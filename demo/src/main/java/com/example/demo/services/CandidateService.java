package com.example.demo.services;

import com.example.demo.dtos.CreateCandidateDTO;
import com.example.demo.entities.Candidate;
import com.example.demo.entities.CandidateAddress;
import com.example.demo.exceptions.UserFoundException;
import com.example.demo.repositories.AddressRepository;
import com.example.demo.repositories.CandidateRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class CandidateService {

    private final CandidateRepository candidateRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;

    public Candidate create(CreateCandidateDTO createCandidateDTO) {
        // Verifica se já existe usuário ou e-mail cadastrado
        Optional<Candidate> existingUser = candidateRepository.findByUsername(createCandidateDTO.username());
        Optional<Candidate> existingEmail = candidateRepository.findByEmail(createCandidateDTO.email());
        if (existingUser.isPresent() || existingEmail.isPresent()) {
            throw new UserFoundException();
        }

        Candidate candidate = new Candidate();

        // Criptografa senha do candidato
        String password = passwordEncoder.encode(createCandidateDTO.password());

        try {
            // Monta URL para consulta de endereço via CEP
            String urlViaCep = "https://viacep.com.br/ws/" + createCandidateDTO.cep() + "/json/";

            // Cria cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Requisição assíncrona para buscar o endereço
            HttpRequest requestViaCep = HttpRequest.newBuilder().uri(URI.create(urlViaCep)).build();
            CompletableFuture<HttpResponse<String>> responseFutureViaCep = client.sendAsync(requestViaCep,
                    HttpResponse.BodyHandlers.ofString());

            // Processa resposta e salva endereço
            CandidateAddress address = responseFutureViaCep.thenApply(HttpResponse::body).thenApply(responseBody -> {
                Gson gson = new Gson();
                return gson.fromJson(responseBody, CandidateAddress.class);
            }).thenApply(addressRepository::save).join();

            // Preenche dados do candidato
            candidate.setPassword(password);
            candidate.setEmail(createCandidateDTO.email());
            candidate.setName(createCandidateDTO.name());
            candidate.setUsername(createCandidateDTO.username());
            candidate.setDescription(createCandidateDTO.description());
            candidate.setCurriculum(createCandidateDTO.curriculum());
            candidate.setCandidateAddress(address);
        } catch (Exception e) {
            // Lança exceção em caso de erro ao buscar por CEP
            throw new RuntimeException("Erro ao buscar por CEP");
        }

        // Salva candidato no banco de dados e retorna
        return candidateRepository.save(candidate);
    }
}

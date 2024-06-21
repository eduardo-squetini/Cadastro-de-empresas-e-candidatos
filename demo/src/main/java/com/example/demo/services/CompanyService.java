package com.example.demo.services;

import com.example.demo.dtos.CreateCompanyDTO;
import com.example.demo.entities.Company;
import com.example.demo.entities.CompanyInfo;
import com.example.demo.exceptions.CompanyFoundException;
import com.example.demo.repositories.CompanyInfoRepository;
import com.example.demo.repositories.CompanyRepository;
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
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyInfoRepository companyInfoRepository;
    private final PasswordEncoder passwordEncoder;

    public Company create(CreateCompanyDTO createCompanyDTO) {
        // Verifica se já existe uma empresa cadastrada com o mesmo e-mail
        Optional<Company> existingEmail = companyRepository.findByEmail(createCompanyDTO.email());
        if (existingEmail.isPresent()) {
            throw new CompanyFoundException();
        }

        Company company = new Company();

        try {
            // Monta URL para consulta de informações da empresa via CNPJ
            String url = "https://brasilapi.com.br/api/cnpj/v1/" + createCompanyDTO.cnpj();

            // Cria cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Requisição assíncrona para buscar informações da empresa
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

            // Processa resposta e salva informações da empresa
            CompanyInfo companyInfo = responseFuture.thenApply(HttpResponse::body).thenApply(responseBody -> {
                Gson gson = new Gson();
                return gson.fromJson(responseBody, CompanyInfo.class);
            }).thenApply(companyInfoRepository::save).join();

            // Preenche dados da empresa
            company.setEmail(createCompanyDTO.email());
            company.setPassword(passwordEncoder.encode(createCompanyDTO.password()));
            company.setDescription(createCompanyDTO.description());
            company.setCompanyInfo(companyInfo);
        } catch (Exception e) {
            // Lança exceção em caso de erro
            throw new RuntimeException(e.getMessage());
        }

        // Salva empresa no banco de dados e retorna
        return companyRepository.save(company);
    }
}
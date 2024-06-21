package com.example.demo.controllers;

import com.example.demo.dtos.CreateCandidateDTO;
import com.example.demo.services.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Define que esta classe é um controlador REST, ou seja, será responsável por receber e responder a requisições HTTP.
@RestController

// Define o mapeamento de requisições para o caminho "/candidates". Todas as requisições dentro desta classe usarão este caminho como base.
@RequestMapping("/candidates")

// Anotação que gera um construtor com argumentos obrigatórios para todas as variáveis finais não inicializadas, facilitando a injeção de dependências.
@RequiredArgsConstructor

// Declaração da classe 'CandidateController'.
public class CandidateController
{
	// Injeta a dependência 'CandidateService' automaticamente. 'CandidateService' é um serviço que contém a lógica de negócios relacionada aos candidatos.
	private final CandidateService candidateService;

	// Mapeia requisições HTTP POST para o caminho raiz ("/") relativo ao mapeamento base definido anteriormente ("/candidates").
	@PostMapping

	// Método que lida com o cadastro de candidato. Recebe um objeto 'CreateCandidateDTO' no corpo da requisição, que deve ser validado.
	public ResponseEntity<Object> create(@Valid @RequestBody CreateCandidateDTO createCandidateDTO)
	{
		try
		{
			// Chama o serviço 'candidateService' para criar um novo candidato utilizando os dados recebidos.
			var result = this.candidateService.create(createCandidateDTO);
			
			// Retorna uma resposta HTTP 200 (OK) com o resultado da criação no corpo da resposta.
			return ResponseEntity.ok().body(result);
		} 
		catch (Exception e)
		{
			// Em caso de exceção, retorna uma resposta HTTP 400 (Bad Request) com a mensagem de erro no corpo da resposta.
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}


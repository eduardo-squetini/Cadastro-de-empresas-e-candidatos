package com.example.demo.controllers;

import com.example.demo.dtos.CreateCompanyDTO;
import com.example.demo.services.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Define que esta classe é um controlador REST, ou seja, será responsável por receber e responder a requisições HTTP.
@RestController

// Define o mapeamento de requisições para o caminho "/companies". Todas as requisições dentro desta classe usarão este caminho como base.
@RequestMapping("/companies")

// Anotação que gera um construtor com argumentos obrigatórios para todas as variáveis finais não inicializadas, facilitando a injeção de dependências.
@RequiredArgsConstructor

// Declaração da classe 'CompanyController'.
public class CompanyController
{
	// Injeta a dependência 'CompanyService' automaticamente. 'CompanyService' é um serviço que contém a lógica de negócios relacionada às empresas.
	private final CompanyService companyService;

	// Mapeia requisições HTTP POST para o caminho raiz ("/") relativo ao mapeamento base definido anteriormente ("/companies").
	@PostMapping

	// Método que lida com o cadastro de uma nova empresa. Recebe um objeto 'CreateCompanyDTO' no corpo da requisição, que deve ser validado.
	public ResponseEntity<Object> create(@Valid @RequestBody CreateCompanyDTO createCompanyDTO)
	{
		try
		{
			// Chama o serviço 'companyService' para criar uma nova empresa utilizando os dados recebidos.
			var result = this.companyService.create(createCompanyDTO);
			
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


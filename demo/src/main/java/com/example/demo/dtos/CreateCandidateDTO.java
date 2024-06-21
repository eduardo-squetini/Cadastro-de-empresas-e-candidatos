package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Define um record chamado 'CreateCandidateDTO' que representa um objeto de transferência de dados (DTO) para criação de um candidato.
public record CreateCandidateDTO(

	// Define que o campo 'name' não pode ser nulo nem vazio.
	@NotNull @NotBlank String name,

	// Define que o campo 'username' não pode ser nulo nem vazio.
	@NotNull @NotBlank String username,

	// Define que o campo 'email' não pode ser nulo nem vazio.
	@NotNull @NotBlank String email,

	// Define que o campo 'password' não pode ser nulo nem vazio.
	@NotNull @NotBlank String password,

	// Define que o campo 'description' não pode ser nulo nem vazio.
	@NotNull @NotBlank String description,

	// Define que o campo 'curriculum' não pode ser nulo nem vazio.
	@NotNull @NotBlank String curriculum,

	// Define que o campo 'cep' não pode ser nulo nem vazio.
	@NotNull @NotBlank String cep
)
{
}


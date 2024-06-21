package com.example.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

// Define um record chamado 'CreateCompanyDTO' que representa um objeto de transferência de dados (DTO) para criação de uma empresa.
public record CreateCompanyDTO(

	// Define que o campo 'email' não pode ser nulo, nem vazio e deve ser um e-mail válido.
	@NotNull @NotBlank @Email String email,

	// Define que o campo 'password' não pode ser nulo, nem vazio e deve ter entre 10 e 100 caracteres.
	@NotNull @NotBlank @Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres") String password,

	// Define que o campo 'description' não pode ser nulo nem vazio.
	@NotNull @NotBlank String description,

	// Define que o campo 'cnpj' não pode ser nulo nem vazio.
	@NotNull @NotBlank String cnpj
)
{
}


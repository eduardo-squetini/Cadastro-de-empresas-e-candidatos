package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

// Anotação que define esta classe como uma entidade JPA com o nome da tabela "company".
@Entity(name = "company")

// Anotação Lombok que gera automaticamente os métodos getter, setter, equals, hashCode e toString.
@Data

// Anotação Lombok que facilita a criação do padrão Builder para a classe, permitindo a construção de objetos de forma fluente.
@Builder

// Anotação Lombok que gera um construtor sem argumentos (construtor padrão).
@NoArgsConstructor

// Anotação Lombok que gera um construtor com todos os argumentos (todas as propriedades da classe).
@AllArgsConstructor

// Declaração da classe 'Company' que representa a entidade 'company' no banco de dados.
public class Company
{
	// Define o campo 'id' como a chave primária da entidade.
	// A geração do valor será automaticamente gerenciada pela estratégia UUID.
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	// Campo que armazena o e-mail da empresa.
	// Deve conter um e-mail válido.
	@Email(message = "O campo [email] deve conter um e-mail válido")
	private String email;

	// Campo que armazena a senha da empresa.
	private String password;

	// Campo que armazena a descrição da empresa.
	private String description;

	// Define uma relação um-para-um com a entidade 'CompanyInfo'.
	// A coluna 'company_info_id' na tabela 'company' referenciará a chave primária na tabela 'company_info'.
	@OneToOne
	@JoinColumn(name = "company_info_id")
	private CompanyInfo companyInfo;

	// Campo que armazena a data e hora de criação do registro.
	// O valor será automaticamente gerado no momento da criação do registro.
	@CreationTimestamp
	private LocalDateTime createdAt;
}

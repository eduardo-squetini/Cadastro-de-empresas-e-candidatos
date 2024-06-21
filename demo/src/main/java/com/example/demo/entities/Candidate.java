package com.example.demo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.UUID;

// Anotação que define esta classe como uma entidade JPA com o nome da tabela "candidate".
@Entity(name = "candidate")

// Anotação Lombok que gera automaticamente os métodos getter, setter, equals, hashCode e toString.
@Data

// Anotação Lombok que facilita a criação do padrão Builder para a classe, permitindo a construção de objetos de forma fluente.
@Builder

// Anotação Lombok que gera um construtor com todos os argumentos (todas as propriedades da classe).
@AllArgsConstructor

// Anotação Lombok que gera um construtor sem argumentos (construtor padrão).
@NoArgsConstructor

// Declaração da classe 'Candidate' que representa a entidade 'candidate' no banco de dados.
public class Candidate
{
	// Define o campo 'id' como a chave primária da entidade. 
	// A geração do valor será automaticamente gerenciada pela estratégia UUID.
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	// Campo que armazena o nome do candidato.
	private String name;

	// Campo que armazena o nome de usuário do candidato.
	// Não pode ser nulo nem vazio e deve conter apenas caracteres sem espaços.
	@NotBlank(message = "O campo [username] é obrigatório")
	@Pattern(regexp = "\\S+", message = "o campo [username] não deve conter espaço")
	private String username;

	// Campo que armazena o e-mail do candidato.
	// Deve conter um e-mail válido.
	@Email(message = "O campo [email] deve conter um e-mail válido")
	private String email;

	// Campo que armazena a senha do candidato.
	// Deve ter entre 10 e 100 caracteres.
	@Length(min = 10, max = 100, message = "A senha deve conter entre 10 e 100 caracteres")
	private String password;

	// Campo que armazena a descrição do candidato.
	private String description;

	// Campo que armazena o currículo do candidato.
	private String curriculum;

	// Campo que armazena a data e hora de criação do registro.
	// O valor será automaticamente gerado no momento da criação do registro.
	@CreationTimestamp
	private LocalDateTime createdAt;

	// Define uma relação muitos-para-um com a entidade 'CandidateAddress'.
	// A coluna 'address_id' na tabela 'candidate' referenciará a chave primária na tabela 'candidate_address'.
	@ManyToOne
	@JoinColumn(name = "address_id")
	private CandidateAddress candidateAddress;
}


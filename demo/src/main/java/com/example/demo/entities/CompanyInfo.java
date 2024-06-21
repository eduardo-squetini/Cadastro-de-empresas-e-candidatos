package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

// Anotação que define esta classe como uma entidade JPA com o nome da tabela "company_info".
@Entity(name = "company_info")

// Anotação Lombok que gera automaticamente os métodos getter, setter, equals, hashCode e toString.
@Data

// Anotação Lombok que gera um construtor com todos os argumentos (todas as propriedades da classe).
@AllArgsConstructor

// Anotação Lombok que gera um construtor sem argumentos (construtor padrão).
@NoArgsConstructor

// Declaração da classe 'CompanyInfo' que representa a entidade 'company_info' no banco de dados.
public class CompanyInfo
{
	// Define o campo 'id' como a chave primária da entidade.
	// A geração do valor será automaticamente gerenciada pela estratégia UUID.
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;

	// Campo que armazena o CNPJ da empresa.
	private String cnpj;

	// Campo que armazena a razão social da empresa.
	private String razao_social;

	// Campo que armazena o nome fantasia da empresa.
	private String nome_fantasia;

	// Campo que armazena a descrição da situação cadastral da empresa.
	private String descricao_situacao_cadastral;

	// Campo que armazena a data da situação cadastral da empresa.
	private String data_situacao_cadastral;

	// Campo que armazena a descrição do tipo de logradouro da empresa.
	private String descricao_tipo_de_logradouro;

	// Campo que armazena o logradouro da empresa.
	private String logradouro;

	// Campo que armazena o número do endereço da empresa.
	private String numero;

	// Campo que armazena o complemento do endereço da empresa.
	private String complemento;

	// Campo que armazena o bairro da empresa.
	private String bairro;

	// Campo que armazena o CEP da empresa.
	private Integer cep;

	// Campo que armazena a unidade federativa (estado) da empresa.
	private String uf;

	// Campo que armazena o município da empresa.
	private String municipio;

	// Campo que armazena o primeiro telefone de contato da empresa.
	private String ddd_telefone_1;
}

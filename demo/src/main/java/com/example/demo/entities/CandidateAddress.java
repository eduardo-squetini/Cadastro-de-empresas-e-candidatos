package com.example.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "candidate_address")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateAddress
{
	// Classe que representa informações de endereço do candidato.
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	// Campo para o ID único do endereço (geralmente um UUID).

	private String cep;

	private String logradouro;
	// Logradouro ou rua.

	private String complemento;
	// Detalhes adicionais do endereço (por exemplo, número do apartamento, andar).

	private String bairro;
	// Bairro.

	private String localidade;
	// Cidade ou localidade.

	private String uf;
	// Sigla do estado (por exemplo, "SP" para São Paulo).

	private String ibge;
	// Código IBGE (Instituto Brasileiro de Geografia e Estatística).

	private String gia;
	// Código GIA (Grupo de Informações de Apoio à Administração).

	private String ddd;
	// Código de área para números de telefone.

	private String siafi;
	// Código SIAFI (Sistema Integrado de Administração Financeira).

	// Outros campos ou métodos relacionados a informações de endereço podem ser adicionados aqui.

	// Normalmente, construtores, getters, setters e outros métodos também seriam incluídos.
}

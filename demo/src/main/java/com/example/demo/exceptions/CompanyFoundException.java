package com.example.demo.exceptions;

// Define uma classe de exceção personalizada que estende RuntimeException.
public class CompanyFoundException extends RuntimeException
{
	// Construtor padrão da exceção.
	// Chama o construtor da superclasse (RuntimeException) com uma mensagem específica.
	public CompanyFoundException()
	{
		super("Empresa já existe");
	}
}


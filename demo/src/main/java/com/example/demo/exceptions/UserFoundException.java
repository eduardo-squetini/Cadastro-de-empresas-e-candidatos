package com.example.demo.exceptions;

// Define uma classe de exceção personalizada que estende RuntimeException.
public class UserFoundException extends RuntimeException
{
	// Construtor padrão da exceção.
	// Chama o construtor da superclasse (RuntimeException) com uma mensagem específica.
	public UserFoundException()
	{
		// Chama o construtor da classe pai ('RuntimeException') passando a mensagem "Usuário já existe".
		super("Usuário já existe");
	}
}


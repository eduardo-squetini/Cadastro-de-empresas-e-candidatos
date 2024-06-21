package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    // Define um filtro de segurança para configurar as regras de autorização
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Desativa a proteção CSRF (Cross-Site Request Forgery)
        http.csrf(csrf -> csrf.disable())
            // Configura as regras de autorização para requisições HTTP
            .authorizeHttpRequests(auth -> {
                // Permite acesso sem autenticação aos endpoints "/candidates" e "/companies"
                auth.requestMatchers("/candidates").permitAll()
                    .requestMatchers("/companies").permitAll();
            });

        // Constrói e retorna o filtro de segurança configurado
        return http.build();
    }

    // Define um bean para fornecer um codificador de senha
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Retorna um BCryptPasswordEncoder para codificar e verificar senhas
        return new BCryptPasswordEncoder();
    }
}

package com.example.demo.repositories;

import com.example.demo.entities.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Indica que esta interface é um repositório Spring para a entidade Candidate
@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
	// Método de consulta para encontrar um Candidato por nome de usuário
	Optional<Candidate> findByUsername(String username);

	// Método de consulta para encontrar um Candidato por endereço de email
	Optional<Candidate> findByEmail(String email);
}

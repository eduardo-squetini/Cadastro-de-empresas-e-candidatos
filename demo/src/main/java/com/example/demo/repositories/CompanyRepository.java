package com.example.demo.repositories;

import com.example.demo.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

// Indica que esta interface é um repositório Spring para a entidade Company
@Repository
public interface CompanyRepository extends JpaRepository<Company, UUID>
{
    // Método de consulta para encontrar uma Company pelo endereço de email
    Optional<Company> findByEmail(String email);
}

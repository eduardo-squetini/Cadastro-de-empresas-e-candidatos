package com.example.demo.repositories;

import com.example.demo.entities.CandidateAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// Anotação que define esta interface como um componente de repositório Spring.
@Repository

// Declaração da interface 'AddressRepository' que estende 'JpaRepository'.
public interface AddressRepository extends JpaRepository<CandidateAddress, UUID>
{
}


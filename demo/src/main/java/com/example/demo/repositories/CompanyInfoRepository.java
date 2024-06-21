package com.example.demo.repositories;

import com.example.demo.entities.CompanyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// Indica que esta interface é um repositório Spring para a entidade CompanyInfo
@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfo, UUID>
{
}

package com.example.medemo.repository;

import com.example.medemo.model.LaboratoryResearchType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryResearchTypeRepository extends JpaRepository<LaboratoryResearchType, Long> {
}

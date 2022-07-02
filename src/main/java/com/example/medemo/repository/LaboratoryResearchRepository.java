package com.example.medemo.repository;

import com.example.medemo.model.LaboratoryResearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaboratoryResearchRepository extends JpaRepository<LaboratoryResearch, Long> {
}

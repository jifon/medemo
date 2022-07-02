package com.example.medemo.repository;

import com.example.medemo.model.Pregnancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PregnancyRepository extends JpaRepository<Pregnancy, Long> {
}

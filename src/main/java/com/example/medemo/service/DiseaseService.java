package com.example.medemo.service;

import com.example.medemo.model.Disease;
import com.example.medemo.repository.DiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseService {

    @Autowired
    private DiseaseRepository repository;

    public List<Disease> getAllDiseases() {
        return repository.findAll();
    }

    public Optional<Disease> findById(long id) {
        return repository.findById(id);
    }

    public Disease save(Disease diseas) {
        return repository.save(diseas);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}

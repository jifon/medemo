package com.example.medemo.service;

import com.example.medemo.model.DiseaseType;
import com.example.medemo.model.Text;
import com.example.medemo.repository.DiseaseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DiseaseTypeService {

    @Autowired
    private DiseaseTypeRepository repository;

    public List<DiseaseType> getAllDiseaseTypes() {
        return repository.findAll();
    }

    public Optional<DiseaseType> findById(long id) {
        return repository.findById(id);
    }

    public DiseaseType save(DiseaseType diseaseType) {
        return repository.save(diseaseType);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}

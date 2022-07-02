package com.example.medemo.service;

import com.example.medemo.model.Anamnesis;
import com.example.medemo.model.Text;
import com.example.medemo.repository.AnamnesisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnamnesisService {

    @Autowired
    private AnamnesisRepository repository;

    public List<Anamnesis> getAllAnamnesis() {
        return repository.findAll();
    }

    public Optional<Anamnesis> findById(long id) {
        return repository.findById(id);
    }

    public Anamnesis save(Anamnesis anamnesis) {
        return repository.save(anamnesis);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}

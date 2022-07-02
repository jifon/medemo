package com.example.medemo.service;

import com.example.medemo.model.Pregnancy;
import com.example.medemo.repository.PregnancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PregnancyService {

    @Autowired
    private PregnancyRepository pregnancyRepository;

    public List<Pregnancy> getAllPregnancies() {
        return pregnancyRepository.findAll();
    }

    public Optional<Pregnancy> findById(long id) {
        return pregnancyRepository.findById(id);
    }

    public Pregnancy save(Pregnancy pregnancy) {
        return pregnancyRepository.save(pregnancy);
    }

    public void delete(long id) {
        pregnancyRepository.deleteById(id);
    }

}

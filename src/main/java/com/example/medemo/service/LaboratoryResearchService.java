package com.example.medemo.service;

import com.example.medemo.model.LaboratoryResearch;
import com.example.medemo.model.Text;
import com.example.medemo.repository.LaboratoryResearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryResearchService {


    @Autowired
    private LaboratoryResearchRepository researchRepository;

    public List<LaboratoryResearch> getAllLaboratoryResearches() {
        return researchRepository.findAll();
    }

    public Optional<LaboratoryResearch> findById(long id) {
        return researchRepository.findById(id);
    }

    public LaboratoryResearch save(LaboratoryResearch laboratoryResearch) {
        return researchRepository.save(laboratoryResearch);
    }

    public void delete(long id) {
        researchRepository.deleteById(id);
    }

}

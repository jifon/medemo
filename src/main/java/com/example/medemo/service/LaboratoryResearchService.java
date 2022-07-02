package com.example.medemo.service;

import com.example.medemo.dto.LaboratoryResearchDto;
import com.example.medemo.dto.LaboratoryResearchTypeDto;
import com.example.medemo.mapper.LaboratoryResearchMapper;
import com.example.medemo.mapper.LaboratoryResearchTypeMapper;
import com.example.medemo.model.LaboratoryResearch;
import com.example.medemo.model.LaboratoryResearchType;
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

    public List<LaboratoryResearchDto> getAllLaboratoryResearches() {
        List<LaboratoryResearch> list = researchRepository.findAll();
        List<LaboratoryResearchDto> listDto = null;
        for(LaboratoryResearch entity : list ){
            listDto.add(LaboratoryResearchMapper.EntityToDto(entity));
        }
        return listDto;
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

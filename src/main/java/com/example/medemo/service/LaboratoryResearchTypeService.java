package com.example.medemo.service;

import com.example.medemo.dto.LaboratoryResearchTypeDto;
import com.example.medemo.dto.PregnancyDto;
import com.example.medemo.mapper.LaboratoryResearchTypeMapper;
import com.example.medemo.mapper.PregnancyMapper;
import com.example.medemo.model.LaboratoryResearchType;
import com.example.medemo.model.Pregnancy;
import com.example.medemo.model.Text;
import com.example.medemo.repository.LaboratoryResearchTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LaboratoryResearchTypeService {

    @Autowired
    private LaboratoryResearchTypeRepository repository;

    public List<LaboratoryResearchTypeDto> getAllLaboratoryResearchTypes() {
        List<LaboratoryResearchType> list = repository.findAll();
        List<LaboratoryResearchTypeDto> listDto = null;
        for(LaboratoryResearchType entity : list ){
            listDto.add(LaboratoryResearchTypeMapper.EntityToDto(entity));
        }
        return listDto;
    }

    public Optional<LaboratoryResearchType> findById(long id) {
        return repository.findById(id);
    }

    public LaboratoryResearchType save(LaboratoryResearchType laboratoryResearchType) {
        return repository.save(laboratoryResearchType);
    }

    public void delete(long id) {
        repository.deleteById(id);
    }

}

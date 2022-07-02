package com.example.medemo.mapper;

import com.example.medemo.dto.LaboratoryResearchDto;
import com.example.medemo.dto.QuestionDto;
import com.example.medemo.model.LaboratoryResearch;
import com.example.medemo.model.Question;

public class LaboratoryResearchMapper {

    public static LaboratoryResearch DtoToEntity(LaboratoryResearchDto dto) {

        LaboratoryResearch entity = new LaboratoryResearch();
        entity.setLaboratoryResearch(dto.getLaboratoryResearch());
        entity.setResult(dto.getResult());
        entity.setDate(dto.getDate());
        entity.setPregnancy(dto.getPregnancy());

        return entity;
    }
    public static LaboratoryResearchDto EntityToDto(LaboratoryResearch entity) {

        LaboratoryResearchDto dto = new LaboratoryResearchDto();
        dto.setLaboratoryResearch(entity.getLaboratoryResearch());
        dto.setResult(entity.getResult());
        entity.setDate(dto.getDate());
        entity.setPregnancy(dto.getPregnancy());

        return dto;
    }
}

package com.example.medemo.mapper;

import com.example.medemo.dto.LaboratoryResearchTypeDto;
import com.example.medemo.model.LaboratoryResearchType;

public class LaboratoryResearchTypeMapper {
    public static LaboratoryResearchType DtoToEntity(LaboratoryResearchTypeDto dto) {

        LaboratoryResearchType entity = new LaboratoryResearchType();
        entity.setName(dto.getName());
        entity.setLaboratoryResearches(dto.getLaboratoryResearches());
        return entity;
    }
    public static LaboratoryResearchTypeDto EntityToDto(LaboratoryResearchType entity) {

        LaboratoryResearchTypeDto dto = new LaboratoryResearchTypeDto();
        dto.setName(entity.getName());
        dto.setLaboratoryResearches(entity.getLaboratoryResearches());
        return dto;
    }
}

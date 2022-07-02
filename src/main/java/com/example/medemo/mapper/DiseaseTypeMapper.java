package com.example.medemo.mapper;

import com.example.medemo.dto.DiseaseTypeDto;
import com.example.medemo.model.DiseaseType;

public class DiseaseTypeMapper {
    public static DiseaseType DtoToEntity(DiseaseTypeDto dto) {

        DiseaseType entity = new DiseaseType();
        entity.setName(dto.getName());
        entity.setDiseas(dto.getDiseas());
        return entity;
    }
    public static DiseaseTypeDto EntityToDto(DiseaseType entity) {

        DiseaseTypeDto dto = new DiseaseTypeDto();
        dto.setName(entity.getName());
        dto.setDiseas(entity.getDiseas());
        return dto;
    }
}

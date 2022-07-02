package com.example.medemo.mapper;

import com.example.medemo.dto.DiseaseDto;
import com.example.medemo.model.Disease;

public class DiseaseMapper {

    public static Disease DtoToEntity(DiseaseDto dto) {

        Disease entity = new Disease();
        entity.setName(dto.getName());
        entity.setAnamnesis(dto.getAnamnesis());
        entity.setDisease_type(dto.getDisease_type());

        return entity;
    }
    public static DiseaseDto EntityToDto(Disease entity) {

        DiseaseDto dto = new DiseaseDto();
        dto.setName(entity.getName());
        dto.setAnamnesis(entity.getAnamnesis());
        entity.setDisease_type(dto.getDisease_type());

        return dto;
    }

}

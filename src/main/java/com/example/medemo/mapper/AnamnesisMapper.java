package com.example.medemo.mapper;

import com.example.medemo.dto.AnamnesisDto;
import com.example.medemo.dto.TextDto;
import com.example.medemo.model.Anamnesis;
import com.example.medemo.model.Text;

public class AnamnesisMapper {
    public static Anamnesis DtoToEntity(AnamnesisDto dto) {

        Anamnesis entity = new Anamnesis();
        entity.setDiseas(dto.getDiseas());
        entity.setPregnancy(dto.getPregnancy());
        return entity;
    }
    public static AnamnesisDto EntityToDto(Anamnesis entity) {

        AnamnesisDto dto = new AnamnesisDto();
        dto.setDiseas(entity.getDiseas());
        dto.setPregnancy(entity.getPregnancy());
        return dto;
    }
}

package com.example.medemo.mapper;

import com.example.medemo.dto.TextDto;
import com.example.medemo.model.Text;

public class TextMapper {

    public static Text DtoToEntity(TextDto dto) {

        Text entity = new Text();
        entity.setText_value(dto.getText_value());
        entity.setContent(dto.getContent());
        return entity;
    }
    public static TextDto EntityToDto(Text entity) {

        TextDto dto = new TextDto();
        dto.setText_value(entity.getText_value());
        dto.setContent(entity.getContent());
        return dto;
    }
}

package com.example.medemo.mapper;

import com.example.medemo.dto.ContentDto;
import com.example.medemo.dto.TextDto;
import com.example.medemo.model.Content;
import com.example.medemo.model.Text;

public class ContentMapper {

    public static Content DtoToEntity(ContentDto dto) {

        Content entity = new Content();
        entity.setContent_name(dto.getContent_name());
        entity.setTexts(dto.getTexts());
        return entity;
    }
    public static ContentDto EntityToDto(Content entity) {

        ContentDto dto = new ContentDto();
        dto.setContent_name(entity.getContent_name());
        dto.setTexts(entity.getTexts());
        return dto;
    }
}

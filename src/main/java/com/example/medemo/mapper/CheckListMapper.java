package com.example.medemo.mapper;

import com.example.medemo.dto.CheckListDto;
import com.example.medemo.dto.TextDto;
import com.example.medemo.model.CheckList;
import com.example.medemo.model.Text;

public class CheckListMapper {
    public static CheckList DtoToEntity(CheckListDto dto) {

        CheckList entity = new CheckList();
        entity.setPatient(dto.getPatient());
        entity.setDoctor(dto.getDoctor());
        entity.setTime(dto.getTime());
        entity.setDate(dto.getDate());
        entity.setAnswers(dto.getAnswers());
        return entity;
    }
    public static CheckListDto EntityToDto(CheckList entity) {

        CheckListDto dto = new CheckListDto();
        dto.setPatient(entity.getPatient());
        dto.setDoctor(entity.getDoctor());
        entity.setTime(dto.getTime());
        entity.setDate(dto.getDate());
        entity.setAnswers(dto.getAnswers());
        return dto;
    }
}

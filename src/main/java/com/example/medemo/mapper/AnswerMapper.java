package com.example.medemo.mapper;

import com.example.medemo.dto.AnswerDto;
import com.example.medemo.model.Answer;

public class AnswerMapper {

    public static Answer DtoToEntity(AnswerDto dto) {

        Answer entity = new Answer();
        entity.setQuest(dto.getQuest());
        entity.setAnswer(dto.getAnswer());
        entity.setCommentary(dto.getCommentary());
        entity.setCheckList(dto.getCheckList());
        return entity;
    }
    public static AnswerDto EntityToDto(Answer entity) {

        AnswerDto dto = new AnswerDto();
        dto.setQuest(entity.getQuest());
        dto.setAnswer(entity.getAnswer());
        dto.setCommentary(entity.getCommentary());
        dto.setCheckList(entity.getCheckList());
        return dto;
    }

}

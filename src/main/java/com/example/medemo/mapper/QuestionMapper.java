package com.example.medemo.mapper;

import com.example.medemo.dto.QuestionDto;
import com.example.medemo.model.Question;

public class QuestionMapper {

    public static Question DtoToEntity(QuestionDto dto) {

        Question entity = new Question();

        entity.setQuestion(dto.getQuestion());
        entity.setAnswers(dto.getAnswers());

        return entity;
    }
    public static QuestionDto EntityToDto(Question entity) {

        QuestionDto dto = new QuestionDto();

        dto.setQuestion(entity.getQuestion());
        dto.setAnswers(entity.getAnswers());

        return dto;
    }
}

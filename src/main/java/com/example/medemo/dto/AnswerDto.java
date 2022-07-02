package com.example.medemo.dto;

import com.example.medemo.model.CheckList;
import com.example.medemo.model.Question;
import lombok.Data;

import javax.persistence.*;

@Data
public class AnswerDto {

//    private Long id;
    private Question quest;
    private String answer;
    private String commentary;
    private CheckList checkList;

}

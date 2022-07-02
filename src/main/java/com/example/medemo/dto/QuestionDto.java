package com.example.medemo.dto;

import com.example.medemo.model.Answer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class QuestionDto {

//    private Long id;
    private String question;
    private Set<Answer> answers;
}

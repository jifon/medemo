package com.example.medemo.dto;

import com.example.medemo.model.Text;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
public class ContentDto {

//    private Long id;
    private String content_name;
    private Set<Text> texts;


}

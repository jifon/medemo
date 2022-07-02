package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "questions")
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name ="question",nullable = false)
    private String question;

    @OneToMany(mappedBy="quest")
    private Set<Answer> answers;
}

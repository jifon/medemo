package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "answers")
@Getter
@Setter
public class Answer {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private Question quest;

    @Column(name = "answer",nullable = false)
    private String answer;
    @Column(name = "commentary",nullable = false)
    private String commentary;

    @ManyToOne
    @JoinColumn(name = "checklist_id", nullable = false)
    private CheckList checkList;

}

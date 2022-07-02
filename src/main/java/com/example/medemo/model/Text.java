package com.example.medemo.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "texts")
@Getter
@Setter
public class Text {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "text_value")
    private String text_value;

    @ManyToOne
    @JoinColumn(name = "content_id", nullable = false)
    private Content content;


}

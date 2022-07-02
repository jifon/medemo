package com.example.medemo.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "content")
@Getter
@Setter
public class Content {
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name = "content_name")
    private String content_name;

    @OneToMany(mappedBy="content")
    private Set<Text> texts;


}

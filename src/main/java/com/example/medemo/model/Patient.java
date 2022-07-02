package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {

    @Id
    @GeneratedValue
    @Column
    private Long id;

    @Column(name ="age",nullable = false)
    private int age;
    @Column(name ="citizenship",nullable = false)
    private String citizenship;
    @Column(name ="pin",nullable = false)
    private int PIN;
    @Column(name ="insurance_territory",nullable = false)
    private String insurance_territory;
    @Column(name ="image",nullable = false)
    private String image;
    @Column(name ="category",nullable = false)
    private String category;
    @Column(name ="workplace",nullable = false)
    private String workplace;
    @Column(name ="position",nullable = false)
    private String position;
    @Column(name ="phone_number",nullable = false)
    private int phone_number;
    @Column(name ="husband_phone_number",nullable = false)
    private int husband_phone_number;
    @Column(name ="husband_workplace",nullable = false)
    private String husband_workplace;
    @Column(name ="husband_position",nullable = false)
    private String husband_position;
    @Column(name ="marital_status",nullable = false)
    private String marital_status;
    @Column(name ="education",nullable = false)
    private String education;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy="patient")
    private Set<Pregnancy> pregnancies;



}

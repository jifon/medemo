package com.example.medemo.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
@Getter
@Setter
@Entity(name = "addresses")
public class Address {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column(name = "city",nullable = false)
    private String city;
    @Column(name = "village",nullable = false)
    private String village;
    @Column(name = "street_name",nullable = false)
    private String street_name;
    @Column(name = "house_number",nullable = false)
    private int house_number;
    @Column(name = "phone_number",nullable = false)
    private int phone_number;
    @Column(name = "relative_city",nullable = false)
    private String relative_city;
    @Column(name = "relative_village",nullable = false)
    private String relative_village;
    @Column(name = "relative_house_number",nullable = false)
    private int relative_house_number;
    @Column(name = "relative_phone_number",nullable = false)
    private int relative_phone_number;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    private Patient patient;
}

package com.example.medemo.model;

import com.example.medemo.model.constants.Role;
import lombok.*;
import com.example.medemo.model.constants.Status;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name ="phone_number",nullable = false)
    private String phoneNumber;
    @Column(name = "password")
    private String password;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @JoinColumn(name  = "role",nullable = false)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @Column(name = "otp_active" ,columnDefinition = "boolean default true" )
    private boolean otpActive;
    @Column(name = "psw_reset_code")
    private String pswResetCode;
    @Column(name ="first_name",nullable = false)
    private String firstName;
    @Column(name ="last_name",nullable = false)
    private String lastName;
    @Column(name ="middle_name",nullable = false)
    private String middle_name;




}


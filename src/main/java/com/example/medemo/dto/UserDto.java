package com.example.medemo.dto;
import com.example.medemo.model.constants.Role;
import ch.qos.logback.core.status.Status;
import lombok.Data;

@Data
public class UserDto {

    private Long id;
    private String phoneNumber;
    private String password;
    private String email;
    private Role role;
    private Status status;
    private boolean otpActive;
    private String pswResetCode;
    private String firstName;
    private String lastName;
    private String middle_name;

}

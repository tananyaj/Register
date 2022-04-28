package com.krungsri.register.model;

import lombok.Data;

import javax.persistence.Column;

@Data
public class AddUserRequest {
    private String cid;
    private String title;
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private String birthDate;
    private int salary;
}

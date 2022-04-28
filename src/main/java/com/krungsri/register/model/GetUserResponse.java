package com.krungsri.register.model;

import lombok.Data;

@Data
public class GetUserResponse {
    private int id;
    private String cid;
    private String title;
    private String firstName;
    private String lastName;
    private String mobile;
    private String gender;
    private String birthDate;
    private int salary;
    private String memberType;
    private String referenceCode;
    private String isDeleted;
    private String createdBy;
    private String createdDate;
    private String updatedDate;
    private String updatedBy;
}

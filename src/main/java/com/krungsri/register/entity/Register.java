package com.krungsri.register.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Register")
@Data
public class Register {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "CITIZEN_ID")
    private String citizenId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MOBILE")
    private String mobile;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @Column(name = "SALARY")
    private Integer salary;

    @Column(name = "MEMBER_TYPE")
    private String memberType;

    @Column(name = "REFERENCE_CODE")
    private String referenceCode;

    @Column(name = "IS_DELETED")
    private String isDeleted;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private String createdDate;

    @Column(name = "UPDATED_DATE")
    private String updatedDate;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

}

package com.krungsri.register.model;

import lombok.Data;

@Data
public class GetUserRequest {
    private String firstName;
    private String lastName;
    private String cid;
}

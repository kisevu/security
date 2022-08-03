package com.ameda.kevin.client.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentModel {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
}

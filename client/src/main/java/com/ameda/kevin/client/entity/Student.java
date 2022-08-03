package com.ameda.kevin.client.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String password;
    private boolean enabled=false;
    private String role;
}

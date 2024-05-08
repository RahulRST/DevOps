package com.rahul.devops.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "auth")
public class Auth {
    @Id
    private String username;
    private String password;
}
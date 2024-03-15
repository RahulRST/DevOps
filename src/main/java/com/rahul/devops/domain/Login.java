package com.rahul.devops.domain;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "login")
public class Login {
    @Id
    private String username;
    @Nonnull
    private String password;
    
    public Login() {
        
    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
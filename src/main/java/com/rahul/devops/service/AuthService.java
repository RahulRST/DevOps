package com.rahul.devops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.devops.domain.Auth;
import com.rahul.devops.repository.AuthRepository;

@Service
public class AuthService {

    @Autowired
    AuthRepository authRepository;

    public String handleLogin(Auth login) {
        Auth found = authRepository.findByUsernameAndPassword(login.getUsername(),login.getPassword());
        if(found != null) {
            return found.getUsername();
        }
        return "Invalid username or password";
    }

    public String handleRegister(Auth login) {
        Auth registered = authRepository.save(login);
        if(registered != null) {
            return "Registered successfully";
        };
        return "Error in Registration";
    }
}

package com.rahul.devops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rahul.devops.domain.Login;
import com.rahul.devops.repository.LoginRepository;

@Service
public class AuthService {

    @Autowired
    LoginRepository loginRepository;

    public String handleLogin(Login login) {
        Login found = loginRepository.findByUsernameAndPassword(login.getUsername(),login.getPassword());
        if(found != null) {
            return found.getUsername();
        }
        return "Invalid username or password";
    }

    public String handleRegister(Login login) {
        Login registered = loginRepository.save(login);
        if(registered != null) {
            return "Registered successfully";
        };
        return "Error in Registration";
    }
}

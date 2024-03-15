package com.rahul.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rahul.devops.domain.Login;
import com.rahul.devops.service.LoginService;

@Controller
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/")
    public String home(Model model) {
        return "login";
    }

    @PostMapping("/log")
    public ResponseEntity<String> Login(Login entity) {  
        return ResponseEntity.ok("Welcome \n"+loginService.handleLogin(entity));
    }
    
}
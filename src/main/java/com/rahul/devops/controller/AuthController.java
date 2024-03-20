package com.rahul.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rahul.devops.domain.Login;
import com.rahul.devops.service.AuthService;

@Controller
public class AuthController {

    @Autowired
    AuthService authService;

    @GetMapping("/")
    public String home(Model model) {
        return "login";
    }

    @GetMapping("/reg")
    public String Reg(Model model) {
        return "register";
    }

    @PostMapping("/login")
    public ResponseEntity<String> Login(Login entity) {  
        return ResponseEntity.ok("Welcome \n"+authService.handleLogin(entity));
    }

    @PostMapping("/register")
    public String Register(Login entity) {
        authService.handleRegister(entity);
        return "redirect:/";
    }
}
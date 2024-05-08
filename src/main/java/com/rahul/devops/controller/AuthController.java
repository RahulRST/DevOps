package com.rahul.devops.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rahul.devops.domain.Auth;
import com.rahul.devops.service.AuthService;

@Controller
public class AuthController {

    String username = "";

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

    @GetMapping("/home")
    public String Home(Model model) {
        model.addAttribute("username", username);
        return "home";
    }

    @PostMapping("/login")
    public String Login(Auth entity, Model model) {  
        String username = authService.handleLogin(entity);
        if(username.equals("Invalid username or password")) {
            return "redirect:/";
        } else {
            this.username = username;
            return "redirect:/home";
        }
    }

    @PostMapping("/register")
    public String Register(Auth entity) {
        authService.handleRegister(entity);
        return "redirect:/";
    }
}
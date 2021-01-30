package com.example.OnlineBankingSystemAPJ2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/login")
    public String LoginPage() {
        return "login-page";
    }

}

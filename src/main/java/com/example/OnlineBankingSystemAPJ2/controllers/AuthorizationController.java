package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class AuthorizationController {
    @Autowired
    private final UserService userService;

    public AuthorizationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String LoginPage() {
        return "login-page";
    }

    @PostMapping("/password")
    public ResponseEntity<?> changePassword(Principal principal,@RequestBody  @RequestParam(name = "new-password")String password){
        userService.changePassword(principal.getName(),password);
        return ResponseEntity.ok("Password successfully changed to"+password);
    }

}

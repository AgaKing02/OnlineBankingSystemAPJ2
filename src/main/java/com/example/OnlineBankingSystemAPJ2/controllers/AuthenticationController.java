package com.example.OnlineBankingSystemAPJ2.controllers;

import com.example.OnlineBankingSystemAPJ2.models.Consumer;
import com.example.OnlineBankingSystemAPJ2.models.User;
import com.example.OnlineBankingSystemAPJ2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final UserService userService;

    @Autowired
    public AuthenticationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/sign/up")
    public String signUpPage() {
        return "signup-page";
    }

    @PostMapping("/sign/up")
    public String signUp(Model model,
                         @RequestParam(name = "txtUsername") String txtUsername,
                         @RequestParam(name = "txtPassword") String txtPassword,
                         @RequestParam(name ="txtName") String txtName,
                         @RequestParam(name ="txtSurname") String txtSurname) {
        Consumer consumer = new Consumer(txtUsername,txtPassword,txtName,txtSurname);
        User user = new User(consumer);
        user.setPassword(passwordEncoder.encode(consumer.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }
}

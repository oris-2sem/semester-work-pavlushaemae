package com.example.dragi.controllers;

import com.example.dragi.models.User;
import com.example.dragi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


public interface RegistrationController {

    @GetMapping("/registration")
    String registration();

    @PostMapping("/registration")
    String createUser(User user, Model model);
}

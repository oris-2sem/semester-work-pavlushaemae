package com.example.dragi.controllers;

import com.example.dragi.models.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

public interface UserController {

    @GetMapping("/user/{user}")
    String userInfo(@PathVariable("user") User user, Model model);

    @PostMapping("/user/seller")
    String setSeller(Principal principal);

    @GetMapping("/profile")
    String profile(Principal principal, Model model);
}

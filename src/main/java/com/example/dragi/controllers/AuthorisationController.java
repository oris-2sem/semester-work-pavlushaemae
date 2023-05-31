package com.example.dragi.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public interface AuthorisationController {

    @GetMapping("/login")
    String products();

}

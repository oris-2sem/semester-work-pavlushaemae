package com.example.dragi.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@RequestMapping("/basket")
public interface BasketController {

    @GetMapping
    String productInfo(Principal principal, Model model);

    @PostMapping("/add/{id}")
    String addToBasket(@PathVariable("id") Long id, Principal principal);

    @PostMapping("/delete")
    String deleteBasket(Principal principal);

    @PostMapping("/order")
    String createOrder(Principal principal);
}

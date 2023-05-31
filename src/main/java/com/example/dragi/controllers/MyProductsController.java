package com.example.dragi.controllers;

import com.example.dragi.models.User;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

public interface MyProductsController {

    @GetMapping("/product/my-products")
    String myProducts(Model model, Principal principal);

    @PostMapping("/product/delete/{id}")
    String deleteProduct(@PathVariable long id);
}

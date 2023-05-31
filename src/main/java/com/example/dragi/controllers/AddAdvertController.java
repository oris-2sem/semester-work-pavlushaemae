package com.example.dragi.controllers;

import com.example.dragi.models.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Part;
import java.security.Principal;

@RequestMapping("/product/create")
public interface AddAdvertController {

    @GetMapping
    String createProduct();

    @PostMapping
    String createProduct(
            @RequestParam("file1") Part file1,
            @RequestParam("file2") Part file2,
            @RequestParam("file3") Part file3,
            Product product,
            Principal principal
    );
}

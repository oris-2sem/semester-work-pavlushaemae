package com.example.dragi.controllers;

import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Part;
import java.security.Principal;
import java.util.List;

public interface ProductsController {

    @GetMapping("/")
    String products(
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "category", required = false) String category,
            Model model,
            Principal principal
    );
}

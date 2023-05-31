package com.example.dragi.controllers;

import com.example.dragi.dto.request.review.ReviewRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

public interface ProductController {

    @GetMapping("/product/{id}")
    String productInfo(@PathVariable long id, Model model, Principal principal);

    @PostMapping("/review/create/{id}")
    String createReview(
            @PathVariable("id") Long productId,
            ReviewRequest review,
            Principal principal
    );
}

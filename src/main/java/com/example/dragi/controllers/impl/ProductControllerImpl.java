package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.ProductController;
import com.example.dragi.dto.request.review.ReviewRequest;
import com.example.dragi.dto.response.review.ReviewResponse;
import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import com.example.dragi.services.ProductService;
import com.example.dragi.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;

    private final ReviewService reviewService;

    @Override
    public String productInfo(long id, Model model, Principal principal) {
        Product product = productService.getProductById(id);
        User user = productService.getUserByPrincipal(principal);
        List<ReviewResponse> reviews = reviewService.getReviewsOfProduct(product.getId());
        model.addAttribute("product", product);
        model.addAttribute("images", product.getImages());
        model.addAttribute("reviews", reviews);
        List<String> roles = user.getRoles().stream().map(Enum::name).toList();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "product";
    }

    @Override
    public String createReview(
            Long productId,
            ReviewRequest review,
            Principal principal
    ) {
        review.setProductId(productId);
        review.setUserId(productService.getUserByPrincipal(principal).getId());
        reviewService.saveReview(review);
        return "redirect:/product/{id}";
    }
}

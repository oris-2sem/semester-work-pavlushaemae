package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.ProductsController;
import com.example.dragi.models.User;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class ProductsControllerImpl implements ProductsController {
    private final ProductService productService;

    @Override
    public String products(
            String title,
            String sort,
            String category,
            Model model,
            Principal principal
    ) {
        if (sort != null && !sort.equals("")) {
            model.addAttribute("products", productService.getProductsByTitle(title, sort));
        } else if (category != null && !category.equals("")) {
            model.addAttribute("products", productService.getProductsWithCategory(category));
        } else {
            model.addAttribute("products", productService.getProductsByTitle(title));
        }
        User user = productService.getUserByPrincipal(principal);
        List<String> roles = user.getRoles().stream().map(Enum::name).toList();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "products";
    }
}

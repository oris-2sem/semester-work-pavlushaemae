package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.MyProductsController;
import com.example.dragi.models.User;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MyProductsControllerImpl implements MyProductsController {
    private final ProductService productService;

    @Override
    public String myProducts(Model model, Principal principal) {
        User user = productService.getUserByPrincipal(principal);
        model.addAttribute("products", productService.getProductsByUser(user));
        return "my-products";
    }

    @Override
    public String deleteProduct(long id) {
        productService.deleteProduct(id);
        return "redirect:/";
    }
}

package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.AddAdvertController;
import com.example.dragi.models.Product;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import javax.servlet.http.Part;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class AddAdvertControllerImpl implements AddAdvertController {

    private final ProductService productService;

    @Override
    public String createProduct() {
        return "product-create";
    }

    @Override
    public String createProduct(
            Part file1,
            Part file2,
            Part file3,
            Product product,
            Principal principal
    ) {
        productService.saveProduct(principal, product, file1, file2, file3);
        return "redirect:/product/my-products";
    }
}

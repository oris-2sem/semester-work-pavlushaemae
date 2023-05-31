package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.EditProductController;
import com.example.dragi.models.Product;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
@RequiredArgsConstructor
public class EditProductControllerImpl implements EditProductController {
    private final ProductService productService;

    @Override
    public String edit(Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "edit";
    }

    @Override
    public String delete(Long id) {
        productService.deleteProduct(id);
        return "redirect:/product/my-products";
    }

    @Override
    public String edit(Product product, Long id) {
        product.setId(id);
        productService.updateProduct(product);
        return "redirect:/product/my-products";
    }
}

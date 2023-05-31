package com.example.dragi.controllers;

import com.example.dragi.models.Product;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/product")
public interface EditProductController {

    @GetMapping("/edit/{id}")
    String edit(@PathVariable Long id, Model model);

    @PostMapping("/delete")
    String delete(@RequestParam("productId") Long id);

    @PostMapping("/edit")
    String edit(Product product, @RequestParam("id") Long id);
}

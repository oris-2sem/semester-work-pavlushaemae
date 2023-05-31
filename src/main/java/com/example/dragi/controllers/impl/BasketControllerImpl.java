package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.BasketController;
import com.example.dragi.dto.request.order.OrderRequest;
import com.example.dragi.models.Product;
import com.example.dragi.models.User;
import com.example.dragi.services.OrderService;
import com.example.dragi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class BasketControllerImpl implements BasketController {

    private final ProductService productService;
    private final OrderService orderService;

    @Override
    public String productInfo(Principal principal, Model model) {
        User user = productService.getUserByPrincipal(principal);
        List<String> roles = user.getRoles().stream().map(Enum::name).toList();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        List<Product> products = productService.getBasketOfUser(user);
        model.addAttribute("products", products);
        return "basket";
    }

    @Override
    public String addToBasket(Long id, Principal principal) {
        User user = productService.getUserByPrincipal(principal);
        productService.addProductToBasketOfUser(user, id);
        return "redirect:/basket";
    }

    @Override
    public String deleteBasket(Principal principal) {
        User user = productService.getUserByPrincipal(principal);
        productService.deleteBasketOfUser(user);
        return "redirect:/";
    }

    @Override
    public String createOrder(Principal principal) {
        User user = productService.getUserByPrincipal(principal);
        orderService.createNewOrder(new OrderRequest(user, productService.getBasketOfUser(user)));
        productService.deleteBasketOfUser(user);
        return "redirect:/profile";
    }
}

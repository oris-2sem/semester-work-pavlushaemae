package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.UserController;
import com.example.dragi.models.User;
import com.example.dragi.services.OrderService;
import com.example.dragi.services.UserService;
import com.example.dragi.services.impl.CustomUserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final CustomUserDetailsServiceImpl userDetailsService;
    private final OrderService orderService;

    @Override
    public String userInfo(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("products", user.getProducts());
        return "user-info";
    }

    @Override
    public String setSeller(Principal principal) {
        User user = userService.getUserByPrincipal(principal);
        userService.setSeller(user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UserDetails updatedUserDetails = userDetailsService.loadUserByUsername(userDetails.getUsername());
        Authentication newAuthentication = new UsernamePasswordAuthenticationToken(updatedUserDetails, authentication.getCredentials(), updatedUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(newAuthentication);

        return "redirect:/";
    }

    @Override
    public String profile(Principal principal,
                          Model model) {
        User user = userService.getUserByPrincipal(principal);
        List<String> roles = user.getRoles().stream().map(Enum::name).toList();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        model.addAttribute("orders", orderService.getListOfOrdersOfUser(user));
        return "profile";
    }
}

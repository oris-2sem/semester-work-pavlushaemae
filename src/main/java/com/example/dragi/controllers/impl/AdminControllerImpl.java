package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.AdminController;
import com.example.dragi.models.User;
import com.example.dragi.models.enums.Role;
import com.example.dragi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class AdminControllerImpl implements AdminController {
    private final UserService userService;

    @Override
    public String admin(Model model) {
        model.addAttribute("users", userService.list());
        return "admin";
    }

    @Override
    public String userBan(Long id) {
        userService.banUser(id);
        return "redirect:/admin";
    }

    @Override
    public String userEdit(User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        return "user-edit";
    }

    @Override
    public String userEdit(User user, Map<String, String> form) {
        userService.changeUserRoles(user, form);
        return "redirect:/admin";
    }
}

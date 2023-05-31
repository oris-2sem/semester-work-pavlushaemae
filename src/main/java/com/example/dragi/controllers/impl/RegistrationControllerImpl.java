package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.RegistrationController;
import com.example.dragi.models.User;
import com.example.dragi.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationControllerImpl implements RegistrationController {
    private final UserService userService;

    @Override
    public String registration() {
        return "registration";
    }

    @Override
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            model.addAttribute("errorMessage", "Email: " + user.getEmail() + " недопустим.");
            return "registration";
        }
        return "redirect:/login";
    }
}

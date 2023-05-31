package com.example.dragi.controllers;

import com.example.dragi.models.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/admin")
public interface AdminController {

    @GetMapping
    String admin(Model model);

    @PostMapping("/user/ban/{id}")
    String userBan(@PathVariable("id") Long id);

    @GetMapping("/user/edit/{user}")
    String userEdit(@PathVariable("user") User user, Model model);

    @PostMapping("/user/edit")
    String userEdit(@RequestParam("userId") User user, @RequestParam Map<String, String> form);
}

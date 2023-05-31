package com.example.dragi.controllers.impl;

import com.example.dragi.controllers.AuthorisationController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class AuthorisationControllerImpl implements AuthorisationController {

    @Override
    public String products() {
        return "login";
    }

}

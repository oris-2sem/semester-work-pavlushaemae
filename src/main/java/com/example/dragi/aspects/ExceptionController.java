package com.example.dragi.aspects;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/error")
public class ExceptionController implements ErrorController {

    @GetMapping
    public String handleMessage(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Exception error = (Exception) request.getAttribute(RequestDispatcher.ERROR_EXCEPTION);
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            model.addAttribute("code", statusCode);

        }
        if (error != null) {
            model.addAttribute("message", error.getMessage());
        }
        return "error-page";
    }
}

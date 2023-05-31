package com.example.dragi.aspects;

import com.example.dragi.dto.request.ExceptionDto;
import com.example.dragi.exceptions.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static java.rmi.server.LogStream.log;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ExceptionDto.builder()
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .build());
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception exception, Model model) {
        log.error(exception.getMessage());
        model.addAttribute("code", SERVER_ERROR);
        model.addAttribute("message", exception.getMessage());
        return "error-page";
    }

    private static final int SERVER_ERROR = 500;
}

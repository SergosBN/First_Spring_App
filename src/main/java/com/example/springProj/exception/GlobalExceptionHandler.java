package com.example.springProj.exception;

import com.example.springProj.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;           // works with exceptions (specific)
import org.springframework.web.bind.annotation.RestControllerAdvice;       // works with exceptions (global)

@RestControllerAdvice
public class GlobalExceptionHandler {            // 2. WORKS WITH EXCEPTION

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(UserNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), 404);

        return ResponseEntity.status(404).body(errorResponse);
    }
}

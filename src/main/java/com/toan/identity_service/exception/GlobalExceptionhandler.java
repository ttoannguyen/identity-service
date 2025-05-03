package com.toan.identity_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.toan.identity_service.dto.response.ApiResponse;

@ControllerAdvice
public class GlobalExceptionhandler {

    @ExceptionHandler(value = RuntimeException.class)
    ResponseEntity<ApiResponse> handlingRuntimeException(RuntimeException exception) {
        ApiResponse apiResponse = new ApiResponse<>();
        apiResponse.setCode(1001);
        apiResponse.setMessage(exception.getMessage());
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<String> handlingValidation(MethodArgumentNotValidException exception) {
        return ResponseEntity.badRequest().body(exception.getFieldError().getDefaultMessage());
    }
}

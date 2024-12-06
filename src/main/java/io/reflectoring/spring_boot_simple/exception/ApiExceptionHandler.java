package io.reflectoring.spring_boot_simple.exception;

import io.reflectoring.spring_boot_simple.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleAllException(Exception ex, WebRequest request) {
        System.out.println("Error: " + ex.getMessage());
        return "Something went wrong!";
    }

//    Index Out Of Bounds Exception

    @ExceptionHandler(IndexOutOfBoundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String TodoException(Exception ex, WebRequest request) {
        return ex.getMessage();
    }
    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBindException(BindException e) {
        // Trả về message của lỗi đầu tiên
        String errorMessage = "Bad Request!";
        if (e.getBindingResult().hasErrors())
            e.getBindingResult().getAllErrors().getFirst().getDefaultMessage();
        return errorMessage;
    }
}

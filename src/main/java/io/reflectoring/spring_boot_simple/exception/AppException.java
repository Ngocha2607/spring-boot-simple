package io.reflectoring.spring_boot_simple.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AppException extends RuntimeException{
    private int code;
    private String message;
}

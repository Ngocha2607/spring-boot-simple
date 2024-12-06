package io.reflectoring.spring_boot_simple.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TodoDto {
    @NotEmpty(message = "Title is not empty")
    String title;
    String detail;
}

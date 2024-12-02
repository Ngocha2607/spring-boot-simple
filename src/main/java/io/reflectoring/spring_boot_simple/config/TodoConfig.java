package io.reflectoring.spring_boot_simple.config;

import io.reflectoring.spring_boot_simple.model.TodoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TodoConfig {
    @Bean
    public TodoValidator validator() {
        return new TodoValidator();
    }
}

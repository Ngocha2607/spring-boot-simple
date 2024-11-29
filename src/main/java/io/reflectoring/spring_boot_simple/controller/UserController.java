package io.reflectoring.spring_boot_simple.controller;

import io.reflectoring.spring_boot_simple.entity.User;
import io.reflectoring.spring_boot_simple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

@RequestMapping("api/user")
@Controller
public class UserController {
    @Autowired
    private UserService userService;
@GetMapping
    List<User> getAllUser(){
        return this.userService.getAllUser();
    }
}

package io.reflectoring.spring_boot_simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }
    @GetMapping("/hello")
    public String hello(
            @RequestParam(name="name", required = false, defaultValue = "") String name,
            Model model
    ) {
        model.addAttribute("name", name);
        return "hello";
    }
}


package io.reflectoring.spring_boot_simple;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/profile")
    public String profile(Model model) {
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Nguyễn Hoàng Nam"));
        profile.add(new Info("nickname", "lốddaf"));
        profile.add(new Info("gmail", "loda.namnh@gmail.com"));
        profile.add(new Info("facebook", "https://www.facebook.com/nam.tehee"));
        profile.add(new Info("website", "https://loda.me"));

        model.addAttribute("profile", profile);

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


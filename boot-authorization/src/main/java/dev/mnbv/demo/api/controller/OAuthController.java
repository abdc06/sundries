package dev.mnbv.demo.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OAuthController {
    @GetMapping("/loginForm")
    public String home() {
        return "/loginForm";
    }

    @GetMapping("/private")
    public String privatePage() {
        return "/private";
    }
}

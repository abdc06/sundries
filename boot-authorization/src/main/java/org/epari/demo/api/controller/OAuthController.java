package org.epari.demo.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OAuthController {

    @GetMapping("/login")
    public String login() {
        return "/login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "/dashboard";
    }

    @ResponseBody
    @GetMapping("/users")
    public ResponseEntity<?> getUserInfo(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(userDetails);
    }
}

package com.kcfed.ucmo.smsbackend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootRedirectController {

    @GetMapping
    public String redirectHome() {
        return "redirect:/home";
    }
}

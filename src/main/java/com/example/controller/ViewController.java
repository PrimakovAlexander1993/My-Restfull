package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping(value = "/admin")
    public String printAdminPage() {
        return "admin";
    }

    @GetMapping(value = "/user")
    public String printUserPage() {
        return "user";
    }
}
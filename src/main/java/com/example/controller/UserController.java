package com.example.controller;

import com.example.model.User;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class UserController {
    @GetMapping(value = "/user")
    public String printUserInfo(Model model) {
        model.addAttribute("user", (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return "/user";
    }
}
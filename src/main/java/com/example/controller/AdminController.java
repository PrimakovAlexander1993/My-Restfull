package com.example.controller;

import com.example.model.User;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getAllUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("userAuthentication", (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return "/admin/users";
    }

    @PostMapping(value = "/add")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("select") String[] rolesValues) {
        userService.addUser(user, rolesValues);
        return "redirect:/admin/users";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin/users";
    }
}
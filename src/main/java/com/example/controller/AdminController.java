package com.example.controller;

import com.example.model.User;

import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class AdminController {
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String getAllUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.listUsers());
        model.addAttribute("userAuthentication", (User) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal());
        return "admin";
    }

    @PostMapping(value = "/admin/add")
    public String addUser(@ModelAttribute("user") User user, @RequestParam("select") String[] rolesValues) {
        userService.addUser(user, rolesValues);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/delete")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.removeUser(id);
        return "redirect:/admin";
    }
}
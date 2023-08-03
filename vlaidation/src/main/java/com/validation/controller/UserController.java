package com.validation.controller;

import com.validation.entity.UserEntity;
import com.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

     private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
      // http://localhost:8080/all
     @GetMapping("/all")
     public String showUserList(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("newUser", new UserEntity());
        return "user-list.html";
     }

    @PostMapping("/addUser")
    public String addUser(@Validated UserEntity newUser, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("users", userService.getAllUsers());
            return "user-list";
        }
        userService.addUser(newUser);
        return "redirect:/all";
    }
}
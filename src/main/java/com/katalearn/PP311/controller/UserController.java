package com.katalearn.PP311.controller;

import com.katalearn.PP311.model.User;
import com.katalearn.PP311.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping(value = "/")
    public String startPageOpen(Model model) {
        List<User> users = userServiceImpl.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping(value = "/users")
    public String findAll(Model model) {
        List<User> users = userServiceImpl.findAll();
        model.addAttribute("users", users);
        return "user-list";
    }
    @GetMapping(value="/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }
    @PostMapping(value = "/user-create")
    public String createUser(User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userServiceImpl.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping(value="/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userServiceImpl.findById(id);
        model.addAttribute("user", user);
        return "user-update";
    }
    @PostMapping(value = "/user-update")
    public String updateUser(User user) {
        userServiceImpl.save(user);
        return "redirect:/users";
    }
}

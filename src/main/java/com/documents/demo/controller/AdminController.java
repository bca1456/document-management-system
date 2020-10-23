package com.documents.demo.controller;

import com.documents.demo.domain.User;
import com.documents.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public List<User> allUsers(){
        return userService.findAll();
    }
}

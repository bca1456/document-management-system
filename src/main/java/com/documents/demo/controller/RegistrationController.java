package com.documents.demo.controller;

import com.documents.demo.domain.Document;
import com.documents.demo.domain.User;
import com.documents.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public String addUser(@RequestBody User user){
        if (userService.findByUsername(user.getUsername()) != null){
            return "User exists";
        }

        userService.addNew(user);
        return "registered";
    }
}

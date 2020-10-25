package com.documents.demo.controller;

import com.documents.demo.domain.User;
import com.documents.demo.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
@Api
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping("/kek")
    public String kek(){
        return "kek";
    }

    @PostMapping("/add")
    public String addUser(@RequestBody User user){
        if (userService.loadUserByUsername(user.getUsername()) != null){
            return "User exists";
        }

        userService.addNew(user);
        return "registered";
    }
}

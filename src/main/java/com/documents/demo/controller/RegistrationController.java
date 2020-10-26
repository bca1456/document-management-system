package com.documents.demo.controller;

import com.documents.demo.domain.User;
import com.documents.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/registration")
@Api
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "get kek c=")
    @RequestMapping(value = "/kek", method = RequestMethod.GET)
    public String kek(){
        return "kek";
    }

    @ApiOperation(value = "register new user")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@RequestBody User user){
        if (userService.loadUserByUsername(user.getUsername()) != null){
            return "User exists";
        }

        userService.addNew(user);
        return "registered";
    }
}

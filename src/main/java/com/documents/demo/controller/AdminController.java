package com.documents.demo.controller;

import com.documents.demo.domain.User;
import com.documents.demo.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@Api
public class AdminController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "get all users")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> allUsers(){
        return userService.findAll();
    }
}

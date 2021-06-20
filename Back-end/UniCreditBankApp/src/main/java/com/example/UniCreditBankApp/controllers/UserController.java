package com.example.UniCreditBankApp.controllers;

import com.example.UniCreditBankApp.models.User;
import com.example.UniCreditBankApp.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }



    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }



}

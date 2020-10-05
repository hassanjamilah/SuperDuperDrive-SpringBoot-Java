package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;

@Controller
@RequestMapping("/login")
public class LoginController {
    UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String loginView(){
        // TODO: 03/10/2020 Delete the insert default user
//        UserModel user = new UserModel(null,"h3","","123456", "Hassan", "Jamila");
//        userService.createUser(user);

        return "/login";
    }

    @PostMapping("/logout")
    public String logoutView(){
        System.out.println("logout");
        return "login";
    }

    @GetMapping("/logout")
    public String logoutView1(){
        System.out.println("logout1");
        return "login";
    }

}

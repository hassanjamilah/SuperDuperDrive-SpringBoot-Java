package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")
public class SignUpController {
    UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String signupView(){
        return "/signup";
    }

    @PostMapping
    public String signupUser(@ModelAttribute UserModel user, Model model){
        String signUpErrorMessage = null;
        if (!userService.isUserNameAvailable(user.getUserName())){
            signUpErrorMessage = "The user name is already in use.\nPlease choose another user name";
        }

        if (signUpErrorMessage == null){
            int insertedUserID = userService.createUser(user);
            if (insertedUserID < 0 ){
                signUpErrorMessage = "Error in inserting the user data in the database";
            }

        }

        if (signUpErrorMessage == null){
            model.addAttribute("signupsucees", true);
            return "login";
        }else {
            model.addAttribute("signuperror", signUpErrorMessage);
            return "signup";
        }


    }
}

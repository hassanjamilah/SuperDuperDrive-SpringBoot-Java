package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;

@Controller
public class LogoutController {

    @GetMapping("/logout1")
    public String logoutView(){
        JOptionPane.showMessageDialog(null, "Logout");
        return "redirect:/login?logout";
    }

}

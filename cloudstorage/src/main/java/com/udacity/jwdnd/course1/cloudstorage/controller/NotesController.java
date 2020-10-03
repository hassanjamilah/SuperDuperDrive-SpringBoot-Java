package com.udacity.jwdnd.course1.cloudstorage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/note")
public class NotesController {
    @GetMapping
    public String noteView(){
        return "/home";
    }
}

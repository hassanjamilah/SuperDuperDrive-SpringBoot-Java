package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {
    FileService fileService;
    UserService userService;

    public HomeController(FileService fileService, UserService userService) {
        this.fileService = fileService;
        this.userService = userService;
    }

    @GetMapping
    public String homeView(){
        return "/home";
    }

    @PostMapping
    public String uploadFile(@RequestParam("fileUpload") MultipartFile file, Model model) throws IOException {
        InputStream inputStream = file.getInputStream();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        UserModel user = userService.getUserByUserName(userName);
        FileModel fileModel = new FileModel(null, file.getOriginalFilename(),"text",file.getSize()+"",user.getUserID() , inputStream);
        int id = fileService.createFile(fileModel);
        System.out.println("The inserted file id : " + id );
        List<FileModel> allFiles = fileService.getFilesListByUserID(user.getUserID());
        if (allFiles.size() >0){
            model.addAttribute("allFiles" , allFiles);
        }
        return "home";
    }
}

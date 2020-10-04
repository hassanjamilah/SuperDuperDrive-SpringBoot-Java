package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import com.udacity.jwdnd.course1.cloudstorage.model.NoteModel;
import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.FileService;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.UserService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Controller
public class HomeController {
    FileService fileService;
    UserService userService;
    NoteService noteService;

    public HomeController(FileService fileService, UserService userService, NoteService noteService) {
        this.fileService = fileService;
        this.userService = userService;
        this.noteService = noteService;
    }

    @GetMapping("/home")
    public String homeView(){
        return "/home";
    }

    @GetMapping("home/deleteFile/{fileID}")
    public String deleteFile(@PathVariable int fileID, Model model){
        System.out.println("Delete File with id " + fileID);
        fileService.deleteFile(fileID);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        UserModel user = userService.getUserByUserName(userName);
        List<FileModel> allFiles = fileService.getFilesListByUserID(user.getUserID());
        if (allFiles.size() >0){
            model.addAttribute("allFiles" , allFiles);
        }
        return "home";
    }

    @GetMapping("/home/viewFile/{fileID}")
    public ResponseEntity<Resource> viewFile(@PathVariable int fileID, Authentication auth) throws IOException {
        System.out.println("View file file with ID: " + fileID);
        FileModel file = fileService.getFileByID(fileID);

        return ResponseEntity
                .ok()
                .contentType(MediaType.parseMediaType(file.getContentType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
                .body(new ByteArrayResource(file.getFileData()));
    }

    @PostMapping("/home")
    public String uploadFile(@RequestParam("fileUpload") MultipartFile file, Model model) throws IOException {
        InputStream inputStream = file.getInputStream();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        UserModel user = userService.getUserByUserName(userName);
        FileModel fileModel = new FileModel(null, file.getOriginalFilename(),file.getContentType(),file.getSize()+"",user.getUserID() , file.getBytes());
        int id = fileService.createFile(fileModel);
        System.out.println("The inserted file id : " + id );
        List<FileModel> allFiles = fileService.getFilesListByUserID(user.getUserID());
        if (allFiles.size() >0){
            model.addAttribute("allFiles" , allFiles);
        }
        return "home";
    }

    @PostMapping("/home/createNote")
    public String insertNewNote(@ModelAttribute NoteModel noteModel,Authentication auth, Model model){
        String userName = auth.getName();
        UserModel user = userService.getUserByUserName(userName);
        //TODO: change to oringina user id
        int userID = 1;
        noteModel.setUserID(1);
        int id = noteService.createNote(noteModel);
        System.out.println("The inserted Note ID is: " + id);
        if (id > 0 ){
            List<NoteModel> allNotes = noteService.getNotesByUserID(userID);
            System.out.println("The notes count is: " + noteService.getNotesCount());
            for (NoteModel note:
                 allNotes) {
                System.out.println(note.toString());

            }
            model.addAttribute("allNotes", allNotes );
            model.addAttribute("selectedTab" , "note");
        }
        return "home";
    }
}

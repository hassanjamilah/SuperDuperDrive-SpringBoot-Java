package com.udacity.jwdnd.course1.cloudstorage.services.models_services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.FileMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Service
public class FileService {
    // TODO1: 30/09/2020 create a field for the file mapper
    FileMapper fileMapper;

    public FileService(FileMapper fileMapper) {
        this.fileMapper = fileMapper;
    }

    /**
     * Insert a new file and its data in the database
     * @param fileModel the file mode that contains the data
     * @return the id of the inserted file
     * On Error will return -1
     */
    // TODO1: 30/09/2020 Implement the insert file data, insert file and return the id
    public int createFile(FileModel fileModel){
        int insertedFileID = fileMapper.insertFile(fileModel);
        System.out.println("Inserted file id is : " + fileModel.getFileID());
        List<FileModel> allFiles = fileMapper.getAllFiles();
        System.out.println("The number of files is: " + allFiles.size());
        for (FileModel file:
             allFiles) {
            System.out.println(file.toString());
        }
        return insertedFileID;

    }

    /**
     * Get a list of the files depending on the user id
     * @param userID the user id to search in the database
     * @return a list of the file without the files data
     */
    // TODO1: 30/09/2020 get the list of the files without the data and return it
    public List<FileModel> getFilesListByUserID(int userID){
        List<FileModel> allFiles = fileMapper.getFilesByUserID(userID);
        return allFiles;
    }

    public void deleteFile(int fileID){
        fileMapper.deleteFile(fileID);
    }

    public int getFilesCount(){
        return fileMapper.getFilesCount();
    }
}

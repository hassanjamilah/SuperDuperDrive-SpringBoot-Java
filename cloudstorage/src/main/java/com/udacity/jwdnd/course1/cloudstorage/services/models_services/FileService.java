package com.udacity.jwdnd.course1.cloudstorage.services.models_services;

import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.util.List;

@Service
public class FileService {
    // TODO: 30/09/2020 create a field for the file mapper

    /**
     * Insert a new file and its data in the database
     * @param fileModel the file mode that contains the data
     * @return the id of the inserted file
     * On Error will return -1
     */
    // TODO: 30/09/2020 Implement the insert file data, insert file and return the id
    public int createFile(FileModel fileModel){
        return -1;
    }

    /**
     * Get a list of the files depending on the user id
     * @param userID the user id to search in the database
     * @return a list of the file without the files data
     */
    // TODO: 30/09/2020 get the list of the files without the data and return it 
    public List<FileModel> getFilesListByUserID(int userID){
        return null;
    }

    /**
     * Save the file content in the database
     * @param fileID
     */
    // TODO: 30/09/2020 handle the save of the file 
    public void saveFileByStream (int fileID){

    }

    /**
     * Get the file content of a specific file id
     * @param fileID the file id to get the data for
     * @return a file containing the data
     */
    public File getFileByStream (int fileID){
        //TODO: read the file and return it
        return null;
    }
}

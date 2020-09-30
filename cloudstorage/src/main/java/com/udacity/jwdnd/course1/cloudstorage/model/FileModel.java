package com.udacity.jwdnd.course1.cloudstorage.model;

import java.io.InputStream;

public class FileModel {
    /*
    Sample Data
        fileId INT PRIMARY KEY auto_increment,
        filename VARCHAR,
        contenttype VARCHAR,
        filesize VARCHAR,
        userid INT,
        filedata BLOB,
        foreign key (userid) references USERS(userid)
     */

    private int fileID;
    private String fileName;
    private String contentType;
    private String fileSize;
    private int userID;
    private InputStream fileData;

    public FileModel(int fileID, String fileName, String contentType, String fileSize, int userID) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userID = userID;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public InputStream getFileData() {
        return fileData;
    }

    public void setFileData(InputStream fileData) {
        this.fileData = fileData;
    }
}

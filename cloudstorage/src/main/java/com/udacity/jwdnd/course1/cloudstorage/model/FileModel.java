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

    private Integer fileID;
    private String fileName;
    private String contentType;
    private String fileSize;
    private int userID;
    private InputStream fileData;

    public FileModel(Integer fileID, String fileName, String contentType, String fileSize, int userID, InputStream fileContens) {
        this.fileID = fileID;
        this.fileName = fileName;
        this.contentType = contentType;
        this.fileSize = fileSize;
        this.userID = userID;
        this.fileData = fileContens;
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

    @Override
    public String toString() {
        return "FileModel{" +
                "fileID=" + fileID +
                ", fileName='" + fileName + '\'' +
                ", contentType='" + contentType + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", userID=" + userID +
                ", fileData=" + fileData +
                '}';
    }
}

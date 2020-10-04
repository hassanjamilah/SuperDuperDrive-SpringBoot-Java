package com.udacity.jwdnd.course1.cloudstorage.model;

public class CredentialModel {
    /*
        Sample Data
            credentialid INT PRIMARY KEY auto_increment,
            url VARCHAR(100),
            username VARCHAR (30),
            key VARCHAR,
            password VARCHAR,
            userid INT,
            foreign key (userid) references USERS(userid)
     */
    private Integer credentialID;
    private String url;
    private String userName;
    private String key;
    private String password;
    private Integer userID;

    public CredentialModel(Integer credentialID, String url, String userName, String key, String password, Integer userID) {
        this.credentialID = credentialID;
        this.url = url;
        this.userName = userName;
        this.key = key;
        this.password = password;
        this.userID = userID;
    }

    public int getCredentialID() {
        return credentialID;
    }

    public void setCredentialID(int credentialID) {
        this.credentialID = credentialID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "CredentialModel{" +
                "credentialID=" + credentialID +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", key='" + key + '\'' +
                ", password='" + password + '\'' +
                ", userID=" + userID +
                '}';
    }
}

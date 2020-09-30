package com.udacity.jwdnd.course1.cloudstorage.model;

public class UserModel {
    /*
    Sample Model
          userid INT PRIMARY KEY auto_increment,
          username VARCHAR(20),
          salt VARCHAR,
          password VARCHAR,
          firstname VARCHAR(20),
          lastname VARCHAR(20)
     */

    private int userID;
    private String userName;
    private String salt;
    private String password;
    private String firstName;
    private String lastName;

    public int getUserID() {
        return userID;
    }

    public UserModel(int userID, String userName, String salt, String password, String firstName, String lastName) {
        this.userID = userID;
        this.userName = userName;
        this.salt = salt;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

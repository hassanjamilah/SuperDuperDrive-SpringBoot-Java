package com.udacity.jwdnd.course1.cloudstorage.services.models_services;

import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import com.udacity.jwdnd.course1.cloudstorage.services.security.HashService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    //TODO: create fields for userMapper and hashMap and create constructor
    private HashService hashService;


    /**
     * Check if the user name is available
     * @param userName the user name to check
     * @return if the user name already used will return false becuase it's not available
     * if the user name is not exist will return true so the user can use it
     */
    public boolean isUserNameAvailable(String userName){
        //TODO: check if the user name exist or not
        return false;
    }

    /**
     * Create new user and store it in the database
     * @param user the user model which contains the data
     * @return the id of the inserted user
     * on Fail will return -1
     */
    // TODO: hash the password and insert the user
    public int createUser(UserModel user){

        return -1;
    }

    /**
     * Get user from the database depending on its userName
     * @param userName the userName to find in the database
     * @return User model contains the data of the user
     */
    // TODO: Get the user and return the user model
    public UserModel getUserByUserName (String userName){
        return null;
    }

    /**
     * Get user from the database depending on the user id
     * @param userID the user id to search for in the database
     * @return User model contains the user data
     */
    // TODO: Get the user and return the user model
    public UserModel getUserByID (int userID){
        return null;
    }



}

package com.udacity.jwdnd.course1.cloudstorage.services.models_services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import com.udacity.jwdnd.course1.cloudstorage.services.security.HashService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {
    //TODO: create fields for userMapper and hashMap and create constructor
    private HashService hashService;
    private UserMapper userMapper;

    public UserService(HashService hashService, UserMapper userMapper) {
        this.hashService = hashService;
        this.userMapper = userMapper;
    }

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
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(),encodedSalt);
        user.setSalt(encodedSalt);
        user.setPassword(hashedPassword);
        //Maybe you need to create new user ?
        return userMapper.insertUser(user);
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

package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import com.udacity.jwdnd.course1.cloudstorage.services.models_services.UserService;
import com.udacity.jwdnd.course1.cloudstorage.services.security.HashService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {
    @LocalServerPort
    int port;

    UserMapper mapper;
    static UserService userService;

    @BeforeAll
    static void beforeAll(){


    }

    @Test
    void insertUser(){
        userService = new UserService(new HashService(), new UserMapper() {
            @Override
            public int insertUser(UserModel user) {
                return 0;
            }

            @Override
            public UserModel getUserByID(int userID) {
                return null;
            }

            @Override
            public int getUsersCount() {
                return 0;
            }
        });
        UserModel user = new UserModel(0,"hassanjamila","","123456","Hassan", "Jamila");
        int id = userService.createUser(user);
        System.out.println("The inserted user id is: " + id);
    }

    @Test
    void getAllUsers(){

    }
}

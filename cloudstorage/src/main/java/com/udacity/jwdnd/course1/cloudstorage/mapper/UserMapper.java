package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.UserModel;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    static String USERS_TABLE_NAME = "USERS";
    @Insert("insert into USERS (username, salt, password, firstname, lastname) VALUES " +
            "(#{userName}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userID")
    int insertUser(UserModel user);

    @Select("select * from USERS where userid = #{userID}" )
    UserModel getUserByID(int userID);

    @Select("select * from USERS where username = #{userName}" )
    UserModel getUserByUserName(String  userName);


    @Select("select count(userid) as usercount from " + USERS_TABLE_NAME)
    @Options(useGeneratedKeys = true, keyProperty = "usercount")
    int getUsersCount();

    @Delete("delete from " + USERS_TABLE_NAME + " where userid = #{user.userID}")
    void deleteUser(UserModel user);

    @Update("update " + USERS_TABLE_NAME +
        " set password = #{newUser.password}, firstName = #{newUser.firstName}" +
            " lastname = #{newUser.lastName}" +
            " where userid = #{oldUserID}"
    )
    void updateUser(int oldUserID, UserModel newUser);

}

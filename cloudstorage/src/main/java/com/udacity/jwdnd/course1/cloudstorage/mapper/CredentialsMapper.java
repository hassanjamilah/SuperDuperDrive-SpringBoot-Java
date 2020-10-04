package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CredentialsMapper {
    static String TABLE_CREDENTIAL_NAME = "CREDENTIALS";
    static String COL_CREDENTIALID_NAME = "credentialid";
    static String COL_URL_NAME = "url";
    static String COL_USERNAME_NAME = "username";
    static String COL_KEY_NAME = "key";
    static String COL_PASSWORD_NAME = "password";
    static String COL_USERID_NAME = "userid";
    static String SEPARATOR_COMMA = " , ";
    static String SEPARATOR_EQUAL = " = ";

    //Insert
    @Insert("insert into " + TABLE_CREDENTIAL_NAME +
        "(" +
            COL_KEY_NAME + SEPARATOR_COMMA +
            COL_PASSWORD_NAME + SEPARATOR_COMMA +
            COL_URL_NAME + SEPARATOR_COMMA +
            COL_USERID_NAME + SEPARATOR_COMMA +
            COL_USERNAME_NAME  +
            ") VALUES (" +
            "#{key}" + SEPARATOR_COMMA +
            "#{password}" + SEPARATOR_COMMA +
            "#{url}" + SEPARATOR_COMMA +
            "#{userID}" + SEPARATOR_COMMA +
            "#{userName}" +
            ")"
    )
    @Options(useGeneratedKeys = true, keyProperty = "credentialID")
    int createCredential(CredentialModel cred);

    //Get
    @Select("select * from " + TABLE_CREDENTIAL_NAME + " where userid = #{userID}")
    List<CredentialModel> getCredentialsByUserID(int userID);

    @Select("select * from " + TABLE_CREDENTIAL_NAME + " where " + COL_CREDENTIALID_NAME + " = #{credID}" )
    CredentialModel getCredentialsByID(int credID);

    @Select("select * from " + TABLE_CREDENTIAL_NAME + " where " + COL_URL_NAME + " like '%#{searchString}%'")
    List<CredentialModel> getCredentialBySearch(String searchString);

    //Delete
    @Delete("delete from " + TABLE_CREDENTIAL_NAME + " where " + COL_CREDENTIALID_NAME + " = #{credID}")
    void deleteCredential(int credID);

    //Update
    @Update("update " + TABLE_CREDENTIAL_NAME +
        " set " + COL_PASSWORD_NAME + SEPARATOR_EQUAL + "#{newCred.password}" + SEPARATOR_COMMA +
                  COL_URL_NAME + SEPARATOR_EQUAL + "#{newCred.url}" + SEPARATOR_COMMA +
                  COL_USERNAME_NAME + SEPARATOR_EQUAL + "#{newCred.userName}"  +
        " where " + COL_CREDENTIALID_NAME + " = #{oldCredID}"
    )
    void updateCredential(int oldCredID, CredentialModel newCred);
    
}

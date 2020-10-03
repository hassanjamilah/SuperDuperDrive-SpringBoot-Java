package com.udacity.jwdnd.course1.cloudstorage.services.models_services;

import com.udacity.jwdnd.course1.cloudstorage.model.CredentialModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CredentialService {
    // TODO: 30/09/2020 create fields for encryption class and credential mapper

    /**
     * Insert credential in the database
     * @param cred the credentail model contains the data
     * @return the id of the inserted credential
     * When error return -1
     */
    // TODO: 30/09/2020 Implement the insertions, encrypt the password save and return the id
    public int createCrednetials(CredentialModel cred){
        return -1;
    }

    /**
     * Get the list of credentials for the user
     * @param userID the user id
     * @return a list of the credentials
     * will return null if there are no credentials or the user id is wrong
     */
    public List<CredentialModel> getCredentialsByUserID (int userID){
        return null;
    }

    /**
     * Get the list of credentials depending on the user id and on the search text
     * @param userID
     * @param searchText
     * @return
     */
    public List<CredentialModel> getCredentialsBySearch (String searchText, int userID){
        return null;
    }

    
    // // TODO: 03/10/2020 Complete the method get the credential and put it in the model and return it 
    public CredentialModel getCredentialByID(int credID){
        return null;
    } 
    
    /**
     * Encrypt the password of the credentials
     * @param password the text password
     * @return the encrypted password
     */
    private String encryptPassword(String password){
        return "";
    }
}

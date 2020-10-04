package com.udacity.jwdnd.course1.cloudstorage.services.models_services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.CredentialsMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.CredentialModel;
import com.udacity.jwdnd.course1.cloudstorage.services.security.EncryptionService;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

@Service
public class CredentialService {
    // TODO1: 30/09/2020 create fields for encryption class and credential mapper
    EncryptionService encryptionService;
    CredentialsMapper credMapper;

    public CredentialService(EncryptionService encryptionService, CredentialsMapper credMapper) {
        this.encryptionService = encryptionService;
        this.credMapper = credMapper;
    }

    /**
     * Insert credential in the database
     * @param cred the credentail model contains the data
     * @return the id of the inserted credential
     * When error return -1
     */
    // TODO1: 30/09/2020 Implement the insertions, encrypt the password save and return the id
    public int createCrednetials(CredentialModel cred){
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[16];
        random.nextBytes(key);
        String encodedKey = Base64.getEncoder().encodeToString(key);
        String encryptedPassword = encryptionService.encryptValue(cred.getPassword(), encodedKey);
        cred.setKey(encodedKey);
        cred.setPassword(encryptedPassword);
        int id = credMapper.createCredential(cred);
        return cred.getCredentialID();
    }

    /**
     * Get the list of credentials for the user
     * @param userID the user id
     * @return a list of the credentials
     * will return null if there are no credentials or the user id is wrong
     */
    public List<CredentialModel> getCredentialsByUserID (int userID){
        return credMapper.getCredentialsByUserID(userID);
    }

    /**
     * Get the list of credentials depending on the user id and on the search text
     * @param userID
     * @param searchText
     * @return
     */
    public List<CredentialModel> getCredentialsBySearch (String searchText, int userID){
        return credMapper.getCredentialBySearch(searchText);
    }

    
    // // TODO: 03/10/2020 Complete the method get the credential and put it in the model and return it 
    public CredentialModel getCredentialByID(int credID){

        CredentialModel cred =  credMapper.getCredentialsByID(credID);
        String password = decryptPassword(cred.getPassword(), cred.getKey());
        cred.setPassword(password);
        return  cred;
    } 
    
    public String decryptPassword(String key, String encryptedPassword){
        return encryptionService.decryptValue(encryptedPassword,key);
    }

    public void deleteCredentials(int credID){
        credMapper.deleteCredential(credID);
    }
}

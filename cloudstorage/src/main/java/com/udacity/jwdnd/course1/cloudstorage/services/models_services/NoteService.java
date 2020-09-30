package com.udacity.jwdnd.course1.cloudstorage.services.models_services;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    // TODO: 30/09/2020 create field for Note Mapper 

    /**
     * Insert the note in the database
     * @param note the note model which contains the data
     * @return the id of the inserted note
     * On failure will return -1
     */
    // TODO: 30/09/2020 implement the insertion and return the id 
    public int createNote(NoteModel note){
        return -1;
    }

    /**
     * Get a list of note depending on the user id
     * @param userID the user id to get notes for
     * @return a list of the notes related to this user id
     */
    // TODO: 30/09/2020 Get the notes and return the list 
    public List<NoteModel> getNotesByUserID (int userID){
        return null;    
    }

    /**
     * Get a specified note depening on its id
     * @param noteID the id of the note
     * @param userID the id of the user
     * @return a note model
     */
    // TODO: 30/09/2020 Get the note and store it in the model an return it 
    public NoteModel getNoteByNoteID (int noteID, int userID){
        return null;
    }

    /**
     * Find a list of notes for a specified user id and a specified text to search
     * @param searchFor
     * @param userID 
     * @return a list of note models founded
     */
    // TODO: 30/09/2020 find the notes and return the list of models 
    public List<NoteModel> getNotesBySearch (String searchFor, int userID){
        return null;
    }
    
}

package com.udacity.jwdnd.course1.cloudstorage.model;

public class NoteModel {
    /*
      Sample Model
        noteid INT PRIMARY KEY auto_increment,
        notetitle VARCHAR(20),
        notedescription VARCHAR (1000),
        userid INT,
        foreign key (userid) references USERS(userid)
     */
    private Integer noteID;
    private String noteTitle;
    private String noteDescription;
    private Integer userID;

    public NoteModel(Integer noteID, String noteTitle, String noteDescription, Integer userID) {
        this.noteID = noteID;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.userID = userID;
    }

    public int getNoteID() {
        return noteID;
    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "NoteModel{" +
                "noteID=" + noteID +
                ", noteTitle='" + noteTitle + '\'' +
                ", noteDescription='" + noteDescription + '\'' +
                ", userID=" + userID +
                '}';
    }
}

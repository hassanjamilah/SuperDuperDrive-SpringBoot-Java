package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {
    static String TABLE_NOTES_NAME = "NOTES";
    static String COL_TITLE_NAME = "notetitle";
    static String COL_DESCRIPTION_NAME = "notedescription";
    static String COL_USERID_NAME = "userid";

    //Insert
    @Insert("insert into " + TABLE_NOTES_NAME +
            "( " + COL_TITLE_NAME + " , " + COL_DESCRIPTION_NAME + " , " + COL_USERID_NAME +
             " ) VALUES (" +
             "#{noteTitle} , #{noteDescription}, #{userID})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "noteID")
    int createNote(NoteModel note);

    //Get notes by userID
    @Select("select * from " + TABLE_NOTES_NAME + " WHERE userid = #{userID}")
    List<NoteModel> getNotesByUserID(int userID);

    //Get note by noteID
    @Select("select * from " + TABLE_NOTES_NAME + " where noteid = #{noteID}")
    NoteModel getNoteByNoteID(int noteID);

    //Get notes by search
    @Select("select * from "  + TABLE_NOTES_NAME  + " where " + COL_DESCRIPTION_NAME  +
            " like '%#{searchString}%'"
    )
    List<NoteModel> getNotesBySearch(String searchString);

    //Delete
    @Delete("delete from " + TABLE_NOTES_NAME + " where noteid = #{noteID}")
    void deleteNote(int noteID);

    //Update
    @Update("update "  + TABLE_NOTES_NAME +
        " set " + COL_DESCRIPTION_NAME + " = #{noteDescriptione}," +
            COL_TITLE_NAME + " = #{noteTitle}" +
            " where noteid = #{oldNoteID}"
    )
    void updateNote(int oldNoteID, NoteModel newNote);

    @Select("SELECT count(noteID) FROM " + TABLE_NOTES_NAME)
    int getNotesCount();


}

package com.udacity.jwdnd.course1.cloudstorage.mapper;

import com.udacity.jwdnd.course1.cloudstorage.model.FileModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FileMapper {
    static String TABLE_FILE_NAME = "FILES";
    static String COL_FILEID_NAME = "fileId";
    static String COL_FILENAME_NAME = "filename";
    static String COL_CONTENTTYPE_NAME = "contenttype";
    static String COL_FILESIZE_NAME = "filesize";
    static String COL_USERID_NAME = "userid";
    static String COL_FILEDATA_NAME = "filedata";
    static String SEPARATOR_COMMA = " , ";
    static String SEPARATOR_EQUAL = " = ";

    //Insert
    @Insert(
            "insert into "  + TABLE_FILE_NAME + " (" +
                COL_CONTENTTYPE_NAME + SEPARATOR_COMMA +
                COL_FILEDATA_NAME + SEPARATOR_COMMA +
                COL_FILENAME_NAME + SEPARATOR_COMMA +
                COL_FILESIZE_NAME + SEPARATOR_COMMA +
                COL_USERID_NAME + " ) VALUES (" +
                "#{contentType}, #{fileData}, #{fileName}, #{fileSize}, #{userID})"
    )
    @Options(useGeneratedKeys = true, keyProperty = "fileID")
    int insertFile(FileModel fileModel);

    //Get
    @Select("select * from " + TABLE_FILE_NAME + " where userid = #{userID}")
    List<FileModel> getFilesByUserID(int userID);

    @Select("select * from " + TABLE_FILE_NAME + " where fileid = #{fileID}")
    FileModel getFileByFileID(int fileID);

    //Delete
    @Delete("delete from "  + TABLE_FILE_NAME + " where fileid = #{fileID}")
    void deleteFile(int fileID);

    //Update
    @Update("update " + TABLE_FILE_NAME +
        " set " + COL_CONTENTTYPE_NAME + SEPARATOR_EQUAL + "#{contentType} " + SEPARATOR_COMMA +
                  COL_FILEDATA_NAME + SEPARATOR_EQUAL + "#{fileData}" + SEPARATOR_COMMA +
                  COL_FILENAME_NAME + SEPARATOR_EQUAL + "#{fileName}" + SEPARATOR_COMMA +
                  COL_FILESIZE_NAME + SEPARATOR_EQUAL + "#{fileSize} " +
                  " where fileid = oldFileID"
    )
    void updateFile(int oldFileID, FileModel newFile);


    @Select("select count(fileid) from " + TABLE_FILE_NAME)
    int getFilesCount();

    @Select("select * from " + TABLE_FILE_NAME)
    List<FileModel> getAllFiles();
}

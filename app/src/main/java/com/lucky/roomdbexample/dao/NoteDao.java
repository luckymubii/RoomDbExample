package com.lucky.roomdbexample.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.lucky.roomdbexample.entities.Note;
import com.lucky.roomdbexample.util.Constants;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM "+ Constants.TABLE_NAME_NOTE)
    List<Note> getAll();


    /*
     * Insert the object in database
     * @param note, object to be inserted
     */
    @Insert
    long insertNote(Note note);
    /*
     * update the object in database
     * @param note, object to be updated
     */
    @Update
    void update(Note repos);

    /*
     * delete the object from database
     * @param note, object to be deleted
     */
    @Delete
    void delete(Note note);

    /*
     * delete list of objects from database
     * @param note, array of objects to be deleted
     */
    @Delete
    void delete(Note... note);      // Note... is varargs, here note is an array

}
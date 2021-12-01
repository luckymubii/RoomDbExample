package com.lucky.roomdbexample.noteddb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.lucky.roomdbexample.dao.NoteDao;
import com.lucky.roomdbexample.entities.Note;
import com.lucky.roomdbexample.util.Constants;

@Database(entities = { Note.class }, version = 1)
public abstract class NoteDatabase extends RoomDatabase {

    public abstract NoteDao getNoteDao();

    private static NoteDatabase noteDB;

    public static NoteDatabase getInstance(Context context) {
        if (null == noteDB) {
            noteDB = buildDatabaseInstance(context);
        }
        return noteDB;
    }

    private static NoteDatabase buildDatabaseInstance(Context context) {
        return Room.databaseBuilder(context,
                NoteDatabase.class,
                Constants.DB_NAME)
                .allowMainThreadQueries().build();
    }

    public void cleanUp(){
        noteDB = null;
    }

}
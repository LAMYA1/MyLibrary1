package com.app.mylibrary.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.mylibrary.DbDao.BooksDao;
import com.app.mylibrary.DbDao.ReminderDao;
import com.app.mylibrary.Modle.Books;
import com.app.mylibrary.Modle.Reminder;


@Database(entities = {Books.class, Reminder.class}, version = 1, exportSchema = false)
public abstract class DataBaseS extends RoomDatabase {
    public static final String DATABASE_NAME = "my_library_db";
    private static DataBaseS instance;

    public static DataBaseS getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    DataBaseS.class,
                    DATABASE_NAME)
                    .allowMainThreadQueries().build();
        }
        return instance;
    }


    public abstract BooksDao getBooksDao();

    public abstract ReminderDao getReminderDao();


}

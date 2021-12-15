package com.app.mylibrary.DbDao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.mylibrary.Modle.Books;
import com.app.mylibrary.Modle.Reminder;

import java.util.List;

@Dao
public interface ReminderDao {

    @Insert(entity = Reminder.class, onConflict = OnConflictStrategy.REPLACE)
    long addNewReminder(Reminder reminder);

    @Query("SELECT DISTINCT * FROM reminder")
    List<Reminder> getAllReminder();

    @Query("SELECT DISTINCT * FROM reminder WHERE time = :time")
    Reminder getAllReminderAlarm(String time);


}

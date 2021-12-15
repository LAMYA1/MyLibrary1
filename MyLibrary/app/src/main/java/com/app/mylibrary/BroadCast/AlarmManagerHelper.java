package com.app.mylibrary.BroadCast;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.AlarmManagerCompat;

import com.app.mylibrary.DB.DataBaseS;
import com.app.mylibrary.Modle.Reminder;

import java.util.Calendar;


public class AlarmManagerHelper {

    public static void setAlarm(Context context) {

        DataBaseS dataBaseS = DataBaseS.getInstance(context);

        Reminder reminder  ;
        Calendar calendar = Calendar.getInstance();
        int h = 0, m = 0;

        for (int i = 0; i < dataBaseS.getReminderDao().getAllReminder().size(); i++) {

            reminder = dataBaseS.getReminderDao().getAllReminder().get(i);
            String[] time = reminder.getTime().split(":");
             h = Integer.parseInt(time[0]);
             m = Integer.parseInt(time[1]);

        }
        calendar.set(Calendar.HOUR_OF_DAY, h);
        calendar.set(Calendar.MINUTE, m);
        calendar.set(Calendar.SECOND, 0);
        Intent i = new Intent(context, BroadCastReceiver.class);
        PendingIntent mAlarmSender = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        AlarmManagerCompat.setExactAndAllowWhileIdle(alarmManager, AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), mAlarmSender);


        Log.e("MINUTE" , Calendar.HOUR_OF_DAY+"");
        Log.e("MINUTE" , Calendar.MINUTE+"");
        Log.e("MINUTE" , h+"");
        Log.e("MINUTE" , m+"");
    }





}

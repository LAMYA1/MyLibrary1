package com.app.mylibrary.BroadCast;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

import androidx.core.app.AlarmManagerCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.app.mylibrary.AllReminderActivity;
import com.app.mylibrary.R;


public class BroadCastReceiver extends BroadcastReceiver {
    private static final String CHANNEL_ID = "morning_notification_channel";
    private static final int REQUEST_CODE = 100;
    private static final int NOTIFICATION_ID = 100;

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, BroadCastReceiver.class);
        PendingIntent mAlarmSender = PendingIntent.getBroadcast(context, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        AlarmManagerCompat.setExactAndAllowWhileIdle(alarmManager,AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+ (24*60*60*1000), mAlarmSender);

        createNotificationChannel(context);
        showBasicNotification(context);


    }


    private void createNotificationChannel(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Attention";
            String description = "Warning To Read a Book";
            AudioAttributes audioAttributes=new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_NOTIFICATION)
                    .build();
            Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name,
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription(description);
            channel.setShowBadge(false);
            channel.setSound(soundUri,audioAttributes);
            channel.setLockscreenVisibility(NotificationCompat.VISIBILITY_PUBLIC);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void showBasicNotification(Context context) {
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
        stackBuilder.addNextIntentWithParentStack(new Intent(context, AllReminderActivity.class));
        PendingIntent pendingIntent = PendingIntent.getActivities(context, REQUEST_CODE, stackBuilder.getIntents(), 0);
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .setSmallIcon(R.drawable.ic_baseline_menu_book_24)
                        .setContentTitle("Attention")
                        .setContentText("Warning To Read a Book")
                        .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                        .setSound(soundUri)
                        .setAutoCancel(true)
                        .setContentIntent(pendingIntent);
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);
        Notification notification = builder.build();
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

}

package com.example.yura.notificationexamplesite;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import static android.app.Notification.FLAG_INSISTENT;


public class MainActivity extends AppCompatActivity {

    // Идентификатор уведомления
    private static final int NOTIFY_ID = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        // до версии Android 8.0 API 26
        Intent notificationIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://developer.alexanderklimov.ru/android/"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        Context context = getApplicationContext();
        Resources res = context.getResources();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setContentTitle("Посетите мой сайт")
                .setContentText("http://developer.alexanderklimov.ru/android/")
                .setTicker("Внимание!")
                .setColor(Color.GREEN)
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pendingIntent)
                .setDefaults(Notification.DEFAULT_SOUND|Notification.FLAG_INSISTENT)
                .setAutoCancel(true)
                //.setSmallIcon(R.mipmap.ic_launcher)
                .setSmallIcon(android.R.drawable.stat_sys_upload)
                .setLargeIcon(BitmapFactory.decodeResource(res, R.drawable.hungrycat));

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(NOTIFY_ID, builder.build());


    }

    public void onClick1(View view) {
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.cancel(NOTIFY_ID);

    }
}

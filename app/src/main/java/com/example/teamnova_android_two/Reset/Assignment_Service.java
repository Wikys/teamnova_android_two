package com.example.teamnova_android_two.Reset;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.회원가입.MainActivity;

public class Assignment_Service extends Service {
    NotificationManager Notifi_M;
    Day_Listener thread;
    Notification Notifi ;


    public Assignment_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notifi_M = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        return super.onStartCommand(intent, flags, startId);
    }
    class ServiceHandler extends Handler{
        @Override
        public void handleMessage(@NonNull Message msg) {
            Intent intent = new Intent(Assignment_Service.this, MainActivity.class);
            PendingIntent pendingIntent = PendingIntent
                    .getActivity(Assignment_Service.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
            Notifi = new Notification.Builder(getApplicationContext())
                    .setContentTitle("Content Title")
                    .setContentText("Content Text")
                    .setTicker("알림!!!")
                    .setSmallIcon(R.drawable.icon)
                    .setContentIntent(pendingIntent)
                    .build();
            Notifi.defaults = Notification.DEFAULT_SOUND;
            //소리추가
            Notifi.flags = Notification.FLAG_ONLY_ALERT_ONCE;
            //소리 한번만나게끔
            Notifi.flags = Notification.FLAG_AUTO_CANCEL;
            //확인하면 자동으로 알람제거
            Notifi_M.notify(777,Notifi);
            Toast.makeText(Assignment_Service.this, "뜸?", Toast.LENGTH_SHORT).show();

        }
    }
}

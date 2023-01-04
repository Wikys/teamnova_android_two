package com.example.teamnova_android_two.Reset;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.teamnova_android_two.Main.Main;

import java.util.Calendar;

public class Assignment_Service extends Service {
    NotificationManager Notifi_M;
    //    Day_Listener thread;

    Intent intent;

    ServiceHandler handler = new ServiceHandler();
    Day_Listener thread;
    Context context;
    int 요일;

    public Assignment_Service() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("서비스", "onBind: ");
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        String 아이디 = intent.getStringExtra("아이디");
//        context = (Context)intent.getSerializableExtra("context");

        Day_Listener thread = new Day_Listener(handler, 아이디);
//        Notifi_M = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        ServiceHandler handler = new ServiceHandler();
//        thread = new Day_Listener(handler);

        Log.d("아이디", "onStartCommand: "+아이디);

        thread.start();
        return START_STICKY;
        //start_sticky : 서비스가 강제종료되었을때 재시작시켜줌

//        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d("서비스", "onDestroy: ");
//        thread.interrupt();
//        //스레드 종료

//            thread.stopForever();
//            thread = null;


//        thread.interrupt();
        //널을 만들어서 빠르게 회수
    }
    //서비스 종료될 때 작업

    class ServiceHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
//            Calendar 요일 = Calendar.getInstance();
            Log.d("서비스", "handleMessage: ");
            Bundle bundle = new Bundle();
            Log.d("요일핸들러", "handleMessage: "+msg.what);
            Intent popupIntent = new Intent(getApplicationContext(), Reset_Confirm_Dialog.class);

            if (msg.what == 5) {

                popupIntent.putExtra("알림메세지", "주간 스케쥴이 초기화 되었습니다");

//                Log.d("서비스 번들", "handleMessage: "+popupIntent.getStringExtra("알림메세지"));
            }else {

                popupIntent.putExtra("알림메세지", "일간 스케쥴이 초기화 되었습니다");

//                Log.d("서비스 번들2", "handleMessage: "+popupIntent.getStringExtra("알림메세지"));
            }

            PendingIntent pendingIntent =
                    PendingIntent.getActivity(getApplicationContext(), 0, popupIntent, PendingIntent.FLAG_MUTABLE | PendingIntent.FLAG_UPDATE_CURRENT);

            try {
                pendingIntent.send();
            } catch (Exception e) {

            }


        }
    }
}

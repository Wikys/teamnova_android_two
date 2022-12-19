package com.example.teamnova_android_two;

import static com.example.teamnova_android_two.Main.Main.db_Reset;
import static com.example.teamnova_android_two.Main.Main.dq_Reset;
import static com.example.teamnova_android_two.Main.Main.wb_Reset;
import static com.example.teamnova_android_two.Main.Main.wq_Reset;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;


import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.teamnova_android_two.회원가입.MainActivity;

import java.util.Calendar;

public class alarm extends BroadcastReceiver {
    Calendar 요일 = Calendar.getInstance();



    @Override
    public void onReceive(Context context, Intent intent) {

        Intent n_Move = new Intent(context, MainActivity.class); //노티피케이션 발동시 이동할액티비티
        n_Move.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //액티비티 흐름제어//새액티비티추가
        PendingIntent pn_Move = PendingIntent.getActivity(context, 0, n_Move, PendingIntent.FLAG_IMMUTABLE);
        //특정시점에 intent 실행 예약 // 앱이 꺼져있어도 원격으로 켜질수있게해줌
        dailyNotificationChannel(context); // 채널생성 메소드 호출

        //알림 컨텐츠,채널,아이콘등 설정
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "dayReset"); //채널설정
        builder.setSmallIcon(R.drawable.icon); // 작은 아이콘
        if(요일.get(Calendar.DAY_OF_WEEK) == 5){ //목요일이면 주간초기화
            builder.setContentTitle("초기화알림 (주간)"); // 제목
            builder.setContentText("목요일이 되어 주간일정이 초기화 되었습니다"); //내용
            wq_Reset = true;
            wb_Reset = true;

        }else {
            builder.setContentTitle("초기화알림 (일간)"); // 제목
            builder.setContentText("날짜가 바뀌어 일정이 초기화 되었습니다"); //내용
            dq_Reset = true;
            db_Reset = true;

        }

        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT); //알림 우선순위
        builder.setContentIntent(pn_Move);
        builder.setAutoCancel(true); //탭하면 알림삭제


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);
        notificationManager.notify(0,builder.build()); //알림아이디 저장 0




    }
    private void dailyNotificationChannel(Context context){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ //오레오버전 미만에서는 차단
            CharSequence name = "dayReset";  //채널이름
            String description = "dayReset"; //채널 설명
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("dayReset", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel); // 채널생성

        }
    }




}

package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Lifecycle;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver alarm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Intent n_Move = new Intent(MainActivity.this, MainActivity.class); //노티피케이션 발동시 이동할액티비티
//        n_Move.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); //액티비티 흐름제어//새액티비티추가
//        PendingIntent pn_Move = PendingIntent.getActivity(MainActivity.this, 0, n_Move,0);
//        //특정시점에 intent 실행 예약 // 앱이 꺼져있어도 원격으로 켜질수있게해줌
//        dailyNotificationChannel(); // 채널생성 메소드 호출 //나중에 이거 조건문으로 알람매니저랑 연동
//
//        //알림 컨텐츠,채널,아이콘등 설정
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "dayReset"); //채널설정
//        builder.setSmallIcon(R.drawable.icon); // 작은 아이콘
//        builder.setContentTitle("초기화알림 (일간)"); // 제목
//        builder.setContentText("날짜가 바뀌어 일정이 초기화 되었습니다"); //내용
//        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT); //알림 우선순위
//        builder.setContentIntent(pn_Move);
//        builder.setAutoCancel(true); //탭하면 알림삭제
//
//
//        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(MainActivity.this);
//        notificationManager.notify(0,builder.build()); //알림아이디 저장 0

        Button login_button = (Button) MainActivity.this.findViewById(R.id.login_button);
        TextView id = (TextView) MainActivity.this.findViewById(R.id.로그인);
        TextView ps = (TextView) MainActivity.this.findViewById(R.id.비밀번호);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id.getText().toString().equals("ayc0812") && ps.getText().toString().equals("111222")){
                    Toast.makeText(MainActivity.this, "로그인에 성공하였습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "아이디와 비밀번호를 확인 해주세요", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
//    private void dailyNotificationChannel(){
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ //오레오버전 미만에서는 차단
//            CharSequence name = "dayReset";  //채널이름
//            String description = "dayReset"; //채널 설명
//            int importance = NotificationManager.IMPORTANCE_DEFAULT;
//            NotificationChannel channel = new NotificationChannel("dayReset", name, importance);
//            channel.setDescription(description);
//
//            NotificationManager notificationManager = getSystemService(NotificationManager.class);
//            notificationManager.createNotificationChannel(channel);
//
//        }
//    }

}

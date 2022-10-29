package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver alarm;


//    @Override
//    protected void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dailyNotificationChannel(); // 채널생성 메소드 호출


        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "dayReset");
        builder.setSmallIcon(R.drawable.icon); // 작은 아이콘
        builder.setContentTitle("초기화알림 (일간)"); // 제목
        builder.setContentText("날짜가 바뀌어 일정이 초기화 되었습니다"); //내용
        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT); //알림 우선순위
        alarm = new alarm();

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
    private void dailyNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){ //오레오버전 미만에서는 차단
            CharSequence name = "dayReset";  //채널이름
            String description = "dayReset"; //채널 설명
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("dayReset", name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);

        }
    }

}

package com.example.teamnova_android_two;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Lifecycle;

import android.app.Activity;
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

    ActivityResultLauncher<Intent> receive_Id_Result = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //겟엑스트라 입력
                    }
                }
            });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button login_button = (Button) MainActivity.this.findViewById(R.id.login_button);
        TextView id = (TextView) MainActivity.this.findViewById(R.id.아이디);
        TextView ps = (TextView) MainActivity.this.findViewById(R.id.비밀번호);
        Button sign_Up_Button = (Button) MainActivity.this.findViewById(R.id.sign_up_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id.getText().toString().equals("ayc0812") && ps.getText().toString().equals("111222")) {
                    Toast.makeText(MainActivity.this, "로그인에 성공하였습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "아이디와 비밀번호를 확인 해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sign_Up_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, sign_up.class);
                receive_Id_Result.launch(intent);
            }
        });

    }


}
//데이터 단방향전송할까하다가
//그렇게되면 스타트액티비티로 다시 돌아와야하는데 생명주기꼬임
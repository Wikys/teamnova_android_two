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
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements Serializable {
    private BroadcastReceiver alarm;
    ArrayList<String> 아이디 = new ArrayList<>(); //아이디 저장리스트
    ArrayList<String> 닉네임 = new ArrayList<>(); //닉네임 저장리스트
    ArrayList<String> 비밀번호 = new ArrayList<>(); //비밀번호 저장리스트
    Uri uri; //이미지정보

    ActivityResultLauncher<Intent> receive_Id_Result = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        //겟엑스트라 입력
                        Intent 계정정보 = result.getData();
                        아이디 = (ArrayList<String>)계정정보.getSerializableExtra("아이디");
                        닉네임 = (ArrayList<String>)계정정보.getSerializableExtra("닉네임");
                        비밀번호 = (ArrayList<String>)계정정보.getSerializableExtra("비밀번호");
                        uri = Uri.parse(계정정보.getStringExtra("uri")); //parse -> 스트링문자열을 Uri객체로 변환
                    }
                }
            });



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate: ");


        Button login_button = (Button) MainActivity.this.findViewById(R.id.login_button);
        TextView id = (TextView) MainActivity.this.findViewById(R.id.아이디);
        TextView ps = (TextView) MainActivity.this.findViewById(R.id.비밀번호);
        Button sign_Up_Button = (Button) MainActivity.this.findViewById(R.id.sign_up_button);

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (아이디.contains(id.getText().toString()) && 비밀번호.contains(ps.getText().toString())) {
                    Toast.makeText(MainActivity.this, "로그인에 성공하였습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    //사진정보나 계정정보 넘기기 //
                    //단방향


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
                intent.putExtra("아이디", 아이디);
                intent.putExtra("닉네임", 닉네임);
                receive_Id_Result.launch(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        Log.d("MainActivity", "onStart: ");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d("MainActivity", "onResume: ");
        //온리줌에서 새로 데이터 받아왔을때 갱신해줘야함

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("MainActivity", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("MainActivity", "onRestart: ");
        super.onRestart();
    }
}

//데이터 단방향전송할까하다가
//그렇게되면 스타트액티비티로 다시 돌아와야하는데 생명주기꼬임
package com.example.teamnova_android_two;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.lifecycle.Lifecycle;

import android.app.Activity;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.DialogInterface;
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
    Dialog dialog;

    ActivityResultLauncher<Intent> receive_Id_Result = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        //겟엑스트라 입력
                        Intent 계정정보 = result.getData();
                        아이디 = (ArrayList<String>) 계정정보.getSerializableExtra("아이디");
                        닉네임 = (ArrayList<String>) 계정정보.getSerializableExtra("닉네임");
                        비밀번호 = (ArrayList<String>) 계정정보.getSerializableExtra("비밀번호");
                        uri = 계정정보.getParcelableExtra("uri"); // paracelable -> 객체전달

                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate: ");
        dialog = new Dialog(MainActivity.this);


        Button login_button = (Button) MainActivity.this.findViewById(R.id.login_button);
        TextView id = (TextView) MainActivity.this.findViewById(R.id.아이디);
        TextView ps = (TextView) MainActivity.this.findViewById(R.id.비밀번호);
        Button sign_Up_Button = (Button) MainActivity.this.findViewById(R.id.sign_up_button);
        Button 테스트 = (Button) MainActivity.this.findViewById(R.id.테스트);
        Button 테스트2 = (Button) MainActivity.this.findViewById(R.id.테스트2);

        테스트.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("앱 끈다?")
                        .setMessage("진짜 끈다?")
                        .setPositiveButton("꺼라", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "안 끔", Toast.LENGTH_SHORT).show();
                            }
                        });


                AlertDialog msgDlg = msgBuilder.create();
                msgDlg.show();
//                Intent intent = new Intent(MainActivity.this, test_activity.class);
//                startActivity(intent);
            }
        });
        테스트2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {//로그인버튼 눌렀을때
            @Override
            public void onClick(View view) {

                if (아이디.contains(id.getText().toString()) && 비밀번호.contains(ps.getText().toString())) {
                    Toast.makeText(MainActivity.this, "로그인에 성공하였습니다", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    //사진정보나 계정정보 넘기기 //
                    //단방향
                    intent.putExtra("아이디", 아이디);
                    intent.putExtra("닉네임", 닉네임);
                    intent.putExtra("사진", uri);


                    startActivity(intent);


                } else if (true) { //테스트용 (매번 계정만들기 힘듬)
                    Intent intent = new Intent(MainActivity.this, Main.class);
                    아이디.add("안연창");
                    닉네임.add("팀노바");
                    intent.putExtra("아이디", 아이디);
                    intent.putExtra("닉네임", 닉네임);
                    intent.putExtra("사진", uri);
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
        TextView id = (TextView) MainActivity.this.findViewById(R.id.아이디);
        TextView ps = (TextView) MainActivity.this.findViewById(R.id.비밀번호);
        //온리줌에서 새로 데이터 받아왔을때 갱신해줘야함
        if (아이디.size() > 0 && 비밀번호.size() > 0) {
            id.setText(아이디.get(0));
            ps.setText(비밀번호.get(0));
        }

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


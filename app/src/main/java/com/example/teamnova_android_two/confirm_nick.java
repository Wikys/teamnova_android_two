package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class confirm_nick extends Activity {

    boolean 허가 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없앰
        setContentView(R.layout.confirm_nick);

        TextView 중복텍스트 = findViewById(R.id.중복확인텍스트);
        Button 중복확인 = findViewById(R.id.중복확인버튼);
        TextView 메세지 = findViewById(R.id.메세지);
        Button 종료버튼 = findViewById(R.id.종료버튼);
        Button 확인버튼 = findViewById(R.id.확인버튼);
        Intent 텍스트값 = getIntent(); // 인텐트에 저장한 데이터 받아오기
        ArrayList<String> 닉네임 = (ArrayList<String>)텍스트값.getSerializableExtra("nick_list");

        중복텍스트.setText(텍스트값.getStringExtra("nick")); //키값으로 데이터 찾아서 대입

        중복확인.setOnClickListener(new View.OnClickListener() { //중복확인버튼 눌렀을때 동작하는 리스너
            @Override
            public void onClick(View view) {
                허가 = false;
                String 텍스트 = 중복텍스트.getText().toString();
                String 비교값 = 텍스트.trim();
                if (비교값.length() == 0) { //문자열에서 공백제거하고 길이재서 확인
                    메세지.setTextColor(Color.parseColor("#ff0000"));
                    메세지.setText("닉네임을 입력해주세요");
                } else if (닉네임.contains(비교값)) { //해시맵에 이미 닉네임 존재하면 로직
                    메세지.setTextColor(Color.parseColor("#ff0000"));
                    메세지.setText("이미 존재하는 닉네임입니다");
                } else if (!(닉네임.contains(비교값))) { //해시맵에 닉네임 존재하지않으면 로직
                    메세지.setTextColor(Color.parseColor("#00ff80"));
                    메세지.setText("사용 가능한 닉네임입니다");
                    중복텍스트.setEnabled(false); // 중복된 닉네임 없을시에 텍스트뷰 조작막힘
                    허가 = true;
                }
            }
        });
        확인버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(허가 == true){ // 허가라는 변수로 사용가능한 닉네임인지 판별하고 가능할때
                    String 텍스트 = 중복텍스트.getText().toString();
                    Intent NICK확정 = new Intent(confirm_nick.this, sign_up.class);
                    NICK확정.putExtra("NICK확정", 텍스트); //닉네임을 회원가입 액티비티에 보내주기
                    setResult(RESULT_OK,NICK확정);
                    finish();


                }else{
                    Toast.makeText(confirm_nick.this, "아이디를 확인해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //아이디 입력하고 확인누르면 액티비티가 꺼지면서 정보이동 -> 사인업으로
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}

//중복확인버튼 누르면 텍스트로 사용가능여부 띄우기
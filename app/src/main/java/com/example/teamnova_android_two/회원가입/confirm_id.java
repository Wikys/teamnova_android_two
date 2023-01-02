package com.example.teamnova_android_two.회원가입;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamnova_android_two.R;

import java.util.ArrayList;

public class confirm_id extends Activity {
    boolean 허가 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없앰
        setContentView(R.layout.confirm_id);
        TextView 중복텍스트 = findViewById(R.id.중복확인텍스트);
        Button 중복확인 = findViewById(R.id.중복확인버튼);
        TextView 메세지 = findViewById(R.id.메세지);
        Button 종료버튼 = findViewById(R.id.종료버튼);
        Button 확인버튼 = findViewById(R.id.확인버튼);
        Intent 텍스트값 = getIntent(); // 인텐트에 저장한 데이터 받아오기
        ArrayList<String> 아이디 = (ArrayList<String>)텍스트값.getSerializableExtra("id_list");

        중복텍스트.setText(텍스트값.getStringExtra("id")); //키값으로 데이터 찾아서 대입

        중복확인.setOnClickListener(new View.OnClickListener() { //중복확인버튼 눌렀을때 동작하는 리스너
            @Override
            public void onClick(View view) {
                허가 = false;
                String 텍스트 = 중복텍스트.getText().toString();
                String 비교값 = 텍스트.trim();
                if (비교값.length() == 0) { //문자열에서 공백제거하고 길이재서 확인
                    메세지.setTextColor(Color.parseColor("#ff0000"));
                    메세지.setText("아이디를 입력해주세요");
                } else if (아이디.contains(비교값)) { //해시맵에 이미 아이디가 존재하면 로직
                    메세지.setTextColor(Color.parseColor("#ff0000"));
                    메세지.setText("이미 존재하는 아이디입니다");
                } else if (!(아이디.contains(비교값))) { //해시맵에 아이디가 존재하지않으면 로직
                    메세지.setTextColor(Color.parseColor("#00ff80"));
                    메세지.setText("사용 가능한 아이디입니다");
                    중복텍스트.setEnabled(false); // 중복된 아이디가 없을시에 텍스트뷰 조작막힘
                    허가 = true;
                }
            }
        });


        확인버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(허가 == true){ // 허가라는 변수로 사용가능한 아이디인지 판별하고 가능할때
                    String 텍스트 = 중복텍스트.getText().toString();
                    Intent ID확정 = new Intent(confirm_id.this, sign_up.class);
                    ID확정.putExtra("ID확정", 텍스트); //아이디 회원가입 액티비티에 보내주기
                    setResult(RESULT_OK,ID확정);
                    finish();


                }else{
                    Toast.makeText(confirm_id.this, "아이디를 확인해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //아이디 입력하고 확인누르면 액티비티가 꺼지면서 정보이동 -> 사인업으로





        종료버튼.setOnClickListener(new View.OnClickListener() { //x버튼 누르면 저장이나 별도의 로직없이 그냥 화면꺼줌
            @Override
            public void onClick(View view) {
                finish();
            }
        });


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


package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class sign_up extends Activity {
    Map<String, String> 아이디 = new HashMap<>();
    Map<String, String> 비밀번호 = new HashMap<>();
    Map<String, String> 닉네임 = new HashMap<>();
    Map<String, String> 사진 = new HashMap<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없앰
        setContentView(R.layout.sign_up);
        TextView id = (TextView) findViewById(R.id.id_text); //아이디
        TextView ps = (TextView) findViewById(R.id.ps_text); //비밀번호
        TextView confirm_ps = (TextView) findViewById(R.id.confirm_ps); //비밀번호 확인
        TextView nick = (TextView) findViewById(R.id.닉네임텍스트); //닉네임
        Button 사진등록 = (Button) findViewById(R.id.사진버튼); //사진등록버튼
        Button 완료버튼 = (Button) findViewById(R.id.완료버튼); //가입완료버튼
        Button 종료버튼 = (Button) findViewById(R.id.종료버튼); //종료버튼
        Button ID중복 = (Button) findViewById(R.id.ID중복); //ID중복확인버튼
        Button 닉중복 = (Button) findViewById(R.id.닉중복); //닉네임중복확인버튼

        Intent receive_Id = getIntent(); // 아이디중복확인에서 받아온값


        ID중복.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent id전달 = new Intent(sign_up.this, confirm_id.class);
                //입력한 아이디값을 중복확인 액티비티에 넘김
                String 중복 = id.getText().toString();
                id전달.putExtra("id", 중복); //에딧텍스트값 저장

                startActivity(id전달); // 중복확인 액티비티로 이동

            }
        });

        닉중복.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent 닉전달 = new Intent(sign_up.this,confirm_nick.class);
                startActivity(닉전달);

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

//비밀번호 두개 일치하면 일치여부 텍스트로 띄우기

//아이디값을 해쉬맵에 저장해서 중복액티비티에서 에딧텍스트로 들어온값이랑 비교

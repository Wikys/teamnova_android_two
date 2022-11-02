package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
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

    TextView id = (TextView) findViewById(R.id.id_text); //아이디
    TextView ps = (TextView) findViewById(R.id.ps_text); //비밀번호
    TextView confirm_ps = (TextView) findViewById(R.id.confirm_ps); //비밀번호 확인
    TextView nick = (TextView) findViewById(R.id.닉네임텍스트); //닉네임
    Button 사진등록 = (Button) findViewById(R.id.사진버튼); //사진등록버튼
    Button 완료버튼 = (Button) findViewById(R.id.완료버튼); //가입완료버튼
    Button 종료버튼 = (Button) findViewById(R.id.종료버튼); //종료버튼
    Button ID중복 = (Button) findViewById(R.id.ID중복); //ID중복확인버튼
    Button 닉중복 = (Button) findViewById(R.id.닉중복); //닉네임중복확인버튼


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없앰
        setContentView(R.layout.sign_up);




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


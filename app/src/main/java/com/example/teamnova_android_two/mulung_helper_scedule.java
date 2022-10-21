package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class mulung_helper_scedule extends Activity {

    ArrayList<String> buttonNameList = new ArrayList<>(); //만든 버튼 이름들이 저장되는곳
    private LinearLayout 저장목록; //버튼 추가되는 레이아웃
    Button addBtn, removeBtn; // 버튼 추가 삭제 버튼

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mulung_helper_scedule);

        Button save = (Button) findViewById(R.id.저장버튼);
        save.setOnClickListener(new View.OnClickListener() { //버튼생성 이벤트
            @Override
            public void onClick(View view) {
                //생성된 버튼이름을 어레이리스트와 비교해서
                //기존에 있던 버튼 제목지정한거랑 중복되면 경고(시간도)
                //아니면 생성
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
package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class mulung_helper_scedule extends Activity {
    private final int id = 0x8000; //버튼아이디 변수
    private Integer numButton = 0; // 버튼의 개수
    ArrayList<String> buttonNameList = new ArrayList<>(); //만든 버튼 이름들이 저장되는곳
    //버튼 추가되는 레이아웃


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mulung_helper_scedule);

        Button save = (Button) findViewById(R.id.저장버튼);

        save.setOnClickListener(new View.OnClickListener() { //버튼생성 이벤트
            @Override
            public void onClick(View view) {
                newSaveList();
                //if
                //생성된 버튼이름을 어레이리스트와 비교해서
                //기존에 있던 버튼 제목지정한거랑 중복되면 경고(시간도)
                //아니면 생성
            }
        });

        Button exit = (Button) findViewById(R.id.종료버튼);
        exit.setOnClickListener(new View.OnClickListener() { //x버튼 눌렀을때 꺼지게하기 onstop
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button delete = (Button) findViewById(R.id.삭제버튼);

        delete.setOnClickListener(new View.OnClickListener() { //저장한버튼 삭제
            @Override
            public void onClick(View view) {


            }
        });
    }

    private void newSaveList() { // 저장목록에 버튼추가하는 메소드
        LinearLayout 저장목록 = (LinearLayout) findViewById(R.id.저장목록); // 버튼이 생성될 레이아웃
        EditText title = (EditText) findViewById(R.id.제목); //사용자가 정한 제목
        numButton++; // 버튼아이디 뒤에 붙일 숫자
        Button savelist = new Button(this); // 버튼생성
        savelist.setText(title.getText()); //제목에 입력한 텍스트를 버튼이름으로 지정
        savelist.setId(id+numButton); //제목에 입력한 텍스트를 아이디로 지정
        저장목록.addView(savelist, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        //시간이나 제목이 동일하면 호출불가하게 설정
        //텍스트내용이랑 시간정보도 보내줘야함
    }
    private void removeList(){
        if( numButton <= 0){ // 만약 View가 0개 이하일 때
            return;
        }// 클릭한 뷰의 아이디를 받아와서 삭제해줘야함

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

    @Override
    protected void onStop() { // 온스탑이될때 저장목록에 있는 시간,메모정보를 메인에 쏴줘야함
        super.onStop();
    }
}
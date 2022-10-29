package com.example.teamnova_android_two;

import android.app.AlarmManager;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class Main extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);




        LinearLayout dqbtn = (LinearLayout) Main.this.findViewById(R.id.일일퀘스트); //일일퀘스트 이동버튼
        dqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dqmove = new Intent(Main.this, daily_quest.class);
                startActivity(dqmove);
            }
        });
        LinearLayout dbbtn = (LinearLayout) findViewById(R.id.일일보스); //데일리보스 이동버튼

        dbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbmove = new Intent(Main.this, daily_boss.class);
                startActivity(dbmove);
            }
        });
        LinearLayout wqbtn = (LinearLayout) findViewById(R.id.주간퀘스트); //위클리퀘스트 이동버튼

        wqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wqmove = new Intent(Main.this, weekly_quest.class);
                startActivity(wqmove);
            }
        });

        LinearLayout wbbtn = (LinearLayout) findViewById(R.id.주간보스); //위클리보스 이동버튼

        wbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wbmove = new Intent(Main.this, weekly_boss.class);
                startActivity(wbmove);
            }
        });

        LinearLayout timerbtn = (LinearLayout) findViewById(R.id.재획타이머); // 재획타이머 이동버튼

        timerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent timermove = new Intent(Main.this, timer.class);
                startActivity(timermove);
            }
        });
        LinearLayout schebtn = (LinearLayout) findViewById(R.id.일정표); // 일정표 이동버튼

        schebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schemove = new Intent(Main.this, schedule.class);
                startActivity(schemove);
            }
        });
        LinearLayout seedbtn = (LinearLayout) findViewById(R.id.시드도우미); // 시드도우미 이동버튼

        seedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seedmove = new Intent(Main.this, seed_helper.class);
                startActivity(seedmove);
            }
        });
        LinearLayout mubtn = (LinearLayout) findViewById(R.id.무릉도우미); // 무릉도우미 이동버튼

        mubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mumove = new Intent(Main.this, mulung_helper.class);
                startActivity(mumove);
            }
        });

        //알람매니저로 일간,주간에 신호를줌
        //+일정표까지 신호날려줌
        //각각 클래스에서 받아서 상황에맞게 처리 (체크박스의경우엔 체크를 푼다던가)
        //일정표에서는 날짜가 바뀌면 메모내용이 해당날짜에 맞게 바뀐다던가 하는식으로
        //ㅇ

        //알람매니저의 역할은 그냥 앱이 꺼져있어도 지정된 시간대에 신호(이벤트)를주는 역할뿐
        //이 신호를 받아서 브로드캐스트리시버가 작동한다


    }
}

package com.example.teamnova_android_two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class timer extends AppCompatActivity {
    int 분타이머 = 1; //120 초기값
    int 초타이머 = 2; //0 초기값
    int 디폴트분 = 1; // 기본값 (구분용)
    int 디폴트초 = 2; // 기본값

    private Timer m_timer; //타이머
    private TimerTask mt_timer;
    Boolean end = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
        Log.d("timer", "onCreate: ");
        Button 시작 = (Button) findViewById(R.id.시작);
        TextView 타이머 = (TextView) findViewById(R.id.타이머토글);
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체
        Button 중단 = (Button) findViewById(R.id.중단); // 타이머 중단버튼


        시작.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (end == false) {
                    end = true;
                    timer();
                } else {
                    Toast.makeText(timer.this, "이미 작동중 입니다", Toast.LENGTH_SHORT).show();
                }

            }
        });


        중단.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(m_timer != null && mt_timer != null){
                    timer_Stop();
                }
                else {
                    Toast.makeText(timer.this, "실행중인 타이머가 없습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void timer() { //타이머 생성 메소드

        TextView 타이머 = (TextView) findViewById(R.id.타이머토글);
        m_timer = new Timer();
        mt_timer = new TimerTask() {
            @Override
            public void run() {
                if (초타이머 > 0 || 분타이머 > 0) {
                    초타이머--;
                    if (초타이머 < 0 && 분타이머 > 0) {
                        분타이머--;
                        초타이머 = 디폴트초; // 59
                    }
                    타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
                } else {
                    timer_Stop();
                }

            }

        };
        m_timer.schedule(mt_timer, 1000, 1000);

    }

    private void timer_Stop() { //타이머 중단 메소드
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체

        TextView 타이머 = (TextView) findViewById(R.id.타이머토글);

        end = false;

        분타이머 = 디폴트분;
        초타이머 = 디폴트초;
        타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
        진동.vibrate(500);
        timer.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(timer.this, "재획타이머가 종료되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
        m_timer.cancel();
        mt_timer.cancel();
        m_timer = null;
        mt_timer = null;
    }


    @Override
    protected void onStop() {
        Log.d("timer", "onStop: ");

        super.onStop();
    }

    @Override
    protected void onStart() {
        Log.d("timer", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("timer", "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() { //필요없는 리소스 정리
        Log.d("timer", "onPause: ");
        if (m_timer != null) {
            m_timer.cancel();//팅기거나 뒤로가기눌렀을때 타이머중단
            end = false; // 타이머종료 구분 변수 초기화
        }
        if (mt_timer != null) {
            mt_timer.cancel();
        }

        //나중에 서비스나 핸들러 적용할떄 화면안보고있어도 타이머 자동으로 돌아가게 해두기
        //앱이 종료되기전에 타이머가 꺼지게함
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        Log.d("timer", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("timer", "onRestart: ");

        if (분타이머 != 디폴트분 || 초타이머 != 디폴트초) {
            if (end == false) {
                end = true;
                timer();
            }
            // 저장된 변수(시간값)가 기본값이 아니면 타이머 도중 홈버튼을 눌렀다고 판단해 재시작
        }
        super.onRestart();
    }
}
package com.example.teamnova_android_two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    //    private Timer timer; //분타이머
//    private TimerTask t_Timer;
    private Timer m_timer; //타이머
    private TimerTask mt_timer;
    Button 시작 = (Button) findViewById(R.id.시작);
    TextView 타이머 = (TextView) findViewById(R.id.타이머토글);
    String 백업본 = (String) 타이머.getText();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
//        String data = savedInstanceState.getString(백업본); //오류나면
//        타이머.setText(data); //이부분 삭제


        시작.setOnClickListener(new View.OnClickListener() { //시작버튼
            @Override
            public void onClick(View view) {
                if (타이머.getText().equals("120분 0초")) {
                    int 시작분 = 분타이머;
                    int 시작초 = 초타이머;
                    m_timer = new Timer();
                    mt_timer = new TimerTask() {
                        @Override
                        public void run() {
                            if (초타이머 > 0 || 분타이머 > 0) {
                                초타이머--;
                                if (초타이머 < 0 && 분타이머 > 0) {
                                    분타이머--;
                                    초타이머 = 5; //59
                                }
                                타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
                            } else {
                                try {
                                    분타이머 = 시작분;
                                    초타이머 = 시작초;
                                    타이머.setText("120분 0초");
                                    m_timer.cancel();
                                } catch (Exception e) {
                                    System.out.println("분타이머(태스크)| 인터럽트 예외 발생");
                                }
                            }
                        }
                    };
                    m_timer.schedule(mt_timer, 0, 1000);
                } else {
                    Toast.makeText(timer.this, "이미 작동중 입니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Button 중단 = (Button) findViewById(R.id.중단);

        중단.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 중단버튼
                if (!타이머.getText().equals("120분 0초")) {
                    m_timer.cancel();
                    타이머.setText("120분 0초");
                    Toast.makeText(timer.this, "재획타이머가 중단되었습니다", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(timer.this, "타이머가 작동중이 아닙니다", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    protected void onStop() {
        m_timer.cancel();//팅기거나 뒤로가기눌렀을때 타이머중단
        //남은시간 번들에 저장해놔야할듯
        //나중에 서비스나 핸들러 적용할떄 화면안보고있어도 타이머 자동으로 돌아가게 해두기

        super.onStop();
    }

//    @Override
//    protected void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        String 백업 = 타이머.getText().toString();
//        outState.putString(백업본, 백업); // 백업본 변수가아니라 다른걸로 해야할수도
//
//    } 이걸로 저장기능 구현 불가능
}
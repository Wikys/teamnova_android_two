package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;


public class mulung_helper extends AppCompatActivity {
    int 분타이머 = 1; //14 초기값
    int 초타이머 = 2; //60 초기값
    private Timer m_timer; //분타이머
    private TimerTask mt_timer;

    private boolean timer_s = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mulung_helper);
        ToggleButton mulung_timer = (ToggleButton) findViewById(R.id.시작);
        TextView 타이머 = (TextView) findViewById(R.id.타이머);

        mulung_timer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { //토글버튼을 눌렀을때 작동이벤트

                if (timer_s == true) {
                    m_timer = new Timer(); //타이머객체는 재활용이 안되므로 클릭과동시에 생성
                    mt_timer = new TimerTask() {
                        @Override
                        public void run() {
                                if (초타이머 > 0 || 분타이머 > 0) {
                                    초타이머--;
                                    if (초타이머 < 0 && 분타이머 > 0) {
                                        분타이머--;
                                        초타이머 = 2; //59
                                    }
                                    타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
                                } else {
                                    분타이머 = 14;
                                    초타이머 = 60;
                                    타이머.setText("15분 0초");
                                    timer_s = false;
                                    m_timer.cancel();
                                    // 조건 만족되면 나와서 체크버튼 원상복구
                                }
                        }
                    };
                    m_timer.schedule(mt_timer, 0, 1000);
                }
                //끝나고 토글버튼 원위치 시켜놓으려했지만 메인스레드에서만 ui 조작가능
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

    }
}
package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class timer extends AppCompatActivity {
    int 분타이머 = 1; //14 초기값
    int 초타이머 = 2; //60 초기값
//    private Timer timer; //분타이머
//    private TimerTask t_Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);

        Button 시작 = (Button) findViewById(R.id.시작);
        TextView 타이머 = (TextView) findViewById(R.id.타이머토글);

        시작.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            while(true){
                if(분타이머 >= 0 && 초타이머 >0){
                    초타이머 --;
                    타이머.setText(분타이머+"분 "+초타이머+"초");
                }
                else if (분타이머 >=0 && 초타이머 == 0){
                    분타이머 --;
                    초타이머 = 60;
                    타이머.setText(분타이머+"분 "+초타이머+"초");
                }
                else if(분타이머 == 0 && 초타이머 == 0){
                    Toast.makeText(timer.this, "타이머 종료", Toast.LENGTH_SHORT).show();
                    return;
                }
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

            }
            }
        });
    }
}
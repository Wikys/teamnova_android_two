package com.example.teamnova_android_two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class timer extends AppCompatActivity {
    int 분타이머 = 1; //120 초기값
    int 초타이머 = 2; //0 초기값
    int 디폴트분 = 1; // 기본값 (구분용)
    int 디폴트초 = 2; // 기본값

    int 익골분 = 1;
    int 익골초 = 2;
    int 익골디폴트분 = 1;
    int 익골디폴트초 = 2;

    private Timer m_timer; //타이머
    private TimerTask mt_timer;
    private Timer eg_Timer; //익골타이머
    private TimerTask egt_Timer;

    Boolean end = false;
    Boolean extremeEnd = false;
    ImageView 익골,경축비,경뿌,경쿠,유부,유행;

    TextView 익골타이머,경축비타이머,경뿌타이머,경쿠타이머,유부타이머,유행타이머,알림;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer);
        Log.d("timer", "onCreate: ");
        Button 시작 = (Button) findViewById(R.id.시작);
        TextView 타이머 = (TextView) findViewById(R.id.타이머토글);
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체
        Button 중단 = (Button) findViewById(R.id.중단); // 타이머 중단버튼
        익골 = (ImageView) this.findViewById(R.id.익골);//익스트림 골드 이미지뷰
        경축비 = (ImageView) this.findViewById(R.id.경축비);
        경뿌 = (ImageView) this.findViewById(R.id.경뿌);
        경쿠 = (ImageView) this.findViewById(R.id.경쿠);
        유부 = (ImageView) this.findViewById(R.id.유부);
        유행 = (ImageView) this.findViewById(R.id.유행);
        익골타이머 = (TextView) this.findViewById(R.id.익골타이머);
        경축비타이머 = (TextView) this.findViewById(R.id.경축비타이머);
        경뿌타이머 = (TextView) this.findViewById(R.id.경뿌타이머);
        경쿠타이머 = (TextView) this.findViewById(R.id.경쿠타이머);
        유부타이머 = (TextView) this.findViewById(R.id.유부타이머);
        유행타이머 = (TextView) this.findViewById(R.id.유행타이머);
        알림 = (TextView) this.findViewById(R.id.알림);


        익골.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(익골타이머.getVisibility() == v.VISIBLE && extremeEnd == true) {
                    익골타이머.setVisibility(v.INVISIBLE);
                    //중단코드 작성
                        Extreme_Gold_Timer_Stop();


                }else if(익골타이머.getVisibility() != v.VISIBLE && extremeEnd == false){
                    //시작코드
                    익골타이머.setVisibility(v.VISIBLE);
                        extremeEnd = true;
                        Extreme_Gold_Timer();
                }


            }
        });

        시작.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (end == false) {
                    end = true;
                    timer();
                } else {
                    Toast.makeText(timer.this, "(메인타이머)이미 작동중 입니다", Toast.LENGTH_SHORT).show();
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
                        초타이머--;
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
                Toast.makeText(timer.this, "(재화획득의 비약)타이머가 종료되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
        m_timer.cancel();
        mt_timer.cancel();
        m_timer = null;
        mt_timer = null;
    }
    private void Extreme_Gold_Timer() { //타이머 생성 메소드

        익골타이머 = (TextView) findViewById(R.id.익골타이머);
        eg_Timer = new Timer();
        egt_Timer = new TimerTask() {
            @Override
            public void run() {

                if (익골초 > 0 || 익골분 > 0) {
                    익골초--;
                    if (익골초 < 0 && 익골분 > 0) {
                        익골초--;
                        익골초 = 익골디폴트초; // 59
                    }
                    익골타이머.setText(익골분 + "분" + " " + 익골초 + "초");
                } else {
                    알림.setText("익스트림 골드 종료");
                    Extreme_Gold_Timer_Stop();
                }

            }

        };
        eg_Timer.schedule(egt_Timer, 1000, 1000);
    }
    private void Extreme_Gold_Timer_Stop() { //타이머 중단 메소드
        Vibrator 익골진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체

        익골타이머 = (TextView) findViewById(R.id.익골타이머);

        extremeEnd = false;

        익골분 = 익골디폴트분;
        익골초 = 익골디폴트초;
        익골타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
        익골진동.vibrate(500);
        timer.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(timer.this, "(익스트림골드)타이머가 종료되었습니다", Toast.LENGTH_SHORT).show();
            }
        });
        eg_Timer.cancel();
        egt_Timer.cancel();
        eg_Timer = null;
        egt_Timer = null;
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
//        if (m_timer != null) {
//            m_timer.cancel();//팅기거나 뒤로가기눌렀을때 타이머중단
//            end = false; // 타이머종료 구분 변수 초기화
//        }
//        if (mt_timer != null) {
//            mt_timer.cancel();
//        }
//
//        //나중에 서비스나 핸들러 적용할떄 화면안보고있어도 타이머 자동으로 돌아가게 해두기
//        //앱이 종료되기전에 타이머가 꺼지게함
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

//        if (분타이머 != 디폴트분 || 초타이머 != 디폴트초) {
//            if (end == false) {
//                end = true;
//                timer();
//            }
//            // 저장된 변수(시간값)가 기본값이 아니면 타이머 도중 홈버튼을 눌렀다고 판단해 재시작
//        }
        super.onRestart();
    }
}
package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class mulung_helper extends AppCompatActivity implements Serializable {
    int 분타이머 = 1; //14 초기값
    int 초타이머 = 5; //60 초기값
    private Timer m_timer; //타이머
    private TimerTask mt_timer;
    private Timer r_timer; //휴식타이머
    private TimerTask rt_timer;
    int 휴식 = 3; //10
    boolean 중복 = false;



//    Map<String, String> 제목 = new HashMap<>();
//    Map<String, String> 메모= new HashMap<>();
//    Map<String, String> 분 = new HashMap<>();
//    Map<String, String> 초 = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mulung_helper);
        Log.d("LC", "onCreate: ");

        Intent 저장목록 = getIntent(); // 스케쥴에서 등록해논 데이터 가져옴
        //이부분 브로드캐스트로

        Map<String, String> 제목 = (HashMap<String, String>) 저장목록.getSerializableExtra("제목");
        Map<String, String> 메모 = (HashMap<String, String>) 저장목록.getSerializableExtra("메모");
        Map<String, String> 분 = (HashMap<String, String>) 저장목록.getSerializableExtra("분");
        Map<String, String> 초 = (HashMap<String, String>) 저장목록.getSerializableExtra("초");
        Map<String, String> 분초 = (HashMap<String, String>) 저장목록.getSerializableExtra("분초");


        TextView 타이머 = (TextView) findViewById(R.id.타이머);
        Button 시작하기 = (Button) findViewById(R.id.시작);
        TextView 준비 = (TextView) findViewById(R.id.준비);
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체

        시작하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (m_timer == null) {
                    if (rt_timer != null && r_timer != null) {
                        휴식 = 3; //10
                        중복 = false;
                        r_timer.cancel();
                        rt_timer.cancel();
                    }
                    m_timer = new Timer();
                    mt_timer = new TimerTask() {
                        @Override
                        public void run() {
                            String 분텍스트 = Integer.toString(분타이머); //비교를위해 스트링으로 캐스팅
                            String 초텍스트 = Integer.toString(초타이머);
                            String 키합 = 분텍스트+초텍스트;
                            if (초타이머 > 0 || 분타이머 > 0) {
                                //이쯤에서 분 초 체크하고 셋텍스트?
                                if(분초.containsValue(키합)){

                                    keySet 키분석 = new keySet( 분텍스트,초텍스트,분초); //키를 찾아주는 클래스
                                    String 키 = 키분석.result(); // 분석된 키값을 변수에저장
                                    String 메모수정 = 메모.get(키); // 키값을 인자로주고 저장된 메모받아오기
//                                    준비.setText(메모수정); //텍스트뷰 메모수정인데 핸들러없어서 안됨

                                }


                                초타이머--;
                                if (초타이머 < 0 && 분타이머 > 0) {
                                    분타이머--;
                                    초타이머 = 5; //59
                                }
                                타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
                            } else {
                                try {
                                    분타이머 = 1; // 120
                                    초타이머 = 5; // 0
                                    타이머.setText("15분 0초");
                                    진동.vibrate(500);
                                    m_timer.cancel();
                                    mt_timer.cancel();
                                    m_timer = null;
                                    mt_timer = null;
                                } catch (Exception e) {
                                    //
                                }
                            }
                            //

                            //
                        }
                    };
                    m_timer.schedule(mt_timer, 0, 1000);
                } else {
                    Toast.makeText(mulung_helper.this, "이미 작동중 입니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button 휴식하기 = (Button) findViewById(R.id.휴식);

        휴식하기.setOnClickListener(new View.OnClickListener() { // 휴식버튼 눌렀을때 동작 (9초지연)
            @Override
            public void onClick(View view) {

                if (m_timer != null && mt_timer != null) { //타이머가 실행중이면 죽이고 진행
                    m_timer.cancel();
                    mt_timer.cancel();
                    m_timer = null;
                    mt_timer = null;
                    if (중복 == false) { // 휴식타이머가 죽었을때만 작동
                        중복 = true;

                        r_timer = new Timer();
                        rt_timer = new TimerTask() {
                            @Override
                            public void run() {
                                if (휴식 > 0) {
                                    휴식--;
                                    타이머.setText(휴식 + "초");
//                                    }
                                } else {

                                    try { //시간이 0이되거나, 시작하기를 다시눌렀을경우나 중단눌렀을때 대비
                                        타이머.setText(분타이머 + "분 " + 초타이머 + "초");
                                        휴식 = 3; //10
                                        중복 = false;
                                        r_timer.cancel();
                                        rt_timer.cancel();
                                        r_timer = null;
                                        rt_timer = null;
                                        시작하기.callOnClick();

                                    } catch (Exception e) {
                                        //
                                    }
                                }
                            }
                        };
                        r_timer.schedule(rt_timer, 0, 1000);
                    } else {
                        Toast.makeText(mulung_helper.this, "중복실행 불가합니다", Toast.LENGTH_SHORT).show();
                    }
//                    r_timer.schedule(rt_timer, 0, 1000);


                } else {
                    Toast.makeText(mulung_helper.this, "시작하기를 먼저 눌러주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });


        Button 중단하기 = (Button) findViewById(R.id.중단);
        중단하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 중단버튼
                if (!타이머.getText().equals("15분 0초") && m_timer != null) {
                    m_timer.cancel();
                    mt_timer.cancel();
                    m_timer = null;
                    mt_timer = null;
                    중복 = false;
                    분타이머 = 1;
                    초타이머 = 5;
                    타이머.setText("15분 0초");
                    Toast.makeText(mulung_helper.this, "무릉타이머가 중단되었습니다", Toast.LENGTH_SHORT).show();
                } else if (r_timer != null) { // 휴식타이머가 작동중일때는 여기로와서 중단
                    r_timer.cancel();
                    rt_timer.cancel();
                    r_timer = null;
                    rt_timer = null;
                    중복 = false;
                    분타이머 = 1;
                    초타이머 = 5;
                    타이머.setText("15분 0초");
                } else {
                    Toast.makeText(mulung_helper.this, "타이머가 작동중이 아닙니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button memo = (Button) findViewById(R.id.메모);
        memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent memo_move = new Intent(mulung_helper.this, mulung_helper_scedule.class);
                startActivity(memo_move);
            }
        });

    }

    @Override
    protected void onStart() {
        Log.d("LC", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("LC", "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("LC", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (m_timer != null) {
            m_timer.cancel();//팅기거나 뒤로가기눌렀을때 타이머중단
        }
        if (mt_timer != null) {
            mt_timer.cancel();
        }
        Log.d("LC", "타이머종료 ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("LC", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("LC", "onRestart: ");
        super.onRestart();
    }
    //온크리에이트가 단 한번만 실행되니까 거따가 코딩하기
}
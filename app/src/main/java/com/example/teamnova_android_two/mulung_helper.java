package com.example.teamnova_android_two;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
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
    //    int 분타이머 = 1; //14 초기값
//    int 초타이머 = 5; //60 초기값
//    private Timer m_timer; //타이머
//    private TimerTask mt_timer;
//    private Timer r_timer; //휴식타이머
//    private TimerTask rt_timer;
//    int 휴식 = 3; //10
//    boolean 중복 = false;
    int 분타이머 = 1; //120 초기값
    int 초타이머 = 2; //0 초기값
    int 디폴트분 = 1; // 기본값 (구분용)
    int 디폴트초 = 2; // 기본값
    int 휴식 = 3; // 휴식타이머용
    int 디폴트휴식 = 3; // 기본값

    private Timer m_timer; //타이머
    private TimerTask mt_timer;
    private Timer r_timer; //휴식타이머
    private TimerTask rt_timer;
    Boolean end = false;
    Boolean rest_End = false;
    Boolean end_Onstop = false;
    Boolean rest_End_Onstop = false;
    Boolean rest_Useable = false;

    Map<String, String> 제목 = new HashMap<>();
    Map<String, String> 메모 = new HashMap<>();
    Map<String, String> 분 = new HashMap<>();
    Map<String, String> 초 = new HashMap<>();
    Map<String, String> 분초 = new HashMap<>();

    ActivityResultLauncher<Intent> receive_Memo_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        //겟엑스트라 입력
                        Intent 스케쥴 = result.getData();
                        제목 = (HashMap<String, String>) 스케쥴.getSerializableExtra("제목");
                        메모 = (HashMap<String, String>) 스케쥴.getSerializableExtra("메모");
                        분 = (HashMap<String, String>) 스케쥴.getSerializableExtra("분");
                        초 = (HashMap<String, String>) 스케쥴.getSerializableExtra("초");
                        분초 = (HashMap<String, String>) 스케쥴.getSerializableExtra("분초");

                        //스케쥴 등록해논거 가져옴
                        Log.d("mulung_helper", "onActivityResult: ");
                    }
                }
            }); //메모런쳐


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mulung_helper);

        Log.d("mulung_helper", "onCreate: ");

//        Intent 저장목록 = getIntent(); // 스케쥴에서 등록해논 데이터 가져옴
//
//
//        Map<String, String> 제목 = (HashMap<String, String>) 저장목록.getSerializableExtra("제목");
//        Map<String, String> 메모 = (HashMap<String, String>) 저장목록.getSerializableExtra("메모");
//        Map<String, String> 분 = (HashMap<String, String>) 저장목록.getSerializableExtra("분");
//        Map<String, String> 초 = (HashMap<String, String>) 저장목록.getSerializableExtra("초");
//        Map<String, String> 분초 = (HashMap<String, String>) 저장목록.getSerializableExtra("분초");


        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);
        Button 시작하기 = (Button) mulung_helper.this.findViewById(R.id.시작);
        Button 중단하기 = (Button) mulung_helper.this.findViewById(R.id.중단);
        TextView 준비 = (TextView) mulung_helper.this.findViewById(R.id.준비);
        TextView 휴식하기 = (TextView) mulung_helper.this.findViewById(R.id.휴식);
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체
        Button memo = (Button) findViewById(R.id.메모);


        시작하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (end == false) {
                    end = true;
                    timer();
                } else {
                    Toast.makeText(mulung_helper.this, "이미 작동중 입니다", Toast.LENGTH_SHORT).show();
                }

            }
        });
        중단하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_timer != null || r_timer != null) {
                    timer_Stop();
                } else {
                    Toast.makeText(mulung_helper.this, "실행중인 타이머가 없습니다 ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        휴식하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    rest_Timer();

            }
        });


        memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent m_Move = new Intent(mulung_helper.this, mulung_helper_scedule.class);
                //데이터리스트(해시맵)을 주고 디테일 액티비티에서 받아서 정보를 담아주고 다시 여기로 넘겨주게됨
                //풋데이터 작성하기
                if (제목 != null && 분 != null && 초 != null && 분초 != null && 메모 != null) {
                    m_Move.putExtra("제목", (Serializable) 제목);
                    m_Move.putExtra("분", (Serializable) 분);
                    m_Move.putExtra("초", (Serializable) 초);
                    m_Move.putExtra("분초", (Serializable) 분초);
                    m_Move.putExtra("메모", (Serializable) 메모);
                }
                receive_Memo_State.launch(m_Move);

            }
        });


    }

    private void timer() { //타이머 생성 메소드
        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);
        if (r_timer != null && rt_timer != null) {
            r_timer.cancel();
            rt_timer.cancel();
            r_timer = null;
            rt_timer = null;
            rest_End = false;
            휴식 = 디폴트휴식;

        }
        rest_Useable = true;

        m_timer = new Timer();
        mt_timer = new TimerTask() {
            @Override
            public void run() {
                String 분텍스트 = Integer.toString(분타이머); //비교를위해 스트링으로 캐스팅
                            String 초텍스트 = Integer.toString(초타이머);
                            String 키합 = 분텍스트+초텍스트;

                if (초타이머 > 0 || 분타이머 > 0) {
                    if (!(분초 == null)) { //해시맵 비어있는지 먼저체크
                        if (분초.containsValue(키합)) {
                            TextView 준비 = (TextView) mulung_helper.this.findViewById(R.id.준비);

                            keySet 키분석 = new keySet(분텍스트, 초텍스트, 분초); //키를 찾아주는 클래스
                            String 키 = 키분석.result(); // 분석된 키값을 변수에저장
                            String 메모수정 = 메모.get(키); // 키값을 인자로주고 저장된 메모받아오기
//                                    준비.setText(메모수정); //텍스트뷰 메모수정인데 핸들러없어서 안됨

                        }
                    }


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
        m_timer.schedule(mt_timer, 0, 1000);

    }

    private void timer_Stop() { //타이머 중단 메소드
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체

        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);

        if (r_timer != null && rt_timer != null) {
            r_timer.cancel();
            rt_timer.cancel();
            r_timer = null;
            rt_timer = null;
        } else if (m_timer != null && mt_timer != null) {
            m_timer.cancel();
            mt_timer.cancel();
            m_timer = null;
            mt_timer = null;
        }

        휴식 = 디폴트휴식;
        end = false;
        rest_End = false;
        rest_Useable = false;
        분타이머 = 디폴트분;
        초타이머 = 디폴트초;
        타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
        진동.vibrate(500);
        mulung_helper.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mulung_helper.this, "재획타이머가 종료되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void rest_Timer() { //휴식타이머
        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);
        Button 시작하기 = (Button) mulung_helper.this.findViewById(R.id.시작);
        if (rest_End == false && rest_Useable == true) {
            // 새변수 만들어서 구분해야할ㄷ스 불린하나더만들어서 타이머 실행중일때 활성화하고
            if(m_timer != null && mt_timer != null ) { //리스타트후 재실행을 위해 분기를 나눔..
                m_timer.cancel();
                mt_timer.cancel();
                m_timer = null;
                mt_timer = null;
            }
            end = false;
            rest_End = true;

            r_timer = new Timer();
            rt_timer = new TimerTask() {
                @Override
                public void run() {
                    if (휴식 > 0) {
                        휴식--;
                        타이머.setText(휴식 + "초");

                    } else { //그냥 시간다되서 끝나면
                        r_timer.cancel();
                        rt_timer.cancel();
                        r_timer = null;
                        rt_timer = null;
                        휴식 = 디폴트휴식;
//                        end = false;
                        rest_End = false;
                        시작하기.callOnClick();
                    }

                }
            };
            r_timer.schedule(rt_timer, 0, 1000);

        } else {
            Toast.makeText(this, "우선 타이머를 실행시켜주세요", Toast.LENGTH_SHORT).show();

        }


        //메모로 이동하는 클래스 만들고
        //생명주기로 타이머 재시작 연동 (휴식타이머인지 타이머인지 구분하는 변수가 필요할거같음)

    }


    @Override
    protected void onStart() {
        Log.d("mulung_helper", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("mulung_helper", "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("mulung_helper", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        if (m_timer != null) {
            m_timer.cancel();//팅기거나 뒤로가기눌렀을때 타이머중단
            end = false;
            end_Onstop = true;
        }
        if (mt_timer != null) {
            mt_timer.cancel();
        }
        if(r_timer != null){
            r_timer.cancel();
            rest_End = false;
            rest_End_Onstop = true;
            rest_Useable = true;
        }
        if(rt_timer != null){
            rt_timer.cancel();
        }
        Log.d("mulung_helper", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("mulung_helper", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() { // 다시 돌아오면 타이머 재시작
        Log.d("mulung_helper", "onRestart: ");
        if (분타이머 != 디폴트분 || 초타이머 != 디폴트초) {
            if (end_Onstop == true) { //타이머와 휴식타이머를 구분해서 실행

                end_Onstop = false;
                timer();
            }
            else if (rest_End_Onstop == true){

                rest_End_Onstop = false;
                초타이머 = 휴식;
                rest_Timer();
            }


        }
        super.onRestart();
    }

}
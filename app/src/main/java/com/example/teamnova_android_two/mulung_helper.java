package com.example.teamnova_android_two;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

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

        HashMap<String, String> 제목 = (HashMap<String, String>)저장목록.getSerializableExtra("제목");
        HashMap<String, String> 메모 = (HashMap<String, String>)저장목록.getSerializableExtra("메모");
        HashMap<String, String> 분 = (HashMap<String, String>)저장목록.getSerializableExtra("분");
        HashMap<String, String> 초 = (HashMap<String, String>)저장목록.getSerializableExtra("초");

//        Log.v("HashMapTest", 제목.get("key"));
//        Log.v("HashMapTest", 메모.get("key"));
//        Log.v("HashMapTest", 분.get("key"));
//        Log.v("HashMapTest", 초.get("key"));

        //로직 반대로..
        //여기서 해시맵만들고 스케쥴로 넘겨주고
        //다시 저장해서 여기로넘겨주기
        //

        ToggleButton mulung_timer = (ToggleButton) findViewById(R.id.시작);
        TextView 타이머 = (TextView) findViewById(R.id.타이머);

        mulung_timer.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) { //토글버튼을 눌렀을때 작동이벤트
                if (isChecked) {
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
                                분타이머 = 14;
                                초타이머 = 60;
                                타이머.setText("15분 0초");
                                mulung_timer.setChecked(false);
                                m_timer.cancel();
                                mt_timer.cancel();
                            } catch (Exception e) {
                                System.out.println("분타이머(태스크)| 인터럽트 예외 발생");
                            }
                        }
                    }
                };
                m_timer.schedule(mt_timer, 0, 1000);
            }else{
                    타이머.setText("15분 0초");

                }
//                if (isChecked) {
//                    //  The toggle is enabled
//                } else {
//                    // The toggle is disabled
//                }
            }
        });
        Button memo = (Button) findViewById(R.id.메모);

        memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent memo_move = new Intent(mulung_helper.this, mulung_helper_scedule.class);
                startActivity(memo_move);

            }
        });;


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
        m_timer.cancel();
        mt_timer.cancel();
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
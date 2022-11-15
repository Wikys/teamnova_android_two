package com.example.teamnova_android_two;

import static com.example.teamnova_android_two.Main.dq_Reset;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class daily_quest extends AppCompatActivity implements Serializable {
    HashMap<String, Boolean> 버튼상태확인 = new HashMap<>(); // 버튼상태 저장리스트


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_quest);
        Log.d("daily_quest", "onCreate: ");

        //메인가는버튼 하나만들어야할듯...
        Button 뒤로가기 = (Button) daily_quest.this.findViewById(R.id.뒤로가기);
        ToggleButton 버튼1 = (ToggleButton) daily_quest.this.findViewById(R.id.소멸의여로버튼);
        ToggleButton 버튼2 = (ToggleButton) daily_quest.this.findViewById(R.id.츄츄아일랜드버튼);
        ToggleButton 버튼3 = (ToggleButton) daily_quest.this.findViewById(R.id.레헬른버튼);
        ToggleButton 버튼4 = (ToggleButton) daily_quest.this.findViewById(R.id.아르카나버튼);
        ToggleButton 버튼5 = (ToggleButton) daily_quest.this.findViewById(R.id.모라스버튼);
        ToggleButton 버튼6 = (ToggleButton) daily_quest.this.findViewById(R.id.에스페라버튼);




            Intent 불러오기 = getIntent();
            버튼상태확인 = (HashMap<String, Boolean>) 불러오기.getSerializableExtra("일퀘상태");
            if(버튼상태확인.size() != 0) {
                버튼1.setChecked(버튼상태확인.get("버튼1"));
                버튼2.setChecked(버튼상태확인.get("버튼2"));
                버튼3.setChecked(버튼상태확인.get("버튼3"));
                버튼4.setChecked(버튼상태확인.get("버튼4"));
                버튼5.setChecked(버튼상태확인.get("버튼5"));
                버튼6.setChecked(버튼상태확인.get("버튼6"));
            }
            else if(dq_Reset == true){ //브로드캐스트로 변경된 스태틱변수가 트루면
                버튼1.setChecked(false);
                버튼2.setChecked(false);
                버튼3.setChecked(false);
                버튼4.setChecked(false);
                버튼5.setChecked(false);
                버튼6.setChecked(false); //전부 초기화하고
                dq_Reset = false; //스태틱변수 다시 펄스로바꿈

             }
            //버튼상태확인 해시맵 안에 요소가 0개이상 있으면 버튼상태 체크하고 바꿔줌


        뒤로가기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //뒤로가기 버튼

                버튼상태확인.put("버튼1", 버튼1.isChecked());
                버튼상태확인.put("버튼2", 버튼2.isChecked());
                버튼상태확인.put("버튼3", 버튼3.isChecked());
                버튼상태확인.put("버튼4", 버튼4.isChecked());
                버튼상태확인.put("버튼5", 버튼5.isChecked());
                버튼상태확인.put("버튼6", 버튼6.isChecked());

                Intent 버튼상태저장 = new Intent(daily_quest.this, Main.class);
                버튼상태저장.putExtra("일퀘버튼", 버튼상태확인);
                setResult(RESULT_OK, 버튼상태저장); // 버튼상태체크 해시맵 넘김(메인으로)
                finish();

            }
        });


    }



    @Override
    protected void onStop() {
        Log.d("daily_quest", "onStop: ");


        super.onStop();

    }

    @Override
    protected void onStart() {
        Log.d("daily_quest", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("daily_quest", "onResume: ");
        super.onResume();
        //온크리에이트에서 일단 상태변경해주고
        //여기서 날짜변경 변수받으면 초기화
    }

    @Override
    protected void onPause() {
        Log.d("daily_quest", "onPause: ");

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("daily_quest", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("daily_quest", "onRestart: ");
        super.onRestart();
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}







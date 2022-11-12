package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ToggleButton;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class daily_quest extends AppCompatActivity implements Serializable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_quest);
    }

    @Override
    protected void onStop() { //여기서 버튼상태 저장해서 다시넘기기
        super.onStop();
        ToggleButton 버튼1 = (ToggleButton) daily_quest.this.findViewById(R.id.소멸의여로버튼);
        ToggleButton 버튼2 = (ToggleButton) daily_quest.this.findViewById(R.id.츄츄아일랜드버튼);
        ToggleButton 버튼3 = (ToggleButton) daily_quest.this.findViewById(R.id.레헬른버튼);
        ToggleButton 버튼4 = (ToggleButton) daily_quest.this.findViewById(R.id.아르카나버튼);
        ToggleButton 버튼5 = (ToggleButton) daily_quest.this.findViewById(R.id.모라스버튼);
        ToggleButton 버튼6 = (ToggleButton) daily_quest.this.findViewById(R.id.에스페라버튼);
        HashMap<String, Boolean> 버튼상태확인 = new HashMap<>(); // 버튼상태 저장리스트

        버튼상태확인.put("버튼1", 버튼1.isChecked());
        버튼상태확인.put("버튼2", 버튼2.isChecked());
        버튼상태확인.put("버튼3",버튼3.isChecked());
        버튼상태확인.put("버튼4",버튼4.isChecked());
        버튼상태확인.put("버튼5",버튼5.isChecked());
        버튼상태확인.put("버튼6",버튼6.isChecked());

        Intent 버튼상태저장 = new Intent(daily_quest.this, Main.class);
        버튼상태저장.putExtra("일퀘버튼",버튼상태확인);
        setResult(RESULT_OK, 버튼상태저장); // 버튼상태체크 해시맵 넘김(메인으로)

    } }
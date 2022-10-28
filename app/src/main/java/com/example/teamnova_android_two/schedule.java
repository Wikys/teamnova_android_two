package com.example.teamnova_android_two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class schedule extends AppCompatActivity {
    Map<String, String> 메모리스트 = new HashMap<>();
    Map<String, String> 날짜리스트 = new HashMap<>();
    Map<String, String> 키리스트 = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

        Button 저장 = (Button) findViewById(R.id.저장); //저장버튼
        Button 삭제 = (Button) findViewById(R.id.삭제); //삭제버튼
        TextView 메모 = (TextView) findViewById(R.id.요약); // 메모장
        CalendarView 일정 = (CalendarView) findViewById(R.id.일정); // 달력

        //저장해야될목록
        //메모
        //날짜
        //키값


        일정.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { //달력 날짜클릭하면 반응하는 리스너
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String key = String.format("%d%d%d", year, month + 1, dayOfMonth); //해시맵 키값으로 저장할변수
                저장.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
                삭제.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
                //날짜누르면 날짜에저장돼있던버튼 뿌려주기
                if(메모리스트.containsKey(key)) { //날짜와 일치하는 값이 있는 확인하고
                    메모.setText(메모리스트.get(key)); //저장해둔 해시맵 불러와서 메모에 적용
                }else{
                    메모.setText(null);
                }

                Button 저장버튼 = (Button) findViewById(R.id.저장);

                저장버튼.setOnClickListener(new View.OnClickListener() { //저장버튼 누르면 저장하는 리스너
                    @Override
                    public void onClick(View view) {
                        String 메모저장 = 메모.getText().toString();
                        메모리스트.put(key, 메모저장);
                        키리스트.put(key, key); // 나중에 키값찾기용
                        Toast.makeText(schedule.this, "저장되었습니다", Toast.LENGTH_SHORT).show();


                    }
                });


            }
        });

    }

//    public void newSaveList(){
//
//
//    }
}
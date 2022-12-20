package com.example.teamnova_android_two.schedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamnova_android_two.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class schedule extends AppCompatActivity {
    HashMap<String, String> 메모리스트 = new HashMap<>();
    HashMap<String, String> 키리스트 = new HashMap<>();
    SharedPreferences 메모저장;
    String 아이디; //아이디
    SharedPreferences 사용자정보;
    Calendar today = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);


        Button 저장 = (Button) findViewById(R.id.저장); //저장버튼
        Button 삭제 = (Button) findViewById(R.id.삭제); //삭제버튼
        TextView 메모 = (TextView) findViewById(R.id.요약); // 메모장
        CalendarView 일정 = (CalendarView) findViewById(R.id.일정); // 달력

        Intent 불러오기 = getIntent();
        아이디 = 불러오기.getStringExtra("아이디");
        메모리스트 = Assignment_load("메모리스트");
        String 오늘의메모key = String.format("%d%d%d", today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1, today.get(Calendar.DATE));

        if (메모리스트.containsKey(오늘의메모key)) {
            String input = 메모리스트.get(오늘의메모key);
            메모.setText(input);
        }


        일정.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { //달력 날짜클릭하면 반응하는 리스너
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String key = String.format("%d%d%d", year, month + 1, dayOfMonth); //해시맵 키값으로 저장할변수
                저장.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
                삭제.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
                //날짜누르면 날짜에저장돼있던버튼 뿌려주기
                if (메모리스트.containsKey(key)) { //날짜와 일치하는 값이 있는 확인하고
                    메모.setText(메모리스트.get(key)); //저장해둔 해시맵 불러와서 메모에 적용
                } else {
                    메모.setText(null);
                }

                Button 저장버튼 = (Button) findViewById(R.id.저장);

                저장버튼.setOnClickListener(new View.OnClickListener() { //저장버튼 누르면 저장하는 리스너
                    @Override
                    public void onClick(View view) {
                        String 메모저장 = 메모.getText().toString();
                        메모리스트.put(key, 메모저장);
                        키리스트.put(key, key); // 나중에 키값찾기용
                        Assignment_Save(메모리스트,"메모리스트");
                        //디비에 정보저장해서 메인에서 오늘의메모로 사용

                        Toast.makeText(schedule.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                Button 삭제버튼 = (Button) findViewById(R.id.삭제);
                삭제버튼.setOnClickListener(new View.OnClickListener() { //삭제버튼 누르면 날짜에 저장된메모 삭제
                    @Override
                    public void onClick(View view) {
                        메모리스트.remove(key);
                        키리스트.remove(key);
                        메모.setText(null);//삭제하고 메모비워주기
                        Toast.makeText(schedule.this, "삭제되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
    public void Assignment_Save(HashMap<String, String> Data, String Type) {
        //각종 숙제 상태저장메소드
        String jsonString = new Gson().toJson(Data);
        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        SharedPreferences.Editor editor = 사용자정보.edit();
        editor.putString(Type, jsonString);
        editor.apply();
    }

    public HashMap<String, String> Assignment_load(String Type) {
        //각종 숙제 상태저장 불러오는 메소드
        //해쉬맵 변환하여 불러오는 메소드
        HashMap<String, String> outputMap = new HashMap<String, String>();
        //배출용 해쉬맵 선언
        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        String defValue = new Gson().toJson(new HashMap<String, String>());
        //불러올정보가 없을때 디폴트값
        String json= 사용자정보.getString(Type,defValue);
        TypeToken<HashMap<String, String>> type = new TypeToken<HashMap<String, String>>(){};
        //암시적 형변환해주는 클래스
        HashMap<String, String> returnMap = new Gson().fromJson(json,type.getType());
        //첫번째인자 : 불러온 데이터 , 두번째인자 : 불러온 데이터의 타입
        return returnMap;
    }
}
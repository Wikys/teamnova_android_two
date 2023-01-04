package com.example.teamnova_android_two;

import static com.example.teamnova_android_two.Main.Main.wq_Reset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.teamnova_android_two.Main.Main;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;

public class weekly_quest extends AppCompatActivity {
    HashMap<String, Boolean> 버튼상태확인 = new HashMap<>(); // 버튼상태 저장리스트
    String 아이디; //아이디
    SharedPreferences 사용자정보;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_quest);
        Log.d("weekly_quest", "onCreate: ");
        Button 뒤로가기 = (Button) weekly_quest.this.findViewById(R.id.뒤로가기);
        ToggleButton 버튼1 = (ToggleButton) weekly_quest.this.findViewById(R.id.소멸의여로버튼);
        ToggleButton 버튼2 = (ToggleButton) weekly_quest.this.findViewById(R.id.크리티아스버튼);
        ToggleButton 버튼3 = (ToggleButton) weekly_quest.this.findViewById(R.id.기계무덤버튼);
        ToggleButton 버튼4 = (ToggleButton) weekly_quest.this.findViewById(R.id.타락한세계수버튼);

        Intent 불러오기 = getIntent();
        아이디 = 불러오기.getStringExtra("아이디");
        버튼상태확인 = Assignment_load("주간퀘상태");
        if(버튼상태확인.size() != 0) {
            버튼1.setChecked(버튼상태확인.get("버튼1"));
            버튼2.setChecked(버튼상태확인.get("버튼2"));
            버튼3.setChecked(버튼상태확인.get("버튼3"));
            버튼4.setChecked(버튼상태확인.get("버튼4"));

        }
        else if(wq_Reset == true){ //브로드캐스트로 변경된 스태틱변수가 트루면
            버튼1.setChecked(false);
            버튼2.setChecked(false);
            버튼3.setChecked(false);
            버튼4.setChecked(false);
             //전부 초기화하고
            wq_Reset = false; //스태틱변수 다시 펄스로바꿈

        }
        //버튼상태확인 해시맵 안에 요소가 0개이상 있으면 버튼상태 체크하고 바꿔줌

        뒤로가기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //뒤로가기 버튼

                버튼상태확인.put("버튼1", 버튼1.isChecked());
                버튼상태확인.put("버튼2", 버튼2.isChecked());
                버튼상태확인.put("버튼3", 버튼3.isChecked());
                버튼상태확인.put("버튼4", 버튼4.isChecked());


                Intent 버튼상태저장 = new Intent(weekly_quest.this, Main.class);
                버튼상태저장.putExtra("주간퀘버튼", 버튼상태확인);
                setResult(RESULT_OK, 버튼상태저장); // 버튼상태체크 해시맵 넘김(메인으로)
                Assignment_Save(버튼상태확인,"주간퀘상태");
                finish();
            }
        });


    }
    @Override
    protected void onStart() {
        Log.d("weekly_quest", "onStart: ");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d("weekly_quest", "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("weekly_quest", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("weekly_quest", "onStop: ");
        super.onStop();
        Assignment_Save(버튼상태확인,"주간퀘상태");
    }

    @Override
    protected void onDestroy() {
        Log.d("weekly_quest", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("weekly_quest", "onRestart: ");
        super.onRestart();
    }
    public void Assignment_Save(HashMap<String, Boolean> Data, String Type) {
        //각종 숙제 상태저장메소드
        String jsonString = new Gson().toJson(Data);
        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        SharedPreferences.Editor editor = 사용자정보.edit();
        editor.putString(Type, jsonString);
        editor.apply();
    }
    public HashMap<String, Boolean> Assignment_load(String Type) {
        //각종 숙제 상태저장 불러오는 메소드
        //해쉬맵 변환하여 불러오는 메소드
//        HashMap<String, Boolean> outputMap = new HashMap<String, Boolean>();

        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        String defValue = new Gson().toJson(new HashMap<String, Boolean>());

        String json = 사용자정보.getString(Type, defValue);
        //인자 : Type:내가쓴 스트링값을 제목으로, defvalue:json으로 변환된 해시맵
        TypeToken<HashMap<String, Boolean>> type = new TypeToken<HashMap<String, Boolean>>() {
        };
        //암시적 형변환해주는 클래스
        HashMap<String, Boolean> returnMap = new Gson().fromJson(json, type.getType());
        //첫번째인자 : 불러온 데이터 , 두번째인자 : 불러온 데이터의 타입
        return returnMap;
    }
}
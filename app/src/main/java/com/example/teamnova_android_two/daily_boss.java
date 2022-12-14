package com.example.teamnova_android_two;

import static com.example.teamnova_android_two.Main.Main.db_Reset;
import static com.example.teamnova_android_two.Reset.Day_Listener.daily_Reset;

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

import java.io.Serializable;
import java.util.HashMap;

public class daily_boss extends AppCompatActivity implements Serializable {
    HashMap<String, Boolean> 버튼상태확인 = new HashMap<>(); // 버튼상태 저장리스트
    String 아이디; //아이디
    SharedPreferences 사용자정보;
    ToggleButton 버튼1;
    ToggleButton 버튼2;
    ToggleButton 버튼3;
    ToggleButton 버튼4;
    ToggleButton 버튼5;
    ToggleButton 버튼6;
    ToggleButton 버튼7;
    ToggleButton 버튼8;
    ToggleButton 버튼9;
    ToggleButton 버튼10;
    ToggleButton 버튼11;
    ToggleButton 버튼12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_boss);
        Log.d("daily_boss", "onCreate: ");

    }
    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
    @Override
    protected void onStart() {
        Log.d("daily_boss", "onStart: ");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d("daily_boss", "onResume: ");
        super.onResume();
        Button 뒤로가기 = (Button) daily_boss.this.findViewById(R.id.뒤로가기);
        버튼1 = (ToggleButton) daily_boss.this.findViewById(R.id.자쿰버튼);
        버튼2 = (ToggleButton) daily_boss.this.findViewById(R.id.힐라버튼);
        버튼3 = (ToggleButton) daily_boss.this.findViewById(R.id.혼테일버튼);
        버튼4 = (ToggleButton) daily_boss.this.findViewById(R.id.반레온버튼);
        버튼5 = (ToggleButton) daily_boss.this.findViewById(R.id.아카이럼버튼);
        버튼6 = (ToggleButton) daily_boss.this.findViewById(R.id.블러디퀸버튼);
        버튼7 = (ToggleButton) daily_boss.this.findViewById(R.id.피에르버튼);
        버튼8 = (ToggleButton) daily_boss.this.findViewById(R.id.반반버튼);
        버튼9 = (ToggleButton) daily_boss.this.findViewById(R.id.카웅버튼);
        버튼10 = (ToggleButton) daily_boss.this.findViewById(R.id.매그너스버튼);
        버튼11= (ToggleButton) daily_boss.this.findViewById(R.id.핑크빈버튼);
        버튼12 = (ToggleButton) daily_boss.this.findViewById(R.id.벨룸버튼);

        Intent 불러오기 = getIntent();
        아이디 = 불러오기.getStringExtra("아이디");
//        버튼상태확인 = (HashMap<String, Boolean>) 불러오기.getSerializableExtra("일보상태");
        버튼상태확인 = Assignment_load("일간보스상태");
        if(버튼상태확인.size() != 0) {
            버튼1.setChecked(버튼상태확인.get("버튼1"));
            버튼2.setChecked(버튼상태확인.get("버튼2"));
            버튼3.setChecked(버튼상태확인.get("버튼3"));
            버튼4.setChecked(버튼상태확인.get("버튼4"));
            버튼5.setChecked(버튼상태확인.get("버튼5"));
            버튼6.setChecked(버튼상태확인.get("버튼6"));
            버튼7.setChecked(버튼상태확인.get("버튼7"));
            버튼8.setChecked(버튼상태확인.get("버튼8"));
            버튼9.setChecked(버튼상태확인.get("버튼9"));
            버튼10.setChecked(버튼상태확인.get("버튼10"));
            버튼11.setChecked(버튼상태확인.get("버튼11"));
            버튼12.setChecked(버튼상태확인.get("버튼12"));

        }
        else{
            daily_Reset = false;
            버튼1.setChecked(false);
            버튼2.setChecked(false);
            버튼3.setChecked(false);
            버튼4.setChecked(false);
            버튼5.setChecked(false);
            버튼6.setChecked(false);
            버튼7.setChecked(false);
            버튼8.setChecked(false);
            버튼9.setChecked(false);
            버튼10.setChecked(false);
            버튼11.setChecked(false);
            버튼12.setChecked(false);
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
                버튼상태확인.put("버튼7", 버튼7.isChecked());
                버튼상태확인.put("버튼8", 버튼8.isChecked());
                버튼상태확인.put("버튼9", 버튼9.isChecked());
                버튼상태확인.put("버튼10", 버튼10.isChecked());
                버튼상태확인.put("버튼11", 버튼11.isChecked());
                버튼상태확인.put("버튼12", 버튼12.isChecked());


                Intent 버튼상태저장 = new Intent(daily_boss.this, Main.class);
                버튼상태저장.putExtra("일보버튼", 버튼상태확인);
                setResult(RESULT_OK, 버튼상태저장); // 버튼상태체크 해시맵 넘김(메인으로)
                Assignment_Save(버튼상태확인,"일간보스상태");
//                Log.d("일간보스상태", "onStop: "+Assignment_load("일간보스상태"));
                finish();

            }
        });
    }

    @Override
    protected void onPause() {
        Log.d("daily_boss", "onPause: ");
        super.onPause();
        if (!daily_Reset) {
            버튼상태확인.put("버튼1", 버튼1.isChecked());
            버튼상태확인.put("버튼2", 버튼2.isChecked());
            버튼상태확인.put("버튼3", 버튼3.isChecked());
            버튼상태확인.put("버튼4", 버튼4.isChecked());
            버튼상태확인.put("버튼5", 버튼5.isChecked());
            버튼상태확인.put("버튼6", 버튼6.isChecked());
            버튼상태확인.put("버튼7", 버튼7.isChecked());
            버튼상태확인.put("버튼8", 버튼8.isChecked());
            버튼상태확인.put("버튼9", 버튼9.isChecked());
            버튼상태확인.put("버튼10", 버튼10.isChecked());
            버튼상태확인.put("버튼11", 버튼11.isChecked());
            버튼상태확인.put("버튼12", 버튼12.isChecked());
            Assignment_Save(버튼상태확인,"일간보스상태");
        }

    }

    @Override
    protected void onStop() {
        Log.d("daily_boss", "onStop: ");
        super.onStop();

//        Log.d("일간보스상태", "onStop: "+Assignment_load("일간보스상태"));
    }

    @Override
    protected void onDestroy() {
        Log.d("daily_boss", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("daily_boss", "onRestart: ");
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
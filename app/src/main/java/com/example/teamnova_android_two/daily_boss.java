package com.example.teamnova_android_two;

import static com.example.teamnova_android_two.Main.Main.db_Reset;

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

import java.io.Serializable;
import java.util.HashMap;

public class daily_boss extends AppCompatActivity implements Serializable {
    HashMap<String, Boolean> 버튼상태확인 = new HashMap<>(); // 버튼상태 저장리스트
    String 아이디; //아이디
    SharedPreferences 사용자정보;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_boss);
        Log.d("daily_boss", "onCreate: ");

        Button 뒤로가기 = (Button) daily_boss.this.findViewById(R.id.뒤로가기);
        ToggleButton 버튼1 = (ToggleButton) daily_boss.this.findViewById(R.id.자쿰버튼);
        ToggleButton 버튼2 = (ToggleButton) daily_boss.this.findViewById(R.id.힐라버튼);
        ToggleButton 버튼3 = (ToggleButton) daily_boss.this.findViewById(R.id.혼테일버튼);
        ToggleButton 버튼4 = (ToggleButton) daily_boss.this.findViewById(R.id.반레온버튼);
        ToggleButton 버튼5 = (ToggleButton) daily_boss.this.findViewById(R.id.아카이럼버튼);
        ToggleButton 버튼6 = (ToggleButton) daily_boss.this.findViewById(R.id.블러디퀸버튼);
        ToggleButton 버튼7 = (ToggleButton) daily_boss.this.findViewById(R.id.피에르버튼);
        ToggleButton 버튼8 = (ToggleButton) daily_boss.this.findViewById(R.id.반반버튼);
        ToggleButton 버튼9 = (ToggleButton) daily_boss.this.findViewById(R.id.카웅버튼);
        ToggleButton 버튼10 = (ToggleButton) daily_boss.this.findViewById(R.id.매그너스버튼);
        ToggleButton 버튼11= (ToggleButton) daily_boss.this.findViewById(R.id.핑크빈버튼);
        ToggleButton 버튼12 = (ToggleButton) daily_boss.this.findViewById(R.id.벨룸버튼);

        Intent 불러오기 = getIntent();
        아이디 = 불러오기.getStringExtra("아이디");
        버튼상태확인 = (HashMap<String, Boolean>) 불러오기.getSerializableExtra("일보상태");
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
        else if(db_Reset == true){ //브로드캐스트로 변경된 스태틱변수가 트루면
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

            //전부 초기화하고
            db_Reset = false; //스태틱변수 다시 펄스로바꿈

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
                finish();

            }
        });






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
    }

    @Override
    protected void onPause() {
        Log.d("daily_boss", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("daily_boss", "onStop: ");
        super.onStop();
        Assignment_Save(버튼상태확인,아이디);
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
}
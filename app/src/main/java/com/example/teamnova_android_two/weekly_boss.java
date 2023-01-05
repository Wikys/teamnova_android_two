package com.example.teamnova_android_two;

import static com.example.teamnova_android_two.Main.Main.wb_Reset;
import static com.example.teamnova_android_two.Reset.Day_Listener.weekly_Reset;

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

public class weekly_boss extends AppCompatActivity {
    HashMap<String, Boolean> 버튼상태확인 = new HashMap<>(); // 버튼상태 저장리스트
    String 아이디; //아이디
    SharedPreferences 사용자정보;
    ToggleButton 버튼1 ;
    ToggleButton 버튼2 ;
    ToggleButton 버튼3 ;
    ToggleButton 버튼4 ;
    ToggleButton 버튼5 ;
    ToggleButton 버튼6 ;
    ToggleButton 버튼7 ;
    ToggleButton 버튼8 ;
    ToggleButton 버튼9 ;
    ToggleButton 버튼10;
    ToggleButton 버튼11;
    ToggleButton 버튼12;
    ToggleButton 버튼13;
    ToggleButton 버튼14;
    ToggleButton 버튼15;
    ToggleButton 버튼16;
    ToggleButton 버튼17;
    ToggleButton 버튼18;
    ToggleButton 버튼19;
    ToggleButton 버튼20;
    ToggleButton 버튼21;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_boss);
        Log.d("weekly_boss", "onCreate: ");


    }
    @Override
    protected void onStart() {
        Log.d("weekly_boss", "onStart: ");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d("weekly_boss", "onResume: ");
        super.onResume();
        버튼1 = (ToggleButton) weekly_boss.this.findViewById(R.id.자쿰버튼);
        버튼2 = (ToggleButton) weekly_boss.this.findViewById(R.id.힐라버튼);
        버튼3 = (ToggleButton) weekly_boss.this.findViewById(R.id.파풀버튼);
        버튼4 = (ToggleButton) weekly_boss.this.findViewById(R.id.핑크빈버튼);
        버튼5 = (ToggleButton) weekly_boss.this.findViewById(R.id.매그너스버튼);
        버튼6 = (ToggleButton) weekly_boss.this.findViewById(R.id.시그버튼);
        버튼7 = (ToggleButton) weekly_boss.this.findViewById(R.id.블퀸버튼);
        버튼8 = (ToggleButton) weekly_boss.this.findViewById(R.id.피에르버튼);
        버튼9 = (ToggleButton) weekly_boss.this.findViewById(R.id.반반버튼);
        버튼10 = (ToggleButton) weekly_boss.this.findViewById(R.id.벨룸버튼);
        버튼11 = (ToggleButton) weekly_boss.this.findViewById(R.id.스우버튼);
        버튼12 = (ToggleButton) weekly_boss.this.findViewById(R.id.데미안버튼);
        버튼13 = (ToggleButton) weekly_boss.this.findViewById(R.id.가엔슬버튼);
        버튼14 = (ToggleButton) weekly_boss.this.findViewById(R.id.루시드버튼);
        버튼15 = (ToggleButton) weekly_boss.this.findViewById(R.id.윌버튼);
        버튼16 = (ToggleButton) weekly_boss.this.findViewById(R.id.더스크버튼);
        버튼17 = (ToggleButton) weekly_boss.this.findViewById(R.id.듄켈버튼);
        버튼18 = (ToggleButton) weekly_boss.this.findViewById(R.id.진힐라버튼);
        버튼19 = (ToggleButton) weekly_boss.this.findViewById(R.id.검마버튼);
        버튼20 = (ToggleButton) weekly_boss.this.findViewById(R.id.세렌버튼);
        버튼21 = (ToggleButton) weekly_boss.this.findViewById(R.id.칼로스버튼);

        Intent 불러오기 = getIntent();
        아이디 = 불러오기.getStringExtra("아이디");
        버튼상태확인 = Assignment_load("주간보스상태");
        Log.d("week", "list 사이즈: "+버튼상태확인.size() + " list 요소 : " + 버튼상태확인);
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
            버튼13.setChecked(버튼상태확인.get("버튼13"));
            버튼14.setChecked(버튼상태확인.get("버튼14"));
            버튼15.setChecked(버튼상태확인.get("버튼15"));
            버튼16.setChecked(버튼상태확인.get("버튼16"));
            버튼17.setChecked(버튼상태확인.get("버튼17"));
            버튼18.setChecked(버튼상태확인.get("버튼18"));
            버튼19.setChecked(버튼상태확인.get("버튼19"));
            버튼20.setChecked(버튼상태확인.get("버튼20"));
            버튼21.setChecked(버튼상태확인.get("버튼21"));
        }else{
            weekly_Reset = false;
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
            버튼13.setChecked(false);
            버튼14.setChecked(false);
            버튼15.setChecked(false);
            버튼16.setChecked(false);
            버튼17.setChecked(false);
            버튼18.setChecked(false);
            버튼19.setChecked(false);
            버튼20.setChecked(false);
            버튼21.setChecked(false);
        }

        //버튼상태확인 해시맵 안에 요소가 0개이상 있으면 버튼상태 체크하고 바꿔줌

        Button 뒤로가기 = (Button) weekly_boss.this.findViewById(R.id.뒤로가기);

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
                버튼상태확인.put("버튼13", 버튼13.isChecked());
                버튼상태확인.put("버튼14", 버튼14.isChecked());
                버튼상태확인.put("버튼15", 버튼15.isChecked());
                버튼상태확인.put("버튼16", 버튼16.isChecked());
                버튼상태확인.put("버튼17", 버튼17.isChecked());
                버튼상태확인.put("버튼18", 버튼18.isChecked());
                버튼상태확인.put("버튼19", 버튼19.isChecked());
                버튼상태확인.put("버튼20", 버튼20.isChecked());
                버튼상태확인.put("버튼21", 버튼21.isChecked());
                //이거


                Intent 버튼상태저장 = new Intent(weekly_boss.this, Main.class);
                버튼상태저장.putExtra("주간보스버튼", 버튼상태확인);
                setResult(RESULT_OK, 버튼상태저장); // 버튼상태체크 해시맵 넘김(메인으로)
                Assignment_Save(버튼상태확인,"주간보스상태");
                finish();

            }
        });
    }

    @Override
    protected void onPause() {
        Log.d("weekly_boss", "onPause: ");
        super.onPause();
        if(!weekly_Reset) {
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
            버튼상태확인.put("버튼13", 버튼13.isChecked());
            버튼상태확인.put("버튼14", 버튼14.isChecked());
            버튼상태확인.put("버튼15", 버튼15.isChecked());
            버튼상태확인.put("버튼16", 버튼16.isChecked());
            버튼상태확인.put("버튼17", 버튼17.isChecked());
            버튼상태확인.put("버튼18", 버튼18.isChecked());
            버튼상태확인.put("버튼19", 버튼19.isChecked());
            버튼상태확인.put("버튼20", 버튼20.isChecked());
            버튼상태확인.put("버튼21", 버튼21.isChecked());
            Assignment_Save(버튼상태확인, "주간보스상태");
            Log.d("weekly_boss", "reset: " + weekly_Reset);
            //예외처리 안해놓으면 이비 이중저장되면서 (퍼즈가 후순위라서) 초기화진행안됨
            //초기화 구분변수가 false일때만 현재상태저장
        }

        //팅기거나 해당 액티비티에서 앱 강제종료를 대비한 저장


    }

    @Override
    protected void onStop() {
        Log.d("weekly_boss", "onStop: ");
        super.onStop();


    }

    @Override
    protected void onDestroy() {
        Log.d("weekly_boss", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("weekly_boss", "onRestart: ");
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
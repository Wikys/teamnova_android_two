package com.example.teamnova_android_two;

import static com.example.teamnova_android_two.Main.Main.wb_Reset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;

import com.example.teamnova_android_two.Main.Main;

import java.util.HashMap;

public class weekly_boss extends AppCompatActivity {
    HashMap<String, Boolean> 버튼상태확인 = new HashMap<>(); // 버튼상태 저장리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weekly_boss);
        Log.d("weekly_boss", "onCreate: ");
        Button 뒤로가기 = (Button) weekly_boss.this.findViewById(R.id.뒤로가기);
        ToggleButton 버튼1 = (ToggleButton) weekly_boss.this.findViewById(R.id.자쿰버튼);
        ToggleButton 버튼2 = (ToggleButton) weekly_boss.this.findViewById(R.id.힐라버튼);
        ToggleButton 버튼3 = (ToggleButton) weekly_boss.this.findViewById(R.id.파풀버튼);
        ToggleButton 버튼4 = (ToggleButton) weekly_boss.this.findViewById(R.id.핑크빈버튼);
        ToggleButton 버튼5 = (ToggleButton) weekly_boss.this.findViewById(R.id.매그너스버튼);
        ToggleButton 버튼6 = (ToggleButton) weekly_boss.this.findViewById(R.id.시그버튼);
        ToggleButton 버튼7 = (ToggleButton) weekly_boss.this.findViewById(R.id.블퀸버튼);
        ToggleButton 버튼8 = (ToggleButton) weekly_boss.this.findViewById(R.id.피에르버튼);
        ToggleButton 버튼9 = (ToggleButton) weekly_boss.this.findViewById(R.id.반반버튼);
        ToggleButton 버튼10 = (ToggleButton) weekly_boss.this.findViewById(R.id.벨룸버튼);
        ToggleButton 버튼11 = (ToggleButton) weekly_boss.this.findViewById(R.id.스우버튼);
        ToggleButton 버튼12 = (ToggleButton) weekly_boss.this.findViewById(R.id.데미안버튼);
        ToggleButton 버튼13 = (ToggleButton) weekly_boss.this.findViewById(R.id.가엔슬버튼);
        ToggleButton 버튼14 = (ToggleButton) weekly_boss.this.findViewById(R.id.루시드버튼);
        ToggleButton 버튼15 = (ToggleButton) weekly_boss.this.findViewById(R.id.윌버튼);
        ToggleButton 버튼16 = (ToggleButton) weekly_boss.this.findViewById(R.id.더스크버튼);
        ToggleButton 버튼17 = (ToggleButton) weekly_boss.this.findViewById(R.id.듄켈버튼);
        ToggleButton 버튼18 = (ToggleButton) weekly_boss.this.findViewById(R.id.진힐라버튼);
        ToggleButton 버튼19 = (ToggleButton) weekly_boss.this.findViewById(R.id.검마버튼);
        ToggleButton 버튼20 = (ToggleButton) weekly_boss.this.findViewById(R.id.세렌버튼);
        ToggleButton 버튼21 = (ToggleButton) weekly_boss.this.findViewById(R.id.칼로스버튼);

        Intent 불러오기 = getIntent();
        버튼상태확인 = (HashMap<String, Boolean>) 불러오기.getSerializableExtra("주간보스상태");
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

        }
        else if(wb_Reset == true){ //브로드캐스트로 변경된 스태틱변수가 트루면
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
            //전부 초기화하고
            wb_Reset = false; //스태틱변수 다시 펄스로바꿈

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
                버튼상태확인.put("버튼13", 버튼13.isChecked());
                버튼상태확인.put("버튼14", 버튼14.isChecked());
                버튼상태확인.put("버튼15", 버튼15.isChecked());
                버튼상태확인.put("버튼16", 버튼16.isChecked());
                버튼상태확인.put("버튼17", 버튼17.isChecked());
                버튼상태확인.put("버튼18", 버튼18.isChecked());
                버튼상태확인.put("버튼19", 버튼19.isChecked());
                버튼상태확인.put("버튼20", 버튼20.isChecked());
                버튼상태확인.put("버튼21", 버튼21.isChecked());


                Intent 버튼상태저장 = new Intent(weekly_boss.this, Main.class);
                버튼상태저장.putExtra("주간보스버튼", 버튼상태확인);
                setResult(RESULT_OK, 버튼상태저장); // 버튼상태체크 해시맵 넘김(메인으로)
                finish();

            }
        });

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
    }

    @Override
    protected void onPause() {
        Log.d("weekly_boss", "onPause: ");
        super.onPause();
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
}
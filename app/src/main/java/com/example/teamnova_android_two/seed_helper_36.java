package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

public class seed_helper_36 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_helper_36);

        Button 초기화 = (Button) findViewById(R.id.초기화);
        RadioGroup 단계1 = (RadioGroup) findViewById(R.id.단계1);
        RadioGroup 단계2 = (RadioGroup) findViewById(R.id.단계2);
        RadioGroup 단계3 = (RadioGroup) findViewById(R.id.단계3);
        RadioGroup 단계4 = (RadioGroup) findViewById(R.id.단계4);
        RadioGroup 단계5 = (RadioGroup) findViewById(R.id.단계5);
        RadioGroup 단계6 = (RadioGroup) findViewById(R.id.단계6);
        RadioGroup 단계7 = (RadioGroup) findViewById(R.id.단계7);
        RadioGroup 단계8 = (RadioGroup) findViewById(R.id.단계8);


        초기화.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { // 클릭시 모든 라디오버튼 초기화
                단계1.clearCheck();
                단계2.clearCheck();
                단계3.clearCheck();
                단계4.clearCheck();
                단계5.clearCheck();
                단계6.clearCheck();
                단계7.clearCheck();
                단계8.clearCheck();


            }
        });
    }
}
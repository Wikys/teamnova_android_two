package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        Button btn23 = (Button) findViewById(R.id.시드23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move23 = new Intent(seed_helper_36.this, seed_helper_23.class);
                startActivity(move23);
            }
        });
        Button btn24 = (Button) findViewById(R.id.시드24);

        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move24 = new Intent(seed_helper_36.this, seed_helper_24.class);
                startActivity(move24);
            }
        });
        Button main = (Button) findViewById(R.id.버튼타이틀);

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainmove = new Intent(seed_helper_36.this, Main.class);
                startActivity(mainmove);
            }
        });
        Button btn39 = (Button) findViewById(R.id.시드39);

        btn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move39 = new Intent(seed_helper_36.this, seed_helper_39.class);
                startActivity(move39);
            }
        });
        Button btn47 = (Button) findViewById(R.id.시드47);

        btn47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move47 = new Intent(seed_helper_36.this, seed_helper_47.class);
                startActivity(move47);
            }
        });
        Button btn48 = (Button) findViewById(R.id.시드48);

        btn48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move48 = new Intent(seed_helper_36.this, seed_helper_48.class);
                startActivity(move48);
            }
        });
        Button btn49 = (Button) findViewById(R.id.시드49);

        btn49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move49 = new Intent(seed_helper_36.this, seed_helper_49.class);
                startActivity(move49);

            }
        });

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
package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class seed_helper_49 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_helper_49);

        Button btn23 = (Button) findViewById(R.id.시드23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move23 = new Intent(seed_helper_49.this, seed_helper_23.class);
                move23.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move23);
            }
        });
        Button btn24 = (Button) findViewById(R.id.시드24);

        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move24 = new Intent(seed_helper_49.this, seed_helper_24.class);
                move24.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move24);
            }
        });
        Button btn36 = (Button) findViewById(R.id.시드36);

        btn36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move36 = new Intent(seed_helper_49.this, seed_helper_36.class);
                move36.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move36);
            }
        });
        Button btn39 = (Button) findViewById(R.id.시드39);

        btn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move39 = new Intent(seed_helper_49.this, seed_helper_39.class);
                move39.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move39);
            }
        });
        Button btn47 = (Button) findViewById(R.id.시드47);

        btn47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move47 = new Intent(seed_helper_49.this, seed_helper_47.class);
                move47.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move47);
            }
        });
        Button btn48 = (Button) findViewById(R.id.시드48);

        btn48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move48 = new Intent(seed_helper_49.this, seed_helper_48.class);
                move48.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move48);
            }
        });
//        Button main = (Button) findViewById(R.id.버튼타이틀);
//
//        main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent movemain = new Intent(seed_helper_49.this, Main.class);
//                startActivity(movemain);
//
//            }
//        });
    }
}
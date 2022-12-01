package com.example.teamnova_android_two.seed_39;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.seed_24.BGM_Adapter;
import com.example.teamnova_android_two.seed_24.seed_helper_24;
import com.example.teamnova_android_two.seed_24.seed_helper_24_data;
import com.example.teamnova_android_two.seed_helper_23;
import com.example.teamnova_android_two.seed_helper_36;
import com.example.teamnova_android_two.seed_helper_47;
import com.example.teamnova_android_two.seed_helper_48;
import com.example.teamnova_android_two.seed_helper_49;

import java.util.ArrayList;

public class seed_helper_39 extends AppCompatActivity {
    ArrayList<seed_helper_39_data> data, filter; //데이터모델 타입을 저장하는 어레이리스트
    // 필터는 비어있는 리스트지만 검색할때 기존 리스트에서 삭제를하고 여기에 추가시켜 보여준다
    Quiz_Adapter 리사이클러어댑터;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_helper_39);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        RecyclerView QuizRv = (RecyclerView) this.findViewById(R.id.퀴즈);

        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
        QuizRv.setLayoutManager(리니어매니저);

        리사이클러어댑터 = new Quiz_Adapter(this, data);//
        QuizRv.setAdapter(리사이클러어댑터);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(QuizRv.getContext(), new LinearLayoutManager(this).getOrientation());
        QuizRv.addItemDecoration(dividerItemDecoration);
        //디바이더 데코

        EditText 검색창 = (EditText) this.findViewById(R.id.검색);



        Button btn23 = (Button) findViewById(R.id.시드23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move23 = new Intent(seed_helper_39.this, seed_helper_23.class);
                move23.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move23);
            }
        });
        Button btn24 = (Button) findViewById(R.id.시드24);

        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move24 = new Intent(seed_helper_39.this, seed_helper_24.class);
                move24.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move24);
            }
        });
        Button btn36 = (Button) findViewById(R.id.시드36);

        btn36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move36 = new Intent(seed_helper_39.this, seed_helper_36.class);
                move36.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move36);
            }
        });
//        Button main = (Button) findViewById(R.id.버튼타이틀);
//
//        main.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mainmove = new Intent(seed_helper_39.this, Main.class);
//                startActivity(mainmove);
//            }
//        });
        Button btn47 = (Button) findViewById(R.id.시드47);

        btn47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move47 = new Intent(seed_helper_39.this, seed_helper_47.class);
                move47.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move47);
            }
        });
        Button btn48 = (Button) findViewById(R.id.시드48);

        btn48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move48 = new Intent(seed_helper_39.this, seed_helper_48.class);
                move48.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move48);
            }
        });
        Button btn49 = (Button) findViewById(R.id.시드49);

        btn49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move49 = new Intent(seed_helper_39.this, seed_helper_49.class);
                move49.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move49);

            }
        });
    }
}
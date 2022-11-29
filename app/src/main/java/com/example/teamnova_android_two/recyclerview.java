package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class recyclerview extends AppCompatActivity {
    public static ArrayList<String> 이름;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);
        이름 = new ArrayList<String>();
        이름.add("안연창");
        이름.add("박상현");
        이름.add("박상부");

        RecyclerView 리사이클러뷰 = (RecyclerView) this.findViewById(R.id.recn);
        //리사이클러뷰 선언하고 연결

        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
        리사이클러뷰.setLayoutManager(리니어매니저);
        //리니어 매니저 선언 (무조건해야함)
        //디자인적인부분 수정가능 오리엔테이션등 기능엄청많음 (상하좌우 스크롤등)

        MyAdapter 리사이클러어댑터 = new MyAdapter();
        리사이클러뷰.setAdapter(리사이클러어댑터);
        //안에 표시되는것, 몇개표시되는지등을 관리해주는 "어댑터" 선언



    }
}
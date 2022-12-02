package com.example.teamnova_android_two.seed_49;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.recyclerView_height;
import com.example.teamnova_android_two.seed_24.BGM_Adapter;
import com.example.teamnova_android_two.seed_24.seed_helper_24;
import com.example.teamnova_android_two.seed_39.Quiz_Adapter;
import com.example.teamnova_android_two.seed_39.seed_helper_39;
import com.example.teamnova_android_two.seed_39.seed_helper_39_data;
import com.example.teamnova_android_two.seed_helper_23;
import com.example.teamnova_android_two.seed_helper_36;
import com.example.teamnova_android_two.seed_helper_47;
import com.example.teamnova_android_two.seed_helper_48;

import java.util.ArrayList;

public class seed_helper_49 extends AppCompatActivity {
    ArrayList<seed_helper_49_data> data, filter; //데이터모델 타입을 저장하는 어레이리스트
    // 필터는 비어있는 리스트지만 검색할때 기존 리스트에서 삭제를하고 여기에 추가시켜 보여준다
    Monster_Quiz_Adapter 리사이클러어댑터;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_helper_49);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        data = new ArrayList();
        filter = new ArrayList();

        data.add(new seed_helper_49_data("에델슈타인","가로등",R.drawable.garodung));
        data.add(new seed_helper_49_data("에델슈타인","가로등",R.drawable.garodung));
        data.add(new seed_helper_49_data("에델슈타인","가로등",R.drawable.garodung));
        data.add(new seed_helper_49_data("에델슈타인","가로등",R.drawable.garodung));

        RecyclerView mQuizRv = (RecyclerView) this.findViewById(R.id.퀴즈);

        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        mQuizRv.setLayoutManager(staggeredGridLayoutManager); //불규칙 레이아웃 적용 스팬2

        리사이클러어댑터 = new Monster_Quiz_Adapter(this, data);//
        mQuizRv.setAdapter(리사이클러어댑터);

        recyclerView_height decoration_height = new recyclerView_height(20);
        mQuizRv.addItemDecoration(decoration_height); //데코레이션으로 높이 적용


//        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
//        mQuizRv.setLayoutManager(리니어매니저);



        EditText 검색창 = (EditText) this.findViewById(R.id.검색);

        검색창.addTextChangedListener(new TextWatcher() { //검색창에 스트링값 들어오면 결과변경
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String searchText = 검색창.getText().toString(); //검색창에 들어온값을 스트링으로 형변환
                searchFilter(searchText);

            }
        });



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
    public void searchFilter(String searchText) {

        filter.clear(); //필터 일단 싹비워주고(전에 검색했던기록 안나오게)

        for (int i = 0; i < data.size(); i++) {
            //아이템 전체목록 싹 훑어주고
            if (data.get(i).getArea().toLowerCase().contains(searchText.toLowerCase())
                    || data.get(i).getMonsterName().toLowerCase().contains(searchText.toLowerCase())
            ) {

//                검색창에 써진 텍스트와 비교해서 몬스터이름,지역명 이랑 일치하는 아이템을 찾아서
                filter.add(data.get(i));
                //아이템필터에 추가해주고
            }
        }

        리사이클러어댑터.itemfilter(filter); // 기존 어레이리스트 교체

    }
}
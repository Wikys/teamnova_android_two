package com.example.teamnova_android_two.seed_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.seed_helper_23;
import com.example.teamnova_android_two.seed_helper_36;
import com.example.teamnova_android_two.seed_39.seed_helper_39;
import com.example.teamnova_android_two.seed_helper_47;
import com.example.teamnova_android_two.seed_helper_48;
import com.example.teamnova_android_two.seed_49.seed_helper_49;

import java.util.ArrayList;

public class seed_helper_24 extends AppCompatActivity {
    ArrayList<seed_helper_24_data> data, filter;
    // 필터는 비어있는 리스트지만 검색할때 기존 리스트에서 삭제를하고 여기에 추가시켜 보여준다
    BGM_Adapter 리사이클러어댑터;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_helper_24);

        data = new ArrayList();
        filter = new ArrayList();

        data.add(new seed_helper_24_data(R.drawable.less, "리스항구", "푸른빛 바다가 보이는 부둣가에서 갈매기가 날아다니는 것을 바라보고 있는 느낌이 들어."));
        data.add(new seed_helper_24_data(R.drawable.perion, "페리온", "황량한 바람이 부는 황무지 한가운데, 비장한 전투 부족과 마주친 느낌이 들어."));
        data.add(new seed_helper_24_data(R.drawable.ellinia, "엘리니아", "신비로운 느낌이 들어. 지금 요정들이 사는 숲속에 있는 게 아닐까?"));
        data.add(new seed_helper_24_data(R.drawable.henesys, "헤네시스", "맑고 경쾌한 음악이. 마치 언덕 위에서 버섯들이 뛰놀고 있는 것 같은 느낌이 들어."));
        data.add(new seed_helper_24_data(R.drawable.kerningcity, "커닝시티", "공사 중인 도시 어딘가,도둑들이 어슬렁거리 누군가의 지갑을 노리고 있을 것 같아."));
        data.add(new seed_helper_24_data(R.drawable.sleepywood, "슬리피우드", "잠들어 있는 거대한 나무 안에 들어 있는 느낌이 들어. 어딘가 익숙한 느낌이 드는데?"));
        data.add(new seed_helper_24_data(R.drawable.elluel, "에우렐", "꽃이 아름드리 진 나무 아래 요정들 잠들어 있을 것 같아."));
        data.add(new seed_helper_24_data(R.drawable.orbis, "오르비스", "하늘 위에 떠있 마을에서 천사들 날개를 펼치고 돌아다니고 있을 것 같아."));
        data.add(new seed_helper_24_data(R.drawable.elnath, "엘나스", "음,차가 벌판 위에서 펭귄들 늑대들이 종종걸음치는 것 같은걸."));
        data.add(new seed_helper_24_data(R.drawable.aquaroad, "아쿠아리움", "와,바다 안에서 물고기들과 헤엄치 노는 듯 통통 튀는 리듬이야."));
        data.add(new seed_helper_24_data(R.drawable.ludibrium, "루디브리엄", "귀여운 장난감과 로봇들이 돌아다니는 장난감 마을에 도착한 기분이야."));
        data.add(new seed_helper_24_data(R.drawable.omegasector, "지구방위본부", "빵야 빵야! 레이저 건을 들고 외계 생명들과 싸우고 있는 중이야!"));
        data.add(new seed_helper_24_data(R.drawable.koreanfolktown, "아랫마을", "으음,초가집 마루 아래 할머니의 무릎을 베고 누워 전래동화를 듣고 있는 기분이야."));
        data.add(new seed_helper_24_data(R.drawable.leafre, "리프레", "우와,맑은 하늘 위로 드래곤을 타고 비행하고 있는 기분이 들어!"));
        data.add(new seed_helper_24_data(R.drawable.ereve, "에레브", "나른한 오후, 아름다운 정원에서 신수와 여제가 서로에게 기대어 누워 휴식을 취하고 있나 봐."));
        data.add(new seed_helper_24_data(R.drawable.rien, "리엔", "사방이 얼음으로 뒤덮인 빙하 마을에서 펭귄이 여유롭게 낚시를 하고 있는걸."));
        data.add(new seed_helper_24_data(R.drawable.crystalgarden, "크리스탈 가든", "와,화려한 배를 타고 하늘을 날아오르고 있어! 엄청난 부자가 된 듯 위풍당당한 기분이 들어."));
        data.add(new seed_helper_24_data(R.drawable.ariant, "아리안트", "햇볕이 쨍하게 내리쬐는 사막 아래 코브라가 스멀스멀 항아리 밖으로 나올 것 같아."));
        data.add(new seed_helper_24_data(R.drawable.magatia, "마가티아", "음모가 도사린 어두운 골목 안에서 실종된 누군가를 찾는 듯 긴장감이 느껴져."));
        data.add(new seed_helper_24_data(R.drawable.mulungicon, "무릉", "우직한 곰들이 밝은 새벽부터 힘차게 수련하고 있을 것 같아."));
        data.add(new seed_helper_24_data(R.drawable.backcho, "백초마을", "안개로 둘러쌓인 마을에 1000년 묵은 신비한 약초를 캐러 온 약초꾼이 된 것 같아."));
        data.add(new seed_helper_24_data(R.drawable.edelstein, "에델슈타인", "뚝딱뚝딱.기계공들이 무언가를 만들고 있나 봐!"));
        data.add(new seed_helper_24_data(R.drawable.pantheon, "판테온", "드넓은 우주를 넘어 다른 행성에 놀러 온 듯 새로운 곳을 여행하는 기분이 들어."));
        data.add(new seed_helper_24_data(R.drawable.heliseum, "헬리시움 탈환 본부", "용맹한 용사들이 비장한 모습으로 성을 되찾으려는 듯 웅장한 느낌이 들어."));
        data.add(new seed_helper_24_data(R.drawable.foxvalley, "뾰족귀 여우마을", "수풀 속에서 귀여운 여우들이 귀를 쫑긋거리며 모습을 드러낼 것 같은걸."));


        RecyclerView bgmRv = (RecyclerView) this.findViewById(R.id.브금퀴즈);

        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
        bgmRv.setLayoutManager(리니어매니저);

        리사이클러어댑터 = new BGM_Adapter(this, data);//
        bgmRv.setAdapter(리사이클러어댑터);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(bgmRv.getContext(), new LinearLayoutManager(this).getOrientation());
        bgmRv.addItemDecoration(dividerItemDecoration);
        //디바이더 데코

        EditText 검색창 = (EditText) this.findViewById(R.id.검색);

        검색창.addTextChangedListener(new TextWatcher() { //검색창에 스티링값 들어오면 결과변경
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
                Intent move23 = new Intent(seed_helper_24.this, seed_helper_23.class);
                move23.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move23);
            }
        });

        Button btn36 = (Button) findViewById(R.id.시드36);

        btn36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move36 = new Intent(seed_helper_24.this, seed_helper_36.class);
                move36.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move36);
            }
        });
        Button btn39 = (Button) findViewById(R.id.시드39);

        btn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move39 = new Intent(seed_helper_24.this, seed_helper_39.class);
                move39.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move39);
            }
        });
        Button btn47 = (Button) findViewById(R.id.시드47);

        btn47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move47 = new Intent(seed_helper_24.this, seed_helper_47.class);
                move47.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move47);
            }
        });
        Button btn48 = (Button) findViewById(R.id.시드48);

        btn48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move48 = new Intent(seed_helper_24.this, seed_helper_48.class);
                move48.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move48);
            }
        });
        Button btn49 = (Button) findViewById(R.id.시드49);

        btn49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move49 = new Intent(seed_helper_24.this, seed_helper_49.class);
                move49.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move49);

            }
        });
    }

    public void searchFilter(String searchText) {

        filter.clear(); //필터 일단 싹비워주고(전에 검색했던기록 안나오게)

        for (int i = 0; i < data.size(); i++) {
            //아이템 전체목록 싹 훑어주고
            if (data.get(i).getTitle().toLowerCase().contains(searchText.toLowerCase())
                    || data.get(i).getDescription().toLowerCase().contains(searchText.toLowerCase())
                    ) {


//                검색창에 써진 텍스트와 비교해서 제목,설명이랑 일치하는 아이템을 찾아서
                filter.add(data.get(i));
                //아이템필터에 추가해주고
            }
        }

        리사이클러어댑터.itemfilter(filter);

    }
}
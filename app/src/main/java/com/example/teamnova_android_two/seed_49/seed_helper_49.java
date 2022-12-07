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
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
    ArrayList<seed_helper_49_data> data, filter,favorites_Filter,original_Data;
    //데이터모델 타입을 저장하는 어레이리스트 일반데이터,검색필터,즐겨찾기필터,즐겨찾기에서 원래데이터를 볼때 쓰는 오리지널데이터
    // 필터는 비어있는 리스트지만 검색할때 기존 리스트에서 삭제를하고 여기에 추가시켜 보여준다
    Monster_Quiz_Adapter 리사이클러어댑터;
    int 임시이미지 = R.drawable.garodung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_helper_49);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        data = new ArrayList();
        filter = new ArrayList();
        favorites_Filter = new ArrayList();
        original_Data = new ArrayList();


        data.add(new seed_helper_49_data("에델슈타인", "가로등", R.drawable.garodung,false));
        data.add(new seed_helper_49_data("마가티아", "강화된 아이언 뮤테", 임시이미지,false));
        data.add(new seed_helper_49_data("페리온", "겁먹은 와일드보어", 임시이미지,false));
        data.add(new seed_helper_49_data("페리온","고스텀프",임시이미지,false));
        data.add(new seed_helper_49_data("오르비스","네펜데스",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","귀마개 프릴드",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","구렁이",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","나팔꽃 화분",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","더키 패밀리",임시이미지,false));
        data.add(new seed_helper_49_data("오르비스","다크 네펜데스",임시이미지,false));
        data.add(new seed_helper_49_data("커닝시티","늪진흙괴물",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","더스트 박스",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","레츠",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","라츠",임시이미지,false));
        data.add(new seed_helper_49_data("헤네시스","돼지",임시이미지,false));
        data.add(new seed_helper_49_data("커닝시티","레이스",임시이미지,false));
        data.add(new seed_helper_49_data("헤네시스","리본 돼지",임시이미지,false));
        data.add(new seed_helper_49_data("마가티아","루모",임시이미지,false));
        data.add(new seed_helper_49_data("엘리니아","로얄 페어리",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","마스크피쉬",임시이미지,false));
        data.add(new seed_helper_49_data("지구방위본부","마티안",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","마스터 크로노스",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","마스터 로보",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","머미독",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","모래 두더지",임시이미지,false));
        data.add(new seed_helper_49_data("지구방위본부","메카티안",임시이미지,false));
        data.add(new seed_helper_49_data("지구방위본부","머신 MT-09",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","모래난쟁이",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","목도리 프릴드",임시이미지,false));
        data.add(new seed_helper_49_data("리엔","무루",임시이미지,false));
        data.add(new seed_helper_49_data("리엔","무루무루",임시이미지,false));
        data.add(new seed_helper_49_data("리엔","무루쿤",임시이미지,false));
        data.add(new seed_helper_49_data("리엔","무루피아",임시이미지,false));
        data.add(new seed_helper_49_data("리엔","무루파",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","물 도둑",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","미요캐츠",임시이미지,false));
        data.add(new seed_helper_49_data("엘리니아","버블링",임시이미지,false));
        data.add(new seed_helper_49_data("지구방위본부","바나드 그레이",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","버블피쉬",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","벨라모아",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","북치는 토끼",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","붉은 모래난쟁이",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","브라운테니",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","블랙 라츠",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","블록골렘",임시이미지,false));
        data.add(new seed_helper_49_data("무릉","비급",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","블록퍼스",임시이미지,false));
        data.add(new seed_helper_49_data("헤네시스","뿔버섯",임시이미지,false));
        data.add(new seed_helper_49_data("커닝시티","새싹진흙괴물",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","순찰로봇",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","새싹 화분",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","순찰로봇S",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","스켈독",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","스콜피언",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","스카이세이버",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","스톤 마스크",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","스파커",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","씨클",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","안전제일",임시이미지,false));
        data.add(new seed_helper_49_data("지구방위본부","원로 그레이",임시이미지,false));
        data.add(new seed_helper_49_data("커닝시티","주니어 레이스",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","주니어 카투스",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","크로노스",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","킹 블록골렘",임시이미지,false));
        data.add(new seed_helper_49_data("에레브","티루",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","틱톡",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","포이즌 푸퍼",임시이미지,false));
        data.add(new seed_helper_49_data("지구방위본부","플라티안",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","핑크테니",임시이미지,false));
        data.add(new seed_helper_49_data("헤네시스","스포아",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","아기 바위베어먹기",임시이미지,false));
        data.add(new seed_helper_49_data("커닝시티","옥토퍼스",임시이미지,false));
        data.add(new seed_helper_49_data("아랫마을","월묘",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","장난감 목마",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","치크세이버",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","크립",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","킹 블록퍼스",임시이미지,false));
        data.add(new seed_helper_49_data("에레브","티노",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","티키",임시이미지,false));
        data.add(new seed_helper_49_data("엘리니아","페어리",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","플라워 피쉬",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","핑크세이버",임시이미지,false));
        data.add(new seed_helper_49_data("오르비스","스톤볼",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","씨코",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","아이언호그",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","우드 마스크",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","이상한 이정표",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","주니어 부기",임시이미지,false));
        data.add(new seed_helper_49_data("헤네시스","짜증내는 좀비버섯",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","큰 바위베어먹기",임시이미지,false));
        data.add(new seed_helper_49_data("마가티아","트리플 루모",임시이미지,false));
        data.add(new seed_helper_49_data("에레브","티무",임시이미지,false));
        data.add(new seed_helper_49_data("헤네시스","파란 리본돼지",임시이미지,false));
        data.add(new seed_helper_49_data("에델슈타인","포도주스병",임시이미지,false));
        data.add(new seed_helper_49_data("루디브리엄","플래툰 크로노스",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","히죽대는 고스텀프",임시이미지,false));
        data.add(new seed_helper_49_data("엘리니아","슬라임",임시이미지,false));
        data.add(new seed_helper_49_data("마가티아","아이언 뮤테",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","와일드보어",임시이미지,false));
        data.add(new seed_helper_49_data("지구방위본부","울트라 그레이",임시이미지,false));
        data.add(new seed_helper_49_data("커닝시티","주니어 네키",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","주니어 씰",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","크라피",임시이미지,false));
        data.add(new seed_helper_49_data("아리안트","키요",임시이미지,false));
        data.add(new seed_helper_49_data("에레브","티구르",임시이미지,false));
        data.add(new seed_helper_49_data("에레브","티브",임시이미지,false));
        data.add(new seed_helper_49_data("페리온","파이어보어",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","프리져",임시이미지,false));
        data.add(new seed_helper_49_data("아쿠아리움","핀붐",임시이미지,false));

        //임시로 즐겨찾기 상태를 전부 펄스로 해놨으나
        //이렇게하면 재시작할때마다 모든상태가 초기화될것임
        //로컬Db 과제 진행할때 재실행시엔 로컬디비에있는 자료 기반으로 실행시키게 하던가
        //조치를 해야될거같음

        RecyclerView mQuizRv = (RecyclerView) this.findViewById(R.id.퀴즈);

        StaggeredGridLayoutManager staggeredGridLayoutManager
                = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
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
        CheckBox 즐찾리스트 = (CheckBox) this.findViewById(R.id.즐찾리스트);
        즐찾리스트.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true){
                    favorites_List(isChecked);
                }else if(isChecked == false){
                    리사이클러어댑터.original_Filter(original_Data);
                }

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
    public void favorites_List(boolean isChecked) {

        favorites_Filter.clear(); //필터 일단 싹비워주고(전에 추가했던기록 안나오게)
        original_Data.clear();//원본데이터 초기화

        for (int i = 0; i < data.size(); i++) {
            //아이템 전체목록 싹 훑어주고
            original_Data.add(data.get(i)); // 원본데이터에 모든데이터 일단추가
            if (data.get(i).getIschecked() == true) {

//                검색창에 써진 텍스트와 비교해서 몬스터이름,지역명 이랑 일치하는 아이템을 찾아서
                favorites_Filter.add(data.get(i));
                //아이템필터에 추가해주고
            }
        }
        리사이클러어댑터.itemfilter(favorites_Filter); // 기존 어레이리스트 교체
        //원래대로 되돌리는로직 짜야함

    }
}
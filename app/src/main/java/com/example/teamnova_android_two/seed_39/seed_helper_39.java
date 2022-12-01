package com.example.teamnova_android_two.seed_39;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

        data = new ArrayList();
        filter = new ArrayList();

        data.add(new seed_helper_39_data("골드비치 리조트에 거주하는 잡화 상인 이름은?","1. 스크루지","2. 나탈리","3. 메이슨 ø","4. 베티"));
        data.add(new seed_helper_39_data("노틸러스의 무기 상인 이름은?","1. 리드","2. 프란시스","3. 테스","4. 모건 ø"));
        data.add(new seed_helper_39_data("노틸러스의 잡화 상인 이름은?","1. 잭","2. 시나몬","3. 미르","4. 갤리 ø"));
        data.add(new seed_helper_39_data("노틸러스의 창고지기 이름은?","1. 슈리츠","2. 다고쓰","3. 론도","4. 돈틀레스 ø"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 튼튼한 방어구가 필요하다면 잠깐 여기에 들려보지 그래?","1. 루이스","2. 마이크","3. 로도스 ø","4. 미르"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 고대 노바의 신을 모시고 있습니다.","1. 소피아","2. 브로커 정","3. 펜릴 ø","4. 론도"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 나의 근육을 보라구. 나처럼 강해지고 싶지 않나?","1. 지미","2. 뮤네","3. 쿤 ø","4. 테스"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 난 앞치마가 잘 어울리는 남자야.","1. 헬레나","2. 일렉스 ø","3. 크루소","4. 프레드릭"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 날씨가 참 좋죠? 해피와 산책하기 좋은 날씨입니다.","1. 큐트","2. 게렉터 ø","3. 시나몬","4. 알렉스"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 내가 주워왔으니까 내가 책임져!","1. 비어완","2. 프레드릭","3. 골드리치","4. 랑 ø"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 누가 대신 먹이좀 구해줬으면 좋겠다.","1. 다니카","2. 고로","3. 따비","4. 돌돌 ø"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 도둑질해 가는 사람을 용서하지 않을거야!","1. 일스","2. 해리 ø","3. 자아","4. 루이스"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 모두 힘을 합해야만 해요.","1. 리나","2. 라케리스 ø","3. 다고쓰","4. 베티"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 몸을 푼 지 얼마되지 않았답니다.","1. 디테","2. 랑","3. 캘리코","4. 따비 ø"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 상전벽해... 세월따라 세상도 많이 변하였소","1. 도공 ø","2. 기옹","3. 구영감","4. 노공"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 손이 예전같지 않아.. 어서 제자를 한 명 거뒀으면 좋겠는데..","1. 기옹 ø","2. 이옹","3. 김영감", "4. 구영감"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 숙제도 많고 공부도 해야되고..바쁘다..","1. 요정 윙 ø","2. 요정 아르웬","3. 요정 잭","4. 요정 로웬"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 아궁이 불을 뗄 땔감이 부족하네","1. 이토스","2. 슈미","3. 로도스","4. 고로 ø"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 악마의 문서를 가지고 있다면 나한테 맡겨 보는건 어때?","1. 휴머노이드 C","2. 지니 ø","3. 리드","4. 슈미"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 앞이 보이냐고? 뭘 당연한걸 묻는거지?","1. 페이슨","2. 푸노운 ø","3. 푸카","4. 소피아"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 약초를 모으고 있다네…","1. 사비트라마 ø","2. 벼루","3. 키리두","4. 로도스"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 어라…? 내 연구자료가 어디로 갔지?","1. 에스텔","2. 제피","3. 케리","4. 마법사 쿠디 ø"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 요즘 몬스터들이 사나워진 것 같아 걱정이에요.","1. 큐트","2. 리사 ø","3. 푸츠키","4. 지미"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 일도 중요하지만 맛있는 거 먹는것도 참 중요하지","1. 오심마","2. 바반 ø","3. 프란시스","4. 에스텔"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 제 옆의 델브는 경비서는 일은 항상 지겹다고 난리죠.","1. 토리","2. 장난감병정 올슨 ø","3. 잭","4. 그윈"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 친구인 아르웬은 인간을 불편해 한답니다.","1. 요정 로웬 ø","2. 요정 루엔","3. 요정 윙","4. 요정 푸링"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 킁킁…이게 무슨 냄새죠?","1. 유타","2. 페일","3. 알비올라 ø","4. 마녀 바바라"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 태상에게 약초를 빨리 보내주어야 할텐데… 흐흠…","1. 구영감 ø","2. 김영감","3. 박영감","4. 조영감"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 하인즈가 나쁜 사람은 아니지만..","1. 요정 아르웬 ø","2. 무라트","3. 프델라","4. 요정 수"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 해수면의 상승이 멈춰야 할 텐데..","1. 도베르만","2. 슈미","3. 푸탄 ø","4. 천지"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 해적은 최강! 한 판 붙어 보자고요!","1. 베티","2. 마파","3. 라엘","4. 발레리 ø"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 혼자 노는 것도 심심해… 후~","1. 체프","2. 앤 ø","3. 푸로","4. 유타"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 흐음 자네도 득도의 수련을 해볼텐가?","1. 노공 ø","2. 도공","3. 기옹","4. 구영감"));
        data.add(new seed_helper_39_data("누구의 대사일까? - 흥, 외부인은 도무지 신뢰할 수 없다니까.","1. 라니아","2. 알렉스","3. 토푸","4. 교감 카라얀 ø"));
        data.add(new seed_helper_39_data("다음 중 검사의 스킬로 옳지 않은 것은?","1. 아이언 바디","2. 상상력 증가 ø","3. 리프 어택","4. 슬래시 블러스트"));
        data.add(new seed_helper_39_data("다음 중 나이트워커의 스킬로 옳지 않는 것은?","1. 콜래트럴 플래시 ø","2. 다크니스","3. 헤이스트","4. 매직 스틸"));
        data.add(new seed_helper_39_data("다음 중 나이트워커의 스킬로 옳지 않는 것은?","1. 콜래트럴 플래시 ø","2. 쉐도우 서번트","3. 헤이스트","4. 도미니언"));
        data.add(new seed_helper_39_data("다음 중 노바에 속하는 직업은?","1. 엔젤릭버스터 ø","2. 팔라딘","3. 신궁","4. 섀도어"));
        data.add(new seed_helper_39_data("다음 중 노바에 속하는 직업은?","1. 카이저 ø","2. 소울마스터","3. 미하일","4. 메르세데스"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 무루파 ø","2. 갈색 가시 곰","3. 샐리온","4. 붉은 모래 난쟁이"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 그린 플라워 카우","2. 그류핀","3. 벨라모아","4. 룰랑 ø"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 고대 붉은 거북 ø","2. 크로코","3. 엘리쟈","4. 파랑 식충 슬라임"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 와일드카고","2. 리게이터","3. 고대 식충 슬라임 ø","4. 프릴드"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 블루 플라워 카우","2. 노랑 버섯 박쥐","3. 블루 고대 풍뎅이 ø","4. 고대 주황 거북"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 고대 파랑 거북","2. 옐로 플라워 카우 ø","3. 헥터","4. 노랑 식충 슬라임"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 고대 주황 거북","2. 검은 가시 곰 ø","3. 화이트팽","4. 벨라모아"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 플라워 골렘","2. 클랑","3. 푸른 버섯 박쥐 ø","4. 흰 가시 곰"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 흰 가시 곰","2. 라이오너","3. 프릴드","4. 크로커다일 ø"));
        data.add(new seed_helper_39_data("다음 중 더 시드에 등장하지 않는 몬스터는?","1. 검은 플라워 골렘","2. 로랑","3. 고대 버섯 박쥐 ø","4. 고대 파랑 거북"));
        data.add(new seed_helper_39_data("다음 중 데몬슬레이어의 스킬로 옳지 않을 것은?","1. 마인드 스킨 ø","2. 뱀피릭 터치","3. 메이플 용사","4. 다크 바인드"));
        data.add(new seed_helper_39_data("다음 중 동물형 몬스터가 아닌 것은?","1. 게릴라 스펙터","2. 스포아 ø","3. 풍선쥐","4. 황금 돼지"));
        data.add(new seed_helper_39_data("다음 중 레지스탕스에 속하는 직업은?","1. 카이저","2. 엔젤릭버스터","3. 비숍","4. 데몬어벤져 ø"));
        data.add(new seed_helper_39_data("다음 중 레지스탕스에 속하는 직업은?","1. 히어로","2. 나이트로드","3. 나이트워커","4. 제논 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?","1. 벨더","2. 피아","3. 디제이쿠 ø"," 4. 돌고래"));
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());//ø
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());
        data.add(new seed_helper_39_data());







//        data.add(new seed_helper_39_data());

        RecyclerView QuizRv = (RecyclerView) this.findViewById(R.id.퀴즈);

        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
        QuizRv.setLayoutManager(리니어매니저);

        리사이클러어댑터 = new Quiz_Adapter(this, data);//
        QuizRv.setAdapter(리사이클러어댑터);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(QuizRv.getContext(), new LinearLayoutManager(this).getOrientation());
        QuizRv.addItemDecoration(dividerItemDecoration);
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
    public void searchFilter(String searchText) {

        filter.clear(); //필터 일단 싹비워주고(전에 검색했던기록 안나오게)

        for (int i = 0; i < data.size(); i++) {
            //아이템 전체목록 싹 훑어주고
            if (data.get(i).getQuestion().toLowerCase().contains(searchText.toLowerCase())
                    || data.get(i).getAnswer1().toLowerCase().contains(searchText.toLowerCase())
                    || data.get(i).getAnswer2().toLowerCase().contains(searchText.toLowerCase())
                    || data.get(i).getAnswer3().toLowerCase().contains(searchText.toLowerCase())
                    || data.get(i).getAnswer4().toLowerCase().contains(searchText.toLowerCase())

            ) {
//                || data.get(i).getDescription().toLowerCase().contains(searchText.toLowerCase())

                //설명으로 찾으면 지울때오류남..

//                검색창에 써진 텍스트와 비교해서 제목,설명이랑 일치하는 아이템을 찾아서
                filter.add(data.get(i));
                //아이템필터에 추가해주고
            }
        }

        리사이클러어댑터.itemfilter(filter);

    }
}
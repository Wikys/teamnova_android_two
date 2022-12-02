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
import com.example.teamnova_android_two.seed_24.seed_helper_24;
import com.example.teamnova_android_two.seed_helper_23;
import com.example.teamnova_android_two.seed_helper_36;
import com.example.teamnova_android_two.seed_helper_47;
import com.example.teamnova_android_two.seed_helper_48;
import com.example.teamnova_android_two.seed_49.seed_helper_49;

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
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?","1. 카탈리온","2. 제크","3. 듀이","4. 스티치 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?","1. 아구몽 ø","2. 헤르샤","3. 이카루스","4. 스크루지"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?","1. 찰즈 ø","2. 레아","3. 베티","4. 마티어스"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?","1. 셀렌","2. 재클린 ø","3. 박서방","4. 몽땅따"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?","1. 헤이즈 ø", "2. 카산드라","3. 쉐인","4. 레아"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?","1. 장로 스탄","2. 클라라","3. 카이조 ø", "4. 레아"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?", "1. 큐트", "2. 네벨","3. 자이언트조 ø", "4. 스크루지"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?", "1. 펜릴", "2. 세빌 ø","3. 클리앙","4. 넬라"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 거주하는 주민의 이름이 아닌 것은?", "1. 도공","2. 카르노 ø","3. 비비","4. 골드리치"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 락 스피릿","2. 디아블로우 ø","3. 벨룸","4. 신수"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 듀나스","2. 드래곤 라이더","3. 이뮤르크 ø","4. 피에르"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?", "1. 아우프헤벤","2. 렉스","3. 이리나","4. 베어구릴스 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?", "1. 니벨룽겐 전함", "2. 벨제붑 ø","3. 이카르트","4. 드래고니카"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 보티첼리 ø","2. 반반","3. 교도관 아니","4. 매그너스"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 반반","2. 샤모스 ø","3. 아카이럼","4. 호크아이"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 칼리쉬 ø","2. 마왕 발록","3. 반반","4. 오즈"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 크세르크세스","2. 라바나","3. 반 베놈 ø","4. 여제 시그너스"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 베르가모트","2. 코커트리스 ø","3. 반 레온","4. 힐라"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 등장한 적 없는 보스 몬스터는?","1. 빅브라더 ø","2. 드래고니카","3. 강화형 포이즌 골렘","4. 블러디 퀸"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 쥬니퍼베리 꽃","2. 다이아몬드의 원석","3. 쓰다만 거푸집 ø","4. 체력 회복 포션 1000"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 카모마일 꽃","2. 리튬의 원석","3. 힘의 물약","4. 니켈 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?", "1. 클라리세이지","2. 매그너스의 땀방울 ø","3. 하급 연마제","4. 오리할콘"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 사랑이 담긴 초콜릿 ø","2. 빛바랜 은의 원석","3. 은","4. 마조람 꽃 오일"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 허브 오일병","2. 할미꽃 씨앗 ø","3. 동물의 가죽","4. 무루무루의 털뭉치"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 티트리 씨앗","2. 미스릴의 원석","3. 사파이어","4. 페니실린 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 히솝 꽃","2. 중급 거푸집","3. 페어리 샌드 ø","4. 마법의 가루(검정)"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 자스민 씨앗","2. 크립토나이트 원석 ø","3. 강철","4. 죽은자의 부적"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 자쿰의 눈물 ø","2. 자수정의 원석","3. 오팔","4. 1단계 마력의 물약"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 페츌리 꽃","2. 지혜의 크리스탈 원석","3. 하급 포션 응고제","4. 히야신스 주스 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하는 제작 재료가 아닌 것은?","1. 카모마일 꽃","2. 리튬의 원석","3. 1단계 힘의 물약","4. 니켈 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 에레브","2. 슬리피우드","3. 크레아티스 ø","4. 커닝시티"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 커닝시티","2. 백조마을 ø","3. 페리온","4. 리프레"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 사라세니아 ø","2. 마가티아","3. 노틸러스","4. 아리안트"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 페리온","2. 무릉","3. 프랑켄슈타인 ø","4. 에우렐"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 헤네시스","2. 판교 ø","3. 커닝시티","4. 백초마을"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 리스항구","2. 오르비스","3. 백초마을","4. 아쿠아아쿠아 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 슬리핑포레스트 ø","2. 리엔","3. 에델슈타인","4. 아리안트"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 엘리니브 ø","2. 에델슈타인","3. 크리티아스","4. 리스항구"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 오르비스","2. 아쿠아리움","3. 컨닝시티 ø","4. 엘리니아"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 도시는?","1. 여섯갈래길","2. 엘나스","3. 루디브리엄","4. 마가레트 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 서전아이","2. 다우니 ø","3. 로얄 카투스","4. 버블피쉬"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 스톤골렘","2. 추억의 신관","3. 레드 페퍼즈 ø","4. 뉴트 주니어"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 파란버섯","2. 플라워 피쉬","3. 큐브슬라임","4. 슬레지 햄머 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 와일드보어","2. 베르가모트","3. 주니어 씰","4. 탑승형 골렘 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 스톤 마스크","2. 레드 와이번","3. 베르투스 ø","4. 샐리온"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 주니어 레이스","2. 쏠라리온 ø","3. 레드 드레이크","4. 호걸"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?", "1. 펜릴 ø","2. 핑크테니","3. 페페","4. 블록퍼스"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 스켈독","2. 다크 코니언","3. 벨라모아","4. 샤프란 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 달팽이","2. 다크 케투스 ø","3. 로보토이","4. 난폭한 화장대"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 몬스터는?","1. 옥토퍼스","2. 팬텀워치","3. 코르비 ø","4. 씨클"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 슈가의 요리모자 ø","2. 블루얼 페긴트","3. 혼테일의 목걸이","4. 스컹크의 방독면"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 하프 이어링","2. 헬리시움 정예 도적 망토","3. 혼돈의 포션","4. 필사의 머리삔 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 빨간색 자일즈의 망토","2. 엔젤릭 블레스","3. 슈가의 조그만 지팡이 ø","4. 퍼플 카스트 린넨"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 강인함의 그린 골드 벨트","2. 샤크투스 플람","3. 빨간색 세라프의 망토","4. 솔로의 저주가 담긴 커플링 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 제이드 해츨링","2. 미노타우로스 코뚜레 ø","3. 불멸의 파라오의 벨트","4. 장미꽃 귀고리"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 디펜스의 달인","2. 연금술사의 수제장갑 ø","3. 블랙 바실즈 부츠","4. 자쿰의 투구"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 레드 바이퍼","2. 봄버드 센터 파이어","3. 화이트 피니얼","4. 베놈 바이퍼 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 불사조의 꼬리깃털 ø","2. 디멘션 글러브","3. 금이 간 안경","4. 러브리스 피오니"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 카오스 핑크빈 모자","2. 얼티밋 하프 헬름 ø","3. 콘체르토","4. 더키의 스노클"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 아이템은?","1. 템페스트 견장","2. 얼티밋 링","3. 은총받은 선글라스 ø","4. 브라운 더블드 부츠"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 핑크 물개쿠션","2. 말년 병장 의자 ø","3. 데비존 의자","4. 전치 10주 의자"));
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



//                검색창에 써진 텍스트와 비교해서 제목,설명이랑 일치하는 아이템을 찾아서
                filter.add(data.get(i));
                //아이템필터에 추가해주고
            }
        }

        리사이클러어댑터.itemfilter(filter);

    }
}
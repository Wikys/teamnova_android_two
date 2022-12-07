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
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 뱀부 체어","2. 홍상모 월묘 방석","3. 소울테니 의자","4. 다이아몬드 욕조 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 내게 돌아와 의자 ø","2. 찰떡 아이스","3. 꿈 해몽 의자","4. 길드 의자"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 여우비 의자","2. 감나무 그네","3. 곰돌이 침대","4. 래피의 감나무 의자 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 단풍나무 아래서","2. 트로피컬 썸머 체어","3. 드래곤의 알","4. 첫사랑의 순정 의자 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 나무 욕조","2. 레드 디자인체어","3. 휠체어 ø","4. 와글친구 의자"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 릴렉스 체어","2. 맘모스 의자 ø","3. 힐라의 겟잇뷰티","4. 야영 모닥불 의자"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 사랑의 의자","2. 핑크 비치파라솔","3. 발렌타인의 저주 의자 ø","4. 꿈꾸는 화가 의자"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 3월 토끼 의자 ø","2. 달님별님 쿠션","3. 시추시계 의자","4. 러브 체어"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 의자는?","1. 노블레스 의자","2. 튼튼한 나무의자","3. 토끼 의자","4. 돈방석 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 데몬 슬레이어","2. 신궁","3. 트레져헌터 ø","4. 나이트로드"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 아크메이지(썬,콜)","2. 메르세데스","3. 아트디자이너 ø","4. 카인"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 팔라딘","2. 에반","3. 나이트워커","4. 윈드러너 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 데몬헌터 ø","2. 보우마스터","3. 듀얼블레이드","4. 스트라이커"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 히어로","2. 플레임위자드","3. 댄스마스터 ø","4. 소울마스터"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 미하일","2. 윈드브레이커","3. 바이퍼","4. 미사일 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 다크나이트","2. 배틀메이지","3. 캐논펀쳐 ø","4. 아란"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 비숍","2. 나이트로드","3. 섀도어","4. 던전마스터 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 아크메이지(불,독)","2. 와일드헌터","3. 캡틴","4. 네크로맨서 ø"));
        data.add(new seed_helper_39_data("다음 중 메이플스토리에 존재하지 않는 직업은?","1. 섀도우 마스터 ø","2. 메카닉","3. 팬텀","4. 캐논슈터"));
        data.add(new seed_helper_39_data("다음 중 메카닉의 스킬로 옳지 않을 것은?","1. 호밍 미사일","2. 퍼펙트 아머","3. 개틀링 샷","4. 클레이모어 ø"));
        data.add(new seed_helper_39_data("다음 중 모험가에 속하는 직업은?","1. 소울마스터","2. 에반","3. 제논","4. 신궁 ø"));
        data.add(new seed_helper_39_data("다음 중 모험가에 속하는 직업은?","1. 와일드헌터","2. 비숍 ø","3. 팬텀","4. 데몬 어벤져"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 탱글탱글 포도농장","2. 리엔 온천","3. 천연 황토 집 ø","4. 에레브 분수정원"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 초가집","2. 핑크 엔젤 하우스","3. 메이플 워터 파크 ø","4. 리엔 이글루"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 주주 우유농장","2. 플로팅 캐슬","3. 초밥 전문점 ø","4. 오르비스 비행정원"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 헤네시스 집","2. 양식장 ø","3. 깜짝상자집","4. 클락 하우스"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 나무꾼의 집","2. 아리안트 집","3. 에델슈타인 비행장","4. 메이플 수상 가옥 ø"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 동굴 집 ø","2. 해산물 식당","3. 에우렐 집","4. 피아노"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 초록 버섯집","2. 검은 토끼 농장 ø","3. 무기상점","4. 산타의 집"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 판테온 신전 ø","2. 오아시스","3. 핑크 엔젤 하우스","4. 노틸러스호 선착장"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 아지트 ø","2. 쿠키 하우스","3. 붉은 버섯집","4. 우동집"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 검은 집 ø","2. 과일상점","3. 노바의 집","4. 2층 새둥지 집"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 놀이공원 바이킹","2. 깜짝상자 풍선 집","3. 깜짝상자집","4. 샤모스 창고 ø"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 생츄어리 ø","2. 노랑 잠수함","3. 비화원","4. 아모리아 콘서트홀"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 빨간 벽돌집","2. 버섯왕국 초소","3. 서커스장","4. 과수원 ø"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 천연 빙하집","2. 클럽 헤네시스 ø","3. 에우렐 집","4. 루디브리엄 장난감집"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 아모리아 콘서트홀","2. 무릉 이발소","3. 아쿠아쿠리움 수족관 ø","4. 아쿠아로드 저택"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 주황 버섯집","2. 블로섬 하우스","3. 퓨리엘 집 ø","4. 무릉 수련장"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 헤네시스 궁수길드","2. 할로윈 캐슬","3. 우동집","4. 여제의 기도원 ø"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 버섯버섯 광산 ø","2. 파랑 3단 버섯집","3. 풍차","4. 크리스탈 가든"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 아쿠아로드 소라집","2. 사이킥 오디션 홀 ø","3. 아리안트 집","4. 신수의 둥지"));
        data.add(new seed_helper_39_data("다음 중 몬스터 라이프에 등장하는 건물이 아닌 것은?","1. 한옥집","2. 24시간 병원","3. 지하 수련장 ø","4. 자쿰의 동굴"));
        data.add(new seed_helper_39_data("다음 중 무형 몬스터가 아닌 것은?","1. 양파라고라","2. 아리엘","3. 소라문어 슬라임","4. 앙뚜아네뜨 ø"));
        data.add(new seed_helper_39_data("다음 중 무형 몬스터가 아닌 것은?","1. 무닌","2. 안전제일","3. 망둥이 ø","4. 하늘 수호령"));
        data.add(new seed_helper_39_data("다음 중 미하일의 스킬로 옳지 않는 것은?","1. 소울 아카이브 ø","2. 소울 실드","3. 소울 어질리티","4. 샤이닝 피어스"));
        data.add(new seed_helper_39_data("다음 중 배틀메이지 스킬로 옳지 않은 것은?","1. 하이 위즈덤","2. 쿼드 블로우","3. 드레인 오라","4. 드로우 마나 ø"));
        data.add(new seed_helper_39_data("다음 중 불사형 몬스터가 아닌 것은?","1. 좀비머쉬맘","2. 제등귀신","3. 파우스트","4. 핑크빈 ø"));
        data.add(new seed_helper_39_data("다음 중 불사형 몬스터가 아닌 것은?","1. 고스트","2. 유령","3. 자격의 도도 ø","4. 파우스트"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 마법사의 가루약 ø","2. 빨간 포션","3. 재물 획득의 비약","4. 새벽의 이슬"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 써니텐 엘릭서","2. 크로스헌터 마력 포션","3. 갑오년 각성의 비약 ø","4. 소형 경험 축적의 비약"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 벅카스D ø","2. 주황포션","3. 경험 축적의 비약","4. 달걀"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 파란포션","2. 미지근한 주스 ø","3. 각성의 비약","4. 전설의 체력 비약"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 하얀포션","2. 요정의 이슬 ø","3. 무적의 비약","4. 집중의 비약"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 떡꼬치","2. 마나 엘릭서 알약","3. 훈제 연어 ø","4. 파란별 물약"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 엔젤의 발걸음","2. 밸류 포션","3. 스페셜 체력 회복 물약","4. 파티용 치즈 ø"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 살살 녹는 치즈","2. 1단계 행운의 알약","3. 발굴한 축복의 비약","4. 보라빛 물약 ø"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 속도 향상의 알약","2. 엘릭서","3. 자쿰의 숨결 ø","4. 인내의 비약"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 통증 완화제","2. 빨간 포션 알약","3. 갑오년 인내의 비약 ø","4. 자이언트 비약"));
        data.add(new seed_helper_39_data("다음 중 소비 아이템이 아닌 것은?","1. 고급 향수","2. 밸류 포션","3. 스페셜 체력 회복 물약","4. 파티용 치즈 ø"));
        data.add(new seed_helper_39_data("다음 중 시그너스에 속하는 직업은?","1. 배틀메이지","2. 플레임위자드 ø","3. 팬텀","4. 루미너스"));
        data.add(new seed_helper_39_data("다음 중 시그너스에 속하는 직업은?","1. 엔젤릭버스터","2. 나이트워커 ø","3. 아란","4. 데몬 슬레이어"));
        data.add(new seed_helper_39_data("다음 중 식물형 몬스터가 아닌 것은?","1. 나팔꽃 화분","2. 파이렛 옥토 ø","3. 초록 버섯","4. 데우"));
        data.add(new seed_helper_39_data("다음 중 신궁의 스킬로 옳지 않은 것은?","1. 마크맨쉽","2. 피어싱","3. 문워크 ø","4. 일루전 스텝"));
        data.add(new seed_helper_39_data("다음 중 악마형 몬스터가 아닌 것은?","1. 불량학생 ø","2. 방금 사귄 커플버섯","3. 고백하러 가는 판다곰","4. 잭오랜턴"));
        data.add(new seed_helper_39_data("다음 중 어류형 몬스터가 아닌 것은?","1. 클랑","2. 검은 마법사의 와이번 ø","3. 킹크랑","4. 피아누스"));
        data.add(new seed_helper_39_data("다음 중 영웅에 속하는 직업은?","1. 아크메이지(불,독)","2. 나이트로드","3. 메르세데스 ø","4. 보우마스터"));
        data.add(new seed_helper_39_data("다음 중 영웅에 속하는 직업은?","1. 배틀메이지","2. 다크나이트","3. 루미너스 ø","4. 아크메이지(썬,콜)"));
        data.add(new seed_helper_39_data("다음 중 윈드브레이커의 스킬로 옳지 않은 것은?","1. 더블샷 위쳐 ø","2. 거스트 샷","3. 보우 마스터리","4. 실프스 에이드"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 통백권","2. 불여우령 숙련","3. 스텀핑 어 머드홀 ø","4. 하이퍼 애큐러시"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 통백권","2. 불여우령 숙련","3. 스텀핑 어 머드홀 ø","4. 분혼 격참"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 너클 숙련","2. 환령 강신","3. 하이퍼 버팅 ø","4. 히어로즈 오쓰"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 약화","2. 정령 결속 4식","3. 건곤 일체","4. 슬리퍼 홀드 ø"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 파력권","2. 분홍 파참 ø","3. 메이플 용사","4. 소혼 결계"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 근력 단련","2. 폭류권","3. 심의육합권 ø","4. 정령 결속 극대화"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 팔극 4타 ø","2. 섬권","3. 사혼 각인","4. 너클 숙련"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 태극 2타 ø","2. 메가 펀치","3. 귀참","4. 후방 이동"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 소혼 장막","2. 약점 간파","3. 도약","4. 참격 ø"));//ø
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 여우령","2. 속박술","3. 난투 ø","4. 정령의 화신"));
        data.add(new seed_helper_39_data("다음 중 은월의 스킬에 속하지 않는 것은?","1. 도약","2. 천근추 ø","3. 분혼 격참","4. 귀참"));
        data.add(new seed_helper_39_data("다음 중 정령형 몬스터가 아닌 것은?","1. 달팽이 ø","2. 페어리","3. 오렌지톤","4. 아기 바위베어먹기"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 어스 브레이크","2. 크림슨 커터 ø","3. 롤링 커브","4. 어퍼 슬래시"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 스핀 커터","2. 디바인 리어","3. 사이킥 트레이서 ø","4. 스로잉 웨폰"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 컴뱃 리커버리","2. 윈드 커터","3. 이뮨 배리어","4. 문설트 ø"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 솔리드 바디","2. 스톰 브레이크","3. 더블 스트레치 ø","4. 문 스트라이크"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 스로잉 웨폰","2. 기가 크래시","3. 어스 브레이크","4. 파일 드라이버 ø"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 점핑 크래시","2. 데들리 액션 ø","3. 터닝 드라이브","4. 태도 마스터리"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 어드밴스드 롤링 커브","2. 크로스 라인 ø","3. 아머 스플릿","4. 쉐도우 스트라이크"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 플래시 어썰터","2. 로 블로 ø","3. 휠 윈드","4. 피어스 쓰러스트"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 점핑 파워 봄 ø","2. 크리티컬 바인드","3. 프론트 슬래시","4. 파워 스텀프"));
        data.add(new seed_helper_39_data("다음 중 제로의 스킬에 속하지 않는 것은?","1. 파이트 스플래쉬 ø","2. 윈드 스트라이크","3. 리인포스 바디","4. 대검 마스터리"));
        data.add(new seed_helper_39_data("다음 중 캐논슈터의 스킬로 옳지 않는 것은?","1. 슬러그 샷","2. 캐논 마스터리","3. 몽키 매직","4. 패스트 리로드 ø"));
        data.add(new seed_helper_39_data("다음 중 파충류형 몬스터가 아닌 것은?","1. 청화사","2. 리게이터","3. 강력한 콜드아이","4. 주니어 레이스 ø"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 제령 ø","2. 가디언 스피릿","3. 디바인 스티그마","4. 어드밴스드 홀리 포스"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 홀리 포스","2. 아킬레스","3. 노블 디맨드","4. 블레싱 ø"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 아이언 바디","2. 추격 ø","3. 컴뱃 오더스","4. 팔라딘 엑스퍼트"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 파이널 어택","2. 페이지 오더","3. 헤이스트 ø","4. 생츄어리"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 웨폰 마스터리","2. 디바인 저지먼트","3. 맨디블 클로우 ø","4. 블래스트"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 실신한 기도 ø","2. 워리어 마스터리","3. 리스토네이션","4. 스탠스"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 워리어 리프","2. 디바인 스윙","3. 라이트닝 액션 ø","4. 디바인 차지"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 피지컬 트레이닝","2. 실드 마스터리","3. 리갈 스트레치 ø","4. 용사의 의지"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 슬래시 블러스트","2. 플레임 디펜스 ø","3. 돌진","4. 메이플 용사"));
        data.add(new seed_helper_39_data("다음 중 팔라딘의 스킬에 속하지 않는 것은?","1. 웨폰 액셀레이션","2. 블레싱 아머","3. 파라쇼크 가드","4. 디바인 소드 ø"));
        data.add(new seed_helper_39_data("다음 중 팬텀의 스킬로 옳지 않는 것은?","1. 미스포츈 프로텍션","2. 퍼펙트 센스 ø","3. 어큐트 센스","4. 플래시 앤 플리"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 카오스 호크 헤드","2. 레볼루션 소드","3. 특제 삼지창 ø","4. 발렌티어"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 메이플 우산","2. 스파타","3. 문 글로리 ø","4. 레이븐혼 바젤라드"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 케이그","2. 나무망치 ø","3. 광선 채찍","4. 플레인 알파"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 양날 도끼","2. 행복 화이트 소드","3. 선구자의 듀얼윙 ø","4. 딤 메모리"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 선구자의 모울 ø","2. 용기의 날개","3. 레전드 프라우테","4. 바이킹 소드"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 아츠","2. 레드 카타나","3. 일룬","4. 그륜힐 ø"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 호프만 ø","2. 미하일","3. 카오스 프라우테","4. 플레인"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 파프니르 다마스커스","2. 레전드 메이플 브링어","3. 검","4. 호검 ø"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 특제 파이어잭","2. 용맹의 날개 ø","3. 마녀의 빗자루","4. 골드샤인 베타"));
        data.add(new seed_helper_39_data("다음 중 한 손 무기가 아닌 것은?","1. 메이플 1500일 깃발","2. 초승달 블레이드","3. 에오로 ø","4. 어비스 그림시커"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 헬 크래쉬","2. 발록의 라이노","3. 저주의 블랙 캐논 ø","4. 카오스 플라멘 베르퍼"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 헬 크래쉬","2. 카오스 플라멘 베르퍼","3. 아트룰루 ø","4. 크뤼 소스"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 파프니르 러스터캐논","2. 요정의 프로스티 라이노","3. 템페스트 크래쉬","4. 블러리 캐논 ø"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 벅카스D ø","2. 드레드넛","3. 아트럴리","4. 코라 반 레온 시즈건"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 레인지 로버","2. 발록의 라이노","3. 헐거운 장난감 캐논 ø","4. 샤크투스 플람"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 행복 화이트 캐논","2. 블링블링 아이언 캐논 ø","3. 마이스터 크래쉬","4. 스칼렛 크래쉬"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 노비스 캐논","2. 네크로 베릴 캐논 ø","3. 아이언 봄버","4. 슈타일 봄버"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 붐붐 크래쉬 ø","2. 네크로 이그니스","3. 레드 캐논","4. 피어리스 셀베이션"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 임페리얼 이그니스","2. 얼티밋 크래쉬","3. 브로드 헬크래쉬","4. 특제 이그나이트 크래시 ø"));
        data.add(new seed_helper_39_data("다음 중 핸드캐논이 아닌 것은?","1. 드래곤 헤르츠","2. 메이플 베릴 캐논","3. 드래고닉 라이노 ø","4. 크뤼 소스"));
        data.add(new seed_helper_39_data("루디브리엄의 창고지기 이름은?","1. 로도스","2. 푸로","3. 스우","4. 세피 ø"));
        data.add(new seed_helper_39_data("루디브리엄의 친구목록 관리자 이름은?","1. 골드리치","2. 프델라","3. 할리 ø","4. 크루소"));
        data.add(new seed_helper_39_data("리스항구의 친구목록 관리자 이름은?","1. 무라트","2. 자아","3. 마녀 바바라","4. 몽롱 할배 ø"));
        data.add(new seed_helper_39_data("리에나 해협 빙하관측 본부의 조타수 이름은?","1. 탕윤","2. 푸카","3. 요정 파이니","4. 조타수 따냐 ø"));
        data.add(new seed_helper_39_data("리엔의 창고지기 이름은?","1. 푸슬라 ø","2. 벼루","3. 슈미","4. 리나"));
        data.add(new seed_helper_39_data("마가티아에 거주하는 브로커 이름은?","1. 브로커 정","2. 브로커 한 ø","3. 브로커 홍","4. 토리"));
        data.add(new seed_helper_39_data("마가티아에 거주하는 휴머노이드의 이름은?","1. 페일","2. 휴머노이드 A ø","3. 휴머노이드 B","4. 휴머노이드 C"));
        data.add(new seed_helper_39_data("백초마을의 워프도우미 이름은?","1. 학 ø","2. 백로","3. 두루미","4. 닭"));
        data.add(new seed_helper_39_data("슬리피우드 호텔 입구에 선 아이템 제작자는?","1. 크리슈라마 ø","2. 탈리온","3. 몽땅따","4. 돌고래"));
        data.add(new seed_helper_39_data("아리안트의 무기 상인 이름은?","1. 자이드 ø","2. 야스민","3. 레아","4. 오심마"));
        data.add(new seed_helper_39_data("아리안트의 성형외과 의사 이름은?","1. 슈미","2. 알딘 ø","3. 스크루지","4. 헬레나"));
        data.add(new seed_helper_39_data("아리안트의 피부관리사 이름은?","1. 라일라 ø","2. 네벨","3. 골드리치","4. 큐트"));
        data.add(new seed_helper_39_data("에델슈타인의 곰돌이 알바 이름은?","1. 천지","2. 키루","3. 체키 ø","4. 비어완"));
        data.add(new seed_helper_39_data("에델슈타인의 전 의회장 이름은?","1. 그윈","2. 카이린","3. 알베르트 ø","4. 라니아"));
        data.add(new seed_helper_39_data("에델슈타인의 현 의회장 이름은?","1. 슈미","2. 아벨","3. 안소니 ø","4. 에스텔"));
        data.add(new seed_helper_39_data("에델슈타인의 환경 미화원 이름은?","1. 라엘","2. 키리두","3. 헨리테 ø","4. 이토스"));
        data.add(new seed_helper_39_data("엘리니아의 펫 마스터 이름은?","1. 요정 마르 ø","2. 장로 스탄","3. 요정 플로라","4. 일스"));
        data.add(new seed_helper_39_data("오르비스 차원의 거울 오른쪽에 앉아있는 개 이름은?","1. 뮤네","2. 봉달이 ø","3. 불독","4. 도베르만"));
        data.add(new seed_helper_39_data("전사의 성전에 거주하는 전직관은?","1. 마파","2. 주먹펴고 일어서 ø","3. 하인즈","4. 소피아"));
        data.add(new seed_helper_39_data("커닝시티에 거주하는 아이템 제작자 이름은?","1. 제피","2. 뒷골목의 제이엠 ø","3. 스미스","4. 지미"));
        data.add(new seed_helper_39_data("커닝시티의 지하철 사회복무요원 이름은?","1. 알렉스","2. 웅이 ø","3. 이얀","4. 루이스"));
        data.add(new seed_helper_39_data("판테온에 거주하는 상인 꿈나무 이름은?","1. 캘리코","2. 푸츠키","3. 요정 우니","4. 카린 ø"));
        data.add(new seed_helper_39_data("판테온의 대신전 앞을 지키고 있는 할머니 이름은?","1. 셀렌 ø","2. 올리비아","3. 넬라","4. 체프"));
        data.add(new seed_helper_39_data("페리온의 무기 상인 이름은?","1. 마이크","2. 리버 ø","3. 카밀라","4. 유타"));
        data.add(new seed_helper_39_data("황금 사원 입구에 서 있는 꼬마 승려의 이름은?","1. 토푸","2. 듀나미스","3. 노이 ø","4. 디테"));
        data.add(new seed_helper_39_data("황금사원의 잡화 상인 이름은?","1. 케리","2. 키무","3. 탕따완 ø","4. 다니카"));


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
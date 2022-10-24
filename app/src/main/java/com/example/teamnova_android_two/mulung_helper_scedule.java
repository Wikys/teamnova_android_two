package com.example.teamnova_android_two;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mulung_helper_scedule extends Activity implements Serializable {

    private final int id = 0x8000; //버튼아이디 변수
    private Integer numButton = 0; // 버튼의 개수
    ArrayList<String> buttonNameList = new ArrayList<>(); //만든 버튼 이름들이 저장되는곳
    //버튼 추가되는 레이아웃
    LinearLayout 저장목록;
    int 버튼id;
    Map<String, String> 제목리스트 = new HashMap<>();
    Map<String, String> 메모리스트 = new HashMap<>();
    Map<String, String> 분리스트 = new HashMap<>();
    Map<String, String> 초리스트 = new HashMap<>();
    boolean 신규;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mulung_helper_scedule);
        Button save = (Button) findViewById(R.id.저장버튼);
        save.setOnClickListener(new View.OnClickListener() { //버튼생성 이벤트
            @Override
            public void onClick(View view) {

                newSaveList();
                //if문으로
                //생성된 버튼이름을 어레이리스트와 비교해서
                //기존에 있던 버튼 제목지정한거랑 중복되면 경고(시간도)
                //아니면 생성
            }
        });

        Button exit = (Button) findViewById(R.id.종료버튼);
        exit.setOnClickListener(new View.OnClickListener() { //x버튼 눌렀을때 꺼지게하기 onstop
            @Override
            public void onClick(View view) { //x버튼 누르면 액티비티파괴
                finish();
            }
        });

    }

    private void newSaveList() { // 저장목록에 버튼추가하는 메소드
        EditText memo = (EditText) findViewById(R.id.준비);
        EditText m_get = (EditText) findViewById(R.id.분);
        EditText s_get = (EditText) findViewById(R.id.초);
        String 분 = m_get.getText().toString(); //분에 쓴 텍스트 변수화
        String 초 = s_get.getText().toString(); //초에 쓴 텍스트 변수화
        String 메모 = memo.getText().toString(); //메모에 쓴 텍스트 변수화
        LinearLayout 저장목록 = (LinearLayout) findViewById(R.id.저장목록); // 동적 레이아웃 아이디가져오기
        EditText title = (EditText) findViewById(R.id.제목); //사용자가 정한 제목
        String 제목 = title.getText().toString(); // 제목에 쓴 텍스트 변수화
        int 캐스팅분 = Integer.valueOf(String.valueOf(m_get.getText()));//조건문에 대입해주기위해서 인트로 캐스팅
        int 캐스팅초 = Integer.valueOf(String.valueOf(s_get.getText()));
        if(제목리스트.containsKey(제목)){ //제목이 같으면 기존에 있던 버튼을 수정
            if(!(캐스팅분 > 14) && !(캐스팅초 > 60)) {
                신규 = false;
                메모리스트.replace(제목, 메모); // 해시맵에 메모저장
                분리스트.replace(제목, 분); // 해시맵에 분저장
                초리스트.replace(제목, 초); // 해시맵에 초저장
                Toast.makeText(this, "변경완료", Toast.LENGTH_SHORT).show();
                return;
            }else{
                Toast.makeText(this, "14분 60초 초과불가능", Toast.LENGTH_SHORT).show();
                return;
            }

        }

        else if (!제목리스트.containsKey(제목) ) {
            신규 = true;
            //제목같으면안되고(o) 시간비어있으면안되고(o) 제목비어있으면 안되고(x)
            //시간같으면안되고(o)
            //분이 14이상이면안되고 초가 60이상이면 안되고(o)

            if (!(캐스팅분 > 14) && !(캐스팅초 > 60)) {
                if (!분리스트.containsValue(분) || !초리스트.containsValue(초)) { // 시간이 같으면 안되게끔
                    numButton++; // 버튼아이디 뒤에 붙일 숫자
                    제목리스트.put(제목, 제목); // 해시맵에 제목저장
                    메모리스트.put(제목, 메모); // 해시맵에 메모저장
                    분리스트.put(제목, 분); // 해시맵에 분저장
                    초리스트.put(제목, 초); // 해시맵에 초저장
                    Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "시간이 겹칩니다", Toast.LENGTH_SHORT).show();
                    return;
                }
            }else {
                Toast.makeText(this, "14분 60초 초과불가능", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            Toast.makeText(this, "제목을 확인해주세요", Toast.LENGTH_SHORT).show();
            return;
        }




        Button savelist = new Button(this); // 버튼생성
        savelist.setText(title.getText()); //제목에 입력한 텍스트를 버튼이름으로 지정
        savelist.setId(id + numButton); //제목에 입력한 텍스트를 아이디로 지정

        savelist.setOnClickListener(new View.OnClickListener() { // 버튼클릭하면 작동할코드
            public void onClick(View v) { // v <- 클릭한뷰
                //이제 밖으로 값을넘겨주고 알람매니저로 메인에서 받아서 텍스트변경해주기..
                //클릭한뷰에맞는 키값(제목)을 가진 해쉬맵의 벨류(값)를 뿌려주기
                //어디에? 제목 메모 분 초
                //제목 -> 해시맵 핵심키값
                //메모 -> 팝업창 메모내용, 메인에넘겨주기
                //분,초 -> 팝업창 메모내용, 메인에 넘겨주기

                title.setText(제목리스트.get(제목));
                memo.setText(메모리스트.get(제목));
                m_get.setText(분리스트.get(제목));
                s_get.setText(초리스트.get(제목));

                Button delete = (Button) findViewById(R.id.삭제버튼);
                delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        제목리스트.remove(제목); //해시맵에 등록된데이터 삭제
                        메모리스트.remove(제목);
                        분리스트.remove(제목);
                        초리스트.remove(제목);
                        저장목록.removeView(v); //저장한버튼 삭제

                    }
                });

            }
        });
        if(신규) { //신규생성로직으로 등록된버튼이면 생성
            저장목록.addView(savelist, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        }else{
            Toast.makeText(this, "변경 되었습니다", Toast.LENGTH_SHORT).show();
            신규 = true;
        }


    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }

    @Override
    protected void onPause() { // 온퍼즈될때 저장목록에 있는 시간,메모정보를 메인에 쏴줘야함
        Intent put_data = new Intent(this,mulung_helper.class);
        put_data.putExtra("제목", (Serializable) 제목리스트);
        put_data.putExtra("메모", (Serializable) 메모리스트);
        put_data.putExtra("분", (Serializable) 분리스트);
        put_data.putExtra("초", (Serializable) 초리스트);
        startActivity(put_data);
        super.onPause();
    }
    //    public void onClick(View v) { //선택한뷰 아이디값 가져와서 삭제버튼에 보내주고
//        //삭제버튼에서 받아서 삭제
//        동적버튼 = findViewById(v.getId()); //맴버변수 값을 아이디로 변경
//
//    }
}
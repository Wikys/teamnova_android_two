package com.example.teamnova_android_two;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class sign_up extends Activity implements Serializable {
//    Map<String, String> 아이디 = new HashMap<>();
//    Map<String, String> 비밀번호 = new HashMap<>();
//    Map<String, String> 닉네임 = new HashMap<>();
//    Map<String, String> 사진 = new HashMap<>();
    ArrayList<String> 아이디 = new ArrayList<>(); //아이디 저장리스트
    ArrayList<String> 닉네임 = new ArrayList<>(); //닉네임 저장리스트
    ArrayList<String> 비밀번호 = new ArrayList<>(); //비밀번호 저장리스트


    private static final int REQUEST_ID = 1; //아이디 요청변수
    private static final int REQUEST_NICK = 2; //닉네임 요청변수

    boolean ID중복확인 = false;
    boolean NICK중복확인 = false;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //타이틀바없앰
        setContentView(R.layout.sign_up);
        Log.d("main", "onCreate: ");
        TextView id = (TextView) findViewById(R.id.id_text); //아이디
        TextView ps = (TextView) findViewById(R.id.ps_text); //비밀번호
        TextView confirm_ps = (TextView) findViewById(R.id.confirm_ps); //비밀번호 확인
        TextView nick = (TextView) findViewById(R.id.닉네임텍스트); //닉네임
        Button 사진등록 = (Button) findViewById(R.id.사진버튼); //사진등록버튼
        Button 완료버튼 = (Button) findViewById(R.id.완료버튼); //가입완료버튼
        Button 종료버튼 = (Button) findViewById(R.id.종료버튼); //종료버튼
        Button ID중복 = (Button) findViewById(R.id.ID중복); //ID중복확인버튼
        Button 닉중복 = (Button) findViewById(R.id.닉중복); //닉네임중복확인버튼



        ID중복.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String 비교값 = id.getText().toString().trim();
                if (id.isEnabled()){ //id텍스트뷰가 조작가능한상태면

                    if (비교값.length() != 0) {
                        Intent id전달 = new Intent(sign_up.this, confirm_id.class);
                        //입력한 아이디값을 중복확인 액티비티에 넘김
                        id전달.putExtra("id", 비교값); //에딧텍스트값 저장
                        id전달.putExtra("id_list", 아이디);

                        startActivityForResult(id전달, REQUEST_ID); // 중복확인 액티비티로 이동
                    } else {
                        Toast.makeText(sign_up.this, "아이디값이 공백입니다", Toast.LENGTH_SHORT).show();
                    }
            }else {
                    Toast.makeText(sign_up.this, "아이디가 결정되었습니다", Toast.LENGTH_SHORT).show();
                }

            }
        });
        //액티비티 풋엑스트라 메소드로 컨필름id 액티비티로 아이디값전달해줌


        닉중복.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String 비교값 = nick.getText().toString().trim();
                if (nick.isEnabled()){ //닉네임 텍스트뷰가 조작가능한상태면

                    if (비교값.length() != 0) {
                        Intent 닉전달 = new Intent(sign_up.this,confirm_nick.class);
                        //입력한 아이디값을 중복확인 액티비티에 넘김
                        닉전달.putExtra("nick", 비교값); //에딧텍스트값 저장
                        닉전달.putExtra("nick_list", 닉네임);

                        startActivityForResult(닉전달,REQUEST_NICK); //닉중복 액티비티로 이동
                    } else {
                        Toast.makeText(sign_up.this, "아이디값이 공백입니다", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(sign_up.this, "아이디가 결정되었습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });

        완료버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { //완료버튼 누르면 확인후 계정생성로직
                String 비번 = ps.getText().toString().trim();
                String 비밀번호확인 = confirm_ps.getText().toString().trim();
                if(ID중복확인 == true && NICK중복확인 == true && 비번.equals(비밀번호확인)){
                    Toast.makeText(sign_up.this, "계정생성 완료", Toast.LENGTH_SHORT).show();
                    아이디.add(id.getText().toString());
                    닉네임.add(nick.getText().toString());
                    비밀번호.add(비번);
                    finish();
                    //이부분 스타트액티비티포리저트로 바꾸면 수정해야함
                }else{
                    Toast.makeText(sign_up.this, "비밀번호가 일치하지않거나 중복체크를 안하셨습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
        종료버튼.setOnClickListener(new View.OnClickListener() { //x버튼 누르면 저장이나 별도의 로직없이 그냥 화면꺼줌
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    @Override //리퀘스트코드 = 내가 데이터 보낼때 썻던 인식코드, 리저트코드 = 내가 데이터 받아올때 썻던 인식코드, 데이터 = 인텐트
    protected void onActivityResult(int requestCode, int resultCode, Intent data) { //데이터 결과값 받아오는메소드
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("main", "onActivityResult: ");
        if(requestCode == REQUEST_ID && resultCode == RESULT_OK){ // 리퀘스트코드가 내가설정한 코드일때, 하위액티비티에서 사용한 리절트코드와 일치할떄

            TextView id_Result = (TextView) findViewById(R.id.id_text); //아이디
            id_Result.setText(data.getStringExtra("ID확정"));
            id_Result.setEnabled(false);
            ID중복확인 = true;
        }
        if(requestCode == REQUEST_NICK && resultCode == RESULT_OK){
            TextView nick_Result = (TextView) findViewById(R.id.닉네임텍스트); //닉네임
            nick_Result.setText(data.getStringExtra("NICK확정"));
            nick_Result.setEnabled(false);
            NICK중복확인 = true;

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
    protected void onRestart() {
        Log.d("main", "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onStart() {
        Log.d("main", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("main", "onResume: ");
//        Intent ID확정 = getIntent(); // 중복아이디체크 데이터가져오기
//        TextView id_Result = (TextView) findViewById(R.id.id_text); //아이디
//        if(ID확정.hasExtra("ID확정")) {
//
//            id_Result.setText(ID확정.getStringExtra("ID확정"));
//            id_Result.setEnabled(false);
//        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("main", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("main", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("main", "onDestroy: ");
        super.onDestroy();
    }
}

//비밀번호 두개 일치하면 일치여부 텍스트로 띄우기

//아이디값을 어레이리스트에 저장해서 중복액티비티에서 에딧텍스트로 들어온값이랑 비교

//데이터 메인에 전달

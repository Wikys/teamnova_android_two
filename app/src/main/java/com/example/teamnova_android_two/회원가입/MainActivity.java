package com.example.teamnova_android_two.회원가입;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamnova_android_two.Main.Main;
import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.Reset.Assignment_Service;
import com.example.teamnova_android_two.recyclerview;
import com.example.teamnova_android_two.test_activity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kakao.sdk.common.util.Utility;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Serializable {
    private BroadcastReceiver alarm;
    ArrayList<String> 아이디 = new ArrayList<>(); //아이디 저장리스트
    ArrayList<String> 닉네임 = new ArrayList<>(); //닉네임 저장리스트
    ArrayList<String> 비밀번호 = new ArrayList<>(); //비밀번호 저장리스트
    Uri uri; //이미지정보
    Dialog dialog;
    Context context;
    SharedPreferences 셰어드;
    SharedPreferences 계정기억DB;
    SharedPreferences 최종로그인; // 알람매니저와 연동해서 사용할값 (알람매니저 노티피 누르면 메인으로가니까.. 만듬)
    SharedPreferences.Editor 에디터;
    ArrayList<Account_Data> 계정;
    Gson gson;
    String contect_Account;



    ActivityResultLauncher<Intent> receive_Id_Result = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        //겟엑스트라 입력
                        Intent 계정정보 = result.getData();
                        아이디 = (ArrayList<String>) 계정정보.getSerializableExtra("아이디");
                        닉네임 = (ArrayList<String>) 계정정보.getSerializableExtra("닉네임");
                        비밀번호 = (ArrayList<String>) 계정정보.getSerializableExtra("비밀번호");
                        uri = 계정정보.getParcelableExtra("uri"); // paracelable -> 객체전달
                        String stringUri = uri.toString();
                        //uri객체 스트링으로 형변환 (제이슨으로 변환이안되서)
                        //나중에 다시 돌려놓을떄 Uri.parse();

                        계정.add(new Account_Data(
                                아이디.get(아이디.size() - 1), 비밀번호.get(비밀번호.size() - 1), 닉네임.get(닉네임.size() - 1), stringUri));
//                        //미리 한번 저장(당장에 로그인할떄 반영되어야하니까)
                        saved_Data(아이디.get(아이디.size() - 1), 비밀번호.get(비밀번호.size() - 1), 닉네임.get(닉네임.size() - 1), stringUri);
                        //만들어진 객체 저장하는메소드 (어플껏다킬때 불러오는용도)
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate: ");






        dialog = new Dialog(MainActivity.this);

        계정 = new ArrayList();
        셰어드 = getSharedPreferences("계정DB", MODE_PRIVATE);
        계정기억DB = getSharedPreferences("계정기억DB", MODE_PRIVATE);
        //SharedPreferences 생성
        gson = new GsonBuilder().create();
        //gson 생성

        read_Data();


        Button login_button = (Button) MainActivity.this.findViewById(R.id.login_button);
        TextView id_Input = (TextView) MainActivity.this.findViewById(R.id.아이디);
        TextView ps_Input = (TextView) MainActivity.this.findViewById(R.id.비밀번호);
        Button sign_Up_Button = (Button) MainActivity.this.findViewById(R.id.sign_up_button);
        Button 테스트 = (Button) MainActivity.this.findViewById(R.id.테스트);
        Button 테스트2 = (Button) MainActivity.this.findViewById(R.id.테스트2);
        CheckBox 계정기억 = (CheckBox) MainActivity.this.findViewById(R.id.계정기억);
        Boolean 계정저장상태 = 계정기억DB.getBoolean("계정기억상태", false);
        String 저장id불러오기 = 계정기억DB.getString("ID기억", "");
        String 저장ps불러오기 = 계정기억DB.getString("PS기억", "");

        계정기억.setChecked(계정저장상태);
        //디비에 저장돼있는 체크박스 체크상태를 가져와서 등록

        if (계정저장상태 = true) {
            //계정기억버튼을 누른상태에서 껏으면
            //텍스트뷰에 전에 저장했던 아이디 비번 자동으로 입력
            id_Input.setText(저장id불러오기);
            ps_Input.setText(저장ps불러오기);
        }

        테스트.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent 숙제알림서비스 = new Intent(MainActivity.this, Assignment_Service.class);
                startService(숙제알림서비스);
            }
        });

        테스트2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent test2 = new Intent(MainActivity.this, recyclerview.class);
                startActivity(test2);
            }
        });


        login_button.setOnClickListener(new View.OnClickListener() {//로그인버튼 눌렀을때
            @Override
            public void onClick(View view) {
                String 아이디;
                String 비밀번호;
                String 닉네임;
                Uri 이미지;
                int 인덱스 = -998;

                for (int i = 0; i < 계정.size(); i++) {
                    if (계정.get(i).id.contains(id_Input.getText().toString())) {
                        //입력한값과 아이디쪽 db 대조
                        아이디 = id_Input.getText().toString();
                        인덱스 = i;

                        //인텐트로 넘기기위해서 요소가 어디에 위치해있는지 찾아야하는데
                        //그걸 위해서 인덱스라는 변수를만듬
                    }

                }
                if (인덱스 != -998) {

                    if (계정.get(인덱스).ps.equals(ps_Input.getText().toString())) {
                        Intent intent = new Intent(MainActivity.this, Main.class);
                        //인텐트로넘김 인덱스값(다음액티비티에서 디비불러올때 몇번쨰에있는건지 확인용)
                        //여기서는 이미지 스트링으로 넘기고 다음화면에서 변환
                        //인텐트로 그냥 아이디 닉네임 이미지 넘기고 다음화면에서 아이디값으로 db만들어서 정보구분

//                        intent.putExtra("아이디", 계정.get(인덱스).id);
//                        intent.putExtra("닉네임", 계정.get(인덱스).nick);
//                        intent.putExtra("사진", 계정.get(인덱스).image);
                        최종로그인 = getSharedPreferences("최종로그인",MODE_PRIVATE);
                        SharedPreferences.Editor 에디터 = 최종로그인.edit();

                        에디터.putString("아이디",계정.get(인덱스).id);
                        에디터.putString("닉네임",계정.get(인덱스).nick);
                        에디터.putString("사진",계정.get(인덱스).image);

                        에디터.apply();

                        if (계정기억.isChecked()) {
                            계정기억DB = getSharedPreferences("계정기억DB", MODE_PRIVATE);
                            SharedPreferences.Editor editor = 계정기억DB.edit();
                            editor.putBoolean("계정기억상태", true);
                            editor.putString("ID기억", 계정.get(인덱스).id);
                            editor.putString("PS기억", 계정.get(인덱스).ps);
                            editor.apply();
                            //계정기억 체크박스 누르면 현재 로그인성공한 아이디 비밀번호 디비에저장후
                            //온크리에이트에서 불러와서 자동입력

                        } else {
                            계정기억DB = getSharedPreferences("계정기억DB", MODE_PRIVATE);
                            SharedPreferences.Editor editor = 계정기억DB.edit();
                            editor.putBoolean("계정기억상태", false);
                            editor.putString("ID기억", "");
                            editor.putString("PS기억", "");
                            editor.apply();
                        }

                        startActivity(intent);
                    } else {
                        Toast.makeText(MainActivity.this, "비밀번호를 확인 해주세요.", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity.this, "비밀번호 : "+계정.get(인덱스).ps, Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "아이디를 확인 해주세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sign_Up_Button.setOnClickListener(new View.OnClickListener() { //회원가입 액티비티로 넘어가는 리스너
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, sign_up.class);

                intent.putExtra("계정", 계정); // 중복확인을 위해 계정정보가 담겨있는 어레이리스트 전송
                receive_Id_Result.launch(intent);
            }
        });
    }

    @Override
    protected void onStart() {
        Log.d("MainActivity", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("MainActivity", "onResume: ");
        TextView id = (TextView) MainActivity.this.findViewById(R.id.아이디);
        TextView ps = (TextView) MainActivity.this.findViewById(R.id.비밀번호);
        //온리줌에서 새로 데이터 받아왔을때 갱신해줘야함

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("MainActivity", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("MainActivity", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("MainActivity", "onDestroy: ");
        super.onDestroy();

    }

    @Override
    protected void onRestart() {
        Log.d("MainActivity", "onRestart: ");
        super.onRestart();
    }


    public void saved_Data(String ID, String PS, String Nick, String Image_Path) {
        contect_Account = "";
        Account_Data a = new Account_Data(ID, PS, Nick, Image_Path);

        contect_Account = gson.toJson(a, Account_Data.class);
        //gson.toJson을 이용해 클래스를 String으로 변환
        //첫번째 인자에는 변경되는 클래스변수이름, 두번째에는 클래스의 형식

        SharedPreferences.Editor editor = 셰어드.edit();
        editor.putString(계정.get(계정.size() - 1).id, contect_Account);
        editor.apply();
        //SharedPreferences에 String으로 변환된 클래스 저장

    }

    public void read_Data() {

        Map<String, ?> allEntries = 셰어드.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            //DB에 저장된 모든값을 차례대로 꺼내오는 메소드
            Account_Data a = gson.fromJson(entry.getValue().toString(), Account_Data.class);
            //저장된 모든값을 차례대로 꺼내와서 객체에 변환해서담고
            계정.add(a);
            //어레이리스트에 다시담음
//            Log.d("map values", entry.getKey() + ": " + entry.getValue().toString());
        }
    }
}


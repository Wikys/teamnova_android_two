package com.example.teamnova_android_two.회원가입;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.work.impl.model.Preference;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamnova_android_two.Main;
import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.recyclerview;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    private BroadcastReceiver alarm;
    ArrayList<String> 아이디 = new ArrayList<>(); //아이디 저장리스트
    ArrayList<String> 닉네임 = new ArrayList<>(); //닉네임 저장리스트
    ArrayList<String> 비밀번호 = new ArrayList<>(); //비밀번호 저장리스트
    Uri uri; //이미지정보
    Dialog dialog;
    Context context;
    SharedPreferences 셰어드;
    SharedPreferences.Editor 에디터;
    ArrayList<Account_Data> 계정;


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
//                        에디터.putString("계정",gson.)
                        SaveData(계정);
                        //제이슨으로 변환해서 저장
                        계정 = ReadData();
                        //다시 풀어서 어레이리스트에 저장

                    }
                }
            });


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate: ");
        dialog = new Dialog(MainActivity.this);
//        계정 = getStringArrayPref(context,"계정");
        계정 = new ArrayList();



        Button login_button = (Button) MainActivity.this.findViewById(R.id.login_button);
        TextView id_Input = (TextView) MainActivity.this.findViewById(R.id.아이디);
        TextView ps_Input = (TextView) MainActivity.this.findViewById(R.id.비밀번호);
        Button sign_Up_Button = (Button) MainActivity.this.findViewById(R.id.sign_up_button);
        Button 테스트 = (Button) MainActivity.this.findViewById(R.id.테스트);
        Button 테스트2 = (Button) MainActivity.this.findViewById(R.id.테스트2);


        테스트.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder msgBuilder = new AlertDialog.Builder(MainActivity.this)
                        .setTitle("앱 끈다?")
                        .setMessage("진짜 끈다?")
                        .setPositiveButton("꺼라", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this, "안 끔", Toast.LENGTH_SHORT).show();
                            }
                        });


                AlertDialog msgDlg = msgBuilder.create();
                msgDlg.show();
//                Intent intent = new Intent(MainActivity.this, test_activity.class);
//                startActivity(intent);
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

                for (int i = 0; i < 계정.size(); i++){
                    if(계정.get(i).id.contains(id_Input.getText().toString())){
                        //입력한값과 아이디쪽 db 대조
                        아이디 = id_Input.getText().toString();
                        인덱스 = i;

                        //인텐트로 넘기려고 인덱스번호로 사용하기위해 저장 또는 비밀번호
                    }

                }
                if(인덱스 != -998){
                    if(계정.get(인덱스).ps.equals(ps_Input.getText().toString())){
                        //인텐트로넘김 인덱스값(다음액티비티에서 디비불러올때 몇번쨰에있는건지 확인용)
                        Intent intent = new Intent(MainActivity.this, Main.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(MainActivity.this, "비밀번호를 확인 해주세요.", Toast.LENGTH_SHORT).show();
//                        Toast.makeText(MainActivity.this, "비밀번호 : "+계정.get(인덱스).ps, Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity.this, "아이디를 확인 해주세요.", Toast.LENGTH_SHORT).show();
                }


//                if (아이디.contains(id.getText().toString()) && 비밀번호.contains(ps.getText().toString())) {
//                    Toast.makeText(MainActivity.this, "로그인에 성공하였습니다", Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(MainActivity.this, Main.class);
//                    //사진정보나 계정정보 넘기기 //
//                    //단방향
//                    intent.putExtra("아이디", 아이디);
//                    intent.putExtra("닉네임", 닉네임);
//                    intent.putExtra("사진", uri);
//                    startActivity(intent);
//
//                }
//                else if (true) { //테스트용 (매번 계정만들기 힘듬)
//                    Intent intent = new Intent(MainActivity.this, Main.class);
//                    아이디.add("안연창");
//                    닉네임.add("팀노바");
//                    intent.putExtra("아이디", 아이디);
//                    intent.putExtra("닉네임", 닉네임);
//                    intent.putExtra("사진", uri);
//                    startActivity(intent);
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "아이디와 비밀번호를 확인 해주세요", Toast.LENGTH_SHORT).show();
//                }
            }
        });

        sign_Up_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, sign_up.class);
                intent.putExtra("아이디", 아이디);
                intent.putExtra("닉네임", 닉네임);
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
//        if (계정.size() >0) {
//            id.setText(계정.get(0).id);
//            ps.setText(계정.get(0).ps);
        //테스트코드
//        }

        //어레이리스트가 안비어있으면 디비 변환한거 추가..?
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

//    private void setStringArrayPref(Context context, String Key, ArrayList<Account_Data> values) {
//        //어레이리스트를 json으로 변환하여 sharedpreferences에 string을 저장하는 코드
//        셰어드 = context.getSharedPreferences("계정", Context.MODE_PRIVATE);
//        //"계정"이라는 이름의 디비를 생성
//        SharedPreferences.Editor editor = 셰어드.edit();
//        //만든 디비를 에디터와 연결
//        JSONArray a = new JSONArray();
//        for (int i = 0; i < values.size(); i++) {
//            a.put(values.get(i));
//            //인자로 받아온 어레이리스트의 요소를 제이슨어레이에 추가
//        }
//        if (!values.isEmpty()) {
//            //인자로 받아온 어레이리스트가 비어있지않으면
//            editor.putString(Key, a.toString());
//            //인자로 받아온 Key를 키값으로 넣고 제이슨어레이를 스트링으로 형변환해서 디비에 저장
//        } else {
//            editor.putString(Key, null);
//        }
//        editor.apply();
//        //저장
//    }

//    private ArrayList<String> getStringArrayPref(Context context, String Key) {
//        //Json 형식의 String을 가져와서 다시 Arraylist로 변환
//        셰어드 = context.getSharedPreferences("계정", Context.MODE_PRIVATE);
//        String json = 셰어드.getString(Key, null);
//        ArrayList<String> urls = new ArrayList<String>();
//        //임시 어레이리스트 만들어서
//        if(json != null){
//            //json이 null이 아니면
//            try{
//                JSONArray a = new JSONArray(json);
//                for(int i =0; i < a.length(); i++){
//                    String url = a.optString(i);
//                    //optString < "" 빈문자열 반환
//                    urls.add(url);
//                }
//            }catch (JSONException e){
//                e.printStackTrace();
//            }
//        }
//        return urls;
//    }
    private void SaveData(ArrayList<Account_Data> 계정){ //db 저장메소드
        context = this;
//        셰어드 = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); // db이름,선언
        셰어드 = context.getSharedPreferences("계정",Context.MODE_PRIVATE);
        SharedPreferences.Editor 에디터 = 셰어드.edit();
        Gson gson = new Gson();
        String json = gson.toJson(계정);
        에디터.putString(계정.get(계정.size()-1).id,json); //방금 추가된 아이디를 키값으로 줌
        에디터.apply();
    }
    private ArrayList<Account_Data> ReadData(){ //json으로 저장해놨던거 다시변환하는 메소드
        context = this;
        셰어드 = context.getSharedPreferences("계정",Context.MODE_PRIVATE);
        Gson gson = new Gson();
//        String json = 셰어드.getString("계정","EMPTY");
        String json = 셰어드.getString(계정.get(계정.size()-1).id,"EMPTY");
        //키값때메 하나씩밖에 못가져옴
        Type type = new TypeToken<ArrayList<Account_Data>>(){
        }.getType();

        ArrayList<Account_Data> 계정 = gson.fromJson(json,type);
        return 계정;
    }

    //머지해봤자 의미가없는게 껏다키면 기록사라지고 리드데이터 메소드는 여전히 하나씩만 불러올수있음..
}


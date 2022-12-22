package com.example.teamnova_android_two.Main;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.alarm;
import com.example.teamnova_android_two.daily_boss;
import com.example.teamnova_android_two.daily_quest;
import com.example.teamnova_android_two.mulung_helper;
import com.example.teamnova_android_two.schedule.schedule;
import com.example.teamnova_android_two.seed_helper;
import com.example.teamnova_android_two.timer;
import com.example.teamnova_android_two.weekly_boss;
import com.example.teamnova_android_two.weekly_quest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main extends AppCompatActivity implements Serializable {
    String 아이디; //아이디
    String 닉네임; //닉네임
    String uri; //이미지정보
    Gson gson;
    //    String id;
//    String nick;
    CheckBox 일퀘체크박스;
    CheckBox 주간퀘체크박스;
    CheckBox 일보체크박스;
    CheckBox 주보체크박스;
    TextView 오늘의메모; //메모표시될 텍스트뷰
    String input_Memo; //디비에 저장된 메모값 받을 변수
    Calendar today = Calendar.getInstance(); //메모리스트 키값을 날짜포맷으로 저장해놔서 불러오려면 캘린더클래스 쓰는게 간편

    public static boolean dq_Reset = false; //일간퀘스트 초기화 변수
    public static boolean db_Reset = false; //일간보스 초기화 변수
    public static boolean wq_Reset = false; //주간퀘스트 초기화 변수
    public static boolean wb_Reset = false; //주간보스 초기화 변수

    HashMap<String, Boolean> 일퀘상태 = new HashMap<>(); // 버튼상태정보
    HashMap<String, Boolean> 일간보스상태 = new HashMap<>(); // 버튼상태정보
    HashMap<String, Boolean> 주간퀘상태 = new HashMap<>(); // 버튼상태정보
    HashMap<String, Boolean> 주간보스상태 = new HashMap<>(); // 버튼상태정보

    HashMap<String, String> 메모목록 = new HashMap<>(); // 스케쥴클래스에서 가져오는 메모목록

    SharedPreferences 사용자정보;
    SharedPreferences 최종로그인;


    ActivityResultLauncher<Intent> receive_Dq_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        //겟엑스트라 입력
                        Intent 일퀘정보 = result.getData();
                        일퀘상태 = (HashMap<String, Boolean>) 일퀘정보.getSerializableExtra("일퀘버튼");
                        //일퀘버튼 체크상태정보 받아옴
//                        Assignment_Save(일퀘상태, "일퀘상태");
                        //인텐트로 받아오면서 디비에 상태저장
                        Log.d("com/example/teamnova_android_two/Main", "onActivityResult: ");
                    }
                }
            }); //일퀘런쳐


    ActivityResultLauncher<Intent> receive_Db_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        Intent 일보정보 = result.getData();
                        일간보스상태 = (HashMap<String, Boolean>) 일보정보.getSerializableExtra("일보버튼");
                        //일보버튼 체크상태정보 받아옴
//                        Assignment_Save(일간보스상태, "일간보스상태");
                        //인텐트로 받아오면서 디비에 상태저장
                        Log.d("com/example/teamnova_android_two/Main", "onActivityResult: ");
                    }
                }
            }); //일보런쳐

    ActivityResultLauncher<Intent> receive_Wq_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        Intent 주간퀘정보 = result.getData();
                        주간퀘상태 = (HashMap<String, Boolean>) 주간퀘정보.getSerializableExtra("주간퀘버튼");
                        //일퀘버튼 체크상태정보 받아옴
//                        Assignment_Save(주간퀘상태, "주간퀘상태");
                        //인텐트로 받아오면서 디비에 상태저장
                        Log.d("com/example/teamnova_android_two/Main", "onActivityResult: ");
                    }
                }
            }); //주간퀘런쳐

    ActivityResultLauncher<Intent> receive_Wb_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        Intent 주간보스정보 = result.getData();
                        주간보스상태 = (HashMap<String, Boolean>) 주간보스정보.getSerializableExtra("주간보스버튼");
                        //일퀘버튼 체크상태정보 받아옴
//                        Assignment_Save(주간보스상태, "주간보스상태");
                        //인텐트로 받아오면서 디비에 상태저장
                        Log.d("com/example/teamnova_android_two/Main", "onActivityResult: ");
                    }
                }
            }); //주간보스런쳐

    ActivityResultLauncher<Intent> receive_Timer_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
//                        Intent 주간보스정보 = result.getData();
//                        주간보스상태 = (HashMap<String, Boolean>) 주간보스정보.getSerializableExtra("주간보스버튼");
                        //타이머 시간정보 받아옴
                        Log.d("com/example/teamnova_android_two/Main", "onActivityResult: ");
                    }
                }
            }); //타이머


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("com/example/teamnova_android_two/Main", "onCreate: ");
        //이화면은 무조건 로그인후에 넘어올수밖에 없으므로 조건문없이 인텐트를 받아온다

        resetAlarm(this);// 알람실행

        ImageView 프사 = (ImageView) Main.this.findViewById(R.id.이미지);
        TextView 환영인사 = (TextView) Main.this.findViewById(R.id.환영인사);
        일퀘체크박스 = (CheckBox) Main.this.findViewById(R.id.일일퀘스트상태);
        주간퀘체크박스 = (CheckBox) Main.this.findViewById(R.id.주간퀘스트상태);
        일보체크박스 = (CheckBox) Main.this.findViewById(R.id.일일보스상태);
        주보체크박스 = (CheckBox) Main.this.findViewById(R.id.주간보스상태);
        오늘의메모 = (TextView) Main.this.findViewById(R.id.오늘의메모);

        사용자정보 = getSharedPreferences(아이디,MODE_PRIVATE);
        SharedPreferences.Editor 상태 = 사용자정보.edit();
        최종로그인 = getSharedPreferences("최종로그인",MODE_PRIVATE);
//        SharedPreferences.Editor 로그인정보 = 최종로그인.edit();

        uri = 최종로그인.getString("사진","");
        아이디 = 최종로그인.getString("아이디","");
        닉네임 = 최종로그인.getString("닉네임","");
        Uri 사진변환 = Uri.parse(uri);


        Glide.with(Main.this).load(사진변환).override(150, 150).into(프사); // 프사부분에 이미지띄워주기
        환영인사.setText(아이디 + "(" + 닉네임 + ") 님 어서오세요");

//        if (wq_Reset) {
//            //주간리셋 작동하면 모든 관련디비 삭제
//
//            상태.remove("주간퀘상태");
//            상태.remove("주간보스상태");
//            상태.remove("일퀘상태");
//            상태.remove("일간보스상태");
//            상태.apply();
//            wq_Reset = false;
//
//        } else if (dq_Reset) {
//            주간퀘상태 = Assignment_load("주간퀘상태");
//            주간보스상태 = Assignment_load("주간보스상태");
//
//            상태.remove("일퀘상태");
//            상태.remove("일간보스상태");
//            상태.apply();
//            dq_Reset = false;
//
//            //데이리셋 작동하면 주간숙제 상태만 불러오고 일간디비는 삭제
//        } else {
//            일간보스상태 = Assignment_load("일간보스상태");
//            일퀘상태 = Assignment_load("일퀘상태");
//            주간퀘상태 = Assignment_load("주간퀘상태");
//            주간보스상태 = Assignment_load("주간보스상태");
//            //아무것도 작동하지않으면 모든상태 불러옴
//        }
        일간보스상태 = Assignment_load("일간보스상태");
        일퀘상태 = Assignment_load("일퀘상태");
        주간퀘상태 = Assignment_load("주간퀘상태");
        주간보스상태 = Assignment_load("주간보스상태");

        LinearLayout dqbtn = (LinearLayout) Main.this.findViewById(R.id.일일퀘스트); //일일퀘스트 이동버튼
        dqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dqmove = new Intent(Main.this, daily_quest.class);
//                dqmove.putExtra("날짜변경",dq_Reset ); // 날짜변경 변수 넘김
                dqmove.putExtra("일퀘상태", 일퀘상태); //버튼상태 유지를 위해서 액티비티 들어갈때 버튼상태 받아왔던거 재전송
                dqmove.putExtra("아이디", 아이디);
                //사용자정보 구분을 위해 아이디넘김
                receive_Dq_State.launch(dqmove);
            }
        });
        LinearLayout dbbtn = (LinearLayout) findViewById(R.id.일일보스); //데일리보스 이동버튼

        dbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbmove = new Intent(Main.this, daily_boss.class);
                dbmove.putExtra("일보상태", 일간보스상태);
                dbmove.putExtra("아이디", 아이디);
                //사용자정보 구분을 위해 아이디넘김
                receive_Db_State.launch(dbmove);
            }
        });
        LinearLayout wqbtn = (LinearLayout) findViewById(R.id.주간퀘스트); //위클리퀘스트 이동버튼

        wqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wqmove = new Intent(Main.this, weekly_quest.class);
                wqmove.putExtra("주간퀘상태", 주간퀘상태);
                wqmove.putExtra("아이디", 아이디);
                //사용자정보 구분을 위해 아이디넘김
                receive_Wq_State.launch(wqmove);
            }
        });

        LinearLayout wbbtn = (LinearLayout) findViewById(R.id.주간보스); //위클리보스 이동버튼

        wbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wbmove = new Intent(Main.this, weekly_boss.class);
                wbmove.putExtra("주간보스상태", 주간보스상태);
                wbmove.putExtra("아이디", 아이디);
                //사용자정보 구분을 위해 아이디넘김
                receive_Wb_State.launch(wbmove);
            }
        });

        LinearLayout timerbtn = (LinearLayout) findViewById(R.id.재획타이머); // 재획타이머 이동버튼

        timerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent timermove = new Intent(Main.this, timer.class);
                //분초정보 보내야함
                receive_Timer_State.launch(timermove);
            }
        });
        LinearLayout schebtn = (LinearLayout) findViewById(R.id.일정표); // 일정표 이동버튼

        schebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent schemove = new Intent(Main.this, schedule.class);
                schemove.putExtra("아이디", 아이디);
                startActivity(schemove);
            }
        });
        LinearLayout seedbtn = (LinearLayout) findViewById(R.id.시드도우미); // 시드도우미 이동버튼

        seedbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent seedmove = new Intent(Main.this, seed_helper.class);
                startActivity(seedmove);
            }
        });
        LinearLayout mubtn = (LinearLayout) findViewById(R.id.무릉도우미); // 무릉도우미 이동버튼

        mubtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mumove = new Intent(Main.this, mulung_helper.class);
                mumove.putExtra("아이디", 아이디);
                startActivity(mumove);
            }
        });

        //알람매니저로 일간,주간에 신호를줌
        //+일정표까지 신호날려줌
        //각각 클래스에서 받아서 상황에맞게 처리 (체크박스의경우엔 체크를 푼다던가)
        //일정표에서는 날짜가 바뀌면 메모내용이 해당날짜에 맞게 바뀐다던가 하는식으로

        //알람매니저의 역할은 그냥 앱이 꺼져있어도 지정된 시간대에 신호(이벤트)를주는 역할뿐
        //이 신호를 받아서 브로드캐스트리시버가 작동한다


    }

    public static void resetAlarm(Context context) { //알람매니저//알람메소드 나중에 로그인정보가 있어야 알람이뜨게끔 설정
        AlarmManager resetAlarm = (AlarmManager) context.getSystemService(context.ALARM_SERVICE);
        Intent resetIntent = new Intent(context, alarm.class); // 로직클래스(alarm) 인텐트
        PendingIntent resetSender = PendingIntent.getBroadcast(context, 0, resetIntent, PendingIntent.FLAG_IMMUTABLE);
        //인텐트 보류후 특정시점에 브로드캐스트로 이동

        //자정시간
        Calendar resetCal = Calendar.getInstance(); //캘린더클래스 객체
        resetCal.setTimeInMillis(System.currentTimeMillis()); //현재시간을 밀리세컨드로 가져와 넘겨줌
        resetCal.set(Calendar.HOUR_OF_DAY, 0); //일을 0으로 셋
        resetCal.set(Calendar.MINUTE, 0); //분을 0으로 셋
        resetCal.set(Calendar.SECOND, 0); //초를 0으로 셋
        //다음날 0시에 맞추기위해 24시간을 뜻하는 상수인 INTERVAL_DAY을 더해줌


        resetAlarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, resetCal.getTimeInMillis()
                + AlarmManager.INTERVAL_DAY, AlarmManager.INTERVAL_DAY, resetSender);
        //반복주기
        //하루,일주일에 한번 울리는 알람이라 수면모드 강제깨움 사용(무슨일이 있어도 동작해야하기때문)

        //테스트코드
        SimpleDateFormat format = new SimpleDateFormat("MM/dd kk:mm:ss");
        String setResetTime = format.format(new Date(resetCal.getTimeInMillis() + AlarmManager.INTERVAL_DAY));
        Log.d("resetAlarm", "ResetHour : " + setResetTime);

    }

    @Override
    protected void onStart() {
        Log.d("com/example/teamnova_android_two/Main", "onStart: ");
        super.onStart();

    }

    @Override
    protected void onResume() {
        Log.d("com/example/teamnova_android_two/Main", "onResume: ");
        super.onResume();
        if (!(일간보스상태.containsValue(false))&& !(일간보스상태.isEmpty())) {
            //값중에 false가 없으면
            일보체크박스.setChecked(true);
            //체크박스체크
        } else {
            일보체크박스.setChecked(false);
            //아니면 해제
        }
        if (!(주간퀘상태.containsValue(false)) && !(주간퀘상태.isEmpty())) {
            //값중에 false가 없으면
            주간퀘체크박스.setChecked(true);
            //체크박스체크
        } else {
            주간퀘체크박스.setChecked(false);
            //아니면 해제
        }
        if (!(일퀘상태.containsValue(false))&& !(일퀘상태.isEmpty())) {
            //값중에 false가 없으면
            일퀘체크박스.setChecked(true);
            //체크박스체크
        } else {
            일퀘체크박스.setChecked(false);
            //아니면 해제
        }
        if (!(주간보스상태.containsValue(false))&& !(주간보스상태.isEmpty())) {
            //값중에 false가 없으면
            주보체크박스.setChecked(true);
            //체크박스체크
        } else {
            주보체크박스.setChecked(false);
            //아니면 해제
        }
        //생명주기상 어플을 시작할때나 일일퀘스트 액티비티에서 전부 체크하고 나왔을때
        //유연한처리를 위해 리줌에 배치
        //온스타트에 해봤으나 온스타트 시간이너무짧아서 제대로 작동을안함(됐다안됐다함)
        메모목록 = Memolist_load("메모리스트");

        String key = String.format("%d%d%d", today.get(Calendar.YEAR), today.get(Calendar.MONTH) + 1, today.get(Calendar.DATE));
        if (메모목록.containsKey(key)) {
            String input = 메모목록.get(key);
            오늘의메모.setText(input);
        }
        //캘린더클래스를 참조하여 오늘날짜의 메모가 있으면 불러와서 출력해줌
    }

    @Override
    protected void onPause() {
        Log.d("com/example/teamnova_android_two/Main", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("com/example/teamnova_android_two/Main", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("com/example/teamnova_android_two/Main", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("com/example/teamnova_android_two/Main", "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("com/example/teamnova_android_two/Main", "onSaveInstanceState: ");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("com/example/teamnova_android_two/Main", "onRestoreInstanceState: ");
    }


    public void Assignment_Save(HashMap<String, Boolean> Data, String Type) {
        //각종 숙제 상태저장메소드
        String jsonString = new Gson().toJson(Data);
        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        SharedPreferences.Editor editor = 사용자정보.edit();
        editor.putString(Type, jsonString);
        editor.apply();
    }

    public HashMap<String, Boolean> Assignment_load(String Type) {
        //각종 숙제 상태저장 불러오는 메소드
        //해쉬맵 변환하여 불러오는 메소드
//        HashMap<String, Boolean> outputMap = new HashMap<String, Boolean>();

        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        String defValue = new Gson().toJson(new HashMap<String, Boolean>());

        String json = 사용자정보.getString(Type, defValue);
        //인자 : Type:내가쓴 스트링값을 제목으로, defvalue:json으로 변환된 해시맵
        TypeToken<HashMap<String, Boolean>> type = new TypeToken<HashMap<String, Boolean>>() {
        };
        //암시적 형변환해주는 클래스
        HashMap<String, Boolean> returnMap = new Gson().fromJson(json, type.getType());
        //첫번째인자 : 불러온 데이터 , 두번째인자 : 불러온 데이터의 타입
        return returnMap;
    }

    public HashMap<String, String> Memolist_load(String Type) {
        //스케쥴메모 상태저장 불러오는 메소드
        //해쉬맵 변환하여 불러오는 메소드
//        HashMap<String, String> outputMap = new HashMap<String, String>();
//        //배출용 해쉬맵 선언
        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        String defValue = new Gson().toJson(new HashMap<String, String>());

        String json = 사용자정보.getString(Type, defValue);
        TypeToken<HashMap<String, String>> type = new TypeToken<HashMap<String, String>>() {
        };
        //암시적 형변환해주는 클래스
        HashMap<String, String> returnMap = new Gson().fromJson(json, type.getType());
        //첫번째인자 : 불러온 데이터 , 두번째인자 : 불러온 데이터의 타입
        return returnMap;
    }

}

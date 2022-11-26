package com.example.teamnova_android_two;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Main extends AppCompatActivity implements Serializable {
    ArrayList<String> 아이디목록 = new ArrayList<>(); //아이디 저장리스트
    ArrayList<String> 닉네임목록 = new ArrayList<>(); //닉네임 저장리스트
    Uri uri; //이미지정보
    static boolean dq_Reset = false; //일간퀘스트 초기화 변수
    static boolean db_Reset = false; //일간보스 초기화 변수
    static boolean wq_Reset = false; //주간퀘스트 초기화 변수
    static boolean wb_Reset = false; //주간보스 초기화 변수

    HashMap<String, Boolean> 일퀘상태 = new HashMap<>(); // 버튼상태정보
    HashMap<String, Boolean> 일간보스상태 = new HashMap<>(); // 버튼상태정보
    HashMap<String, Boolean> 주간퀘상태 = new HashMap<>(); // 버튼상태정보
    HashMap<String, Boolean> 주간보스상태 = new HashMap<>(); // 버튼상태정보
    int 재획타이머_분;
    int 재획타이머_초;


    ActivityResultLauncher<Intent> receive_Dq_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        //겟엑스트라 입력
                        Intent 일퀘정보 = result.getData();
                        일퀘상태 = (HashMap<String, Boolean>) 일퀘정보.getSerializableExtra("일퀘버튼");
                        //일퀘버튼 체크상태정보 받아옴
                        Log.d("Main", "onActivityResult: ");
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
                        Log.d("Main", "onActivityResult: ");
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
                        Log.d("Main", "onActivityResult: ");
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
                        Log.d("Main", "onActivityResult: ");
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
                        Log.d("Main", "onActivityResult: ");
                    }
                }
            }); //타이머


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.d("Main", "onCreate: ");
        //이화면은 무조건 로그인후에 넘어올수밖에 없으므로 조건문없이 인텐트를 받아온다


        Intent data = getIntent();
        uri = data.getParcelableExtra("사진"); // paracelable -> 객체전달
        아이디목록 = (ArrayList<String>) data.getSerializableExtra("아이디");
        닉네임목록 = (ArrayList<String>) data.getSerializableExtra("닉네임");


        String id = 아이디목록.get(0);
        String nick = 닉네임목록.get(0);


        resetAlarm(this);// 알람실행

        ImageView 프사 = (ImageView) Main.this.findViewById(R.id.이미지);
        TextView 환영인사 = (TextView) Main.this.findViewById(R.id.환영인사);

        Glide.with(Main.this).load(uri).override(150, 150).into(프사); // 프사부분에 이미지띄워주기
        환영인사.setText(id + "(" + nick + ") 님 어서오세요");

        LinearLayout dqbtn = (LinearLayout) Main.this.findViewById(R.id.일일퀘스트); //일일퀘스트 이동버튼
        dqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dqmove = new Intent(Main.this, daily_quest.class);
//                dqmove.putExtra("날짜변경",dq_Reset ); // 날짜변경 변수 넘김
                dqmove.putExtra("일퀘상태", 일퀘상태); //버튼상태 유지를 위해서 액티비티 들어갈때 버튼상태 받아왔던거 재전송
                receive_Dq_State.launch(dqmove);
            }
        });
        LinearLayout dbbtn = (LinearLayout) findViewById(R.id.일일보스); //데일리보스 이동버튼

        dbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbmove = new Intent(Main.this, daily_boss.class);
                dbmove.putExtra("일보상태", 일간보스상태);
                receive_Db_State.launch(dbmove);
            }
        });
        LinearLayout wqbtn = (LinearLayout) findViewById(R.id.주간퀘스트); //위클리퀘스트 이동버튼

        wqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wqmove = new Intent(Main.this, weekly_quest.class);
                wqmove.putExtra("주간퀘상태", 주간퀘상태);
                receive_Wq_State.launch(wqmove);
            }
        });

        LinearLayout wbbtn = (LinearLayout) findViewById(R.id.주간보스); //위클리보스 이동버튼

        wbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wbmove = new Intent(Main.this, weekly_boss.class);
                wbmove.putExtra("주간보스상태", 주간보스상태);
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
                startActivity(mumove);
            }
        });

        //알람매니저로 일간,주간에 신호를줌
        //+일정표까지 신호날려줌
        //각각 클래스에서 받아서 상황에맞게 처리 (체크박스의경우엔 체크를 푼다던가)
        //일정표에서는 날짜가 바뀌면 메모내용이 해당날짜에 맞게 바뀐다던가 하는식으로
        //

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
        Log.d("Main", "ResetHour : " + setResetTime);

    }

    @Override
    protected void onStart() {
        Log.d("Main", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("Main", "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("Main", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("Main", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Main", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("Main", "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d("Main", "onSaveInstanceState: ");

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("Main", "onRestoreInstanceState: ");
    }
}

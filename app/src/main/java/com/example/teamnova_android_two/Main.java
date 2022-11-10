package com.example.teamnova_android_two;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Main extends AppCompatActivity {
    ArrayList<String> 아이디목록 = new ArrayList<>(); //아이디 저장리스트
    ArrayList<String> 닉네임목록 = new ArrayList<>(); //닉네임 저장리스트
    Uri uri; //이미지정보


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //이화면은 무조건 로그인후에 넘어올수밖에 없으므로 조건문없이 인텐트를 받아온다
        Intent data = getIntent();
        uri = data.getParcelableExtra("사진"); // paracelable -> 객체전달
        아이디목록 = (ArrayList<String>)data.getSerializableExtra("아이디");
        닉네임목록 = (ArrayList<String>)data.getSerializableExtra("닉네임");
        String id = 아이디목록.get(0);
        String nick = 닉네임목록.get(0);



        resetAlarm(this);// 알람실행

        ImageView 프사 = (ImageView)Main.this.findViewById(R.id.이미지);
        TextView 환영인사 = (TextView)Main.this.findViewById(R.id.환영인사);

        Glide.with(Main.this).load(uri).override(150,150).into(프사); // 프사부분에 이미지띄워주기
        환영인사.setText(id+"("+nick+") 님 어서오세요");






        LinearLayout dqbtn = (LinearLayout) Main.this.findViewById(R.id.일일퀘스트); //일일퀘스트 이동버튼
        dqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dqmove = new Intent(Main.this, daily_quest.class);
                startActivity(dqmove);
            }
        });
        LinearLayout dbbtn = (LinearLayout) findViewById(R.id.일일보스); //데일리보스 이동버튼

        dbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dbmove = new Intent(Main.this, daily_boss.class);
                startActivity(dbmove);
            }
        });
        LinearLayout wqbtn = (LinearLayout) findViewById(R.id.주간퀘스트); //위클리퀘스트 이동버튼

        wqbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wqmove = new Intent(Main.this, weekly_quest.class);
                startActivity(wqmove);
            }
        });

        LinearLayout wbbtn = (LinearLayout) findViewById(R.id.주간보스); //위클리보스 이동버튼

        wbbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wbmove = new Intent(Main.this, weekly_boss.class);
                startActivity(wbmove);
            }
        });

        LinearLayout timerbtn = (LinearLayout) findViewById(R.id.재획타이머); // 재획타이머 이동버튼

        timerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent timermove = new Intent(Main.this, timer.class);
                startActivity(timermove);
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
        AlarmManager resetAlarm = (AlarmManager)context.getSystemService(context.ALARM_SERVICE);
        Intent resetIntent = new Intent(context, alarm.class); // 로직클래스(alarm) 인텐트
        PendingIntent resetSender = PendingIntent.getBroadcast(context,0,resetIntent,PendingIntent.FLAG_MUTABLE);
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
        String setResetTime = format.format(new Date(resetCal.getTimeInMillis()+AlarmManager.INTERVAL_DAY));
        Log.d("resetAlarm", "ResetHour : " + setResetTime);

    }
}

package com.example.teamnova_android_two.재획타이머;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.teamnova_android_two.R;

import java.util.ArrayList;

public class Buff_Alarm implements Runnable{
    int 분;
    int 초;
    String 타이머이름;
    ArrayList 알림;
    TextView 텍스트;
    Activity activity;


    public Buff_Alarm(int 분, int 초,String 타이머이름 ,ArrayList 알림, Activity activity) {
        this.분 = 분;
        this.초 = 초;
        this.타이머이름 = 타이머이름;
        this.알림 = 알림;
        this.activity = activity;
    }
    Handler 핸들러 = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            텍스트 = (TextView) activity.findViewById(R.id.알림);


        }
    };


    @Override
    public void run() {
        텍스트 = (TextView) activity.findViewById(R.id.알림);
//        텍스트.setText(타이머이름+": "+분+" 분"+초+" 초 남았습니다");
        //핸들러처리
//        if(분 == 0 && 초 == 0){
//            텍스트.setText(타이머이름+" 종료");
//        }



    }
}

package com.example.teamnova_android_two.Reset;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.example.teamnova_android_two.Main.Main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Day_Listener extends Thread {
    Handler handler;
    boolean isRun = true;

    String 계정날짜;
    String 실제날짜;
    SharedPreferences 사용자정보;
    public static Context threadContext = null;
    //Main 온크리에이트에서 context 초기화후 가져옴(db때문에)


    String 아이디;


    public Day_Listener(Handler handler, String ID) {
        //생성자
        this.handler = handler;
        this.아이디 = ID;


    }
//    public void stopForever(){
//        synchronized (this){
//            //스레드가 작업중인동안 다른스레드 접근금지
//            this.isRun = false;
//        }
//    }

    public void run() {
        while (isRun) {
//            long systemTime = System.currentTimeMillis();
//            SimpleDateFormat formatter = new SimpleDateFormat("E", Locale.KOREA);
//            String 요일 = formatter.format(systemTime);
            Calendar 날짜 = Calendar.getInstance();


            사용자정보 = threadContext.getSharedPreferences(아이디, Context.MODE_PRIVATE);
            계정날짜 = 사용자정보.getString("날짜", "null");

            실제날짜 = String.format("%d%d%d", 날짜.get(Calendar.YEAR), 날짜.get(Calendar.MONTH) + 1, 날짜.get(Calendar.DATE));
            int 요일 = 날짜.get(Calendar.DAY_OF_WEEK);
            Log.d("요일", "run: " + 요일);

            if (!(실제날짜.equals(계정날짜))) {

                //계정에 저장된날짜와 실제날짜가 달라지면

                Message msg = handler.obtainMessage();

//                    msg.obj = "주간 스케쥴이 초기화 되었습니다";
                msg.what = 요일;


                handler.sendMessage(msg);


                //날짜 변경됐을때 목요일이면 주간초기화 메세지전송
                //아니면 일간초기화 메세지전송

                //쓰레드에있는 핸들러에게 날짜변경되었다고 메세지보냄
                //디비에 바뀐 날짜 다시저장
                SharedPreferences.Editor editor = 사용자정보.edit();
                editor.putString("날짜", 실제날짜);
                editor.apply();
            }

            try {

                Thread.sleep(1000);
            } catch (Exception e) {

            }
        }
    }

}

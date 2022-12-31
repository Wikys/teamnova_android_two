package com.example.teamnova_android_two.Reset;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class Day_Listener extends Thread{
    Handler handler;
    boolean isRun = true;


    public Day_Listener(Handler handler){
        //생성자
        this.handler = handler;
    }
    public void stopForever(){
        synchronized (this){
            //스레드가 작업중인동안 다른스레드 접근금지
            this.isRun = false;
        }
    }

    public void run(){
        while(isRun){
            handler.sendEmptyMessage(0);
            //쓰레드에있는 핸들러에게 메세지보냄
            try{
              Thread.sleep(10000);
            }catch (Exception e){

            }
        }
    }

}

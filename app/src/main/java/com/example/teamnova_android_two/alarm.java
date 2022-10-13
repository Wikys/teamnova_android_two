package com.example.teamnova_android_two;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class alarm extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

            Toast.makeText(context, "날짜가 바뀌어 모든 일일활동이 초기화 되었습니다", Toast.LENGTH_LONG).show();
        Log.e("Alarm","초기화알람.");//로그확인용


    }
}

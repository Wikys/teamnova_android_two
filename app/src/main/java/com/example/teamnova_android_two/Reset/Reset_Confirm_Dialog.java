package com.example.teamnova_android_two.Reset;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.teamnova_android_two.R;

import org.w3c.dom.Text;

public class Reset_Confirm_Dialog extends AppCompatActivity {
    private String 알림메세지;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Log.d("Reset_Confirm_Dialog", "onCreate: ");

        setContentView(R.layout.reset_confirm_dialog);


        Button 확인버튼 = (Button) findViewById(R.id.확인);
        확인버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        Log.d("Reset_Confirm_Dialog", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("Reset_Confirm_Dialog", "onResume: ");
        super.onResume();
        Bundle bundle;
        Intent intent = new Intent();
        intent = getIntent();
        알림메세지 = intent.getStringExtra("알림메세지");
        Log.d("서비스 번들(다이얼로그)", "onResume: "+알림메세지);

        TextView 알림텍스트뷰 = (TextView) findViewById(R.id.알림텍스트);
        알림텍스트뷰.setText(알림메세지);

    }

    @Override
    protected void onPause() {
        Log.d("Reset_Confirm_Dialog", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("Reset_Confirm_Dialog", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("Reset_Confirm_Dialog", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("Reset_Confirm_Dialog", "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Log.d("번들", "onNewIntent: ");
        super.onNewIntent(intent);
        setIntent(intent);
    }
}
package com.example.teamnova_android_two;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ToggleButton;

public class test_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);
        Log.d("test_activity", "onCreate: ");

        ToggleButton 테스트 = (ToggleButton) test_activity.this.findViewById(R.id.테스트);



    }
    @Override
    protected void onStart() {
        Log.d("test_activity", "onStart: ");
        super.onStart();
    }
    @Override
    protected void onResume() {
        Log.d("test_activity", "onResume: ");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("test_activity", "onPause: ");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("test_activity", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("test_activity", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("test_activity", "onRestart: ");
        super.onRestart();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        Log.d("test_activity", "onSaveInstanceState: ");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        Log.d("test_activity", "onRestoreInstanceState: ");
        super.onRestoreInstanceState(savedInstanceState);
    }
}
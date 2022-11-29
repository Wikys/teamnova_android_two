package com.example.teamnova_android_two.seed_24;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.seed_helper_23;
import com.example.teamnova_android_two.seed_helper_36;
import com.example.teamnova_android_two.seed_helper_39;
import com.example.teamnova_android_two.seed_helper_47;
import com.example.teamnova_android_two.seed_helper_48;
import com.example.teamnova_android_two.seed_helper_49;

import java.util.ArrayList;

public class seed_helper_24 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seed_helper_24);

        ArrayList<seed_helper_24_data> data = new ArrayList();

        data.add(new seed_helper_24_data(R.drawable.less,"리스항구","푸른빛 바다가 보이는 부둣가에서 갈매기가 날아다니는 것을 바라보고 있는 느낌이 들어."));
        data.add(new seed_helper_24_data(R.drawable.perion,"페리온","황량한 바람이 부는 황무지 한가운데, 비장한 전투 부족과 마주친 느낌이 들어."));
        data.add(new seed_helper_24_data(R.drawable.ellinia,"엘리니아","신비로운 느낌이 들어. 지금 요정들이 사는 숲속에 있는 게 아닐까?"));

        RecyclerView bgmRv = (RecyclerView) this.findViewById(R.id.브금퀴즈);

        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
        bgmRv.setLayoutManager(리니어매니저);

        BGM_Adapter 리사이클러어댑터 = new BGM_Adapter(this,data);//
        bgmRv.setAdapter(리사이클러어댑터);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(bgmRv.getContext(), new LinearLayoutManager(this).getOrientation());
        bgmRv.addItemDecoration(dividerItemDecoration);
        //디바이더 데코




        Button btn23 = (Button) findViewById(R.id.시드23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move23 = new Intent(seed_helper_24.this, seed_helper_23.class);
                move23.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move23);
            }
        });

        Button btn36 = (Button) findViewById(R.id.시드36);

        btn36.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move36 = new Intent(seed_helper_24.this, seed_helper_36.class);
                move36.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move36);
            }
        });
        Button btn39 = (Button) findViewById(R.id.시드39);

        btn39.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move39 = new Intent(seed_helper_24.this, seed_helper_39.class);
                move39.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move39);
            }
        });
        Button btn47 = (Button) findViewById(R.id.시드47);

        btn47.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move47 = new Intent(seed_helper_24.this, seed_helper_47.class);
                move47.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move47);
            }
        });
        Button btn48 = (Button) findViewById(R.id.시드48);

        btn48.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move48 = new Intent(seed_helper_24.this, seed_helper_48.class);
                move48.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move48);
            }
        });
        Button btn49 = (Button) findViewById(R.id.시드49);

        btn49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent move49 = new Intent(seed_helper_24.this, seed_helper_49.class);
                move49.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(move49);

            }
        });
    }
}
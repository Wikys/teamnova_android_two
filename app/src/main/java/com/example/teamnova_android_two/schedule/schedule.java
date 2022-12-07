package com.example.teamnova_android_two.schedule;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teamnova_android_two.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class schedule extends AppCompatActivity {
        Map<String, String> 메모리스트 = new HashMap<>();
    Map<String, String> 키리스트 = new HashMap<>();
    schedule_Adapter 리사이클러어댑터;
//    ArrayList<schedule_data> data, filter;
//    String 메모;
//    int 년;
//    int 월;
//    int 일;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);

//        data = new ArrayList(); // (동적)날짜저장
//        filter = new ArrayList(); // 메모랑 대조하기위한 날짜저장 리스트


        //데이터모델 추가

//        RecyclerView scRv = (RecyclerView) this.findViewById(R.id.요약);
//
//        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
//        scRv.setLayoutManager(리니어매니저);
//
//        리사이클러어댑터 = new schedule_Adapter(this, data);//
//        scRv.setAdapter(리사이클러어댑터);

        //누른뷰의 이어,몬스,데이오브몬스가 같으면 리사이클러뷰에서 찾아서 출력 이런느낌으로 짜보기?

        Button 저장 = (Button) findViewById(R.id.저장); //저장버튼
        Button 삭제 = (Button) findViewById(R.id.삭제); //삭제버튼
        TextView 메모 = (TextView) findViewById(R.id.요약); // 메모장
        CalendarView 일정 = (CalendarView) findViewById(R.id.일정); // 달력

//        일정.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                저장.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
//                삭제.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
//                년 = year;
//                월 = month;
//                일 = dayOfMonth;
//                data.add(new schedule_data(메모,년,월,일));
//
//
//
//            }
//        });



        일정.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { //달력 날짜클릭하면 반응하는 리스너
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                String key = String.format("%d%d%d", year, month + 1, dayOfMonth); //해시맵 키값으로 저장할변수
                저장.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
                삭제.setVisibility(view.VISIBLE); //날짜를 눌렀을때 버튼나오게함
                //날짜누르면 날짜에저장돼있던버튼 뿌려주기
                if (메모리스트.containsKey(key)) { //날짜와 일치하는 값이 있는 확인하고
                    메모.setText(메모리스트.get(key)); //저장해둔 해시맵 불러와서 메모에 적용
                } else {
                    메모.setText(null);
                }

                Button 저장버튼 = (Button) findViewById(R.id.저장);

                저장버튼.setOnClickListener(new View.OnClickListener() { //저장버튼 누르면 저장하는 리스너
                    @Override
                    public void onClick(View view) {
                        String 메모저장 = 메모.getText().toString();
                        메모리스트.put(key, 메모저장);
                        키리스트.put(key, key); // 나중에 키값찾기용
                        Toast.makeText(schedule.this, "저장되었습니다", Toast.LENGTH_SHORT).show();
                    }
                });

                Button 삭제버튼 = (Button) findViewById(R.id.삭제);

                삭제버튼.setOnClickListener(new View.OnClickListener() { //삭제버튼 누르면 날짜에 저장된메모 삭제
                    @Override
                    public void onClick(View view) {
                        메모리스트.remove(key);
                        키리스트.remove(key);
                        메모.setText(null);//삭제하고 메모비워주기
                        Toast.makeText(schedule.this, "삭제되었습니다", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });

    }

}
package com.example.teamnova_android_two.mulung_helper_scedule;



import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teamnova_android_two.R;
import com.example.teamnova_android_two.mulung_helper;
import com.example.teamnova_android_two.recyclerView_height;
import com.example.teamnova_android_two.seed_24.BGM_Adapter;
import com.example.teamnova_android_two.seed_24.seed_helper_24_data;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class mulung_helper_schedule extends AppCompatActivity implements mulung_helper_schedule_Adapter.OnItemClickListener {
    ArrayList<mulung_helper_schedule_data> data, filter;
    RecyclerView mhSchedule;
    mulung_helper_schedule_Adapter 리사이클러어댑터;

    Button 수정버튼;
    Button 저장버튼;
    Button 삭제버튼;
    TextView 분;
    TextView 초;
    TextView 제목;
    TextView 준비;
    Button 종료;
    int 포지션; //아이템번호 알아내기위해서 포지션값 받아온거 저장


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.mulung_helper_scedule);
        Log.d("mulung_helper_schedule", "onCreate: ");

        data = new ArrayList();
        filter = new ArrayList();

        mhSchedule = (RecyclerView) this.findViewById(R.id.저장목록);

        LinearLayoutManager 리니어매니저 = new LinearLayoutManager(this);
        mhSchedule.setLayoutManager(리니어매니저);

        리사이클러어댑터 = new mulung_helper_schedule_Adapter(this, data);//
        mhSchedule.setAdapter(리사이클러어댑터);

        recyclerView_height decoration_height = new recyclerView_height(20);
        mhSchedule.addItemDecoration(decoration_height); //데코레이션으로 높이 적용

         저장버튼 = (Button) this.findViewById(R.id.저장버튼);
         삭제버튼 = (Button) this.findViewById(R.id.삭제버튼);
        수정버튼 = (Button) this.findViewById(R.id.수정버튼);
         분 = (TextView) this.findViewById(R.id.분);
         초 = (TextView) this.findViewById(R.id.초);
         제목 = (TextView) this.findViewById(R.id.제목);
         준비 = (TextView) this.findViewById(R.id.준비);
         종료 = (Button) this.findViewById(R.id.종료버튼);


//        int 분변환 = Integer.parseInt(분.getText().toString());
//        int 초변환 = Integer.parseInt(초.getText().toString());


        저장버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("mulung_helper_schedule", "onClick: ");
                if (!(분.getText().toString().equals("")) && !(초.getText().toString().equals(""))) {

                    String 제목변환 = 제목.getText().toString();
                    String 메모변환 = 준비.getText().toString();

                    int 분변환 = Integer.parseInt(분.getText().toString());
                    int 초변환 = Integer.parseInt(초.getText().toString());
                    //데이터모델에 넣기위해 형변환

//                    mulung_helper_schedule_data save = new mulung_helper_schedule_data(제목변환, 메모변환, 분변환, 초변환);
                    //형변환이 잘못된건지 읽지를못하고 버튼이 하나이상 추가가안됨
//                    mulung_helper_schedule_data save = new mulung_helper_schedule_data("ㅇㅇ", "ㅇㅇ", 1, 1);
                    data.add(new mulung_helper_schedule_data(제목변환, 메모변환, 분변환, 초변환));
                    리사이클러어댑터.notifyItemInserted(data.size());
                    //데이터에 새로 삽입된 데이터의 위치(int)

                    Toast.makeText(mulung_helper_schedule.this, "저장완료", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(mulung_helper_schedule.this, "전부 입력후 저장해주세요", Toast.LENGTH_SHORT).show();
                }

            }
        });
        수정버튼.setOnClickListener(new View.OnClickListener() { //수정기능
            @Override
            public void onClick(View v) {
                Log.d("mulung_helper_schedule", "onClick: ");

                String 제목변환 = 제목.getText().toString();
                String 메모변환 = 준비.getText().toString();
                int 분변환 = Integer.parseInt(분.getText().toString());
                int 초변환 = Integer.parseInt(초.getText().toString());

                data.set(포지션,new mulung_helper_schedule_data(제목변환, 메모변환, 분변환, 초변환));
                //포지션번호에 있는 데이터 수정해서 추가
                리사이클러어댑터.notifyItemChanged(포지션);
                //어댑터 특정포지션 아이템목록 변경
                Toast.makeText(mulung_helper_schedule.this, "수정완료", Toast.LENGTH_SHORT).show();

            }
        });
        삭제버튼.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mulung_helper_schedule", "onClick: ");
                data.remove(포지션);
                //데이터목록삭제
                리사이클러어댑터.notifyItemRemoved(포지션);
                //삭제된 데이터 어댑터에서도 적용
                리사이클러어댑터.notifyItemRangeChanged(포지션,data.size());
                //아이템의 포지션이 싹다변경되야하므로 변경된아이템의 위치와 아이템의갯수를 넣어서 호출

                Toast.makeText(mulung_helper_schedule.this, "삭제완료", Toast.LENGTH_SHORT).show();
            }
        });
        종료.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mulung_helper_schedule", "onClick: ");
                finish();
            }
        });

        리사이클러어댑터.setOnItemClickListener(this);

//    private void newSaveList() { // 저장목록에 버튼추가하는 메소드
//        EditText memo = (EditText) findViewById(R.id.준비);
//        EditText m_get = (EditText) findViewById(R.id.분);
//        EditText s_get = (EditText) findViewById(R.id.초);
//        String 분 = m_get.getText().toString(); //분에 쓴 텍스트 변수화
//        String 초 = s_get.getText().toString(); //초에 쓴 텍스트 변수화
//        String 메모 = memo.getText().toString(); //메모에 쓴 텍스트 변수화
//        LinearLayout 저장목록 = (LinearLayout) findViewById(R.id.저장목록); // 동적 레이아웃 아이디가져오기
//        EditText title = (EditText) findViewById(R.id.제목); //사용자가 정한 제목
//        String 제목 = title.getText().toString(); // 제목에 쓴 텍스트 변수화
//        int 캐스팅분 =0;
//        int 캐스팅초 =0;
//
//        if (!(m_get.getText().toString().equals("")) && !(s_get.getText().toString().equals(""))) {
//            캐스팅분 = Integer.valueOf(String.valueOf(m_get.getText()));//조건문에 대입해주기위해서 인트로 캐스팅
//            캐스팅초 = Integer.valueOf(String.valueOf(s_get.getText()));
//        }
//        if (제목리스트.containsKey(제목)) { //제목이 같으면 기존에 있던 버튼을 수정
//            if (!(캐스팅분 > 14) && !(캐스팅초 > 60)) {
//                신규 = false;
//                메모리스트.replace(제목, 메모); // 해시맵에 메모저장
//                분리스트.replace(제목, 분); // 해시맵에 분저장
//                초리스트.replace(제목, 초); // 해시맵에 초저장
//                분초리스트.replace(제목, 분 + 초); // 밖으로 내보낼 데이터
//                Toast.makeText(this, "변경완료", Toast.LENGTH_SHORT).show();
//                return;
//            } else {
//                Toast.makeText(this, "14분 60초 초과불가능", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//        } else if (!제목리스트.containsKey(제목)) {
//            신규 = true;
//            //제목같으면안되고(o) 시간비어있으면안되고(o) 제목비어있으면 안되고(x)
//            //시간같으면안되고(o)
//            //분이 14이상이면안되고 초가 60이상이면 안되고(o)
//
//            if (!(캐스팅분 > 14) && !(캐스팅초 > 60) && !(캐스팅초 == 0)) {
//                if (!분리스트.containsValue(분) || !초리스트.containsValue(초)) { // 시간이 같으면 안되게끔
//                    numButton++; // 버튼아이디 뒤에 붙일 숫자
//                    제목리스트.put(제목, 제목); // 해시맵에 제목저장
//                    메모리스트.put(제목, 메모); // 해시맵에 메모저장
//                    분리스트.put(제목, 분); // 해시맵에 분저장
//                    초리스트.put(제목, 초); // 해시맵에 초저장
//                    분초리스트.put(제목, 분 + 초); // 밖으로 내보낼 데이터
//                    Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, "시간이 겹칩니다", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            } else {
//                Toast.makeText(this, "14분 60초 초과불가능, 0초 입력x", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        } else {
//            Toast.makeText(this, "제목을 확인해주세요", Toast.LENGTH_SHORT).show();
//            return;
//        }





//        삭제버튼.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                final mulung_helper_schedule_data item = 리사이클러어댑터.getSelected();
//                if (item == null) {
////                    데이터모델이 비어있으면
//                    Toast.makeText(mulung_helper_schedule.this, "지울 저장목록을 선택해주세요", Toast.LENGTH_SHORT).show();
//                    return;
//                    //작동안하게처리
//                }
//                data.remove(item);
//                //선택한 아이템 리스트에서삭제
//
//                final int checkedPosition = 리사이클러어댑터.getCheckedPosition();
//                //포지션번호 받아와서
//                리사이클러어댑터.notifyItemRemoved(checkedPosition);
//                //포지션에 맞는 아이템 리무브
//                리사이클러어댑터.clearSelected();
//                //아이템 하나 빠졌으니 만든 포지션변수 포지션값 하나 줄여줌
//            }
//        });

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }

    @Override//커스텀온클릭리스너 리사이클러뷰 아이템클릭시 작동
    public void onClick(View v, mulung_helper_schedule_data data) {
        Log.d("mulung_helper_schedule", "onClick: ");
        포지션 = (int) v.getTag();
        Toast.makeText(this,  포지션 +" : "+ data, Toast.LENGTH_SHORT).show();
//        분초제목준비


        제목.setText(data.제목);
        분.setText(String.valueOf(data.분));
        초.setText(String.valueOf(data.초));
        준비.setText(data.메모);
    }

}


//    private final int id = 0x8000; //버튼아이디 변수
//    private Integer numButton = 0; // 버튼의 개수
//    ArrayList<String> buttonNameList = new ArrayList<>(); //만든 버튼 이름들이 저장되는곳
//    //버튼 추가되는 레이아웃
//
//    Map<String, String> 제목리스트 = new HashMap<>();
//    Map<String, String> 메모리스트 = new HashMap<>();
//    Map<String, String> 분리스트 = new HashMap<>();
//    Map<String, String> 초리스트 = new HashMap<>();
//    Map<String, String> 분초리스트 = new HashMap<>();
//    boolean 신규;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d("mulung_helper_scedule", "onCreate: ");
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        setContentView(R.layout.mulung_helper_scedule);
//        Button save = (Button) findViewById(R.id.저장버튼);
//        save.setOnClickListener(new View.OnClickListener() { //버튼생성 이벤트
//            @Override
//            public void onClick(View view) {
//
//                newSaveList();
//                //if문으로
//                //생성된 버튼이름을 해쉬맵과 비교해서
//                //기존에 있던 버튼 제목지정한거랑 중복되면 경고(시간도)
//                //아니면 생성
//            }
//        });
//
//        Button exit = (Button) findViewById(R.id.종료버튼);
//        exit.setOnClickListener(new View.OnClickListener() { //x버튼 눌렀을때 꺼지게하기 onstop
//            @Override
//            public void onClick(View view) { //x버튼 누르면 액티비티파괴
//                Intent put_data = new Intent(mulung_helper_scedule.this, mulung_helper.class);
//                put_data.putExtra("제목", (Serializable) 제목리스트);
//                put_data.putExtra("메모", (Serializable) 메모리스트);
//                put_data.putExtra("분", (Serializable) 분리스트);
//                put_data.putExtra("초", (Serializable) 초리스트);
//                put_data.putExtra("분초", (Serializable) 분초리스트);
//                setResult(RESULT_OK, put_data);
//                finish();
//            }
//        });
//
//    }
//
//    private void newSaveList() { // 저장목록에 버튼추가하는 메소드
//        EditText memo = (EditText) findViewById(R.id.준비);
//        EditText m_get = (EditText) findViewById(R.id.분);
//        EditText s_get = (EditText) findViewById(R.id.초);
//        String 분 = m_get.getText().toString(); //분에 쓴 텍스트 변수화
//        String 초 = s_get.getText().toString(); //초에 쓴 텍스트 변수화
//        String 메모 = memo.getText().toString(); //메모에 쓴 텍스트 변수화
//        LinearLayout 저장목록 = (LinearLayout) findViewById(R.id.저장목록); // 동적 레이아웃 아이디가져오기
//        EditText title = (EditText) findViewById(R.id.제목); //사용자가 정한 제목
//        String 제목 = title.getText().toString(); // 제목에 쓴 텍스트 변수화
//        int 캐스팅분 =0;
//        int 캐스팅초 =0;
//
//        if (!(m_get.getText().toString().equals("")) && !(s_get.getText().toString().equals(""))) {
//            캐스팅분 = Integer.valueOf(String.valueOf(m_get.getText()));//조건문에 대입해주기위해서 인트로 캐스팅
//            캐스팅초 = Integer.valueOf(String.valueOf(s_get.getText()));
//        }
//        if (제목리스트.containsKey(제목)) { //제목이 같으면 기존에 있던 버튼을 수정
//            if (!(캐스팅분 > 14) && !(캐스팅초 > 60)) {
//                신규 = false;
//                메모리스트.replace(제목, 메모); // 해시맵에 메모저장
//                분리스트.replace(제목, 분); // 해시맵에 분저장
//                초리스트.replace(제목, 초); // 해시맵에 초저장
//                분초리스트.replace(제목, 분 + 초); // 밖으로 내보낼 데이터
//                Toast.makeText(this, "변경완료", Toast.LENGTH_SHORT).show();
//                return;
//            } else {
//                Toast.makeText(this, "14분 60초 초과불가능", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//        } else if (!제목리스트.containsKey(제목)) {
//            신규 = true;
//            //제목같으면안되고(o) 시간비어있으면안되고(o) 제목비어있으면 안되고(x)
//            //시간같으면안되고(o)
//            //분이 14이상이면안되고 초가 60이상이면 안되고(o)
//
//            if (!(캐스팅분 > 14) && !(캐스팅초 > 60) && !(캐스팅초 == 0)) {
//                if (!분리스트.containsValue(분) || !초리스트.containsValue(초)) { // 시간이 같으면 안되게끔
//                    numButton++; // 버튼아이디 뒤에 붙일 숫자
//                    제목리스트.put(제목, 제목); // 해시맵에 제목저장
//                    메모리스트.put(제목, 메모); // 해시맵에 메모저장
//                    분리스트.put(제목, 분); // 해시맵에 분저장
//                    초리스트.put(제목, 초); // 해시맵에 초저장
//                    분초리스트.put(제목, 분 + 초); // 밖으로 내보낼 데이터
//                    Toast.makeText(this, "저장완료", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, "시간이 겹칩니다", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//            } else {
//                Toast.makeText(this, "14분 60초 초과불가능, 0초 입력x", Toast.LENGTH_SHORT).show();
//                return;
//            }
//        } else {
//            Toast.makeText(this, "제목을 확인해주세요", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//
//        Button savelist = new Button(this); // 버튼생성
//        savelist.setText(title.getText()); //제목에 입력한 텍스트를 버튼이름으로 지정
//        savelist.setId(id + numButton); //제목에 입력한 텍스트를 아이디로 지정
//
//        savelist.setOnClickListener(new View.OnClickListener() { // 버튼클릭하면 작동할코드
//            public void onClick(View v) { // v <- 클릭한뷰
//                //클릭한뷰에맞는 키값(제목)을 가진 해쉬맵의 벨류(값)를 뿌려주기
//                //어디에? 제목 메모 분 초
//                //제목 -> 해시맵 핵심키값
//                //메모 -> 팝업창 메모내용, 메인에넘겨주기
//                //분,초 -> 팝업창 메모내용, 메인에 넘겨주기
//
//                title.setText(제목리스트.get(제목));
//                memo.setText(메모리스트.get(제목));
//                m_get.setText(분리스트.get(제목));
//                s_get.setText(초리스트.get(제목));
//
//                Button delete = (Button) findViewById(R.id.삭제버튼);
//                delete.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        제목리스트.remove(제목); //해시맵에 등록된데이터 삭제
//                        메모리스트.remove(제목);
//                        분리스트.remove(제목);
//                        초리스트.remove(제목);
//                        분초리스트.remove(제목);
//                        저장목록.removeView(v); //저장한버튼 삭제
//
//                    }
//                });
//
//            }
//        });
//        if (신규) { //신규생성로직으로 등록된버튼이면 생성
//            저장목록.addView(savelist, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
//        } else {
//            Toast.makeText(this, "변경 되었습니다", Toast.LENGTH_SHORT).show();
//            신규 = true;
//        }
//
//
//    }
//
//
//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        //바깥레이어 클릭시 안닫히게
//        if (event.getAction() == MotionEvent.ACTION_OUTSIDE) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public void onBackPressed() {
//        //안드로이드 백버튼 막기
//        return;
//    }
//
//    @Override
//    protected void onStop() { // 온스탑될때 저장목록에 있는 시간,메모정보를 메인에 쏴줘야함
//        Log.d("mulung_helper_scedule", "onStop: ");
//
//
//        super.onStop();
//    }
//
//    @Override
//    protected void onStart() {
//        Log.d("mulung_helper_scedule", "onStart: ");
//        super.onStart();
//    }
//
//    @Override
//    protected void onResume() {
//        Log.d("mulung_helper_scedule", "onResume: ");
//        super.onResume();
//    }
//
//    @Override
//    protected void onPause() {
//        Log.d("mulung_helper_scedule", "onPause: ");
//        super.onPause();
//    }
//
//    @Override
//    protected void onDestroy() {
//        Log.d("mulung_helper_scedule", "onDestroy: ");
//        super.onDestroy();
//    }
//
//    @Override
//    protected void onRestart() {
//        Log.d("mulung_helper_scedule", "onRestart: ");
//        super.onRestart();
//    }
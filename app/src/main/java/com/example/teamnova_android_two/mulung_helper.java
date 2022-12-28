package com.example.teamnova_android_two;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.teamnova_android_two.mulung_helper_scedule.mulung_helper_schedule;
import com.example.teamnova_android_two.mulung_helper_scedule.mulung_helper_schedule_data;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class mulung_helper extends AppCompatActivity implements Serializable {
    //    int 분타이머 = 1; //14 초기값
//    int 초타이머 = 5; //60 초기값
//    private Timer m_timer; //타이머
//    private TimerTask mt_timer;
//    private Timer r_timer; //휴식타이머
//    private TimerTask rt_timer;
//    int 휴식 = 3; //10
//    boolean 중복 = false;
    int 분타이머 = 1; //120 초기값
    int 초타이머 = 2; //0 초기값
    int 디폴트분 = 1; // 기본값 (구분용)
    int 디폴트초 = 2; // 기본값
    int 휴식 = 3; // 휴식타이머용
    int 디폴트휴식 = 3; // 기본값
    String 아이디;
    ArrayList<mulung_helper_schedule_data> schedule;
    SharedPreferences 사용자정보;
    TextView 준비;

    private Timer m_timer; //타이머
    private TimerTask mt_timer;
    private Timer r_timer; //휴식타이머
    private TimerTask rt_timer;
    Boolean end = false;
    Boolean rest_End = false;
    Boolean end_Onstop = false;
    Boolean rest_End_Onstop = false;
    Boolean rest_Useable = false;

    Handler memoHandler;
    Handler 메모핸들러;

//    Map<String, String> 제목 = new HashMap<>();
//    Map<String, String> 메모 = new HashMap<>();
//    Map<String, String> 분 = new HashMap<>();
//    Map<String, String> 초 = new HashMap<>();
//    Map<String, String> 분초 = new HashMap<>();

    ActivityResultLauncher<Intent> receive_Memo_State = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) { //이동한 액티비티에서 RESULT_OK사인이오면
                        //겟엑스트라 입력
                        Intent 스케쥴 = result.getData();
//                        제목 = (HashMap<String, String>) 스케쥴.getSerializableExtra("제목");
//                        메모 = (HashMap<String, String>) 스케쥴.getSerializableExtra("메모");
//                        분 = (HashMap<String, String>) 스케쥴.getSerializableExtra("분");
//                        초 = (HashMap<String, String>) 스케쥴.getSerializableExtra("초");
//                        분초 = (HashMap<String, String>) 스케쥴.getSerializableExtra("분초");


                        //스케쥴 등록해논거 가져옴
                        Log.d("mulung_helper", "onActivityResult: ");
                    }
                }
            }); //메모런쳐


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mulung_helper);
        Log.d("mulung_helper", "onCreate: ");

        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);
        Button 시작하기 = (Button) mulung_helper.this.findViewById(R.id.시작);
        Button 중단하기 = (Button) mulung_helper.this.findViewById(R.id.중단);

        TextView 휴식하기 = (TextView) mulung_helper.this.findViewById(R.id.휴식);
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체
        Button memo = (Button) findViewById(R.id.메모);



        Intent idget = getIntent();
        아이디 = idget.getStringExtra("아이디");


//        memoHandler = new Handler(Looper.getMainLooper()){
//            @Override
//            public void handleMessage(android.os.Message msg){
//                //서비스랑 연동해서 사용가능
//                //서비스로 24시간 감시하면서 시간에따라 일정초기화 하는식으로 이용할수있을듯? (UI쪽)
//                super.handleMessage(msg);
//                //이곳에 이벤트를 모이게끔해서
//                //이안에서 ui변경처리를 하게됨 (리스너같은느낌)
//                if(msg.what == 1) { // 1번일경우 정상메세지
//
//                    Toast.makeText(mulung_helper.this, "", Toast.LENGTH_SHORT).show();
//                }
//                else if(msg.what == 2){ // 2번인경우 이미지파일 뭐 이런식으로 처리가능
//
//                }
//
//            }
//        };
//        //핸들러로 데이터 전달(데이터가 순차적으로 처리될 수 있도록)
//        Message msg = memoHandler.obtainMessage();
//        msg.what = 1; //일련번호처럼 사용 (구분자느낌?)
//        msg.obj = "메세지당!!";
//        memoHandler.sendMessage(msg);
//        //여기서 샌드메세지를 하면 위에 핸들메세지에서 잡힘
//        //이거쓸라면 스레드에 넣어서 써야할거같은데

        시작하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (end == false) {
                    end = true;
                    timer();
                } else {
                    Toast.makeText(mulung_helper.this, "이미 작동중 입니다", Toast.LENGTH_SHORT).show();
                }

            }
        });
        중단하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (m_timer != null || r_timer != null) {
                    timer_Stop();
                } else {
                    Toast.makeText(mulung_helper.this, "실행중인 타이머가 없습니다 ", Toast.LENGTH_SHORT).show();
                }
            }
        });


        휴식하기.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                rest_Timer();

            }
        });


        memo.setOnClickListener(new View.OnClickListener() {
            //메모설정화면으로 넘어가는 버튼
            @Override
            public void onClick(View view) {
                Intent m_Move = new Intent(mulung_helper.this, mulung_helper_schedule.class);
                m_Move.putExtra("아이디",아이디);

                receive_Memo_State.launch(m_Move);

            }
        });


    }


    private void timer() { //타이머 생성 메소드
        memoHandler = new Handler();
        준비 = (TextView) mulung_helper.this.findViewById(R.id.준비);
        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);
        if (r_timer != null && rt_timer != null) {
            r_timer.cancel();
            rt_timer.cancel();
            r_timer = null;
            rt_timer = null;
            rest_End = false;
            휴식 = 디폴트휴식;

        }
        rest_Useable = true;

        m_timer = new Timer();
        mt_timer = new TimerTask() {


            @Override
            public void run() {
                String 분텍스트 = Integer.toString(분타이머); //비교를위해 스트링으로 캐스팅
                String 초텍스트 = Integer.toString(초타이머);
//                String 키합 = 분텍스트 + 초텍스트; // 이거필요없을듯

//                if (초타이머 > 0 || 분타이머 > 0) {
//                    if (!(분초 == null)) { //해시맵 비어있는지 먼저체크
//                        if (분초.containsValue(키합)) {
//                            TextView 준비 = (TextView) mulung_helper.this.findViewById(R.id.준비);

//                            keySet 키분석 = new keySet(분텍스트, 초텍스트, 분초); //키를 찾아주는 클래스
//                            String 키 = 키분석.result(); // 분석된 키값을 변수에저장
//                            String 메모수정 = 메모.get(키); // 키값을 인자로주고 저장된 메모받아오기
//                                    준비.setText(메모수정); //텍스트뷰 메모수정인데 핸들러없어서 안됨
                //쓰레드에서 계속 포문을 돌리면서 시간과 맞으면 출력 이런식으로 구현?

//                        }
//                    }

                if (초타이머 > 0 || 분타이머 > 0) {
                    if (schedule.size() > 0) { // 메모가 저장되어있는 어레이리스트 크기가 0이상일떄 작동
                        //쓰레드에서 계속 포문을 돌리면서 시간과 맞으면 출력 이런식으로 구현?
                        memoHandler.post(new Runnable() { //핸들러
                            @Override
                            public void run() {
//                                Log.d("run", "run: "+분타이머+"분 "+초타이머+"초");

                                for (int i = 0; i < schedule.size(); i++){
                                    if(분타이머 == schedule.get(i).get분() && 초타이머 == schedule.get(i).get초()){
                                        준비.setText(schedule.get(i).get메모());
                                        Log.d("run", "run: "+schedule.get(i).get메모());
                                    }

                                }

                            }
                        });

                    }

                    초타이머--;
                    if (초타이머 < 0 && 분타이머 > 0) {
                        분타이머--;
                        초타이머 = 디폴트초; // 59
                    }
                    타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
                } else {
                    timer_Stop();
                }
            }

        };
        m_timer.schedule(mt_timer, 0, 1000);

    }

    private void timer_Stop() { //타이머 중단 메소드
        Vibrator 진동 = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE); //진동객체

        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);

        준비 = (TextView) mulung_helper.this.findViewById(R.id.준비);

        if (r_timer != null && rt_timer != null) {
            r_timer.cancel();
            rt_timer.cancel();
            r_timer = null;
            rt_timer = null;
        } else if (m_timer != null && mt_timer != null) {
            m_timer.cancel();
            mt_timer.cancel();
            m_timer = null;
            mt_timer = null;
        }

        휴식 = 디폴트휴식;
        end = false;
        rest_End = false;
        rest_Useable = false;
        분타이머 = 디폴트분;
        초타이머 = 디폴트초;
        타이머.setText(분타이머 + "분" + " " + 초타이머 + "초");
        준비.setText("");
        진동.vibrate(500);
        mulung_helper.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(mulung_helper.this, "재획타이머가 종료되었습니다", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void rest_Timer() { //휴식타이머
        TextView 타이머 = (TextView) mulung_helper.this.findViewById(R.id.타이머);
        Button 시작하기 = (Button) mulung_helper.this.findViewById(R.id.시작);
        if (rest_End == false && rest_Useable == true) {
            // 새변수 만들어서 구분해야할ㄷ스 불린하나더만들어서 타이머 실행중일때 활성화하고
            if (m_timer != null && mt_timer != null) { //리스타트후 재실행을 위해 분기를 나눔..
                m_timer.cancel();
                mt_timer.cancel();
                m_timer = null;
                mt_timer = null;
            }
            end = false;
            rest_End = true;

            r_timer = new Timer();
            rt_timer = new TimerTask() {
                @Override
                public void run() {
                    if (휴식 > 0) {
                        휴식--;
                        타이머.setText(휴식 + "초");

                    } else { //그냥 시간다되서 끝나면
                        r_timer.cancel();
                        rt_timer.cancel();
                        r_timer = null;
                        rt_timer = null;
                        휴식 = 디폴트휴식;
//                        end = false;
                        rest_End = false;
                        시작하기.callOnClick();
                    }

                }
            };
            r_timer.schedule(rt_timer, 0, 1000);

        } else {
            Toast.makeText(this, "우선 타이머를 실행시켜주세요", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        Log.d("mulung_helper", "onStart: ");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("mulung_helper", "onResume: ");
        super.onResume();
        schedule = new ArrayList();
        schedule = Assignment_load("무릉DB");

    }

    @Override
    protected void onPause() {
        Log.d("mulung_helper", "onPause: ");
        if (m_timer != null) {
            m_timer.cancel();//팅기거나 뒤로가기눌렀을때 타이머중단
            end = false;
            end_Onstop = true;
        }
        if (mt_timer != null) {
            mt_timer.cancel();
        }
        if (r_timer != null) {
            r_timer.cancel();
            rest_End = false;
            rest_End_Onstop = true;
            rest_Useable = true;
        }
        if (rt_timer != null) {
            rt_timer.cancel();
        }
        super.onPause();
    }

    @Override
    protected void onStop() {

        Log.d("mulung_helper", "onStop: ");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("mulung_helper", "onDestroy: ");
        super.onDestroy();
    }

    @Override
    protected void onRestart() { // 다시 돌아오면 타이머 재시작
        Log.d("mulung_helper", "onRestart: ");
        if (분타이머 != 디폴트분 || 초타이머 != 디폴트초) {
            if (end_Onstop == true) { //타이머와 휴식타이머를 구분해서 실행

                end_Onstop = false;
                timer();
            } else if (rest_End_Onstop == true) {

                rest_End_Onstop = false;
                초타이머 = 휴식;
                rest_Timer();
            }
        }
        super.onRestart();
    }

    public ArrayList<mulung_helper_schedule_data> Assignment_load(String Type) {
        //인자: 디비에저장된이름(불러오기용)
        //각종 숙제 상태저장 불러오는 메소드
        //해쉬맵 변환하여 불러오는 메소드
        ArrayList<mulung_helper_schedule_data> outputList = new ArrayList<mulung_helper_schedule_data>();
        //배출용 해쉬맵 선언
        사용자정보 = getSharedPreferences(아이디, MODE_PRIVATE);
        String defValue = new Gson().toJson(new ArrayList<mulung_helper_schedule_data>());
        //불러올정보가 없을때 디폴트값
        String json = 사용자정보.getString(Type, defValue);
        TypeToken<ArrayList<mulung_helper_schedule_data>> type = new TypeToken<ArrayList<mulung_helper_schedule_data>>() {
        };
        //암시적 형변환해주는 클래스
        ArrayList<mulung_helper_schedule_data> returnMap = new Gson().fromJson(json, type.getType());
        //첫번째인자 : 불러온 데이터 , 두번째인자 : 불러온 데이터의 타입
        return returnMap;
    }

}
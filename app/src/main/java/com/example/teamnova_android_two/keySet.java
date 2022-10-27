package com.example.teamnova_android_two;

import java.util.Map;

public class keySet { // 키 찾아주는 클래스
    String 분;
    String 초;
    Map<String, String> 리스트;
    String Key; //키값
//    String 제목;

    public keySet(String 분, String 초, Map 데이터) {
        this.분 = 분;
        this.초 = 초;
        this.리스트 = 데이터;

    }

    public void searchValue() {
        for (Map.Entry<String, String> entry : 리스트.entrySet()) {
            if (entry.getValue().equals(분 + 초)) { // 받은해시맵과 일치하는 키를 찾아서 내보냄
                Key = entry.getKey();
                break;
            }
        }
    }
    public String result(){
        this.searchValue();
        return Key;
    }
}

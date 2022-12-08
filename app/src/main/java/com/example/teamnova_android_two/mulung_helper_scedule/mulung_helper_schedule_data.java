package com.example.teamnova_android_two.mulung_helper_scedule;

public class mulung_helper_schedule_data {
    String id;
    String 제목;
    String 메모;
    int 분;
    int 초;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String get제목() {
        return 제목;
    }

    public void set제목(String 제목) {
        this.제목 = 제목;
    }

    public String get메모() {
        return 메모;
    }

    public void set메모(String 메모) {
        this.메모 = 메모;
    }

    public int get분() {
        return 분;
    }

    public void set분(int 분) {
        this.분 = 분;
    }

    public int get초() {
        return 초;
    }

    public void set초(int 초) {
        this.초 = 초;
    }

    public mulung_helper_schedule_data( String 제목, String 메모, int 분, int 초) {

        this.제목 = 제목;
        this.메모 = 메모;
        this.분 = 분;
        this.초 = 초;
    }
}

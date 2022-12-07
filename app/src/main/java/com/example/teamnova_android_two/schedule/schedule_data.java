package com.example.teamnova_android_two.schedule;

public class schedule_data {
    String memo;
    int year;
    int month;
    int dayOfMonth;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
    public schedule_data (String memo, int year, int month, int dayOfMonth){
        this.memo = memo;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;

    }



}

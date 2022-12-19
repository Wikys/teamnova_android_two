package com.example.teamnova_android_two.회원가입;

import android.net.Uri;

import java.io.Serializable;

public class Account_Data implements Serializable {


    String id;
    String ps;
    String nick;
    String image;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPs() {
        return ps;
    }

    public void setPs(String ps) {
        this.ps = ps;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public Account_Data(String id, String ps, String nick, String image) {
        this.id = id;
        this.ps = ps;
        this.nick = nick;
        this.image = image;
    }
}

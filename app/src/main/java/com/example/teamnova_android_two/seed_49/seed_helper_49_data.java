package com.example.teamnova_android_two.seed_49;

public class seed_helper_49_data {
    String monsterName;
    String area;
    int image_path;
    boolean ischecked;

    public boolean getIschecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getImage_path() {
        return image_path;
    }

    public void setImage_path(int image_path) {
        this.image_path = image_path;
    }

    public seed_helper_49_data(String area, String monsterName, int image_path, boolean ischecked){
        this.area = area;
        this.monsterName = monsterName;
        this.image_path = image_path;
        this.ischecked = ischecked;
    }
}

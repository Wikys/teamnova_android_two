package com.example.teamnova_android_two.seed_24;

public class seed_helper_24_data {
    String title;
    String description;
    int image_path;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public int getImage_path(){
        return image_path;
    }
    public void setImage_path(int image_path){
        this.image_path = image_path;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public seed_helper_24_data(int image_path, String title, String description){
        this.image_path = image_path;
        this.title = title;
        this.description = description;
    }

}
//데이터모델 게터세터
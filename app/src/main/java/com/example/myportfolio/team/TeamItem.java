package com.example.myportfolio.team;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myportfolio.R;

public class TeamItem  {

    private String name,desc;
    private int img ;

    public TeamItem(String name, String desc, int img) {
        this.name = name;
        this.desc = desc;
        this.img = img;
    }

    public TeamItem() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}

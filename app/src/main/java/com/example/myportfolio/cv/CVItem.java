package com.example.myportfolio.cv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myportfolio.R;

public class CVItem {

    private String title;
    private String description;

    public CVItem(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public CVItem() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

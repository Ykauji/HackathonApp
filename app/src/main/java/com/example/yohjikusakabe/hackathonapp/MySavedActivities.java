package com.example.yohjikusakabe.hackathonapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;

public class MySavedActivities extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_saved_activities);
        ImageButton imageButton = findViewById(R.id.imageButton98);
        ImageButton imageButton2 = findViewById(R.id.imageButton101);

        Glide.with(this).load(R.drawable.placeholderposter).centerCrop().into(imageButton);
        Glide.with(this).load(R.drawable.placeholder2).centerCrop().into(imageButton);
    }

}

package com.example.ireribrian.myapi.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.ireribrian.myapi.R;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;

public class Home extends AppCompatActivity {

    String arrayName [] = {"Okay",
    "Yeah", "Brian", "Shawn", "Koko"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        CircleMenu circleMenu = (CircleMenu) findViewById(R.id.circle_menu);
        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.bv, R.drawable.cs)
                .addSubMenu(Color.parseColor("#258CFF"), R.drawable.icon)
                .addSubMenu(Color.parseColor("#6d4c41"), R.drawable.jk)
                .addSubMenu(Color.parseColor("#ff0000"), R.drawable.trom)
                .addSubMenu(Color.parseColor("#03a9f4"), R.drawable.weee)
                .addSubMenu(Color.parseColor("#1a237e"), R.drawable.donatelogin)
                .setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        Toast.makeText(Home.this, "You selected " + arrayName[index], Toast.LENGTH_SHORT).show();

                    }
                });
    }
}

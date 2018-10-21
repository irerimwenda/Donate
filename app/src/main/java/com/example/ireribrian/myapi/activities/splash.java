package com.example.ireribrian.myapi.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.ireribrian.myapi.R;

public class splash extends AppCompatActivity {

    VideoView videoView;
    Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                final Intent nextIntent = new Intent(splash.this, loginActivity.class);
                startActivity(nextIntent);

            }
        }, 3000);
    }
}

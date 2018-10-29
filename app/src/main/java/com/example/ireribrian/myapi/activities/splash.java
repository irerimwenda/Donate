package com.example.ireribrian.myapi.activities;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.example.ireribrian.myapi.R;
import com.felipecsl.gifimageview.library.GifImageView;

import java.io.IOException;

import static android.view.View.getDefaultSize;

public class splash extends AppCompatActivity /**implements SurfaceHolder.Callback, MediaPlayer.OnPreparedListener**/{

    Button loginBtn;
   // GifImageView gifImageView;
    private SurfaceView surfaceView;
    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    private static final String VIDEO_PATH = "android.resource://com.example.ireribrian.myapi/"+R.raw.videosplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

       // gifImageView = findViewById(R.id.mygif);
       // gifImageView.startAnimation();

        final VideoView videoView = (VideoView) findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videosplash));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setVolume(0f, 0f);
                mp.setLooping(true);
            }
        });
        videoView.requestFocus();
        videoView.start();

      /**  surfaceView = findViewById(R.id.surfaceView);
        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(splash.this);**/



        loginBtn = findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent loginIntent = new Intent(splash.this, loginActivity.class);
                startActivity(loginIntent);
            }
        });


    }
/**
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDisplay(surfaceHolder);
        try{
            mediaPlayer.setDataSource(VIDEO_PATH);
            mediaPlayer.prepare();
            mediaPlayer.setOnPreparedListener(splash.this);
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {

        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        releaseMediaPlayer();
    }

    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

    }

    @Override
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
    }**/
}

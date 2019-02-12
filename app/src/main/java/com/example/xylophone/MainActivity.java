package com.example.xylophone;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final int NUM_SIMULTANEOUS_SOUNDS = 7;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;
    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;

    private int mCSoundId;
    private int mDSoundId;
    private int mESoundId;
    private int mFSoundId;
    private int mGSoundId;
    private int mASoundId;
    private int mBSoundId;

    private SoundPool mSoundpool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            mSoundpool = new SoundPool.Builder()
                    .setMaxStreams(NUM_SIMULTANEOUS_SOUNDS).build();
        }
        else{
            mSoundpool = new SoundPool(NUM_SIMULTANEOUS_SOUNDS, AudioManager.STREAM_MUSIC,0);
        }

        mCSoundId = mSoundpool.load(getApplicationContext(),R.raw.note1_c,1);
        mDSoundId = mSoundpool.load(getApplicationContext(),R.raw.note2_d,1);
        mESoundId = mSoundpool.load(getApplicationContext(),R.raw.note3_e,1);
        mFSoundId = mSoundpool.load(getApplicationContext(),R.raw.note4_f,1);
        mGSoundId = mSoundpool.load(getApplicationContext(),R.raw.note5_g,1);
        mASoundId = mSoundpool.load(getApplicationContext(),R.raw.note6_a,1);
        mBSoundId = mSoundpool.load(getApplicationContext(),R.raw.note7_b,1);

        findViewById(R.id.cKey).setOnClickListener(this);
        findViewById(R.id.dKey).setOnClickListener(this);
        findViewById(R.id.eKey).setOnClickListener(this);
        findViewById(R.id.fKey).setOnClickListener(this);
        findViewById(R.id.gKey).setOnClickListener(this);
        findViewById(R.id.aKey).setOnClickListener(this);
        findViewById(R.id.bKey).setOnClickListener(this);

        if(Build.VERSION.SDK_INT >=21){
            findViewById(R.id.cKey).setElevation(8.0f);
            findViewById(R.id.dKey).setElevation(8.0f);
            findViewById(R.id.eKey).setElevation(8.0f);
            findViewById(R.id.fKey).setElevation(8.0f);
            findViewById(R.id.gKey).setElevation(8.0f);
            findViewById(R.id.aKey).setElevation(8.0f);
            findViewById(R.id.bKey).setElevation(8.0f);

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.cKey:
                mSoundpool.play(mCSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,NO_LOOP,NORMAL_PLAY_RATE);
                break;

            case R.id.dKey:
                mSoundpool.play(mDSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,NO_LOOP,NORMAL_PLAY_RATE);
                break;

            case R.id.eKey:
                mSoundpool.play(mESoundId,LEFT_VOLUME,RIGHT_VOLUME,0,NO_LOOP,NORMAL_PLAY_RATE);
                break;

            case R.id.fKey:
                mSoundpool.play(mFSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,NO_LOOP,NORMAL_PLAY_RATE);
                break;

            case R.id.gKey:
                mSoundpool.play(mGSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,NO_LOOP,NORMAL_PLAY_RATE);
                break;

            case R.id.aKey:
                mSoundpool.play(mASoundId,LEFT_VOLUME,RIGHT_VOLUME,0,NO_LOOP,NORMAL_PLAY_RATE);
                break;

            case R.id.bKey:
                mSoundpool.play(mBSoundId,LEFT_VOLUME,RIGHT_VOLUME,0,NO_LOOP,NORMAL_PLAY_RATE);
                break;
        }
    }
}

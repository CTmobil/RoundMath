package com.belnek.roundmath;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isNeedStopMusic = true;
    public static SoundPool soundPool;
    static int clickId, otvetverID, otvetneverID;
static boolean loaded;
    private AudioManager audioManager;

    // Maximumn sound stream.
    private static final int MAX_STREAMS = 5;

    // Stream type.
    private static final int streamType = AudioManager.STREAM_MUSIC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonless = (Button) findViewById(R.id.button_startless);
        Button buttontasks = (Button)findViewById(R.id.button_startTasks);

        buttonless.setOnClickListener(this);
        buttontasks.setOnClickListener(this);
        startService(new Intent(this, BGMusic.class));
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        AudioAttributes audioAttrib = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();

        SoundPool.Builder builder= new SoundPool.Builder();
        builder.setAudioAttributes(audioAttrib).setMaxStreams(MAX_STREAMS);

        this.soundPool = builder.build();
        this.soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                loaded = true;
            }
        });
        clickId = soundPool.load(this, R.raw.click,1);
        otvetneverID = soundPool.load(this, R.raw.neverniyonvet, 1);
        otvetverID = soundPool.load(this, R.raw.verniyonvet, 1);



    }
    @Override
    public void onPause() {
        super.onPause();
        if (isNeedStopMusic)
        stopService(new Intent(this, BGMusic.class));
    }
    @Override
    public void onResume()
    {
        super.onResume();
        isNeedStopMusic = true;
        startService(new Intent(this, BGMusic.class));
    }
    @Override
    public void onBackPressed() {
    }
    @Override
    public void onClick(View v) {
        playSoundClick();
        switch (v.getId()) {
            case R.id.button_startless:
                isNeedStopMusic = false;
                Intent intentless = new Intent(this, LessonCategoryActivity.class);
                startActivity(intentless);
                break;

            case R.id.button_startTasks:
                isNeedStopMusic = false;
                Intent intenttasks = new Intent(this, TasksCategoryActivity.class);
                startActivity(intenttasks);
                break;
        }
    }
    public static void playSoundClick( )  {
        if(loaded)  {
            float leftVolumn = 1f;
            float rightVolumn = 1f;
            // Play sound of gunfire. Returns the ID of the new stream.
            int streamId = soundPool.play(clickId, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public static void playSoundvern( )  {
        if(loaded)  {
            float leftVolumn = 1f;
            float rightVolumn = 1f;
            // Play sound of gunfire. Returns the ID of the new stream.
            int streamId = soundPool.play(otvetverID, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }
    public static void playSoundnevern( )  {
        if(loaded)  {
            float leftVolumn = 1f;
            float rightVolumn = 1f;
            // Play sound of gunfire. Returns the ID of the new stream.
            int streamId = soundPool.play(otvetneverID, leftVolumn, rightVolumn, 1, 0, 1f);
        }
    }

}
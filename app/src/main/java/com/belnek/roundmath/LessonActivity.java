package com.belnek.roundmath;

import androidx.annotation.AnyRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Timer;
import java.util.TimerTask;

public class LessonActivity extends AppCompatActivity implements View.OnClickListener {
    public TextView Title;
    public TextView TextLesson;
    private boolean isNeedStopMusic = true;
    public int TitleId;
    public int StrId;
    Button BtnNext;
    Button BtnBack;
    int IDLess;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        Bundle arguments = getIntent().getExtras();
        Title = (TextView) findViewById(R.id.TitleText);
        TextLesson = (TextView) findViewById(R.id.TextLesson);
        BtnNext = (Button) findViewById(R.id.buttonNext);
        BtnBack = (Button) findViewById(R.id.buttonback);
        IDLess = arguments.getInt("IDLess");
        Timer mTimer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask();
        TitleId = IDLess;
        image = (ImageView) findViewById(R.id.Image);
        mTimer.schedule(myTimerTask, 0, 100);
        switch (IDLess){
            case 1:
                Title.setText(R.string.LessonTitle1);
                TextLesson.setText(R.string.LessonText1str1);
                StrId = 1;
                break;
            case 2:
                Title.setText(R.string.LessonTitle2);
                TextLesson.setText(R.string.LessonText2str1);
                StrId = 1;

                break;
            case 3:
                Title.setText(R.string.LessonTitle3);
                TextLesson.setText(R.string.LessonText3str1);
                StrId = 1;
                break;
            case 4:
                Title.setText(R.string.LessonTitle4);
                TextLesson.setText(R.string.LessonText4str1);
                StrId = 1;
                break;
            case 5:
                Title.setText(R.string.LessonTitle5);
                TextLesson.setText(R.string.LessonText5str1);
                StrId = 1;
                break;
            case 6:
                Title.setText(R.string.LessonTitle6);
                TextLesson.setText(R.string.LessonText6str1);
                StrId = 1;
                break;
            case 7:
                Title.setText(R.string.LessonTitle7);
                TextLesson.setText(R.string.LessonText7str1);
                StrId = 1;
                break;
        }
        BtnNext.setOnClickListener(this);
        BtnBack.setOnClickListener(this);



    }
    @Override
    public void onPause() {
        super.onPause();
        if(isNeedStopMusic)
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
    public void onClick(View v) {
        MainActivity.playSoundClick();
        switch (v.getId())
        {
            case R.id.buttonNext:
                switch (StrId)
                {
                    case 5:
                        isNeedStopMusic = false;
                        Intent intentBack = new Intent(this, LessonCategoryActivity.class);
                        startActivity(intentBack);
                        break;
                    default:
                        StrId++;
                        break;
                }
                break;
            case R.id.buttonback:
                switch (StrId)
                {
                    case 1:
                        break;
                    default:
                        StrId--;
                        break;
                }
        }
        switch (TitleId)
        {
            case 1:
                switch(StrId)
                {
                    case 1:
                        TextLesson.setText(R.string.LessonText1str1);
                        image.setAlpha(0f);
                        break;
                    case 2:
                        TextLesson.setText(R.string.LessontText1str2);
                        image.setImageResource(R.drawable.t1s2);
                        image.setAlpha(1f);
                        break;
                    case 3:
                        TextLesson.setText(R.string.LessontText1str3);
                        image.setAlpha(0f);
                        break;
                    case 4:
                        TextLesson.setText(R.string.LessontText1str4);
                        image.setImageResource(R.drawable.t1s4);
                        image.setAlpha(1f);
                        break;
                    case 5:
                        TextLesson.setText(R.string.LessontText1str5);
                        image.setImageResource(R.drawable.t1s5);
                        image.setAlpha(1f);
                        break;


                }
                break;
            case 2:
                switch(StrId)
                {
                    case 1:
                        TextLesson.setText(R.string.LessonText2str1);
                        image.setAlpha(0f);
                        break;
                    case 2:
                        TextLesson.setText(R.string.LessontText2str2);
                        image.setImageResource(R.drawable.t2s2);
                        image.setAlpha(1f);
                        break;
                    case 3:
                        TextLesson.setText(R.string.LessontText2str3);
                        image.setImageResource(R.drawable.t2s3);
                        image.setAlpha(1f);
                        break;
                    case 4:
                        TextLesson.setText(R.string.LessontText2str4);
                        image.setImageResource(R.drawable.t2s4);
                        image.setAlpha(1f);break;
                    case 5:
                        TextLesson.setText(R.string.LessontText2str5);
                        image.setImageResource(R.drawable.t2s5);
                        image.setAlpha(1f);
                        break;


                }
                break;
            case 3:
                switch(StrId)
                {
                    case 1:
                        TextLesson.setText(R.string.LessonText3str1);
                        break;
                    case 2:
                        TextLesson.setText(R.string.LessontText3str2);
                        break;
                    case 3:
                        TextLesson.setText(R.string.LessontText3str3);
                        break;
                    case 4:
                        TextLesson.setText(R.string.LessontText3str4);
                        break;
                    case 5:
                        TextLesson.setText(R.string.LessontText3str5);
                        break;


                }
                break;
            case 4:
                switch(StrId)
                {
                    case 1:
                        TextLesson.setText(R.string.LessonText4str1);
                        break;
                    case 2:
                        TextLesson.setText(R.string.LessontText4str2);
                        break;
                    case 3:
                        TextLesson.setText(R.string.LessontText4str3);
                        break;
                    case 4:
                        TextLesson.setText(R.string.LessontText4str4);
                        break;
                    case 5:
                        TextLesson.setText(R.string.LessontText4str5);
                        break;


                }
                break;
            case 5:
                switch(StrId)
                {
                    case 1:
                        TextLesson.setText(R.string.LessonText5str1);
                        break;
                    case 2:
                        TextLesson.setText(R.string.LessontText5str2);
                        break;
                    case 3:
                        TextLesson.setText(R.string.LessontText5str3);
                        break;
                    case 4:
                        TextLesson.setText(R.string.LessontText5str4);
                        break;
                    case 5:
                        TextLesson.setText(R.string.LessontText5str5);
                        break;


                }
                break;
            case 6:
                switch(StrId)
                {
                    case 1:
                        TextLesson.setText(R.string.LessonText6str1);
                        break;
                    case 2:
                        TextLesson.setText(R.string.LessontText6str2);
                        break;
                    case 3:
                        TextLesson.setText(R.string.LessontText6str3);
                        break;
                    case 4:
                        TextLesson.setText(R.string.LessontText6str4);
                        break;
                    case 5:
                        TextLesson.setText(R.string.LessontText6str5);
                        break;


                }
                break;
            case 7:
                switch(StrId)
                {
                    case 1:
                        TextLesson.setText(R.string.LessonText7str1);
                        break;
                    case 2:
                        TextLesson.setText(R.string.LessontText7str2);
                        break;
                    case 3:
                        TextLesson.setText(R.string.LessontText7str3);
                        break;
                    case 4:
                        TextLesson.setText(R.string.LessontText7str4);
                        break;
                    case 5:
                        TextLesson.setText(R.string.LessontText7str5);
                        break;


                }
                break;
        }
    }
    class MyTimerTask extends TimerTask {

        @Override
        public void run() {
        if(StrId == 5)
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                BtnNext.setText("??????????????????");

                }
            });
        else
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    BtnNext.setText("C??????. ????????????????");

                }
            });

        }
    }
}
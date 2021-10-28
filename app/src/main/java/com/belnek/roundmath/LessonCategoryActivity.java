package com.belnek.roundmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LessonCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isNeedStopMusic = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessoncategory);
        Button lesson1 = (Button) findViewById(R.id.textLesson1);
        Button lesson2 = (Button)findViewById(R.id.textLesson2);
        Button lesson3 = (Button)findViewById(R.id.textLesson3);
        Button lesson4 = (Button)findViewById(R.id.textLesson4);
        Button lesson5 = (Button)findViewById(R.id.textLesson5);
        Button lesson6 = (Button)findViewById(R.id.textLesson6);
        Button lesson7 = (Button)findViewById(R.id.textLesson7);
        Button backtomenu = (Button)findViewById(R.id.backtominemenuLess);
        lesson1.setOnClickListener(this);
        lesson2.setOnClickListener(this);
        lesson3.setOnClickListener(this);
        lesson4.setOnClickListener(this);
        lesson5.setOnClickListener(this);
        lesson6.setOnClickListener(this);
        lesson7.setOnClickListener(this);
        backtomenu.setOnClickListener(this);
        lesson3.setClickable(false);
        lesson3.setVisibility(View.INVISIBLE);
        lesson4.setClickable(false);
        lesson4.setVisibility(View.INVISIBLE);
        lesson5.setClickable(false);
        lesson5.setVisibility(View.INVISIBLE);
        lesson6.setClickable(false);
        lesson6.setVisibility(View.INVISIBLE);
        lesson7.setClickable(false);
        lesson7.setVisibility(View.INVISIBLE);
    }
    @Override
    public void onBackPressed() {
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
        switch (v.getId()) {
            case R.id.textLesson1:
                Intent intentLess1 = new Intent(this, LessonActivity.class);
                intentLess1.putExtra("IDLess", 1);
                startActivity(intentLess1);
                break;
            case R.id.textLesson2:
                Intent intentLess2 = new Intent(this, LessonActivity.class);
                intentLess2.putExtra("IDLess", 2);
                startActivity(intentLess2);
                break;
            case R.id.textLesson3:
                Intent intentLess3 = new Intent(this, LessonActivity.class);
                intentLess3.putExtra("IDLess", 3);
                startActivity(intentLess3);
                break;
            case R.id.textLesson4:
                Intent intentLess4 = new Intent(this, LessonActivity.class);
                intentLess4.putExtra("IDLess", 4);
                startActivity(intentLess4);
                break;
            case R.id.textLesson5:
                Intent intentLess5 = new Intent(this, LessonActivity.class);
                intentLess5.putExtra("IDLess", 5);
                startActivity(intentLess5);
                break;
            case R.id.textLesson6:
                Intent intentLess6 = new Intent(this, LessonActivity.class);
                intentLess6.putExtra("IDLess", 6);
                startActivity(intentLess6);
                break;
            case R.id.textLesson7:
                Intent intentLess7 = new Intent(this, LessonActivity.class);
                intentLess7.putExtra("IDLess", 7);
                startActivity(intentLess7);
                break;
            case R.id.backtominemenuLess:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;

        }
    }
}
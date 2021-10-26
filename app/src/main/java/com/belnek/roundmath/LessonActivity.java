package com.belnek.roundmath;

import androidx.annotation.AnyRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);
        Bundle arguments = getIntent().getExtras();
        TextView Title = (TextView) findViewById(R.id.TitleText);
        TextView TextLesson = (TextView) findViewById(R.id.TextLesson);
        Button BtnNext = (Button) findViewById(R.id.buttonNext);
        Button BtnBack = (Button) findViewById(R.id.buttonback);
        int IDLess = arguments.getInt("IDLess");
        switch (IDLess){
            case 1:
                Title.setText(R.string.LessonTitle1);
                TextLesson.setText(R.string.LessonText1str1);
                break;
            case 2:
                Title.setText(R.string.LessonTitle2);
                TextLesson.setText(R.string.LessonText2str1);
                break;
            case 3:
                Title.setText(R.string.LessonTitle3);
                TextLesson.setText(R.string.LessonText3str1);
                break;
            case 4:
                Title.setText(R.string.LessonTitle4);
                TextLesson.setText(R.string.LessonText4str1);
                break;
            case 5:
                Title.setText(R.string.LessonTitle5);
                TextLesson.setText(R.string.LessonText5str1);
                break;
            case 6:
                Title.setText(R.string.LessonTitle6);
                TextLesson.setText(R.string.LessonText6str1);
                break;
            case 7:
                Title.setText(R.string.LessonTitle7);
                TextLesson.setText(R.string.LessonText7str1);
                break;
        }
    }
}
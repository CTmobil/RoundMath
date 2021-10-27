package com.belnek.roundmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TasksActivity extends AppCompatActivity implements View.OnClickListener {
    Integer rezult;
    String znakStr;
    String example;
    boolean IsTaskEnd = false;
    int Answer2, Answer3, Answer4;
    int ExampleCounter;
    public TextView TitleT;
    public TextView TextTask;
    public int TitleId;
    public int StrId;
    Button BtnAnswer1;
    Button BtnAnswer2;
    Button BtnAnswer3;
    Button BtnAnswer4;
    int IDTask;
    private Timer mTimer;
    private MyTimerTask2 mMyTimerTask;
    Intent intentBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);
        Bundle arguments = getIntent().getExtras();
        IDTask = arguments.getInt("IDTask");
        TextTask = (TextView) findViewById(R.id.TextTask);
        BtnAnswer1 = (Button) findViewById(R.id.buttonAnswer1);
        BtnAnswer2 = (Button) findViewById(R.id.buttonAnswer2);
        BtnAnswer3 = (Button) findViewById(R.id.buttonAnswer3);
        BtnAnswer4 = (Button) findViewById(R.id.buttonAnswer4);
        TitleId = IDTask;
        mTimer = new Timer();
        mMyTimerTask = new MyTimerTask2();
        intentBack =  new Intent(this, TasksCategoryActivity.class);
        ExampleCounter = 1;
        TitleT = (TextView) findViewById(R.id.TitleTextTasks);
        TitleT.setText(R.string.LessonTitle1);

        switch (IDTask){
            case 1:
                TitleT.setText(R.string.LessonTitle1);
                displayingExample(NumberGen(9, 1), NumberGen(9, 1), NumberGen(2, 1));
                Answer2 = NumberGen(15, 1);
                Answer3 = NumberGen(15, 1);
                Answer4 = NumberGen(15, 1);
                while(Answer2== rezult || Answer2 == Answer3 || Answer2 == Answer4 || Answer3 == rezult || Answer3 == Answer4 || Answer4 == rezult){
                    Answer2 = NumberGen(15, 1);
                    Answer3 = NumberGen(15, 1);
                    Answer4 = NumberGen(15, 1);
                }
                displayingAnswers(rezult, Answer2, Answer3, Answer4);
                break;
            case 2:
                TitleT.setText(R.string.LessonTitle2);
                break;
            case 3:
                TitleT.setText(R.string.LessonTitle3);
                break;
            case 4:
                TitleT.setText(R.string.LessonTitle4);
                break;
            case 5:
                TitleT.setText(R.string.LessonTitle5);
                break;
            case 6:
                TitleT.setText(R.string.LessonTitle6);
                break;
            case 7:
                TitleT.setText(R.string.LessonTitle7);
                break;
        }
        BtnAnswer1.setOnClickListener(this);
        BtnAnswer2.setOnClickListener(this);
        BtnAnswer3.setOnClickListener(this);
        BtnAnswer4.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
    Button ClickedBtn = findViewById(v.getId());
    if(ClickedBtn.getText() == rezult.toString()){
        ExamplePassed();
        ExampleCounter++;}


    }

    public int NumberGen(int max, int min)
    {
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        i += min;
        return i;
    }
    public float FloatNumberGen(int max, int min)
    {
        int diff = max - min;
        Random random = new Random();
        float i = random.nextFloat();
        float b = random.nextInt(diff+1);
        b += min;
        b += i;
        return b;
    }
    public void displayingExample(Integer num1, Integer num2, int znak)
    {
        switch(znak)
        {
            case 1:
                znakStr = "+";
                rezult = num1 + num2;
                example = num1.toString() + " " + znakStr + " " + num2.toString() + " = ";
                break;
            case 2:
                znakStr = "-";
                if(num1>num2) {
                    rezult = num1 - num2;
                    example = num1.toString() + " " + znakStr + " " + num2.toString() + " = ";
                }
                else {
                    rezult = num2 - num1;
                    example = num2.toString() + " " + znakStr + " " + num1.toString() + " = ";
                }
                break;
            case 3:
                znakStr = "*";
                rezult = num1 * num2;
                example = num1.toString() + " " + znakStr + " " + num2.toString() + " = ";
        }
        TextTask.setText(example);
    }
    public void displayingAnswers(Integer res, Integer Answerr2, Integer Answerr3, Integer Answerr4)
    {
        int pos_res = NumberGen(4, 1);
        switch (pos_res)
        {
            case 1:
                BtnAnswer1.setText(res.toString());
                BtnAnswer2.setText(Answerr2.toString());
                BtnAnswer3.setText(Answerr3.toString());
                BtnAnswer4.setText(Answerr4.toString());
                break;
            case 2:
                BtnAnswer2.setText(res.toString());
                BtnAnswer1.setText(Answerr2.toString());
                BtnAnswer3.setText(Answerr3.toString());
                BtnAnswer4.setText(Answerr4.toString());
                break;
            case 3:
                BtnAnswer3.setText(res.toString());
                BtnAnswer2.setText(Answerr2.toString());
                BtnAnswer1.setText(Answerr3.toString());
                BtnAnswer4.setText(Answerr4.toString());
                break;
            case 4:
                BtnAnswer4.setText(res.toString());
                BtnAnswer2.setText(Answerr2.toString());
                BtnAnswer3.setText(Answerr3.toString());
                BtnAnswer1.setText(Answerr4.toString());
                break;

        }
        mTimer.cancel();
        mTimer.purge();

    }
    public void ExamplePassed()
    {
        Toast.makeText(getApplicationContext(),
                "Верно!", Toast.LENGTH_SHORT).show();
        mTimer.schedule(mMyTimerTask, 5000);
        IsTaskEnd = false;

    }
    public void ExampleDeclined()
    {
        Toast.makeText(getApplicationContext(),
                "Неверно, подумай еще!", Toast.LENGTH_SHORT).show();
    }
    class MyTimerTask2 extends TimerTask {

        @Override
        public void run() {
            if(ExampleCounter > 10)
            {startActivity(intentBack);
            }
            switch (IDTask){
                case 1:
                    displayingExample(NumberGen(9, 1), NumberGen(9, 1), NumberGen(2, 1));
                    while(Answer2== rezult || Answer2 == Answer3 || Answer2 == Answer4 || Answer3 == rezult || Answer3 == Answer4 || Answer4 == rezult){
                        Answer2 = NumberGen(15, 1);
                        Answer3 = NumberGen(15, 1);
                        Answer4 = NumberGen(15, 1);
                    }
                    runOnUiThread(new Runnable() {

                        @Override
                        public void run() {

                            // Stuff that updates the UI
                            displayingAnswers(rezult, Answer2, Answer3, Answer4);

                        }
                    });

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
            }


        }
    }

    }






package com.belnek.roundmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TasksCategoryActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean isNeedStopMusic = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_category);
        Button lesson1 = (Button) findViewById(R.id.textTask1);
        Button lesson2 = (Button)findViewById(R.id.textTask2);
        Button lesson3 = (Button)findViewById(R.id.textTask3);
        Button lesson4 = (Button)findViewById(R.id.textTask4);
        Button lesson5 = (Button)findViewById(R.id.textTask5);
        Button lesson6 = (Button)findViewById(R.id.textTask6);
        Button lesson7 = (Button)findViewById(R.id.textTask7);
        Button backtomenu = (Button)findViewById(R.id.backtominemenuTasks);
        lesson1.setOnClickListener(this);
        lesson2.setOnClickListener(this);
        lesson3.setOnClickListener(this);
        lesson4.setOnClickListener(this);
        lesson5.setOnClickListener(this);
        lesson6.setOnClickListener(this);
        lesson7.setOnClickListener(this);
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
        backtomenu.setOnClickListener(this);

    }
    @Override
    public void onPause() {
        super.onPause();
        if(isNeedStopMusic) {
            stopService(new Intent(this, BGMusic.class));
        }
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
        MainActivity.playSoundClick();
        Intent intentTask = new Intent(this, TasksActivity.class);
        switch (v.getId()) {
            case R.id.textTask1:
                intentTask.putExtra("IDTask", 1);
                isNeedStopMusic = false;
                startActivity(intentTask);
                break;
            case R.id.textTask2:
                intentTask.putExtra("IDTask", 2);
                isNeedStopMusic = false;
                startActivity(intentTask);
                break;
            case R.id.textTask3:
                intentTask.putExtra("IDTask", 3);
                isNeedStopMusic = false;
                startActivity(intentTask);
                break;
            case R.id.textTask4:
                intentTask.putExtra("IDTask", 4);
                isNeedStopMusic = false;
                startActivity(intentTask);
                break;
            case R.id.textTask5:
                intentTask.putExtra("IDTask", 5);
                isNeedStopMusic = false;
                startActivity(intentTask);
                break;
            case R.id.textTask6:
                intentTask.putExtra("IDTask", 6);
                isNeedStopMusic = false;
                startActivity(intentTask);
                break;
            case R.id.textTask7:
                intentTask.putExtra("IDTask", 7);
                isNeedStopMusic = false;
                startActivity(intentTask);
                break;
            case R.id.backtominemenuTasks:
                Intent intentBack = new Intent(this, MainActivity.class);
                isNeedStopMusic = false;
                startActivity(intentBack);
                break;

        }
    }
}

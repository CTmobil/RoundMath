package com.belnek.roundmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TasksCategoryActivity extends AppCompatActivity implements View.OnClickListener {

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
        backtomenu.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.textTask1:
                Intent intentTask1 = new Intent(this, TasksActivity.class);
                intentTask1.putExtra("IDTask", 1);
                startActivity(intentTask1);
                break;
            case R.id.textTask2:
                Intent intentTask2 = new Intent(this, TasksActivity.class);
                intentTask2.putExtra("IDTask", 2);
                startActivity(intentTask2);
                break;
            case R.id.textTask3:
                Intent intentTask3 = new Intent(this, TasksActivity.class);
                intentTask3.putExtra("IDTask", 3);
                startActivity(intentTask3);
                break;
            case R.id.textTask4:
                Intent intentTask4 = new Intent(this, TasksActivity.class);
                intentTask4.putExtra("IDTask", 4);
                startActivity(intentTask4);
                break;
            case R.id.textTask5:
                Intent intentTask5 = new Intent(this, TasksActivity.class);
                intentTask5.putExtra("IDTask", 5);
                startActivity(intentTask5);
                break;
            case R.id.textTask6:
                Intent intentTask6 = new Intent(this, TasksActivity.class);
                intentTask6.putExtra("IDTask", 6);
                startActivity(intentTask6);
                break;
            case R.id.textTask7:
                Intent intentTask7 = new Intent(this, TasksActivity.class);
                intentTask7.putExtra("IDTask", 7);
                startActivity(intentTask7);
                break;
            case R.id.backtominemenuTasks:
                Intent intentBack = new Intent(this, MainActivity.class);
                startActivity(intentBack);
                break;

        }
    }
}

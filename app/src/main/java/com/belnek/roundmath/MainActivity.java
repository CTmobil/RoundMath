package com.belnek.roundmath;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonless = (Button) findViewById(R.id.button_startless);
        Button buttontasks = (Button)findViewById(R.id.button_startTasks);

        buttonless.setOnClickListener(this);
        buttontasks.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_startless:
                break;

        }
    }
}
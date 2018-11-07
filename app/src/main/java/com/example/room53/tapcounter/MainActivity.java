package com.example.room53.tapcounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_COUNTER = "SC";
    private int counter = 0;
    private int max = 10;
    private TextView counterTV;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTV = findViewById(R.id.tv_counter);
        counterTV.setText(String.valueOf(counter));
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt(STATE_COUNTER);
            updateCounterValue(counter);
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(STATE_COUNTER, counter);
        super.onSaveInstanceState(savedInstanceState);
    }

    public void increaseNumber(View view) {
        counter++;
        updateCounterValue(counter);

        if(counter > max)
            openSecondActivity();

    }

    private void updateCounterValue(int value) {
        counterTV.setText(String.valueOf(value));
    }

    public void openSecondActivity() {
        SecondActivity.start(this, counter);
    }

    //calling by button
    public void openSecondActivity(View view) {
        SecondActivity.start(this, counter);
    }
}

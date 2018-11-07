package com.example.room53.tapcounter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String KEY_TEXT = "KEY_TEXT";

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textView = findViewById(R.id.tv);
        int counterFromIntent = getIntent().getIntExtra(KEY_TEXT, 0);
        textView.setText(String.format("Counter is: %s",counterFromIntent));
    }

    public static void start( Context context, int counter) {
        Intent intent = new Intent(context, SecondActivity.class);
        intent.putExtra(KEY_TEXT, counter);
        context.startActivity(intent);
    }


}

package com.example.lifecyclecallbacktwoactivities;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            SecondActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        String message =
                intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView =
                (TextView)findViewById(R.id.text_message);
        textView.setText(message);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(LOG_TAG, "onResume");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }
}

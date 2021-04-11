package com.example.loginsharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class DaftarPeruqyahActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftarperuqyah);
    }

    public void click_peruqyah1(View view) {
        Intent intent = new Intent(this, Peruqyah1Activity.class);
        startActivity(intent);
    }

    public void click_peruqyah2(View view) {
        Intent intent = new Intent(this, Peruqyah2Activity.class);
        startActivity(intent);
    }
}

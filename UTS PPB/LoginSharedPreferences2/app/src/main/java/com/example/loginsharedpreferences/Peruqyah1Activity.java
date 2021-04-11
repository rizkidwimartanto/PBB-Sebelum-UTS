package com.example.loginsharedpreferences;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Peruqyah1Activity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peruqyah1);
    }

    public void click_lokasi(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String data = getString(R.string.lokasi_yaman);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }

    public void click_hubungi(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }
}
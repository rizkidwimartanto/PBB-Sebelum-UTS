package com.example.loginsharedpreferences;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Dialog myDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDialog = new Dialog(this);

        /* Deklarasi dan Menginisialisasi variable nama dengan Label Nama dari Layout MainActivity */

        /* Men-set Status dan User yang sedang login menjadi default atau kosong di
         * Data Preferences. Kemudian menuju ke LoginActivity*/
        findViewById(R.id.button_logoutMain).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menghapus Status login dan kembali ke Login Activity
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),LoginActivity.class));
                finish();
            }
        });


    }

    public void click_ruqyah(View view) {
        AlertDialog.Builder psn= new AlertDialog.Builder(this);
        psn.setMessage(R.string.text_ruqyah);
        psn.setNeutralButton("Kembali",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Oke",
                        Toast.LENGTH_SHORT).show();
            }
        });
        psn.show();
    }

    public void click_bekam(View view) {
        AlertDialog.Builder psn= new AlertDialog.Builder(this);
        psn.setMessage(R.string.text_bekam);
        psn.setNeutralButton("Kembali",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Oke",
                        Toast.LENGTH_SHORT).show();
            }
        });
        psn.show();
    }

    public void click_totok(View view) {
        AlertDialog.Builder psn= new AlertDialog.Builder(this);
        psn.setMessage(R.string.text_totok);
        psn.setNeutralButton("Kembali",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Oke",
                        Toast.LENGTH_SHORT).show();
            }
        });
        psn.show();
    }

    public void click_maps(View view) {
        Intent intent = new Intent(this, DaftarPeruqyahActivity.class);
        startActivity(intent);
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        String data = getString(R.string.lokasi);
//        intent.setData(Uri.parse(data));
//        if (intent.resolveActivity(getPackageManager())!= null){
//            startActivity(intent);
//        }
    }

    public void click_website(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String data = getString(R.string.website);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }

    public void click_update(View view) {
        Intent intent = new Intent(this, UpdateUserActivity.class);
        startActivity(intent);
    }

    public void click_order(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        startActivity(intent);
    }


    public void click_telepon(View view) {
        AlertDialog.Builder psn= new AlertDialog.Builder(this);
        psn.setMessage(R.string.call_centre);
        psn.setNeutralButton("Kembali",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Oke",
                        Toast.LENGTH_SHORT).show();
            }
        });
        psn.show();
    }

    public void click_sms(View view) {
        AlertDialog.Builder psn= new AlertDialog.Builder(this);
        psn.setMessage(R.string.email);
        psn.setNeutralButton("Kembali",new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"Oke",
                        Toast.LENGTH_SHORT).show();
            }
        });
        psn.show();
    }

    public void click_video(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        String data = getString(R.string.video);
        intent.setData(Uri.parse(data));
        if (intent.resolveActivity(getPackageManager())!= null){
            startActivity(intent);
        }
    }
}

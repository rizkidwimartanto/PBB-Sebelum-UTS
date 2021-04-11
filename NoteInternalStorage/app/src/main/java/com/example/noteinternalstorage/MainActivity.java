package com.example.noteinternalstorage;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    TextView txt;
    private SharedPreferences mPreferences;
    private static final String mSharedPrefFile =
            "com.a71b.belajarsharedprefs";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=(EditText) findViewById(R.id.inp_text);
    }
    public void savesd(View view) {
        Toast.makeText(MainActivity.this, "Catatan Berhasil Tersimpan Di SD",
                Toast.LENGTH_SHORT).show();
    }
    public void simpan(View view) {
        mPreferences=getSharedPreferences(mSharedPrefFile,
                Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor=mPreferences.edit();
        editor.putString("Text",txt.getText().toString());
        editor.commit();
        pesan();
    }
    public void Baca(View view) {
        mPreferences=getSharedPreferences(mSharedPrefFile,
                Activity.MODE_PRIVATE);
        txt.setText(mPreferences.getString("Text",null));
    }
    private void pesan() {
        AlertDialog.Builder psn = new
                AlertDialog.Builder(this);
        psn.setTitle("Konfirmasi");
        psn.setMessage("Data Tersimpan");
        psn.setIcon(R.drawable.ic_launcher_background);
        psn.setNeutralButton("OK", new

                DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface
                                                dialogInterface, int i) {

                        Toast.makeText(getApplicationContext(), "Sukses simpan",
                                Toast.LENGTH_SHORT).show();
                    }
                });
        psn.show();
    }
}

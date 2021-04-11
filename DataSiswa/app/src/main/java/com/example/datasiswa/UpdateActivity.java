package com.example.datasiswa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class UpdateActivity extends AppCompatActivity {
    private String xnis,xnama;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        final DatabaseHandler db = new DatabaseHandler(this);
        final EditText editNis = (EditText)findViewById(R.id.editNis);
        final EditText editNama = (EditText) findViewById(R.id.editNama);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);
        Button btnBatal = (Button) findViewById(R.id.btnBatal);
        Bundle bun = this.getIntent().getExtras();
        xnis = bun.getString("nis");
        xnama = bun.getString("nama");
        editNama.setText(xnama);
        editNis.setText(xnis);
        btnUpdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String nis = editNis.getText().toString();
                String nama = editNama.getText().toString();
                db.updateMethod(nis,nama);
                editNis.setText("");
                editNama.setText("");
                try{
                    Class c= Class.forName("com.example.datasiswa.MainActivity");
                    Intent i = new Intent(UpdateActivity.this,
                            c);
                    startActivity(i);
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btnBatal.setOnClickListener(new View.OnClickListener()
        {public void onClick(View v) {
            try {
                Class c =
                        Class.forName("com.example.datasiswa.MainActivity");
                Intent i=new Intent(UpdateActivity.this,c);
                startActivity(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        });
    }
}

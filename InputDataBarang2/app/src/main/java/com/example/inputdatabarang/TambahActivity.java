package com.example.inputdatabarang;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class TambahActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        final DatabaseHandler db = new DatabaseHandler(this);
        final EditText editKd = (EditText) findViewById(R.id.editKodeBarang);
        final EditText editNama = (EditText)findViewById(R.id.editNamaBarang);
        final EditText editHrgb = (EditText)findViewById(R.id.editHargaBeli);
        final EditText editHrgj = (EditText)findViewById(R.id.editHargaJual);
        final EditText editStok = (EditText)findViewById(R.id.editStok);
        Button btnTambah = (Button) findViewById(R.id.btnTambah);
        Button btnBatal = (Button) findViewById(R.id.btnBatal);
        btnTambah.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String kd = editKd.getText().toString();
                String nama = editNama.getText().toString();
                String hrgb = editHrgb.getText().toString();
                String hrgj = editHrgj.getText().toString();String stok = editStok.getText().toString();
                db.addBarang(new Barang(kd, nama, hrgb, hrgj, stok));
                editKd.setText("");
                editNama.setText("");
                editHrgb.setText("");
                editHrgj.setText("");
                editStok.setText("");
                try{
                    Class c = Class.forName("com.example.inputdatabarang.MainActivity");
                    Intent i = new Intent(TambahActivity.this, c);
                    startActivity(i);
                } catch(ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        btnBatal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
// TODO Auto-generated method stub
                try {
                    Class c = Class.forName("com.example.inputdatabarang.MainActivity");
                    Intent i=new Intent(TambahActivity.this,c);
                    startActivity(i);
                } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }
}

package com.example.inputdatabarang;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import java.util.List;
public class MainActivity extends ListActivity {
    String dataBarang[] = null;
    String dB[] = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//setContentView(R.layout.activity_main);
// Tambah Siswa
        DatabaseHandler db = new DatabaseHandler(this);
// Membaca Semua Siswa
        Log.d("Baca Barang: ", "Membaca Semua Data Barang..");
        List<Barang> barang = db.getSemuaBarang();
        dataBarang= new String[barang.size()];
        dB= new String[barang.size()];
        int i=0;
        for(Barang s : barang) {
            String log = "Kode Barang: "+ s.getKd() + ",Nama Barang: "+ s.getNama()+
                    ",Harga Beli Barang: "+ s.getHrgb()+ ",Harga Jual Barang: "+ s.getHrgj()+ ",Stok: "+
                    s.getStok();
            Log.d("Name: ", log);
            dataBarang[i] = s.getKd() + " | "+ s.getNama() + " | "+ "Rp."+s.getHrgb()
                    + " | "+ "Rp."+s.getHrgj() + " | "+ s.getStok()+"pcs";
            dB[i] = s.getKd();
            i++;
        }
//cek data
        if(i==0)
        {
            Log.d("Tambah Barang: ", "Menambah Data Barang..");
            db.addBarang(new Barang("B001", "BUKU", "5000", "6000", "100"));
            db.addBarang(new Barang("B002", "Spidol", "3500", "4000", "50"));
            db.addBarang(new Barang("B003", "Pulpen", "2500", "3000", "60"));
            db.addBarang(new Barang("B004", "Pensil", "2000", "2500", "70"));
            db.addBarang(new Barang("B004", "Penghapus", "1500", "2000", "40"));
            db.addBarang(new Barang("B004", "Penggaris", "4000", "5000", "300"));
        }
        setListAdapter(new ArrayAdapter<Object>(this,android.R.layout.simple_list_item_1, dataBarang));
        registerForContextMenu(getListView());
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
// TODOAuto-generated method stub
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Action");
        menu.add(0,0,0,"Tambah");
        menu.add(0,1,1,"Hapus");
        menu.add(0,2,2,"Update");
    }//
    @Override
    public boolean onContextItemSelected(MenuItem item) {
// TODOAuto-generated method stub
        try{
            switch(item.getItemId()){
                case 0:{
                    Class c =
                            Class.forName("com.example.inputdatabarang.TambahActivity");
                    Intent i = new Intent(MainActivity.this, c);
                    startActivity(i); break;
                }
                case 1:{
                    DatabaseHandler db = new DatabaseHandler(this);
                    AdapterView.AdapterContextMenuInfo info =
                            (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    String[] args = {String.valueOf(info.id) };
                    int xpos=Integer.parseInt(args[0]);
                    db.deleteRow(dB[xpos]);
                    Class c = Class.forName("com.example.inputdatabarang.MainActivity");
                    Intent i = new Intent(MainActivity.this, c);
                    startActivity(i);

                    break;
                }
                case 2:{
                    DatabaseHandler db = new DatabaseHandler(this);
                    AdapterView.AdapterContextMenuInfo info
                            =(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
                    String[] args ={String.valueOf(info.id)
                    };

                    Log.d("args0 : ",args[0]);
                    int xpos=Integer.parseInt(args[0]);
                    db.getBarang(dB[xpos]);
                    String namax=db.getBarang(dB[xpos]).getNama();
                    String hrgbx=db.getBarang(dB[xpos]).getHrgb();
                    String hrgjx=db.getBarang(dB[xpos]).getHrgj();
                    String stokx=db.getBarang(dB[xpos]).getStok();
                    Intent i = new Intent(this, UpdateActivity.class);
                    Bundle bun = new Bundle();
                    bun.putString("KdBrg", dB[xpos]);
                    bun.putString("NmBrg", namax);
                    bun.putString("HrgBeli", hrgbx);
                    bun.putString("HrgJual", hrgjx);
                    bun.putString("Stok", stokx);
                    i.putExtras(bun);
                    startActivity(i); break;

                }
            }
        } catch(ClassNotFoundException e) {
// TODOAuto-generated catch block
            e.printStackTrace();
        }
        return true;
    }
}
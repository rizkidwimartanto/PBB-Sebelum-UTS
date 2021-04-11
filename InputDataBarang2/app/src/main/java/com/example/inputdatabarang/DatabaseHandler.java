package com.example.inputdatabarang;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

import java.util.List;
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION= 1;
    // NamaDatabase
    private static final String DATABASE_NAME= "Gudang";
    // NamaTable
    private static final String TABLE_BARANG= "Barang";
    // NamaKolomTable Siswa
    private static final String KEY_KD = "KdBrg";
    private static final String KEY_NAMA = "NmBrg";
    private static final String KEY_HRGB = "HrgBeli";
    private static final String KEY_HRGJ = "HrgJual";
    private static final String KEY_STOK = "Stok";
    public DatabaseHandler(Context context) {
// TODOAuto-generated constructor stub
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
// TODOAuto-generated method stub
        String query_table_barang = "CREATE TABLE "+ TABLE_BARANG+ "("
                + KEY_KD+ " TEXT PRIMARY KEY,"+ KEY_NAMA+ " TEXT,"+ KEY_HRGB+ " TEXT,"+KEY_HRGJ+ " TEXT,"+KEY_STOK+ " TEXT)";
        db.execSQL(query_table_barang);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODOAuto-generated method stub
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_BARANG);
// Create tables again
        onCreate(db);
    }
    // MenambahSiswaBaru
    public void addBarang(Barang barang) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KD, barang.getKd());
        values.put(KEY_NAMA, barang.getNama());
        values.put(KEY_HRGB, barang.getHrgb());
        values.put(KEY_HRGJ, barang.getHrgj());
        values.put(KEY_STOK, barang.getStok());
// Inserting Row
        db.insert(TABLE_BARANG, null, values);
        db.close(); //
    }
    // MembacaSiswa
    public Barang getBarang(String kd) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_BARANG, new String[] {
                KEY_KD, KEY_NAMA, KEY_HRGB, KEY_HRGJ, KEY_STOK}, KEY_KD+ "=?", new
                String[] {kd}, null, null, null, null);
        if(cursor != null) cursor.moveToFirst();
        Barang barang = new Barang(cursor.getString(0), cursor.getString(1),
                cursor.getString(2),cursor.getString(3), cursor.getString(4));
        return barang;
    }
    // MembacaSemuaSiswa
    public List<Barang> getSemuaBarang() {
        List<Barang> barangList = new ArrayList<Barang>();
        String query_select_barang = "SELECT * FROM "+ TABLE_BARANG;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query_select_barang, null);
        if(cursor.moveToFirst()) {
            do{
                Barang barang = new Barang(cursor.getString(0), cursor.getString(1),
                        cursor.getString(2), cursor.getString(3), cursor.getString(4));
                barangList.add(barang);
            } while(cursor.moveToNext());
        }
        return barangList;
    }
    public void deleteRow(String xkd) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BARANG, KEY_KD+ "='"+ xkd+"'",null);
        db.close();
        System.out.println("Data terhapus "+xkd);
    }
    public void updateMethod(String kd, String nama, String hrgb, String hrgj, String
            stok ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KD, kd);
        values.put(KEY_NAMA, nama);
        values.put(KEY_HRGB, hrgb);
        values.put(KEY_HRGJ, hrgj);
        values.put(KEY_STOK, stok);
// updating row
        db.update(TABLE_BARANG, values,KEY_KD +" = ?", new String[] {kd});
        db.update(TABLE_BARANG, values,KEY_NAMA +" = ?", new String[] {nama});
        db.update(TABLE_BARANG, values,KEY_HRGB +" = ?", new String[] {hrgb});
        db.update(TABLE_BARANG, values,KEY_HRGJ +" = ?", new String[] {hrgj});
        db.update(TABLE_BARANG, values,KEY_STOK +" = ?", new String[] {stok});
        db.close();
        System.out.println("Data TerUpdate"+kd);
    }
}

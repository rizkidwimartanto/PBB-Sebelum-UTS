package com.example.inputdatabarang;

public class Barang {
    private String kd;
    private String nama;
    private String hrgb;
    private String hrgj;
    private String stok;
    public Barang(String kd, String nama, String hrgb, String hrgj, String stok) {
        this.kd= kd;
        this.nama= nama;
        this.hrgb= hrgb;
        this.hrgj= hrgj;
        this.stok= stok;
    }
    public String getKd() {
        return kd;
    }
    public void setKd(String kd) {
        this.kd= kd;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama= nama;
    }
    public String getHrgb() {
        return hrgb;
    }
    public void setHrgb(String hrgb) {
        this.hrgb= hrgb;
    }
    public String getHrgj() {
        return hrgj;
    }
    public void setHrgj(String Hrgj) {
        this.hrgj= hrgj;
    }
    public String getStok() {
        return stok;
    }
    public void setStok(String stok) {
        this.stok= stok;
    }
}

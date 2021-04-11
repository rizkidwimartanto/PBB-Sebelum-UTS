package com.example.loginsharedpreferences;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class OrderActivity extends AppCompatActivity {

    private EditText mNama, mAlamat, mNoHp, mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        /* Menginisialisasi variable dengan Form User, Form Password, dan Form Repassword
        dari Layout RegisterActivity */
        mNama =findViewById(R.id.et_nama);
        mAlamat =findViewById(R.id.et_alamat);
        mNoHp =findViewById(R.id.et_noHp);
        mEmail =findViewById(R.id.et_email);

        /* Menjalankan Method razia() jika merasakan tombol SignUp di keyboard disentuh */
//        mNama.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
//                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
//                    razia();
//                    return true;
//                }
//                return false;
//            }
//        });
        /* Menjalankan Method razia() jika merasakan tombol SignUp disentuh */
        findViewById(R.id.button_order).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                razia();
            }
        });

        findViewById(R.id.button_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });
    }

    /** Men-check inputan User dan Password dan Memberikan akses ke MainActivity */
    private void razia(){
        /* Mereset semua Error dan fokus menjadi default */
        mNama.setError(null);
        mAlamat.setError(null);
        mNoHp.setError(null);
        mEmail.setError(null);
        View fokus = null;
        boolean cancel = false;

        /* Mengambil text dari Form User, Password, Repassword dengan variable baru bertipe String*/
        String nama = mNama.getText().toString();
        String alamat = mAlamat.getText().toString();
        String nohp = mNoHp.getText().toString();
        String email = mEmail.getText().toString();

        /* Jika form user kosong atau MEMENUHI kriteria di Method cekUser() maka, Set error di Form-
         * User dengan menset variable fokus dan error di Viewnya juga cancel menjadi true*/
        if (TextUtils.isEmpty(nama)){
            mNama.setError("This field is required");
            fokus = mNama;
            cancel = true;
        }

        /* Jika form password kosong dan MEMENUHI kriteria di Method cekPassword maka,
         * Reaksinya sama dengan percabangan User di atas. Bedanya untuk Password dan Repassword*/
        if (TextUtils.isEmpty(alamat)){
            mAlamat.setError("This field is required");
            fokus = mAlamat;
            cancel = true;
        }

        if (TextUtils.isEmpty(nohp)){
            mNoHp.setError("This field is required");
            fokus = mNoHp;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)){
            mEmail.setError("This field is required");
            fokus = mEmail;
            cancel = true;
        }

        /** Jika cancel true, variable fokus mendapatkan fokus. Jika false, maka
         *  Kembali ke LoginActivity dan Set User dan Password untuk data yang terdaftar */
        if (cancel){
            fokus.requestFocus();
        }else{
            Preferences.setRegisteredUser(getBaseContext(),nama);
            Preferences.setRegisteredPass(getBaseContext(),alamat);
            Preferences.setRegisteredPass(getBaseContext(),nohp);
            Preferences.setRegisteredPass(getBaseContext(),email);
            finish();
            Toast.makeText(getApplicationContext(),"Terimakasih",
                    Toast.LENGTH_SHORT).show();
        }
    }

    /** True jika parameter password sama dengan parameter repassword */
    private boolean cekPassword(String password, String repassword){
        return password.equals(repassword);
    }

    /** True jika parameter user sama dengan data user yang terdaftar dari Preferences */
    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }

    public void reset(){
        mNama.setText("");
        mNoHp.setText("");
        mAlamat.setText("");
        mEmail.setText("");
    }
}


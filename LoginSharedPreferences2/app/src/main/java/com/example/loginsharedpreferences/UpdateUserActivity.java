package com.example.loginsharedpreferences;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class UpdateUserActivity extends AppCompatActivity {

    private EditText mViewUser, mViewPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);

        /* Menginisialisasi variable dengan Form User, Form Password, dan Form Repassword
        dari Layout RegisterActivity */
        mViewUser =findViewById(R.id.et_emailUpdate);
        mViewPassword =findViewById(R.id.et_passwordUpdate);
        /* Menjalankan Method razia() jika merasakan tombol SignUp di keyboard disentuh */
        mViewPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE ||
                        actionId == EditorInfo.IME_NULL) {
                    razia();
                    return true;
                }
                return false;
            }
        });
        /* Menjalankan Method razia() jika merasakan tombol SignUp disentuh */
        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
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
        mViewUser.setError(null);
        mViewPassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        /* Mengambil text dari Form User, Password, Repassword dengan variable baru bertipe String*/
        String newuser = mViewUser.getText().toString();
        String newpassword = mViewPassword.getText().toString();

        /* Jika form user kosong atau MEMENUHI kriteria di Method cekUser() maka, Set error di Form-
         * User dengan menset variable fokus dan error di Viewnya juga cancel menjadi true*/
        if (TextUtils.isEmpty(newuser)){
            mViewUser.setError("This field is required");
            fokus = mViewUser;
            cancel = true;
        }

        /* Jika form password kosong dan MEMENUHI kriteria di Method cekPassword maka,
         * Reaksinya sama dengan percabangan User di atas. Bedanya untuk Password dan Repassword*/
        if (TextUtils.isEmpty(newpassword)){
            mViewPassword.setError("This field is required");
            fokus = mViewPassword;
            cancel = true;
        }

        /** Jika cancel true, variable fokus mendapatkan fokus. Jika false, maka
         *  Kembali ke LoginActivity dan Set User dan Password untuk data yang terdaftar */
        if (cancel){
            fokus.requestFocus();
        }else{
            Preferences.setUpdateUser(getBaseContext(), newuser);
            Preferences.setUpdatePass(getBaseContext(), newpassword);
            masuk();
        }
    }

    private void masuk(){
        Preferences.setUpdatedUsername(getBaseContext(),Preferences.getUpdateUser(getBaseContext()));
        startActivity(new Intent(getBaseContext(),MainActivity.class));
        finish();
    }

    public void reset(){
        mViewUser.setText("");
        mViewPassword.setText("");
    }
}

package com.example.sampleconstraintlayout;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityKedua extends AppCompatActivity {
    //deklarasi variabel dengan tipe data textview
    TextView txEmail,txPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kedua);
        //Menghubungkan variabel textEmail dengan componen TextView pada layout
        txEmail=findViewById(R.id.tvEmail);
        //Menghubungkan variabel textPassword dengan componen TextView pada layout
        txPassword=findViewById(R.id.tvPassword);

        //membuat objek bundle dan mengambil datayang dikirimkan dari activity
        Bundle bundle = getIntent().getExtras();
        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci"a"
        String email = bundle.getString("a");
        //Membuat variabel string yang digunakan untuk menyimpan data yang dikirimkan dari activity sebelumnya dengan kunci"b"
        String pass = bundle.getString("b");

        //Menampilkan value dari variabel email kedalam txEmail
        txEmail.setText(email);
        //Menampilkan value dari variabel pass kedalam txPassword
        txPassword.setText(pass);
    }
}

package com.example.sampleconstraintlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk
    Button btnLogin;
    //Deklarasi variabel untuk
    EditText edemail, edpassword;
    //Deklarasi variabel untuk
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel btnlogin dengan componen button pada layout
        btnLogin=findViewById(R.id.btSignIn);
        //Menghubungkan variabel edemail dengan componen button pada layout
        edemail=findViewById(R.id.edEmail);
        //Menghubungkan variabel password dengan componen button pada layout
        edpassword=findViewById(R.id.edPassword);

        //Membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Menyimpan input user di edittext email kedalam variabel nama
                nama = edemail.getText().toString();
                //Menyimpan input user di edittext password  kedalam variabel password
                password = edpassword.getText().toString();

                //set email yang benar
                String email = "erda@mail.com";

                //set password yang benar
                String pass = "erda123";

                //Mengecek apakah edittext email dan password terdapat isi atau tidak
                if(nama.isEmpty() || password.isEmpty()) {
                    //Membuat variabel toast dan menampilkan pesan "edittext tidak boleh kosong"
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Email dan Password tidak boleh kosong!!",
                            Toast.LENGTH_LONG);
                    //menampilkan toast
                    t.show();
                } else {
                    //mengecek apakah isi dari email dan password sudah sama dengan email dan
                    //password yang sudah diset
                    if (nama.equals(email) && password.equals(pass)) {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Sukses",
                                Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                        //Mmebuat objeck bundle
                        Bundle b = new Bundle();
                        //Memasukkan value dari variabel nama dengan kunci "a"
                        //dan dimasukkan kedalam bundle
                        b.putString("a", nama.trim());
                        //Memasukkan value dari variabel nama dengan kunci "b"
                        //dan dimasukkan kedalam bundle
                        b.putString("b", password.trim());
                        //membuat objek intent berpindah activity dari mainactivity ke Activityhasil
                        Intent i = new Intent(getApplicationContext(), Home_Activity.class);
                        //Memasukkan bundle kedalam intent untuk dikirimkan ke ACtivityHasil
                        i.putExtras(b);
                        //berpindah ke Home_Activity
                        startActivity(i);
                    }else{
                        //Membuat toast dan menampilkan pesan "Login Gagal"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        //Menampilkan toast
                        t.show();

                    }
                }

                //Membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                Toast t = Toast.makeText(getApplicationContext(),
                        "email anda: "+nama+"dan password anda"+password+"", Toast.LENGTH_LONG);
                //menampilkan toast
                t.show();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Method untuk menampilkan menu.
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Membuat kondisi jika dipilih adalah id mnDaftar
        if (item.getItemId() == R.id.mnDaftar)
        {
            //Method untuk memanggil activity "Daftar Activity"
            Intent i = new Intent(getApplicationContext(),DaftarActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}

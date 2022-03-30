package com.example.sampleconstraintlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Home_Activity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    //Deklarasi variabel dengan jenis data listview
    private ListView list;
    //memanggil class listviewadapter dari diinisiasi menjeadi variabel adapter
    private ListViewAdapter adapter;
    //Deklarasi array untuk menyimpan nama
    String[] listNama;
    //Memanggil class CmassNama
    public static ArrayList<ClassNama> classNamaArrayList =new ArrayList<ClassNama>();
    //Membuat objek bundle
    Bundle bundle = new Bundle();
    //Membuat object intent
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    //Menyimpan nama didalam array ListNama
        listNama = new String[]{"Erda","Wyne","Astuti","Utami","Ervita","Kusuma"};

        list = findViewById(R.id.listKontak);
        //Membuat objek dari classNama menjadi arrayList
        classNamaArrayList = new ArrayList<>();
        //Membaca seluruh data pada array ListNama
        for (int i=9; i< listNama.length;i++)
        {
            ClassNama classNama = new ClassNama(listNama[i]);
            classNamaArrayList.add(classNama);

        }
        //Membuat objek dari ListViewAdapter
        adapter = new ListViewAdapter( this);
        //Binds Adapter ke ListView
        list.setAdapter(adapter);
        //Membuat event dari List onclick
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String nama = classNamaArrayList.get(position).getName();
                //memasukkan Value dari variable nama dengan kunci "a" dan dimasukkan kedalam bundle
                bundle.putString("a",nama.trim());
                //Membuat event untuk popup menu ketika dipilih
                PopupMenu pm = new PopupMenu(getApplicationContext(),view);
                //Membuat event untuk popup menu ketika dipilih
                pm.setOnMenuItemClickListener(Home_Activity.this);
                //Menampilkan popup menu dari layout menu
                pm.inflate(R.menu.popup_menu);
                //Menampilkan popup menu
                pm.show();
            }
        });

    }
    //Event yang terjadi ketika menu dipilih
    @Override
    public boolean onMenuItemClick(MenuItem menuItem){
        switch (menuItem.getItemId()) {
            case R.id.mnview:
                intent = new Intent(getApplicationContext(), ActivityLihatData.class);
                intent.putExtras(bundle);
                startActivity(intent);
                break;
            case R.id.mnedit:
                Toast.makeText(getApplicationContext(), "Ini untuk edit kontak",
                        Toast.LENGTH_LONG).show();
                break;
        }
        return  false;
    }

}

package com.example.sampleconstraintlayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ListViewAdapter extends BaseAdapter {
    //Deklarasi variabel dengan jenis data context
    Context mContext;
    //Deklarasi variabel dengan jenis data layout
    LayoutInflater inflater;
    //Deklarasi variabel dengan jenis data arraylist
    private  ArrayList<ClassNama>arraylist;
    //Membuat konstruktor ListViewadapter
    public ListViewAdapter(Context context){

        //Memberi nilai mContext dengan context
        mContext =context;
        //Mengatur Layoutinflater dari context yang diberikan
        inflater = LayoutInflater.from(mContext);
        //Memberikan nilai arraylist dari class ClassNama
        this.arraylist=new ArrayList<ClassNama>();
        //Menambahkan semua elemen ke arraylist
        this.arraylist.addAll(Home_Activity.classNamaArrayList);
    }
    public class ViewHolder{
        //Mendeklarasikan variabel dengan jenis TextView
        TextView name;
    }

    //Fungsi getCount () mengambilkan jumlah item yang akan ditampilkan dalam list
    @Override
    public int getCount() {
        //deklarasi variabel dengan jenis data ViewHolder
        return Home_Activity.classNamaArrayList.size();
    }

    @Override
    public Object getItem(int i) {

        return Home_Activity.classNamaArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final  ViewHolder holder;

        if(view==null){
            //Membuat object viewholder
            holder = new ViewHolder();
            //Menagtur layout untuk menampilkan item
            view = inflater.inflate(R.layout.activity_item_listview, null);
            //set id untuk textview
            holder.name = (TextView)view.findViewById(R.id.tvnama_item);
            //menyimpan data dalam tampilan tanpa menggunakan struktur data lain.
            view.setTag(holder);
        }else {
            //mengatur holder untuk mengembalikan nilai dari view tag.
            holder = (ViewHolder) view.getTag();
        }
        //Set item ke TextViews
        holder.name.setText(Home_Activity.classNamaArrayList.get(i).getName());
        //Mengambilkan nilai ke variabel view
        return view;
    }
}
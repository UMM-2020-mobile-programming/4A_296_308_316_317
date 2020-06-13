package com.example.cloudprint;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity2 extends AppCompatActivity {

    ListView listView;
    SimpleAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] jdl; //deklarasi judul item
    String[] ket; //deklarasi keterangan item
    String[] gambar; //deklarasi image item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        listView = (ListView)findViewById(R.id.listView);
        jdl = new String[] {
                "Kartu Nama","Brosur","Banner","Pamflet","Spanduk"
        };
        ket = new String[]{
                "Rp 25.000/kotak","Rp 90.000/rim","Rp 20.000/meter","Rp 90.000/rim","Rp 15.000/meter"//jumlahnya harus sama dengan jumlah judul
        };
        gambar = new String[]{
                Integer.toString(R.drawable.kartu),Integer.toString(R.drawable.brosur),Integer.toString(R.drawable.kartu),
                Integer.toString(R.drawable.pamflet),Integer.toString(R.drawable.brosur)
        };
        mylist = new ArrayList<HashMap<String, String>>();

        for (int i=0; i<jdl.length; i++){
            map = new HashMap<String, String>();
            map.put("Judul", jdl[i]);
            map.put("Keterangan", ket[i]);
            map.put("Gambar", gambar[i]);
            mylist.add(map);
        }
        adapter = new SimpleAdapter(this, mylist, R.layout.list_item1,
                new String[]{"Judul", "Keterangan", "Gambar"}, new int[]{R.id.txt_judul,(R.id.txt_keterangan),(R.id.img)});
        listView.setAdapter(adapter);
    }
}

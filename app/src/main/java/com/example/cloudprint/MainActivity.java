package com.example.cloudprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    SimpleAdapter adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] HeroesName; //deklarasi judul item
    String[] HeroesDetail; //deklarasi keterangan item
    String[] HeroesImages; //deklarasi image item

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        listView = (ListView) findViewById(R.id.listView);


        HeroesName = new String[]{
                "PRINTER CENTRE - IZZILOW",
                "ASLAM Printer Malang",
                "CucuShinta PRINT - Servis printer",
                "MB Print",
                "Ijen Computer",
                "Tujuh Komputer",
                "GASOL COMPUTER MALANG",
                "Majesty Printing",
                "Soepomo",
                "Tan Malaka"
        };
        HeroesDetail = new String[]{
                "Jl. Permata Hijau.G No.113, Tlogomas, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144",
                "Jl. Sigura - Gura Barat No.20, Karangbesuki, Kec. Sukun, Kota Malang, Jawa Timur 65149",
                "Jl. MT. Haryono Gg. II No.482, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144",
                "Jl. Gajayana No.796, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144",
                "Jl. Besar Ijen No.77B, Oro-oro Dowo, Kec. Klojen, Kota Malang, Jawa Timur 65119",
                "Jl. Gajayana No.544, Dinoyo, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144",
                "Jl. Raya Tlogomas No.1, Tlogomas, Kec. Lowokwaru, Kota Malang, Jawa Timur 65144",
                "Jl. Brigjend Slamet Riadi No.44, Oro-oro Dowo, Kec. Klojen, Kota Malang, Jawa Timur 65112",
                "Prof. Mr. Dr. Soepomo (Ejaan Soewandi: Supomo; lahir di Sukoharjo, Jawa Tengah, 22 Januari 1903 – meninggal di Jakarta, 12 September 1958 pada umur 55 tahun) adalah seorang pahlawan nasional Indonesia. Soepomo dikenal sebagai arsitek Undang-undang Dasar 1945, bersama dengan Muhammad Yamin dan Soekarno.",
                "Tan Malaka atau Ibrahim gelar Datuk Sutan Malaka (lahir di Nagari Pandam Gadang, Suliki, Lima Puluh Kota, Sumatera Barat, 2 Juni 1897 – meninggal di Desa Selopanggung, Kediri, Jawa Timur, 21 Februari 1949 pada umur 51 tahun) adalah seorang pembela kemerdekaan Indonesia, tokoh Partai Komunis Indonesia, juga pendiri Partai Murba, dan merupakan salah satu Pahlawan Nasional Indonesia."
        };
        HeroesImages = new String[]{
                Integer.toString(R.drawable.ahmad_dahlan), Integer.toString(R.drawable.ahmad_yani), Integer.toString(R.drawable.bung_tomo),
                Integer.toString(R.drawable.gatot_subroto), Integer.toString(R.drawable.ki_hadjar_dewantara),
                Integer.toString(R.drawable.mohammad_hatta), Integer.toString(R.drawable.sudirman),
                Integer.toString(R.drawable.sukarno), Integer.toString(R.drawable.supomo), Integer.toString(R.drawable.tan_malaka)
        };
        mylist = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < HeroesName.length; i++) {
            map = new HashMap<String, String>();
            map.put("Judul", HeroesName[i]);
            map.put("Keterangan", HeroesDetail[i]);
            map.put("Gambar", HeroesImages[i]);
            mylist.add(map);

        }
        adapter = new SimpleAdapter(this, mylist, R.layout.list_item,
                new String[]{"Judul", "Keterangan", "Gambar"}, new int[]{R.id.tv_item_name, (R.id.tv_item_detail), (R.id.img_item_photo)});
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Mendapatkan Nama pada salah satu item yang diklik, berdasarkan posisinya
                HashMap<String, String> getName = mylist.get(position);

                //Berpindah Activity dan Mempassing data Nama pada Activity Selanjutnya
                Intent sendData = new Intent(MainActivity.this, MainActivity3.class);
                sendData.putExtra("MyName", getName);
                startActivity(sendData);
            }
        });
    }





}
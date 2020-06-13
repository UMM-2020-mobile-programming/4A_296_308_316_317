package com.example.cloudprint;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity5 extends AppCompatActivity {
    private Switch Notification, Ads;
    private TextView HasilNotif, HasilAds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().hide();

        Notification = findViewById(R.id.notif);
        Ads = findViewById(R.id.ads);
        HasilNotif = findViewById(R.id.resultnotif);
        HasilAds = findViewById(R.id.resultads);
        Notification.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                //Mengecek Status, Apakah SwitchButton Dalam Keadaan Checked/Hidup atau Unchecked/Mati
                if(checked){
                    HasilNotif.setText("Notification : ON");
                    Toast.makeText(getApplicationContext(),"Notification On", Toast.LENGTH_SHORT).show();
                }else {
                    HasilNotif.setText("Notification : OFF");
                    Toast.makeText(getApplicationContext(),"Notification Off", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Ads.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                //Mengecek Status, Apakah SwitchButton Dalam Keadaan Checked/Hidup atau Unchecked/Mati
                if(checked){
                    HasilAds.setText("Ads : ON");
                    Toast.makeText(getApplicationContext(),"Ads On", Toast.LENGTH_SHORT).show();
                }else {
                    HasilAds.setText("Ads : OFF");
                    Toast.makeText(getApplicationContext(),"Ads Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

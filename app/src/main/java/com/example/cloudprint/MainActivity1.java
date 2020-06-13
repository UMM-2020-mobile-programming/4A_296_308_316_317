package com.example.cloudprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        getSupportActionBar().hide();


        CardView priceCard = findViewById(R.id.pricecardId);
        priceCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent price = new Intent(MainActivity1.this, MainActivity2.class);
                startActivity(price);
            }
        });

        CardView orderCard = findViewById(R.id.ordercardId);
        orderCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent order = new Intent(MainActivity1.this, MainActivity.class);
                startActivity(order);
            }
        });

        CardView accountCard = findViewById(R.id.accountcardId);
        accountCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent account = new Intent(MainActivity1.this, MainActivity4.class);
                startActivity(account);
            }
        });

        CardView settingCard = findViewById(R.id.settingcardId);
        settingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setting = new Intent(MainActivity1.this, MainActivity5.class);
                startActivity(setting);
            }
        });

        CardView aboutCard = findViewById(R.id.aboutcardId);
        aboutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent about = new Intent(MainActivity1.this, MainActivity6.class);
                startActivity(about);
            }
        });
    }
}




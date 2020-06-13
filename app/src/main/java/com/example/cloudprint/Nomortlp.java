package com.example.cloudprint;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Nomortlp extends AppCompatActivity {
    EditText mobile;
    Button button;
    String no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomortlp);
        getSupportActionBar().hide();


        mobile = (EditText) findViewById(R.id.mobile);

        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                no = mobile.getText().toString();
                validNo(no);
                Intent intent = new Intent(Nomortlp.this, OtpActivity.class);
                intent.putExtra("mobile", no);
                startActivity(intent);
                Toast.makeText(Nomortlp.this, no, Toast.LENGTH_LONG).show();
            }
        });


    }

    private void validNo(String no) {
        if (no.isEmpty() || no.length() < 15) {
            mobile.setError("Enter a valid mobile");
            mobile.requestFocus();
            return;
        }
    }
}
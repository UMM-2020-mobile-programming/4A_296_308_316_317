package com.example.cloudprint;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    private EditText email,password,alamat;
    private Button register;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        
        initView();
        RegisterUser();
    }

    private void initView() {
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.btnregis);
        alamat = findViewById(R.id.alamat);
        auth = FirebaseAuth.getInstance();
    }

    private void RegisterUser(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString().trim();
                String Password = password.getText().toString().trim();
                String Alamat = alamat.getText().toString().trim();

                if (Email.isEmpty()){
                    email.setError("Email tidak boleh kosong");
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    email.setError("Email tidak valid");
                }
                else if(Password.isEmpty()){
                    password.setError("Password tidak boleh kosong");
                }
                else if(Password.length()<6){
                    password.setError("Password minimal terdiri dari 6 karakter");
                }
                else if (Alamat.isEmpty()){
                    alamat.setError("Email tidak boleh kosong");
                }
                else{
                    auth.createUserWithEmailAndPassword(Email,Password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(Register.this,"Register gagal karena "+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                            }
                            else{
                                startActivity(new Intent(Register.this, Nomortlp.class));
                            }
                        }
                    });
                }
            }
        });
    }

}

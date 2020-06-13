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

public class Login extends AppCompatActivity {
    private EditText email,password;
    private Button btnlogin,btnregis;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        
        initView();
        login();

    }

    private void initView() {
        email = findViewById(R.id.editTextEmail);
        password = findViewById(R.id.editTextPassword);
        btnlogin = findViewById(R.id.buttonlogin);
        btnregis = findViewById(R.id.buttonregis);
        auth = FirebaseAuth.getInstance();
    }

    private void login() {
        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Email = email.getText().toString().trim();
                final String Password = password.getText().toString().trim();

                if (Email.isEmpty()){
                    email.setError("Email tidak boleh kosong");
                }
                else if (!Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
                    email.setError("Email tidak valid");
                }
                else if (Password.isEmpty()){
                    password.setError("Password tidak boleh kosong");
                }
                else if (Password.length()<6){
                    password.setError("Password minimal terdiri dari 6 karakter");
                }
                else{
                    auth.signInWithEmailAndPassword(Email, Password)
                            .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>(){

                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(!task.isSuccessful()){
                                        Toast.makeText(Login.this,"Login gagal karena "+task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                    }
                                    else {
                                        Bundle bundle = new Bundle();
                                        bundle.putString("email", Email);
                                        bundle.putString("password", Password);
                                        startActivity(new Intent(Login.this, MainActivity1.class).putExtra("emailpass", bundle));
                                        finish();
                                    }
                                }
                            });
                }

            }
        });
    }
}
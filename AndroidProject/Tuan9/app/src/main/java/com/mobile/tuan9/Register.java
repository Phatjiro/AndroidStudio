package com.mobile.tuan9;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText etxtName, etxtEmail, etxtPass, etxtComfirmPass;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            finish();
            return;
        }

        btnRegister = (Button) findViewById(R.id.button2); // button dang ky
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        etxtName = (EditText) findViewById(R.id.e1);
        etxtEmail = (EditText) findViewById(R.id.e2);
        etxtPass = (EditText) findViewById(R.id.e3);
        etxtComfirmPass = (EditText) findViewById(R.id.e4);
    }

    public void registerUser() {
        String ten = etxtName.getText().toString().trim();
        String mail = etxtEmail.getText().toString().trim();
        String pass = etxtPass.getText().toString().trim();
        String conPass = etxtComfirmPass.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(mail, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                        } else {

                        }
                    }
                });
    }

}
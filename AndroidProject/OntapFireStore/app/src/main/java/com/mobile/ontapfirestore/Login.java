package com.mobile.ontapfirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    EditText tfEmailDN;
    EditText tfPassDN;
    Button btnDN;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tfEmailDN = (EditText) findViewById(R.id.tfEmailDN);
        tfPassDN = (EditText) findViewById(R.id.tfPassDN);
        btnDN = (Button) findViewById(R.id.btnDN);

        tfEmailDN.setText("phat1@gmail.com");
        tfPassDN.setText("123456");

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnDN.setOnClickListener(view -> {
            loginUser();
        });
    }

    public void loginUser() {
        String email = tfEmailDN.getText().toString();
        String pass = tfPassDN.getText().toString();

        if (TextUtils.isEmpty(email)) {
            tfEmailDN.setError("Email can't be empty!");
            tfEmailDN.requestFocus();
        } else if (TextUtils.isEmpty(pass)) {
            tfPassDN.setError("Password can't be empty");
            tfPassDN.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(authResult -> {
                db.collection("User").whereEqualTo("email", email).get().addOnSuccessListener(queryDocumentSnapshots -> {
                    Toast.makeText(Login.this, "Login successfully!", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(Login.this, Complete.class));
                }).addOnFailureListener(e -> {
                    Toast.makeText(Login.this, "Login failed!", Toast.LENGTH_LONG).show();
                });
            });
        }
    }
}
package com.mobile.nguyenvanphat19483821;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {

    EditText tfEmailDN, tfPassDN;
    Button btnDN;
    TextView tvDKNgay;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tfEmailDN = (EditText) findViewById(R.id.tfEmailDN);
        tfPassDN = (EditText) findViewById(R.id.tfPassDN);
        btnDN = (Button) findViewById(R.id.btnDN);
        tvDKNgay = (TextView) findViewById(R.id.tvDKNgay);

        // Set text sẵn cho user đăng nhập - dùng để test cho lẹ
        tfEmailDN.setText("phat1@gmail.com");
        tfPassDN.setText("123456");

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLayoutMain();
            }
        });

        tvDKNgay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLayoutRegister();
            }
        });
    }

    public void openLayoutRegister() {
        startActivity(new Intent(Login.this, Register.class));
    }
    public void openLayoutMain() {
        String email = tfEmailDN.getText().toString().trim();
        String pass = tfPassDN.getText().toString().trim();

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
                    startActivity(new Intent(Login.this, Bussines.class));
                }).addOnFailureListener(e -> {
                    Toast.makeText(Login.this, "Login failed!", Toast.LENGTH_LONG).show();
                });
            });
        }
    }
}
package com.mobile.onthicoban;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class DangNhapActivity extends AppCompatActivity {

    EditText edtMailDN;
    EditText edtPassDN;
    Button btnDN;
    TextView edtChuThichDN;

    String userId;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        edtMailDN = findViewById(R.id.edtMailDN);
        edtPassDN = findViewById(R.id.edtPassDN);

        // Dành để test
        edtMailDN.setText("ph1@gmail.com");
        edtPassDN.setText("123456");

        btnDN = findViewById(R.id.btnDN);
        btnDN.setOnClickListener(view -> {
            loginAndJumpLayout();
        });

        edtChuThichDN = findViewById(R.id.txtChuThichDN);
        edtChuThichDN.setOnClickListener(view -> {
            startActivity(new Intent(DangNhapActivity.this, DangKiActivity.class));
        });
    }

    public void loginAndJumpLayout() {
        String email = edtMailDN.getText().toString();
        String pass = edtPassDN.getText().toString();

        mAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(DangNhapActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DangNhapActivity.this, MainActivity.class));
            } else {
                Toast.makeText(DangNhapActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

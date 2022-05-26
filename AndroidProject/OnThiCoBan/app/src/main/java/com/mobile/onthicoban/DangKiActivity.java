package com.mobile.onthicoban;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class DangKiActivity extends AppCompatActivity {

    EditText edtMailDK;
    EditText edtPassDK;
    Button btnDK;

    String userId;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ki);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        edtMailDK = (EditText) findViewById(R.id.edtMailDK);
        edtPassDK = (EditText) findViewById(R.id.edtPassDK);
        btnDK = (Button) findViewById(R.id.btnDK);
        btnDK.setOnClickListener(view -> {
            createUserAndJumpLayout();
        });
    }

    public void createUserAndJumpLayout() {
        String email = edtMailDK.getText().toString();
        String pass = edtPassDK.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(DangKiActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();

                userId = mAuth.getCurrentUser().getUid();
                DocumentReference reference = db.collection("Users").document(userId);
                User user = new User(email);
                reference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(DangKiActivity.this, "FireStore thành công", Toast.LENGTH_SHORT).show();
                    }
                });
                startActivity(new Intent(DangKiActivity.this, DangNhapActivity.class));
            } else {
                Toast.makeText(DangKiActivity.this, "Đăng kí thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

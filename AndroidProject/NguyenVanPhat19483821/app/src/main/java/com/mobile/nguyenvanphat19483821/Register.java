package com.mobile.nguyenvanphat19483821;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Register extends AppCompatActivity {

    EditText tfNameDK, tfEmailDK, tfPassDK;
    Button btnDK;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tfNameDK = (EditText) findViewById(R.id.tfNameDK);
        tfEmailDK = (EditText) findViewById(R.id.tfEmailDK);
        tfPassDK = (EditText) findViewById(R.id.tfPassDK);
        btnDK = (Button) findViewById(R.id.btnDK);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });
    }

    public void registerUser() {
        String name = tfNameDK.getText().toString().trim();
        String email = tfEmailDK.getText().toString().trim();
        String pass = tfPassDK.getText().toString().trim();

        if (TextUtils.isEmpty(name)) {
            tfNameDK.setError("Name can't be empty!");
            tfNameDK.requestFocus();
        } else if (TextUtils.isEmpty(email)) {
            tfEmailDK.setError("Email can't be empty!");
            tfEmailDK.requestFocus();
        } else if (TextUtils.isEmpty(pass)) {
            tfPassDK.setError("Password can't be empty");
            tfPassDK.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(Register.this, "Register successfully!", Toast.LENGTH_LONG).show();

                    userID = mAuth.getCurrentUser().getUid();
                    DocumentReference reference = db.collection("User").document(userID);

                    User user = new User(name, email);

                    reference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Register.this, "Save data to FireStore successfully!", Toast.LENGTH_LONG).show();
                        }
                    });
                    startActivity(new Intent(Register.this, Login.class));
                } else {
                    Toast.makeText(Register.this, "Register failed!", Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}
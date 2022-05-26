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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    EditText tfEmailDK;
    EditText tfPassDK;
    EditText tfAgeDK;
    Button btnDK;
    Button btnJumpDN;

    String userID;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        tfEmailDK = (EditText) findViewById(R.id.tfEmailDK);
        tfPassDK = (EditText) findViewById(R.id.tfPassDK);
        tfAgeDK = (EditText) findViewById(R.id.tfAgeDK);
        btnDK = (Button) findViewById(R.id.btnDK);
        btnJumpDN = (Button) findViewById(R.id.btnJumpDN);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnDK.setOnClickListener(view -> {
            createUser();
        });

        btnJumpDN.setOnClickListener(view -> {
            startActivity(new Intent(Register.this, Login.class));
        });
    }

    public void createUser() {
        String email = tfEmailDK.getText().toString();
        String pass = tfPassDK.getText().toString();
        int age = Integer.parseInt(tfAgeDK.getText().toString());

        if (TextUtils.isEmpty(email)) {
            tfEmailDK.setError("Email can't be empty!");
            tfEmailDK.requestFocus();
        } else if (TextUtils.isEmpty(pass)) {
            tfPassDK.setError("Password can't be empty");
            tfPassDK.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(Register.this, "Register and save data successfully!", Toast.LENGTH_LONG).show();
                    userID = mAuth.getCurrentUser().getUid();
                    DocumentReference reference = db.collection("User").document(userID);
                    User user = new User(email, pass, age);
                    reference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(Register.this, "Uid: " + userID, Toast.LENGTH_LONG).show();
                        }
                    });
                    startActivity(new Intent(Register.this, Login.class));
                } else {
                    Toast.makeText(Register.this, "Register and save data failed!", Toast.LENGTH_LONG).show();
                }
            });
        }

    }
}
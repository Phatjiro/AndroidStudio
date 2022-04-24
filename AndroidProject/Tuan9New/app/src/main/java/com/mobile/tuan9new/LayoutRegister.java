package com.mobile.tuan9new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LayoutRegister extends AppCompatActivity {

    private FirebaseAuth mAuth;
    Button btnRegister;
    EditText txtRegisterName, txtRegisterMail, txtRegisterPassword, txtRegisterConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_register);

        mAuth = FirebaseAuth.getInstance();

        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        txtRegisterName = (EditText) findViewById(R.id.txtRegisterName);
        txtRegisterMail = (EditText) findViewById(R.id.txtRegisterMail);
        txtRegisterPassword = (EditText) findViewById(R.id.txtRegisterPassword);
        txtRegisterConfirmPassword = (EditText) findViewById(R.id.txtRegisterConfirmPassword);
    }

    public void registerUser() {
        String userName = txtRegisterName.getText().toString().trim();
        String userMail = txtRegisterMail.getText().toString().trim();
        String userPass = txtRegisterPassword.getText().toString().trim();
        String userConfirmPass = txtRegisterConfirmPassword.getText().toString().trim();

        if(userPass.equals(userConfirmPass) == false) {
            txtRegisterConfirmPassword.setError("Confirm password failed!");
        }

        mAuth.createUserWithEmailAndPassword(userMail, userPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            UserTuan9 userTuan9 = new UserTuan9(userName, userMail);
                            FirebaseDatabase.getInstance().getReference("userTuan9s")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(userTuan9).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(LayoutRegister.this, "Create successful", Toast.LENGTH_LONG).show();
                                    showMainActivity();
                                }
                            });
                        }
                        else {
                            Toast.makeText(LayoutRegister.this, "Create failed!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void showMainActivity() {
        startActivity(new Intent(this, LayoutRegister.class));
    }

}
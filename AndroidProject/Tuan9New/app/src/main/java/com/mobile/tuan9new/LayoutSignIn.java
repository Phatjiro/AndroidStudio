package com.mobile.tuan9new;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class LayoutSignIn extends AppCompatActivity {

    FirebaseAuth mAuth;
    Button btnSignIn;
    EditText txtSignInMail, txtSignInPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_sign_in);

        mAuth = FirebaseAuth.getInstance();
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInUser();
            }
        });
        txtSignInMail = (EditText) findViewById(R.id.txtSignInMail);
        txtSignInPassword = (EditText) findViewById(R.id.txtSignInPassword);
    }

    public void signInUser() {
        String userMail = txtSignInMail.getText().toString().trim();
        String userPass = txtSignInPassword.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(userMail, userPass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            showInfoUser();
                        }
                        else {
                            Toast.makeText(LayoutSignIn.this, "Login failed!", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void showInfoUser() {
        startActivity(new Intent(this, InfoUser.class));
    }
}
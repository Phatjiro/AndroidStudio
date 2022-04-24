package com.mobile.tuan9new;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnToRegister;
    Button btnToSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToRegister = (Button) findViewById(R.id.btnToRegister);
        btnToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLayoutRegister();
            }
        });

        btnToSignIn = (Button) findViewById(R.id.btnToSignIn);
        btnToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLayoutSignIn();
            }
        });
    }

    public void openLayoutRegister() {
        startActivity(new Intent(this, LayoutRegister.class));
    }

    public void openLayoutSignIn() {
        startActivity(new Intent(this, LayoutSignIn.class));
    }
}
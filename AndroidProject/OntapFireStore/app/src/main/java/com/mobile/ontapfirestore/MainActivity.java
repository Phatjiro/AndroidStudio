package com.mobile.ontapfirestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnGoToDN;
    Button btnGoToDK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGoToDK = (Button) findViewById(R.id.btnGoToDK);
        btnGoToDN = (Button) findViewById(R.id.btnGoToDN);

        btnGoToDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLayoutDK();
            }
        });

        btnGoToDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLayoutDN();
            }
        });
    }

    public void openLayoutDK() {
        startActivity(new Intent(MainActivity.this, Register.class));
    }

    public void openLayoutDN() {
        startActivity(new Intent(MainActivity.this, Login.class));
    }
}
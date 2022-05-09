package com.mobile.ontapfirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Complete extends AppCompatActivity {

    TextView tfEmailCom, tfPassCom, tfAgeCom;
    Button btnDX;

    FirebaseAuth mAuth;
    FirebaseFirestore db;
    static final String TAG = "Read Data Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete);

        tfEmailCom = (TextView) findViewById(R.id.tfEmailCom);
        tfPassCom = (TextView) findViewById(R.id.tfPassCom);
        tfAgeCom = (TextView) findViewById(R.id.tfAgeCom);
        btnDX = (Button) findViewById(R.id.btnDX);

        btnDX.setOnClickListener(view -> {
            mAuth.signOut();
            startActivity(new Intent(Complete.this, MainActivity.class));
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        String uid = user.getUid();
        System.out.println(uid + "AAAAAAAAAAAAAAAAAAA");

        DocumentReference reference;
        db = FirebaseFirestore.getInstance();

        reference = db.collection("User").document(uid);

        reference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.getResult().exists()) {

                    Toast.makeText(Complete.this, "Read data from FireStore successfullyyyyyyyyyyyy!", Toast.LENGTH_LONG).show();

                    String mailRs = task.getResult().getString("email");
                    String passRs = task.getResult().getString("password");
                    String ageRs = task.getResult().getLong("age")+"";

                    tfEmailCom.setText(mailRs);
                    tfPassCom.setText(passRs);
                    tfAgeCom.setText(ageRs);

                } else {
                    Toast.makeText(Complete.this, "Read data from FireStore failed!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
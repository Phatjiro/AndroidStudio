package com.mobile.onthicoban;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edtTenSP;
    Button btnThemSP;
    TextView txtTitleMain;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    ListView lstView;
    ArrayList<SanPham> lstSanPham;
    CustomeAdapter adapterSanPham;
    ArrayAdapter adapter;

    SanPham spp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        edtTenSP = findViewById(R.id.edtTenSpThem);
        btnThemSP = findViewById(R.id.btnThemSp);
        btnThemSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themSanPham();
            }
        });

        txtTitleMain = findViewById(R.id.txtTitleMain);
        txtTitleMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(CustomeAdapter.SPP + "AAAAAAAAAAAAAA");
            }
        });

        lstView = (ListView) findViewById(R.id.lstViewItem);

        lstSanPham = new ArrayList<>();
        getListItem();

        //
        List<String> lsTest = new ArrayList<>();
        lsTest.add("APPLE");
        lsTest.add("BANANA");

        adapterSanPham = new CustomeAdapter(MainActivity.this, R.layout.item, lstSanPham);
        //
        adapter = new ArrayAdapter(getApplicationContext(), R.layout.item, lsTest);

        lstView.setAdapter(adapterSanPham);

        lstView.setItemsCanFocus(false);
        System.out.println(CustomeAdapter.SPP + "AAAAAAAAAAAAAA");
    }

    public void themSanPham() {
        String tenSP = edtTenSP.getText().toString();

        DocumentReference reference = db.collection("SanPham").document();
        SanPham sp = new SanPham(reference.getId(), tenSP, "Chi ti???t s???n ph???m si??u c???p vip pro");
        reference.set(sp).addOnCompleteListener(task -> {
           if (task.isSuccessful()) {
               getListItem();
               Toast.makeText(MainActivity.this, "Th??m s???n ph???m th??nh c??ng", Toast.LENGTH_SHORT).show();
           } else {
               Toast.makeText(MainActivity.this, "Th??m th???t b???i", Toast.LENGTH_SHORT).show();
           }
        });
    }

    public void getListItem() {
        db.collection("SanPham").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (queryDocumentSnapshots.isEmpty()) {
                            Toast.makeText(MainActivity.this, "Danh s??ch tr???ng", Toast.LENGTH_SHORT).show();
                            return;
                        } else {
                            List<SanPham> sp =  (List<SanPham>) queryDocumentSnapshots.toObjects(SanPham.class);
                            lstSanPham.clear();
                            lstSanPham.addAll(sp);
                            System.out.println(lstSanPham);
                            adapterSanPham.notifyDataSetChanged();
                            Toast.makeText(MainActivity.this, "Load danh s??ch ok", Toast.LENGTH_SHORT).show();
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivity.this, "Load danh s??ch th???t b???i", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void deleteItem(String id) {
        db.collection("SanPham").document(id).delete().addOnCompleteListener(task -> {
           if (task.isSuccessful()) {
               Toast.makeText(MainActivity.this, "Xo?? th??nh c??ng", Toast.LENGTH_SHORT).show();
           } else {
               Toast.makeText(MainActivity.this, "Xo?? th???t b???i", Toast.LENGTH_SHORT).show();
           }
        });
    }
}
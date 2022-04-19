package com.mobile.tuan4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuan4_a);

        listView = findViewById(R.id.lvSanPham);

        // Creat data
        ArrayList<SanPham> arrayList = new ArrayList<>();

        SanPham sp1 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");
        SanPham sp2 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");
        SanPham sp3 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");
        SanPham sp4 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");
        SanPham sp5 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");
        SanPham sp6 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");
        SanPham sp7 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");
        SanPham sp8 = new SanPham(R.drawable.ca_nau_lau, "Ca nấu lẩu, nấu mì mini...", "Shop Devan");

        arrayList.add(sp1);
        arrayList.add(sp2);
        arrayList.add(sp3);
        arrayList.add(sp4);
        arrayList.add(sp5);
        arrayList.add(sp6);
        arrayList.add(sp7);
        arrayList.add(sp8);

        ListAdapter listAdapter = new ListAdapter(this, R.layout.sanpham, arrayList);

        listView.setAdapter(listAdapter);
    }
}
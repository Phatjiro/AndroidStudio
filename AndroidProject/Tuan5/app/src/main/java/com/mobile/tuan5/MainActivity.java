package com.mobile.tuan5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tuan5);

        listView = findViewById(R.id.lvDonut);

        Donut dn1 = new Donut(R.drawable.donut_yellow, "Tasty Donut", "Spicy tasty donut family", 10.00);
        Donut dn2 = new Donut(R.drawable.donut_yellow, "Tasty Donut", "Spicy tasty donut family", 10.00);
        Donut dn3 = new Donut(R.drawable.donut_yellow, "Tasty Donut", "Spicy tasty donut family", 10.00);
        Donut dn4 = new Donut(R.drawable.donut_yellow, "Tasty Donut", "Spicy tasty donut family", 10.00);
        Donut dn5 = new Donut(R.drawable.donut_yellow, "Tasty Donut", "Spicy tasty donut family", 10.00);

        ArrayList<Donut> arrayList = new ArrayList<>();

        arrayList.add(dn1);
        arrayList.add(dn2);
        arrayList.add(dn3);
        arrayList.add(dn4);
        arrayList.add(dn5);

        ListAdapter listAdapter = new ListAdapter(this, R.layout.donut, arrayList);

        listView.setAdapter(listAdapter);
    }
}
package com.mobile.labt055;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Donut> donutList;
    private ListView listView;
    private Donut d1;
    private Donut d2;
    private Donut d3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        donutList = new ArrayList<>();

        d1 = new Donut(R.drawable.donut_yellow, "Donut Vang");
        d2 = new Donut(R.drawable.donut_yellow, "Donut Vang");
        d3 = new Donut(R.drawable.donut_yellow, "Donut Vang");

        donutList.add(d1);
        donutList.add(d2);
        donutList.add(d3);

        DonutAdapter donutAdapter = new DonutAdapter(this, R.layout.donut_custom_item,donutList);
        listView.setAdapter(donutAdapter);
    }
}
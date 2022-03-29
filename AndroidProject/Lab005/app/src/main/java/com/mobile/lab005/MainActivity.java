package com.mobile.lab005;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Donut> donutList;
    private ListView donutListView;
    private Button pinkDonutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutListView = findViewById(R.id.listView);
        donutList = new ArrayList<>();
        donutList.add(new Donut(R.drawable.donut_yellow, "Donut ngon dei"));
        donutList.add(new Donut(R.drawable.donut_yellow, "Donut pink"));
        donutList.add(new Donut(R.drawable.donut_yellow, "Donut floating"));

        DonutAdapter donutAdapter = new DonutAdapter(this,R.layout.donut_custom_item,donutList);
        donutListView.setAdapter(donutAdapter);

        pinkDonutBtn = (Button) findViewById(R.id.pinkDonutBtn);
        pinkDonutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                filterPinkDonut();
            }
        });
    }

    public void filterPinkDonut() {
        donutListView = findViewById(R.id.listView);
        donutList = new ArrayList<>();
        donutList.add(new Donut(R.drawable.donut_yellow, "Donut pink"));

        DonutAdapter donutAdapter = new DonutAdapter(this,R.layout.donut_custom_item,donutList);
        donutListView.setAdapter(donutAdapter);
    }
}
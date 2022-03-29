package com.mobile.lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Donut> donutList;
    private ListView donutListView;
//    private DonutAdapter donutAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutListView = findViewById(R.id.donutListView);
        donutList = new ArrayList<>();

        donutList.add(new Donut(R.drawable.donut_yellow, "Donut ngon"));
        donutList.add(new Donut(R.drawable.donut_yellow, "Donut ngon"));
        donutList.add(new Donut(R.drawable.donut_yellow, "Donut ngon"));

        DonutAdapter donutAdapter = new DonutAdapter(this, R.layout.donut_item_custom, donutList);
        donutListView.setAdapter(donutAdapter);


    }
}
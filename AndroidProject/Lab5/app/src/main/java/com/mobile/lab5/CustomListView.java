package com.mobile.lab5;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomListView extends AppCompatActivity {
    private List<Donut> donuts;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view);

        listView = findViewById(R.id.listView);

        donuts = new ArrayList<>();
        donuts.add(new Donut("donut_yellow","Tasty Donut","Spicy tasty donut family","$10.00"));
        donuts.add(new Donut("tasty_donut","Pink Donut","Spicy tasty donut family","$20.00"));
        donuts.add(new Donut("green_donut","Floating Donut","Spicy tasty donut family","$30.00"));
        donuts.add(new Donut("donut_red","Tasty Donut","Spicy tasty donut family","$17.99"));

        DonutAdapter donutAdapter = new DonutAdapter(this,R.layout.item_custom_list_view,donuts);
        listView.setAdapter(donutAdapter);
    }
}

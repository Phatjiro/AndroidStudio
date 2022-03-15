package com.mobile.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Goods> listGoods;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_listview);

        listView = (ListView) findViewById(R.id.idListView);
        listGoods = new ArrayList<>();
        listGoods.add(new Goods(1, "Lập Trình Java"));
        listGoods.add(new Goods(2, "Lập Trình Android"));
        listGoods.add(new Goods(3, "Lập Trình JavaFX"));
        listGoods.add(new Goods(4, "Lập Trình Web"));
        listGoods.add(new Goods(5, "Lập Trình Ruby"));
        listGoods.add(new Goods(6, "Lập Trình C++"));
        listGoods.add(new Goods(7, "Lập Trình PHP"));
        listGoods.add(new Goods(8, "Lập Trình WordPress"));

        GoodsAdapter adapter = new GoodsAdapter(this, R.layout.custom_listview_item, listGoods);
        listView.setAdapter(adapter);
    }
}
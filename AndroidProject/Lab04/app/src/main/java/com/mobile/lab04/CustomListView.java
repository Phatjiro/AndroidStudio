package com.mobile.lab04;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CustomListView extends AppCompatActivity {
    private List<Product> products;
    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_list_view);

        listView = findViewById(R.id.listView);

        products = new ArrayList<>();
        products.add(new Product("ca_nau_lau", "Ca nấu lẩu, nấu mì mini", "Devang"));
        products.add(new Product("ga_bo_toi", "1Kg khô gà lá chanh", "LTD Food"));
        products.add(new Product("xa_can_cau", "Xe cần cẩu đa năng", "Thế giới đồ chơi"));
        products.add(new Product("do_choi_dang_mo_hinh", "Đồ chơi dạng mô hình", "Thế giới đồ chơi"));
        products.add(new Product("lanh_dao_gian_don", "Lãnh đạo giản đơn", "Minh Long Book"));
        products.add(new Product("hieu_long_con_tre", "Hiểu lòng con trẻ", "Minh Long Book"));
        products.add(new Product("trump", "Donald Trump - Thiên tài chính trị", "Minh Long Book"));

        ProductAdapter productAdapter = new ProductAdapter(this, R.layout.item_custom_list_view, products);
        listView.setAdapter(productAdapter);
    }
}

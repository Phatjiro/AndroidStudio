package com.mobile.onthicoban;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class CustomeAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<SanPham> lstSanPham;
    private int pos = -1;

    private FirebaseFirestore db;

    public static SanPham SPP;

    public CustomeAdapter(Context context, int layout, List<SanPham> lstSanPham) {
        this.context = context;
        this.layout = layout;
        this.lstSanPham = lstSanPham;
    }

    @Override
    public int getCount() {
        return lstSanPham.size();
    }

    @Override
    public Object getItem(int i) {
        return lstSanPham.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        db = FirebaseFirestore.getInstance();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(layout, null);

        SanPham sp = lstSanPham.get(i);

        ConstraintLayout layoutItem = view.findViewById(R.id.layoutItem);

        TextView tenItem = view.findViewById(R.id.txtTenItem);
        TextView chiTietItem = view.findViewById(R.id.txtChiTietItem);

        tenItem.setText(sp.getTenSP());
        chiTietItem.setText(sp.getChiTietSP());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pos = i;
                notifyDataSetChanged();
            }
        });

        if (pos == i) {
            layoutItem.setBackgroundColor(Color.rgb(202, 117, 255));
        } else {
            layoutItem.setBackgroundColor(Color.WHITE);
        }

        if (pos != -1) {
            SPP = (SanPham) getItem(pos);
        }

        return view;
    }
}

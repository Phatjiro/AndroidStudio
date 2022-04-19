package com.mobile.tuan4;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<SanPham> {

    private int posSelect = -1;

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<SanPham> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        SanPham sp = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sanpham, parent, false);

        }

        ImageView imgSanPham = convertView.findViewById(R.id.imgSanPham);
        TextView tvSanPham = convertView.findViewById(R.id.tvSanPham);
        TextView tvTenShop = convertView.findViewById(R.id.tvTenShop);
        Button btnChat = convertView.findViewById(R.id.btnChat);

        final LinearLayout linearLayout = convertView.findViewById(R.id.idLinearLayout);

        imgSanPham.setImageResource(sp.getImgID());
        tvSanPham.setText(sp.getTenSanPham());
        tvTenShop.setText(sp.getTenShop());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), sp.getTenSanPham(), Toast.LENGTH_LONG).show();
                posSelect = position;
                notifyDataSetChanged();
            }
        });

        if (posSelect == position) {
            linearLayout.setBackgroundColor(Color.LTGRAY);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }
}

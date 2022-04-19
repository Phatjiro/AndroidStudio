package com.mobile.tuan5;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<Donut> {

    private int posSelect = -1;

    public ListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Donut> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Donut donut = getItem(position);

        if (convertView == null) {

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.donut, parent, false);

        }

        ImageView imgDonut = convertView.findViewById(R.id.imgDonut);
        TextView tvTenDonut = convertView.findViewById(R.id.tvTenDonut);
        TextView tvMoTaDonut = convertView.findViewById(R.id.tvMoTaDonut);
        TextView tvGiaTienDonut = convertView.findViewById(R.id.tvGiaTienDonut);

        ImageButton ibtnMuaDonut = convertView.findViewById(R.id.ibtnMuaDonut);

        final LinearLayout linearLayout = convertView.findViewById(R.id.idLinearLayout);

        imgDonut.setImageResource(donut.getImgID());
        tvTenDonut.setText(donut.getTenDonut());
        tvMoTaDonut.setText(donut.getMoTaDonut());
        tvGiaTienDonut.setText(donut.getGiaTienDonut()+"");

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), donut.getTenDonut(), Toast.LENGTH_SHORT).show();
                posSelect = position;
                notifyDataSetChanged();
            }
        });

        ibtnMuaDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDonutDetail();
            }
        });

        if (posSelect == position) {
            linearLayout.setBackgroundColor(Color.rgb(106, 90, 205));
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }

    public void openDonutDetail() {
        Intent intent = new Intent(getContext(), DonutDetail.class);
        getContext().startActivity(intent);
    }
}

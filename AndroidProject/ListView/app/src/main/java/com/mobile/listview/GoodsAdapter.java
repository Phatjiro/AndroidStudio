package com.mobile.listview;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class GoodsAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Goods> listGoods;
    private int positionSelect = -1;

    public GoodsAdapter(Context context, int idLayout, List<Goods> listGoods) {
        this.context = context;
        this.idLayout = idLayout;
        this.listGoods = listGoods;
    }

    @Override
    public int getCount() {
        if (listGoods.size() != 0 && !listGoods.isEmpty()) {
            return listGoods.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(idLayout, parent, false);
        }

        TextView tvGoodsName = (TextView) convertView.findViewById(R.id.tvLanguageName);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.logo);
        final LinearLayout linearLayout = (LinearLayout) convertView.findViewById(R.id.idLinearLayout);
        final Goods goods = listGoods.get(position);

        if (listGoods != null && !listGoods.isEmpty()) {
            tvGoodsName.setText(goods.getName());
            int idGoods = goods.getId();
            switch (idGoods) {
                case 1:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 2:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 3:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 4:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 5:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 6:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 7:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                case 8:
                    imageView.setImageResource(R.drawable.ca_nau_lau);
                    break;
                default:
                    break;
            }
        }
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, goods.getName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if (positionSelect == position) {
            linearLayout.setBackgroundColor(Color.BLUE);
        } else {
            linearLayout.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

}

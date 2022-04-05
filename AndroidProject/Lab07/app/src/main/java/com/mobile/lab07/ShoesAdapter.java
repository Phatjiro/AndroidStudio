package com.mobile.lab07;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.List;

public class ShoesAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Shoes> shoesList;
    private int posSelect = -1;

    public ShoesAdapter(Context context, int idLayout, List<Shoes> shoesList) {
        this.context = context;
        this.idLayout = idLayout;
        this.shoesList = shoesList;
    }

    @Override
    public int getCount() {
        return shoesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);

        ImageView shoeImg = view.findViewById(R.id.shoeImg);
        TextView shoeName = view.findViewById(R.id.shoeName);
        TextView shoeDetail = view.findViewById(R.id.shoeDetail);

        shoeImg.setImageResource(shoesList.get(i).getIdImg());
        shoeName.setText(shoesList.get(i).getName());
        shoeDetail.setText(shoesList.get(i).getDetail());

        return null;
    }
}

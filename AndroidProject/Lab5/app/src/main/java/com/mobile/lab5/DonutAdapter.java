package com.mobile.lab5;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class DonutAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Donut> donutList;
    private int positionSelect = -1;

    public DonutAdapter(Context context, int idLayout, List<Donut> donutList) {
        this.context = context;
        this.idLayout = idLayout;
        this.donutList = donutList;
    }

    @Override
    public int getCount() {
        return donutList.size();
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
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout,viewGroup,false);
        }

        ImageView dnImg = view.findViewById(R.id.dnImg);
        TextView dnName = view.findViewById(R.id.dnName);
        TextView dnDetail = view.findViewById(R.id.dnDetail);
        TextView dnCost = view.findViewById(R.id.dnCost);

        LinearLayout layout = view.findViewById(R.id.idLinearLayout);
        Donut donut = donutList.get(i);

        if (donutList != null && !donutList.isEmpty()) {
            dnImg.setImageResource(context.getResources().getIdentifier(
                    donut.getDnImg(),
                    "drawable",
                    context.getPackageName()
            ));
            dnName.setText(donut.getDnName());
            dnDetail.setText(donut.getDnDetail());
            dnCost.setText(donut.getDnCost());
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                positionSelect = i;
                notifyDataSetChanged();
            }
        });

        if(positionSelect == i) {
            layout.setBackgroundColor(Color.GRAY);
        } else {
            layout.setBackgroundColor(Color.WHITE);
        }

        return view;
    }
}

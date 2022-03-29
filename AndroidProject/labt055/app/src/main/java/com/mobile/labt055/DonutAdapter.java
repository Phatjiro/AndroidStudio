package com.mobile.labt055;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class DonutAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Donut> donutList;
    private int posSelect = -1;

    public DonutAdapter(Context context, int idLayout, List<Donut> donutList) {
        this.context = context;
        this.idLayout = idLayout;
        this.donutList = donutList;
    }

    @Override
    public int getCount() {
        if(donutList.size() != 0 && !donutList.isEmpty()) {
            return donutList.size();
        }
        return 0;
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

        ImageView donutIdImg = view.findViewById(R.id.donutImg);
        TextView donutName = view.findViewById(R.id.donutName);
        ImageButton donutPlusBtn = view.findViewWithTag(R.id.donutPlusBtn);

        LinearLayout layout = view.findViewById(R.id.idLinearLayout);
        Donut donut = donutList.get(i);

        if(donutList != null && !donutList.isEmpty()) {
            donutIdImg.setImageResource(donut.getDonutIdImg());
            donutName.setText(donut.getDonutName());
        }

        donutPlusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetail();
            }
        });

        return view;
    }

    public void openDetail() {
        Intent intent = new Intent(context, DonutDetail.class);
    }
}

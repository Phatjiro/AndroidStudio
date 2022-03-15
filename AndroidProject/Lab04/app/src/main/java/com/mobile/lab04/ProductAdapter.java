package com.mobile.lab04;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context context;
    private int idLayout;
    private List<Product> productList;
    private int positionSelect = -1;

    public ProductAdapter(Context context, int idLayout, List<Product> productList) {
        this.context = context;
        this.idLayout = idLayout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        if (productList.size() != 0 && !productList.isEmpty())
            return productList.size();

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
    public View getView(final int position, View view, ViewGroup viewGroup) {

        if (view == null)
            view = LayoutInflater.from(viewGroup.getContext()).inflate(idLayout, viewGroup, false);

        ImageView prdImg = view.findViewById(R.id.prdImg);
        TextView prdName = view.findViewById(R.id.prdName);
        TextView prdSupplier = view.findViewById(R.id.prdSupplier);

        LinearLayout layout = view.findViewById(R.id.idLinearLayout);
        Product product = productList.get(position);

        if (productList != null && !productList.isEmpty()){
            prdImg.setImageResource(context.getResources().getIdentifier(
                    product.getPrdImg(),
                    "drawable",
                    context.getPackageName()
            ));
            prdName.setText(product.getPrdName());
            prdSupplier.setText(product.getPrdSupplier());
        }

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, product.getPrdName(), Toast.LENGTH_LONG).show();
                positionSelect = position;
                notifyDataSetChanged();
            }
        });

        if(positionSelect == position) {
            layout.setBackgroundColor(Color.CYAN);
        } else {
            layout.setBackgroundColor(Color.WHITE);
        }

        return view;
    }
}

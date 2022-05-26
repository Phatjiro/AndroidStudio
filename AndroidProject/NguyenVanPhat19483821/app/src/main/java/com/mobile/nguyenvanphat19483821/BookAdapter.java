package com.mobile.nguyenvanphat19483821;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class BookAdapter extends BaseAdapter {
    private Context context;
    private int bookContainer;
    private List<Book> bookList;

    public BookAdapter(Context context, int bookContainer, List<Book> bookList) {
        this.context = context;
        this.bookContainer = bookContainer;
        this.bookList = bookList;
    }

    @Override
    public int getCount() {
        return bookList.size();
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
            view = LayoutInflater.from(viewGroup.getContext()).inflate(bookContainer, viewGroup, false);
        }

        ImageView imgViewBook = view.findViewById(R.id.imgViewBook);
        TextView tvBookName = view.findViewById(R.id.tvBookName);

        Book book = bookList.get(i);

        if (book != null && !bookList.isEmpty()){
            imgViewBook.setImageResource(book.getBookID());
            tvBookName.setText(book.getBookName());
        }

        return view;
    }
}

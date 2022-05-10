package com.mobile.ontaptodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TodoAdapter extends BaseAdapter {
    private Context context;
    private int todoContainer;
    private List<Todo> todoList;

    public TodoAdapter(Context context, int todoContainer, List<Todo> todoList) {
        this.context = context;
        this.todoContainer = todoContainer;
        this.todoList = todoList;
    }


    @Override
    public int getCount() {
        return todoList.size();
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
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(todoContainer, viewGroup, false);


        TextView txvName = view.findViewById(R.id.tvTodoTitle);
        TextView txvCompleted = view.findViewById(R.id.tvTodoStatus);
        TextView txvContent = view.findViewById(R.id.tvTodoContent);

        Todo todo = todoList.get(i);

        if (todo != null && !todoList.isEmpty()){
            txvName.setText(todo.getName());
            txvCompleted.setText( todo.isCompleted() ? "XONG" : "ĐANG");
            txvContent.setText(todo.getContent());
        }

        return view;
    }
}

package com.mobile.labtuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    DataUser dataUser;
    Button btn_add, btn_remove, btn_cancel;
    EditText edit_name;
    ListView listViewName;
    ArrayList arrayListName;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataUser = new DataUser(
                this,
                "user.db.sqlite",
                null,
                1
        );

        arrayListName = getNameList();

        edit_name = findViewById(R.id.edit_name);
        btn_add = findViewById(R.id.btn_add);
        btn_remove = findViewById(R.id.btn_remove);
        btn_cancel = findViewById(R.id.btn_cancel);
        listViewName = findViewById(R.id.listViewName);

        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                arrayListName);

        listViewName.setAdapter(adapter);
    }

    private ArrayList getNameList() {
        ArrayList<String> arrayListName = new ArrayList<>();
        for (Iterator iterator = dataUser.getAll().iterator(); iterator.hasNext(); ) {
            User user = (User) iterator.next();

            arrayListName.add(user.getName());
        }
        return arrayListName;
    }
}
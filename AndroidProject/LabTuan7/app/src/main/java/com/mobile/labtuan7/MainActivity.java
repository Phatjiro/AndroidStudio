package com.mobile.labtuan7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    DataUser dataUser;
    Button btn_add, btn_remove, btn_cancel;
    EditText edit_name;
    ListView listViewName;
    ArrayList arrayListName;
    ArrayList arrayListId;
    ArrayAdapter adapter;
    int posSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Tạo dataUser để kết nối database
        dataUser = new DataUser(
                this,
                "user.db.sqlite",
                null,
                1
        );

        // Tạo ArrayList quản lí id, name của user
        arrayListId = new ArrayList();
        arrayListName = new ArrayList();

        edit_name = findViewById(R.id.edit_name);
        btn_add = findViewById(R.id.btn_add);
        btn_remove = findViewById(R.id.btn_remove);
        btn_cancel = findViewById(R.id.btn_cancel);
        listViewName = findViewById(R.id.listViewName);

        getArrayListName();

        adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                arrayListName);

        listViewName.setAdapter(adapter);

        /**
         * Tạo sự kiện cho button Add
         * Add một user mới cho DataUser
         * Gọi là hàm getArrayListName để clear toàn bộ ArrayList rồi cập nhật dữ liệu mới
         * qua từng user trong DataUser
         */
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataUser.addUser(new User(edit_name.getText().toString()));
                getArrayListName();
                adapter.notifyDataSetChanged();
            }
        });

        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,
                        "Xoá dòng " + arrayListId.get(posSelect) + " thành công!",
                        Toast.LENGTH_SHORT).show();

                dataUser.removeUser((int) arrayListId.get(posSelect));
                getArrayListName();
                adapter.notifyDataSetChanged();
            }
        });

        listViewName.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                posSelect = i;
            }
        });
    }

    /**
     * Clear toàn bộ ArrayList
     * Dùng lại hàm getAll tạo bên DataUser để lấy ra dữ liệu
     * Add vào ArrayList id, name của từng user được lấy ra
     * @return
     */
    private ArrayList getArrayListName() {
        arrayListId.clear();
        arrayListName.clear();
        for (Iterator iterator = dataUser.getAll().iterator(); iterator.hasNext(); ) {
            User user = (User) iterator.next();
            arrayListId.add(user.getId());
            arrayListName.add(user.getName());
        }
        return arrayListName;
    }
}
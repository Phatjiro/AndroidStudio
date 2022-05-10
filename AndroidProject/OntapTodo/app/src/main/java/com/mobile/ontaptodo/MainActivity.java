package com.mobile.ontaptodo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.QueryDocumentSnapshot;
//
//import java.util.ArrayList;
//import java.util.List;
//
//    public class MainActivity extends AppCompatActivity {
//        private User user;
//        private String userId;
//
//        private TodoAdapter todoAdapter;
//
//        private TextView txvUsername;
//        private ListView listView;
//
//        private FirebaseAuth firebaseAuth;
//        private FirebaseFirestore firestore;
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_main);
//
//            initUIComponents();
//
//            loadToDoListData();
//        }
//
//        private void initUIComponents(){
//            userId = getIntent().getExtras().getString("userId");
//            user = (User) getIntent().getSerializableExtra("userInfo");
//
//            firebaseAuth = FirebaseAuth.getInstance();
//            firestore = FirebaseFirestore.getInstance();
//
//            txvUsername = findViewById(R.id.txvUsername);
//            txvUsername.setText(user.getName());
//
//            listView = findViewById(R.id.todoListView);
//        }
//
//        private void loadToDoListData(){
//            firestore.collection("todoes")
//                    .whereEqualTo("user_id", userId).get()
//                    .addOnSuccessListener(snaps -> {
//                        List<Todo> todoList = new ArrayList<>();
//
//                        for (QueryDocumentSnapshot snap : snaps) {
//                            System.out.println(snap.toObject(Todo.class));
//                            todoList.add(snap.toObject(Todo.class));
//                        }
//
//                        renderTodoListToListView(todoList);
//                    });
//        }
//
//        private void renderTodoListToListView(List<Todo> data){
//            todoAdapter = new TodoAdapter(
//                    getApplicationContext(),
//                    R.layout.todo_item,
//                    data
//            );
//
//            listView.setAdapter(todoAdapter);
//        }
//    }
}
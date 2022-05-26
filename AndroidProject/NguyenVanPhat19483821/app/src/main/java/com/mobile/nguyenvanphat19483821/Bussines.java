package com.mobile.nguyenvanphat19483821;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class Bussines extends AppCompatActivity {

    EditText tfBookName;
    Button btnAddBook;

    private BookAdapter bookAdapter;
    private ListView listView;

    FirebaseAuth mAuth;
    FirebaseFirestore db;

    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bussines);

        tfBookName = (EditText) findViewById(R.id.tfBookName);
        btnAddBook = (Button) findViewById(R.id.btnAddBook);

        tfBookName.setText("Doraemon");

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        btnAddBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewBook();
            }
        });
    }

    public void createNewBook() {
        String bookName = tfBookName.getText().toString().trim();

        if (TextUtils.isEmpty(bookName)) {
            tfBookName.setError("Book name can't be empty!");
            tfBookName.requestFocus();
        } else {
            userID = mAuth.getCurrentUser().getUid();
            DocumentReference reference = db.collection("Book").document();

            Book book = new Book(1, bookName);

            reference.set(book).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(Bussines.this, "Save data to FireStore successfully!", Toast.LENGTH_LONG).show();
                }
            });
        }
    }

//    private void loadToDoListData(){
//        db.collection("Book")
//                .document().get()
//                .addOnSuccessListener(snaps -> {
//                    List<Book> bookList = new ArrayList<>();
//
//                    for (QueryDocumentSnapshot snap : snaps) {
//                        System.out.println(snap.toObject(Book.class));
//                        bookList.add(snap.toObject(Book.class));
//                    }
//
//                    renderTodoListToListView(bookList);
//                });
//    }
//
//    private void renderTodoListToListView(List<Book> data){
//        bookAdapter = new BookAdapter(
//                getApplicationContext(),
//                R.layout.item_sach,
//                data
//        );
//
//        listView.setAdapter(bookAdapter);
//    }
}
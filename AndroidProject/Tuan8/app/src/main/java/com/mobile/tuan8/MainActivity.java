package com.mobile.tuan8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "TestUser").build();

        User user1 = new User(1, "Van Phat", "Nguyen");
        User user2 = new User(2, "Van Tuong", "Nguyen");

        UserDao userDao = db.userDao();

        userDao.insertAll();

        List<User> users = userDao.getAll();

        System.out.println(users);
    }
}
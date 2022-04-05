package com.mobile.labtuan7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataUser extends SQLiteOpenHelper {
    public DataUser(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =
                "CREATE TABLE user ( "
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL)";
        sqLiteDatabase.execSQL(sql);
    }

    // Add user
    public void addUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user.getName());

        sqLiteDatabase.insert("user", null, values);
    }

    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(0);
                user.setName(cursor.getString(1));

                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return userList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

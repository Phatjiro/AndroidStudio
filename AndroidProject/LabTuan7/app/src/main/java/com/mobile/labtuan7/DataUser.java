package com.mobile.labtuan7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Tạo class DataUser để khởi tạo SQLite
 */

public class DataUser extends SQLiteOpenHelper {
    public DataUser(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    /**
     * Override lại hàm onCreate để khởi tạo table sql
     * @param sqLiteDatabase
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Tạo câu lệnh String sql để khởi tạo table
        String sql =
                "CREATE TABLE user ( "
                + "id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,"
                + "name TEXT NOT NULL)";
        sqLiteDatabase.execSQL(sql);
    }

    /**
     * Sử dụng SQLiteDatabase để đọc database
     * Sau đó dùng ContentValues tạo put dữ liệu vào database "user"
     * @param user
     */
    public void addUser(User user) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", user.getName());

        sqLiteDatabase.insert("user", null, values);
    }

    /**
     * Tạo ArrayList cho user
     * Dùng câu lệnh SELECT * FROM user để xuất hết dữ liệu trong database
     * Nếu là lần đầu thì khởi tạo new User rồi add vào ArrayList vừa tạo ở trên
     * @return
     */
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        String sql = "SELECT * FROM user";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));

                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        sqLiteDatabase.close();
        return userList;
    }

    /**
     * Hàm xoá dữ liệu trong database
     * Tạo kết nối đọc databse rồi delete qua id
     * @param id
     */
    public int removeUser(int id) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        return sqLiteDatabase.delete(
                "user",
                "id = ?",
                new String[] {String.valueOf(id)}
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

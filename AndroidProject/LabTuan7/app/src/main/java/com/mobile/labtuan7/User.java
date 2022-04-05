package com.mobile.labtuan7;

/**
 * Tạo đối tượng user để lưu trữ thông tin
 * Hàm constructor, get/set cơ bản
 */

public class User {
    private int id;
    private String name;

    public User() {

    }
    public User(String name) {
        this.name = name;
    }
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.mobile.ontaptodo;

public class Todo {
    private String user_id;
    private String name;
    private boolean completed;
    private String content;

    public Todo() {
    }

    public Todo(String user_id, String name, boolean completed, String content) {
        this.user_id = user_id;
        this.name = name;
        this.completed = completed;
        this.content = content;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "user_id='" + user_id + '\'' +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                ", content='" + content + '\'' +
                '}';
    }
}

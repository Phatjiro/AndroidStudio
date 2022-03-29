package com.mobile.lab005;

import java.io.Serializable;

public class Donut implements Serializable {
    private int donutIdImg;
    private String donutName;

    public Donut(int donutIdImg, String donutName) {
        this.donutIdImg = donutIdImg;
        this.donutName = donutName;
    }

    public int getDonutIdImg() {
        return donutIdImg;
    }

    public void setDonutIdImg(int donutIdImg) {
        this.donutIdImg = donutIdImg;
    }

    public String getDonutName() {
        return donutName;
    }

    public void setDonutName(String donutName) {
        this.donutName = donutName;
    }

    @Override
    public String toString() {
        return "Donut{" +
                "donutIdImg=" + donutIdImg +
                ", donutName='" + donutName + '\'' +
                '}';
    }
}

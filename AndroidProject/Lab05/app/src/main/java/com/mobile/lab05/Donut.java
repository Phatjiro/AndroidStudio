package com.mobile.lab05;

import java.io.Serializable;

public class Donut implements Serializable {
    private int donutImgId;
    private String donutName;

    public Donut(int donutImgId, String donutName) {
        this.donutImgId = donutImgId;
        this.donutName = donutName;
    }

    public int getDonutImgId() {
        return donutImgId;
    }

    public void setDonutImgId(int donutImgId) {
        this.donutImgId = donutImgId;
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
                "donutImgId='" + donutImgId + '\'' +
                ", donutName='" + donutName + '\'' +
                '}';
    }
}

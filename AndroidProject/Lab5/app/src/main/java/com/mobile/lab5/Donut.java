package com.mobile.lab5;

public class Donut {
    private String dnImg;
    private String dnName;
    private String dnDetail;
    private String dnCost;

    public Donut(String dnImg, String dnName, String dnDetail, String dnCost) {
        this.dnImg = dnImg;
        this.dnName = dnName;
        this.dnDetail = dnDetail;
        this.dnCost = dnCost;
    }

    public String getDnImg() {
        return dnImg;
    }

    public void setDnImg(String dnImg) {
        this.dnImg = dnImg;
    }

    public String getDnName() {
        return dnName;
    }

    public void setDnName(String dnName) {
        this.dnName = dnName;
    }

    public String getDnDetail() {
        return dnDetail;
    }

    public void setDnDetail(String dnDetail) {
        this.dnDetail = dnDetail;
    }

    public String getDnCost() {
        return dnCost;
    }

    public void setDnCost(String dnCost) {
        this.dnCost = dnCost;
    }

    @Override
    public String toString() {
        return "Donut{" +
                "dnImg='" + dnImg + '\'' +
                ", dnName='" + dnName + '\'' +
                ", dnDetail='" + dnDetail + '\'' +
                ", dnCost='" + dnCost + '\'' +
                '}';
    }
}

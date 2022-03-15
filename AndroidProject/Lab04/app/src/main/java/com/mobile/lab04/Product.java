package com.mobile.lab04;

public class Product {
    private String prdImg;
    private String prdName;
    private String prdSupplier;

    public Product(String prdImg, String prdName, String prdSupplier) {
        this.prdImg = prdImg;
        this.prdName = prdName;
        this.prdSupplier = prdSupplier;
    }

    public Product() {
    }

    public String getPrdImg() {
        return prdImg;
    }

    public void setPrdImg(String prdImg) {
        this.prdImg = prdImg;
    }

    public String getPrdName() {
        return prdName;
    }

    public void setPrdName(String prdName) {
        this.prdName = prdName;
    }

    public String getPrdSupplier() {
        return prdSupplier;
    }

    public void setPrdSupplier(String prdSupplier) {
        this.prdSupplier = prdSupplier;
    }


    @Override
    public String toString() {
        return "Product{" +
                "prdImg='" + prdImg + '\'' +
                ", prdName='" + prdName + '\'' +
                ", prdSupplier='" + prdSupplier + '\'' +
                '}';
    }
}

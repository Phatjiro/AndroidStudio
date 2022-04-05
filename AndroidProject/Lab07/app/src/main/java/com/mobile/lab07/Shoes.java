package com.mobile.lab07;

public class Shoes {
    private int idImg;
    private String name;
    private String detail;

    public Shoes(int idImg, String name, String detail) {
        this.idImg = idImg;
        this.name = name;
        this.detail = detail;
    }

    public int getIdImg() {
        return idImg;
    }

    public void setIdImg(int idImg) {
        this.idImg = idImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Shoes{" +
                "idImg=" + idImg +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}

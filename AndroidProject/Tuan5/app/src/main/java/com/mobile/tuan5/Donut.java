package com.mobile.tuan5;

public class Donut {
    private int imgID;
    private String tenDonut, moTaDonut;
    private Double giaTienDonut;

    public Donut(int imgID, String tenDonut, String moTaDonut, Double giaTienDonut) {
        this.imgID = imgID;
        this.tenDonut = tenDonut;
        this.moTaDonut = moTaDonut;
        this.giaTienDonut = giaTienDonut;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getTenDonut() {
        return tenDonut;
    }

    public void setTenDonut(String tenDonut) {
        this.tenDonut = tenDonut;
    }

    public String getMoTaDonut() {
        return moTaDonut;
    }

    public void setMoTaDonut(String moTaDonut) {
        this.moTaDonut = moTaDonut;
    }

    public Double getGiaTienDonut() {
        return giaTienDonut;
    }

    public void setGiaTienDonut(Double giaTienDonut) {
        this.giaTienDonut = giaTienDonut;
    }
}

package com.mobile.onthicoban;

public class SanPham {
    private String idSanPham;
    private String tenSP;
    private String chiTietSP;

    public SanPham() {
    }

    public SanPham(String idSanPham, String tenSP, String chiTietSP) {
        this.idSanPham = idSanPham;
        this.tenSP = tenSP;
        this.chiTietSP = chiTietSP;
    }

    public String getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(String idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getChiTietSP() {
        return chiTietSP;
    }

    public void setChiTietSP(String chiTietSP) {
        this.chiTietSP = chiTietSP;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "idSanPham='" + idSanPham + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", chiTietSP='" + chiTietSP + '\'' +
                '}';
    }
}

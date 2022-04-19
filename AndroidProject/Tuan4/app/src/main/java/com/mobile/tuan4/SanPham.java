package com.mobile.tuan4;

public class SanPham {
    private int imgID;
    private String tenSanPham, tenShop;

    public SanPham(int imgID, String tenSanPham, String tenShop) {
        this.imgID = imgID;
        this.tenSanPham = tenSanPham;
        this.tenShop = tenShop;
    }

    public int getImgID() {
        return imgID;
    }

    public void setImgID(int imgID) {
        this.imgID = imgID;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getTenShop() {
        return tenShop;
    }

    public void setTenShop(String tenShop) {
        this.tenShop = tenShop;
    }
}

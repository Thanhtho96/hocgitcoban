/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.model;

/**
 *
 * @author Lordđ
 */
public class ChiTietHangXuat extends ChiTietNhapXuat {

    private String diaChiXuat;
    private SanPham thongTinSPXuat;
    private int index;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getDiaChi() {
        return diaChiXuat;
    }

    public void setDiaChi(String diaChi) {
        this.diaChiXuat = diaChi;
    }

    public SanPham getThongTinSPXuat() {
        return thongTinSPXuat;
    }

    public void setThongTinSPXuat(SanPham thongTinSPXuat) {
        this.thongTinSPXuat = thongTinSPXuat;
    }


}

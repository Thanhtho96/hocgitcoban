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
public class ChiTietHangNhap extends ChiTietNhapXuat {

    private String nhaCungCap;
    private SanPham thongTinSPNhap;
    private int tonTai;

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }

    public SanPham getThongTinSPNhap() {
        return thongTinSPNhap;
    }

    public void setThongTinSPNhap(SanPham thongTinSPNhap) {
        this.thongTinSPNhap = thongTinSPNhap;
    }

    public int getTonTai() {
        return tonTai;
    }

    public void setTonTai(int tonTai) {
        this.tonTai = tonTai;
    }


}

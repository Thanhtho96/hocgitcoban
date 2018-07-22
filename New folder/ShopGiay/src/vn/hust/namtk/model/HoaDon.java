/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HoaDon {

    private int soLuong;
    private SanPham thongTinSP;
    private Date ngayTao;
    private String idNhanVien;

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public SanPham getThongTinSP() {
        return thongTinSP;
    }

    public void setThongTinSP(SanPham thongTinSP) {
        this.thongTinSP = thongTinSP;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao() {
        this.ngayTao = new Date();
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public double thanhTien() {
        return (soLuong * thongTinSP.getGiaBan());
    }

    public void show() {
        System.out.println("Sản phẩm: " + thongTinSP.getTenGiay());
        System.out.println("ID: " + thongTinSP.getMaGiay());
        System.out.println("Ngày: " + (new SimpleDateFormat("dd/MM/yyyy   hh:MM").format(ngayTao)));
        System.out.println("Nhân viên: "+idNhanVien);
        System.out.println("Số lượng: "+soLuong);
        System.out.println("Giá: "+thongTinSP.getGiaBan());
        System.out.println("THÀNH TIỀN: "+ thanhTien());
    }
}

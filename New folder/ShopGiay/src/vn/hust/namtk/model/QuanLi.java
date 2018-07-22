/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.model;

import vn.hust.namtk.model.NhanVien;

/**
 *
 * @author Admin
 */
public class QuanLi extends NhanVien {

    private float luongQL;

    public QuanLi() {
    }

    public float tinhLuong() {
        luongQL = luongcb+5;
        return luongQL;
    }

    public QuanLi(String id, String ten, byte tuoi, float luong) {
        super(id, ten, tuoi);
        this.luongQL = luong;
    }

    public void InPhieu(){
        
    }
    
    public void QuanLiKhachHang(){
        
    }
    public void QuanLiNhanVien(){
        System.out.println("nhap ten nv");
        
    }
    public void QuanLiSanPham(){
        
    }
    
    public void QuanLiDoanhThu(){
        
    }
}

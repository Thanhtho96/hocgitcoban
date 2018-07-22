/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.model;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class NhanVien {

    private String id;
    private String ten;
    private byte tuoi;
    float luongcb;
    public NhanVien() {
    }

    public NhanVien(String id, String ten, byte tuoi) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
    }
    

    public NhanVien(String id, String ten, byte tuoi, float luong) {
        this.id = id;
        this.ten = ten;
        this.tuoi = tuoi;
        this.luongcb = luong;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public byte getTuoi() {
        return tuoi;
    }

    public void setTuoi(byte tuoi) {
        this.tuoi = tuoi;
    }

    public float getLuong() {
        return luongcb;
    }

    public void setLuong(float luong) {
        this.luongcb = luong;
    }

    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lordđ
 */
public class ChiTietNhapXuat {
    private double giaSP;
    private String soPhieu;
    private Date ngayTao;
    private int soLuong;
    private String maHangHoa;


    public double getGiaSP() {
        return giaSP;
    }

    public void setGiaSP(double giaSP) {
        this.giaSP = giaSP;
    }
    
    
    public String getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(String soPhieu) {
        this.soPhieu = soPhieu;
    }

    private DateFormat day(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat;
    }

    public void setNgayTao() {
        ngayTao = new Date();
    }
    
    public Date getDateNgayTao(){
        Date date = null;
        try {
            date = new SimpleDateFormat("dd/MM/yyyy").parse(getStringNgayTao());
        } catch (ParseException ex) {
            Logger.getLogger(ChiTietNhapXuat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return date;
    }
    
    public String getStringNgayTao() {
        return day().format(ngayTao);
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }


    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
    }

    
    public double thanhTien(double donGia){
        return (donGia * soLuong);
    }
    
}

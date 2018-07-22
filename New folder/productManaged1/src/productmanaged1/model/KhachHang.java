/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanaged1.model;

import java.util.Scanner;

/**
 *
 * @author Xuan
 */
public class KhachHang extends Person{
    private String MaKH;
    private HoaDon DonHang;

    public KhachHang() {
    }

    public KhachHang(String MaKH, HoaDon DonHang, String name, String phone, String address, String dob) {
        super(name, phone, address, dob);
        this.MaKH = MaKH;
        this.DonHang = DonHang;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public HoaDon getDonHang() {
        return DonHang;
    }

    public void setDonHang(HoaDon DonHang) {
        this.DonHang = DonHang;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        System.out.println("Nhập mã khách hàng:");
        this.MaKH= new Scanner(System.in).nextLine();
        
    }
    

    @Override
    public String toString() {
        return "KhachHang{" + "MaKH=" + MaKH + ", DonHang=" + DonHang + '}';
    }
    
}

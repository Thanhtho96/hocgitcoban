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
public class Product implements IBasic{
    private String ID;
    private String tenSP;
    private String thuongHieu;
    private String xuatXu;
    private double donGia;

    public Product() {
    }

    public Product(String ID, String tenSP, String thuongHieu, String xuatXu, double donGia) {
        this.ID = ID;
        this.tenSP = tenSP;
        this.thuongHieu = thuongHieu;
        this.xuatXu = xuatXu;
        this.donGia = donGia;
    }

    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("nhap ID:");
        this.ID= new Scanner(System.in).nextLine();
        System.out.println("nhap tenSP: ");
        this.tenSP=new Scanner(System.in).nextLine();
        System.out.println("nhap thuong hieu: ");
        this.thuongHieu= new Scanner(System.in).nextLine();
        System.out.println("nhap xuat xu: ");
        this.xuatXu= new Scanner(System.in).nextLine();
        System.out.println("nhap don gia:");
        this.donGia=new Scanner(System.in).nextDouble();
    }

    @Override
    public void inThongTin() {
        System.out.println("ID:" +this.ID);
        System.out.println("tenSP: "+this.tenSP);
        System.out.println("thuong hieu: "+this.thuongHieu);
        System.out.println("xuat xu: "+this.xuatXu);
        System.out.println("don gia: "+this.donGia);
        
    }

   public Double getThueNhapKhau() {
double vat =0;
vat = this.donGia * 0.1; 

return vat;
} 
    
}


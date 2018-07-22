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
public class SanPham {
    private String maGiay;
    private String tenGiay;
    private String xuatXu;
    private double giaBan;
    private int soLuong;
    
    public SanPham() {
    }

    public SanPham(String maGiay, String tenGiay, String xuatXu, double giaBan, int soLuong, byte giamgia) {
        this.maGiay = maGiay;
        this.tenGiay = tenGiay;
        this.xuatXu = xuatXu;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }
    

    public String getMaGiay() {
        return maGiay;
    }

    public void setMaGiay(String maGiay) {
        this.maGiay = maGiay;
    }

    public String getTenGiay() {
        return tenGiay;
    }

    public void setTenGiay(String tenGiay) {
        this.tenGiay = tenGiay;
    }

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }
    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public void tangSoLuong(int soLuong){
        this.soLuong += soLuong;
    }
    
    public void giamSoLuong(int soLuong){
        this.soLuong -= soLuong;
    }

    
    public void nhaphang(){
        System.out.println("Ma Giay:");maGiay=new Scanner(System.in).nextLine();
        System.out.println("Ten Giay:");tenGiay=new Scanner(System.in).nextLine();
        System.out.println("Xuất xứ :");xuatXu=new Scanner(System.in).nextLine();
        System.out.println("Gia bán:");giaBan=new Scanner(System.in).nextDouble();
        System.out.println("Số lượng:");soLuong=new Scanner(System.in).nextByte();
    }

    @Override
    public String toString() {
        return "maGiay=" + maGiay + "\ntenGiay=" + tenGiay  + "\n xuatSu=" + xuatXu  +"\n soLuong=" +soLuong+ "\n giaBan=" + giaBan;
    }
    
    public  void output(){
        System.out.println(toString());
    }
    
    
    
    
}

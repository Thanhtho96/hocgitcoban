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
public class Shoes extends Product{
    public String mauSac;
    public boolean gioiTinh;
    public chatLieu chatLieu;

    public Shoes() {
    }

    public Shoes(String mauSac, boolean gioiTinh, chatLieu chatLieu, String ID, String tenSP, 
            String thuongHieu, String xuatXu, double donGia) {
        super(ID, tenSP, thuongHieu, xuatXu, donGia);
        this.mauSac = mauSac;
        this.gioiTinh = gioiTinh;
        this.chatLieu = chatLieu;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public chatLieu getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(chatLieu chatLieu) {
        this.chatLieu = chatLieu;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin(); 
        System.out.println("nhap mau sac:");
        this.mauSac= new Scanner(System.in).nextLine();
        System.out.println("gioi tinh:");
        
    }
    
    @Override
    public void inThongTin() {
        super.inThongTin(); 
        System.out.println("ID:"+this.getID());
        System.out.println("mau sac:"+this.mauSac);
        System.out.println("thuong hieu"+this.getThuongHieu());
        System.out.println("xuat xu: "+this.getXuatXu());
        System.out.println("gioi tinh"+ this.gioiTinh);
        System.out.println("chat lieu: "+this.chatLieu);
    }

    
    
    public void showInfo(){
        System.out.println("Thong tin cua giay: ");
    }
    
}

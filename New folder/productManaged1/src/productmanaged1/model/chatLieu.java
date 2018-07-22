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
public class chatLieu implements IBasic{
    private String deGiay;
    private String thanGiay;

    public String getDeGiay() {
        return deGiay;
    }

    public void setDeGiay(String deGiay) {
        this.deGiay = deGiay;
    }

    public String getThanGiay() {
        return thanGiay;
    }

    public void setThanGiay(String thanGiay) {
        this.thanGiay = thanGiay;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("chat lieu than giay: ");
        this.thanGiay= new Scanner(System.in).nextLine();
        System.out.println("chat lieu de giay: ");
        this.deGiay= new Scanner(System.in).nextLine();
    }

    @Override
    public void inThongTin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}

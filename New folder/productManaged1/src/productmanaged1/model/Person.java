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
public class Person implements IBasic{
    private String name;
    private String phone;
    private String address;
    private String dob;

    public Person() {
    }

    public Person(String name, String phone, String address, String dob) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
    

    @Override
    public void nhapThongTin() {
        System.out.println("nhap ho ten:");
        this.name= new Scanner(System.in).nextLine();
        System.out.println("nhap dia chi:");
        this.address= new Scanner(System.in).nextLine();
        System.out.println("nhap ngay sinh:");
        this.dob= new Scanner(System.in).nextLine();
        System.out.println("nhap so dien thoai:");
        this.phone= new Scanner(System.in).nextLine();
    }

    @Override
    public void inThongTin() {
        System.out.println("ho ten:"+this.name);
        System.out.println("dia chi:"+this.address);
        System.out.println("ngay sinh:"+this.dob);
        System.out.println("so dien thoai:"+this.phone);
    }
}


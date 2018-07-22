/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.model;

import java.util.Scanner;

/**
 *
 * @author Bibi
 */
public abstract class Person {

    protected String name, phone;
    protected Integer born;

    public Person() {
    }

    public Person(String name, String phone, Integer born) {
        this.name = name;
        this.phone = phone;
        this.born = born;
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

    public Integer getBorn() {
        return born;
    }

    public void setBorn(Integer born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", phone=" + phone + ", born=" + born + '}';
    }

    public void getInfo() {
    }

    public void showInfo() {
        System.out.println("Họ tên: " + this.name);
        System.out.println("SĐT: " + this.phone);
        System.out.println("Năm sinh: " + this.born);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.model;

/*
 * @author Dao
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Bill extends Product {
    
    private int billID;
    private Date date;
    private double totalMoney;
    private double totalBill;
    private int number;

    public Bill() {
    }
    
    public Bill(int billID, Date date, double totalMoney, double totalBill, int number) {
        this.billID = billID;
        this.date = date;
        this.totalMoney = totalMoney;
        this.totalBill = totalBill;
        this.number = number;
    }

     public Bill(int billID, Date date, double totalMoney, double totalBill, int number, int productID, String productName, double productPrice, String color, double weight) {
        super(productID, productName, productPrice,  color, weight);
        this.billID = billID;
        this.date = date;
        this.totalMoney = totalMoney;
        this.totalBill = totalBill;
        this.number = number;
    }

    public Bill(int billID, Date date, double totalMoney, int number, int productID, String productName, double productPrice, String color, double weight) {
        super(productID, productName, productPrice,  color, weight);
        this.billID = billID;
        this.date = date;
        this.totalMoney = totalMoney;
        this.number = number;
    }

    public int getBillID() {
        return billID;
    }

    public void setBillID(int billID) {
        this.billID = billID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Bill{" + "billID=" + billID + ", date=" + date + ", totalMoney=" + totalMoney + ", totalBill=" + totalBill + ", number=" + number + '}';
    }
    
}

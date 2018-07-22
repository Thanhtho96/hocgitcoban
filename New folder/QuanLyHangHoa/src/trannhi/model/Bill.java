/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.model;

import java.util.Date;

/**
 *
 * @author Tran Nhi
 */
public class Bill extends Product{
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

    public Bill(int billID, Date date, double totalMoney, double totalBill, int number, int productID, String productName, double productPrice, String color, String size) {
        super(productID, productName, productPrice,  color, size);
        this.billID = billID;
        this.date = date;
        this.totalMoney = totalMoney;
        this.totalBill = totalBill;
        this.number = number;
    }

    public Bill(int billID, Date date, double totalMoney, int number, int productID, String productName, double productPrice, String color, String size) {
        super(productID, productName, productPrice,  color, size);
        this.billID = billID;
        this.date = date;
        this.totalMoney = totalMoney;
        this.number = number;
    }
    
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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

    @Override
    public String toString() {
        return "Bill{" + "billID=" + billID + ", date=" + date + ", totalMoney=" + totalMoney +  ", number=" + number + '}';
    }
    
    
}

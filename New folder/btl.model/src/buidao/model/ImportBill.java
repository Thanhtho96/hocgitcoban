/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dao
 */
public class ImportBill extends Product{
    private int id;
    private Date date;
    private double totalMoney;
    private double totalMoneyImportBill;
    private double importPrice;
    private int number;

    public ImportBill() {
    }
    
    public ImportBill(int id,  Date date, double totalMoney, double totalMoneyImportBill, double importPrice, int number) {
        this.id = id;
        this.date = date;
        this.totalMoney = totalMoney;
        this.totalMoneyImportBill = totalMoneyImportBill;
        this.importPrice = importPrice;
        this.number = number;
    }

    public ImportBill(int id,  Date date, double totalMoney, double importPrice, int number, int productID, String productName, double productPrice, String color, double weight) {
        super(productID, productName, productPrice,  color, weight);
        this.id = id;
        this.date = date;
        this.totalMoney = totalMoney;
        
        this.importPrice = importPrice;
        this.number = number;
    }
    
    public ImportBill(int id,  Date date, double totalMoney, double totalMoneyImportBill, double importPrice, int number, int productID, String productName, double productPrice, String color, double weight) {
        super(productID, productName, productPrice,  color, weight);
        this.id = id;
        this.date = date;
        this.totalMoney = totalMoney;
        this.totalMoneyImportBill = totalMoneyImportBill;
        this.importPrice = importPrice;
        this.number = number;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTotalMoneyImportBill() {
        return totalMoneyImportBill;
    }

    public void setTotalMoneyImportBill(double totalMoneyImportBill) {
        this.totalMoneyImportBill = totalMoneyImportBill;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ImportBill{" + "id=" + id + ", date=" + date + ", totalMoney=" + totalMoney + ", totalMoneyImportBill=" + totalMoneyImportBill + ", importPrice=" + importPrice + ", number=" + number + '}';
    }
    
}

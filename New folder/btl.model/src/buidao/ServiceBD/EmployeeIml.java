/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.ServiceBD;

import java.util.ArrayList;
import buidao.model.Bill;
import buidao.model.ImportBill;
import buidao.model.Product;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author DAo NGo
 */
public class EmployeeIml implements InterBill, InterImportBill, InterEmployee, InterProduct{

    private String[] Bill;

    @Override
    public void showBill() {
        for (Bill Bill : listBill) {
            System.out.println("Danh sách hóa đơn bán hàng: \n");
            System.out.println(Bill.toString());
            
        }
    }

    @Override
    public void showImportBill() {
       for (ImportBill importBill : listImportBill) {
            System.out.println("Danh sách hóa đơn nhập hàng: \n");
            System.out.println(importBill.toString());
            
        }
    }

    @Override
    public void makeBill() {
        double totalMoney = 0;
        double totalBill = 0;
        int n;
        
        try {
            System.out.println("Mời nhập hóa đơn: ");
            int billID = new Scanner(System.in).nextInt();
            do {        
                System.out.println("Thao tác: ");
                System.out.println("1. Nhập");
                System.out.println("2. Thoát");
                System.out.println("Mời chọn thao tác: ");
                n = new Scanner(System.in).nextInt();
                
                switch (n) {
                    case 1:
                        Date date = new Date();
                        System.out.println("Mời nhập id sản phẩm: ");
                        int productID = new Scanner(System.in).nextInt();
                        System.out.println("Mời nhập tên sản phẩm : ");
                        String productName = new Scanner(System.in).next();
                        System.out.println("Mời nhập màu sắc sản phẩm: ");
                        String color = new Scanner(System.in).next();
                        System.out.println("Mời nhập giá sản phẩm: ");
                        double productPrice = new Scanner(System.in).nextDouble();
                         System.out.println("Mời nhập trọng lượng xe: ");
                        double weight = new Scanner(System.in).nextDouble();
                        System.out.println("Mời nhập số lượng: ");
                        int number = new Scanner(System.in).nextInt();
                        totalMoney = number * productPrice;
                        totalBill = totalBill + totalMoney;

                        Bill Bill = new Bill(billID, date, totalMoney,  number, productID, productName, productPrice, color, weight);
                        listBill.add(Bill);
                        break;
                    case 2:
                        System.out.println("Bạn chọn thoát!");
                        break;
                }
                
            } while (n==1);
            
            System.out.println("Tổng tiền hóa đơn là: "+totalBill);
            
        } catch (Exception e) {
            
            System.out.println("Nhập sai dữ liệu. Mời bạn nhập lại");
        }
    }

    @Override
    public void makeImportBill() {
        int n;
        double totalMoney = 0;
        double totalMoneyImportBill = 0;
        
        try {
            System.out.println("Mời nhập id sản phẩm: ");
            int ID = new Scanner(System.in).nextInt();
        
            do{

                System.out.println("Thao tác: ");
                System.out.println("1. Nhập");
                System.out.println("2. Thoát");
                System.out.println("Mời chọn thao tác: ");
                n = new Scanner(System.in).nextInt();
                switch(n){
                    case 1:
                        Date date = new Date();
                        System.out.println("Mời nhập id sản phẩm: ");
                        int productID = new Scanner(System.in).nextInt();
                        System.out.println("Mời bạn nhập tên sản phẩm: ");
                        String productName = new Scanner(System.in).next();
                        System.out.println("Mời nhập màu sắc sản phẩm: ");
                        String color = new Scanner(System.in).next();
                        System.out.println("Mời nhập giá sản phẩm: ");
                        double importPrice = new Scanner(System.in).nextDouble();
                        System.out.println("Mời nhập giá bán: ");
                        double productPrice = new Scanner(System.in).nextDouble();
                        System.out.println("Mời nhập trọng lượng: ");
                        double weight = new Scanner(System.in).nextDouble();
                        System.out.println("Mời nhập số lượng: ");
                        int number = new Scanner(System.in).nextInt();
                        totalMoney = number * importPrice;
                        totalMoneyImportBill = totalMoneyImportBill + totalMoney;
                        Product product = new Product(productID, productName, productPrice, color, weight);
                        listProduct.add(product);
                        ImportBill importBill = new ImportBill(ID,  date, totalMoney,  importPrice, number,  productID, productName, productPrice, color, weight);
                        listImportBill.add(importBill);
                        break;
                    case 2:
                        break;
                }
            }while (n <2 && n>0);

            System.out.println("Tổng tiền của hóa đơn là: "+totalMoneyImportBill);
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu. Mời bạn nhập lại");
        }
    }

    @Override
    public void showProduct() {
       for (Product product : listProduct) {
            System.out.println("Danh sách hàng hóa: \n");
            System.out.println(product.toString());
           
        }
    }

    @Override
    public void find(int productID) {
        for (int i = 0; i<listBill.size(); i++)
               {
                   if(listBill.get(i).getBillID() == productID)
                   {
                       System.out.println(listBill.get(i).toString());
                   }
                   
               }
    }
}
 

 

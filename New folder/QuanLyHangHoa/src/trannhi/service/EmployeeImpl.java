/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import trannhi.model.Bill;
import trannhi.model.ImportBill;
import trannhi.model.Product;

/**
 *
 * @author Tran Nhi
 */
public class EmployeeImpl implements IEmployee,IProduct,IImportBill,IBill{
    
    
    
    @Override
    public void makeBill() {
        double totalMoney = 0;
        double totalBill = 0;
        int n;
        
        try {
            System.out.println("Moi nhap ID hoa don: ");
            int billID = new Scanner(System.in).nextInt();
        
            do{
                System.out.println("Thao tác: ");
                System.out.println("1. Nhập");
                System.out.println("2. Thoát");
                System.out.println("Mời chọn thao tác: ");
                n = new Scanner(System.in).nextInt();
                switch (n) {
                    case 1:
                        Date date = new Date();
                        System.out.println("Mời nhập ID sản phẩm: ");
                        int productID = new Scanner(System.in).nextInt();
                        System.out.println("Mời nhập tên sản phẩm: ");
                        String productName = new Scanner(System.in).next();
                        System.out.println("Mời nhập màu sắc sản phẩm: ");
                        String color = new Scanner(System.in).next();
                        System.out.println("Mời nhập size sản phẩm: ");
                        String size = new Scanner(System.in).next();
                        System.out.println("Mời nhập giá sản phẩm: ");
                        double productPrice = new Scanner(System.in).nextDouble();
                        System.out.println("Mời nhập số lượng: ");
                        int number = new Scanner(System.in).nextInt();
                        totalMoney = number * productPrice;
                        totalBill = totalBill + totalMoney;

                        Bill Bill = new Bill(billID, date, totalMoney,  number, productID, productName, productPrice, color, size);
                        listBill.add(Bill);
                        break;
                    case 2:
                        System.out.println("Bạn chọn thoát!");
                        break;
                }

            }while (n == 1);
            
            System.out.println("Tổng tiền hóa đơn là: "+totalBill);
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu. Mời nhập lại");
        }
        
        
        
            
        
    
    }

    @Override
    public void makeImportBill() {
        
        int n;
        double totalMoney = 0;
        double totalMoneyImportBill = 0;
        
        try {
            System.out.println("Mời nhập ID hóa đơn: ");
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
                        System.out.println("Mời nhập ID sản phẩm: ");
                        int productID = new Scanner(System.in).nextInt();
                        System.out.println("Mời nhập tên sản phẩm: ");
                        String productName = new Scanner(System.in).next();
                        System.out.println("Mời nhập màu sắc sản phẩm: ");
                        String color = new Scanner(System.in).next();
                        System.out.println("Mời nhập size sản phẩm: ");
                        String size = new Scanner(System.in).next();
                        System.out.println("Mời nhập giá nhập: ");
                        double importPrice = new Scanner(System.in).nextDouble();
                        System.out.println("Mời nhập giá bán: ");
                        double productPrice = new Scanner(System.in).nextDouble();
                        System.out.println("Mời nhập số lượng: ");
                        int number = new Scanner(System.in).nextInt();
                        totalMoney = number * importPrice;
                        totalMoneyImportBill = totalMoneyImportBill + totalMoney;
                        Product product = new Product(productID, productName, productPrice, color, size);
                        listProduct.add(product);
                        ImportBill importBill = new ImportBill(ID,  date, totalMoney,  importPrice, number,  productID, productName, productPrice, color, size);
                        listImportBill.add(importBill);
                        break;
                    case 2:
                        break;
                }

            }while (n <2 && n>0);

            System.out.println("Tổng tiền hóa đơn là: "+totalMoneyImportBill);
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu. Mời nhập lại");
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
    public void showImportBill() {
        for (ImportBill importBill : listImportBill) {
            System.out.println("Danh sách hóa đơn nhập: \n");
            System.out.println(importBill.toString());
            
        }
    }

    @Override
    public void showBill() {
        for (Bill Bill : listBill) {
            System.out.println("Danh sách hóa đơn: \n");
            System.out.println(Bill.toString());
            
        }
    }
    
    
}

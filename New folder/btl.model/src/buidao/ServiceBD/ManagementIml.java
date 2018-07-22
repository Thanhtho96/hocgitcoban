/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.ServiceBD;

import buidao.model.Bill;
import buidao.model.Employees;
import buidao.model.ImportBill;
import buidao.model.Product;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DAo NGo
 */
public class ManagementIml implements InterManagement, InterBill, InterImportBill, InterProduct, InterEmployee{

    private String[] Bill;

    
    @Override
    public void makeNewEmployee() {
        
        int n;
        try {
            do {                
                System.out.println("Thao tác: ");
                System.out.println("1. Nhập");
                System.out.println("2. Thoát");
                System.out.println("Mời chọn thao tac: ");
                n = new Scanner(System.in).nextInt();
                if (n == 1){
                    System.out.println("Mời chọn id sản phẩm: ");
                    String id = new Scanner(System.in).nextLine();
                    System.out.println("Mời bạn nhập tên tài khoản: ");
                    String nameAccount = new Scanner(System.in).nextLine();
                    System.out.println("Mời nhập mật khẩu: ");
                    String password = new Scanner(System.in).nextLine();
                    System.out.println("Mời nhập tên đầy đủ: ");
                    String fullName = new Scanner(System.in).nextLine();
                    System.out.println("Mời nhập giới tính: ");
                    String gender = new Scanner(System.in).nextLine();
                    System.out.println("Mời nhập tuổi: ");
                    Integer Age = new Scanner(System.in).nextInt();
                    System.out.println("Mời nhập địa chỉ: ");
                    String Address = new Scanner(System.in).nextLine();
                    System.out.println("Mời nhập số điện thoại: ");
                    int PhoneNumber = new Scanner(System.in).nextInt();
                    System.out.println("Mòi nhập lương: ");
                    Float Salary = new Scanner(System.in).nextFloat();
                    Employees employee = new Employees(id, Address, Age, PhoneNumber, fullName, password, gender, nameAccount, Salary);
                    listEmployee.add(employee);
                }
            } while (n < 2 && n>0);
            
        } catch (Exception e) {
             System.out.println("Nhập sai dữ liệu. Mới nhập lại");
        }
        
    }

    @Override
    public void showSales() {
         double doanhthu = 0;
        for (Bill Bill : listBill) {
             
             doanhthu = doanhthu + Bill.getTotalBill();
            
        }
        System.out.println("Doanh thu: "+doanhthu);
    }

    @Override
    public void showBill() {
        for (Bill Bill : listBill) {
            System.out.println("Danh sách hóa đơn: \n");
            System.out.println(Bill.toString());

        } 
    }

    @Override
    public void showImportBill() {
        for (ImportBill importBill : listImportBill) {
            System.out.println("Danh sach hóa đơn nhập: \n");
            System.out.println(importBill.toString());
            
        }
    }

    @Override
    public void showProduct() {
         for (Product product : listProduct) {
            System.out.println("Danh sách sản phẩm: \n");
            System.out.println(product.toString());
           
        }
    }

    @Override
    public void showNewEmployee() {
        for (Employees employees : listEmployee) {
            System.out.println("Danh sách tài khoản đã đăng ký : ");
            System.out.println("Mã id : "+ employees.getId());
            System.out.println("Địa chỉ: "+ employees.getAddress());
            System.out.println("Tuổi: "+ employees.getAge());
            System.out.println("Tên đầy đủ: "+ employees.getFullName());
            System.out.println("Giới tính: "+employees.getGender());
            System.out.println("Tên tài khoản: " + employees.getNameAccount());
            System.out.println("Mật khẩu: " + employees.getPassword());
            System.out.println("Số điện thoại: " + employees.getPhoneNumber());
            System.out.println("Lương: " + employees.getSalary());
        }
     }

    @Override
    public void makeBill() {
        
    }

    @Override
    public void makeImportBill() {
        
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

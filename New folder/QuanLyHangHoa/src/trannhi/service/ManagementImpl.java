/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.service;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import trannhi.model.Bill;
import trannhi.model.Employee;
import trannhi.model.ImportBill;
import trannhi.model.Product;
import static trannhi.service.IBill.listBill;
import static trannhi.service.IImportBill.listImportBill;

/**
 *
 * @author Tran Nhi
 */
public class ManagementImpl implements IManagement,IProduct,IImportBill,IBill{

    
    @Override
    public void makeNewEmployee() {
        ArrayList<Employee> listEmployee = new ArrayList<Employee>();
        int n;
        try {
            do{
                System.out.println("Thao tác: ");
                System.out.println("1. Nhập");
                System.out.println("2. Thoát");
                System.out.println("Mời chọn thao tác: ");
                n = new Scanner(System.in).nextInt();
                if (n == 1){
                    System.out.println("Mời nhập họ tên: ");
                    String fullName = new Scanner(System.in).next();
                    System.out.println("Mời nhập giới tính: ");
                    String gender = new Scanner(System.in).next();
                    System.out.println("Mời nhập ngày sinh: ");
                    String dateOfBirth = new Scanner(System.in).next();
                    System.out.println("Mời nhập địa chỉ: ");
                    String address = new Scanner(System.in).next();
                    System.out.println("Mời nhập số điện thoại: ");
                    byte phoneNumber = new Scanner(System.in).nextByte();
                    System.out.println("Mời nhập lương: ");
                    float salary = new Scanner(System.in).nextFloat();
                    Employee employee = new Employee(fullName, gender, dateOfBirth, address, phoneNumber, salary);
                    listEmployee.add(employee);
                }

            }while (n < 2 && n>0);
        } catch (InputMismatchException e) {
            System.out.println("Nhập sai dữ liệu. Mời nhập lại");
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
    public void showSales() {
        double doanhthu = 0;
        for (Bill Bill : listBill) {
             
             doanhthu = doanhthu + Bill.getTotalBill();
            
        }
        System.out.println("Doanh thu: "+doanhthu);
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

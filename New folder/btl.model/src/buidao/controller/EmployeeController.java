/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.controller;

import buidao.ServiceBD.EmployeeIml;
import static buidao.ServiceBD.InterBill.listBill;
import java.util.Scanner;
/**
 *
 * @author DAo NGo
 */
public class EmployeeController {
    
    EmployeeIml employeeIml = new EmployeeIml();
    private int productID;
    
    public void active() {
        int n;
        
         do {
            System.out.println("1.Đơn bán hàng - Tạo mới");
            System.out.println("2.Đơn nhập hàng - Tạo mới");
            System.out.println("3. Xem hàng hóa ");
            System.out.println("4. Tìm sản phẩm theo mã (Hóa đơn bán hàng)");
            System.out.println("5. Xem hóa đơn nhập hàng ");
            System.out.println("6. Xem hóa đơn bán hàng ");
            System.out.println("7. Thoát ");
            System.out.println("Mời nhập lựa chọn:");
            n= new Scanner(System.in).nextInt();
            switch(n){
                case 1:
                    employeeIml.makeBill();
                    break;
                case 2:
                    employeeIml.makeImportBill();
                    break;
                case 3:
                    employeeIml.showProduct();
                    break;
                case 4:
                    System.out.println("Nhập id sản phẩm cần tìm kiếm: ");
                    productID = new Scanner(System.in).nextInt();
                    employeeIml.find(productID);
                    break;
                case 5:
                    employeeIml.showImportBill();
                    break;
                case 6:
                    employeeIml.showBill();
                    break;
                case 7:
                    break;
            }
        }while (n <6 && n>0);
        
    }
    
}

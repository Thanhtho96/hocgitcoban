/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.controller;

import buidao.ServiceBD.ManagementIml;
import java.util.Scanner;

/**
 *
 * @author DAo NGo
 */
public class ManagerController {
    ManagementIml managementIml = new ManagementIml();
    
     public void active(){
        int n;
        do{
            System.out.println("1.Tạo một tài khoản mới ");
            System.out.println("2.xem hàng hóa");
            System.out.println("3. Xem doanh thu");
            System.out.println("4.Xem các tài khoản đã tạo: ");
            System.out.println("5. Xem hóa đơn nhập hàng");
            System.out.println("6. xem hóa đơn bán hàng");
            System.out.println("7. Thoát");
            System.out.println("Mời nhập lựa chọn:");
            n= new Scanner(System.in).nextInt();
            switch(n){
                case 1:
                    managementIml.makeNewEmployee();
                    break;
                case 2:
                    managementIml.showProduct();
                    break;
                case 3:
                    managementIml.showSales();
                    break;
                case 4:
                    managementIml.showNewEmployee();
                case 5:
                    managementIml.showImportBill();
                    break;
                case 6:
                    managementIml.showBill();
                    break;
                case 7:
                    break;
            }
        }while(n <7 && n>0);
    }
    
}

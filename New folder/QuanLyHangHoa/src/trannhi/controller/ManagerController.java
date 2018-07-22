/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.controller;

import java.util.Scanner;
import trannhi.service.ManagementImpl;

/**
 *
 * @author Tran Nhi
 */
public class ManagerController {
    ManagementImpl managementImpl = new ManagementImpl();
    public void active(){
        int n;
        do{
            System.out.println("1. Tạo tài khoản nhân viên");
            System.out.println("2. Xem hàng hóa");
            System.out.println("3. Xem doanh thu");
            System.out.println("4. Xem hóa đơn nhập hàng");
            System.out.println("5. xem hóa đơn bán hàng");
            System.out.println("6. Thoát");
            System.out.println("Mời nhập lựa chọn:");
            n= new Scanner(System.in).nextInt();
            switch(n){
                case 1:
                    managementImpl.makeNewEmployee();
                    break;
                case 2:
                    managementImpl.showProduct();
                    break;
                case 3:
                    managementImpl.showSales();
                    break;
                case 4:
                    managementImpl.showImportBill();
                    break;
                case 5:
                    managementImpl.showBill();
                    break;
                case 6:
                    break;
            }
        }while(n <6 && n>0);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.controller;

import buidao.ServiceBD.MenuIml;
import java.util.Scanner;

/**
 *
 * @author DAo NGo
 */
public class MenuController {
    MenuIml menuImpl = new MenuIml();
    EmployeeController employeeController = new EmployeeController();
    ManagerController managementController = new ManagerController();
    public void active() {
        
        int n = 0;

        do {
            String name;
            String password;
            menuImpl.showMenu();
            System.out.println("Mời nhập lựa chọn: ");
            n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1:
                    System.out.println("Mời nhập tên tài khoản:");
                    name = new Scanner(System.in).next();
                    System.out.println("Mời nhập mật khẩu");
                    password = new Scanner(System.in).next();
                    if (name.equals("BuiSu") == true && password.equals("0309") == true) {
                        
                        employeeController.active();
                    }else if (name.equals("BuiDao") == true && password.equals("1703") == true) {
                        
                        managementController.active();
                    }
                    break;
                case 2:
                    System.out.println("Bạn chọn thoát!");
                    break;
            }
        }while(n <2 && n>0);
    }
}

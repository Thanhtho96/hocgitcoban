/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.controller;

import java.util.Scanner;
import trannhi.service.EmployeeImpl;

/**
 *
 * @author Tran Nhi
 */
public class EmployeeController {

    EmployeeImpl employeeImpl = new EmployeeImpl();

    public void active() {
        int n;

        do {
            System.out.println("1. Tạo hóa đơn bán hàng");
            System.out.println("2. Tạo hóa đơn nhập hàng");
            System.out.println("3. Xem hàng hóa");
            System.out.println("4. Xem hóa đơn nhập hàng");
            System.out.println("5. xem hóa đơn bán hàng");
            System.out.println("6. Thoát");
            System.out.println("Mời nhập lựa chọn:");
            n = new Scanner(System.in).nextInt();
            switch (n) {
                case 1:
                    employeeImpl.makeBill();
                    break;
                case 2:
                    employeeImpl.makeImportBill();
                    break;
                case 3:
                    employeeImpl.showProduct();
                    break;
                case 4:
                    employeeImpl.showImportBill();
                    break;
                case 5:
                    employeeImpl.showBill();
                    break;
                case 6:
                    break;
            }
        } while (n < 6 && n > 0);

    }

}

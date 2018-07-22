/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.controller;

import bka.binhnk.model.Car;
import bka.binhnk.model.CarMethod;
import bka.binhnk.model.CustomerMethod;
import bka.binhnk.model.EmployeeMethod;
import bka.binhnk.service.Menu;
import bka.binhnk.service.MenuCar;
import bka.binhnk.service.MenuCustomer;
import bka.binhnk.service.MenuEmployee;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bibi
 */
public class MainController {

    public static void main(String[] args) {

        Menu menu = new Menu();
        MenuCar menuCar = new MenuCar();
        MenuCustomer menuCustomer = new MenuCustomer();
        MenuEmployee menuEmployee = new MenuEmployee();
        CarMethod carMethod = new CarMethod();
        CustomerMethod customerMethod = new CustomerMethod();

        carMethod.getDefautCar();
        customerMethod.getDefaultCustomer();

        while (true) {
            int v = 0;
            menu.showMenu();
            try {
                v = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Bạn phải nhập vào số nguyên");
            }
            switch (v) {
                case 1: {
                    carMethod.showCar();
                    while (true) {
                        int var = 0;
                        menuCar.showMenu();
                        try {
                            var = new Scanner(System.in).nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Bạn phải nhập vào số nguyên");
                        }

                        switch (var) {
                            case 1: {
                                System.out.println("1. Xe mới nhập về");
                                carMethod.getInfoCar();
                                break;
                            }
                            case 2: {
                                System.out.println("2. Tìm xe theo tên");
                                carMethod.findNameCar();
                                break;
                            }
                            case 3: {
                                System.out.println("3. Hiển thị xe theo giá");
                                carMethod.showPrinceCar();
                                break;
                            }
                            case 4: {
                                System.out.println("4. Khách hàng mua xe");
                                carMethod.sellCar();
                                break;
                            }
                            case 5: {
                                System.out.println("5. Danh sách xe trong Gara");
                                carMethod.showCar();
                                break;
                            }
                            case 6: {
                                System.out.println("5. Quay lại Menu trước");
                                break;
                            }
                            default: {
                                System.out.println("Mời bạn nhập lại theo Menu từ 1 đến 5");
                            }
                        }
                        if (var == 6) {
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    while (true) {
                        int var = 0;
                        menuCustomer.showMenu();
                        try {
                            var = new Scanner(System.in).nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Bạn phải nhập vào số nguyên");
                        }

                        switch (var) {
                            case 1: {
                                System.out.println("1. Nhập vào thông tin khách hàng");
                                customerMethod.getInfoCustomer();
                                break;
                            }
                            case 2: {
                                System.out.println("2. Tìm khách hàng theo ID");
                                customerMethod.findIDCustomer();
                                break;
                            }
                            case 3: {
                                System.out.println("3. Tìm khách hàng theo tên");
                                customerMethod.findNameCustomer();
                                break;
                            }
                            case 4: {
                                System.out.println("4. Hiển thị khách hàng theo năm sinh");
                                customerMethod.showBornCustomer();
                                break;
                            }
                            case 5: {
                                System.out.println("5. Danh sách tất cả khách hàng");
                                customerMethod.showCustomer();
                                break;
                            }
                            case 6: {
                                System.out.println("6. Quay lại Menu trước");
                                break;
                            }
                            default: {
                                System.out.println("Mời bạn nhập lại theo Menu từ 1 đến 6");
                            }
                        }
                        if (var == 6) {
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    menuEmployee.showMenu();
                    break;
                }
                case 4: {
                    System.out.println("Thoát chương trình!");
                    break;
                }
                default: {
                    System.out.println("Mời bạn nhập lại theo Menu từ 1 đến 4");
                }
            }
            if (v == 4) {
                break;
            }
        }
    }
}

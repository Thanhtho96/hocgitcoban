/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.service;

import java.util.Scanner;

/**
 *
 * @author Bibi
 */
public class MenuCar implements IMenu {

    @Override
    public void showMenu() {
        System.out.println("---------Menu Xe----------");
        System.out.println("Mời bạn nhập vào lựa chọn");
        System.out.println("1. Xe mới nhập về");
        System.out.println("2. Tìm xe theo tên");
        System.out.println("3. Hiển thị xe theo giá");
        System.out.println("4. Khách hàng mua xe");
        System.out.println("5. Danh sách xe trong Gara");
        System.out.println("6. Quay lại Menu trước");
        System.out.println("--------------------------");
        }
    }



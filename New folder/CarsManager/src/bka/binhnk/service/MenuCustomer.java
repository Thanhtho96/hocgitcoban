/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.service;

/**
 *
 * @author Bibi
 */
public class MenuCustomer implements IMenu{

    @Override
    public void showMenu() {
        System.out.println("-----------Menu Khách Hàng------------");  
        System.out.println("1. Nhập vào thông tin khách hàng");
        System.out.println("2. Tìm khách hàng theo ID");
        System.out.println("3. Tìm khách hàng theo tên");
        System.out.println("4. Hiển thị khách hàng theo năm sinh");
        System.out.println("5. Danh sách tất cả khách hàng");
        System.out.println("6. Quay lại Menu trước");
        System.out.println("--------------------------------------");}
    
}

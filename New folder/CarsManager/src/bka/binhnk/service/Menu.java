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
public class Menu implements IMenu{

    @Override
    public void showMenu() {
        System.out.println("-------Menu------");
        System.out.println("1. Menu Xe");
        System.out.println("2. Menu Khách hàng");
        System.out.println("3. Menu Nhân viên");
        System.out.println("-----------------");
    }
    
}

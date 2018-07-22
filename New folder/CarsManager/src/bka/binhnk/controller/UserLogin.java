/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.controller;

import bka.binhnk.constant.Constant;
import java.util.Scanner;

/**
 *
 * @author Bibi
 */
public class UserLogin {
    public String userName;
    public String passWord;

    public Boolean login() {
        System.out.println("Đăng nhập");
        System.out.println("Tài khoản: ");
        userName = new Scanner(System.in).nextLine();
        System.out.println("Mật khẩu: ");
        passWord = new Scanner(System.in).nextLine();
        
        boolean result = false;
        if (userName.equals(Constant.UN_CONSTANT)
                && passWord.equals(Constant.PW_CONSTANT)) {
            result = true;
        }
        return result;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.Scanner;

/**
 *
 * @author QQ
 */
public class UserController extends PersonController{
    @Override
    public Boolean login(String user, String pass) {
        boolean bl = false;
        if(user!=null&&
                user.equals(Common.getUSER_NAME_NV())&&
                pass!=null&&
                pass.equals(Common.getPASSWORD_NV())){
            bl = true;
        }
        return bl;
    }
    

    @Override
    public Boolean login(String user, String pass, int role) {
        boolean bl = false;
        if(user != null&&
                user.equals(Common.getUSER_NAME_QL())&&
                pass!=null&&
                pass.equals(Common.getPASSWORD_QL())
                &&role==0){
            bl= true;
        }
        return bl;
    }
}

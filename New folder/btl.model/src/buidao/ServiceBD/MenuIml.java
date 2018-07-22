/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.ServiceBD;

/**
 *
 * @author DAo NGo
 */
public class MenuIml implements InterMenu{

    @Override
    public void showMenu() {
         String[] menu = new String[2];
        menu[0] = "Login";
        menu[1] = "Logout";
        
        System.out.println("Menu:");
        for (int i=0; i<menu.length; i++){
            System.out.println(i+1+". "+menu[i]);
        }
    }
    
}

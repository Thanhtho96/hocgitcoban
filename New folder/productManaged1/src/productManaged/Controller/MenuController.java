/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productManaged.Controller;

import productManage.Service.MenuImpl;

/**
 *
 * @author Xuan
 */
public class MenuController {
    MenuImpl menuImpl=new MenuImpl();
    public void showMenu(int role){
        switch(role){
            case 1: menuImpl.showMenu(1);
                    break;
            case 2: menuImpl.showMenu(2);
                    break;
            case 3: menuImpl.showMenu(3);
                   break;
            case 4: menuImpl.showMenu(4);
                    break;
        }
    }
}

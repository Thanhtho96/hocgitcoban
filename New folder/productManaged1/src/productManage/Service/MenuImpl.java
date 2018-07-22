/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productManage.Service;

import productmanaged1.model.Menu;

/**
 *
 * @author Xuan
 */
public class MenuImpl implements IMenu{

    @Override
    public boolean showMenu(int option) {
       if(option>=1){
           Menu TTSP= new Menu(1,"nhập thông tin sản phẩm");
           Menu TTKH= new Menu(2,"Nhập thông tin khách hàng");
           Menu TTHD= new Menu(3,"in thông tin hóa đơn");
           Menu DX= new Menu(4,"đăng xuất");
           switch(option){
               case 1:
                      System.out.println(TTSP.getOption()+"./t"+TTSP.getDescription());
                      return true;
               case 2:
                      System.out.println(TTKH.getOption()+"./t"+TTKH.getDescription());
                      return true;
               case 3:
                     System.out.println(TTHD.getOption()+"./t"+TTHD.getDescription());
                     return true;
               case 4:
                    System.out.println(DX.getOption()+"./t"+DX.getDescription());
                    return true;
               default:    break;
           }
       }
        return false;
    }

    
    
}

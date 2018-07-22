/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productManaged.Controller;

/**
 *
 * @author Xuan
 */
public class userController extends PersonController{
      public void DangKy(String name, String pass, String phone, String address){
        System.out.println(" moi ban dang ky:");
        
    }
    public boolean DangNhap(String name, String pass){
    if(("Hello".equals(name))&&("1234".equals(pass))) return true;
    else { System.out.println("tai khoan khong dung. Nhap lai!");
        return false;
    }
    }

    boolean DangNhap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void ShowMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void ShowMenu(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

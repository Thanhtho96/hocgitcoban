/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productManaged.Controller;

import java.util.Scanner;
import productmanaged1.model.HoaDon;
import productmanaged1.model.KhachHang;
import productmanaged1.model.Menu;
import productmanaged1.model.Shoes;

/**
 *
 * @author Xuan
 */
public class MainProcess {

    private static boolean userController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    KhachHang khachHang1= new KhachHang();
    Shoes shoes1= new Shoes();
    HoaDon hoaDon1= new HoaDon();
    public void nhapKH(){
        System.out.println("Nhập vào thông tin khách hàng:");
        khachHang1.nhapThongTin(); 
        
    }
    public void nhapShoes(){
        System.out.println("Nhập thông tin giày:");
        shoes1.nhapThongTin();
        
    }
    public void InHoaDon(){
        System.out.println("In hóa đơn:");
        hoaDon1.inThongTin();
    }
    public static void main(String[] args) {
      userController person= new userController(); 
      MainProcess mainProcess= new MainProcess();
        
        System.out.println("Nhập username:");
        String name= new Scanner(System.in).nextLine();
        System.out.println("nhập pass:");
        String pass=new Scanner(System.in).nextLine();
        boolean KQ= person.DangNhap(name,pass);
        if(KQ) System.out.println("Đăng nhập thành công");
           mainProcess.nhapKH();
       
    }
}

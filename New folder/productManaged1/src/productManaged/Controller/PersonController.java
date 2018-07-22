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
public abstract class PersonController {
    public abstract void DangKy(String name,String pass, String phone, String address);
    public abstract boolean DangNhap(String name, String pass);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.model;

/**
 *
 * @author Bibi
 */
public class Customer extends Person {

    public String idCustomer;

    public Customer() {
    }

    public Customer(String idCustomer, String name, String phone, Integer born) {
        super(name, phone, born);
        this.idCustomer = idCustomer;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        return "Mã khách hàng: " + idCustomer + ", Họ tên: " + name
                + ", Số điện thoại " + phone + ", Năm sinh: " + born;
    }

}

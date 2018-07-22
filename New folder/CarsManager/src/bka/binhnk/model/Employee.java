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
public class Employee extends Person {

    private String idEmployee;

    public Employee(String idEmployee, String name, String phone, Integer born) {
        super(name, phone, born);
        this.idEmployee = idEmployee;
    }

    public String getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    public String toString() {
        return "Mã nhân viên: " + idEmployee + ", Họ tên: " + name
                + ", Số điện thoại " + phone + ", Năm sinh: " + born;
    }

}

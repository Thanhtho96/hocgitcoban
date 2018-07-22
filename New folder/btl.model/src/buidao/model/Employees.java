/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.model;

/**
 *
 * @author Dao
 */
public class Employees extends Person{

    public Employees() {
    }

    public Employees(String id, String Address, int Age, int PhoneNumber, String fullName, String password, String gender, String nameAccount, float Salary) {
        super(id, Address, Age, PhoneNumber, fullName, password, gender, nameAccount, Salary);
    }


}

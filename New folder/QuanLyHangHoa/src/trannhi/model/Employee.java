/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trannhi.model;

/**
 *
 * @author Tran Nhi
 */
public class Employee extends User{

    public Employee() {
    }

    public Employee(String fullName, String gender, String dateOfBirth, String address, byte phoneNumber, float salary) {
        super(fullName, gender, dateOfBirth, address, phoneNumber, salary);
    }
    
}

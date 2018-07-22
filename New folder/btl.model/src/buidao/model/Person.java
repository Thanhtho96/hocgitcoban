/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buidao.model;

import java.util.Scanner;

/**
 *
 * @author Dao
 */
public class Person {
    private String id;
    private String Address;
    private int Age;
    private int PhoneNumber;
    private String fullName;
    private String password;
    private String gender;
    private String nameAccount;
    private float Salary;

    public Person() {
    }

    public Person(String id, String Address, int Age, int PhoneNumber, String fullName, String password, String gender, String nameAccount, float Salary) {
        this.id = id;
        this.Address = Address;
        this.Age = Age;
        this.PhoneNumber = PhoneNumber;
        this.fullName = fullName;
        this.password = password;
        this.gender = gender;
        this.nameAccount = nameAccount;
        this.Salary = Salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNameAccount() {
        return nameAccount;
    }

    public void setNameAccount(String nameAccount) {
        this.nameAccount = nameAccount;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }
}

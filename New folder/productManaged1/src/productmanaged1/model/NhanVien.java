/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanaged1.model;

/**
 *
 * @author Xuan
 */
public class NhanVien extends Person{
    private float worktimes;
    private float Salary;

    public NhanVien() {
    }

    public NhanVien(float worktimes, float Salary, String name, String phone, String address, String dob) {
        super(name, phone, address, dob);
        this.worktimes = worktimes;
        this.Salary = Salary;
    }

    public float getWorktimes() {
        return worktimes;
    }

    public void setWorktimes(float worktimes) {
        this.worktimes = worktimes;
    }

    public float getSalary() {
        return Salary;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }

    public float getTienLuong(){
        this.Salary=this.worktimes*15;
        return this.Salary;
        
    }
}

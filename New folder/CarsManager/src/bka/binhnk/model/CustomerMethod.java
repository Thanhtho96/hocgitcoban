/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bka.binhnk.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bibi
 */
public class CustomerMethod extends Customer {

    public CustomerMethod() {
    }

    public CustomerMethod(String idCustomer, String name, String phone, Integer born) {
        super(idCustomer, name, phone, born);
    }

    List<Customer> customers = new ArrayList<>();
    Customer customer = new Customer();

//khách hàng mặc định
    public void getDefaultCustomer() {
        customers.add(new Customer("KH1", "Nguyen Van A", "0123456", 1995));
        customers.add(new Customer("KH2", "Le Van B", "01234567", 1993));
        customers.add(new Customer("KH3", "Nguyen Thi C", "012345678", 1991));
        customers.add(new Customer("KH4", "Tran D", "0123456789", 1996));
    }

    public void getInfoCustomer() {

        System.out.println("Nhập vào mã khách hàng: ");
        String a1 = new Scanner(System.in).nextLine();
        String a = a1.toUpperCase();
        System.out.println("Nhập vào tên khách hàng: ");
        String b = new Scanner(System.in).nextLine();
        System.out.println("Nhập vào số điện thoại khách hàng: ");
        String c = new Scanner(System.in).nextLine();
        int d = 0;
        while (true) {
            try {
                System.out.println("Nhập vào năm sinh khách hàng: ");
                d = new Scanner(System.in).nextInt();
                if (d < 0 || d > 2018) {
                    throw new NumberFormatException();
                }
                break;
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Mời bạn nhập đúng năm sinh");
            }
        }
        customers.add(new Customer(a, b, c, d));
    }

    public void findIDCustomer() {
        boolean check = true;
        System.out.println("Nhập vào ID khách hàng muốn tìm kiếm: ");
        String a = new Scanner(System.in).nextLine();
        for (Customer key : customers) {
            if (key.getIdCustomer().equalsIgnoreCase(a)) {
                System.out.println("Thông tin khách hàng muốn tìm kiếm: " + key);
                check = false;
            }
        }
        if (check) {
            System.out.println("Không có mã khách hàng bạn muốn tìm");
        }
    }

    public void findNameCustomer() {
        boolean check = true;
        System.out.println("Nhập vào tên khách hàng muốn tìm kiếm: ");
        String a = new Scanner(System.in).nextLine();
        System.out.println("Những khách hàng có tên " + a + " là: ");
        for (Customer key : customers) {
            if (key.getName().equalsIgnoreCase(a)) {
                System.out.println(key);
                check = false;
            }
        }
        if (check) {
            System.out.println("Không có khách hàng nào ");
        }
    }

    public static class CustomerComparator implements Comparator<Customer> {

        @Override
        public int compare(Customer cus1, Customer cus2) {
            if (cus1.born > cus2.born) {
                return 1;
            } else if (cus1.born < cus2.born) {
                return -1; //đổi 1 và -1 nếu sắp xếp giảm dần
            } else {
                return 0;
            }
        }
    }

    public void showBornCustomer() {
        Comparator<Customer> customerComparator = new CustomerComparator();
        Collections.sort(customers, customerComparator);
        System.out.println("Các khách hàng được sắp xếp theo năm sinh: ");
        for (Customer key : customers) {
            System.out.println(key);
        }
    }

    public static class CustomerComparator2 implements Comparator<Customer> {

        @Override
        public int compare(Customer cus1, Customer cus2) {
            return cus1.idCustomer.compareToIgnoreCase(cus2.idCustomer);

        }
    }

    public void showCustomer() {
        System.out.println("Danh sách khách hàng: ");
        for (Customer key : customers) {
            System.out.println(key);
        }
    }
}

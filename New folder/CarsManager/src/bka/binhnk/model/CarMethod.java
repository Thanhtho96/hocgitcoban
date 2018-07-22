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
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Bibi
 */
public class CarMethod extends Car {

    List<Car> cars = new ArrayList<Car>();
    Car car = new Car();

    public void getDefautCar() {
        //xe có sẵn trong gara
        cars.add(new Car("X1", "mercedes", 1200000000, 3));
        cars.add(new Car("X2", "audi", 1000000000, 1));
        cars.add(new Car("X3", "honda", 700000000, 2));
        cars.add(new Car("X4", "bmv", 900000000, 2));
    }

    public void getInfoCar() {

        System.out.println("Nhập vào mã xe: ");
        String a1 = new Scanner(System.in).nextLine();
        String a = a1.toUpperCase();
        System.out.println("Nhập vào tên xe: ");
        String b = new Scanner(System.in).nextLine();

        int c = 0;
        while (true) {
            try {
                System.out.println("Nhập vào giá tiền (VNĐ): ");
                c = new Scanner(System.in).nextInt();
                if (c <= 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Bạn phải nhập vào số nguyên dương");
            }
        }

        int d = 0;
        while (true) {
            try {
                System.out.println("Nhập vào số lượng: ");
                d = new Scanner(System.in).nextInt();
                if (d <= 0) {
                    throw new NumberFormatException();
                }
                break;
            } catch (InputMismatchException | NumberFormatException ex) {
                System.out.println("Bạn phải nhập vào số nguyên dương");
            }
        }

        cars.add(new Car(a, b, c, d));
    }

    //tìm xe theo tên
    public void findNameCar() {
        boolean check = true;
        System.out.println("Nhập vào tên xe muốn tìm kiếm");
        String a = new Scanner(System.in).nextLine();
        for (Car key : cars) {
            if (key.getNameCar().equalsIgnoreCase(a)) {
                System.out.println("Thông tin xe bạn cần tìm: " + key);
                check = false;
            }
        }
        if (check) {
            System.out.println("Không có xe bạn cần tìm");
        }
    }

    public static class CarComparator implements Comparator<Car> {

        @Override
        public int compare(Car car1, Car car2) {
            if (car1.priceIn > car2.priceIn) {
                return 1;
            } else if (car1.priceIn < car2.priceIn) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    //sắp xếp xe theo giá
    public void showPrinceCar() {
        Comparator<Car> carComparator = new CarComparator();
        Collections.sort(cars, carComparator);
        System.out.println("Các xe được sắp xếp theo giá: ");
        for (Car key : cars) {
            System.out.println(key);
        }
    }

    //bán xe
    public void sellCar() {

        boolean check = true;
        System.out.println("----------------------------");
        System.out.println("Nhập vào mã xe bạn muốn mua: ");
        String check1 = new Scanner(System.in).nextLine();
        for (Car key : cars) {

            if (check1.equalsIgnoreCase(key.getIdCar())) {
                int a = 0;

                System.out.println("Thông tin xe bạn muốn mua: " + key);
                if (key.soLuong != 0) {
                    while (true) {
                        try {
                            System.out.println("Bạn muốn mua mấy cái xe này: ");
                            a = new Scanner(System.in).nextInt();
                            if (a <= 0) {
                                throw new NumberFormatException();
                            }
                            break;
                        } catch (InputMismatchException | NumberFormatException ex) {
                            System.out.println("Bạn phải nhập vào số nguyên dương");
                        }
                    }
                    while (a > key.soLuong) {
                        System.out.println("Trong gara chỉ còn " + key.soLuong
                                + " chiếc xe " + key.getNameCar());
                        System.out.println("Mời bạn nhập lại số lượng xe muốn mua");
                        a = new Scanner(System.in).nextInt();
                    }

                    System.out.println("Bạn có chắc muốn mua " + a + " chiếc xe này");
                    System.out.println("Gõ 'mua' để mua và "
                            + "gõ 'khongmua' để không mua");

                    while (true) {
                        String check2 = new Scanner(System.in).nextLine();
                        if (check2.equalsIgnoreCase("mua")) {
                            key.soLuong = key.soLuong - a;
                            //mua thành công, số lượng giảm đi a
                            System.out.println("Bạn đã mua thành công "
                                    + a + " chiếc xe " + key.getNameCar());
                            break;
                        } else if (check2.equalsIgnoreCase("khongmua")) {
                            System.out.println("Bạn chọn không mua!");
                            break;
                        } else {
                            System.out.println("Mời bạn gõ lại 'mua' hoặc 'khongmua': ");
                        }
                    }
                } else {
                    System.out.println("Gara hết mẫu xe này");
                }
                check = false;
            }

        }
        if (check) {
            System.out.println("Không có mã xe này!");
        }
    }

    public static class CarComparator2 implements Comparator<Car> {

        @Override
        public int compare(Car car1, Car car2) {

            return car1.idCar.compareToIgnoreCase(car2.idCar);
        }
    }

    public void showCar() {
        System.out.println("Tất cả xe trong gara");
        Comparator<Car> carComparator2 = new CarComparator2();
        Collections.sort(cars, carComparator2);
        for (Car key : cars) {
            System.out.println(key);
        }
    }
}

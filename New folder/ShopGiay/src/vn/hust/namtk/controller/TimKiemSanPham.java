/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Lordđ
 */
public class TimKiemSanPham extends AbsTimKiemSP {

    public void menu(ArrayList<SanPham> sanpham) {
        byte n;

        do {
            System.out.println("1. Tìm kiếm theo ID");
            System.out.println("2. Tìm kiếm theo tên");
            System.out.println("3. Tìm kiếm theo giá");
            System.out.println("4. Tìm kiếm theo xuất xứ");
            System.out.println("5. Thoát");
            do {
                System.out.print("Nhap lua chon: ");
                n = new Scanner(System.in).nextByte();
            } while (n < 1 || n > 5);
            switch (n) {
                case 1: {
                    System.out.println("Nhập ID sp: ");
                    String id = new Scanner(System.in).nextLine();
                    int index = timKiemTheoID(sanpham, id);
                    if (index == -1) {
                        System.out.println("Không tìm thấy ID này");
                    } else {
                        System.out.println("---------");
                        System.out.println(sanpham.get(index).toString());
                        System.out.println("---------");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập tên sp: ");
                    String ten = new Scanner(System.in).nextLine();
                    int index = timKiemTheoTen(sanpham, ten);
                    if (index == -1) {
                        System.out.println("Không tìm thấy sp này");
                    } else {
                        System.out.println("---------");
                        System.out.println(sanpham.get(index).toString());
                        System.out.println("---------");
                    }
                    break;
                }
                case 3: {
                    double min, max;
                    ArrayList<Integer> list;
                    System.out.print("Giá min: ");
                    min = new Scanner(System.in).nextDouble();
                    System.out.print("Giá max: ");
                    max = new Scanner(System.in).nextDouble();
                    list = timKiemTheoGia(sanpham, min, max);
                    if (list.isEmpty()) {
                        System.out.println("Không có sp nào");
                    } else {
                        for (int index : list) {
                            System.out.println("---------");
                            System.out.println(sanpham.get(index).toString());
                            System.out.println("---------");
                        }
                    }
                    break;
                }
                case 4: {
                    double min, max;
                    ArrayList<Integer> list;
                    System.out.println("Xuất xứ: ");
                    String xuatXu = new Scanner(System.in).nextLine();
                    list = timKiemTheoXuatXu(sanpham, xuatXu);
                    if (list.isEmpty()) {
                        System.out.println("Không có sp nào");
                    } else {
                        for (int index : list) {
                            System.out.println("---------");
                            System.out.println(sanpham.get(index).toString());
                            System.out.println("---------");
                        }
                    }
                    break;
                }
                case 5:
                    break;
            }
        } while (n != 5);
    }

    @Override
    public int timKiemTheoID(ArrayList<SanPham> sanpham, String id) {
        int index = 0;
        for (SanPham x : sanpham) {
            if (x.getMaGiay().equals(id)) {
                break;
            }
            index++;
        }
        if (index == sanpham.size()) {
            index = -1;
        }
        return index;
    }

    @Override
    public int timKiemTheoTen(ArrayList<SanPham> sanpham, String ten) {
        int index = 0;
        for (SanPham x : sanpham) {
            if (x.getMaGiay().equals(ten)) {
                break;
            }
            index++;
        }
        if (index == sanpham.size()) {
            index = -1;
        }
        return index;
    }

    @Override
    public ArrayList<Integer> timKiemTheoXuatXu(ArrayList<SanPham> sanpham, String xuatXu) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        for (SanPham x : sanpham) {
            if (x.getXuatXu().equals(xuatXu)) {
                list.add(index);
            }
            index++;
        }
        return list;
    }

    @Override
    public ArrayList<Integer> timKiemTheoGia(ArrayList<SanPham> sanpham, double giaMin, double giaMax) {
        ArrayList<Integer> list = new ArrayList<>();
        int index = 0;
        double gia;
        for (SanPham x : sanpham) {
            gia = x.getGiaBan();
            if (gia >= giaMin && gia <= giaMax) {
                list.add(index);
            }
            index++;
        }
        return list;
    }

}

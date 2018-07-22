/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import java.util.Scanner;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Lordđ
 */
public class SanPhamController {

    public void dieuChinhGia(ArrayList<SanPham> sanpham, String id) {
        int index = 0;
        for (SanPham x : sanpham) {
            if (x.getMaGiay().equals(id)) {
                System.out.println("Mã sp: " + x.getMaGiay());
                System.out.println("Tên: " + x.getTenGiay());
                System.out.println("Giá bán: " + x.getGiaBan());
                System.out.print("Nhập giá mới: ");
                double gia = new Scanner(System.in).nextDouble();
                System.out.print("Thay đổi giá?(y/n) ");
                String check = new Scanner(System.in).nextLine();
                if (check.equals("y")) {
                    sanpham.get(index).setGiaBan(gia);
                    System.out.println("Đã thay đổi giá thành " + sanpham.get(index).getGiaBan());
                }
                break;
            }
            index++;
        }
        if (index == sanpham.size()) {
            System.out.println("Không tìm thấy " + id);
        }

    }

    public void xoaSanPham(ArrayList<SanPham> sanpham, String id) {
        int index = 0;
        for (SanPham x : sanpham) {
            if (x.getMaGiay().equals(id)) {
                System.out.println("-------------");
                System.out.println(x.toString());
                System.out.println("-------------");
                System.out.print("Xóa?(y/n) ");
                String check = new Scanner(System.in).nextLine();
                if (check.equals("y")) {
                    sanpham.remove(index);
                    System.out.println("Đã xóa " + id);
                }
                break;
            }
            index++;
        }
        if (index == sanpham.size()) {
            System.out.println("Không tìm thấy " + id);
        }
    }

}

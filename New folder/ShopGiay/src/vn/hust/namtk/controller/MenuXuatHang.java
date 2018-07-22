/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import java.util.Scanner;
import vn.hust.namtk.model.ChiTietNhapXuat;
import vn.hust.namtk.model.ChiTietHangXuat;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Lordđ
 */
public class MenuXuatHang{
    public void run(ArrayList<ChiTietHangXuat> listXuatHang,ArrayList<SanPham> listSanPham) {
        ChiTietHangXuat chiTiet1SPXuat;
        TimKiemXuat thongTinXuat = new TimKiemXuat();
        XuatHangController xuatHang = new XuatHangController();
        byte n;
        do {
            System.out.println("1.Them hang\n"
                    + "2.Xoa phieu\n"
                    + "3.Lich su xuat hang\n"
                    + "4.Tim kiem giao dich\n"
                    + "5.Thoat");
            do {
                System.out.print("Nhap lua chon: ");
                n = new Scanner(System.in).nextByte();
            } while (n < 1 || n > 5);
            switch (n) {
                case 1:
                    if((chiTiet1SPXuat = xuatHang.taoPhieuXuat(listSanPham))!=null){
                        listXuatHang.add(chiTiet1SPXuat);
                        int index = chiTiet1SPXuat.getIndex();
                        listSanPham.get(index).giamSoLuong(chiTiet1SPXuat.getSoLuong());
                    }
                    break;
                case 2:
                    int index = thongTinXuat.timKiemTheoSoPhieu(listXuatHang);
                    listXuatHang.remove(index);
                    break;
                case 3:
                    for(ChiTietHangXuat x : listXuatHang){
                        xuatHang.show(x);
                    }
                    break;
                case 4:
                    thongTinXuat.menu(listXuatHang);
                    break;
                case 5:
                    break;
            }
        } while (n != 5);

    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import java.util.Scanner;
import vn.hust.namtk.model.ChiTietHangNhap;
import vn.hust.namtk.model.ChiTietNhapXuat;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Lordđ
 */
public class MenuNhapHang {

    public void run(ArrayList<ChiTietHangNhap> listNhapHang,ArrayList<SanPham> listSanPham) {
        ChiTietHangNhap chiTiet1SPNhap;
        NhapHangController nhapHang = new NhapHangController();
        byte n;
        TimKiemNhap thongTinNhap = new TimKiemNhap();
        do {
            System.out.println("1.Them hang\n"
                    + "2.Xoa phieu\n"
                    + "3.Lich su nhap hang\n"
                    + "4.Tim kiem giao dich\n"
                    + "5.Thoat");
            do {
                System.out.print("Nhap lua chon: ");
                n = new Scanner(System.in).nextByte();
            } while (n < 1 || n > 5);
            switch (n) {
                case 1:
                    if((chiTiet1SPNhap = nhapHang.taoPhieuNhap(listSanPham))!=null){
                        listNhapHang.add(chiTiet1SPNhap);
                        int index = chiTiet1SPNhap.getTonTai();
                        if(index!=-1){
                            listSanPham.get(index).tangSoLuong(chiTiet1SPNhap.getSoLuong());
                        }
                        else{
                            listSanPham.add(chiTiet1SPNhap.getThongTinSPNhap());
                        }
                    }
                    break;
                case 2:
                    int index = thongTinNhap.timKiemTheoSoPhieu(listNhapHang);
                    listNhapHang.remove(index);
                    break;
                case 3:
                    for(ChiTietHangNhap x : listNhapHang){
                        nhapHang.show(x);
                    }
                    break;
                case 4:
                    thongTinNhap.menu(listNhapHang);
                    break;
                case 5:
                    break;
            }
        } while (n != 5);

    }
}

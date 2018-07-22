/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import java.util.Scanner;
import vn.hust.namtk.model.ChiTietHangNhap;
import vn.hust.namtk.model.ChiTietHangXuat;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Lordđ
 */
public class XuatHangController extends AbsGiaoDich {

    @Override
    public ChiTietHangNhap taoPhieuNhap(ArrayList<SanPham> listSanPham) {
        return null;
    }

    @Override
    public ChiTietHangXuat taoPhieuXuat(ArrayList<SanPham> listSanPham) {
        boolean taoThanhCong;
        ChiTietHangXuat chiTietXuat = new ChiTietHangXuat();
        while (true) {
            taoThanhCong = false;
            String maSP;
            boolean tonTai = false;
            SanPham thongTinSPXuat = null;
            int index;
            while (true) {
                index = -1;
                System.out.print("Nhap ma SP: ");
                maSP = new Scanner(System.in).nextLine();
                for (SanPham x : listSanPham) {
                    index++;
                    if (x.getMaGiay().equals(maSP)) {
                        System.out.println(x.getTenGiay());
                        tonTai = true;
                        thongTinSPXuat = x;
                        break;
                    }
                }
                if (!tonTai) {
                    System.out.println("Ma sp khong ton tai");
                } else {
                    chiTietXuat.setMaHangHoa(maSP);
                    break;
                }
            }
            chiTietXuat.setThongTinSPXuat(thongTinSPXuat);
            chiTietXuat.setIndex(index);

            String soPhieuNhap;
            System.out.print("Nhap so phieu: ");
            soPhieuNhap = new Scanner(System.in).nextLine();
            chiTietXuat.setSoPhieu(soPhieuNhap);

            chiTietXuat.setNgayTao();

            double gia;
            System.out.println("Gia xuat: ");
            gia = new Scanner(System.in).nextDouble();
            chiTietXuat.setGiaSP(gia);

            int soLuongXuat;
            while (true) {
                System.out.print("So luong xuat: ");
                soLuongXuat = new Scanner(System.in).nextInt();
                int soLuongConLai = listSanPham.get(index).getSoLuong();
                if ((soLuongXuat - soLuongConLai) < 0) {
                    System.out.println("Chi con: " + soLuongConLai + " sp");
                } else {
                    break;
                }
            }
            chiTietXuat.setSoLuong(soLuongXuat);

            String diaChi;
            System.out.print("Dia chi: ");
            diaChi = new Scanner(System.in).nextLine();
            chiTietXuat.setDiaChi(diaChi);
            show(chiTietXuat);
            System.out.print("Tao phieu? (Y/N) ");
            if (!(new Scanner(System.in).nextLine()).equalsIgnoreCase("n")) {
                taoThanhCong = true;
                break;
            }
            if (!taoThanhCong) {
                System.out.println("Nhap lai? (Y/N)");
                if (!(new Scanner(System.in).nextLine()).equalsIgnoreCase("n")) {
                    return null;
                }
            }
        }
        return chiTietXuat;
// THIEU EXCEPTION  
    }

    @Override
    public void show(ChiTietHangNhap hangNhap) {
    }

    @Override
    public void show(ChiTietHangXuat hangXuat) {
        System.out.println("So phieu: " + hangXuat.getSoPhieu());
        System.out.println("Ngay tao: " + hangXuat.getStringNgayTao());
        System.out.println("Ma hang hoa: " + hangXuat.getMaHangHoa());
        System.out.println("Ten SP: " + hangXuat.getThongTinSPXuat().getTenGiay());
        System.out.println("So luong: " + hangXuat.getSoLuong());
        System.out.println("Gia xuat: " + hangXuat.getGiaSP());
        System.out.println("Dia Chi Xuat Hang: " + hangXuat.getDiaChi());
        System.out.println("Xuat xu: " + hangXuat.getThongTinSPXuat().getXuatXu());
        System.out.println("Thanh tien: " + hangXuat.thanhTien(hangXuat.getGiaSP()));
    }

}

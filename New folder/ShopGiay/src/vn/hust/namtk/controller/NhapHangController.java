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
public class NhapHangController extends AbsGiaoDich {

    @Override
    public ChiTietHangNhap taoPhieuNhap(ArrayList<SanPham> listSanPham) {
        ChiTietHangNhap chiTietNhap = new ChiTietHangNhap();
        boolean taoThanhCong;
        while (true) {
            String soPhieuNhap;
            System.out.print("Nhap so phieu: ");
            soPhieuNhap = new Scanner(System.in).nextLine();
            chiTietNhap.setSoPhieu(soPhieuNhap);

            chiTietNhap.setNgayTao();

            String maSP;
            System.out.print("Nhap ma san pham: ");
            maSP = new Scanner(System.in).nextLine();
            chiTietNhap.setMaHangHoa(maSP);
            int index = 0;
            for (SanPham x : listSanPham) {
                if (x.getMaGiay().equals(maSP)) {
                    break;
                }
                index++;
            }
            if(index==listSanPham.size()) index=-1;
            chiTietNhap.setTonTai(index);
            String ten;
            String xuatXu;
            double giaBan=0;
            if (chiTietNhap.getTonTai() == -1) {
                System.out.print("Ten SP: ");
                ten = new Scanner(System.in).nextLine();
                
                System.out.print("Xuat xu: ");
                xuatXu = new Scanner(System.in).nextLine();

                
            } else {
                ten = listSanPham.get(index).getTenGiay();
                System.out.println("Ten SP: " + ten);
                xuatXu = listSanPham.get(index).getXuatXu();
                System.out.println("Xuat xu: " + xuatXu);
                giaBan = listSanPham.get(index).getGiaBan();
                System.out.println("Gia ban ra: " + giaBan);
            }
            int soLuong;
            System.out.print("So luong nhap vao: ");
            soLuong = new Scanner(System.in).nextInt();
            chiTietNhap.setSoLuong(soLuong);

            double giaNhap;
            System.out.print("Gia nhap: ");
            giaNhap = new Scanner(System.in).nextDouble();
            chiTietNhap.setGiaSP(giaNhap);

            String cungCap;
            System.out.print("Nha cung cap: ");
            cungCap = new Scanner(System.in).nextLine();
            chiTietNhap.setNhaCungCap(cungCap);
            chiTietNhap.setThongTinSPNhap(new SanPham(maSP, ten, xuatXu, giaBan, soLuong, (byte) 0));

            System.out.println("----------------");
            show(chiTietNhap);
            System.out.println("----------------");
            System.out.print("Tao phieu? (Y/N) ");
            if (!(new Scanner(System.in).nextLine()).equalsIgnoreCase("n")) {
                taoThanhCong = true;
                break;
            } else {
                taoThanhCong = false;
            }
            if (!taoThanhCong) {
                System.out.println("Nhap lai? (Y/N)");
                if ((new Scanner(System.in).nextLine()).equalsIgnoreCase("n")) {
                    return null;
                }
            }
        }

        return chiTietNhap;
// THIEU EXCEPTION
    }

    @Override
    public ChiTietHangXuat taoPhieuXuat(ArrayList<SanPham> listSanPham) {
        return null;
    }

    @Override
    public void show(ChiTietHangNhap hangNhap) {
        System.out.println("So phieu: " + hangNhap.getSoPhieu());
        System.out.println("Ngay tao: " + hangNhap.getStringNgayTao());
        System.out.println("Ma hang hoa: " + hangNhap.getMaHangHoa());
        System.out.println("Ten SP: " + hangNhap.getThongTinSPNhap().getTenGiay());
        System.out.println("So luong: " + hangNhap.getSoLuong());
        System.out.println("Gia nhap: " + hangNhap.getGiaSP());
        System.out.println("Nha cung cap: " + hangNhap.getNhaCungCap());
        System.out.println("Xuat xu: " + hangNhap.getThongTinSPNhap().getXuatXu());
        System.out.println("Thanh tien: " + hangNhap.thanhTien(hangNhap.getGiaSP()));
        System.out.println("Gia ban ra: " + hangNhap.getThongTinSPNhap().getGiaBan());
    }

    @Override
    public void show(ChiTietHangXuat hangXuat) {
    }

}

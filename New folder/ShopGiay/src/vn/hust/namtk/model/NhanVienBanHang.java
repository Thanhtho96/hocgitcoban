/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import vn.hust.namtk.controller.Common;

/**
 *
 * @author Admin
 */
public class NhanVienBanHang extends NhanVien {

    /**
     *
     * @return
     */
    private String matKhau;

    public NhanVienBanHang(String matKhau, String id, String ten, byte tuoi) {
        super(id, ten, tuoi);
        this.matKhau = matKhau;
    }       
    public float tinhLuong() {
        float luongNv;
        luongNv = luongcb + 2;
        return luongNv;
    }

    public NhanVienBanHang() {
    }

    public NhanVienBanHang(String id, String ten, byte tuoi, float luong) {
        super(id, ten, tuoi, luong);
    }

    public void nhapNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID: ");
        String id = sc.nextLine();
        setId(id);
        System.out.println("Ten NV: ");
        String ten = sc.nextLine();
        setTen(ten);
        System.out.println("Tuoi: ");
        byte tuoi = sc.nextByte();
        setTuoi(tuoi);
        System.out.println("Luong cb: ");
        float luong = sc.nextFloat();
        setLuong(luong);

    }

    public void hienNhanVien() {
        System.out.println("ID: " + getId());
        System.out.println("Ten NV: " + getTen());
        System.out.println("Tuoi: " + getTuoi());
        System.out.println("Luong: " + tinhLuong() + "d");
    }

    public float TinhTien() {
        float tinhtien = 0f;
        return tinhtien;
    }

    public void LapHoaDon(ArrayList<HoaDon> listHoaDon, ArrayList<SanPham> listSanPham) {
        System.out.print("Nhập ID sản phẩm: ");
        String id = new Scanner(System.in).nextLine();
        boolean check = false;
        HoaDon hoaDon;
        SanPham sanpham = null;
        for (SanPham x : listSanPham) {
            if (x.getMaGiay().equals(id)) {
                check = true;
                sanpham = x;
                break;
            }
        }
        if (check) {
            hoaDon = new HoaDon();
            hoaDon.setThongTinSP(sanpham);
            System.out.println(hoaDon.getThongTinSP().getTenGiay() + "\n" + hoaDon.getThongTinSP().getGiaBan() + "\n" + hoaDon.getThongTinSP().getSoLuong());
            hoaDon.setNgayTao();
            hoaDon.setIdNhanVien(id);
            while (true) {
                System.out.println("Nhập số lượng: ");
                int soLuong = new Scanner(System.in).nextInt();
                if (soLuong <= 0 || soLuong > hoaDon.getThongTinSP().getSoLuong()) {
                    System.out.println("Không hợp lệ");
                } else {
                    hoaDon.setSoLuong(soLuong);
                    break;
                }
            }
            System.out.println("------------");
            hoaDon.show();
            System.out.println("------------");
            System.out.print("Tạo phiếu?(y/n) ");
            String result = new Scanner(System.in).nextLine();
            if (result.equals("y")) {
                System.out.println("In phiếu...");
                sanpham.giamSoLuong(hoaDon.getSoLuong());
            }
        }

    }
}

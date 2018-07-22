/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import vn.hust.namtk.model.ChiTietHangXuat;

/**
 *
 * @author Lordđ
 */
public class TimKiemXuat extends AbsTimKiemXuat {

    private XuatHangController xuatHang = new XuatHangController();

    public void menu(ArrayList<ChiTietHangXuat> list) {
        byte n;
        do {
            System.out.println("1.Hien thi giao dich theo maSP\n2.Hien thi GD theo Ngay\n3.Hien thi GD theo Khoang thoi gian\n4.Tim kiem theo so phieu\n10.Thoat");
            do {
                System.out.print("Nhap lua chon: ");
                n = new Scanner(System.in).nextByte();
            } while (n < 1 || n > 10);
            switch (n) {
                case 1:
                    hienThiTheoMaSP(list);
                    break;
                case 2:
                    String date;
                    //do{
                    System.out.println("Nhap ngay (dd/MM/yyyy): ");
                    date = new Scanner(System.in).nextLine();
                    //}while(!date.matches("[0,9]{2}.[0,1]{1}[0,9]{1}.[0,9]{4}"));
                    hienThiTheoNgay(date, list);
                    break;
                case 3:
                    System.out.println("Tim kiem giao dich");
                    System.out.print("Tu ngay: ");
                    String dateMin = new Scanner(System.in).nextLine();
                    System.out.print("Den ngay: ");
                    String dateMax = new Scanner(System.in).nextLine();
                    hienThiTheoNgay(dateMin, dateMax, list);
                    break;
                case 4:
                    hienThiTheoSoPhieu(list);
                    break;
            }
        } while (n != 10);
    }

    @Override
    public void hienThiTheoMaSP(ArrayList<ChiTietHangXuat> list) {
        String maSP;
        System.out.print("Nhap ma can tim kiem: ");
        maSP = new Scanner(System.in).nextLine();
        boolean tonTai = false;
        for (ChiTietHangXuat x : list) {
            if (x.getMaHangHoa().equals(maSP)) {
                xuatHang.show(x);
                tonTai = true;
            }
        }
        if (!tonTai) {
            System.out.println("Khong tim thay " + maSP);
        }
    }

    @Override
    public void hienThiTheoNgay(String date, ArrayList<ChiTietHangXuat> list) {
        try {
            Date ngayTimKiem = new SimpleDateFormat("dd/MM/yyyy").parse(date);
            boolean tonTai = false;
            for (ChiTietHangXuat x : list) {
                //if(x.getStringNgayTao().regionMatches(0, date, 0, date.length())){
                /*if (x.getStringNgayTao().equals(date)) {
                    x.show();
                    tonTai = true;
                }*/
                if (x.getDateNgayTao().equals(ngayTimKiem)) {
                    xuatHang.show(x);
                    tonTai = true;
                }
            }
            if (!tonTai) {
                System.out.println("Khong ton tai");
            }
        } catch (ParseException ex) {
        }
        System.out.println("");
    }

    @Override
    public void hienThiTheoNgay(String stringDateMin, String stringDateMax, ArrayList<ChiTietHangXuat> list) {
        try {
            Date dateMin = new SimpleDateFormat("dd/MM/yyyy").parse(stringDateMin);
            Date dateMax = new SimpleDateFormat("dd/MM/yyyy").parse(stringDateMax);
            if (dateMax.before(dateMin)) {
                Date temp;
                temp = dateMin;
                dateMin = dateMax;
                dateMax = temp;
            }
            boolean tonTai = false;
            for (ChiTietHangXuat x : list) {
                //if(x.getStringNgayTao().regionMatches(0, date, 0, date.length())){
                if (x.getDateNgayTao().after(dateMin) && x.getDateNgayTao().before(dateMax)) {
                    xuatHang.show(x);
                    tonTai = true;
                }
            }
            if (!tonTai) {
                System.out.println("Khong ton tai");
            }
            System.out.println("");
        } catch (ParseException ex) {
        }
    }

    @Override
    public int timKiemTheoSoPhieu(ArrayList<ChiTietHangXuat> list) {
        int index = -1;
        System.out.print("Nhap so phieu: ");
        String soPhieu = new Scanner(System.in).nextLine();
        for (ChiTietHangXuat x : list) {
            index++;
            if (x.getSoPhieu().equals(soPhieu)) {
                break;
            }
        }
        return index;
    }

    @Override
    public void hienThiTheoSoPhieu(ArrayList<ChiTietHangXuat> list) {
        System.out.print("Nhap so phieu: ");
        String soPhieu = new Scanner(System.in).nextLine();
        for (ChiTietHangXuat x : list) {
            if (x.getSoPhieu().equals(soPhieu)) {
                xuatHang.show(x);
                break;
            }
        }
    }
}

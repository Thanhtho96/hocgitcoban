/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import vn.hust.namtk.model.ChiTietHangNhap;

/**
 *
 * @author Lordđ
 */
public abstract class AbsTimKiemNhap {
    public abstract void hienThiTheoMaSP(ArrayList<ChiTietHangNhap> list);

    public abstract void hienThiTheoNgay(String date, ArrayList<ChiTietHangNhap> list);

    public abstract void hienThiTheoNgay(String stringDateMin, String stringDateMax, ArrayList<ChiTietHangNhap> list);

    public abstract void hienThiTheoSoPhieu(ArrayList<ChiTietHangNhap> list);

    public abstract int timKiemTheoSoPhieu(ArrayList<ChiTietHangNhap> list);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import vn.hust.namtk.model.ChiTietHangXuat;

/**
 *
 * @author Lordđ
 */
public abstract class AbsTimKiemXuat {

    public abstract void hienThiTheoMaSP(ArrayList<ChiTietHangXuat> list);

    public abstract void hienThiTheoNgay(String date, ArrayList<ChiTietHangXuat> list);

    public abstract void hienThiTheoNgay(String stringDateMin, String stringDateMax, ArrayList<ChiTietHangXuat> list);

    public abstract void hienThiTheoSoPhieu(ArrayList<ChiTietHangXuat> list);

    public abstract int timKiemTheoSoPhieu(ArrayList<ChiTietHangXuat> list);
}

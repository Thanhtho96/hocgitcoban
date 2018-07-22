/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import java.util.List;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Lordđ
 */
public abstract class AbsTimKiemSP {
    public abstract int timKiemTheoID(ArrayList<SanPham> sanpham,String id);
    public abstract int timKiemTheoTen(ArrayList<SanPham> sanpham, String ten);
    public abstract ArrayList<Integer> timKiemTheoXuatXu(ArrayList<SanPham> sanpham, String xuatXu);
    public abstract ArrayList<Integer> timKiemTheoGia(ArrayList<SanPham> sanpham, double giaMin, double giaMax);
}

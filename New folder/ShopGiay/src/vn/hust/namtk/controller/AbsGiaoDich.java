/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.hust.namtk.controller;

import java.util.ArrayList;
import vn.hust.namtk.model.ChiTietHangNhap;
import vn.hust.namtk.model.ChiTietHangXuat;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Lordđ
 */
public abstract class AbsGiaoDich {
    public abstract ChiTietHangNhap taoPhieuNhap (ArrayList<SanPham> listSanPham);
    public abstract ChiTietHangXuat taoPhieuXuat (ArrayList<SanPham> listSanPham);
    public abstract void show(ChiTietHangNhap hangNhap);
    public abstract void show(ChiTietHangXuat hangXuat);
}

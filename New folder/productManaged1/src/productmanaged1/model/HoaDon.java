/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productmanaged1.model;

/**
 *
 * @author Xuan
 */
public class HoaDon implements IBasic{
    private byte NgayDat;
    private byte NgayNhanHang;
    private byte HinhThucGiaoHang;
    private byte PhiGiaoHang;

    public HoaDon() {
    }

    public HoaDon(byte NgayDat, byte NgayNhanHang, byte HinhThucGiaoHang, byte PhiGiaoHang) {
        this.NgayDat = NgayDat;
        this.NgayNhanHang = NgayNhanHang;
        this.HinhThucGiaoHang = HinhThucGiaoHang;
        this.PhiGiaoHang = PhiGiaoHang;
    }

    @Override
    public void nhapThongTin() {
        System.out.println("nhap ngay dat:");
        System.out.println("ngay giao hang:");
        System.out.println("hinh thuc giao hang:");
        System.out.println("phi giao hang:");
    }

    @Override
    public void inThongTin() {
        System.out.println(""+this.NgayDat);
        System.out.println(""+this.HinhThucGiaoHang);
        System.out.println(""+this.NgayNhanHang);
        System.out.println(""+this.PhiGiaoHang);
        
    }
    
}

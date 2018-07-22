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
import vn.hust.namtk.model.HoaDon;
import vn.hust.namtk.model.NhanVienBanHang;
import vn.hust.namtk.model.SanPham;

/**
 *
 * @author Admin
 */
public class ProcessMain {

    public static void main(String[] args) {
        ArrayList<SanPham> sanpham = new ArrayList<>();//để lưu thông tin của các sản phẩm
        ArrayList<ChiTietHangNhap> listNhapHang = new ArrayList<>();
        ArrayList<ChiTietHangXuat> listXuatHang = new ArrayList<>();
        ArrayList<HoaDon> listHoaDon = new ArrayList<>();
        UserController ul = new UserController();
        NhanVienBanHang nvTest = new NhanVienBanHang(Common.getPASSWORD_NV(), Common.getUSER_NAME_NV(), "Nguyen Van A",(byte)20);
        int nutchon1;
        do {
            System.out.println("Chọn chức năng");
            System.out.println("1.Show hàng");
            System.out.println("2.Nhân Viên");
            System.out.println("3.Quản lí");
            System.out.println("4.Exit");
            System.out.println("Chọn nhanh không là thoát: ");
            do {
                nutchon1 = new Scanner(System.in).nextInt();
            } while (nutchon1 < 1 || nutchon1 > 4);
            switch (nutchon1) {
                case 1: {
                    System.out.println("Chào mừng bố con nhà bạn đến với cửa hàng của chúng tôi\n"
                            + "Mời bạn xem các thông tin về sản phẩm \n");
                    for (SanPham x : sanpham) {
                        System.out.println("--------------------------");
                        System.out.println(x.toString());
                        System.out.println("--------------------------");
                    }
                }
                break;
                case 2: {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Bạn là nhân viên?");
                    System.out.println("Mời bạn đăng nhập:");
                    System.out.print("Nhập username: ");
                    String username = sc.nextLine();
                    System.out.print("Nhập pass: ");
                    String pass = sc.nextLine();
                    boolean bl = ul.login(username, pass);
                    if (bl) {
                        System.out.println("Đăng nhập thành công!");

                        Byte nutchon2;
                        do {
                            System.out.println("1.Show hàng");
                            System.out.println("2.Tìm kiếm SP");
                            System.out.println("3.Bán Hàng");
                            System.out.println("4.Exit");
                            do {
                                nutchon2 = new Scanner(System.in).nextByte();
                            } while (nutchon2 < 1 || nutchon2 > 4);
                            switch (nutchon2) {
                                case 1:
                                    for (SanPham x : sanpham) {
                                        System.out.println("--------");
                                        System.out.println(x.toString());
                                        System.out.println("--------");
                                    }
                                    break;
                                case 2: {
                                    TimKiemSanPham timkiem = new TimKiemSanPham();
                                    timkiem.menu(sanpham);
                                    break;
                                }
                                case 3: {
                                    nvTest.LapHoaDon(listHoaDon, sanpham);
                                    break;
                                }
                                case 4:
                                    System.out.println("Goodbye!");
                                    System.exit(0); //
                                default: {
                                    System.out.println("Lại sai");
                                }
                            }
                        } while (nutchon2 != 4);
                    } else {
                        System.out.println("Đăng nhập thất bại");
                    }
                }
                break;
                case 3: {
                    System.out.println("Bạn là Quản Lí?");
                    System.out.println("Mời bạn đăng nhập");
                    System.out.print("Nhập username: ");
                    String username = new Scanner(System.in).nextLine();
                    System.out.print("Nhập pass: ");
                    String pass = new Scanner(System.in).nextLine();
                    boolean bl = ul.login(username, pass, 0);
                    if (bl) {
                        System.out.println("Đăng nhập thành công");

                        byte nutchon3;
                        do {
                            System.out.println("1.Show hàng");
                            System.out.println("2.Tim kiem SP");
                            System.out.println("4.Nhập hàng");
                            System.out.println("5.Xuất hàng");
                            System.out.println("6.Kho?");
                            System.out.println("7.Quản lý nhân viên");
                            System.out.println("8.Exit");
                            System.out.print("Chon: ");
                            do {
                                nutchon3 = new Scanner(System.in).nextByte();

                            } while (nutchon3 < 1 || nutchon3 > 8);
                            switch (nutchon3) {
                                case 1: {
                                    for (SanPham x : sanpham) {
                                        System.out.println(x.toString());
                                    }

                                }
                                break;
                                case 2: {
                                    TimKiemSanPham timkiem = new TimKiemSanPham();
                                    timkiem.menu(sanpham);
                                    break;
                                }
                                
                                case 4: {
                                    new MenuNhapHang().run(listNhapHang, sanpham);
                                }
                                break;
                                case 5: {
                                    new MenuXuatHang().run(listXuatHang, sanpham);
                                }
                                break;
                                case 6: {
                                    SanPhamController spControl = new SanPhamController();
                                    TimKiemSanPham timKiem = new TimKiemSanPham();
                                    int nutchon5;
                                    do {
                                        System.out.println("1. Điều chỉnh giá sản phẩm");
                                        System.out.println("2. Xóa sản phẩm");
                                        System.out.println("3. Thoát");
                                        do {
                                            System.out.print("Nhập lựa chọn: ");
                                            nutchon5 = new Scanner(System.in).nextInt();
                                        } while (nutchon5 < 1 || nutchon5 > 3);
                                        switch (nutchon5) {
                                            case 1: {
                                                System.out.print("Nhập id sp: ");
                                                spControl.dieuChinhGia(sanpham, new Scanner(System.in).nextLine());
                                                break;
                                            }
                                            case 2: {
                                                System.out.print("Nhập id sp: ");
                                                spControl.xoaSanPham(sanpham, new Scanner(System.in).nextLine());
                                                break;
                                            }

                                            case 3:
                                                break;
                                        }
                                    } while (nutchon5 != 3);
                                }
                                break;
                                case 7:
                                    /*********************/
                                    break;
                                case 8:
//                                    System.out.println("Goodbye");
//                                    System.exit(0);
                                    break;
                                default: {

                                }
                            }
                        } while (nutchon3 != 8);
                    }

                }
                break;
                default: {
                    System.out.println("Nhập lại tử tế đi!");
                }
            }
        } while (nutchon1 != 4);
    }
}

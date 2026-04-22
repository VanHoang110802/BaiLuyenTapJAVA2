package model;

import java.math.BigDecimal;
import java.util.Scanner;

public class DonHang {

    private int idDonHang;
    private int maDonHang;
    private String tenKhachHang;
    private BigDecimal tongTien;

    public DonHang() {
    }

    public DonHang(int idDonHang, int maDonHang, String tenKhachHang, BigDecimal tongTien) {
        this.idDonHang = idDonHang;
        this.maDonHang = maDonHang;
        this.tenKhachHang = tenKhachHang;
        this.tongTien = tongTien;
    }

    public int getIdDonHang() {
        return idDonHang;
    }

    public void setIdDonHang(int idDonHang) {
        this.idDonHang = idDonHang;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public BigDecimal getTongTien() {
        return tongTien;
    }

    public void setTongTien(BigDecimal tongTien) {
        this.tongTien = tongTien;
    }

    public void nhapDonHang() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Nhap ma don hang: ");
                this.maDonHang = Integer.parseInt(sc.nextLine());
                if (this.maDonHang > 0) {
                    break;
                }
                System.out.println("Ma don hang phai > 0!");
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang!");
            }
        }
        while (true) {
            System.out.print("Nhap ten khach hang: ");
            this.tenKhachHang = sc.nextLine();
            if (!this.tenKhachHang.matches("[a-zA-Z]+$")) {
                System.out.println("Nhap khong hop le, xin hay kiem tra lai!");

            } else {
                break;
            }
        }

        while (true) {
            try {
                System.out.print("Nhap tong tien: ");
                this.tongTien = new BigDecimal(sc.nextLine());
                if (tongTien.compareTo(BigDecimal.ZERO) > 0) {
                    break;
                }
                System.out.println("Tong tien phai > 0!");
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang tien!");
            }
        }

        //System.out.print("Nhap tong tien: ");
        //this.tongTien = new BigDecimal(sc.nextLine());
    }

    @Override
    public String toString() {
        return "DonHang{" + "idDonHang=" + idDonHang + ", maDonHang=" + maDonHang + ", tenKhachHang=" + tenKhachHang + ", tongTien=" + tongTien + '}';
    }

}

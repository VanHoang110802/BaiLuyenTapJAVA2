package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Sach {

    private String maSach;
    private String tenSach;
    private String nhaXuatBan;
    private int soTrang;
    private int soLuong;
    private BigDecimal giaTien;
    private LocalDate ngayNhap;
    private String viTriDatSach;
    private String maTheLoai;

    public Sach() {
    }

    public Sach(String maSach, String tenSach, String nhaXuatBan, int soTrang, int soLuong, BigDecimal giaTien, LocalDate ngayNhap, String viTriDatSach, String maTheLoai) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.soTrang = soTrang;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.ngayNhap = ngayNhap;
        this.viTriDatSach = viTriDatSach;
        this.maTheLoai = maTheLoai;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(BigDecimal giaTien) {
        this.giaTien = giaTien;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getViTriDatSach() {
        return viTriDatSach;
    }

    public void setViTriDatSach(String viTriDatSach) {
        this.viTriDatSach = viTriDatSach;
    }

    public String getMaTheLoai() {
        return maTheLoai;
    }

    public void setMaTheLoai(String maTheLoai) {
        this.maTheLoai = maTheLoai;
    }

    public String validTheLoai(String _theLoai) {

        String ans;
        _theLoai = _theLoai.toUpperCase();

        switch (_theLoai) {

            case "CN":
                ans = "Cong nghe thong tin";
                break;

            case "DL":
                ans = "Du lich";
                break;
            case "GD":
                ans = "Giao duc";
                break;
            case "IT":
                ans = "Tin hoc";
                break;
            case "KT":
                ans = "Kinh te";
                break;

            case "NN":
                ans = "Ngoai Ngu";
                break;
            case "VH":
                ans = "Van hoc";
                break;
            default: {
                System.out.println("The loai khong hop le!");
                ans = null;
            }
        }
        return ans;
    }

    public void nhapMaSach() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ma sach: ");
        this.maSach = sc.nextLine();
    }

    public void nhapSach() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap ten sach: ");
        this.tenSach = sc.nextLine();
        System.out.print("Nhap nha xuat ban: ");
        this.nhaXuatBan = sc.nextLine();
        while (true) {
            try {
                System.out.print("Nhap so trang: ");
                this.soTrang = Integer.parseInt(sc.nextLine());
                if (soTrang > 0) {
                    break;
                }
                System.out.println("So trang phai > 0!");
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang so!");
            }
        }

        while (true) {
            try {
                System.out.print("Nhap so luong sach: ");
                this.soLuong = Integer.parseInt(sc.nextLine());
                if (soLuong > 0) {
                    break;
                }
                System.out.println("So luong phai > 0!");
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang so!");
            }
        }
        while (true) {
            try {
                System.out.print("Nhap gia tien: ");
                this.giaTien = new BigDecimal(sc.nextLine());
                if (giaTien.compareTo(BigDecimal.ZERO) > 0) {
                    break;
                }
                System.out.println("Gia tien phai > 0!");
            } catch (Exception e) {
                System.out.println("Nhap sai dinh dang tien!");
            }
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            try {
                System.out.print("Nhap ngay nhap (yyyy-MM-dd): ");
                String input = sc.nextLine();
                this.ngayNhap = LocalDate.parse(input, dtf);
                break;
            } catch (Exception e) {
                System.out.println("Sai dinh dang ngay! VD: 2026-10-01");
            }
        }
        System.out.print("Nhap vi tri dat: ");
        this.viTriDatSach = sc.nextLine();
        while (true) {
            System.out.print("(CN: Cong nghe thong tin, DL: Du lich, GD: Giao duc, IT: Tin hoc, KT: Kinh te, NN: Ngoai Ngu, VH: Van hoc)\nNhap ma the loai: ");
            this.maTheLoai = sc.nextLine();
            if (validTheLoai(this.maTheLoai) != null) {
                break;
            } else {
                System.out.println("Ma hop le la nhung ki tu duoc viet in hoa o trong ngoac!");
            }
        }

    }

    @Override
    public String toString() {
        return "Sach{" + "maSach=" + maSach + ", tenSach=" + tenSach + ", nhaXuatBan=" + nhaXuatBan + ", soTrang=" + soTrang + ", soLuong=" + soLuong + ", giaTien=" + giaTien + ", ngayNhap=" + ngayNhap + ", viTriDatSach=" + viTriDatSach + ", maTheLoai=" + validTheLoai(maTheLoai) + '}';
    }

}

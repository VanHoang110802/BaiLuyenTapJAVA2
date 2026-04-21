package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import model.Sach;
import repository.RepoSach;

public class MainSach {

    public static Scanner sc = new Scanner(System.in);
    public static RepoSach _repo = new RepoSach();

    public static void hienThiTT() {
        ArrayList<Sach> _lstSach = _repo.getAll();
        for (Sach _s : _lstSach) {
            System.out.println(_s);
        }
    }

    public static void themTT() {
        Sach _sach = new Sach();

        _sach.nhapMaSach();
        _sach.nhapSach();

        String xacNhan;
        while (true) {
            System.out.print("Ban co chac chan muon them khong? (y/n): ");
            xacNhan = sc.nextLine();

            if (xacNhan.equalsIgnoreCase("y") || xacNhan.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Xin hay nhap dung!");
            }
        }
        if (xacNhan.equalsIgnoreCase("y")) {

            int kq = _repo.insertSach(_sach);

            if (kq > 0) {
                System.out.println("Them thanh cong!");
                for (Sach x : _repo.getAll()) {
                    System.out.println(x);
                }
            } else {
                System.out.println("Them that bai!");
            }

        } else {
            System.out.println("Lan sau nho chu y nhe!");
        }

    }

    public static void xoaTT() {
        System.out.print("Nhap id can xoa: ");
        String _id = sc.nextLine();

        String xacNhan;
        while (true) {
            System.out.print("Ban co chac chan muon xoa khong? (y/n): ");
            xacNhan = sc.nextLine();

            if (xacNhan.equalsIgnoreCase("y") || xacNhan.equalsIgnoreCase("n")) {
                break;
            } else {
                System.out.println("Xin hay nhap dung!");
            }
        }
        if (xacNhan.equalsIgnoreCase("y")) {
            int kq = _repo.deleteSach(_id);

            if (kq > 0) {
                System.out.println("Xoa thanh cong!");
                hienThiTT();
            } else {
                System.out.println("Xoa that bai!");
            }
        } else {
            System.out.println("Lan sau nho chu y nhe!");
        }

    }

    public static void suaTT() {
        System.out.print("Nhap id can sua: ");
        String _ma = sc.nextLine();

        ArrayList<Sach> _list = _repo.getAll();
        Sach _sach = null;

        for (Sach _x : _list) {
            if (_x.getMaSach().equalsIgnoreCase(_ma)) {
                _sach = _x;
                break;
            }
        }

        if (_sach == null) {
            System.out.println("Khong tim thay!");
            return;
        }
        _sach.nhapSach();
        
        String xacNhan;
        while (true) {
            System.out.print("Ban co chac chan muon sua khong? (y/n): ");
            xacNhan = sc.nextLine();

            if (xacNhan.equalsIgnoreCase("y") || xacNhan.equalsIgnoreCase("n")) {
                break;
            }
        }
        if (xacNhan.equalsIgnoreCase("y")) {
            int kq = _repo.updateSach(_sach);

            if (kq > 0) {
                System.out.println("Update thanh cong!");
                hienThiTT();
            } else {
                System.out.println("Update that bai!");
            }
        } else {
            System.out.println("Lan sau nho chu y nhe!");
        }

    }

    public static void timKiemTheoMa() {
        String _ma;
        while (true) {
            System.out.print("Nhap ma can tim: ");
            _ma = sc.nextLine();
            if (_ma == null || !_ma.matches("^[a-zA-Z0-9]+$")) {
                System.out.println("Chi duoc nhap ma la chu hoac so!");
            } else {
                break;
            }
        }

        Sach _tmpSach = _repo.findByID(_ma);

        if (_tmpSach != null) {
            System.out.println("Tim thay thanh cong!");
            System.out.println(_tmpSach);
        } else {
            System.out.println("Khong tim thay!");
        }
    }

    public static void timKiemTheoNgayNhap() {
        LocalDate _ngayBatDau, _ngayKetThuc;
        DateTimeFormatter _dtfBatDau = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter _dtfKetThuc = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.print("Nhap ngay bat dau: ");
            String _inputBatDau = sc.nextLine();
            try {
                _ngayBatDau = LocalDate.parse(_inputBatDau, _dtfBatDau);
                break;
            } catch (Exception e) {
                System.out.println("Dinh dang ngay khong hop le, xin hay kiem tra lai!");
            }

        }

        while (true) {
            System.out.print("Nhap ngay ket thuc: ");
            String _inputKetThuc = sc.nextLine();
            try {
                _ngayKetThuc = LocalDate.parse(_inputKetThuc, _dtfKetThuc);
                break;
            } catch (Exception e) {
                System.out.println("Dinh dang ngay khong hop le, xin hay kiem tra lai!");
            }

        }

        ArrayList<Sach> _lstTKSach = _repo.findByDate(_ngayBatDau, _ngayKetThuc);
        for (Sach _s : _lstTKSach) {
            System.out.println(_s);
        }
    }

    public static void sapXepTangDan() {
        ArrayList<Sach> _lstTKSach = _repo.sortByASC();
        for (Sach _s : _lstTKSach) {
            System.out.println(_s);
        }
    }

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 30; i++) {
                System.out.println(); // clear
            }

            System.out.println("\n------------MENU------------");
            System.out.println("1. Hien thi");
            System.out.println("2. Them");
            System.out.println("3. Xoa");
            System.out.println("4. Sua");
            System.out.println("5. Tim kiem");
            System.out.println("6. Sap xep");
            System.out.println("7. Thoat");
            System.out.print("Nhap lua chon: ");

            String _input = sc.nextLine();
            if (!_input.matches("\\d+")) {
                System.out.println("Lua chon khong hop le, xin hay kiem tra lai");
                continue;
            }

            int _luaChon = Integer.parseInt(_input);
            switch (_luaChon) {
                case 1:
                    hienThiTT();
                    break;
                case 2:
                    themTT();
                    break;
                case 3:
                    xoaTT();
                    break;
                case 4:
                    suaTT();
                    break;
                case 5:
                    //timKiemTheoMa();
                    timKiemTheoNgayNhap();
                    break;
                case 6:
                    sapXepTangDan();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Lua chon khong hop le, xin hay kiem tra lai");
            }
            if (_luaChon == 7) {
                break;
            }
            System.out.println("Nhan Enter de tiep tuc...");
            sc.nextLine();
        }
    }
}

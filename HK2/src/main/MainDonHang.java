package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.DonHang;
import repository.RepoDonHang;

public class MainDonHang {

    public static Scanner sc = new Scanner(System.in);
    public static RepoDonHang _repo = new RepoDonHang();

    public static void hienThiTT() {
        ArrayList<DonHang> _lstDonHang = _repo.getAll();
        for (DonHang _dh : _lstDonHang) {
            System.out.println(_dh);
        }
    }

    public static void themTT() {
        DonHang _donHang = new DonHang();

        _donHang.nhapDonHang();

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

            int kq = _repo.insertDonHang(_donHang);

            if (kq > 0) {
                System.out.println("Them thanh cong!");
                for (DonHang x : _repo.getAll()) {
                    System.out.println(x);
                }
            } else {
                System.out.println("Them that bai!");
            }

        } else {
            System.out.println("Lan sau nho chu y nhe!");
        }
    }

    public static void suaTT() {
        System.out.print("Nhap id can sua: ");
        int _ma = Integer.parseInt(sc.nextLine());

        ArrayList<DonHang> _list = _repo.getAll();
        DonHang _donHang = null;

        for (DonHang _x : _list) {
            if (_x.getIdDonHang() == _ma) {
                _donHang = _x;
                break;
            }
        }

        if (_donHang == null) {
            System.out.println("Khong tim thay!");
            return;
        }
        _donHang.nhapDonHang();

        String xacNhan;
        while (true) {
            System.out.print("Ban co chac chan muon sua khong? (y/n): ");
            xacNhan = sc.nextLine();

            if (xacNhan.equalsIgnoreCase("y") || xacNhan.equalsIgnoreCase("n")) {
                break;
            }
        }
        if (xacNhan.equalsIgnoreCase("y")) {
            int kq = _repo.updateDonHang(_donHang);

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

    public static void xoaTT() {
        System.out.print("Nhap id can xoa: ");
        int _id = Integer.parseInt(sc.nextLine());

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
            int kq = _repo.deleteDonHang(_id);

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

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n----------MENU----------");
            System.out.println("1. Hien thi");
            System.out.println("2. Them");
            System.out.println("3. Sua");
            System.out.println("4. Xoa");
            System.out.println("5. Thoat");
            System.out.print("Vui long chon: ");
            String _input = sc.nextLine();
            if (!_input.matches("\\d+")) {
                System.out.println("Nhap khong hop le, xin hay kiem tra lai!");
                continue;
            }
            int _chon = Integer.parseInt(_input);
            switch (_chon) {
                case 1:
                    hienThiTT();
                    break;

                case 2:
                    themTT();
                    break;
                case 3:
                    suaTT();
                    break;
                case 4:
                    xoaTT();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Nhap khong hop le, xin hay kiem tra lai!");
            }
            if (_chon == 5) {
                break;
            }
        }
    }
}

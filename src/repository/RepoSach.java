package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Sach;
import util.DBConnect;

public class RepoSach {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;

    public RepoSach() {
        con = DBConnect.getConnection();
    }

    public ArrayList<Sach> getAll() {
        ArrayList<Sach> _lstSach = new ArrayList();
        sql = "SELECT Masach, TenSach, NXB, Sotrang, SoLuong, Giatien, NgayNhap, vitridat, MaTheLoai FROM SACH";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String _maSach = rs.getString("Masach");
                String _tenSach = rs.getString("TenSach");
                String _nxb = rs.getString("NXB");
                int _soTrang = rs.getInt("Sotrang");
                int _soLuong = rs.getInt("SoLuong");
                BigDecimal _giaTien = rs.getBigDecimal("Giatien");
                LocalDate _ngayNhap = (rs.getDate("NgayNhap") != null) ? rs.getDate("NgayNhap").toLocalDate() : null;
                String _viTriDat = rs.getString("vitridat");
                String _maTheLoai = rs.getString("MaTheLoai");

                _lstSach.add(new Sach(_maSach, _tenSach, _nxb, _soTrang, _soLuong, _giaTien, _ngayNhap, _viTriDat, _maTheLoai));
            }

            return _lstSach;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertSach(Sach _sach) {
        sql = "INSERT INTO SACH(Masach, TenSach, NXB, Sotrang, SoLuong, Giatien, NgayNhap, vitridat, MaTheLoai) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, _sach.getMaSach());
            ps.setString(2, _sach.getTenSach());
            ps.setString(3, _sach.getNhaXuatBan());
            ps.setInt(4, _sach.getSoTrang());
            ps.setInt(5, _sach.getSoLuong());
            ps.setBigDecimal(6, _sach.getGiaTien());
            if (_sach.getNgayNhap() != null) {
                ps.setDate(7, java.sql.Date.valueOf(_sach.getNgayNhap()));
            } else {
                ps.setDate(7, null);
            }
            ps.setString(8, _sach.getViTriDatSach());
            ps.setString(9, _sach.getMaTheLoai());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteSach(String _id) {
        sql = "DELETE FROM SACH WHERE Masach = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, _id);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateSach(Sach _sach) {
        sql = "UPDATE SACH SET TenSach = ?, NXB = ?, Sotrang = ?, SoLuong = ?, Giatien = ?, NgayNhap = ?, vitridat = ?, MaTheLoai = ? WHERE Masach = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, _sach.getTenSach());
            ps.setString(2, _sach.getNhaXuatBan());
            ps.setInt(3, _sach.getSoTrang());
            ps.setInt(4, _sach.getSoLuong());
            ps.setBigDecimal(5, _sach.getGiaTien());
            if (_sach.getNgayNhap() != null) {
                ps.setDate(6, java.sql.Date.valueOf(_sach.getNgayNhap()));
            } else {
                ps.setDate(6, null);
            }
            ps.setString(7, _sach.getViTriDatSach());
            ps.setString(8, _sach.getMaTheLoai());
            ps.setString(9, _sach.getMaSach());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Sach findByID(String _maCanTim) {
        Sach _tmpSach = null;
        sql = "SELECT Masach, TenSach, NXB, Sotrang, SoLuong, Giatien, NgayNhap, vitridat, MaTheLoai FROM SACH WHERE Masach = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, _maCanTim);

            rs = ps.executeQuery();

            if (rs.next()) {
                String _maSach = rs.getString("Masach");
                String _tenSach = rs.getString("TenSach");
                String _nxb = rs.getString("NXB");
                int _soTrang = rs.getInt("Sotrang");
                int _soLuong = rs.getInt("SoLuong");
                BigDecimal _giaTien = rs.getBigDecimal("Giatien");
                LocalDate _ngayNhap = (rs.getDate("NgayNhap") != null) ? rs.getDate("NgayNhap").toLocalDate() : null;
                String _viTriDat = rs.getString("vitridat");
                String _maTheLoai = rs.getString("MaTheLoai");

                _tmpSach = new Sach(_maSach, _tenSach, _nxb, _soTrang, _soLuong, _giaTien, _ngayNhap, _viTriDat, _maTheLoai);
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return _tmpSach;
    }

    public ArrayList<Sach> findByDate(LocalDate _date1, LocalDate _date2) {
        ArrayList<Sach> _lstSach = new ArrayList();
        sql = "SELECT Masach, TenSach, NXB, Sotrang, SoLuong, Giatien, NgayNhap, vitridat, MaTheLoai FROM SACH WHERE NgayNhap BETWEEN ? AND ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(_date1));
            ps.setDate(2, java.sql.Date.valueOf(_date2));

            rs = ps.executeQuery();

            while (rs.next()) {
                String _maSach = rs.getString("Masach");
                String _tenSach = rs.getString("TenSach");
                String _nxb = rs.getString("NXB");
                int _soTrang = rs.getInt("Sotrang");
                int _soLuong = rs.getInt("SoLuong");
                BigDecimal _giaTien = rs.getBigDecimal("Giatien");
                LocalDate _ngayNhap = (rs.getDate("NgayNhap") != null) ? rs.getDate("NgayNhap").toLocalDate() : null;
                String _viTriDat = rs.getString("vitridat");
                String _maTheLoai = rs.getString("MaTheLoai");

                _lstSach.add(new Sach(_maSach, _tenSach, _nxb, _soTrang, _soLuong, _giaTien, _ngayNhap, _viTriDat, _maTheLoai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _lstSach;
    }

    public ArrayList<Sach> sortByASC() { /// sort tang dan, giam dan thi DESC
        ArrayList<Sach> _lstSach = new ArrayList();
        sql = "SELECT Masach, TenSach, NXB, Sotrang, SoLuong, Giatien, NgayNhap, vitridat, MaTheLoai FROM SACH ORDER BY Giatien ASC";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String _maSach = rs.getString("Masach");
                String _tenSach = rs.getString("TenSach");
                String _nxb = rs.getString("NXB");
                int _soTrang = rs.getInt("Sotrang");
                int _soLuong = rs.getInt("SoLuong");
                BigDecimal _giaTien = rs.getBigDecimal("Giatien");
                LocalDate _ngayNhap = (rs.getDate("NgayNhap") != null) ? rs.getDate("NgayNhap").toLocalDate() : null;
                String _viTriDat = rs.getString("vitridat");
                String _maTheLoai = rs.getString("MaTheLoai");

                _lstSach.add(new Sach(_maSach, _tenSach, _nxb, _soTrang, _soLuong, _giaTien, _ngayNhap, _viTriDat, _maTheLoai));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return _lstSach;

    }

}

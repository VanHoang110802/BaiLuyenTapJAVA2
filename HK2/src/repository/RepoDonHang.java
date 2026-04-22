package repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.DonHang;
import util.DBConnect;

public class RepoDonHang {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private String sql = null;
    
    public RepoDonHang() {
        con = DBConnect.getConnection();
    }
    
    public ArrayList<DonHang> getAll() {
        ArrayList<DonHang> _lstDH = new ArrayList();
        sql = "SELECT id, ma_don, ten_khach, tong_tien FROM don_hang";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int _idDonHang = rs.getInt("id");
                int _maDon = rs.getInt("ma_don");
                String _tenKhach = rs.getString("ten_khach");
                BigDecimal _tongTien = rs.getBigDecimal("tong_tien");
                
                _lstDH.add(new DonHang(_idDonHang, _maDon, _tenKhach, _tongTien));
            }

            return _lstDH;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int insertDonHang(DonHang _donHang) {
        sql = "INSERT INTO don_hang(ma_don, ten_khach, tong_tien) VALUES(?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, _donHang.getMaDonHang());
            ps.setString(2, _donHang.getTenKhachHang());
            ps.setBigDecimal(3, _donHang.getTongTien());
            
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public int updateDonHang(DonHang _donHang){
       sql = "UPDATE don_hang SET ma_don = ?, ten_khach = ?, tong_tien = ? WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);

            ps.setInt(1, _donHang.getMaDonHang());
            ps.setString(2, _donHang.getTenKhachHang());
            ps.setBigDecimal(3, _donHang.getTongTien());
            ps.setInt(4, _donHang.getIdDonHang());

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteDonHang(int _id) {
        sql = "DELETE FROM don_hang WHERE id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, _id);

            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
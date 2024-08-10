package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.KhachHang;

public class KhachHang_DAO {
	public boolean themKhachHang(KhachHang newinfo) {
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("INSERT INTO KhachHang VALUES(?,?,?,?,?)");
			ps.setString(1, newinfo.getMaKhachHang());
			ps.setString(2, newinfo.getTenKhachHang());
			ps.setString(3, newinfo.getSoDienThoai());
			ps.setString(4, newinfo.getDiaChi());
			ps.setDate(5, Date.valueOf(newinfo.getNgaySinh()));
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean xoaKhachHang(String maKH) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM KhachHang WHERE MaKH=?");
			stmt.setString(1, maKH);
			return stmt.executeUpdate() > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public KhachHang timKhachHang(String maKHCanTim) {
		KhachHang khachHangCanTim = null;
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("Select * from KhachHang where MaKH=?");
			ps.setString(1, maKHCanTim);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				khachHangCanTim = new KhachHang();
				khachHangCanTim.setMaKhachHang(rs.getString(1));
				khachHangCanTim.setTenKhachHang(rs.getString(2));
				khachHangCanTim.setSoDienThoai(rs.getString(3));
				khachHangCanTim.setDiaChi(rs.getString(4));
				khachHangCanTim.setNgaySinh(rs.getDate(5).toLocalDate());
			}
		} catch (Exception e) {
			return null;
		}
		return khachHangCanTim;
	}

	public boolean capNhatKhachHang(KhachHang kh) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement(
					"Update KhachHang set TenKhachHang=?,SoDienThoai=?,DiaChi=?,NgaySinh=? Where MaKH=?");
			ps.setString(1, kh.getTenKhachHang());
			ps.setString(2, kh.getSoDienThoai());
			ps.setString(3, kh.getDiaChi());
			ps.setDate(4, Date.valueOf(kh.getNgaySinh()));
			ps.setString(5, kh.getMaKhachHang());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<KhachHang> getDsKhachHang() {
		ArrayList<KhachHang> dsKhachHang = new ArrayList<KhachHang>();
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("Select * from KhachHang");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setMaKhachHang(rs.getString(1));
				kh.setTenKhachHang(rs.getString(2));
				kh.setSoDienThoai(rs.getString(3));
				kh.setDiaChi(rs.getString(4));
				kh.setNgaySinh(rs.getDate(5).toLocalDate());
				dsKhachHang.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsKhachHang;
	}

	/////////////////////// 28/4/2024 Phát
	public String timMaKhachHangTheoTen(String tenKh) {
		String maKH = null;
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Select MaKH from KhachHang where TenKhachHang = ?");
			ps.setString(1, tenKh);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				maKH = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maKH;
	}
}

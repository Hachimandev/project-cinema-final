package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

@SuppressWarnings("unused")
public class HoaDon_DAO {
	private ArrayList<HoaDon> dsHoaDon;

	// lấy danh sách phim
	public ArrayList<HoaDon> getAllTBHoaDon() {
		dsHoaDon = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString("MaHoaDon");
				// lấy ngày kiểu date
				Date ngayLapDate = rs.getDate("NgayLapHD");
				// đổi data thành localdate
				LocalDate ngayLap = ngayLapDate.toLocalDate();
				KhachHang kh = new KhachHang(rs.getString("MaKH"));
				NhanVien dc = new NhanVien(rs.getString("MaNhanVien"));
				HoaDon hd = new HoaDon(maHD, ngayLap, kh, dc);
				dsHoaDon.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsHoaDon;
	}

	public boolean xoaHoaDon(String maHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HoaDon where MaHoaDon = ?");
			stmt.setString(1, maHD);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	////////////////////////////// 28/4/2024 Phát
	public String layMaHoaDonCuoi() {
		String maHoaDonCuoi = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ConnectDB.getInstance();
			conn = ConnectDB.getConnection();
			ps = conn.prepareStatement("select top 1 MaHoaDon from HoaDon order by MaHoaDon desc");
			rs = ps.executeQuery();
			if (rs.next()) {
				maHoaDonCuoi = rs.getString("MaHoaDon");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return maHoaDonCuoi;
	}

	public boolean themHoaDon(HoaDon hd) {
		try {
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("insert into HoaDon values(?,?,?,?)");
			ps.setString(1, hd.getMaHoaDon());
			ps.setDate(2, Date.valueOf(hd.getNgayLapHD()));
			ps.setString(3, hd.getMaKhachHang().getMaKhachHang());
			ps.setString(4, hd.getMaNhanVien().getMaNhanVien());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean themHoaDon2(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("insert into HoaDon values(?, ?, ?, ?)");
			stmt.setString(1, hd.getMaHoaDon());
			stmt.setString(2, hd.getMaKhachHang().getMaKhachHang());
			java.sql.Date ngayLap = java.sql.Date.valueOf(hd.getNgayLapHD());
			stmt.setDate(3, ngayLap);
			stmt.setString(4, hd.getMaNhanVien().getMaNhanVien());
			return stmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

//	public static void main(String[] args) {
//		HoaDon_DAO hd = new HoaDon_DAO();
//		ArrayList<HoaDon> ds = hd.getAllTBHoaDon();
//		ds.forEach(h -> System.out.println(h));
//	}

}

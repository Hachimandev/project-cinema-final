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
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.VePhim;

public class ChiTietHoaDon_DAO {
	ArrayList<ChiTietHoaDon> dsChiTietHoaDon; 
	public ArrayList<ChiTietHoaDon> layDSChiTietHoaDon() {
		dsChiTietHoaDon = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from ChiTietHoaDon";
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				VePhim vp = new VePhim(rs.getString("MaVe"));
				HoaDon hd = new HoaDon(rs.getString("MaHoaDon"));
				int soLuong = rs.getInt("SoLuong");
				Date ngayLapDate = rs.getDate("NgayLapHoaDon");
				
				LocalDate ngayLap = ngayLapDate.toLocalDate();
				ChiTietHoaDon cthd = new ChiTietHoaDon(ngayLap, soLuong, vp, hd);
				dsChiTietHoaDon.add(cthd);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsChiTietHoaDon;
	}
	public boolean themChiTietHoaDon(ChiTietHoaDon cthd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into ChiTietHoaDon values(?, ?, ?, ?)");
			stmt.setString(1,cthd.getVePhim().getMaVe());
			stmt.setString(2,cthd.getHoaDon().getMaHoaDon());
			stmt.setInt(3,cthd.getSoLuong());
			stmt.setDate(4, Date.valueOf(cthd.getNgayLapHoaDon()));
			n = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0; 

	}
	
	
	
	public boolean xoaMotChiTietHoaDon(String maVe, String maHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("DELETE FROM ChiTietHoaDon WHERE MaVe = ? AND MaHoaDon = ?");
			stmt.setString(1, maVe);
			stmt.setString(2, maHD);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0; 

	}
	
	///////////////////////////////////////////////////28/4/2024 Phát
	public double tinhTongTienHoaDon(String maHD){
		double tongTien = 0;
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement ps = con.prepareStatement("Select Sum(SoLuong*Gia) as TongTien\r\n" + //
								"from ChiTietHoaDon ct join VePhim vp on vp.MaVe=ct.MaVe\r\n" + //
								"where ct.MaHoaDon=?");
			ps.setString(1, maHD);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tongTien = rs.getDouble("TongTien");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tongTien;
	}
}

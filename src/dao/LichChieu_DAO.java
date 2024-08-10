package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LichChieu;
import entity.Phim;
import entity.PhongChieu;

public class LichChieu_DAO {
	ArrayList<LichChieu> dsLichChieu;
	public ArrayList<LichChieu> layDSLichChieu() {
		dsLichChieu = new ArrayList<LichChieu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from LichChieu";
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				String maLC = rs.getString("MaLichChieu");
				Time thoiGianChieu = rs.getTime("ThoiGianChieu");
				Time thoiGianKetThuc = rs.getTime("ThoiGianKetThuc");
				Date ngayChieuDate = rs.getDate("NgayChieu");
				
				LocalDate ngayChieu = ngayChieuDate.toLocalDate();
				PhongChieu pc = new PhongChieu(rs.getString("MaPhongChieu"));
				Phim p = new Phim(rs.getString("MaPhim"));
				
				LichChieu lc = new LichChieu(maLC, thoiGianChieu, thoiGianKetThuc, ngayChieu, pc, p);
				dsLichChieu.add(lc);
			}
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return dsLichChieu;
	}
	
	public boolean themLichChieu(LichChieu lc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into LichChieu values(?, ?, ?, ?, ?, ?)");
			stmt.setString(1, lc.getMaLichChieu());
			stmt.setTime(2,lc.getThoiGianChieu());
			stmt.setTime(3,lc.getThoiGianKetThuc());
			stmt.setDate(4,Date.valueOf(lc.getNgayChieu()));
			stmt.setString(5, lc.getPhongChieu().getMaPhongChieu());
			stmt.setString(6, lc.getPhim().getMaPhim());
			n = stmt.executeUpdate();
		} catch (SQLException  e) {
			e.printStackTrace();
		}
		return n > 0;
	}
	
	public boolean xoaLichChieu(String maLC) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from LichChieu where MaLichChieu = ?");
			stmt.setString(1, maLC);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0; 
	}	
	
	public boolean capNhapLichChieu(LichChieu lc) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update LichChieu set ThoiGianChieu = ?, "
					+ "ThoiGianKetThuc = ?, NgayChieu = ?, MaPhongChieu = ?, MaPhim = ? where maLop = ?");
			stmt.setTime(1,lc.getThoiGianChieu());
			stmt.setTime(2,lc.getThoiGianKetThuc());
			stmt.setDate(3,Date.valueOf(lc.getNgayChieu()));
			stmt.setString(4, lc.getPhongChieu().getMaPhongChieu());
			stmt.setString(5, lc.getPhim().getMaPhim());
			stmt.setString(6, lc.getMaLichChieu());
			
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0; 
	}
	
	/////////////////////////////////////////////////// Khánh
	public LichChieu layLichChieuTheoMaVe(String maLichChieu) { 
		try {
			LichChieu lc = null;
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("Select * from LichChieu Where MaLichChieu = ?");
			ps.setString(1, maLichChieu);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				String maPhim = rs.getString("MaPhim");
				Time thoiGianChieu = rs.getTime("ThoiGianChieu");
				Time thoiGianKetThuc = rs.getTime("ThoiGianKetThuc");
				Date ngayChieuDate = rs.getDate("NgayChieu");
				
				LocalDate ngayChieu = ngayChieuDate.toLocalDate();
				PhongChieu pc = new PhongChieu(rs.getString("MaPhongChieu"));
				Phim p = new Phim(rs.getString("MaPhim"));
				
				lc = new LichChieu(maLichChieu, thoiGianChieu, thoiGianKetThuc, ngayChieu, pc, p);
			}
			return lc;
		} catch (Exception e) {
			return null;
		}
	}
	
	/////////////////////////////////////////////////// Sơn
	public ArrayList<LichChieu> timLichChieuTheoTenPhim(String tenPhim) {
		ArrayList<LichChieu> dsLCfind = new ArrayList<LichChieu>();
		try {			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();			
			PreparedStatement stmt = null;
			String sql = "select MaLichChieu, ThoiGianKetThuc, ThoiGianChieu, NgayChieu, "
						+ "MaPhongChieu, lc.MaPhim from LichChieu lc join Phim p on lc.MaPhim = p.MaPhim where TenPhim = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, tenPhim);
					
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				String maLC = rs.getString("MaLichChieu");
				Time thoiGianChieu = rs.getTime("ThoiGianChieu");
				Time thoiGianKetThuc = rs.getTime("ThoiGianKetThuc");
				Date ngayChieuDate = rs.getDate("NgayChieu");
				
				LocalDate ngayChieu = ngayChieuDate.toLocalDate();
				PhongChieu pc = new PhongChieu(rs.getString("MaPhongChieu"));
				Phim p = new Phim(rs.getString("MaPhim"));
				
				LichChieu lc = new LichChieu(maLC, thoiGianChieu, thoiGianKetThuc, ngayChieu, pc, p);
				dsLCfind.add(lc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return dsLCfind;
	}
	
	public String getTenPhimByMaPhim(String maPhim) throws SQLException {
        String tenPhim = null;
        ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
        String sql = "SELECT TenPhim FROM phim WHERE MaPhim = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, maPhim);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    tenPhim = resultSet.getString("TenPhim");
                }
            }
        }
        return tenPhim;
    }
	
	public String getMaPhimByTenPhim(String tenPhim) throws SQLException {
        String maPhim = null;
        ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
        String sql = "SELECT MaPhim FROM phim WHERE TenPhim = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, tenPhim);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    maPhim = resultSet.getString("MaPhim");
                }
            }
        }
        return maPhim;
    }
	
	public String layMaLichChieuCuoiCung() {
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("SELECT TOP 1 MaLichChieu FROM LichChieu ORDER BY MaLichChieu DESC");
			ResultSet rs = ps.executeQuery();
			String s = null;
			while (rs.next()) {
				s = rs.getString(1);
			}
			return s;
		} catch (Exception e) {
			return null;
		}
	}
}

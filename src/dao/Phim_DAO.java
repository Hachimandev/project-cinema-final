package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DangChieu;
import entity.LoaiPhim;
import entity.Phim;

public class Phim_DAO {

	private ArrayList<Phim> dsPhim;

	// lấy danh sách phim
	public ArrayList<Phim> getalltbPhim(){
		dsPhim = new ArrayList<Phim>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from Phim";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maPhim = rs.getString("MaPhim");
				String tenPhim = rs.getString("TenPhim");
				double giaPhim = Double.parseDouble(rs.getString("GiaPhim"));
				LoaiPhim lp = new LoaiPhim(rs.getString("MaLoaiPhim"));
				DangChieu dc = new DangChieu(rs.getString("MaDangChieu"));
				Phim p = new Phim(maPhim, tenPhim,giaPhim ,lp, dc);
				dsPhim.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsPhim;
	}
	
	// thêm phim vào dánh sách
	public boolean themPhim(Phim p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into" + " Phim values(?,?,?,?)");
			stmt.setString(1, p.getMaPhim());
			stmt.setString(2, p.getTenPhim());
			stmt.setString(3, p.getMaLoaiPhim().getMaLoaiPhim());
			stmt.setString(4, p.getMaDangChieu().getMaDangChieu());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	//Xóa phim
	public boolean XoaPhim(String mp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Delete from Phim Where MaPhim =?" );
			stmt.setString(1, mp);
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	
	// cập nhật phim
	public boolean capNhatPhim(Phim p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update Phim Set TenPhim=?, MaLoaiPhim=?, MaDangChieu=?" + "Where MaPhim=?");
			stmt.setString(1, p.getTenPhim());
			stmt.setString(2, p.getMaLoaiPhim().getMaLoaiPhim());
			stmt.setString(3, p.getMaDangChieu().getMaDangChieu());
			stmt.setString(4, p.getMaPhim());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n>0;
	}
	
	// in ra danh sách phim theo mã phim
	public ArrayList<Phim> getPhimTheoMaPhim(String mp){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from Phim Where MaPhim = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mp);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String maPhim = rs.getString("MaPhim");
				String tenPhim = rs.getString("TenPhim");
				double giaPhim = Double.parseDouble(rs.getString("GiaPhim"));
				LoaiPhim lp = new LoaiPhim(rs.getString("MaLoaiPhim"));
				DangChieu dc = new DangChieu(rs.getString("MaDangChieu"));
				Phim p = new Phim(maPhim, tenPhim, giaPhim,lp, dc);
				dsPhim.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsPhim;
	}
	
	// in ra danh sách phim theo mã loại phim
	public ArrayList<Phim> getPhimTheoMaLoaiPhim(String mlp){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from Phim Where MaLoaiPhim = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mlp);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String maPhim = rs.getString("MaPhim");
				String tenPhim = rs.getString("TenPhim");
				double giaPhim = Double.parseDouble(rs.getString("GiaPhim"));
				LoaiPhim lp = new LoaiPhim(rs.getString("MaLoaiPhim"));
				DangChieu dc = new DangChieu(rs.getString("MaDangChieu"));
				Phim p = new Phim(maPhim, tenPhim, giaPhim,lp, dc);
				dsPhim.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsPhim;
	}
	
	// in ra danh sách phim theo mã dạng chiếu
	public ArrayList<Phim> getPhimTheoMaDangChieu(String mdc){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from Phim Where MaDangChieu = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mdc);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String maPhim = rs.getString("MaPhim");
				String tenPhim = rs.getString("TenPhim");
				double giaPhim = Double.parseDouble(rs.getString("GiaPhim"));
				LoaiPhim lp = new LoaiPhim(rs.getString("MaLoaiPhim"));
				DangChieu dc = new DangChieu(rs.getString("MaDangChieu"));
				Phim p = new Phim(maPhim, tenPhim, giaPhim, lp, dc);
				dsPhim.add(p);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dsPhim;
	}
	
	////////////////////////////////////////////// Khánh
	public Phim layPhimTheoMaVe(String maPhim) { 
		try {
			Phim p = null;
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("Select * from Phim Where MaPhim = ?");
			ps.setString(1, maPhim);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
//				String maPhim = rs.getString("MaPhim");
				String tenPhim = rs.getString("TenPhim");
				double giaPhim = Double.parseDouble(rs.getString("GiaPhim"));
				LoaiPhim lp = new LoaiPhim(rs.getString("MaLoaiPhim"));
				DangChieu dc = new DangChieu(rs.getString("MaDangChieu"));
				p = new Phim(maPhim, tenPhim, giaPhim, lp, dc);
			}
			return p;
		} catch (Exception e) {
			return null;
		}
	}
	
	
	///////////////////////////////////////// Phát 
	public String layMaPhimCuoiCung() {
	    String maPhimCuoi = null;
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    try {
	        conn = ConnectDB.getConnection(); // Lấy kết nối đến cơ sở dữ liệu

	        if (conn != null) {
	            // Truy vấn SQL để lấy mã phim cuối cùng (sử dụng cú pháp phù hợp với cơ sở dữ liệu)
	            String sql = "SELECT TOP 1 MaPhim FROM Phim ORDER BY MaPhim DESC";
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();

	            // Lấy mã phim cuối cùng nếu có kết quả trả về
	            if (rs.next()) {
	                maPhimCuoi = rs.getString("MaPhim");
	            }
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // Xử lý ngoại lệ (in ra lỗi trong console)
		}
	    return maPhimCuoi;
	}

	public boolean suaPhim(Phim phim) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("UPDATE Phim SET TenPhim = ?, GiaPhim = ?, MaLoaiPhim = ?, MaDangChieu = ? WHERE MaPhim = ?");
			stmt.setString(1, phim.getTenPhim());
			stmt.setDouble(2, phim.getGiaPhim());
			stmt.setString(3, phim.getMaLoaiPhim().getMaLoaiPhim());
			stmt.setString(4, phim.getMaDangChieu().getMaDangChieu());
			stmt.setString(5, phim.getMaPhim());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n > 0;
	}

	public Phim timPhim(String maPhim) {
	    Phim phim = null;
		try {
			Connection con = ConnectDB.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Phim WHERE MaPhim = ?");
			ps.setString(1, maPhim);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maPhim1 = rs.getString("MaPhim");
				String tenPhim = rs.getString("TenPhim");
				double giaPhim = rs.getDouble("GiaPhim");
				LoaiPhim loaiPhim = new LoaiPhim(rs.getString("MaLoaiPhim"));
				DangChieu dangChieu = new DangChieu(rs.getString("MaDangChieu"));
				phim = new Phim(maPhim1, tenPhim, giaPhim, loaiPhim, dangChieu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return phim;
	}
	
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiNhanVien;
import entity.NhanVien;

public class NhanVien_DAO {
	public ArrayList<NhanVien> dsNhanVien; 
	
	public ArrayList<NhanVien> getallTBNhanVien(){
		dsNhanVien = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maNV = rs.getString("MaNV");
				String tenNV = rs.getString("TenNV");
				String sdt = rs.getString("SDT"); 
				String cmd = rs.getString("CMD"); 
				LoaiNhanVien loaiNV = new LoaiNhanVien(rs.getString("MaLoaiNV"));
				
				NhanVien nv = new NhanVien(maNV, tenNV, sdt, cmd, loaiNV); 
				dsNhanVien.add(nv);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	
	public boolean themNhanVien(NhanVien nv) { 
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into NhanVien (MaNV,TenNV,SDT,CMD,MaLoaiNV)" + " values(?,?,?,?,?)");
			stmt.setString(1, nv.getMaNhanVien());
			stmt.setString(2, nv.getTenNhanVien());
			stmt.setString(3, nv.getSoDienThoai());
			stmt.setString(4, nv.getCMD());
			stmt.setString(5, nv.getMaLoaiNV().getMaLoaiNhanVien());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
	/////////////////////////////////////////////////// Khánh
	public NhanVien layNhanVien(String maNV) {
		try {
			NhanVien nv = null;
			LoaiNhanVien lnv = null; 
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT MaNV, TenNV, SDT, CMD, MaLoaiNV FROM NhanVien WHERE MaNV = ?");
			ps.setString(1, maNV);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nv = new NhanVien();
				lnv = new LoaiNhanVien(rs.getString("MaLoaiNV")); 
				nv.setMaNhanVien(rs.getString("MaNV"));
				nv.setTenNhanVien(rs.getString("TenNV"));
				nv.setSoDienThoai(rs.getString("SDT"));
				nv.setCMD(rs.getString("CMD"));
				nv.setMaLoaiNV(lnv);
			}
			return nv;
		} catch (Exception e) {
			return null;
		}
	}
	
	/////////////////////////////////////////////////// Quyền 
	public boolean xoaNhanVien(String manv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement("DELETE FROM NhanVien WHERE MaNV=?");
			stmt.setString(1, manv);
			return stmt.executeUpdate()>0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public NhanVien timNhanVien(String manv){
		NhanVien nvcantim = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien Where MaNV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, manv);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				nvcantim = new NhanVien();
				String ma = rs.getString("MaNV"); 
				nvcantim.setMaNhanVien(ma);
				String ten = rs.getString("TenNV");
				nvcantim.setTenNhanVien(ten);
				String sdt = rs.getString("SDT");
				nvcantim.setSoDienThoai(sdt);
				String cmnd = rs.getString("CMD");
				nvcantim.setCMD(cmnd);
				LoaiNhanVien lnv = new LoaiNhanVien(rs.getString("MaLoaiNV"));
				nvcantim.setMaLoaiNV(lnv);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return nvcantim;
	}
	
	public ArrayList<NhanVien> timNhanVientheoloai(String maloainv){
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		try {
			String sql = "Select * from NhanVien Where MaLoaiNV = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, maloainv);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String ma = rs.getString("MaNV"); 
				String ten = rs.getString("TenNV");
				String sdt = rs.getString("SDT");
				String cmnd = rs.getString("CMD");
				LoaiNhanVien lnv = new LoaiNhanVien(rs.getString("MaLoaiNV"));
				NhanVien nv = new NhanVien(ma, ten, sdt, cmnd, lnv);
				dsNhanVien.add(nv);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsNhanVien;
	}
	public boolean capNhatNhanVien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Update NhanVien Set TenNV=?, SDT=?, CMD=? , MaLoaiNV=? Where MaNV=?");
			stmt.setString(1, nv.getTenNhanVien());
			stmt.setString(2, nv.getSoDienThoai());
			stmt.setString(3,nv.getCMD());
			stmt.setString(4, nv.getMaLoaiNV().getMaLoaiNhanVien());
			stmt.setString(5, nv.getMaNhanVien());
			n = stmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0;
	}
	
}

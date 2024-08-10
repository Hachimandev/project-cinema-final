package dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import connectDB.ConnectDB;
import entity.LoaiNhanVien;

public class LoaiNhanVien_DAO {
	private ArrayList<LoaiNhanVien> dsLoaiNhanVien;
	
	public ArrayList<LoaiNhanVien> getAllTBLoaiNhanVien(){
		dsLoaiNhanVien = new ArrayList<LoaiNhanVien>(); 
		try {
			ConnectDB.getInstance(); 
			Connection con = ConnectDB.getConnection(); 
			
			String sql = "Select * from LoaiNhanVien"; 
			Statement statement = con.createStatement(); 
			ResultSet rs = statement.executeQuery(sql); 
			while(rs.next()) { 
				String maLoaiNV = rs.getString("MaLoaiNV"); 
				String tenLoaiNV = rs.getString("TenLoaiNV");
				
				LoaiNhanVien lnv = new LoaiNhanVien(maLoaiNV, tenLoaiNV); 
				dsLoaiNhanVien.add(lnv); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiNhanVien; 
	}
	
	//////////////////////////////////////
	public LoaiNhanVien layLoaiNV(String maLoai) {
		try {
			LoaiNhanVien lnv = null; 
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT MaLoaiNV, TenLoaiNV FROM LoaiNhanVien WHERE MaLoaiNV = ?");
			ps.setString(1, maLoai);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lnv = new LoaiNhanVien(rs.getString("MaLoaiNV")); 
				lnv.setTenLoaiNhanVien(rs.getString("TenLoaiNV"));;
			}
			return lnv;
		} catch (Exception e) {
			return null;
		}
		
	}
}

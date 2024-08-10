package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoanNV;

public class TaiKhoanNV_DAO {
	private ArrayList<TaiKhoanNV> dsTaiKhoanNV;

	public ArrayList<TaiKhoanNV> getAllTBTaiKhoan(){
		dsTaiKhoanNV = new ArrayList<TaiKhoanNV>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoanNV";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
			while(rs.next()) {
				String maTK = rs.getString("MaTaiKhoan");
				String matKhau = rs.getString("MatKhau");
				
				TaiKhoanNV tk = new TaiKhoanNV(maTK, matKhau);
				dsTaiKhoanNV.add(tk);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsTaiKhoanNV;
	}
	
	public boolean themTaiKhoan(TaiKhoanNV tk) { 
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("Insert into" + " TaiKhoanNV values(?,?)");
			stmt.setString(1, tk.getMaTK());
			stmt.setString(2, tk.getMatKhau());
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
	
	
	///////////////////////////////////////////////////////
	public TaiKhoanNV layTaiKhoan(String maTK) {
		try {
			TaiKhoanNV tk = null;
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT MaTaiKhoan, MatKhau FROM TaiKhoanNV WHERE MaTaiKhoan = ?");
			ps.setString(1, maTK);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoanNV();
				tk.setMaTK(rs.getString("MaTaiKhoan"));
				tk.setMatKhau(rs.getString("MatKhau"));	
			}
			return tk;
		} catch (Exception e) {
			return null;
		}
	}


}

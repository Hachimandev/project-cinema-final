package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Ghe;

public class Ghe_DAO {
	public Ghe timGhe(String maGhe) {
		Ghe ghe = new Ghe();
		try {
			PreparedStatement ps= ConnectDB.getConnection()
					.prepareStatement("Select * from Ghe where MaGhe = ?");
			ps.setString(1,maGhe);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ghe.setMaGhe(rs.getString(1));
				ghe.setTrangThai(rs.getBoolean(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ghe;
	}
	
	public boolean capNhatTrangThaiGhe(String maGhe) {
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Update Ghe set TrangThai=? where MaGhe=?");
			ps.setBoolean(1,false);
			ps.setString(2, maGhe);
			return ps.executeUpdate() >0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Ghe> getDanhSachGhe(){
		ArrayList<Ghe> dsGhe = new ArrayList<Ghe>();
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Select * from Ghe");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Ghe ghe = new Ghe();
				ghe.setMaGhe(rs.getString(1));
				ghe.setTrangThai(rs.getBoolean(2));
				dsGhe.add(ghe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsGhe;
	}
	
	/////////////////////////////////////////// Khánh 
	public ArrayList<Ghe> getDanhSachGheTheoPhongChieu(String maLichChieu){
		
		ArrayList<Ghe> dsGhe = new ArrayList<Ghe>();
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Select * from Ghe");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Ghe ghe = new Ghe();
				ghe.setMaGhe(rs.getString(1));
				ghe.setTrangThai(rs.getBoolean(2));
				
				String firstChar = ghe.getMaGhe().substring(0, 1);
				if(firstChar.equals(maLichChieu))
					dsGhe.add(ghe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsGhe;
	}
	
	// lay ghe theo ma
	public Ghe layLichChieuTheoMaVe(String maGhe) { 
		try {
			Ghe g = null;
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Select * from Ghe Where MaGhe = ?");
			ps.setString(1, maGhe);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String maGheIn = rs.getString("MaGhe");
				boolean trangthai =  rs.getBoolean("TrangThai");
				
				g = new Ghe(maGheIn, trangthai); 
			}
			return g;
		} catch (Exception e) {
			return null;
		}
	}
	
	// set trang thái cho ghe khi truyền vào mã ghế 

	
}

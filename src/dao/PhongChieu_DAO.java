package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.PhongChieu;

public class PhongChieu_DAO {
	ArrayList<PhongChieu> dsPhongChieu; 
	public ArrayList<PhongChieu> getalltbPhongChieu() {	
		dsPhongChieu = new ArrayList<PhongChieu>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from PhongChieu";
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				String maPhongChieu = rs.getString("MaPhongChieu");
				String tenPhongChieu = rs.getString("TenPhongChieu");
				int soLuongGhe = rs.getInt("SoLuongGhe");
				String moTa = rs.getString("MoTa");
				PhongChieu pc = new PhongChieu(maPhongChieu, tenPhongChieu, soLuongGhe, moTa);
				dsPhongChieu.add(pc);				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPhongChieu;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiVe;


public class LoaiVe_DAO {
	
	private ArrayList<LoaiVe> dsLoaiVe;

	public ArrayList<LoaiVe> getalltbLoaiVe(){
		dsLoaiVe = new ArrayList<LoaiVe>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiVe";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maLoaiVe = rs.getString("MaLoaiVe");
				String tenLoaiVe = rs.getString("TenLoaiVe");
				double giaLoaiVe = rs.getDouble("GiaLoaiVe");
				LoaiVe lv = new LoaiVe(maLoaiVe, tenLoaiVe, giaLoaiVe);
				dsLoaiVe.add(lv);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsLoaiVe;
	}
	
	///////////////////////////////// Khánh
	public LoaiVe layVeTheoMaVe(String maVe) { 
		try {
			LoaiVe lv = null;
			PreparedStatement ps = ConnectDB.getConnection().prepareStatement("SELECT MaLoaiVe, TenLoaiVe, GiaLoaiVe FROM LoaiVe WHERE MaLoaiVe = ?");
			ps.setString(1, maVe);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				lv = new LoaiVe(rs.getString("MaLoaiVe"));
				lv.setTenLoaiVe(rs.getString("TenLoaiVe"));;
				lv.setGiaLoaiVe(Double.parseDouble(rs.getString("GiaLoaiVe")));
				
			}
			return lv;
		} catch (Exception e) {
			return null;
		}
	}
	

}

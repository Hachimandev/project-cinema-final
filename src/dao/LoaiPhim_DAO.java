package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiPhim;

public class LoaiPhim_DAO {
	ArrayList<LoaiPhim> dsLoaiPhim; 
	public ArrayList<LoaiPhim> getalltbLoaiPhim() {	
		dsLoaiPhim = new ArrayList<LoaiPhim>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			
			String sql = "select * from LoaiPhim";
			Statement stm = con.createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while (rs.next()) {
				String maLoaiPhim = rs.getString("MaLoaiPhim");
				String tenTheLoai = rs.getString("TenTheLoai");
				LoaiPhim lp = new LoaiPhim(maLoaiPhim, tenTheLoai);
				dsLoaiPhim.add(lp);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLoaiPhim;
	}	

}

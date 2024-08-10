package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.DangChieu;


public class DangChieu_DAO {
	
	private ArrayList<DangChieu> dsDangChieu;

	public ArrayList<DangChieu> getalltbDangChieu(){
		dsDangChieu = new ArrayList<DangChieu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from DangChieu";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maDangChieu = rs.getString("MaDangChieu");
				String tenDangChieu = rs.getString("TenDangChieu");
				DangChieu dc = new DangChieu(maDangChieu, tenDangChieu);
				dsDangChieu.add(dc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return dsDangChieu;
	}


}

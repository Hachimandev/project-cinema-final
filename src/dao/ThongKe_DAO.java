package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;


import connectDB.ConnectDB;


public class ThongKe_DAO {
	public ArrayList<Object[]> doanhThu() {
		int stt = 1;
		ArrayList<Object[]> dsdt = new ArrayList<Object[]>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    CallableStatement cstmt = null;
	    ResultSet rs = null;

	    try {
	        cstmt = con.prepareCall("select \r\n"
	        		+ "		p.MaPhim, TenPhim,  hd.NgayLapHD AS NgayLapHoaDon,\r\n"
	        		+ "		count(distinct lc.MaLichChieu) as SoBuoiChieu, sum(SoLuong) as SoVeBanRa,\r\n"
	        		+ "		sum(SoLuong*vp.Gia) as TongDoanhThu\r\n"
	        		+ "		from Phim p join VePhim vp \r\n"
	        		+ "		on p.MaPhim = vp.MaPhim join LichChieu lc\r\n"
	        		+ "		on p.MaPhim = lc.MaPhim join ChiTietHoaDon cthd\r\n"
	        		+ "		on vp.MaVe = cthd.MaVe join HoaDon hd \r\n"
	        		+ "		on cthd.MaHoaDon = hd.MaHoaDon\r\n"
	        		+ "		group by p.MaPhim, TenPhim, hd.NgayLapHD");
	        rs = cstmt.executeQuery();

	        while (rs.next()) {	        	
	            String maPhim = rs.getString("MaPhim");
	            String tenPhim = rs.getString("TenPhim");
	            Date ngayLapHDDate = rs.getDate("NgayLapHoaDon");				
				LocalDate ngayLapHD = ngayLapHDDate.toLocalDate();
	            int soBuoiChieu = rs.getInt("SoBuoiChieu");
	            int soVeBanRa = rs.getInt("SoVeBanRa");
	            double tongDoanhThu = rs.getDouble("TongDoanhThu");
	            
	            DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
                String formattedTongDoanhThu = decimalFormat.format(tongDoanhThu);
	            Object[] rowData = {stt++,maPhim, tenPhim, ngayLapHD, soBuoiChieu, soVeBanRa, formattedTongDoanhThu};
	            dsdt.add(rowData);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dsdt;
	}
	
	
	
	public ArrayList<Object[]> doanhThuTheoThang(int thang) {
		int stt = 1;
		ArrayList<Object[]> dtThang = new ArrayList<Object[]>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    CallableStatement cstmt = null;
	    ResultSet rs = null;

	    try {
	        cstmt = con.prepareCall("{call phim_DoanhThuThang(?)}");
	        cstmt.setInt(1, thang);
	        rs = cstmt.executeQuery();

	        while (rs.next()) {	        	
	            String maPhim = rs.getString("MaPhim");
	            String tenPhim = rs.getString("TenPhim");
	            Date ngayLapHDDate = rs.getDate("NgayLapHoaDon");				
				LocalDate ngayLapHD = ngayLapHDDate.toLocalDate();
	            int soBuoiChieu = rs.getInt("SoBuoiChieu");
	            int soVeBanRa = rs.getInt("SoVeBanRa");
	            double tongDoanhThu = rs.getDouble("TongDoanhThu");
	            
	            DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
                String formattedTongDoanhThu = decimalFormat.format(tongDoanhThu);
	            Object[] rowData = {stt++,maPhim, tenPhim, ngayLapHD, soBuoiChieu, soVeBanRa, formattedTongDoanhThu};
	            dtThang.add(rowData);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dtThang;
	}
	
	public ArrayList<Object[]> doanhThuTheoNam(int nam) {
		int stt = 1;
		ArrayList<Object[]> dtNam = new ArrayList<Object[]>();
	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();
	    CallableStatement cstmt = null;
	    ResultSet rs = null;

	    try {
	        cstmt = con.prepareCall("{call phim_DoanhThuNam(?)}");
	        cstmt.setInt(1, nam);
	        rs = cstmt.executeQuery();

	        while (rs.next()) {	        	
	            String maPhim = rs.getString("MaPhim");
	            String tenPhim = rs.getString("TenPhim");
	            Date ngayLapHDDate = rs.getDate("NgayLapHoaDon");				
				LocalDate ngayLapHD = ngayLapHDDate.toLocalDate();
	            int soBuoiChieu = rs.getInt("SoBuoiChieu");
	            int soVeBanRa = rs.getInt("SoVeBanRa");
	            double tongDoanhThu = rs.getDouble("TongDoanhThu");
	            
	            DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
                String formattedTongDoanhThu = decimalFormat.format(tongDoanhThu);
	            Object[] rowData = {stt++,maPhim, tenPhim, ngayLapHD, soBuoiChieu, soVeBanRa, formattedTongDoanhThu};
	            dtNam.add(rowData);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return dtNam;
	}
	public double doanhThuThangHienTai() {
	    double doanhThu = 0;
	    String sql = "SELECT SUM(SoLuong*vp.Gia) AS DoanhThu "
	               + "FROM Phim p JOIN VePhim vp "
	               + "ON p.MaPhim = vp.MaPhim "
	               + "JOIN LichChieu lc ON p.MaPhim = lc.MaPhim "
	               + "JOIN ChiTietHoaDon cthd ON vp.MaVe = cthd.MaVe "
	               + "JOIN HoaDon hd ON cthd.MaHoaDon = hd.MaHoaDon "
	               + "WHERE MONTH(NgayLapHD) = MONTH(GETDATE()) and YEAR(NgayLapHD) = YEAR(GETDATE());";
	    
	    Connection connection = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    
	    try {
	        connection = ConnectDB.getConnection();
	        statement = connection.prepareStatement(sql);
	        resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            doanhThu = resultSet.getDouble("DoanhThu");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    
	    return doanhThu;
	}
}

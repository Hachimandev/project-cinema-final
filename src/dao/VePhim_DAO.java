package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.Ghe;
import entity.LichChieu;
import entity.LoaiVe;
import entity.Phim;
import entity.VePhim;

public class VePhim_DAO {
	private LoaiVe_DAO lv_dao = new LoaiVe_DAO(); 
	private Phim_DAO p_dao = new Phim_DAO(); 
	private LichChieu_DAO lc_dao = new LichChieu_DAO(); 
	private Ghe_DAO g_dao = new Ghe_DAO(); 
	
	public VePhim timVePhim(String maVe) {
		VePhim vp = null;
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Select * from VePhim where MaVe= ?");
			ps.setString(1, maVe);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				String maVeStr = rs.getString(1); 
				LoaiVe lv = lv_dao.layVeTheoMaVe(rs.getString(2)); 
				Phim p = p_dao.layPhimTheoMaVe(rs.getString(3)); 
				LichChieu lc = lc_dao.layLichChieuTheoMaVe(rs.getString(4));
				Ghe g = g_dao.layLichChieuTheoMaVe(rs.getString(5));  
				double gia = Double.parseDouble(rs.getString(6));
				String mota = rs.getString(7); 
				
				vp = new VePhim(maVeStr, lv, p, lc, g, gia, mota); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vp;
	}
	
	public boolean themVePhim(VePhim vePhim) {
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Insert into VePhim values(?,?,?,?,?,?,?)");
			ps.setString(1,vePhim.getMaVe());
			ps.setString(2,vePhim.getMaloaiVe().getMaLoaiVe());
			ps.setString(3,vePhim.getMaPhim().getMaPhim());
			ps.setString(4,vePhim.getMaLichChieu().getMaLichChieu());
			ps.setString(5,vePhim.getMaGhe().getMaGhe());
			ps.setDouble(6,vePhim.getGia());
			ps.setString(7,vePhim.getMota());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean xoaVePhim(String maVe) {
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Delete from VePhim where MaVe=?");
			ps.setString(1, maVe);
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public boolean capNhatVePhim(VePhim vp){
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Update VePhim set MaLoaiVe=?,MaPhim=?,MaLichChieu=?,MaGhe=?,Gia=?,MoTa=? where MaVe=?");
			ps.setString(1, vp.getMaloaiVe().getMaLoaiVe());
			ps.setString(2, vp.getMaPhim().getMaPhim());
			ps.setString(3, vp.getMaLichChieu().getMaLichChieu());
			ps.setString(4, vp.getMaGhe().getMaGhe());
			ps.setDouble(5, vp.getGia());
			ps.setString(6, vp.getMota());
			ps.setString(7, vp.getMaVe());
			return ps.executeUpdate()>0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public ArrayList<VePhim> getDsVePhim(){
		ArrayList<VePhim> dsVePhim = new ArrayList<VePhim>();
		try {
			PreparedStatement ps = ConnectDB.getConnection()
					.prepareStatement("Select * from VePhim");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				String maVe = rs.getString(1); 
				LoaiVe lv = lv_dao.layVeTheoMaVe(rs.getString(2)); 
				Phim p = p_dao.layPhimTheoMaVe(rs.getString(3)); 
				LichChieu lc = lc_dao.layLichChieuTheoMaVe(rs.getString(4));
				Ghe g = g_dao.layLichChieuTheoMaVe(rs.getString(5));  
				double gia = Double.parseDouble(rs.getString(6));
				String mota = rs.getString(7); 
				
				VePhim vp = new VePhim(maVe, lv, p, lc, g, gia, mota); 
				
				dsVePhim.add(vp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dsVePhim;
	}
}

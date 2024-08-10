package entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class HoaDon {
	private String maHoaDon; 
	private LocalDate ngayLapHD;
	
	private KhachHang maKhachHang; 
	private NhanVien maNhanVien;
	//////////////////////Phát 
	private ArrayList<ChiTietHoaDon> dsChiTietHoaDon;
	
	// contructor
	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}
	
	public HoaDon(String maHoaDon, LocalDate ngayLapHD, KhachHang maKhachHang, NhanVien maNhanVien,
			ArrayList<ChiTietHoaDon> dsChiTietHoaDon) {
		this.maHoaDon = maHoaDon;
		this.ngayLapHD = ngayLapHD;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
		this.dsChiTietHoaDon= new ArrayList<ChiTietHoaDon>();
	}

	public HoaDon(String maHoaDon, LocalDate ngayLapHD, KhachHang maKhachHang, NhanVien maNhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHD = ngayLapHD;
		this.maKhachHang = maKhachHang;
		this.maNhanVien = maNhanVien;
	}
	
	public HoaDon() {
		
	}
	
	//get, set
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public LocalDate getNgayLapHD() {
		return ngayLapHD;
	}
	public KhachHang getMaKhachHang() {
		return maKhachHang;
	}
	public NhanVien getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public void setNgayLapHD(LocalDate ngayLapHD) {
		this.ngayLapHD = ngayLapHD;
	}
	public void setMaKhachHang(KhachHang maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public void setMaNhanVien(NhanVien maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maHoaDon);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(maHoaDon, other.maHoaDon);
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHD=" + ngayLapHD + ", maKhachHang=" + maKhachHang
				+ ", maNhanVien=" + maNhanVien + "]";
	} 
	
	public ArrayList<ChiTietHoaDon> getDsChiTietHoaDon() {
		return dsChiTietHoaDon;
	}
	
	public void setDsChiTietHoaDon(ArrayList<ChiTietHoaDon> dsChiTietHoaDon) {
		this.dsChiTietHoaDon = dsChiTietHoaDon;
	} 
	
	
}

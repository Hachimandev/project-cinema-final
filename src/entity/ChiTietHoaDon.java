package entity;

import java.time.LocalDate;

public class ChiTietHoaDon {
	private LocalDate ngayLapHoaDon;
	private int soLuong;
	
	private VePhim vePhim;
	private HoaDon hoaDon;
	
	// contructor
	public ChiTietHoaDon() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietHoaDon(LocalDate ngayLapHoaDon, int soLuong, VePhim vePhim, HoaDon hoaDon) {
		super();
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.soLuong = soLuong;
		this.vePhim = vePhim;
		this.hoaDon = hoaDon;
	}

	//get, set
	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public VePhim getVePhim() {
		return vePhim;
	}

	public void setVePhim(VePhim vePhim) {
		this.vePhim = vePhim;
	}

	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [ngayLapHoaDon=" + ngayLapHoaDon + ", soLuong=" + soLuong + ", vePhim=" + vePhim
				+ ", hoaDon=" + hoaDon + "]";
	}	
	
}

package entity;

import java.util.Objects;

public class VePhim {
	private String maVe;
	private double gia;
	private String mota;
	
	private LoaiVe maloaiVe;
	private Phim maPhim;
	private LichChieu maLichChieu;
	private Ghe maGhe;
	
	
	//contructor
	public VePhim() {
		super();
	}
	
	public VePhim(String maVe) {
		super();
		this.maVe = maVe;
	}
	
	public VePhim(String maVe, LoaiVe maloaiVe, Phim maPhim, LichChieu maLichChieu, Ghe maGhe,
			String mota) {
		super();
		this.maVe = maVe;
		this.maloaiVe = maloaiVe;
		this.maPhim = maPhim;
		this.maLichChieu = maLichChieu;
		this.maGhe = maGhe;
		this.gia = tinhGia(); 
		this.mota = mota;
	}
	
	
	
	public VePhim(String maVe, LoaiVe maloaiVe, Phim maPhim, LichChieu maLichChieu,
			Ghe maGhe, double gia, String mota) {
		super();
		this.maVe = maVe;
		this.gia = gia;
		this.mota = mota;
		this.maloaiVe = maloaiVe;
		this.maPhim = maPhim;
		this.maLichChieu = maLichChieu;
		this.maGhe = maGhe;
	}

	private double tinhGia() {
		double giaTong; 
		giaTong = maPhim.getGiaPhim() + maloaiVe.getGiaLoaiVe(); 
		return giaTong; 
	}
	
	// get, set
	public String getMaVe() {
		return maVe;
	}
	public void setMaVe(String maVe) {
		this.maVe = maVe;
	}
	public LoaiVe getMaloaiVe() {
		return maloaiVe;
	}
	public void setMaloaiVe(LoaiVe maloaiVe) {
		this.maloaiVe = maloaiVe;
	}
	public Phim getMaPhim() {
		return maPhim;
	}
	public void setMaPhim(Phim maPhim) {
		this.maPhim = maPhim;
	}
	public LichChieu getMaLichChieu() {
		return maLichChieu;
	}
	public void setMaLichChieu(LichChieu maLichChieu) {
		this.maLichChieu = maLichChieu;
	}
	public Ghe getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(Ghe maGhe) {
		this.maGhe = maGhe;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getMota() {
		return mota;
	}
	public void setMota(String mota) {
		this.mota = mota;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maVe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VePhim other = (VePhim) obj;
		return Objects.equals(maVe, other.maVe);
	}
	
	@Override
	public String toString() {
		return "VePhim [maVe=" + maVe + ", maloaiVe=" + maloaiVe + ", maPhim=" + maPhim + ", maLichChieu=" + maLichChieu
				+ ", maGhe=" + maGhe + ", gia=" + gia + ", mota=" + mota + "]";
	}
	

}

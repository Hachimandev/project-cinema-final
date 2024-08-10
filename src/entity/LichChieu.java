package entity;

import java.sql.Time;
import java.time.LocalDate;
import java.util.Objects;

public class LichChieu {
	private String maLichChieu;
	private Time thoiGianChieu;
	private Time thoiGianKetThuc;
	private LocalDate ngayChieu;
	
	private PhongChieu phongChieu;
	private Phim phim;
	
	// contructor
	public LichChieu() {
		// TODO Auto-generated constructor stub
	}

	public LichChieu(String maLichChieu) {
		super();
		this.maLichChieu = maLichChieu;
	}

	public LichChieu(String maLichChieu, Time thoiGianChieu, Time thoiGianKetThuc, LocalDate ngayChieu,
			PhongChieu phongChieu, Phim phim) {
		super();
		this.maLichChieu = maLichChieu;
		this.thoiGianChieu = thoiGianChieu;
		this.thoiGianKetThuc = thoiGianKetThuc;
		this.ngayChieu = ngayChieu;
		this.phongChieu = phongChieu;
		this.phim = phim;
	}
	
	//get, set
	public String getMaLichChieu() {
		return maLichChieu;
	}

	public void setMaLichChieu(String maLichChieu) {
		this.maLichChieu = maLichChieu;
	}

	public Time getThoiGianChieu() {
		return thoiGianChieu;
	}

	public void setThoiGianChieu(Time thoiGianChieu) {
		this.thoiGianChieu = thoiGianChieu;
	}

	public Time getThoiGianKetThuc() {
		return thoiGianKetThuc;
	}

	public void setThoiGianKetThuc(Time thoiGianKetThuc) {
		this.thoiGianKetThuc = thoiGianKetThuc;
	}

	public LocalDate getNgayChieu() {
		return ngayChieu;
	}

	public void setNgayChieu(LocalDate ngayChieu) {
		this.ngayChieu = ngayChieu;
	}

	public PhongChieu getPhongChieu() {
		return phongChieu;
	}

	public void setPhongChieu(PhongChieu phongChieu) {
		this.phongChieu = phongChieu;
	}

	public Phim getPhim() {
		return phim;
	}

	public void setPhim(Phim phim) {
		this.phim = phim;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLichChieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LichChieu other = (LichChieu) obj;
		return Objects.equals(maLichChieu, other.maLichChieu);
	}

	@Override
	public String toString() {
		return "LichChieu [maLichChieu=" + maLichChieu + ", thoiGianChieu=" + thoiGianChieu + ", thoiGianKetThuc="
				+ thoiGianKetThuc + ", ngayChieu=" + ngayChieu + ", phongChieu=" + phongChieu + "]";
	}
	
}

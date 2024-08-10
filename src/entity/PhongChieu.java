package entity;

import java.util.Objects;

public class PhongChieu {
	private String maPhongChieu;
	private String tenPhongChieu;
	private int soLuongGhe;
	private String moTa;
	
	// contructor
	public PhongChieu() {
		// TODO Auto-generated constructor stub
	}

	public PhongChieu(String maPhongChieu) {
		super();
		this.maPhongChieu = maPhongChieu;
	}

	public PhongChieu(String maPhongChieu, String tenPhongChieu, int soLuongGhe, String moTa) {
		super();
		this.maPhongChieu = maPhongChieu;
		this.tenPhongChieu = tenPhongChieu;
		this.soLuongGhe = soLuongGhe;
		this.moTa = moTa;
	}
	
	//get, set
	public String getMaPhongChieu() {
		return maPhongChieu;
	}

	public void setMaPhongChieu(String maPhongChieu) {
		this.maPhongChieu = maPhongChieu;
	}

	public String getTenPhongChieu() {
		return tenPhongChieu;
	}

	public void setTenPhongChieu(String tenPhongChieu) {
		this.tenPhongChieu = tenPhongChieu;
	}

	public int getSoLuongGhe() {
		return soLuongGhe;
	}

	public void setSoLuongGhe(int soLuongGhe) {
		this.soLuongGhe = soLuongGhe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhongChieu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhongChieu other = (PhongChieu) obj;
		return Objects.equals(maPhongChieu, other.maPhongChieu);
	}

	@Override
	public String toString() {
		return "PhongChieu [maPhongChieu=" + maPhongChieu + ", tenPhongChieu=" + tenPhongChieu + ", soLuongGhe="
				+ soLuongGhe + ", moTa=" + moTa + "]";
	}
	
	
}

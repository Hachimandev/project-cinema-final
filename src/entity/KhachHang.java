package entity;

import java.time.LocalDate;
import java.util.Objects;

public class KhachHang {
	private  String maKhachHang;
	private String tenKhachHang;
	private String soDienThoai;
	private String diaChi;
	private LocalDate ngaySinh;
	
	// contructor
	public KhachHang() {
		this("makh","tenkh","sdt","",LocalDate.now());
	}
	public KhachHang(String maKhachHang) {
		super();
		this.maKhachHang = maKhachHang;
	}
	
	public KhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String diaChi, LocalDate ngaySinh) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
	}
	
	
	//get, set
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChia) {
		this.diaChi = diaChia;
	}
	public LocalDate getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maKhachHang);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(maKhachHang, other.maKhachHang);
	}
	@Override
	public String toString() {
		return "KhachHang [maKhachHang=" + maKhachHang + ", tenKhachHang=" + tenKhachHang + ", soDienThoai="
				+ soDienThoai + ", diaChi=" + diaChi + ", ngaySinh=" + ngaySinh + "]";
	}
	
	
}

package entity;

import java.util.Objects;

public class NhanVien {
	private String maNhanVien;
	private String tenNhanVien; 
	private String soDienThoai;
	private String CMD; 
	
	private LoaiNhanVien maLoaiNV;
	
	// contructor
	public NhanVien() { 
		this ("manv", "tennv", "sdt", "cmd",null);
	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}
	

	public NhanVien(String maNhanVien, String tenNhanVien, String soDienThoai, String cMD, LoaiNhanVien maLoaiNV) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.CMD  = cMD;
		this.maLoaiNV = maLoaiNV;
	}
	
	//get, set

	public String getMaNhanVien() {
		return maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public String getCMD() {
		return CMD;
	}
	public LoaiNhanVien getMaLoaiNV() {
		return maLoaiNV;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public void setCMD(String cMD) {
		CMD = cMD;
	}
	public void setMaLoaiNV(LoaiNhanVien maLoaiNV) {
		this.maLoaiNV = maLoaiNV;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNhanVien, other.maNhanVien);
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", soDienThoai=" + soDienThoai
				+ ", CMD=" + CMD + ", maLoaiNV=" + maLoaiNV + "]";
	}
	
	
	
	
}

package entity;

import java.util.Objects;

public class LoaiNhanVien {
	private String maLoaiNhanVien;
	private String tenLoaiNhanVien;
	
	
	// contructor
	public LoaiNhanVien() {
		super();
	}

	public LoaiNhanVien(String maLoaiNhanVien) {
		super();
		this.maLoaiNhanVien = maLoaiNhanVien;
	}

	public LoaiNhanVien(String maLoaiNhanVien, String tenLoaiNhanVien) {
		super();
		this.maLoaiNhanVien = maLoaiNhanVien;
		this.tenLoaiNhanVien = tenLoaiNhanVien;
	}

	//get, set
	public String getMaLoaiNhanVien() {
		return maLoaiNhanVien;
	}

	public String getTenLoaiNhanVien() {
		return tenLoaiNhanVien;
	}

	public void setMaLoaiNhanVien(String maLoaiNhanVien) {
		this.maLoaiNhanVien = maLoaiNhanVien;
	}

	public void setTenLoaiNhanVien(String tenLoaiNhanVien) {
		this.tenLoaiNhanVien = tenLoaiNhanVien;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLoaiNhanVien);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiNhanVien other = (LoaiNhanVien) obj;
		return Objects.equals(maLoaiNhanVien, other.maLoaiNhanVien);
	}
	
	@Override
	public String toString() {
		return "LoaiNhanVien [maLoaiNhanVien=" + maLoaiNhanVien + ", tenLoaiNhanVien=" + tenLoaiNhanVien + "]";
	}
	
	
	
	
	
}

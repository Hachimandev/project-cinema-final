package entity;

import java.util.Objects;

public class LoaiPhim {
	private String maLoaiPhim;
	private String tenTheLoai;
	
	// contructor
	public LoaiPhim() {
		// TODO Auto-generated constructor stub
	}
	public LoaiPhim(String maLoaiPhim) {
		super();
		this.maLoaiPhim = maLoaiPhim;
	}
	public LoaiPhim(String maLoaiPhim, String tenTheLoai) {
		super();
		this.maLoaiPhim = maLoaiPhim;
		this.tenTheLoai = tenTheLoai;
	}
	
	//get, set
	public String getMaLoaiPhim() {
		return maLoaiPhim;
	}
	public void setMaLoaiPhim(String maLoaiPhim) {
		this.maLoaiPhim = maLoaiPhim;
	}
	public String getTenTheLoai() {
		return tenTheLoai;
	}
	public void setTenTheLoai(String tenTheLoai) {
		this.tenTheLoai = tenTheLoai;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhim);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhim other = (LoaiPhim) obj;
		return Objects.equals(maLoaiPhim, other.maLoaiPhim);
	}
	
	@Override
	public String toString() {
		return "LoaiPhim [maLoaiPhim=" + maLoaiPhim + ", tenTheLoai=" + tenTheLoai + "]";
	}
	
	
	
}

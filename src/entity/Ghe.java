package entity;

import java.util.Objects;

public class Ghe {
	private String maGhe;
	private boolean trangThai;
	
	// contructor
	public Ghe() {
		super();
	}
	
	public Ghe(String maGhe) {
		super();
		this.maGhe = maGhe;
	}
	
	public Ghe(String maGhe, boolean trangThai) {
		super();
		this.maGhe = maGhe;
		this.trangThai = trangThai;
	}
	
	
	
	//get, set
	public String getMaGhe() {
		return maGhe;
	}
	public void setMaGhe(String maGhe) {
		this.maGhe = maGhe;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(maGhe);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ghe other = (Ghe) obj;
		return Objects.equals(maGhe, other.maGhe);
	}
	
	@Override
	public String toString() {
		return "Ghe [maGhe=" + maGhe + ", trangThai=" + trangThai + "]";
	}
	
}

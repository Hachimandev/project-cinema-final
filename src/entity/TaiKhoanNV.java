package entity;

import java.util.Objects;

public class TaiKhoanNV {
	private String maTK;
	private String matKhau;
	
	
	
	public TaiKhoanNV() {
		super();
	}

	public TaiKhoanNV(String maTK) {
		super();
		this.maTK = maTK;
		this.matKhau = "111"; 
	}

	public TaiKhoanNV(String maTK, String matKhau) {
		super();
		this.maTK = maTK;
		this.matKhau = matKhau;
	}
	
	public String getMaTK() {
		return maTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMaTK(String maTK) {
		this.maTK = maTK;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	

	@Override
	public String toString() {
		return "TaiKhoanNV [maTK=" + maTK + ", matKhau=" + matKhau + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maTK);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaiKhoanNV other = (TaiKhoanNV) obj;
		return Objects.equals(maTK, other.maTK);
	} 
	
	
	
}

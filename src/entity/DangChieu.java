package entity;


public class DangChieu {
	private String maDangChieu;
	private String tenDangChieu;
	
	// contructor
	public DangChieu(String maDangChieu) {
		this.maDangChieu = maDangChieu;
	}
	
	public DangChieu(String maDangChieu, String tenDangChieu) {
		super();
		this.maDangChieu = maDangChieu;
		this.tenDangChieu = tenDangChieu;
	}
	
	//get, set
	public String getMaDangChieu() {
		return maDangChieu;
	}
	public void setMaDangChieu(String maDangChieu) {
		this.maDangChieu = maDangChieu;
	}
	public String getTenDangChieu() {
		return tenDangChieu;
	}
	public void setTenDangChieu(String tenDangChieu) {
		this.tenDangChieu = tenDangChieu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDangChieu == null) ? 0 : maDangChieu.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DangChieu other = (DangChieu) obj;
		if (maDangChieu == null) {
			if (other.maDangChieu != null)
				return false;
		} else if (!maDangChieu.equalsIgnoreCase(other.maDangChieu))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "DangChieu [maDangChieu=" + maDangChieu + ", tenDangChieu=" + tenDangChieu + "]";
	}
	
	
}

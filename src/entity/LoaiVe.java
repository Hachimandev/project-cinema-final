package entity;

public class LoaiVe {
	private String maLoaiVe;
	private String tenLoaiVe;
	private double giaLoaiVe;
	
	
	// contructor
	public LoaiVe(String maLoaiVe) {
		this.maLoaiVe = maLoaiVe;
	}


	public LoaiVe(String maLoaiVe, String tenLoaiVe, double giaLoaiVe) {
		super();
		this.maLoaiVe = maLoaiVe;
		this.tenLoaiVe = tenLoaiVe;
		this.giaLoaiVe = giaLoaiVe;
	}

	//get, set
	public String getMaLoaiVe() {
		return maLoaiVe;
	}
	
	public void setMaLoaiVe(String maLoaiVe) {
		this.maLoaiVe = maLoaiVe;
	}

	public String getTenLoaiVe() {
		return tenLoaiVe;
	}

	public void setTenLoaiVe(String tenLoaiVe) {
		this.tenLoaiVe = tenLoaiVe;
	}

	public double getGiaLoaiVe() {
		return giaLoaiVe;
	}

	public void setGiaLoaiVe(double giaLoaiVe) {
		this.giaLoaiVe = giaLoaiVe;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiVe == null) ? 0 : maLoaiVe.hashCode());
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
		LoaiVe other = (LoaiVe) obj;
		if (maLoaiVe == null) {
			if (other.maLoaiVe != null)
				return false;
		} else if (!maLoaiVe.equalsIgnoreCase(other.maLoaiVe))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "LoaiVe [maLoaiVe=" + maLoaiVe + ", tenLoaiVe=" + tenLoaiVe + ", giaLoaiVe=" + giaLoaiVe + "]";
	}
	

	
	
	
}

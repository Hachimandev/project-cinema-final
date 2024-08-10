package entity;


public class Phim {
	private String maPhim;
	private String tenPhim;
	private double giaPhim; 
	
	private LoaiPhim maLoaiPhim;
	private DangChieu maDangChieu;
	
	// contructor
	public Phim(String maPhim) {
		this.maPhim = maPhim;
	}

	public Phim(String maPhim, String tenPhim, double giaPhim, LoaiPhim maLoaiPhim, DangChieu maDangChieu) {
		super();
		this.maPhim = maPhim;
		this.tenPhim = tenPhim;
		this.maLoaiPhim = maLoaiPhim;
		this.maDangChieu = maDangChieu;
		this.giaPhim = giaPhim; 
	}
	
	//get, set
	
	
	public String getMaPhim() {
		return maPhim;
	}

	public double getGiaPhim() {
		return giaPhim;
	}

	public void setGiaPhim(double giaPhim) {
		this.giaPhim = giaPhim;
	}

	public void setMaPhim(String maPhim) {
		this.maPhim = maPhim;
	}

	public String getTenPhim() {
		return tenPhim;
	}

	public void setTenPhim(String tenPhim) {
		this.tenPhim = tenPhim;
	}

	public LoaiPhim getMaLoaiPhim() {
		return maLoaiPhim;
	}

	public void setMaLoaiPhim(LoaiPhim maLoaiPhim) {
		this.maLoaiPhim = maLoaiPhim;
	}

	public DangChieu getMaDangChieu() {
		return maDangChieu;
	}

	public void setMaDangChieu(DangChieu maDangChieu) {
		this.maDangChieu = maDangChieu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maPhim == null) ? 0 : maPhim.hashCode());
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
		Phim other = (Phim) obj;
		if (maPhim == null) {
			if (other.maPhim != null)
				return false;
		} else if (!maPhim.equalsIgnoreCase(other.maPhim))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phim [maPhim=" + maPhim + ", tenPhim=" + tenPhim + ", giaPhim=" + giaPhim + ", maLoaiPhim=" + maLoaiPhim
				+ ", maDangChieu=" + maDangChieu + "]";
	}


	
	
	
	
}

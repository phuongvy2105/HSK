package Entity;

import java.util.Objects;

public class LoaiPhong {
	private String maLoaiPhong;
	private String tenLoaiPhong;
	private float Gia;
	private String TienNghi;
	
	
	public LoaiPhong(String maLoaiPhong, String tenLoaiPhong, float gia, String tienNghi) {
		super();
		this.maLoaiPhong = maLoaiPhong;
		this.tenLoaiPhong = tenLoaiPhong;
		Gia = gia;
		TienNghi = tienNghi;
	}
	
	public LoaiPhong(String maLoaiPhong) {
		super();
		this.maLoaiPhong = maLoaiPhong;
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}
	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}
	public String getTenLoaiPhong() {
		return tenLoaiPhong;
	}
	public void setTenLoaiPhong(String tenLoaiPhong) {
		this.tenLoaiPhong = tenLoaiPhong;
	}
	public float getGia() {
		return Gia;
	}
	public void setGia(float gia) {
		Gia = gia;
	}
	public String getTienNghi() {
		return TienNghi;
	}
	public void setTienNghi(String tienNghi) {
		TienNghi = tienNghi;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maLoaiPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoaiPhong other = (LoaiPhong) obj;
		return Objects.equals(maLoaiPhong, other.maLoaiPhong);
	}
	public String toString() {
		return String.format("%s-%s",maLoaiPhong,tenLoaiPhong);
	}
	
	
}

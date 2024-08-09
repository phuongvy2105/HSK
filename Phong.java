package Entity;

import java.util.Objects;

public class Phong {
	 private String maPhong;
	 private int tangPhong;
	 private LoaiPhong loaiphong;
	 private boolean trangThai;
	 private String ghiChu;
	 private int soNguoi;
	 private float dienTich;
	 
	
	

	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	public Phong(String maPhong, int tangPhong, LoaiPhong loaiphong, boolean trangThai, String ghiChu, int soNguoi,
			float dienTich) {
		super();
		this.maPhong = maPhong;
		this.tangPhong = tangPhong;
		this.loaiphong = loaiphong;
		this.trangThai = trangThai;
		this.ghiChu = ghiChu;
		this.soNguoi = soNguoi;
		this.dienTich = dienTich;
	}
	
	public int getSoNguoi() {
		return soNguoi;
	}
	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}
	public float getDienTich() {
		return dienTich;
	}
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}
	public void setLoaiphong(LoaiPhong loaiphong) {
		this.loaiphong = loaiphong;
	}
	public LoaiPhong getLoaiphong() {
		return loaiphong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	
	
	public int getTangPhong() {
		return tangPhong;
	}

	public void setTangPhong(int tangPhong) {
		this.tangPhong = tangPhong;
	}

	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phong other = (Phong) obj;
		return Objects.equals(maPhong, other.maPhong);
	}
	 
	 
}

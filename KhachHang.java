package Entity;

import java.util.Objects;

public class KhachHang {
	private String makh;
	private String tenkh;
	private String CMND;
	private String diaCHi;
	private String sdt;
	private boolean gioiTinh;
	private int tuoi;
	private String email;
	private boolean thanhvien;
	 
	
	public KhachHang(String makh, String tenkh, String cMND, String diaCHi, String sdt, boolean gioiTinh, int tuoi,
			String email, boolean thanhvien) {
		super();
		this.makh = makh;
		this.tenkh = tenkh;
		CMND = cMND;
		this.diaCHi = diaCHi;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.tuoi = tuoi;
		this.email = email;
		this.thanhvien = thanhvien;
	}

	public KhachHang(String makh) {
		super();
		this.makh = makh;
	}

	@Override
	public int hashCode() {
		return Objects.hash(makh);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(makh, other.makh);
	}
	public String getMakh() {
		return makh;
	}
	public void setMakh(String makh) {
		this.makh = makh;
	}
	public String getTenkh() {
		return tenkh;
	}
	public void setTenkh(String tenkh) {
		this.tenkh = tenkh;
	}
	public String getCMND() {
		return CMND;
	}
	public void setCMND(String cMND) {
		CMND = cMND;
	}
	public String getDiaCHi() {
		return diaCHi;
	}
	public void setDiaCHi(String diaCHi) {
		this.diaCHi = diaCHi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isThanhvien() {
		return thanhvien;
	}

	public void setThanhvien(boolean thanhvien) {
		this.thanhvien = thanhvien;
	}
	
}

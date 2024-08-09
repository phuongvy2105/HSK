package Entity;

import java.util.Objects;

import GUI.GUI_LoaiDichVu;

public class DichVu {
	private String maDichVu;
	private String tenDichVu;
	private LoaiDichVu loaiDichVu;
	private float gia;
	
	public DichVu(String maDichVu, String tenDichVu, LoaiDichVu loaiDichVu, float gia) {
		super();
		this.maDichVu = maDichVu;
		this.tenDichVu = tenDichVu;
		this.loaiDichVu = loaiDichVu;
		this.gia = gia;
	}
	
	public DichVu(String maDichVu) {
		super();
		this.maDichVu = maDichVu;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDichVu);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DichVu other = (DichVu) obj;
		return Objects.equals(maDichVu, other.maDichVu);
	}

	public String getMaDichVu() {
		return maDichVu;
	}
	public void setMaDichVu(String maDichVu) {
		this.maDichVu = maDichVu;
	}
	public String getTenDichVu() {
		return tenDichVu;
	}
	public void setTenDichVu(String tenDichVu) {
		this.tenDichVu = tenDichVu;
	}
	public LoaiDichVu getLoaiDichVu() {
		return loaiDichVu;
	}
	public void setLoaiDichVu(LoaiDichVu loaiDichVu) {
		this.loaiDichVu = loaiDichVu;
	}
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	
	public String toString() {
		return String.format("%s-(%s VND)",tenDichVu,gia);
	}
}

package Entity;

import java.util.ArrayList;
import java.util.Objects;

public class SuDungDichVu {

	private int maSuDungDichVu;
	private Phong phong;
	private float TongThanhTien;
	
	
	
	public SuDungDichVu(int maSuDungDichVu, Phong phong, float tongThanhTien) {
		super();
		this.maSuDungDichVu = maSuDungDichVu;
		this.phong = phong;
		TongThanhTien = tongThanhTien;
	}

	public SuDungDichVu(Phong phong, float tongThanhTien) {
		super();

		this.phong = phong;
		TongThanhTien = tongThanhTien;
	}
	
	public int getMaSuDungDichVu() {
		return maSuDungDichVu;
	}

	public void setMaSuDungDichVu(int maSuDungDichVu) {
		this.maSuDungDichVu = maSuDungDichVu;
	}

	
	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public float getTongThanhTien() {
		return TongThanhTien;
	}
	public void setTongThanhTien(float tongThanhTien) {
		TongThanhTien = tongThanhTien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSuDungDichVu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SuDungDichVu other = (SuDungDichVu) obj;
		return maSuDungDichVu == other.maSuDungDichVu;
	}
	
	
	
	
	
}

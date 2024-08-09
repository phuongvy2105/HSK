package Entity;

import java.util.Objects;

public class ChiTietSuDungDichVu {
	private int soLuong;
	private DichVu dichvu;
	private SuDungDichVu sddichvu;
	private float thanhtien;
	
	
	
	
	public ChiTietSuDungDichVu(int soLuong, DichVu dichvu, SuDungDichVu sddichvu, float thanhtien) {
		super();
		this.soLuong = soLuong;
		this.dichvu = dichvu;
		this.sddichvu = sddichvu;
		this.thanhtien = thanhtien;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public DichVu getDichvu() {
		return dichvu;
	}
	public void setDichvu(DichVu dichvu) {
		this.dichvu = dichvu;
	}
	
	public SuDungDichVu getSddichvu() {
		return sddichvu;
	}
	public void setSddichvu(SuDungDichVu sddichvu) {
		this.sddichvu = sddichvu;
	}
	public float getThanhtien() {
		return thanhtien;
	}
	public void setThanhtien(float thanhtien) {
		this.thanhtien = thanhtien;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dichvu, sddichvu);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietSuDungDichVu other = (ChiTietSuDungDichVu) obj;
		return Objects.equals(dichvu, other.dichvu) && Objects.equals(sddichvu, other.sddichvu);
	}
	
	
	
	
	
	
}

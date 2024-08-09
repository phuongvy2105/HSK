package Entity;

public class HoaDon {
	private int maHoaDon;
	private KhachHang khachhang;
	private Phong phong;
	private SuDungDichVu hoadondv;
	private int sonngay;
	private float tienPhong;
	private float tongtien;
	private float giamgia;
	public static int ID=0;
	
	
	public HoaDon(int maHoaDon, KhachHang khachhang, Phong phong, SuDungDichVu hoadondv, int sonngay, float tienPhong,
			float tongtien, float giamgia, int mahoadon2) {
		super();
		this.maHoaDon = maHoaDon;
		this.khachhang = khachhang;
		this.phong = phong;
		this.hoadondv = hoadondv;
		this.sonngay = sonngay;
		this.tienPhong = tienPhong;
		this.tongtien = tongtien;
		this.giamgia = giamgia;
	
	}

	public HoaDon(KhachHang khachhang, Phong phong, SuDungDichVu hoadondv, int sonngay, float tienPhong,
			float tongtien, float giamgia) {
		super();
		this.maHoaDon=ID++;
		this.khachhang = khachhang;
		this.phong = phong;
		this.hoadondv = hoadondv;
		this.sonngay = sonngay;
		this.tienPhong = tienPhong;
		this.tongtien = tongtien;
		this.giamgia = giamgia;
	}
	
	public float getGiamgia() {
		return giamgia;
	}

	public void setGiamgia(float giamgia) {
		this.giamgia = giamgia;
	}

	public int getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public KhachHang getKhachhang() {
		return khachhang;
	}
	public void setKhachhang(KhachHang khachhang) {
		this.khachhang = khachhang;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public SuDungDichVu getHoadondv() {
		return hoadondv;
	}
	public void setHoadondv(SuDungDichVu hoadondv) {
		this.hoadondv = hoadondv;
	}
	public int getSonngay() {
		return sonngay;
	}
	public void setSonngay(int sonngay) {
		this.sonngay = sonngay;
	}
	public float getTienPhong() {
		return tienPhong;
	}
	public void setTienPhong(float tienPhong) {
		this.tienPhong = tienPhong;
	}
	public float getTongtien() {
		return tongtien;
	}
	public void setTongtien(float tongtien) {
		this.tongtien = tongtien;
	}
	
	
}

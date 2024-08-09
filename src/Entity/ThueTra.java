package Entity;

import java.sql.Date;
import java.time.LocalDate;



public class ThueTra {
	private KhachHang khachhang;
	private Phong phong;
	private Date ngayTra;
	private Date ngayDen;
	
	public ThueTra(KhachHang khachhang, Phong phong, Date ngayTra, Date ngayDen) {
		super();
		this.khachhang = khachhang;
		this.phong = phong;
		this.ngayTra = ngayTra;
		this.ngayDen = ngayDen;
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
	public Date getNgayTra() {
		return ngayTra;
	}
	public void setNgayTra(Date ngayTra) {
		if(ngayTra == null) {
			long millis=System.currentTimeMillis();  
			java.sql.Date date=new java.sql.Date(millis);
			this.ngayTra=date;
		}else {
			this.ngayTra = ngayTra;
		}
		
	}
	public Date getNgayDen() {
		return ngayDen;
	}
	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}
	
	
	
}

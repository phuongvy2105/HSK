package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;
import Entity.HoaDon;
import Entity.KhachHang;
import Entity.Phong;
import Entity.SuDungDichVu;

public class DAO_HoaDon {
	public ArrayList<HoaDon> getAllHoaDon(){
		ArrayList<HoaDon> list=new ArrayList<HoaDon>();
		try {
			String sql="Select * from HoaDon";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				int maHoaDon=rs.getInt(1);
				Phong phong=new DAO_Phong().timPhong(rs.getString(2));
				KhachHang khachhang=new DAO_KhachHang().timKhachHang(rs.getString(3));
				SuDungDichVu sudungDichVu=new DAO_HoaDonDichVu().timSuDungDichVuTheoMa(rs.getInt(4));
				int tongthoigian=rs.getInt(5);
				float tienphong=rs.getFloat(6);
				float giamgia=rs.getFloat(7);
				float tongtien=rs.getFloat(8);
				HoaDon hoadon=new HoaDon(maHoaDon, khachhang, phong, sudungDichVu, tongthoigian, tienphong, tongtien, giamgia, maHoaDon);
				list.add(hoadon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themHoaDon(HoaDon a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into HoaDon values(?,?,?,?,?,?,?)";
			statement=con.prepareStatement(sql);
			statement.setString(1,a.getPhong().getMaPhong());
			statement.setString(2, a.getKhachhang().getMakh());
			statement.setInt(3,a.getHoadondv().getMaSuDungDichVu());
			statement.setInt(4,a.getSonngay());
			statement.setFloat(5, a.getTienPhong());
			statement.setFloat(6, a.getGiamgia());
			statement.setFloat(7, a.getTongtien());
			int kq=statement.executeUpdate();
			statement.close();
			if(kq==1) {
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	
}

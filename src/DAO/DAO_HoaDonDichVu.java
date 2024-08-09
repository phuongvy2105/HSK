package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;
import Entity.ChiTietSuDungDichVu;
import Entity.DichVu;
import Entity.SuDungDichVu;
import Entity.KhachHang;
import Entity.Phong;

public class DAO_HoaDonDichVu {
	
	public ArrayList<SuDungDichVu> getAllHoaDonDichVu(){
		ArrayList<SuDungDichVu> list=new ArrayList<SuDungDichVu>();
		try {
			String sql="Select * from SuDungDichVu";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				int maSuDungDichVu=rs.getInt(1);
				Phong phong=new DAO_Phong().timPhong(rs.getString(3));
				float tongThanhTien=rs.getFloat(2);
				SuDungDichVu sudungDichVu=new SuDungDichVu(maSuDungDichVu, phong, tongThanhTien);
				list.add(sudungDichVu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themHoaDon(SuDungDichVu a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into SuDungDichVu values(?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setString(2,a.getPhong().getMaPhong());
			statement.setFloat(1, a.getTongThanhTien());	
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
	public boolean xoaHoaDonDichVu(String MaHoaDon) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from SuDungDichVu where maSuDungDichVu=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,MaHoaDon);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public  SuDungDichVu timSuDungDichVuTheoPhong(String maPhong) {
		
		ArrayList<SuDungDichVu> list = new DAO_HoaDonDichVu().getAllHoaDonDichVu();
		for (int i = list.size()-1; i >=0 ; i--) {
			if(list.get(i).getPhong().getMaPhong().equals(maPhong)) {
				return list.get(i);
			}
		}
		return null;
	}
public  SuDungDichVu timSuDungDichVuTheoMa(int maSuDungDichVu) {
		
		ArrayList<SuDungDichVu> list = new DAO_HoaDonDichVu().getAllHoaDonDichVu();
		for (SuDungDichVu dto_HoaDonDichVu : list) {
			if(dto_HoaDonDichVu.getMaSuDungDichVu()==maSuDungDichVu) {
				return dto_HoaDonDichVu;
			}
		}
		return null;
	}
	public  boolean capNhatSubTotal(String maPhong,float subtotal) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="Update SuDungDichVu  set  tongTien=? WHERE maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setString(2,maPhong);
			statement.setFloat(1, subtotal);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
      
    }
	
}

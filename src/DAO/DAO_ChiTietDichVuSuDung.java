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
import Entity.LoaiDichVu;
import Entity.LoaiPhong;
import Entity.Phong;

public class DAO_ChiTietDichVuSuDung {
	
	
	public ArrayList<ChiTietSuDungDichVu> getAllChiTietHoaDon(){
		ArrayList<ChiTietSuDungDichVu> list=new ArrayList<ChiTietSuDungDichVu>();
		
		try {
			String sql="Select * from CT_SuDungDichVu";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				SuDungDichVu hoadon=new DAO_HoaDonDichVu().timSuDungDichVuTheoMa(rs.getInt(1));
				DichVu dichvu=new DAO_DichVu().timDichVu(rs.getString(2));
				int soLuong=rs.getInt(3);
				float thanhtien=rs.getFloat(4);
				ChiTietSuDungDichVu cthoadon=new ChiTietSuDungDichVu(soLuong, dichvu, hoadon, thanhtien);
				list.add(cthoadon);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<ChiTietSuDungDichVu> getAllChiTietHoaDonDichVuTheoMa(int mahd){
		ArrayList<ChiTietSuDungDichVu> list= new ArrayList<ChiTietSuDungDichVu>();
		for (ChiTietSuDungDichVu dto_CT_HoaDonDichVu : list) {
			if(dto_CT_HoaDonDichVu.getSddichvu().getMaSuDungDichVu()==mahd) {
				list.add(dto_CT_HoaDonDichVu);
			}
		}
		return list;
	}
	public ChiTietSuDungDichVu timChiTietSuDungDichVu(ChiTietSuDungDichVu a){
		ArrayList<ChiTietSuDungDichVu> list= new DAO_ChiTietDichVuSuDung().getAllChiTietHoaDon();
		for (int i = list.size()-1; i >=0; i--) {
			
			if(list.get(i).getDichvu().getMaDichVu().equals(a.getDichvu().getMaDichVu())&& list.get(i).getSddichvu().getMaSuDungDichVu()==a.getSddichvu().getMaSuDungDichVu()) {
				return list.get(i);
			}
		}
		
		return null;
	}
	public boolean updateCTDichVu(int masudungdichvu,int soluong,float thanhtien,String madichvu) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update CT_SuDungDichVu set soLuong=soLuong+?,tongTien=tongTien+? where maSuDungDichVu=? and maDichVu=?";
			statement =con.prepareStatement(sql);
			statement.setInt(1,soluong);
			statement.setFloat(2, thanhtien);
			statement.setInt(3, masudungdichvu);
			statement.setString(4, madichvu);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
			
		}
	}
	
	public boolean themChiTietHoaDon(ChiTietSuDungDichVu a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into CT_SuDungDichVu\r\n"
					+ "values(?,?,?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setInt(1,a.getSddichvu().getMaSuDungDichVu());
			statement.setString(2,a.getDichvu().getMaDichVu());
			statement.setInt(3, a.getSoLuong());
			statement.setFloat(4, a.getThanhtien());
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
	public boolean xoaCTDichVu(int maHoaDon) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from CT_SuDungDichVu where maSuDungDichVu=?";
			statement =con.prepareStatement(sql);
			statement.setInt(1,maHoaDon);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	
	
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import Connect.ConnectDB;

import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.Phong;

public class DAO_Phong {
	
	
	public ArrayList<Phong> getAllPhong(){
		ArrayList<Phong> list=new ArrayList<Phong>();
		
		try {
			String sql="Select * from Phong";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maPhong=rs.getString(1);
				LoaiPhong loaiphong=new DAO_LOAIPHONG().timLoaiPhong(rs.getString(2));
				int tang=rs.getInt(3);
				boolean trangthai=rs.getBoolean(4);
				String ghiChu=rs.getNString(5);
				int soNguoi=rs.getInt(6);
				float dienTich=rs.getFloat(7);
				Phong phong=new Phong(maPhong, tang, loaiphong, trangthai, ghiChu, soNguoi, dienTich);
				list.add(phong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themPhong(Phong a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into Phong\r\n"
					+ "values(?,?,?,?,?,?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setString(1,a.getMaPhong());
			statement.setString(2,a.getLoaiphong().getMaLoaiPhong());
			statement.setInt(3, a.getTangPhong());
			statement.setBoolean(4,a.isTrangThai());
			statement.setString(5, a.getGhiChu());
			statement.setInt(6, a.getSoNguoi());
			statement.setFloat(7, a.getDienTich());
			
			
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
	public boolean xoaPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from Phong where maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,maPhong);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	public Phong timPhong(String maPhong) {
		ArrayList<Phong> list=new DAO_Phong().getAllPhong();
		for (Phong dto_Phong : list) {
			if(dto_Phong.getMaPhong().equals(maPhong)){
				return dto_Phong;
			}
		}
		return null;
	}
	public static boolean capNhatTrangThai (String maPhong) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update Phong set trangThai=? where maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setBoolean(1,false);
			statement.setString(2, maPhong);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public static boolean capNhatTrangThaiSanSang (String maPhong) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update Phong set trangThai=? where maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setBoolean(1,true);
			statement.setString(2, maPhong);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public ArrayList<Phong> getPhongTheoTrangThai(){
		ArrayList<Phong> list=new DAO_Phong().getAllPhong();
		for (Phong dto_Phong : list) {
			if(dto_Phong.isTrangThai()) {
				list.add(dto_Phong);
			}
		}
		return list;
	}
	public boolean  updatePhong(String maPhong,int tang,String maLoaiPhong,String ghichu,int soNguoi,float DienTich) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update Phong set tang=?,maLoaiPhong=?,soNguoi=?,dienTich=?,ghiChu=? where maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setInt(1, tang);
			statement.setString(2, maLoaiPhong);
			statement.setInt(3, soNguoi);
			statement.setFloat(4, DienTich);
			statement.setString(5, ghichu);
			statement.setString(6, maPhong);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
}

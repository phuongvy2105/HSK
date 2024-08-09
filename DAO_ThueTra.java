package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.ConnectDB;
import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.Phong;
import Entity.ThueTra;

public class DAO_ThueTra {
	public ArrayList<ThueTra> getAllThueTra(){
		ArrayList<ThueTra> list=new ArrayList<ThueTra>();
		
		try {
			String sql="Select * from ThueTra";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maPhong=rs.getString(1);
				String maKh=rs.getString(2);
				Date ngayTra=rs.getDate(3);
				Date ngayThue=rs.getDate(4);
				KhachHang khachhang=new DAO_KhachHang().timKhachHang(maKh);
				Phong phong=new DAO_Phong().timPhong(maPhong);
				ThueTra thuetra=new ThueTra(khachhang, phong, ngayTra, ngayThue);
				list.add(thuetra);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themThueTra(ThueTra a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into ThueTra\r\n"
					+ "values(?,?,?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setString(2,a.getKhachhang().getMakh());
			statement.setString(1,a.getPhong().getMaPhong());
			statement.setDate(3,a.getNgayTra());
			statement.setDate(4,a.getNgayDen());
			
			
			
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
	public boolean xoaThueTra(String maPhong) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from ThueTra where maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,maPhong);
			
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public ThueTra timThuetra(String maPhong) {
		ArrayList<ThueTra> list=new DAO_ThueTra().getAllThueTra();
		for (ThueTra dto_ThueTra : list) {
			if(dto_ThueTra.getPhong().getMaPhong().equals(maPhong)) {
				return dto_ThueTra;
			}
		}
		return null;
		
	}
	public ThueTra timThuetraTheoMaKhachHang(String makh) {
		ArrayList<ThueTra> list=new DAO_ThueTra().getAllThueTra();
		for (ThueTra dto_ThueTra : list) {
			if(dto_ThueTra.getKhachhang().getMakh().equals(makh)) {
				return dto_ThueTra;
			}
		}
		return null;
		
	}
	public boolean updateThueTra(String maPhong, String maKhachHang,Date ngaytra,Date ngaythue) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			
			String sql="update ThueTra set maKhachHang=?, ngayTra=? , ngayThue=? where maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,maKhachHang);
			statement.setDate(2, ngaytra);
			statement.setDate(3, ngaythue);
			statement.setString(4, maPhong);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
			
		}
	}
	public boolean updateNgayTra(String maPhong,Date date) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			
			String sql="update ThueTra set ngayTra=? where maPhong=?";
			statement =con.prepareStatement(sql);
			statement.setDate(1, date);
			statement.setString(2, maPhong);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
			
		}
	}
	
	
	

    
	
}

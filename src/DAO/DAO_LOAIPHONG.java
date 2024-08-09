package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.ConnectDB;
import Entity.LoaiPhong;

import GUI.GUI_LoaiPhong;

public class DAO_LOAIPHONG {
	public ArrayList<LoaiPhong> getAllLoaiPhong(){
		ArrayList<LoaiPhong> list=new ArrayList<LoaiPhong>();
		
		try {
			String sql="Select * from LoaiPhong";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maLoaiPhong=rs.getString(1);
				String tenLoaiPhong=rs.getString(2);
				float gia=rs.getFloat(3);
				String tiennghi=rs.getNString(4);
				LoaiPhong loai=new LoaiPhong(maLoaiPhong, tenLoaiPhong, gia, tiennghi);
				list.add(loai);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themLoaiPhong(LoaiPhong a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into LoaiPhong\r\n"
					+ "values(?,?,?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setString(1,a.getMaLoaiPhong());
			statement.setString(2,a.getTenLoaiPhong());
			statement.setFloat(3, a.getGia());
			statement.setString(4, a.getTienNghi());
			
			
			int kq=statement.executeUpdate();
			statement.close();
			if(kq==1) {
				return true;
			}else {
				return true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			return false;
		}
	}
	public boolean xoaPhong(String MaPhong) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from LoaiPhong where maLoaiPhong=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,MaPhong);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	
	public boolean suaLoaiPhong(String maLoaiPhong,String tenLoaiPhong,float gia,String tiennghi) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update LoaiPhong set tenLoaiPhong=?,gia=?,mota=? where maLoaiPhong=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,tenLoaiPhong);
			statement.setFloat(2,gia);
			statement.setString(3,tiennghi);
			statement.setString(4, maLoaiPhong);
			
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
			
		}
	}
	public LoaiPhong timLoaiPhong(String maLoaiPhong) {
		ArrayList<LoaiPhong> list=new DAO_LOAIPHONG().getAllLoaiPhong();
		for (LoaiPhong dto_LoaiPhong : list) {
			if(dto_LoaiPhong.getMaLoaiPhong().equals(maLoaiPhong)) {
				return dto_LoaiPhong;
			}
		}
		return null;
	}
	
}

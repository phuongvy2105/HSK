package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;

import Entity.DichVu;
import Entity.KhachHang;
import Entity.LoaiDichVu;
import Entity.LoaiPhong;

public class DAO_LoaiDichVu {
	public ArrayList<LoaiDichVu> getAllLoaiDichVu(){
		ArrayList<LoaiDichVu> list=new ArrayList<LoaiDichVu>();
		
		try {
			String sql="Select * from LoaiDichVu";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maLoaiDichVu=rs.getString(1);
				String tenLoaiDichVu=rs.getString(2);
				
				LoaiDichVu loai=new LoaiDichVu(maLoaiDichVu, tenLoaiDichVu);
				list.add(loai);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themLoaiDichVu(LoaiDichVu a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into LoaiDichVu\r\n"
					+ "values(?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setString(1,a.getMaLoaiDichVu());
			statement.setString(2,a.getTenLoaiDichVu());
			
			
			
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
	public boolean xoaLoaiDichVu(String maLoaiDichVu) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from LoaiDichVu where maLoaiDichVu=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,maLoaiDichVu);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public LoaiDichVu timDichVu(String maLoaiDichVu){
		ArrayList<LoaiDichVu> list=new DAO_LoaiDichVu().getAllLoaiDichVu();
		for (LoaiDichVu dto_LoaiDichVu : list) {
			if(dto_LoaiDichVu.getMaLoaiDichVu().equals(maLoaiDichVu)) {
				return dto_LoaiDichVu;
			}
		}
		return null;
	}
	public boolean updateLoaiDichVu(String maLoaiDichVu,String tenLoaiDichVu) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update LoaiDichVu set tenLoaiDichVu=? where maLoaiDichVu=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,tenLoaiDichVu);
			statement.setString(2,maLoaiDichVu);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	

   
    
}

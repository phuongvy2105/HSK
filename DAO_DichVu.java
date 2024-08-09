package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Connect.ConnectDB;

import Entity.DichVu;
import Entity.LoaiDichVu;
import Entity.LoaiPhong;
import Entity.Phong;

public class DAO_DichVu {
	public ArrayList<DichVu> getAllDichVu(){
		ArrayList<DichVu> list=new ArrayList<DichVu>();
		try {
			String sql="Select * from DichVu";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				LoaiDichVu loaiDichvu=new DAO_LoaiDichVu().timDichVu(rs.getString(3));
				float gia=rs.getFloat(4);
				DichVu dv=new DichVu(maDichVu, tenDichVu, loaiDichvu, gia);
				list.add(dv);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themDichVu(DichVu a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into DichVu\r\n"
					+ "values(?,?,?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setString(1,a.getMaDichVu());
			statement.setString(2,a.getTenDichVu());
			statement.setString(3, a.getLoaiDichVu().getMaLoaiDichVu());
			statement.setFloat(4,a.getGia());		
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
	public boolean xoaDichVu(String maDichVu) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from DichVu where maDichVu=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,maDichVu);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public DichVu timDichVu(String maDichVu) {
		ArrayList<DichVu> list=new DAO_DichVu().getAllDichVu();
		for (DichVu dto_DichVu : list) {
			if(dto_DichVu.getMaDichVu().equals(maDichVu)) {
				return dto_DichVu;
			}
		}
		return null;
	}
	public boolean  updateDichVu(String maDichVu,String tenDv,String maLoaiDichVu,float gia) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update DichVu set tenDichVu=?,maLoaiDichVu=?,gia=? where maDichVu=?";
			statement =con.prepareStatement(sql);
			statement.setString(1, tenDv);
			statement.setString(2, maLoaiDichVu);
			statement.setFloat(3, gia);
			statement.setString(4, maDichVu);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
}

package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Connect.ConnectDB;

import Entity.KhachHang;
import Entity.LoaiPhong;
import Entity.Phong;





public class DAO_KhachHang {
	
	public ArrayList<KhachHang> getAllKhachHang(){
		ArrayList<KhachHang> list=new ArrayList<KhachHang>();
		
		try {
			String sql="Select * from KhachHang";
			Connection con=ConnectDB.getConnection();
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(sql);
			while(rs.next()) {
				String maKhangHang=rs.getString(1);
				String tenKhachHang=rs.getString(2);
				int tuoi=rs.getInt(3);
				String CMND=rs.getString(4);
				String diaCHi=rs.getString(5);
				String email=rs.getString(6);
				String sdt=rs.getString(7);
				boolean gioitinh=rs.getBoolean(8);
				boolean ThanhVien=rs.getBoolean(9);
				KhachHang khachhang=new KhachHang(maKhangHang, tenKhachHang, CMND, diaCHi, sdt, gioitinh, tuoi, email, ThanhVien);
				list.add(khachhang);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public boolean themKhachHang(KhachHang a) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement;
		try {
			String sql="insert into KhachHang\r\n"
					+ "values(?,?,?,?,?,?,?,?,?)";
			
			statement=con.prepareStatement(sql);
			statement.setString(1,a.getMakh());
			statement.setString(2,a.getTenkh());
			statement.setInt(3, a.getTuoi());
			statement.setString(4,a.getCMND());
			statement.setString(5, a.getDiaCHi());
			statement.setString(6,a.getEmail());
			statement.setString(7, a.getSdt());
			statement.setBoolean(8, a.isGioiTinh());
			statement.setBoolean(9,a.isThanhvien());
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
	public boolean xoaKhachHang(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="delete from KhachHang where maKhachHang=?";
			statement =con.prepareStatement(sql);
			statement.setString(1,maKhachHang);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public boolean capnhatThanhVienKhachHang(String maKhachHang) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update KhachHang set KhachHangQuen=? where maKhachHang=?";
			statement =con.prepareStatement(sql);
			statement.setBoolean(1, true);
			statement.setString(2,maKhachHang);
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public boolean capnhatKhachHang(String maKhachHang,String tenkh,String CMND,String sdt,String email,String diachi,int tuoi,boolean gioitinh) {
		ConnectDB.getInstance();
		Connection con=ConnectDB.getConnection();
		PreparedStatement statement=null;
		try {
			String sql="update KhachHang set tenKhachHang=?,CMND=?,tuoi=?,diaChi=?,email=?,sdt=?,gioitinh=? where maKhachHang=?";
			statement =con.prepareStatement(sql);
			
			statement.setString(1,tenkh);
			statement.setString(2,CMND);
			statement.setInt(3, tuoi);
			statement.setString(4,diachi);
			statement.setString(5,email );
			statement.setString(6, sdt);
			statement.setBoolean(7, gioitinh);
			statement.setString(8, maKhachHang);
			
			statement.executeUpdate();
			return true;
		}catch (SQLException e) {
			return false;
		}
	}
	public KhachHang timKhachHang(String maKhachHang) {
		ArrayList<KhachHang> list=new DAO_KhachHang().getAllKhachHang();
		for (KhachHang dto_KhachHang : list) {
			if(dto_KhachHang.getMakh().equals(maKhachHang))
					return dto_KhachHang;
		}
		return null;
	}
}

package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;

import DAO.DAO_HoaDonDichVu;
import DAO.DAO_KhachHang;
import DAO.DAO_Phong;
import DAO.DAO_ThueTra;
import Entity.SuDungDichVu;
import Entity.KhachHang;
import Entity.Phong;
import Entity.ThueTra;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;

public class GUI_DatPhong extends JFrame implements ActionListener,MouseListener {
	private JTextField textTenKhachHang;
	private JTextField textTuoi;
	private JTextField textSDT;
	private JTextField txt_CMND;
	private JTextField txt_SoNguoi;
	private JTextField txt_Ngay;
	private JTextField txtEmail;
	private JButton btnCheckIn;
	private JTextField txt_DiaChi;
	private JComboBox cbx_GioiTinh;
	private JTextField txtNgayDen;
	private String maPhong1;
	private ArrayList<KhachHang> list;
	public String maHoaDon;
	private JButton btnHuy;

	public GUI_DatPhong(String maPhong) {
		maPhong1 = maPhong;
		getContentPane().setLayout(null);
		setSize(450, 491);
		setLocationRelativeTo(null);

		JLabel lblTenPhong = new JLabel("Phòng" + " " + maPhong);
		lblTenPhong.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblTenPhong.setBounds(141, 4, 148, 24);
		getContentPane().add(lblTenPhong);

		JLabel lblKhachHang = new JLabel("Khách Hàng");
		lblKhachHang.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblKhachHang.setBounds(41, 64, 111, 37);
		getContentPane().add(lblKhachHang);

		JLabel lblTuoi = new JLabel("Tuổi");
		lblTuoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblTuoi.setBounds(41, 98, 111, 37);
		getContentPane().add(lblTuoi);

		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblGiiTnh.setBounds(41, 127, 111, 37);
		getContentPane().add(lblGiiTnh);

		JLabel lblSDT = new JLabel("SDT");
		lblSDT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSDT.setBounds(41, 159, 111, 37);
		getContentPane().add(lblSDT);

		JLabel lblCMND = new JLabel("CCCD/CMND");
		lblCMND.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblCMND.setBounds(41, 188, 111, 37);
		getContentPane().add(lblCMND);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblEmail.setBounds(41, 215, 111, 37);
		getContentPane().add(lblEmail);

		JLabel lblDiaChi = new JLabel("Địa Chỉ");
		lblDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblDiaChi.setBounds(41, 244, 111, 37);
		getContentPane().add(lblDiaChi);

		JLabel lblSoNguoi = new JLabel("Số Người");
		lblSoNguoi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblSoNguoi.setBounds(41, 281, 111, 37);
		getContentPane().add(lblSoNguoi);

		textTenKhachHang = new JTextField();
		textTenKhachHang.setBounds(162, 73, 234, 20);
		getContentPane().add(textTenKhachHang);
		textTenKhachHang.setColumns(10);

		textTuoi = new JTextField();
		textTuoi.setBounds(162, 107, 237, 20);
		getContentPane().add(textTuoi);
		textTuoi.setColumns(10);

		textSDT = new JTextField();
		textSDT.setBounds(162, 168, 234, 20);
		getContentPane().add(textSDT);
		textSDT.setColumns(10);

		cbx_GioiTinh = new JComboBox();
		cbx_GioiTinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cbx_GioiTinh.setBounds(162, 135, 235, 22);
		getContentPane().add(cbx_GioiTinh);

		txt_CMND = new JTextField();
		txt_CMND.setColumns(10);
		txt_CMND.setBounds(161, 197, 235, 20);
		getContentPane().add(txt_CMND);

		txt_SoNguoi = new JTextField();
		txt_SoNguoi.setColumns(10);
		txt_SoNguoi.setBounds(161, 290, 235, 20);
		getContentPane().add(txt_SoNguoi);

		txt_DiaChi = new JTextField();
		txt_DiaChi.setBounds(163, 253, 233, 20);
		getContentPane().add(txt_DiaChi);
		txt_DiaChi.setColumns(10);

		btnCheckIn = new JButton("Check In!");
		btnCheckIn.setBackground(Color.GREEN);
		btnCheckIn.setBounds(102, 373, 89, 23);
		getContentPane().add(btnCheckIn);

		btnHuy = new JButton("Huỷ");
		btnHuy.setBackground(Color.RED);
		btnHuy.setBounds(223, 373, 89, 23);
		getContentPane().add(btnHuy);
		btnHuy.addActionListener(this);

		txtEmail = new JTextField();
		txtEmail.setBounds(162, 224, 234, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNgyn = new JLabel("Ngày Đến");
		lblNgyn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNgyn.setBounds(41, 312, 111, 37);
		getContentPane().add(lblNgyn);

		txtNgayDen = new JTextField();
		txtNgayDen.setEditable(false);
		txtNgayDen.setBounds(162, 321, 234, 20);
		getContentPane().add(txtNgayDen);
		txtNgayDen.setColumns(10);
		btnCheckIn.addActionListener(this);
		long millis = System.currentTimeMillis();
		java.sql.Date NgayDen = new java.sql.Date(millis);
		txtNgayDen.setText(NgayDen.toString());
	
	}

	private boolean validData() {
		String tenkh = textTenKhachHang.getText();
		String CMND = txt_CMND.getText();
		String diachi = txt_DiaChi.getText();
		String tuoi = textTuoi.getText();
		String sdt = textSDT.getText();
		String email = txtEmail.getText();
		if (tenkh.equals("")) {
			JOptionPane.showMessageDialog(null, "Bắt Buộc Nhập Tên Khách Hàng");
			return false;
		} else if (CMND.equals("")) {
			JOptionPane.showMessageDialog(null, "Bắt Buộc Nhập CMND");
			return false;
		} else if (tuoi.equals("")) {
			JOptionPane.showMessageDialog(null, "Bắt Buộc Nhập Tuổi");
			return false;
		} else if (sdt.equals("")) {
			JOptionPane.showMessageDialog(null, "Bắt Buộc Nhập Số Điện Thoại");
			return false;
		} else if (email.equals("")) {
			JOptionPane.showMessageDialog(null, "Bắt Buộc Nhập Email");
			return false;
		} else {
			try {
				int tuoii = Integer.parseInt(tuoi);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Tuổi Phải Nhập Số");
				return false;
			}
			String regexsdt = "^[0-9]{10,11}$";
			if (!sdt.matches(regexsdt)) {
				JOptionPane.showMessageDialog(null, "Số Điện Thoại từ 10-11 số");
				return false;
			}
			String regexEmail = "^[a-zA-Z][A-Za-z0-9]+@[a-zA-Z]+(.[A-Za-z]+){1,3}$";
			if (!email.matches(regexEmail)) {
				JOptionPane.showMessageDialog(null, "Email Không Hợp Lệ");
				return false;
			}
		}
		return true;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btnCheckIn)) {
			if (validData()) {
				String maKh = txt_CMND.getText();
				String tenkh = textTenKhachHang.getText();
				String CMND = txt_CMND.getText();
				String diachi = txt_DiaChi.getText();
				String tuoi = textTuoi.getText();
				int tuoii = Integer.parseInt(tuoi);
				String sdt = textSDT.getText();
				boolean gioitinh = cbx_GioiTinh.getSelectedItem().equals("Nam") ? true : false;
				String email = txtEmail.getText();
				///
				KhachHang kh = new KhachHang(maKh, tenkh, CMND, diachi, sdt, gioitinh, tuoii, email, false);
				DAO_KhachHang dao_khachhang = new DAO_KhachHang();
				KhachHang khachhang = dao_khachhang.timKhachHang(maKh);
				Phong phong = new DAO_Phong().timPhong(maPhong1);
				if (khachhang != null) {
					long millis = System.currentTimeMillis();
					java.sql.Date NgayDen = new java.sql.Date(millis);
					if (new DAO_ThueTra().updateThueTra(maPhong1, maKh, NgayDen, NgayDen)) {
						JOptionPane.showMessageDialog(null, "Check in thành công!");
						new DAO_Phong().capNhatTrangThai(maPhong1);
						GUI_Main.xoaHetDuLieuTrenModel();
						GUI_Main.doDuLieuTuCollection();
						SuDungDichVu sudungdichvu = new SuDungDichVu(phong, 0);
						new DAO_HoaDonDichVu().themHoaDon(sudungdichvu);
					}
				} else {
					if (new DAO_KhachHang().themKhachHang(kh)) {
						long millis = System.currentTimeMillis();
						java.sql.Date NgayDen = new java.sql.Date(millis);
						KhachHang khachHang = new DAO_KhachHang().timKhachHang(maKh);
						Phong phongg = new DAO_Phong().timPhong(maPhong1);
						if (new DAO_ThueTra().updateThueTra(maPhong1, maKh, NgayDen, NgayDen)) {
							JOptionPane.showMessageDialog(null, "Check in thành công!");
							new DAO_Phong().capNhatTrangThai(maPhong1);
							GUI_Main.xoaHetDuLieuTrenModel();
							GUI_Main.doDuLieuTuCollection();
							String maHoaDon = txt_CMND.getText().toString();
							SuDungDichVu sudungdichvu = new SuDungDichVu(phongg, 0);
							new DAO_HoaDonDichVu().themHoaDon(sudungdichvu);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Khách Hàng Đã Đặt Phòng Trước Đó");
					}

				}
			}

		}
		if(obj.equals(btnHuy)) {
			//this.dispose();
			setVisible(false);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

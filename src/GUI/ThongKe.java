package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JTextField;

import DAO.DAO_HoaDon;
import DAO.DAO_KhachHang;
import Entity.HoaDon;
import Entity.KhachHang;

public class ThongKe extends JFrame {
	private JTextField txt_TongDoanhThu;
	private JTextField txt_TongKhachHang;
	private JTextField txt_TongHoaDon;
	private JTextField txt_TongDichVu;
	public ThongKe() {
		setSize(841, 573);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 818, 41);
		getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("Thống Kê Doanh Thu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 268, 818, 41);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Thống Kê Dịch Vụ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tổng Doanh Thu:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(27, 62, 227, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tổng Khách Hàng:");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(27, 151, 227, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tổng Hoá Đơn:");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(27, 230, 227, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		txt_TongDoanhThu = new JTextField();
		txt_TongDoanhThu.setBounds(205, 61, 542, 20);
		getContentPane().add(txt_TongDoanhThu);
		txt_TongDoanhThu.setColumns(10);
		
		txt_TongKhachHang = new JTextField();
		txt_TongKhachHang.setBounds(205, 150, 542, 20);
		getContentPane().add(txt_TongKhachHang);
		txt_TongKhachHang.setColumns(10);
		
		txt_TongHoaDon = new JTextField();
		txt_TongHoaDon.setBounds(205, 229, 542, 20);
		getContentPane().add(txt_TongHoaDon);
		txt_TongHoaDon.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Tổng Doanh Thu Dịch Vụ");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(27, 358, 247, 20);
		getContentPane().add(lblNewLabel_3);
		
		txt_TongDichVu = new JTextField();
		txt_TongDichVu.setBounds(307, 360, 440, 20);
		getContentPane().add(txt_TongDichVu);
		txt_TongDichVu.setColumns(10);
		thongke();
	}
	private void thongke() {
		ArrayList<KhachHang> list=new DAO_KhachHang().getAllKhachHang();
		int tongsokhachhang=list.size();
		ArrayList<HoaDon> listHoaDon=new DAO_HoaDon().getAllHoaDon();
		int tongsohoadon=list.size();
		float tongDoanhThu=0;
		float tongTienDichVu=0;
		for (HoaDon hoaDon : listHoaDon) {
			tongDoanhThu+=hoaDon.getTongtien();
			tongTienDichVu+=hoaDon.getHoadondv().getTongThanhTien();
		}
		DecimalFormat df = new DecimalFormat("#,##0.00");
		txt_TongDichVu.setText(df.format(tongTienDichVu));
		txt_TongDoanhThu.setText(df.format(tongDoanhThu));
		txt_TongHoaDon.setText(tongsohoadon+" Hoá Đơn");
		txt_TongKhachHang.setText(tongsokhachhang+ " Khách Hàng");
		
	}
}

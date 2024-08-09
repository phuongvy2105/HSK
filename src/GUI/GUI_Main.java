package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import Connect.ConnectDB;
import DAO.DAO_Phong;
import Entity.Phong;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTable;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTextField;

public class GUI_Main extends JFrame implements ActionListener,MouseListener {
	private JPanel pMenu;
	private JButton btn_Home;
	private JButton btn_QuanLyPhong;
	private JButton btn_LoaiPhong;
	private JButton btn_DichVu;
	private JButton btnNewButton;
	private JButton btn_KhachHang;
	private JButton btnLoaiDichVu;
	private JButton DangXuat;
	private JPanel pCenter;
	public static DefaultTableModel model;
	private DefaultTableModel modeltang1;
	private JScrollPane scrollPanetang1;
	private DefaultTableModel modeltang2;
	private DefaultTableModel modeltang3;
	private JTable table2;
	private JTable table3;
	private JScrollPane JS_tang2;
	private JScrollPane JS_tang3;
	private JComboBox comboBox;
	private JScrollPane JS;
	private JScrollPane scrollPane;
	private JPanel panelTinhTrang;
	private JScrollPane js1;
	private JScrollPane js2;
	private JScrollPane js3;
	private DefaultTableModel modelPhong;
	public static JTable table;
	private JScrollPane js;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JMenuBar menuBar;
	private JMenu File;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JButton btnThongKe;
	private JButton btnDatPhong;
	private JButton btnDatTra;
	private JButton btnConTrong;
	private JButton btn_Thue;
	private DAO_Phong phong_dao;
	private JTextField txtTim;
	private JButton btnTim;
	public GUI_Main() {
		try {
			ConnectDB.getInstance().connect();
		}catch (SQLException e) {
			// TODO: handle exception
		}
		setTitle("Quản Lý Thông Tin Đặt Phòng Khách Sạn");
		setSize(1223, 600);
		setLocationRelativeTo(null);
		getContentPane().add(pMenu=new JPanel(),BorderLayout.WEST);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pMenu.setBackground(new Color(0, 128, 128));
		
		pCenter = new JPanel();
		getContentPane().add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(null);
		
		JPanel panelHead = new JPanel();
		panelHead.setBackground(new Color(192, 192, 192));
		panelHead.setBounds(10, 23, 658, 44);
		pCenter.add(panelHead);
		panelHead.setLayout(null);
		panelHead.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		btnConTrong = new JButton("Còn Trống\r\n");
		btnConTrong.setBackground(Color.RED);
		btnConTrong.setBounds(33, 11, 127, 23);
		panelHead.add(btnConTrong);
		
		btn_Thue = new JButton("Đã Thuê");
		btn_Thue.setBackground(Color.GREEN);
		btn_Thue.setBounds(177, 11, 150, 23);
		panelHead.add(btn_Thue);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập mã phòng cần tìm  ");
		lblNewLabel_3.setBounds(355, 15, 150, 14);
		panelHead.add(lblNewLabel_3);
		
		txtTim = new JTextField();
		txtTim.setBounds(490, 12, 60, 20);
		panelHead.add(txtTim);
		txtTim.setColumns(10);
		
		btnTim = new JButton("TÌM");
		btnTim.setBackground(new Color(148, 0, 211));
		btnTim.setBounds(559, 11, 70, 23);
		panelHead.add(btnTim);
		
		JLabel lblNewLabel = new JLabel("Hướng dẫn: Click chuột chọn phòng cần đặt và nhất nút đặt phòng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.ITALIC, 17));
		lblNewLabel.setBounds(10, 78, 502, 23);
		pCenter.add(lblNewLabel);
		
	
		
		panelTinhTrang = new JPanel();
		panelTinhTrang.setBackground(new Color(192, 192, 192));
		panelTinhTrang.setBounds(10, 123, 658, 341);
		pCenter.add(panelTinhTrang);
		panelTinhTrang.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		
		String[] headTang= {"Mã Phòng","Loại Phòng","Tầng","Tình trạng","Mô tả","Số Người","Diện Tích"};
		model= new DefaultTableModel(headTang, 0);
		
		
		table=new JTable(model);
		js=new JScrollPane(table);
		panelTinhTrang.add(js);
		js.setPreferredSize(new Dimension(600, 300));
		
		pMenu.setLayout(new GridLayout(10, 1));
		JLabel label = new JLabel("QUẢN LÝ KHÁCH SẠN");
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(30, 144, 255));
		pMenu.add(label);
		pMenu.add(btn_Home=new JButton("Home"));
		pMenu.add(btn_QuanLyPhong=new JButton("Quản Lý Phòng"));
		
		btn_LoaiPhong = new JButton("Loại Phòng");
		pMenu.add(btn_LoaiPhong);
		
		btn_DichVu = new JButton("Dịch Vụ");
		pMenu.add(btn_DichVu);
		
		btnLoaiDichVu = new JButton("Loại Dịch Vụ");
		pMenu.add(btnLoaiDichVu);
		
		btnThongKe = new JButton("Thống Kê");
		pMenu.add(btnThongKe);
		
		btn_KhachHang = new JButton("Khách Hàng");
		pMenu.add(btn_KhachHang);
		
		DangXuat = new JButton("Đăng Xuất");
		pMenu.add(DangXuat);
		
		
		
		panel = new JPanel();
		panel.setBounds(678, 11, 413, 541);
		pCenter.add(panel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("src\\hinh\\5098385.jpg"));
		panel.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Lọc:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 0, 49, 23);
		pCenter.add(lblNewLabel_2);
		
		JPanel panelFoot = new JPanel();
		panelFoot.setLayout(null);
		panelFoot.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelFoot.setBackground(Color.LIGHT_GRAY);
		panelFoot.setBounds(10, 486, 658, 44);
		pCenter.add(panelFoot);
		
		btnDatPhong = new JButton("Đặt Phòng");
		btnDatPhong.setBackground(Color.RED);
		btnDatPhong.setBounds(32, 11, 122, 23);
		panelFoot.add(btnDatPhong);
		
		btnDatTra = new JButton("Quản Lý Thuê Phòng");
		btnDatTra.setBackground(Color.GREEN);
		btnDatTra.setBounds(189, 11, 163, 23);
		panelFoot.add(btnDatTra);
		
		menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		File = new JMenu("File");
		menuBar.add(File);
		
		mntmNewMenuItem = new JMenuItem("Cài đặt tài khoản");
		File.add(mntmNewMenuItem);
		
		mntmNewMenuItem_1 = new JMenuItem("Cài đặt CSDL");
		File.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu = new JMenu("Help");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Hướng Dẫn Sử Dụng Chương Trình");
		mnNewMenu.add(mntmNewMenuItem_2);
		table.addMouseListener(this);
		btn_QuanLyPhong.addActionListener(this);
		btn_LoaiPhong.addActionListener(this);
		btn_DichVu.addActionListener(this);
		btnLoaiDichVu.addActionListener(this);
		btn_KhachHang.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnDatPhong.addActionListener(this);
		btnDatTra.addActionListener(this);
		btn_Thue.addActionListener(this);
		btnConTrong.addActionListener(this);
		btnTim.addActionListener(this);
		doDuLieuTuCollection();
		
	}
	public static void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}
	public static void doDuLieuTuCollection()  {
		
		ArrayList<Phong> list =new DAO_Phong().getAllPhong();
		for (Phong dto_Phong : list) {
			model.addRow(new Object[] {dto_Phong.getMaPhong(),dto_Phong.getLoaiphong().getMaLoaiPhong(),dto_Phong.getTangPhong(),dto_Phong.isTrangThai()?"Còn Trống":"Được Thuê",dto_Phong.getGhiChu(),dto_Phong.getSoNguoi(),dto_Phong.getDienTich()});
		}
	}
	public static void main(String[] args) {
		new GUI_Main().setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(btnDatPhong)) {
			int vitri = table.getSelectedRow();
			if (vitri ==-1) {
				JOptionPane.showMessageDialog(null, "Chưa chọn phòng");
			}else {
				
				String soPhong=model.getValueAt(vitri, 0).toString();
				if(new DAO_Phong().timPhong(soPhong).isTrangThai()) {
					new GUI_DatPhong(soPhong).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Phòng Đã Có Người Đặt");
				}
			}
			
			
		}else if(obj.equals(btnDatTra)) {
			int vitri = table.getSelectedRow();
			String soPhong=model.getValueAt(vitri, 0).toString();
			if(new DAO_Phong().timPhong(soPhong).isTrangThai()) {
				JOptionPane.showMessageDialog(null,"Phòng Chưa Có Người Thuê");
			}else {
				
				new GUI_ThongTinChiTiet(soPhong).setVisible(true);
			}
		}else if(obj.equals(btn_QuanLyPhong)) {
			new QUANLYPHONG().setVisible(true);
		}else if(obj.equals(btn_LoaiPhong)) {
			new GUI_LoaiPhong().setVisible(true);
		}else if(obj.equals(btn_DichVu)) {
			new GUI_DichVu().setVisible(true);
		}else if(obj.equals(btnLoaiDichVu)) {
			new GUI_LoaiDichVu().setVisible(true);
		}else if(obj.equals(btnThongKe)) {
			new ThongKe().setVisible(true);
		}else if(obj.equals(btn_KhachHang)) {
			new GUI_KhachHang().setVisible(true);
		}
		else if(obj.equals(btnConTrong)) {
			xoaHetDuLieuTrenModel();
			ArrayList<Phong> dsPhong=new DAO_Phong().getAllPhong();
			for(Phong p:dsPhong) {
				if(p.isTrangThai())
					model.addRow(new Object[] {p.getMaPhong(),p.getLoaiphong().getMaLoaiPhong(),
						p.getTangPhong(),p.isTrangThai()?"Còn Trống":"Đã Thuê",p.getGhiChu()});
			}
		}
		else if(obj.equals(btn_Thue)) {
			xoaHetDuLieuTrenModel();
			ArrayList<Phong> dsPhong=new DAO_Phong().getAllPhong();
			for(Phong p:dsPhong) {
				if(!(p.isTrangThai()))
					model.addRow(new Object[] {p.getMaPhong(),p.getLoaiphong().getMaLoaiPhong(),
						p.getTangPhong(),p.isTrangThai()?"Còn Trống":"Đã Thuê",p.getGhiChu()});
			}
		}else if(obj.equals(btnTim)) {
			String maphong=txtTim.getText();
			if(maphong.equals("")) {
				xoaHetDuLieuTrenModel();
				doDuLieuTuCollection();
			}else {
				xoaHetDuLieuTrenModel();
				ArrayList<Phong> list=new DAO_Phong().getAllPhong();
				for (Phong phong : list) {
					if(phong.getMaPhong().equals(maphong)) {
						model.addRow(new Object[] {phong.getMaPhong(),phong.getLoaiphong().getMaLoaiPhong(),phong.getTangPhong(),phong.isTrangThai()?"Còn Trống":"Được Thuê",phong.getGhiChu(),phong.getSoNguoi(),phong.getDienTich()});
					}
				}
			}
		}
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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

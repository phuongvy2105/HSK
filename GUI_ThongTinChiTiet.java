package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;



import DAO.DAO_ChiTietDichVuSuDung;
import DAO.DAO_DichVu;
import DAO.DAO_HoaDon;
import DAO.DAO_HoaDonDichVu;
import DAO.DAO_KhachHang;
import DAO.DAO_LoaiDichVu;
import DAO.DAO_Phong;
import DAO.DAO_ThueTra;
import Entity.ChiTietSuDungDichVu;
import Entity.DichVu;
import Entity.HoaDon;
import Entity.SuDungDichVu;
import Entity.KhachHang;
import Entity.LoaiDichVu;
import Entity.Phong;
import Entity.ThueTra;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI_ThongTinChiTiet extends JFrame implements ActionListener, ItemListener, MouseListener {
	private JTextField txtTenKH;
	private JTextField txt_Gioitinh;
	private JTextField txtCMND;
	private JTextField txtTuoi;
	private JTextField txtEmail;
	private JTextField txtQuequan;
	private JTextField txtSoPhong;
	private JTextField txtLoaiPhong;
	private JTextField txt_TienNghi;
	private JTextField txtGiaPhong;
	private DefaultTableModel model;
	private JTable table;
	private JScrollPane js;
	private JTextField txt_SoLuongDichVu;
	private JTextField textField;
	private JTextField txt_Thenganhang;
	private JTextField txt_TienKhachDua;
	private JTextField txt_TraLai;
	private static DefaultTableModel modeldv;
	private static JTable table_dv;
	private ThueTra thueTra;
	private JComboBox cbx_DichVu;
	private JComboBox cbx_LoaiDichVu;
	private JButton btnThemDichVu;
	private JButton btn_XoaDichVu;
	private ArrayList<DichVu> listDichVu;
	private float giaDichVu;
	private JTextField txt_ThanhTien;
	private float donGia;
	private Object thanhTien;
	private ArrayList<LoaiDichVu> list;
	private DefaultTableModel model_DichVu;
	private JTable table_DichVu;
	private JLabel lbl_TongthanhtienDichVu;
	private String maPhong1;
	private JTextField txtThanhVien;
	private JLabel lbTongTien;
	private JComboBox cbx_ThanhToan;
	private JLabel lblTongTienThanhToan;
	private float tongtienPhong;
	private float tongtienDV;
	private float tongtienthanhtoan;
	private JButton btnThanhToan;
	private JTextField txtDienDich;
	private JTextField txtSoNguoi;
	
	public GUI_ThongTinChiTiet(String maphong) {
		maPhong1 = maphong;
		thueTra = new DAO_ThueTra().timThuetra(maPhong1);
		getContentPane().setEnabled(false);
		getContentPane().setLayout(null);
		setSize(1142, 678);
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(-99, 0, 1231, 29);
		getContentPane().add(panel);
		JLabel lblNewLabel = new JLabel("Phòng: " + maphong);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setForeground(Color.WHITE);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(887, 39, 235, 549);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(220, 20, 60));
		panel_2.setBounds(0, 0, 235, 40);
		panel_1.add(panel_2);

		JLabel lblNewLabel_18 = new JLabel("Thanh Toán");
		lblNewLabel_18.setForeground(Color.WHITE);
		lblNewLabel_18.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_2.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Tổng Tiền:");
		lblNewLabel_19.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_19.setForeground(Color.RED);
		lblNewLabel_19.setBounds(10, 51, 99, 21);
		panel_1.add(lblNewLabel_19);

		lblTongTienThanhToan = new JLabel("New label");
		lblTongTienThanhToan.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblTongTienThanhToan.setBounds(104, 51, 121, 19);
		panel_1.add(lblTongTienThanhToan);

		JLabel lblNewLabel_20 = new JLabel("Hình Thức Thanh Toán");
		lblNewLabel_20.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel_20.setBounds(0, 99, 131, 14);
		panel_1.add(lblNewLabel_20);

		cbx_ThanhToan = new JComboBox();
		cbx_ThanhToan.setModel(new DefaultComboBoxModel(new String[] { "Tiền Mặt", "Ngân Hàng" }));
		cbx_ThanhToan.setBounds(141, 96, 84, 22);
		panel_1.add(cbx_ThanhToan);

		JLabel lblNewLabel_21 = new JLabel("Thẻ ngân hàng");
		lblNewLabel_21.setBounds(0, 124, 121, 14);
		panel_1.add(lblNewLabel_21);

		txt_Thenganhang = new JTextField();
		txt_Thenganhang.setBounds(131, 121, 96, 20);
		panel_1.add(txt_Thenganhang);
		txt_Thenganhang.setColumns(10);

		JLabel lblNewLabel_22 = new JLabel("Tiền Khách Đưa");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_22.setBounds(0, 149, 131, 14);
		panel_1.add(lblNewLabel_22);

		txt_TienKhachDua = new JTextField();
		txt_TienKhachDua.setBounds(131, 147, 94, 17);
		panel_1.add(txt_TienKhachDua);
		txt_TienKhachDua.setColumns(10);

		JLabel lblNewLabel_23 = new JLabel("Trả Lại");
		lblNewLabel_23.setBounds(0, 174, 89, 14);
		panel_1.add(lblNewLabel_23);

		txt_TraLai = new JTextField();
		txt_TraLai.setBounds(129, 171, 96, 20);
		panel_1.add(txt_TraLai);
		txt_TraLai.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 216, 215, 206);
		panel_1.add(textArea);

		JLabel lblNewLabel_24 = new JLabel("Ghi chú");
		lblNewLabel_24.setBounds(0, 199, 49, 14);
		panel_1.add(lblNewLabel_24);

		btnThanhToan = new JButton("Thanh Toán và Trả Phòng");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setBackground(Color.GREEN);
		btnThanhToan.setForeground(Color.DARK_GRAY);
		btnThanhToan.setBounds(10, 472, 215, 23);
		panel_1.add(btnThanhToan);

		JPanel pChiTietThuePhong = new JPanel();
		pChiTietThuePhong.setBackground(Color.LIGHT_GRAY);
		pChiTietThuePhong.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		pChiTietThuePhong.setBounds(10, 40, 867, 311);
		getContentPane().add(pChiTietThuePhong);
		pChiTietThuePhong.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(220, 20, 60));
		panel_4.setBounds(0, 0, 867, 40);
		pChiTietThuePhong.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Chi Tiết Thuê Phòng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(10, 5, 448, 24);
		panel_4.add(lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Thông Tin Khách Hàng", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		panel_5.setBounds(10, 51, 451, 134);
		pChiTietThuePhong.add(panel_5);
		panel_5.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Tên Khách Hàng");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_2.setBounds(10, 22, 92, 14);
		panel_5.add(lblNewLabel_2);

		txtTenKH = new JTextField(thueTra.getKhachhang().getTenkh().toString());
		txtTenKH.setEditable(false);
		txtTenKH.setBounds(100, 19, 138, 20);
		panel_5.add(txtTenKH);
		txtTenKH.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Giới Tính");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_3.setBounds(253, 22, 68, 14);
		panel_5.add(lblNewLabel_3);

		txt_Gioitinh = new JTextField();
		txt_Gioitinh.setEditable(false);
		txt_Gioitinh.setBounds(310, 19, 48, 20);
		panel_5.add(txt_Gioitinh);
		txt_Gioitinh.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("CMND/CCCD");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_4.setBounds(20, 48, 68, 14);
		panel_5.add(lblNewLabel_4);

		txtCMND = new JTextField();
		txtCMND.setEditable(false);
		txtCMND.setBounds(100, 47, 138, 20);
		panel_5.add(txtCMND);
		txtCMND.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tuổi");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_5.setBounds(253, 47, 49, 14);
		panel_5.add(lblNewLabel_5);

		txtTuoi = new JTextField();
		txtTuoi.setEditable(false);
		txtTuoi.setBounds(310, 47, 48, 20);
		panel_5.add(txtTuoi);
		txtTuoi.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Email");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_6.setBounds(24, 73, 78, 14);
		panel_5.add(lblNewLabel_6);

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(100, 70, 138, 20);
		panel_5.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Quê Quán");
		lblNewLabel_8.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_8.setBounds(20, 98, 49, 14);
		panel_5.add(lblNewLabel_8);

		txtQuequan = new JTextField();
		txtQuequan.setEditable(false);
		txtQuequan.setBounds(100, 98, 138, 20);
		panel_5.add(txtQuequan);
		txtQuequan.setColumns(10);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(
				new TitledBorder(null, "Chi Tiết Phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBounds(472, 51, 385, 134);
		pChiTietThuePhong.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_10 = new JLabel("Số Phòng");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblNewLabel_10.setBounds(20, 20, 49, 14);
		panel_6.add(lblNewLabel_10);

		txtSoPhong = new JTextField();
		txtSoPhong.setEditable(false);
		txtSoPhong.setBounds(100, 17, 114, 17);
		panel_6.add(txtSoPhong);
		txtSoPhong.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("Loại Phòng");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_11.setBounds(217, 19, 70, 14);
		panel_6.add(lblNewLabel_11);

		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setEditable(false);
		txtLoaiPhong.setBounds(287, 17, 89, 17);
		panel_6.add(txtLoaiPhong);
		txtLoaiPhong.setColumns(10);

		txt_TienNghi = new JTextField();
		txt_TienNghi.setEditable(false);
		txt_TienNghi.setBounds(100, 96, 276, 20);
		panel_6.add(txt_TienNghi);
		txt_TienNghi.setColumns(10);

		JLabel lblNewLabel_12 = new JLabel("Tiện Nghi");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_12.setBounds(20, 99, 49, 14);
		panel_6.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("Giá Phòng\r\n");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_13.setBounds(20, 45, 49, 14);
		panel_6.add(lblNewLabel_13);

		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtGiaPhong.setEditable(false);
		txtGiaPhong.setBounds(100, 45, 114, 20);
		panel_6.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);

		String[] head = { "Mã phòng", "Ngày Thuê", "Ngày trả", "Tổng Thời Gian", "Tiền Phòng", "Giảm Giá" };
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 196, 847, 77);
		pChiTietThuePhong.add(scrollPane);

		JLabel lblNewLabel_14 = new JLabel("Tổng Tiền Phòng:");
		lblNewLabel_14.setForeground(Color.RED);
		lblNewLabel_14.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_14.setBounds(10, 284, 162, 14);
		pChiTietThuePhong.add(lblNewLabel_14);

		lbTongTien = new JLabel("....");
		lbTongTien.setForeground(Color.RED);
		lbTongTien.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		lbTongTien.setBounds(345, 284, 255, 14);
		pChiTietThuePhong.add(lbTongTien);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		panel_3.setBounds(10, 362, 865, 226);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(220, 20, 60));
		panel_7.setBounds(0, 5, 865, 33);
		panel_3.add(panel_7);
		panel_7.setLayout(null);

		JLabel lblNewLabel_17 = new JLabel("Chi Tiết Dịch Vụ");
		lblNewLabel_17.setForeground(Color.WHITE);
		lblNewLabel_17.setBackground(Color.WHITE);
		lblNewLabel_17.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_17.setBounds(10, 5, 447, 14);
		panel_7.add(lblNewLabel_17);
		String[] headDv = { "Loại dịch vụ", "Tên Dịch vụ", "Đơn giá", "Số lượng", "Thành tiền" };
		model_DichVu = new DefaultTableModel(headDv, 0);
		table_DichVu = new JTable(model_DichVu);

		JScrollPane jsDV = new JScrollPane(table_DichVu);
		jsDV.setBounds(10, 49, 473, 140);

		panel_3.add(jsDV);
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "Thêm Dịch Vụ", TitledBorder.LEADING, TitledBorder.TOP,
				null, null));
		panel_8.setBounds(493, 49, 362, 166);
		panel_3.add(panel_8);
		panel_8.setLayout(null);

		JLabel lbl_ChonloaiDichVu = new JLabel("Chọn Loại Dịch Vụ");
		lbl_ChonloaiDichVu.setBounds(10, 35, 101, 14);
		panel_8.add(lbl_ChonloaiDichVu);

		cbx_LoaiDichVu = new JComboBox();
		cbx_LoaiDichVu.setBounds(137, 31, 174, 22);
		panel_8.add(cbx_LoaiDichVu);

		JLabel lblNewLabel_15 = new JLabel("Số Lượng");
		lblNewLabel_15.setBounds(10, 83, 83, 14);
		panel_8.add(lblNewLabel_15);

		txt_SoLuongDichVu = new JTextField();
		txt_SoLuongDichVu.setBounds(137, 78, 174, 22);
		panel_8.add(txt_SoLuongDichVu);
		txt_SoLuongDichVu.setColumns(10);

		JLabel lbl_ThanhTien = new JLabel("Thành Tiền");
		lbl_ThanhTien.setBounds(10, 109, 101, 14);
		panel_8.add(lbl_ThanhTien);

		txt_ThanhTien = new JTextField();
		txt_ThanhTien.setEditable(false);
		txt_ThanhTien.setBounds(137, 103, 174, 20);
		panel_8.add(txt_ThanhTien);
		txt_ThanhTien.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("Chọn Dịch Vụ");
		lblNewLabel_16.setBounds(10, 58, 83, 14);
		panel_8.add(lblNewLabel_16);

		cbx_DichVu = new JComboBox<DichVu>();
		cbx_DichVu.setBounds(137, 54, 174, 22);
		panel_8.add(cbx_DichVu);

		btnThemDichVu = new JButton("Thêm");
		btnThemDichVu.setBackground(new Color(50, 205, 50));
		btnThemDichVu.setBounds(137, 132, 89, 23);
		panel_8.add(btnThemDichVu);

		btn_XoaDichVu = new JButton("Xoá Dịch Vụ");
		btn_XoaDichVu.setBackground(new Color(153, 50, 204));
		btn_XoaDichVu.setBounds(354, 192, 129, 23);
		panel_3.add(btn_XoaDichVu);

		JLabel lblNewLabel_25 = new JLabel("Tổng Tiền DV:");
		lblNewLabel_25.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_25.setForeground(Color.RED);
		lblNewLabel_25.setBounds(20, 200, 151, 15);
		panel_3.add(lblNewLabel_25);

		lbl_TongthanhtienDichVu = new JLabel("...");
		lbl_TongthanhtienDichVu.setForeground(Color.RED);
		lbl_TongthanhtienDichVu.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		lbl_TongthanhtienDichVu.setBounds(166, 200, 151, 15);
		panel_3.add(lbl_TongthanhtienDichVu);
		txtCMND.setText(thueTra.getKhachhang().getCMND().toString());
		txtEmail.setText(thueTra.getKhachhang().getEmail().toString());
		txtQuequan.setText(thueTra.getKhachhang().getDiaCHi().toString());
		txt_Gioitinh.setText(thueTra.getKhachhang().isGioiTinh() ? "Nam" : "Nữ");
		txtTuoi.setText(String.format("%d", thueTra.getKhachhang().getTuoi()));

		JLabel lblThanhVien = new JLabel("Thành Viên");
		lblThanhVien.setFont(new Font("Times New Roman", Font.BOLD, 9));
		lblThanhVien.setBounds(253, 72, 49, 14);
		panel_5.add(lblThanhVien);

		txtThanhVien = new JTextField();
		txtThanhVien.setEditable(false);
		txtThanhVien.setColumns(10);
		txtThanhVien.setBounds(310, 69, 48, 20);
		panel_5.add(txtThanhVien);

		
		JLabel lblNewLabel_13_1 = new JLabel("Diện Tích");
		lblNewLabel_13_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_13_1.setBounds(20, 70, 49, 14);
		panel_6.add(lblNewLabel_13_1);
		
		txtDienDich = new JTextField();
		txtDienDich.setText("0.0 VND");
		txtDienDich.setFont(new Font("Tahoma", Font.PLAIN, 9));
		txtDienDich.setEditable(false);
		txtDienDich.setColumns(10);
		txtDienDich.setBounds(100, 68, 114, 20);
		panel_6.add(txtDienDich);
		
		JLabel lblNewLabel_11_1 = new JLabel("Số Người");
		lblNewLabel_11_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblNewLabel_11_1.setBounds(217, 45, 70, 14);
		panel_6.add(lblNewLabel_11_1);
		
		txtSoNguoi = new JTextField();
		txtSoNguoi.setEditable(false);
		txtSoNguoi.setBounds(287, 44, 89, 14);
		panel_6.add(txtSoNguoi);
		txtSoNguoi.setColumns(10);
		txtThanhVien.setText(thueTra.getKhachhang().isThanhvien()?"true":"false");
		
		txtSoPhong.setText(thueTra.getPhong().getMaPhong());
		txt_TienNghi.setText(thueTra.getPhong().getLoaiphong().getTienNghi());
		txtLoaiPhong.setText(thueTra.getPhong().getLoaiphong().getTenLoaiPhong());
		txtGiaPhong.setText(thueTra.getPhong().getLoaiphong().getGia() + " VND");
		txtSoNguoi.setText((thueTra.getPhong().getSoNguoi())+" Người");
		txtDienDich.setText(thueTra.getPhong().getDienTich()+" m2");
		//add Event
		btnThemDichVu.addActionListener(this);
		btn_XoaDichVu.addActionListener(this);
		txt_SoLuongDichVu.addMouseListener(this);
		txt_TraLai.addMouseListener(this);
		txt_TienKhachDua.addMouseListener(this);
		cbx_LoaiDichVu.addActionListener(this);
		cbx_DichVu.addActionListener(this);
		cbx_LoaiDichVu.addItemListener(this);
		cbx_ThanhToan.addActionListener(this);
		btnThanhToan.addActionListener(this);
		//Đọc Dữ Liệu
		try {
			
			DuyetComboBoxLoaiDichVu();
			DuyetComBoxDichVu();
			updateTongTien();
			doDuLieuVaoModel();
			doDuLieuTuCollectionHoaDonDichvu();
			tinhTongTienThanhToan();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	private void doDuLieuVaoModel() {
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		new DAO_ThueTra().updateNgayTra(thueTra.getPhong().getMaPhong(),date);
		KhachHang kh = thueTra.getKhachhang();
		String maphong = thueTra.getPhong().getMaPhong();
		LocalDate ngayden = thueTra.getNgayDen().toLocalDate();
		LocalDate ngaydi = date.toLocalDate();
		Period ngay = Period.between(ngayden, ngaydi);
		int soNgay = (ngay.getDays() == 0) ? 1 : ngay.getDays();
		String maPhong = maPhong1;
		float tienPhong = new DAO_Phong().timPhong(maPhong).getLoaiphong().getGia();
		float giamGia = (kh.isThanhvien()) ? 50000 : 0;
		model.addRow(new Object[] { maphong, ngayden, ngaydi, soNgay, tienPhong, giamGia });
		tongtienPhong = soNgay * tienPhong - giamGia;
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String tongtienn = df.format(tongtienPhong);
		lbTongTien.setText(tongtienn + " VND");

	}
	private void capNhatThanhToan() {
		LocalDate ngayden = thueTra.getNgayDen().toLocalDate();
		LocalDate ngaydi = thueTra.getNgayTra().toLocalDate();
		Period ngay = Period.between(ngayden, ngaydi);
		int soNgay = (ngay.getDays() == 0) ? 1 : ngay.getDays();
		Phong phong=thueTra.getPhong();
		KhachHang khachhang=thueTra.getKhachhang();
		float  tienPhong=(float) model.getValueAt(0,4);
		float giamgia=(float) model.getValueAt(0, 5);
		float tongtient=tongtienthanhtoan;
		SuDungDichVu sudungdichvu=new DAO_HoaDonDichVu().timSuDungDichVuTheoPhong(maPhong1);
		HoaDon hoadon=new HoaDon(khachhang, phong, sudungdichvu, soNgay, tienPhong, tongtient, giamgia);
		new DAO_HoaDon().themHoaDon(hoadon);
		new DAO_Phong().capNhatTrangThaiSanSang(maPhong1);
		new DAO_KhachHang().capnhatThanhVienKhachHang(thueTra.getKhachhang().getMakh());
		new DAO_ThueTra().updateThueTra(maPhong1,null, null, null);
		JOptionPane.showMessageDialog(null,"Thanh toán và trả phòng thành công!");
		GUI_Main.xoaHetDuLieuTrenModel();
		GUI_Main.doDuLieuTuCollection();
		setVisible(false);
	
	}
	private void DuyetComboBoxLoaiDichVu() throws SQLException {
		ArrayList<LoaiDichVu> list = new DAO_LoaiDichVu().getAllLoaiDichVu();
		for (LoaiDichVu dto_LoaiDichVu : list) {
			cbx_LoaiDichVu.addItem(dto_LoaiDichVu.toString());
		}
	}

	private void tinhTongTienThanhToan() {
		tongtienthanhtoan=tongtienPhong+tongtienDV;
		DecimalFormat df = new DecimalFormat("#,##0.00");
		String tongtienthanhtoann = df.format(tongtienthanhtoan);
		lblTongTienThanhToan.setText(tongtienthanhtoann+" VND");
	}

	private void updateTongTien() throws SQLException {
		
		SuDungDichVu sudungdichvu = new  DAO_HoaDonDichVu().timSuDungDichVuTheoPhong(maPhong1);
		ArrayList<ChiTietSuDungDichVu> list = new DAO_ChiTietDichVuSuDung().getAllChiTietHoaDon();
		tongtienDV = 0;
		for (ChiTietSuDungDichVu dto_CT_HoaDonDichVu : list) {
			if (dto_CT_HoaDonDichVu.getSddichvu().equals(sudungdichvu)) {
				tongtienDV = tongtienDV + dto_CT_HoaDonDichVu.getThanhtien();
			}
		}
		new DAO_HoaDonDichVu().capNhatSubTotal(maPhong1, tongtienDV);
		lbl_TongthanhtienDichVu.setText(tongtienDV + "vnd");
	}

	private void DuyetComBoxDichVu() throws SQLException {
		String loai = cbx_LoaiDichVu.getSelectedItem().toString();
		System.out.println(loai);
		String[] maLoai = loai.split("-");
		listDichVu = new DAO_DichVu().getAllDichVu();
		for (DichVu dto_DichVu : listDichVu) {
			if (dto_DichVu.getLoaiDichVu().getMaLoaiDichVu().equals(maLoai[0])) {
				cbx_DichVu.addItem(dto_DichVu.toString());
			}
		}
	}

	public void xoaHetDuLieuTrenModelDichVu() {
		DefaultTableModel dm = (DefaultTableModel) table_DichVu.getModel();
		dm.getDataVector().removeAllElements();
	}

	public void doDuLieuTuCollectionHoaDonDichvu() throws SQLException {

		ArrayList<ChiTietSuDungDichVu> list = new DAO_ChiTietDichVuSuDung().getAllChiTietHoaDon();
		for (ChiTietSuDungDichVu dto_cthd : list) {
			int maSuDungDichVu = new DAO_HoaDonDichVu().timSuDungDichVuTheoPhong(maPhong1).getMaSuDungDichVu();
			if (dto_cthd.getSddichvu().getMaSuDungDichVu()==maSuDungDichVu) {
				model_DichVu.addRow(new Object[] { dto_cthd.getDichvu().getLoaiDichVu().getTenLoaiDichVu(),
						dto_cthd.getDichvu().getTenDichVu(), dto_cthd.getDichvu().getGia(), dto_cthd.getSoLuong(),
						dto_cthd.getThanhtien() });
			}

		}
	}

	private DichVu getDichVuCBX() {
		ArrayList<DichVu> list = new DAO_DichVu().getAllDichVu();
		for (DichVu dto_DichVu : list) {
			if (dto_DichVu.toString().equals(cbx_DichVu.getSelectedItem().toString()))
				return dto_DichVu;
		}

		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(cbx_LoaiDichVu)) {
			try {
				cbx_DichVu.removeAllItems();
				DuyetComBoxDichVu();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (obj.equals(btnThemDichVu)) {

			try {
				SuDungDichVu suDungDichVu = new DAO_HoaDonDichVu().timSuDungDichVuTheoPhong(maPhong1);
				System.out.println(suDungDichVu.getMaSuDungDichVu());
				int soLuong = Integer.parseInt(txt_SoLuongDichVu.getText());
				float thanhTien = Float.parseFloat(txt_ThanhTien.getText());
				ChiTietSuDungDichVu ChiTietDichVu = new ChiTietSuDungDichVu(soLuong, getDichVuCBX(), suDungDichVu, thanhTien);
				ChiTietSuDungDichVu timChiTietDichVu=new DAO_ChiTietDichVuSuDung().timChiTietSuDungDichVu(ChiTietDichVu);
				if(timChiTietDichVu==null) {
					if (new DAO_ChiTietDichVuSuDung().themChiTietHoaDon(ChiTietDichVu)) {
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
						xoaHetDuLieuTrenModelDichVu();
						doDuLieuTuCollectionHoaDonDichvu();
						updateTongTien();
						tinhTongTienThanhToan();
					}
				}else {
					new DAO_ChiTietDichVuSuDung().updateCTDichVu(timChiTietDichVu.getSddichvu().getMaSuDungDichVu(), soLuong, thanhTien, timChiTietDichVu.getDichvu().getMaDichVu());
					JOptionPane.showMessageDialog(null, "Thêm Thành Công");
					xoaHetDuLieuTrenModelDichVu();
					doDuLieuTuCollectionHoaDonDichvu();
					updateTongTien();
					tinhTongTienThanhToan();
				}
				

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (obj.equals(cbx_ThanhToan)) {
			if (cbx_ThanhToan.getSelectedIndex() == 0) {
				txt_Thenganhang.setEditable(false);
				txt_TienKhachDua.setEditable(true);

			} else if (cbx_ThanhToan.getSelectedIndex() == 1) {
				txt_TienKhachDua.setEditable(false);
				txt_Thenganhang.setEditable(true);
				
			}
		}if(obj.equals(btnThanhToan)) {
			capNhatThanhToan();
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
		Object obj = e.getSource();
		if (obj.equals(txt_SoLuongDichVu)) {
			String so = txt_SoLuongDichVu.getText();
			if (so.equals("")) {

			} else {
				int soluong = Integer.parseInt(so);
				for (DichVu dto_DichVu : listDichVu) {
					if (dto_DichVu.toString().equals(cbx_DichVu.getSelectedItem().toString())) {
						donGia = dto_DichVu.getGia();
						thanhTien = soluong * donGia;
						txt_ThanhTien.setText(thanhTien.toString());
					}
				}

			}
		}if(obj.equals(txt_TienKhachDua)) {
			String tienKhachDua=txt_TienKhachDua.getText();
			try {
				float TienKhachduaa=Float.parseFloat(tienKhachDua);
				float tientralai= TienKhachduaa-tongtienthanhtoan;
				String tien=String.format(tientralai+ "VND");
				txt_TraLai.setText(tien);
			}catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Tiền khách đưa phải nhập số");
			}
			
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {

	}
}

package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_KhachHang;
import DAO.DAO_Phong;
import Entity.KhachHang;
import Entity.Phong;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class GUI_KhachHang extends JFrame implements ActionListener,MouseListener {
	private JTextField txtMaKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtTuoi;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtEmail;
	private JTextField txt_DiaChi;
	private DefaultTableModel model;
	private JTable table;
	private JButton btn_Xoa;
	private JButton btn_Sua;
	private JButton btnLmMi;
	private JButton btn_Them;
	private JComboBox cbx_gioitinh;

	public GUI_KhachHang() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(new Dimension(915, 495));
		setLocationRelativeTo(null);
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 898, 45);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ KHÁCH HÀNG\r\n");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã Khách Hàng");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(43, 76, 175, 23);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên Khách Hàng");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(43, 130, 175, 23);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Tuổi");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(43, 181, 109, 23);
		getContentPane().add(lblNewLabel_1_2);

		JLabel txt_CMND = new JLabel("CMND");
		txt_CMND.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txt_CMND.setBounds(382, 76, 50, 23);
		getContentPane().add(txt_CMND);

		JLabel txt_SDT = new JLabel("SDT");
		txt_SDT.setFont(new Font("Times New Roman", Font.BOLD, 15));
		txt_SDT.setBounds(382, 130, 50, 23);
		getContentPane().add(txt_SDT);

		JLabel TXTemail = new JLabel("Email");
		TXTemail.setFont(new Font("Times New Roman", Font.BOLD, 15));
		TXTemail.setBounds(382, 181, 68, 23);
		getContentPane().add(TXTemail);

		JLabel lblNewLabel_1_6 = new JLabel("Địa Chỉ");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_6.setBounds(595, 81, 175, 23);
		getContentPane().add(lblNewLabel_1_6);

		JLabel lblNewLabel_1_7 = new JLabel("Giới Tính");
		lblNewLabel_1_7.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1_7.setBounds(595, 135, 175, 23);
		getContentPane().add(lblNewLabel_1_7);

		txtMaKhachHang = new JTextField();
		txtMaKhachHang.setBounds(173, 78, 147, 20);
		getContentPane().add(txtMaKhachHang);
		txtMaKhachHang.setColumns(10);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setBounds(173, 132, 147, 20);
		getContentPane().add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);

		txtTuoi = new JTextField();
		txtTuoi.setBounds(173, 183, 147, 20);
		getContentPane().add(txtTuoi);
		txtTuoi.setColumns(10);

		txtCMND = new JTextField();
		txtCMND.setBounds(439, 78, 118, 20);
		getContentPane().add(txtCMND);
		txtCMND.setColumns(10);

		txtSDT = new JTextField();
		txtSDT.setBounds(437, 132, 118, 20);
		getContentPane().add(txtSDT);
		txtSDT.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(436, 183, 121, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		txt_DiaChi = new JTextField();
		txt_DiaChi.setBounds(685, 78, 138, 20);
		getContentPane().add(txt_DiaChi);
		txt_DiaChi.setColumns(10);

		cbx_gioitinh = new JComboBox();
		cbx_gioitinh.setModel(new DefaultComboBoxModel(new String[] { "Nam", "Nữ" }));
		cbx_gioitinh.setBounds(685, 136, 138, 22);
		getContentPane().add(cbx_gioitinh);

		String[] head = { "Mã Khách Hàng", "Tên Khách Hàng", "CMND", "SDT", "Email", "Địa Chỉ", "Giới Tính", "Tuổi",
				"Thành Viên" };
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 283, 878, 164);
		getContentPane().add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 220, 878, 51);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btn_Them = new JButton("Thêm");
		btn_Them.setBounds(150, 11, 110, 23);
		panel_1.add(btn_Them);

		btn_Xoa = new JButton("Xoá");
		btn_Xoa.setBounds(291, 11, 110, 23);
		panel_1.add(btn_Xoa);

		btn_Sua = new JButton("Sửa");
		btn_Sua.setBounds(431, 11, 110, 23);
		panel_1.add(btn_Sua);

		btnLmMi = new JButton("Làm Mới");
		btnLmMi.setBounds(581, 11, 110, 23);
		panel_1.add(btnLmMi);
		try {
			doDuLieuTuCollection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		btn_Them.addActionListener(this);
		btn_Xoa.addActionListener(this);
		btnLmMi.addActionListener(this);
		btn_Sua.addActionListener(this);
		table.addMouseListener(this);
	}

	private boolean validData() {
		String tenkh = txtTenKhachHang.getText();
		String CMND = txtCMND.getText();
		String diachi = txt_DiaChi.getText();
		String tuoi = txtTuoi.getText();
		String sdt = txtSDT.getText();
		String email = txtEmail.getText();
		if (tenkh.equals("")) {
			JOptionPane.showMessageDialog(null, "Bắt Buộc Nhập Mã Khách Hàng");
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

	private void doDuLieuTuCollection() throws SQLException {

		ArrayList<KhachHang> list = new DAO_KhachHang().getAllKhachHang();
		for (KhachHang dto_KhachHang : list) {
			model.addRow(new Object[] { dto_KhachHang.getMakh(), dto_KhachHang.getTenkh(), dto_KhachHang.getCMND(),
					dto_KhachHang.getSdt(), dto_KhachHang.getEmail(), dto_KhachHang.getDiaCHi(),
					dto_KhachHang.isGioiTinh() == true ? "Nam" : "Nữ", dto_KhachHang.getTuoi(),
					dto_KhachHang.isThanhvien() ? "là thành viên" : "không" });
		}

	}

	private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btn_Them)) {

		} else if (obj.equals(btn_Xoa)) {
			int row = table.getSelectedRow();
			String makh = model.getValueAt(row, 0).toString();
			if (row == -1) {
				JOptionPane.showMessageDialog(null, "Chưa chọn khách hàng cần xoá");
			}
			if (new DAO_KhachHang().xoaKhachHang(makh)) {
				JOptionPane.showMessageDialog(null, "Xoá thành công khách hàng");
				xoaHetDuLieuTrenModel();
				try {
					doDuLieuTuCollection();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			} else {
				JOptionPane.showMessageDialog(null, "Khách hàng đang thuê phòng không được xoá");
			}
		}else if(obj.equals(btn_Sua)) {
			int r=table.getSelectedRow();
			if(validData()) {
				String maKhachhang =txtMaKhachHang.getText();
				if(!model.getValueAt(r, 0).equals(maKhachhang)) {
					JOptionPane.showMessageDialog(null, "Không được sửa mã");
				}
				String ten=txtTenKhachHang.getText();
				String email=txtEmail.getText();
				String sdt=txtSDT.getText();
				String diachi=txt_DiaChi.getText();
				boolean gioiTinh=cbx_gioitinh.getSelectedIndex()==0?true:false;
				String CMND=txtCMND.getText();
				int tuoi=Integer.parseInt(txtTuoi.getText());
				if(new DAO_KhachHang().capnhatKhachHang(maKhachhang, ten, CMND, sdt, email, diachi, tuoi, gioiTinh)) {
					JOptionPane.showMessageDialog(null, "Sửa thành công");
					xoaHetDuLieuTrenModel();
					try {
						doDuLieuTuCollection();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "Sửa thất bại");
				}

				
			}else {
				JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!");
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		txtMaKhachHang.setText(model.getValueAt(row, 0).toString());
		txtTenKhachHang.setText(model.getValueAt(row, 1).toString());
		txtCMND.setText(model.getValueAt(row, 2).toString());
		txtSDT.setText(model.getValueAt(row, 3).toString());
		txtEmail.setText(model.getValueAt(row, 4).toString());
		txt_DiaChi.setText(model.getValueAt(row,5).toString());
		cbx_gioitinh.setSelectedIndex((model.getValueAt(row, 6).toString().equals("Nam")?0:1));
		txtTuoi.setText(model.getValueAt(row, 7).toString());
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

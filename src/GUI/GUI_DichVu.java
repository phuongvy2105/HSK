
package GUI;

import javax.swing.JFrame;
import java.awt.Color;
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

import DAO.DAO_DichVu;
import DAO.DAO_LoaiDichVu;
import DAO.DAO_Phong;
import Entity.DichVu;
import Entity.LoaiDichVu;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class GUI_DichVu extends JFrame implements ActionListener,MouseListener {
	private JTextField txtMaDV;
	private JTextField txt_TenDV;
	private JTextField txt_Gia;
	private DefaultTableModel model;
	private JTable table;
	private JComboBox cbx_Loai;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLamMoi;

	public GUI_DichVu() {
		setSize(897, 612);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(0, 0, 874, 43);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DỊCH VỤ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(397, 11, 145, 21);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã Dịch Vụ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(33, 88, 149, 27);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tên Dịch Vụ");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(291, 88, 149, 27);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Loại Dịch Vụ");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2.setBounds(33, 154, 149, 27);
		getContentPane().add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Giá");
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_3.setBounds(291, 154, 149, 27);
		getContentPane().add(lblNewLabel_1_3);

		txtMaDV = new JTextField();
		txtMaDV.setBounds(146, 93, 96, 20);
		getContentPane().add(txtMaDV);
		txtMaDV.setColumns(10);

		txt_TenDV = new JTextField();
		txt_TenDV.setBounds(397, 93, 96, 20);
		getContentPane().add(txt_TenDV);
		txt_TenDV.setColumns(10);

		txt_Gia = new JTextField();
		txt_Gia.setBounds(397, 159, 96, 20);
		getContentPane().add(txt_Gia);
		txt_Gia.setColumns(10);

		cbx_Loai = new JComboBox();
		cbx_Loai.setBounds(146, 158, 96, 22);
		getContentPane().add(cbx_Loai);

		String[] head = { "Mã Dịch Vụ", "Tên Dịch Vụ", "Loại Dịch Vụ", "Giá" };
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 333, 854, 220);
		getContentPane().add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(33, 199, 462, 117);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 11, 89, 23);
		panel_1.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(10, 71, 89, 23);
		panel_1.add(btnSua);

		btnXoa = new JButton("Xoá");
		btnXoa.setBounds(134, 11, 89, 23);
		panel_1.add(btnXoa);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBounds(134, 71, 89, 23);
		panel_1.add(btnLamMoi);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("src\\hinh\\DichVu.jpg"));
		lblNewLabel_2.setBounds(516, 54, 348, 268);
		getContentPane().add(lblNewLabel_2);
		doDuLieuTuCollection();
			try {
				duyetComboBox();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}

	private void doDuLieuTuCollection() {
		ArrayList<DichVu> list = new DAO_DichVu().getAllDichVu();
		for (DichVu dto_DichVu : list) {
			model.addRow(new Object[] { dto_DichVu.getMaDichVu(), dto_DichVu.getTenDichVu(),
					dto_DichVu.getLoaiDichVu().getTenLoaiDichVu(), dto_DichVu.getGia()});
		}
	}

	private void duyetComboBox() throws SQLException {
		ArrayList<LoaiDichVu> list = new DAO_LoaiDichVu().getAllLoaiDichVu();
		for (LoaiDichVu dto_LoaiDichVu : list) {
			cbx_Loai.addItem(dto_LoaiDichVu.toString());
		}
	}

	private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	public boolean validData() {
		String maDichVu = txtMaDV.getText();
		String tenDichVu = txt_TenDV.getText();
		String gia = txt_Gia.getText();
		if (maDichVu.equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Dịch Vụ Không Để Trống");
			txtMaDV.requestFocus();
			return false;
		} else if (tenDichVu.equals("")) {
			JOptionPane.showMessageDialog(null, "Tên Dịch Vụ Không Để Trống");
			txt_TenDV.requestFocus();
			return false;
		} else if (gia.equals("")) {
			JOptionPane.showMessageDialog(null, "Giá Không Để Trống");
		} else {
			try {
				float gia1 = Float.parseFloat(gia);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Giá Phải Nhập Số");
				return false;
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			if (validData()) {

				ArrayList<LoaiDichVu> list = new DAO_LoaiDichVu().getAllLoaiDichVu();
				String maDichVu = txtMaDV.getText();
				String tenDichVu = txt_TenDV.getText();
				String gia = txt_Gia.getText();
				float gia1 = Float.parseFloat(gia);
				if (new DAO_DichVu().timDichVu(maDichVu) == null) {
					String loai = cbx_Loai.getSelectedItem().toString();
					String[] maloai =loai.split("-");
					LoaiDichVu loaiDichVu = new DAO_LoaiDichVu().timDichVu(maloai[0]);
					DichVu dichvu = new DichVu(maDichVu, tenDichVu, loaiDichVu, gia1);
					if (new DAO_DichVu().themDichVu(dichvu)) {
						JOptionPane.showMessageDialog(null, "Thêm Thành Công");
						xoaHetDuLieuTrenModel();
						doDuLieuTuCollection();
					} else
						JOptionPane.showMessageDialog(null, "Thêm Thất Bại");

				} else {
					JOptionPane.showMessageDialog(null, "Trùng Loại Dịch Vụ");
				}

			}
		} else if (obj.equals(btnXoa)) {
			int row = table.getSelectedRow();

			ArrayList<DichVu> list = new DAO_DichVu().getAllDichVu();
			String maDichvu = list.get(row).getMaDichVu();
			if (new DAO_DichVu().xoaDichVu(maDichvu)) {
				JOptionPane.showMessageDialog(null, "Xoá Thành Công");
				xoaHetDuLieuTrenModel();
				doDuLieuTuCollection();
			} else {
				JOptionPane.showMessageDialog(null, "Xoá Thất Bại");
			}

		}else if (obj.equals(btnSua)) {
			int r=table.getSelectedRow();
			if(validData()) {
				String maDichVu =txtMaDV.getText();
				if(!model.getValueAt(r, 0).equals(maDichVu)) {
					JOptionPane.showMessageDialog(null, "Không Được Sửa Mã");
				}
				String maLoai=cbx_Loai.getSelectedItem().toString();
				String[] maLoaiDichVu =maLoai.split("-");
				float gia=Float.parseFloat(txt_Gia.getText());
				
				String tenLoaiDichVu=txt_TenDV.getText();
				if(new DAO_DichVu().updateDichVu(maDichVu, tenLoaiDichVu, maLoaiDichVu[0], gia)) {
					JOptionPane.showMessageDialog(null, "Sửa Thành Công");
					xoaHetDuLieuTrenModel();
					doDuLieuTuCollection();
				}else {
					JOptionPane.showMessageDialog(null, "Sửa Thất Bại");
				}
		}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		txtMaDV.setText(model.getValueAt(row, 0).toString());
		txt_TenDV.setText(model.getValueAt(row, 1).toString());
		txt_Gia.setText(model.getValueAt(row, 3).toString());
		
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

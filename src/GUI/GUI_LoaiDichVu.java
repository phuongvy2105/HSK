package GUI;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.DAO_DichVu;
import DAO.DAO_LOAIPHONG;
import DAO.DAO_LoaiDichVu;
import Entity.LoaiDichVu;
import Entity.LoaiPhong;

public class GUI_LoaiDichVu extends JFrame implements ActionListener,MouseListener {
	private JTextField txtLoaiDichVu;
	private JTextField txt_TenDichVu;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;

	public GUI_LoaiDichVu() {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(690, 369);
		setLocationRelativeTo(null);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 675, 40);
		getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel("LOẠI DỊCH VỤ");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel("Mã Loại Dịch Vụ");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 61, 128, 32);
		getContentPane().add(lblNewLabel);

		JLabel lblTnLoiDch = new JLabel("Tên Loại Dịch Vụ");
		lblTnLoiDch.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblTnLoiDch.setBounds(10, 123, 128, 32);
		getContentPane().add(lblTnLoiDch);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 187, 305, 95);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBounds(10, 11, 89, 23);
		panel_1.add(btnThem);

		btnXoa = new JButton("Xoá");
		btnXoa.setBounds(177, 11, 89, 23);
		panel_1.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBounds(10, 61, 89, 23);
		panel_1.add(btnSua);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBounds(177, 61, 89, 23);
		panel_1.add(btnLamMoi);

		String[] head = { "Mã dịch vụ", "Tên Dịch Vụ" };
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(325, 51, 340, 270);
		getContentPane().add(scrollPane);

		txtLoaiDichVu = new JTextField();
		txtLoaiDichVu.setBounds(129, 68, 186, 20);
		getContentPane().add(txtLoaiDichVu);
		txtLoaiDichVu.setColumns(10);

		txt_TenDichVu = new JTextField();
		txt_TenDichVu.setBounds(131, 130, 184, 20);
		getContentPane().add(txt_TenDichVu);
		txt_TenDichVu.setColumns(10);
		btnLamMoi.addActionListener(this);
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		table.addMouseListener(this);
		doDuLieuTuCollection();
	}

	private void doDuLieuTuCollection() {
			ArrayList<LoaiDichVu> list = new DAO_LoaiDichVu().getAllLoaiDichVu();
			for (LoaiDichVu dto_LoaiDichVu : list) {
				model.addRow(new Object[] { dto_LoaiDichVu.getMaLoaiDichVu(), dto_LoaiDichVu.getTenLoaiDichVu()});
			}
	}

	private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	public boolean validData() {
		String maloai = txtLoaiDichVu.getText();
		String loai = txt_TenDichVu.getText();
		if (maloai.equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Loại Dịch Vụ Không Để Trống");
			txtLoaiDichVu.requestFocus();
			return false;
		} else if (maloai.equals("")) {
			JOptionPane.showMessageDialog(null, "Mã Loại Dịch Vụ Không Để Trống");
			txt_TenDichVu.requestFocus();
			return false;
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj.equals(btnThem)) {
			if (validData()) {

				ArrayList<LoaiDichVu> list = new DAO_LoaiDichVu().getAllLoaiDichVu();
				String maloai = txtLoaiDichVu.getText();
				String loai = txt_TenDichVu.getText();
				LoaiDichVu loaidichvu = new LoaiDichVu(maloai, loai);
				if (!list.contains(loaidichvu)) {

					if (new DAO_LoaiDichVu().themLoaiDichVu(loaidichvu)) {
						JOptionPane.showMessageDialog(null, "Thêm Thành công");
						xoaHetDuLieuTrenModel();
						doDuLieuTuCollection();
					} else
						JOptionPane.showMessageDialog(null, "Thêm thất bại");

				} else {
					JOptionPane.showMessageDialog(null, "Trùng Loại Dịch Vụ");
				}

			}
		} else if (obj.equals(btnXoa)) {
			int row = table.getSelectedRow();

			ArrayList<LoaiDichVu> list = new DAO_LoaiDichVu().getAllLoaiDichVu();
			String maLoaiDichu = list.get(row).getMaLoaiDichVu();
			if (new DAO_LoaiDichVu().xoaLoaiDichVu(maLoaiDichu)) {
				JOptionPane.showMessageDialog(null, "Xoá thành công");
				xoaHetDuLieuTrenModel();
				doDuLieuTuCollection();
			} else {
				JOptionPane.showMessageDialog(null, "Xoá thất bại, đã có phòng sử dụng loại dịch vụ này");
			}

		}else if (obj.equals(btnSua)) {
			int r=table.getSelectedRow();
			if(validData()) {
				String maLoaiDichVu =txtLoaiDichVu.getText();
				if(!model.getValueAt(r, 0).equals(maLoaiDichVu)) {
					JOptionPane.showMessageDialog(null, "Không được sửa mã");
				}
				String tenLoai=txt_TenDichVu.getText();
				if(new DAO_LoaiDichVu().updateLoaiDichVu(maLoaiDichVu, tenLoai)) {
					JOptionPane.showMessageDialog(null, "Sửa thành công");
					xoaHetDuLieuTrenModel();
					doDuLieuTuCollection();
				}else {
					JOptionPane.showMessageDialog(null, "Sửa thất bại");
				}
		}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row=table.getSelectedRow();
		txt_TenDichVu.setText(model.getValueAt(row, 1).toString());
		txtLoaiDichVu.setText(model.getValueAt(row, 0).toString());
		
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

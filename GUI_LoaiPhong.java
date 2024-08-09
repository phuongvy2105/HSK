package GUI;

import javax.swing.JFrame;
import java.awt.Color;
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

import Connect.ConnectDB;
import DAO.DAO_LOAIPHONG;
import DAO.DAO_Phong;
import Entity.KhachHang;
import Entity.LoaiPhong;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class GUI_LoaiPhong extends JFrame implements ActionListener,MouseListener {
	private JTextField txt_TenLoaiPhong;
	private JTextField textField;
	private JTextField textField_1;
	private DefaultTableModel model;
	private JTable table;
	private JButton btnSua;
	private JButton btnLamMoi;
	private JButton btnThem;
	private JButton btnXoa;
	private JTextField txt_Gia;
	private JTextField txt_TienNghi;
	private JTextField txtMaLoaiPhong;

	public GUI_LoaiPhong() {
		try {
			ConnectDB.getInstance().connect();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		getContentPane().setBackground(Color.LIGHT_GRAY);
		getContentPane().setLayout(null);
		setSize(883, 481);
		setLocationRelativeTo(null);

		JLabel lblTnLoiPhng = new JLabel("Tên Loại Phòng");
		lblTnLoiPhng.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTnLoiPhng.setBounds(65, 124, 136, 25);
		getContentPane().add(lblTnLoiPhng);

		txt_TenLoaiPhong = new JTextField();
		txt_TenLoaiPhong.setBounds(65, 160, 222, 20);
		getContentPane().add(txt_TenLoaiPhong);
		txt_TenLoaiPhong.setColumns(10);

		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblGi.setBounds(320, 45, 136, 25);
		getContentPane().add(lblGi);

		txt_Gia = new JTextField();
		txt_Gia.setColumns(10);
		txt_Gia.setBounds(320, 78, 222, 20);
		getContentPane().add(txt_Gia);

		JLabel lblTinNghi = new JLabel("Tiện Nghi");
		lblTinNghi.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTinNghi.setBounds(320, 124, 136, 25);
		getContentPane().add(lblTinNghi);

		txt_TienNghi = new JTextField();
		txt_TienNghi.setColumns(10);
		txt_TienNghi.setBounds(320, 160, 222, 20);
		getContentPane().add(txt_TienNghi);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(100, 149, 237));
		panel.setBounds(0, 0, 866, 34);
		getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel("LOẠI PHÒNG");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		panel.add(lblNewLabel_1);

		String[] head = { "Mã Loại","Tên loại", "Giá", "Tiện Nghi" };
		model = new DefaultTableModel(head, 0);
		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 206, 846, 210);
		getContentPane().add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(632, 45, 224, 135);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setBackground(new Color(0, 250, 154));
		btnThem.setBounds(10, 11, 89, 52);
		panel_1.add(btnThem);

		btnXoa = new JButton("Xoá");
		btnXoa.setBackground(new Color(255, 99, 71));
		btnXoa.setBounds(125, 11, 89, 52);
		panel_1.add(btnXoa);

		btnSua = new JButton("Sửa");
		btnSua.setBackground(new Color(147, 112, 219));
		btnSua.setBounds(10, 74, 89, 50);
		panel_1.add(btnSua);

		btnLamMoi = new JButton("Làm Mới");
		btnLamMoi.setBackground(new Color(255, 255, 0));
		btnLamMoi.setBounds(125, 74, 89, 50);
		panel_1.add(btnLamMoi);
		
		JLabel lblTnLoiPhng_1 = new JLabel("Mã Loại Phòng");
		lblTnLoiPhng_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblTnLoiPhng_1.setBounds(65, 51, 136, 25);
		getContentPane().add(lblTnLoiPhng_1);
		
		txtMaLoaiPhong = new JTextField();
		txtMaLoaiPhong.setBounds(65, 78, 222, 20);
		getContentPane().add(txtMaLoaiPhong);
		txtMaLoaiPhong.setColumns(10);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLamMoi.addActionListener(this);
		table.addMouseListener(this);
		doDuLieuTuCollection();
	}

	private void doDuLieuTuCollection() {
		DAO_LOAIPHONG loai=new DAO_LOAIPHONG();
		ArrayList<LoaiPhong> list=new DAO_LOAIPHONG().getAllLoaiPhong();
		for (LoaiPhong dto_LoaiPhong : list) {
			model.addRow(new Object[] {dto_LoaiPhong.getMaLoaiPhong(),dto_LoaiPhong.getTenLoaiPhong(),dto_LoaiPhong.getGia(),dto_LoaiPhong.getTienNghi()});
		}
		
	}

	private boolean validData() {
		String maLoaiphong=txtMaLoaiPhong.getText();
		String tenLoaiPhong = txt_TenLoaiPhong.getText();
		String gia = txt_Gia.getText();
		String tiennghi = txt_TienNghi.getText();
		if(maLoaiphong.equals("")){
			JOptionPane.showMessageDialog(null, "Mã Phòng Không Được rỗng");
			return false;
		}
		else if (tenLoaiPhong.equals("")) {
			JOptionPane.showMessageDialog(null, "Tên Loại Phòng Không Được Rỗng");
			return false;
		} else if (gia.equals("")) {
			JOptionPane.showMessageDialog(null, "Giá Không Được Rỗng");
			return false;
		} else if (tiennghi.equals("")) {
			JOptionPane.showMessageDialog(null, "Tiện Nghi Không Được Rỗng");
			return false;
		} else {
			try {
				double giaa = Double.parseDouble(gia);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Giá Phải Nhập Số");
				return false;
			}
		}
		return true;
	}

	private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) table.getModel();
		dm.getDataVector().removeAllElements();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(btnThem)) {
			if(validData()) {
				
				String maLoaiphong=txtMaLoaiPhong.getText();
				String tenLoaiPhong = txt_TenLoaiPhong.getText();
				float gia =Float.parseFloat(txt_Gia.getText());
				String tiennghi = txt_TienNghi.getText();
				LoaiPhong loai=new LoaiPhong(maLoaiphong, tenLoaiPhong, gia, tiennghi);
				DAO_LOAIPHONG dao=new DAO_LOAIPHONG();
				ArrayList<LoaiPhong> list=new DAO_LOAIPHONG().getAllLoaiPhong();
				if(list.contains(loai)) {
					JOptionPane.showMessageDialog(null, "Trùng loại phòng");
				}else {
				
					if(dao.themLoaiPhong(loai)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công");
						xoaHetDuLieuTrenModel();
						doDuLieuTuCollection();
					}else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại");
					}
				}
				
			}
		}if(obj.equals(btnXoa)) {
			int row=table.getSelectedRow();
			String maLoaiPHong=model.getValueAt(row, 0).toString();
			if(new DAO_LOAIPHONG().xoaPhong(maLoaiPHong)) {
				JOptionPane.showMessageDialog(null,"Xoá thành công");
				xoaHetDuLieuTrenModel();
				doDuLieuTuCollection();
			}else {
				JOptionPane.showMessageDialog(null, "Xoá thất bại, đang có phòng sử dụng loại phòng này");
			}
		}if(obj.equals(btnLamMoi)) {
			txt_Gia.setText("");
			txt_TenLoaiPhong.setText("");
			txtMaLoaiPhong.setText("");
			txt_TienNghi.setText("");
		}if(obj.equals(btnSua)) {
			int r=table.getSelectedRow();
			if(validData()) {
				String maLoaiPhong =txtMaLoaiPhong.getText();
				if(!model.getValueAt(r, 0).equals(maLoaiPhong)) {
					JOptionPane.showMessageDialog(null, "Không được sửa mã");
				}
				String tenLoaiPhong=txt_TenLoaiPhong.getText();
				float gia=Float.parseFloat(txt_Gia.getText());
				String tiennghi=txt_TienNghi.getText();
				if(new DAO_LOAIPHONG().suaLoaiPhong(maLoaiPhong, tenLoaiPhong, gia, tiennghi))  {
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
		txtMaLoaiPhong.setText(model.getValueAt(row, 0).toString());
		txt_TenLoaiPhong.setText(model.getValueAt(row, 1).toString());
		txt_Gia.setText(model.getValueAt(row,2).toString());
		txt_TienNghi.setText(model.getValueAt(row, 3).toString());
		
		
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

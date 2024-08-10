package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import dao.TaiKhoanNV_DAO;
import entity.LoaiNhanVien;
import entity.NhanVien;
import entity.TaiKhoanNV;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUI_QuanLyNhanVien extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private JTextField txtSDT;
	private JTextField txtCMND;
	private JComboBox comboBox;
	private DefaultTableModel modalNhanVien;
	private JTable tableNhanVien;
	private NhanVien_DAO nv_dao;
	private JComboBox cboMaLoai;
	private TaiKhoanNV_DAO tk_dao;

	/**
	 * Create the panel.
	 */
	public GUI_QuanLyNhanVien() {
		try {
			ConnectDB.getInstance().connect();
		}catch (Exception e) {
			e.printStackTrace();
		}
		nv_dao = new NhanVien_DAO();
		setLayout(new BorderLayout(0, 0));
		tk_dao = new TaiKhoanNV_DAO();
		JPanel p = new JPanel();
		add(p, BorderLayout.CENTER);
		p.setLayout(null);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(10, 10, 1509, 340);
		p.add(pTop);
		pTop.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Nhân Viên");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(345, 10, 660, 41);
		pTop.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã NV");
		lblNewLabel_1.setBounds(10, 64, 45, 13);
		pTop.add(lblNewLabel_1);
		
		txtMaNV = new JTextField();
		txtMaNV.setEnabled(false);
		txtMaNV.setBounds(76, 61, 735, 45);
		pTop.add(txtMaNV);
		txtMaNV.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên NV");
		lblNewLabel_2.setBounds(10, 146, 45, 13);
		pTop.add(lblNewLabel_2);
		
		txtTenNV = new JTextField();
		txtTenNV.setBounds(76, 143, 268, 45);
		pTop.add(txtTenNV);
		txtTenNV.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setBounds(438, 143, 77, 13);
		pTop.add(lblNewLabel_3);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(548, 140, 263, 48);
		pTop.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("CMND");
		lblNewLabel_4.setBounds(10, 239, 45, 13);
		pTop.add(lblNewLabel_4);
		
		txtCMND = new JTextField();
		txtCMND.setBounds(76, 236, 268, 45);
		pTop.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Mã loại NV");
		lblNewLabel_5.setBounds(438, 235, 60, 13);
		pTop.add(lblNewLabel_5);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
				phatsinhmakhachhang();
				String ma = txtMaNV.getText();
				String ten = txtTenNV.getText();
				String sdt = txtSDT.getText();
				String cmnd = txtCMND.getText();
				String maloainv = cboMaLoai.getSelectedItem().toString();
				LoaiNhanVien lnv = new LoaiNhanVien(maloainv);
			    NhanVien nv = new NhanVien(ma, ten, sdt, cmnd, lnv);
				if(valid()) {
					String taikhoan = "NV" + cmnd;
					String matkhau = "Quanlybanve"+cmnd;
					TaiKhoanNV tk = new TaiKhoanNV(taikhoan, matkhau);
					tk_dao.themTaiKhoan(tk);
					nv_dao.themNhanVien(nv);
					modalNhanVien.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSoDienThoai(),nv.getCMD(),nv.getMaLoaiNV().getMaLoaiNhanVien()});
					JOptionPane.showMessageDialog(null, "thêm thành công");
				}else{
					JOptionPane.showMessageDialog(null, "thêm không thành công");
				}
				
			}
		});
		btnThem.setBounds(913, 102, 218, 45);
		pTop.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tableNhanVien.getSelectedRow();
				if(row >=0) {
					String manv = (String)tableNhanVien.getValueAt(row, 0);
					int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa nhân viên này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
			        if(option == JOptionPane.YES_OPTION) {
			            if(nv_dao.xoaNhanVien(manv)) {
			                modalNhanVien.removeRow(row);
			                JOptionPane.showMessageDialog(null, "xóa thành công nhân viên");
			                xoaRong();
			            }
			        }
				}else {
					JOptionPane.showMessageDialog(null, "chọn dòng cần xóa");
				}
				
			}
		});
		btnXoa.setBounds(1243, 101, 218, 46);
		pTop.add(btnXoa);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaRong();
				
			}
		});
		btnXoaTrang.setBounds(913, 179, 218, 45);
		pTop.add(btnXoaTrang);
		
		JButton btncapnhat = new JButton("Cập Nhật");
		btncapnhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tableNhanVien.getSelectedRow();
				if(row >=0) {
					NhanVien nv = reverSPformtextfield();
					if(valid()) {
					if(nv_dao.capNhatNhanVien(nv)) {
						tableNhanVien.setValueAt(txtTenNV.getText(), row, 1);
						tableNhanVien.setValueAt(txtSDT.getText(), row,2);
						tableNhanVien.setValueAt(txtCMND.getText(), row, 3);
						tableNhanVien.setValueAt(cboMaLoai.getSelectedItem(), row, 4);
						JOptionPane.showMessageDialog(null, "cập nhật thành công");
						xoaRong();
					}}
				}else {
					JOptionPane.showMessageDialog(null, "chọn nhân viên cần cập nhật");
				}
			}
		});
		btncapnhat.setBounds(1243, 179, 218, 45);
		pTop.add(btncapnhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(913, 253, 218, 45);
		pTop.add(btnLuu);
		
		 comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(1166, 36, 295, 46);
		pTop.add(comboBox);
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String manv = (String) comboBox.getSelectedItem();
			if(manv != null) {
				NhanVien nv = nv_dao.timNhanVien(manv);
				modalNhanVien.setRowCount(0);
				if(nv !=null) {
					txtMaNV.setText(nv.getMaNhanVien());
	                txtTenNV.setText(nv.getTenNhanVien());
	                txtSDT.setText(nv.getSoDienThoai());
	                txtCMND.setText(nv.getCMD());
	                cboMaLoai.setSelectedItem(nv.getMaLoaiNV().getMaLoaiNhanVien());
	                modalNhanVien.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSoDienThoai(),nv.getCMD(),nv.getMaLoaiNV().getMaLoaiNhanVien()});
				}
				
			}
			
			
			
			}
		});
		btnTim.setBounds(913, 32, 218, 46);
		pTop.add(btnTim);
		
		 cboMaLoai = new JComboBox();
		 cboMaLoai.setEditable(true);
		cboMaLoai.setBounds(548, 231, 263, 50);
		pTop.add(cboMaLoai);
		
		JPanel pBottom = new JPanel();
		pBottom.setBounds(10, 360, 1509, 288);
		p.add(pBottom);
		pBottom.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1474, 265);
		pBottom.add(scrollPane);
		
		String[] header = {"Mã NV","Tên NV", "Số điện thoại","CMND","Mã loại NV"};
		modalNhanVien = new DefaultTableModel(header,0);
		tableNhanVien = new JTable(modalNhanVien);
		scrollPane.setViewportView(tableNhanVien);
		updatecombobox();
		docdulieuvaoTable();
		tableNhanVien.addMouseListener(this);

	}
	
	private boolean valid() {
		String ten = txtTenNV.getText();
		String regten = "^[A-Z][a-z]*(\s[A-Z][a-z]*)*";
		if(ten == null || ten.equals("")) {
			JOptionPane.showMessageDialog(this, "tên không rỗng");
			txtTenNV.requestFocus();
			return false;
		}else if(!ten.matches(regten)) {
			JOptionPane.showMessageDialog(this, "tên phải bắt đầu bằng chữ hoa");
			txtTenNV.requestFocus();
			return false;
		}
		
		String sdt = txtSDT.getText();
		String regsdt = "^(0)[0-9]+";
		if(sdt == null || sdt.equals("")) {
			JOptionPane.showMessageDialog(this, "sdt không rỗng");
			txtSDT.requestFocus();
			return false;
		}else if(!sdt.matches(regsdt) || sdt.length() != 10) {
			txtSDT.requestFocus();
			JOptionPane.showMessageDialog(this, "sdt phải bắt đầu bằng 0 và gồm 10 chữ số");
			return false;
		}
		
		String cmnd = txtCMND.getText();
		String regcmnd = "[0-9]+";
		if(cmnd == null || cmnd.equals("")) {
			JOptionPane.showMessageDialog(this, "địa chỉ không rỗng");
			txtCMND.requestFocus();
			return false;
		}else if(!cmnd.matches(regcmnd) || cmnd.length() != 8) {
			txtCMND.requestFocus();
			JOptionPane.showMessageDialog(this, "cmnd phải là số và gồm 8 chữ số");
			return false;
		}
		
		

		return true;
	}
	private NhanVien reverSPformtextfield() {
		String ma = txtMaNV.getText();
		String ten = txtTenNV.getText();
		String sdt = txtSDT.getText();
		String cmnd = txtCMND.getText();
		String maloainv =cboMaLoai.getSelectedItem().toString();
		LoaiNhanVien lnv = new LoaiNhanVien(maloainv);
		
	    return new NhanVien(ma, ten, sdt, cmnd, lnv);
	}
	
	public void phatsinhmakhachhang() {
		String cmnd = txtCMND.getText().trim();
		if(!cmnd.equalsIgnoreCase("")) {
			String manv = "NV" + cmnd;
			txtMaNV.setText(manv);
		}
	}
	
	public void docdulieuvaoTable() {
		List<NhanVien> list = nv_dao.getallTBNhanVien();
		for(NhanVien nv: list) {
			modalNhanVien.addRow(new Object[] {nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getSoDienThoai(),nv.getCMD(),nv.getMaLoaiNV().getMaLoaiNhanVien()});
		}
		tableNhanVien.setModel(modalNhanVien);
	}
	public void updatecombobox() {
		ArrayList<NhanVien> listnv = nv_dao.getallTBNhanVien();
		for(NhanVien nv: listnv) {
			comboBox.addItem(nv.getMaNhanVien());
			cboMaLoai.addItem(nv.getMaLoaiNV().getMaLoaiNhanVien());
			
		}
		
	}
	public void xoaRong() {
		txtMaNV.setText("");
		txtTenNV.setText("");
		txtSDT.setText("");
		txtCMND.setText("");
		cboMaLoai.setSelectedItem(0);
		txtTenNV.requestFocus();
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setText(tableNhanVien.getValueAt(row, 0).toString());
		txtTenNV.setText(tableNhanVien.getValueAt(row, 1).toString());
		txtSDT.setText(tableNhanVien.getValueAt(row, 2).toString());
		txtCMND.setText(tableNhanVien.getValueAt(row, 3).toString());
		cboMaLoai.setSelectedItem(tableNhanVien.getValueAt(row, 4).toString());
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

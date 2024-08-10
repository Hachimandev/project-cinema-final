package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;

public class GUI_QuanLyKhachHang extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modalKhachHang;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JTable tableKhachHang;
	private KhachHang_DAO kh_dao;
	private JComboBox comboBox;

	/**
	 * Create the panel.
	 */
	public GUI_QuanLyKhachHang() {
		try {
			ConnectDB.getInstance().connect();
		}catch (Exception e) {
			e.printStackTrace();
		}
		kh_dao = new KhachHang_DAO();
		setLayout(new BorderLayout(0, 0));
		
		JPanel p = new JPanel();
		add(p, BorderLayout.CENTER);
		p.setLayout(null);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(41, 25, 1476, 231);
		p.add(pTop);
		pTop.setLayout(null);
		
		JPanel pBottom = new JPanel();
		pBottom.setBounds(41, 300, 1476, 310);
		p.add(pBottom);
		pBottom.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quản Lý Khách Hàng");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setBounds(347, 10, 354, 39);
		pTop.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Mã KH");
		lblNewLabel_1.setBounds(10, 64, 45, 13);
		pTop.add(lblNewLabel_1);
		
		txtMaKH = new JTextField();
		txtMaKH.setEnabled(false);
		txtMaKH.setBounds(76, 61, 736, 34);
		pTop.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên KH");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_2.setBounds(10, 124, 45, 13);
		pTop.add(lblNewLabel_2);
		
		txtTenKH = new JTextField();
		txtTenKH.setBounds(76, 114, 268, 34);
		pTop.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_3.setBounds(461, 124, 77, 13);
		pTop.add(lblNewLabel_3);
		
		txtSDT = new JTextField();
		txtSDT.setBounds(548, 117, 264, 34);
		pTop.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setBounds(10, 197, 45, 13);
		pTop.add(lblNewLabel_4);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(76, 186, 268, 35);
		pTop.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày sinh");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_5.setBounds(461, 197, 60, 13);
		pTop.add(lblNewLabel_5);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setBounds(548, 184, 264, 34);
		pTop.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				phatsinhmakhachhang();
				String ma = txtMaKH.getText();
				String ten = txtTenKH.getText();
				String sdt = txtSDT.getText();
				String diachi = txtDiaChi.getText();
				String ngaysinh = txtNgaySinh.getText();
				LocalDate ngaySinh = null;
			    try {
			            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			            ngaySinh = LocalDate.parse(ngaysinh, formatter);
			    }catch (DateTimeParseException ex) {
			            ex.printStackTrace();
			        }
			    KhachHang kh = new KhachHang(ma, ten, sdt, diachi, ngaySinh);
				if(valid()) {
					kh_dao.themKhachHang(kh);
					modalKhachHang.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSoDienThoai(),kh.getDiaChi(),kh.getNgaySinh()});
					JOptionPane.showMessageDialog(null, "thêm thành công");
				}else{
					JOptionPane.showMessageDialog(null, "thêm không thành công");
				}
				
			}
		});
		btnThem.setBounds(972, 67, 184, 41);
		pTop.add(btnThem);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tableKhachHang.getSelectedRow();
				if(row >=0) {
					String makh = (String)tableKhachHang.getValueAt(row, 0);
					int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa khách hàng này?", "Xác nhận xóa", JOptionPane.YES_NO_OPTION);
			        if(option == JOptionPane.YES_OPTION) {
			            if(kh_dao.xoaKhachHang(makh)) {
			                modalKhachHang.removeRow(row);
			                JOptionPane.showMessageDialog(null, "xóa thành công khách hàng");
			                xoaRong();
			            }
			        }
				}else {
					JOptionPane.showMessageDialog(null, "chọn dòng cần xóa");
				}
				
			}
		});
		btnXoa.setBounds(972, 122, 184, 41);
		pTop.add(btnXoa);
		
		JButton btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaRong();
				
			}
		});
		btnXoaTrang.setBounds(1194, 67, 239, 41);
		pTop.add(btnXoaTrang);
		
		JButton btncapnhat = new JButton("Cập Nhật");
		btncapnhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = tableKhachHang.getSelectedRow();
				if(row >=0) {
					KhachHang kh = reverSPformtextfield();
					if(valid()) {
					if(kh_dao.capNhatKhachHang(kh)) {
						tableKhachHang.setValueAt(txtTenKH.getText(), row, 1);
						tableKhachHang.setValueAt(txtSDT.getText(), row,2);
						tableKhachHang.setValueAt(txtDiaChi.getText(), row, 3);
						tableKhachHang.setValueAt(txtNgaySinh.getText(), row, 4);
						JOptionPane.showMessageDialog(null, "cập nhật thành công");
						xoaRong();
					}}
				}else {
					JOptionPane.showMessageDialog(null, "chọn khách hàng cần cập nhật");
				}
			}
		});
		btncapnhat.setBounds(1194, 122, 239, 41);
		pTop.add(btncapnhat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setBounds(972, 186, 184, 35);
		pTop.add(btnLuu);
		
		 comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(1194, 10, 253, 42);
		pTop.add(comboBox);
		JButton btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			String makh = (String) comboBox.getSelectedItem();
			if(makh != null) {
				KhachHang kh = kh_dao.timKhachHang(makh);
				modalKhachHang.setRowCount(0);
				if(kh !=null) {
					txtMaKH.setText(kh.getMaKhachHang());
	                txtTenKH.setText(kh.getTenKhachHang());
	                txtSDT.setText(kh.getSoDienThoai());
	                txtDiaChi.setText(kh.getDiaChi());
	                txtNgaySinh.setText(kh.getNgaySinh().toString());
	                modalKhachHang.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSoDienThoai(),kh.getDiaChi(),kh.getNgaySinh()});
				}
				
			}
			
			
			
			}
		});
		btnTim.setBounds(972, 10, 184, 42);
		pTop.add(btnTim);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1456, 290);
		pBottom.add(scrollPane);
		
		String[] header = {"Mã KH","Tên KH", "Số điện thoại","Địa chỉ","Ngày sinh"};
		modalKhachHang = new DefaultTableModel(header,0);
		tableKhachHang = new JTable(modalKhachHang);
		scrollPane.setViewportView(tableKhachHang);
		updatecombobox();
		docdulieuvaoTable();
		tableKhachHang.addMouseListener(this);

	}
	
	private boolean valid() {
		String ten = txtTenKH.getText();
		String regten = "^[A-Z][a-z]*(\s[A-Z][a-z]*)*";
		if(ten == null || ten.equals("")) {
			JOptionPane.showMessageDialog(this, "tên không rỗng");
			txtTenKH.requestFocus();
			return false;
		}else if(!ten.matches(regten)) {
			JOptionPane.showMessageDialog(this, "tên phải bắt đầu bằng chữ hoa");
			txtTenKH.requestFocus();
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
		
		String diachi = txtDiaChi.getText();
		if(diachi == null || diachi.equals("")) {
			JOptionPane.showMessageDialog(this, "địa chỉ không rỗng");
			txtDiaChi.requestFocus();
			return false;
		}
		
		String ngaysinh = txtNgaySinh.getText();
		String regNgaySinh = "\\d{4}-\\d{2}-\\d{2}";
		String regNam = "\\d{4}";
		String regThang = "\\d{2}";
		String regNgay = "\\d{2}";

		if(ngaysinh == null || ngaysinh.equals("")) {
		    JOptionPane.showMessageDialog(this, "Ngày sinh không được rỗng");
		    txtNgaySinh.requestFocus();
		    return false;
		} else if(!ngaysinh.matches(regNgaySinh)) {
		    JOptionPane.showMessageDialog(this, "Ngày sinh không đúng định dạng YYYY-MM-DD");
		    txtNgaySinh.requestFocus();
		    return false;
		}

		String nam = ngaysinh.substring(0, 4);
		String thang = ngaysinh.substring(5, 7);
		String ngay = ngaysinh.substring(8, 10);

		if(!nam.matches(regNam)) {
		    JOptionPane.showMessageDialog(this, "Năm không đúng định dạng (YYYY)");
		    txtNgaySinh.requestFocus();
		    return false;
		} else {
		    int namInt = Integer.parseInt(nam);
		    if (namInt < 1900 || namInt > 2100) {
		        JOptionPane.showMessageDialog(this, "Năm không hợp lệ (1900-2100)");
		        txtNgaySinh.requestFocus();
		        return false;
		    }
		}

		if(!thang.matches(regThang)) {
		    JOptionPane.showMessageDialog(this, "Tháng không đúng định dạng (MM)");
		    txtNgaySinh.requestFocus();
		    return false;
		} else {
		    int thangInt = Integer.parseInt(thang);
		    if (thangInt < 1 || thangInt > 12) {
		        JOptionPane.showMessageDialog(this, "Tháng không hợp lệ (1-12)");
		        txtNgaySinh.requestFocus();
		        return false;
		    }
		}

		if(!ngay.matches(regNgay)) {
		    JOptionPane.showMessageDialog(this, "Ngày không đúng định dạng (DD)");
		    txtNgaySinh.requestFocus();
		    return false;
		} else {
		    int ngayInt = Integer.parseInt(ngay);
		    int thangInt = Integer.parseInt(thang);
		    int namInt = Integer.parseInt(nam);
		    boolean isLeapYear = (namInt % 4 == 0 && namInt % 100 != 0) || (namInt % 400 == 0);
		    if ((thangInt == 1 || thangInt == 3 || thangInt == 5 || thangInt == 7 || thangInt == 8 || thangInt == 10 || thangInt == 12) && (ngayInt < 1 || ngayInt > 31)) {
		        JOptionPane.showMessageDialog(this, "Tháng này chỉ có từ 1 đến 31 ngày");
		        txtNgaySinh.requestFocus();
		        return false;
		    } else if ((thangInt == 4 || thangInt == 6 || thangInt == 9 || thangInt == 11) && (ngayInt < 1 || ngayInt > 30)) {
		        JOptionPane.showMessageDialog(this, "Tháng này chỉ có từ 1 đến 30 ngày");
		        txtNgaySinh.requestFocus();
		        return false;
		    } else if (thangInt == 2 && isLeapYear && (ngayInt < 1 || ngayInt > 29)) {
		        JOptionPane.showMessageDialog(this, "Tháng 2 trong năm nhuận chỉ có từ 1 đến 29 ngày");
		        txtNgaySinh.requestFocus();
		        return false;
		    } else if (thangInt == 2 && !isLeapYear && (ngayInt < 1 || ngayInt > 28)) {
		        JOptionPane.showMessageDialog(this, "Tháng 2 trong năm không nhuận chỉ có từ 1 đến 28 ngày");
		        txtNgaySinh.requestFocus();
		        return false;
		    }
		}

		return true;
	}
	private KhachHang reverSPformtextfield() {
		String ma = txtMaKH.getText();
		String ten = txtTenKH.getText();
		String sdt = txtSDT.getText();
		String diachi = txtDiaChi.getText();
		String ngaysinh = txtNgaySinh.getText();
		LocalDate ngaySinh = null;
	    try {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            ngaySinh = LocalDate.parse(ngaysinh, formatter);
	    }catch (DateTimeParseException ex) {
	            ex.printStackTrace();
	        }
	    return new KhachHang(ma, ten, sdt, diachi, ngaySinh);
	}
	
	public void phatsinhmakhachhang() {
		String sdt = txtSDT.getText().trim();
		if(!sdt.equalsIgnoreCase("")) {
			String makh = "KH" + sdt;
			txtMaKH.setText(makh);
		}
	}
	
	public void docdulieuvaoTable() {
		List<KhachHang> list = kh_dao.getDsKhachHang();
		for(KhachHang kh: list) {
			modalKhachHang.addRow(new Object[] {kh.getMaKhachHang(),kh.getTenKhachHang(),kh.getSoDienThoai(),kh.getDiaChi(),kh.getNgaySinh()});
		}
		tableKhachHang.setModel(modalKhachHang);
	}
	public void updatecombobox() {
		ArrayList<KhachHang> listkh = kh_dao.getDsKhachHang();
		for(KhachHang kh: listkh) {
			comboBox.addItem(kh.getMaKhachHang());
		}
		
	}
	public void xoaRong() {
		txtMaKH.setText("");
		txtTenKH.setText("");
		txtSDT.setText("");
		txtDiaChi.setText("");
		txtNgaySinh.setText("");
		txtTenKH.requestFocus();
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableKhachHang.getSelectedRow();
		txtMaKH.setText(tableKhachHang.getValueAt(row, 0).toString());
		txtTenKH.setText(tableKhachHang.getValueAt(row, 1).toString());
		txtSDT.setText(tableKhachHang.getValueAt(row, 2).toString());
		txtDiaChi.setText(tableKhachHang.getValueAt(row, 3).toString());
		txtNgaySinh.setText(tableKhachHang.getValueAt(row, 4).toString());
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

package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import dao.DangChieu_DAO;
import dao.LoaiPhim_DAO;
import dao.Phim_DAO;
import entity.DangChieu;
import entity.LoaiPhim;
import entity.Phim;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;

public class GUI_QuanLyPhim extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhim;
	private JTextField txtTenPhim;
	private JTextField txtGiaPhim;
	private JTable table;
	private JTextField timField;
	private DefaultTableModel modelPhim;
	private JComboBox cbLoaiPhim;
	private JComboBox cbDangChieu;
	private Phim_DAO phimDao=new Phim_DAO();;
	private ArrayList<Phim> dsPhim;
	private JButton btnXoaTrang;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnLuu;
	private JButton btnTim;

	/**
	 * Create the panel.
	 */	
	public GUI_QuanLyPhim() {
		cbDangChieu = new JComboBox();
		cbLoaiPhim = new JComboBox();
		
		String headCollum[]=new String[] {
				"Mã Phim", "Tên Phim", "Giá Phim", "Dạng Chiếu", "Loại Phim"
			};
		modelPhim=new DefaultTableModel(headCollum,0);
		uploadDataVaoBang();
		loaiLoaiPhim();
		loadDangChieu();
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblNewLabel = new JLabel("Quản Lý Phim");
		panel_3.add(lblNewLabel, BorderLayout.CENTER);
		lblNewLabel.setForeground(new Color(30, 144, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_4 = new JPanel();
		add(panel_4);
		panel_4.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Nh\u1EADp D\u1EEF Li\u1EC7u", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_5.add(panel);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setLayout(null);
		
		txtMaPhim = new JTextField();
		txtMaPhim.setBounds(106, 6, 186, 36);
		panel.add(txtMaPhim);
		txtMaPhim.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaPhim.setEditable(false);
		txtMaPhim.setColumns(10);
		
		
		JLabel lblNewLabel_1 = new JLabel("Mã Phim");
		lblNewLabel_1.setBounds(10, 11, 60, 13);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txtTenPhim = new JTextField();
		txtTenPhim.setBounds(106, 52, 186, 32);
		panel.add(txtTenPhim);
		txtTenPhim.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Tên Phim");
		lblNewLabel_2.setBounds(10, 54, 60, 13);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JLabel lblNewLabel_3 = new JLabel("Giá Phim");
		lblNewLabel_3.setBounds(10, 96, 60, 13);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		txtGiaPhim = new JTextField();
		txtGiaPhim.setBounds(106, 94, 186, 31);
		panel.add(txtGiaPhim);
		txtGiaPhim.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Loại Phim");
		lblNewLabel_4.setBounds(10, 135, 75, 23);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbLoaiPhim = new JComboBox();
		cbLoaiPhim.setBounds(106, 135, 186, 33);
		panel.add(cbLoaiPhim);
		
		loaiLoaiPhim();
		
		cbDangChieu = new JComboBox();
		cbDangChieu.setBounds(106, 178, 186, 28);
		panel.add(cbDangChieu);
		cbDangChieu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		txtMaPhim.setText(phatSinhMaPhim());
		
		loadDangChieu();
		
		JLabel lblNewLabel_5 = new JLabel("Dạng Chiếu");
		lblNewLabel_5.setBounds(10, 185, 75, 15);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Thao T\u00E1c", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel_4.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_6.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setBounds(33, 108, 143, 36);
		panel_1.add(btnXoa);
		btnXoa.addActionListener(this);
		
		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(219, 29, 143, 36);
		panel_1.add(btnXoaTrang);
		btnXoaTrang.addActionListener(this);
		
		btnLuu = new JButton("Lưu");
		btnLuu.setBounds(219, 108, 143, 36);
		panel_1.add(btnLuu);
		btnLuu.addActionListener(this);
		
		btnThem = new JButton("Thêm");
		panel_1.add(btnThem);
		btnThem.setBounds(33, 30, 143, 34);
		btnThem.addActionListener(this);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "T\u00ECm Phim", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_7.add(panel_2, BorderLayout.CENTER);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setLayout(null);
		
		timField = new JTextField();
		timField.setBounds(88, 42, 169, 34);
		panel_2.add(timField);
		timField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Tìm mã phim:");
		lblNewLabel_6.setBounds(10, 41, 78, 34);
		panel_2.add(lblNewLabel_6);
		
		btnTim = new JButton("Tìm");
		btnTim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String maPhim = timField.getText();
				Phim phim = phimDao.timPhim(maPhim);
				if(phim!=null) {
					txtMaPhim.setText(phim.getMaPhim());
					txtTenPhim.setText(phim.getTenPhim());
					txtGiaPhim.setText(String.valueOf(phim.getGiaPhim()));
					cbLoaiPhim.setSelectedItem(phim.getMaLoaiPhim().getMaLoaiPhim());
					cbDangChieu.setSelectedItem(phim.getMaDangChieu().getMaDangChieu());
				}else {
					JOptionPane.showMessageDialog(null,"Không tìm thấy phim");
				}
				
			}
		});
		btnTim.setHorizontalAlignment(SwingConstants.LEFT);
		btnTim.setBounds(88, 99, 169, 34);
		panel_2.add(btnTim);
		
		JPanel panel_8 = new JPanel();
		add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_8.add(scrollPane_1, BorderLayout.CENTER);
		table = new JTable(modelPhim);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				txtMaPhim.setText(table.getValueAt(row, 0).toString());
				txtTenPhim.setText(table.getValueAt(row, 1).toString());
				txtGiaPhim.setText(table.getValueAt(row, 2).toString());
				cbDangChieu.setSelectedItem(table.getValueAt(row, 3).toString());
				cbLoaiPhim.setSelectedItem(table.getValueAt(row, 4).toString());
			}
		});
		table.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		scrollPane_1.setViewportView(table);


	}
	private void uploadDataVaoBang() {
		dsPhim = phimDao.getalltbPhim();
		for (Phim phim : dsPhim) {
	        String maPhim = phim.getMaPhim();
	        String tenPhim = phim.getTenPhim();
	        Double giaPhim = phim.getGiaPhim();
	        LoaiPhim tenLoaiPhim = phim.getMaLoaiPhim(); // Giả sử có phương thức getTenTheLoai() trong LoaiPhim
	        DangChieu tenDangChieu = phim.getMaDangChieu(); // Giả sử có phương thức getTenDangChieu() trong DangChieu

	        // Thêm hàng mới vào modelPhim
	        modelPhim.addRow(new Object[]{maPhim, tenPhim, giaPhim, tenDangChieu.getMaDangChieu(),tenLoaiPhim.getMaLoaiPhim()});
	    }
		
	}
	private String phatSinhMaPhim() {
        String maPhimCuoi = phimDao.layMaPhimCuoiCung();
        if (maPhimCuoi != null && !maPhimCuoi.isEmpty()) {
            String sttString = maPhimCuoi.substring(1);
            int sttInt = Integer.parseInt(sttString);
            int newSttInt = sttInt + 1;
            return "P" +String.format("%01d", newSttInt);
        } else {
            return "P01"; // Default Ma Phim if no records found
        }
    }


	private void loadDangChieu() {
		DangChieu_DAO dcDao = new DangChieu_DAO();
		ArrayList<DangChieu> dsDanhChieu = dcDao.getalltbDangChieu();
		for (int i = 0; i < dsDanhChieu.size(); i++) {
			cbDangChieu.addItem(dsDanhChieu.get(i).getMaDangChieu());
			
		}
		
	}

	private void loaiLoaiPhim() {
		LoaiPhim_DAO loaiPhim_Dao = new LoaiPhim_DAO();
		ArrayList<LoaiPhim> dsLoaiPhim = loaiPhim_Dao.getalltbLoaiPhim();
		for (int i = 0; i < dsLoaiPhim.size(); i++) {
			cbLoaiPhim.addItem(dsLoaiPhim.get(i).getMaLoaiPhim());
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object s = e.getSource();
		if(s.equals(btnThem)) {
					if(kiemtradulieu()) {
						phimDao = new Phim_DAO();
				 		String maPhim = txtMaPhim.getText();
				 	    String tenPhim = txtTenPhim.getText();
				 	    double giaPhim = Double.parseDouble(txtGiaPhim.getText());
						String maLoaiPhim = cbLoaiPhim.getSelectedItem().toString();
						String maDangChieu = cbDangChieu.getSelectedItem().toString();
						LoaiPhim loaiPhim = new LoaiPhim(maLoaiPhim);
						DangChieu dangChieu = new DangChieu(maDangChieu);
						Phim phim = new Phim(maPhim, tenPhim, giaPhim, loaiPhim, dangChieu);
						 modelPhim.addRow(new Object[]{maPhim, tenPhim, giaPhim, maDangChieu, maLoaiPhim});
						if(phimDao.themPhim(phim)) {
							JOptionPane.showMessageDialog(null,"Thêm phim thành công");
							 modelPhim.addRow(new Object[]{maPhim, tenPhim, giaPhim, maDangChieu, maLoaiPhim});
						}else {
							JOptionPane.showMessageDialog(null,"Thêm phim thất bại");
						}
				 	}
			}else if(s.equals(btnXoaTrang)) {
				txtMaPhim.setText(phatSinhMaPhim());
				txtTenPhim.setText("");
				txtGiaPhim.setText("");
				cbLoaiPhim.setSelectedIndex(0);
				cbDangChieu.setSelectedIndex(0);
			}else if(s.equals(btnXoa)) {
				int row = table.getSelectedRow();
				if(row>=0) {
					String maPhim = table.getValueAt(row, 0).toString();
					if(phimDao.XoaPhim(maPhim)) {
						modelPhim.removeRow(row);
						JOptionPane.showMessageDialog(null,"Xóa phim thành công");
					}else {
						JOptionPane.showMessageDialog(null,"Xóa phim thất bại");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Chọn phim cần xóa");
				}
			}else if(s.equals(btnLuu)) {
				int row = table.getSelectedRow();
				if(row>=0) {
					String maPhim = txtMaPhim.getText();
					String tenPhim = txtTenPhim.getText();
					double giaPhim = Double.parseDouble(txtGiaPhim.getText());
					String maLoaiPhim = cbLoaiPhim.getSelectedItem().toString();
					String maDangChieu = cbDangChieu.getSelectedItem().toString();
					LoaiPhim loaiPhim = new LoaiPhim(maLoaiPhim);
					DangChieu dangChieu = new DangChieu(maDangChieu);
					Phim phim = new Phim(maPhim, tenPhim, giaPhim, loaiPhim, dangChieu);
					if(phimDao.suaPhim(phim)) {
						modelPhim.setValueAt(maPhim, row, 0);
						modelPhim.setValueAt(tenPhim, row, 1);
						modelPhim.setValueAt(giaPhim, row, 2);
						modelPhim.setValueAt(maDangChieu, row, 3);
						modelPhim.setValueAt(maLoaiPhim, row, 4);
						JOptionPane.showMessageDialog(null,"Sửa phim thành công");
						modelPhim.removeRow(row);
						modelPhim.addRow(new Object[]{txtMaPhim.getText(), txtTenPhim.getText(), txtGiaPhim.getText(), cbDangChieu.getSelectedItem(), cbLoaiPhim.getSelectedItem()});
					}else {
						JOptionPane.showMessageDialog(null,"Sửa phim thất bại");
					}
				}else {
					JOptionPane.showMessageDialog(null,"Chọn phim cần sửa");
				}
				
			}
	}

	private boolean kiemtradulieu() {
		if(txtTenPhim.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Tên phim không được để trống");
			txtTenPhim.requestFocus();
			return false;
		}
		if(txtGiaPhim.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Giá phim không được để trống");
			txtGiaPhim.requestFocus();
			return false;
		}
		try {
			Double.parseDouble(txtGiaPhim.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Giá phim phải là số");
			txtGiaPhim.requestFocus();
			return false;
		}
		return true;
	}
}

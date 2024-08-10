package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.VePhim_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.VePhim;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.MessageFormat;
import java.text.NumberFormat;
import javax.swing.border.LineBorder;

public class GUI_TaoHoaDon extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtNgayHienHanh;
	private JTextField txtMaHoaDon;
	private JButton btnTimVePhim;
	private JTextField txtTenPhim;
	private JTextField lichChieu;
	private JTextField txtGhe;
	private JTextField txtLoaiVe;
	private JTextField txtNgayLapHoaDon;
	private JButton btnThem;
	private JTextField txtMaNhanVien;
	private JButton btnTimKhachHang;
	private JTextField txtTenKhachHang;
	private JTextField txtSoDienThoai;
	private JTextField txtDiaChi;
	private JTextField txtNgaySinh;
	private JTable table;
	private DefaultTableModel modalHoaDon;
	private JTextField txtTongTien;
	private JTextField txtTienKhachTra;
	private JButton btnTienThua;
	private HoaDon_DAO hd = new HoaDon_DAO();
	@SuppressWarnings("rawtypes")
	private DefaultComboBoxModel modalCBVePhim;
	private VePhim_DAO vePhim = new VePhim_DAO();
	private JComboBox cbVePhim;
	private DefaultComboBoxModel modalCBKhachHang;
	private KhachHang_DAO kh = new KhachHang_DAO();
	private JComboBox cbKhachHang;
	private JButton btnXoaTrang;
	private ChiTietHoaDon_DAO cthdDao = new ChiTietHoaDon_DAO();
	private JSpinner spinnerSL;
	private JButton btnThemHoaDon;
	private ArrayList dsChiTietHoaDonCanThem = new ArrayList<>();;
	private double tongTien = 0;
	private NhanVien_DAO nv = new NhanVien_DAO();
	private NumberFormat moneyFomat = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
	private JButton btnThanhToan;

	/**
	 * Create the panel.
	 */
	public GUI_TaoHoaDon(NhanVien nv) {
		setLayout(null);
		JPanel panel = new JPanel();
		panel.setBounds(328, 10, 456, 81);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Tạo Hóa Đơn");
		lblNewLabel.setBounds(182, 21, 158, 32);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel panelIcon = new JPanel();
		panelIcon.setBounds(10, 10, 319, 81);
		add(panelIcon);
		panelIcon.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(794, 10, 736, 81);
		add(panel_2);
		panel_2.setLayout(null);

		txtNgayHienHanh = new JTextField();
		txtNgayHienHanh.setEditable(false);
		txtNgayHienHanh.setBounds(109, 27, 96, 31);
		panel_2.add(txtNgayHienHanh);
		txtNgayHienHanh.setColumns(10);
		txtNgayHienHanh.setText(layNgayHienHanh());

		JLabel lblNewLabel_1 = new JLabel("Ngày hiện hành");
		lblNewLabel_1.setBounds(10, 27, 89, 19);
		panel_2.add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 93, 1520, 270);
		panel_1.setBorder(new TitledBorder(null, "Th\u00F4ng tin h\u00F3a \u0111\u01A1n", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 255)));
		add(panel_1);
		panel_1.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_3.setBounds(10, 20, 519, 240);
		panel_1.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Mã hóa đơn");
		lblNewLabel_2.setBounds(10, 10, 68, 13);
		panel_3.add(lblNewLabel_2);

		txtMaHoaDon = new JTextField();
		txtMaHoaDon.setEditable(false);
		txtMaHoaDon.setBounds(75, 7, 193, 36);
		panel_3.add(txtMaHoaDon);
		txtMaHoaDon.setColumns(10);
		txtMaHoaDon.setText(phatSinhMaHoaDon());

		JLabel lblNewLabel_3 = new JLabel("Mã Vé");
		lblNewLabel_3.setBounds(10, 63, 55, 13);
		panel_3.add(lblNewLabel_3);

		btnTimVePhim = new JButton("Tìm");
		btnTimVePhim.setBounds(75, 101, 93, 36);
		panel_3.add(btnTimVePhim);

		modalCBVePhim = new DefaultComboBoxModel<>();

		cbVePhim = new JComboBox(modalCBVePhim);
		cbVePhim.setBounds(75, 56, 193, 35);
		panel_3.add(cbVePhim);
		loadDuLieuVePhim();

		JLabel lblNewLabel_4 = new JLabel("Số Lượng");
		lblNewLabel_4.setBounds(10, 150, 55, 13);
		panel_3.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Tên Phim");
		lblNewLabel_5.setBounds(10, 195, 55, 13);
		panel_3.add(lblNewLabel_5);

		txtTenPhim = new JTextField();
		txtTenPhim.setEditable(false);
		txtTenPhim.setBounds(76, 192, 192, 36);
		panel_3.add(txtTenPhim);
		txtTenPhim.setColumns(10);
		txtTenPhim.setText(layTenPhim());

		spinnerSL = new JSpinner();
		spinnerSL.setBounds(75, 147, 193, 35);
		panel_3.add(spinnerSL);

		JLabel lblNewLabel_6 = new JLabel("Lịch Chiếu");
		lblNewLabel_6.setBounds(278, 13, 231, 13);
		panel_3.add(lblNewLabel_6);

		lichChieu = new JTextField();
		lichChieu.setEditable(false);
		lichChieu.setBounds(343, 10, 166, 33);
		panel_3.add(lichChieu);
		lichChieu.setColumns(10);
		lichChieu.setText(layLichChieu());

		JLabel lblNewLabel_7 = new JLabel("Ghế");
		lblNewLabel_7.setBounds(278, 61, 55, 13);
		panel_3.add(lblNewLabel_7);

		txtGhe = new JTextField();
		txtGhe.setEditable(false);
		txtGhe.setBounds(343, 58, 166, 33);
		panel_3.add(txtGhe);
		txtGhe.setColumns(10);
		txtGhe.setText(layGhe());

		JLabel lblNewLabel_8 = new JLabel("Loại Vé");
		lblNewLabel_8.setBounds(278, 114, 55, 13);
		panel_3.add(lblNewLabel_8);

		txtLoaiVe = new JTextField();
		txtLoaiVe.setEditable(false);
		txtLoaiVe.setBounds(343, 111, 166, 28);
		panel_3.add(txtLoaiVe);
		txtLoaiVe.setColumns(10);
		txtLoaiVe.setText(layLoaiVe());

		cbVePhim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VePhim vp = null;
				String maVePhim = cbVePhim.getSelectedItem().toString();
				String maVe = maVePhim.substring(0, 4);
				vp = vePhim.timVePhim(maVe);
				txtTenPhim.setText(vp.getMaPhim().getTenPhim());
				lichChieu.setText(vp.getMaLichChieu().getMaLichChieu() + " " + vp.getMaLichChieu().getNgayChieu());
				txtGhe.setText(vp.getMaGhe().getMaGhe());
				txtLoaiVe.setText(vp.getMaloaiVe().getTenLoaiVe());
			}
		});

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_4.setBounds(539, 20, 535, 240);
		panel_1.add(panel_4);
		panel_4.setLayout(null);

		JLabel lblNewLabel_9 = new JLabel("Ngày lập");
		lblNewLabel_9.setBounds(10, 13, 74, 13);
		panel_4.add(lblNewLabel_9);

		txtNgayLapHoaDon = new JTextField();
		txtNgayLapHoaDon.setEditable(false);
		txtNgayLapHoaDon.setColumns(10);
		txtNgayLapHoaDon.setBounds(94, 10, 231, 37);
		panel_4.add(txtNgayLapHoaDon);
		txtNgayLapHoaDon.setText(layNgayHienHanh());

		JLabel lblNewLabel_10 = new JLabel("Mã Nhân Viên");
		lblNewLabel_10.setBounds(10, 75, 74, 13);
		panel_4.add(lblNewLabel_10);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setEditable(false);
		txtMaNhanVien.setBounds(94, 72, 231, 35);
		panel_4.add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);
		txtMaNhanVien.setText(nv.getMaNhanVien());

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(335, 10, 190, 191);
		panel_4.add(panel_5);
		panel_5.setLayout(null);

		btnThem = new JButton("Thêm Chi Tiết Hóa Đơn");
		btnThem.setBounds(10, 10, 170, 40);
		panel_5.add(btnThem);

		btnXoaTrang = new JButton("Xóa Trắng");
		btnXoaTrang.setBounds(10, 110, 170, 40);
		panel_5.add(btnXoaTrang);

		btnThemHoaDon = new JButton("Thêm Hóa Đơn");
		btnThemHoaDon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemHoaDon.setBounds(10, 60, 170, 40);
		panel_5.add(btnThemHoaDon);

		JLabel lblNewLabel_11 = new JLabel("Mã Khách Hàng");
		lblNewLabel_11.setBounds(3, 150, 74, 13);
		panel_4.add(lblNewLabel_11);

		modalCBKhachHang = new DefaultComboBoxModel<>();
		cbKhachHang = new JComboBox(modalCBKhachHang);
		cbKhachHang.setBounds(89, 130, 167, 37);
		panel_4.add(cbKhachHang);
		loadDuLieuVaoCBKhachHang();

		btnTimKhachHang = new JButton("Tìm");
		btnTimKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKhachHang.setBounds(266, 130, 59, 37);
		panel_4.add(btnTimKhachHang);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_6.setBounds(1084, 20, 426, 240);
		panel_1.add(panel_6);
		panel_6.setLayout(null);

		JLabel lblNewLabel_12 = new JLabel("Tên Khách Hàng");
		lblNewLabel_12.setBounds(10, 10, 82, 13);
		panel_6.add(lblNewLabel_12);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setEditable(false);
		txtTenKhachHang.setBounds(102, 7, 314, 35);
		panel_6.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(10);
		txtTenKhachHang.setText(layTenKhachHang());

		JLabel lblNewLabel_13 = new JLabel("Số điện thoại");
		lblNewLabel_13.setBounds(10, 52, 82, 13);
		panel_6.add(lblNewLabel_13);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setEditable(false);
		txtSoDienThoai.setBounds(102, 52, 314, 35);
		panel_6.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		txtSoDienThoai.setText(laySDTKhachHang());

		JLabel lblNewLabel_14 = new JLabel("Địa chỉ");
		lblNewLabel_14.setBounds(10, 97, 82, 13);
		panel_6.add(lblNewLabel_14);

		txtDiaChi = new JTextField();
		txtDiaChi.setEditable(false);
		txtDiaChi.setBounds(102, 97, 314, 35);
		panel_6.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		txtDiaChi.setText(layDiaChiKhachHang());

		JLabel lblNewLabel_15 = new JLabel("Ngày sinh");
		lblNewLabel_15.setBounds(10, 145, 82, 13);
		panel_6.add(lblNewLabel_15);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setBounds(102, 142, 314, 35);
		panel_6.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		txtNgaySinh.setText(layNgaySinhKhachHang());

		cbKhachHang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KhachHang khe = null;
				String maKhachHang = cbKhachHang.getSelectedItem().toString();
				String maKH = maKhachHang.substring(0, 6);
				ArrayList<KhachHang> dsKhachHang = kh.getDsKhachHang();
				for (int i = 0; i < dsKhachHang.size(); i++) {
					if (dsKhachHang.get(i).getMaKhachHang().equals(maKH)) {
						khe = dsKhachHang.get(i);
					}
				}
				txtTenKhachHang.setText(khe.getTenKhachHang());
				txtSoDienThoai.setText(khe.getSoDienThoai());
				txtDiaChi.setText(khe.getDiaChi());
				txtNgaySinh.setText(khe.getNgaySinh().toString());
			}
		});

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(10, 379, 1520, 275);
		add(panel_7);
		panel_7.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 1510, 190);
		panel_7.add(scrollPane_1);

		String headCollum[] = new String[] { "Mã Hóa Đơn", "Số lượng", "Mã Vé", "Ngày Lập Hóa Đơn" };
		modalHoaDon = new DefaultTableModel(headCollum, 0);
		table = new JTable(modalHoaDon);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				String maHD = table.getValueAt(row, 0).toString();
				txtMaHoaDon.setText(table.getValueAt(row, 0).toString());
				txtNgayLapHoaDon.setText(table.getValueAt(row, 3).toString());
				ArrayList<HoaDon> dsHoaDon = hd.getAllTBHoaDon();
				for (int i = 0; i < dsHoaDon.size(); i++) {
					if (dsHoaDon.get(i).getMaHoaDon().equals(maHD)) {
						txtMaNhanVien.setText(dsHoaDon.get(i).getMaNhanVien().getMaNhanVien());
						modalCBKhachHang.setSelectedItem(dsHoaDon.get(i).getMaKhachHang().getMaKhachHang());

					}
				}
				txtTongTien.setText(layTongTien(maHD));
			}
		});
		scrollPane_1.setViewportView(table);
		loadDuLieuTable();

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(0, 193, 1510, 82);
		panel_7.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("Tổng Tiền");
		lblNewLabel_16.setBounds(10, 10, 96, 13);
		panel_8.add(lblNewLabel_16);

		txtTongTien = new JTextField();
		txtTongTien.setBounds(127, 7, 129, 33);
		panel_8.add(txtTongTien);
		txtTongTien.setColumns(10);
		txtTongTien.setText(layTongTien(txtMaHoaDon.getText()));

		JLabel lblNewLabel_17 = new JLabel("Khách Trả ");
		lblNewLabel_17.setBounds(297, 10, 96, 13);
		panel_8.add(lblNewLabel_17);

		txtTienKhachTra = new JTextField();
		txtTienKhachTra.setBounds(396, 10, 129, 33);
		panel_8.add(txtTienKhachTra);
		txtTienKhachTra.setColumns(10);

		btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setBounds(636, 10, 151, 33);
		panel_8.add(btnThanhToan);

		btnTienThua = new JButton("Tính Tiền Thùa");
		btnTienThua.setBounds(886, 10, 144, 33);
		panel_8.add(btnTienThua);

		btnXoaTrang.addActionListener(this);
		btnThem.addActionListener(this);
		btnThemHoaDon.addActionListener(this);
		btnTienThua.addActionListener(this);
		btnThanhToan.addActionListener(this);

	}

	private String layTongTien(String maHD) {
		double total = cthdDao.tinhTongTienHoaDon(maHD);
		return String.valueOf(total);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object c = e.getSource();
		if (c.equals(btnXoaTrang)) {
			modalCBKhachHang.setSelectedItem(cbKhachHang.getItemAt(0));
			modalCBVePhim.setSelectedItem(cbVePhim.getItemAt(0));
			txtDiaChi.setText(layDiaChiKhachHang());
			txtGhe.setText(layGhe());
			txtLoaiVe.setText(layLoaiVe());
			txtMaHoaDon.setText(phatSinhMaHoaDon());
			txtNgayLapHoaDon.setText(layNgayHienHanh());
			txtNgaySinh.setText(layNgaySinhKhachHang());
			txtNgayHienHanh.setText(layNgayHienHanh());
			txtSoDienThoai.setText(laySDTKhachHang());
			txtTenKhachHang.setText(layTenKhachHang());
			txtTenPhim.setText(layTenPhim());
			txtTienKhachTra.setText("");
			txtTongTien.setText(layTongTien(txtMaHoaDon.getText()));
		} else if (c.equals(btnThem)) {
			if (validataHoaDon()) {
				String maHoaDon = txtMaHoaDon.getText();
				VePhim_DAO vp = new VePhim_DAO();
				VePhim vpe = vp.timVePhim(cbVePhim.getSelectedItem().toString().substring(0, 4));
				int soLuong = Integer.parseInt(spinnerSL.getValue().toString());
				HoaDon hde = new HoaDon(maHoaDon);
				ChiTietHoaDon cthde = new ChiTietHoaDon(LocalDate.now(), soLuong, vpe, hde);
				tongTien += vpe.getGia() * soLuong;
				txtTongTien.setText(String.valueOf(tongTien));
				dsChiTietHoaDonCanThem.add(cthde);
				modalHoaDon.addRow(new Object[] { maHoaDon, soLuong, vpe.getMaVe(), txtNgayLapHoaDon.getText() });
			}

		} else if (c.equals(btnThemHoaDon)) {
			if (validataHoaDon()) {
				String maHoaDon = txtMaHoaDon.getText();
				String maNhanVien = txtMaNhanVien.getText();
				String tenKh = txtTenKhachHang.getText();
				KhachHang tempKH = null;
				try {
					String maKhachHang = kh.timMaKhachHangTheoTen(tenKh);
					tempKH = new KhachHang(maKhachHang);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại");
				}

				HoaDon temp = new HoaDon(maHoaDon, LocalDate.now(), tempKH, new NhanVien(maNhanVien),
						dsChiTietHoaDonCanThem);

				if (hd.themHoaDon2(temp)) {
					for (int i = 0; i < dsChiTietHoaDonCanThem.size(); i++) {
						ChiTietHoaDon cthd = (ChiTietHoaDon) dsChiTietHoaDonCanThem.get(i);
						cthdDao.themChiTietHoaDon(cthd);
					}
					JOptionPane.showMessageDialog(this, "Thêm hóa đơn thành công");
					dsChiTietHoaDonCanThem.clear();
					tongTien = 0;
				} else {
					JOptionPane.showMessageDialog(this, "Thêm hóa đơn thất bại");
				}
			}
		} else if (c.equals(btnTienThua)) {
			if (validataTienThua()) {
				double tienKhachTra = Double.parseDouble(txtTienKhachTra.getText());
				double tongTien = Double.parseDouble(txtTongTien.getText());
				double tienThua = tienKhachTra - tongTien;
				if (tienThua < 0) {
					JOptionPane.showMessageDialog(this, "Tiền khách trả không đủ");
					return;
				}
				String tienThuaString = moneyFomat.format(tienThua);
				JOptionPane.showMessageDialog(this, "Tiền thừa: " + tienThuaString);
			}
		} else if (c.equals(btnThanhToan)) {
			MessageFormat header = new MessageFormat("Hóa Đơn");
			MessageFormat footer = new MessageFormat("Page{0,number,integer}");
			try {
				table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(this, "In thất bại");
			}

		} else if (c.equals(btnTimVePhim)) {
			loadDuLieuVePhim();
		}

	}

	private boolean validataTienThua() {
		if (txtTienKhachTra.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Tiền khách trả không được trống");
			return false;
		} else {
			try {
				double tienKhachTra = Double.parseDouble(txtTienKhachTra.getText());
				if (tienKhachTra < 0) {
					JOptionPane.showMessageDialog(this, "Tiền khách trả không hợp lệ");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Tiền khách trả không hợp lệ");
				return false;
			}
		}
		return true;
	}

	private boolean validataHoaDon() {
		if (spinnerSL.getValue().toString().equals("0")) {
			JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
			return false;
		} else {
			int soLuong = Integer.parseInt(spinnerSL.getValue().toString());
			try {
				if (soLuong < 0) {
					JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
					return false;
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
				return false;
			}
		}
		return true;
	}

	private String layNgaySinhKhachHang() {
		String maKhachHang = cbKhachHang.getSelectedItem().toString();
		String maKH = maKhachHang.substring(0, 6);
		ArrayList<KhachHang> dsKhachHang = kh.getDsKhachHang();
		for (int i = 0; i < dsKhachHang.size(); i++) {
			if (dsKhachHang.get(i).getMaKhachHang().equals(maKH)) {
				return dsKhachHang.get(i).getNgaySinh().toString();
			}
		}
		return null;
	}

	private String layDiaChiKhachHang() {
		String maKhachHang = cbKhachHang.getSelectedItem().toString();
		String maKH = maKhachHang.substring(0, 6);
		ArrayList<KhachHang> dsKhachHang = kh.getDsKhachHang();
		for (int i = 0; i < dsKhachHang.size(); i++) {
			if (dsKhachHang.get(i).getMaKhachHang().equals(maKH)) {
				return dsKhachHang.get(i).getDiaChi();
			}
		}
		return null;
	}

	private String laySDTKhachHang() {
		String maKhachHang = cbKhachHang.getSelectedItem().toString();
		String maKH = maKhachHang.substring(0, 6);
		ArrayList<KhachHang> dsKhachHang = kh.getDsKhachHang();
		for (int i = 0; i < dsKhachHang.size(); i++) {
			if (dsKhachHang.get(i).getMaKhachHang().equals(maKH)) {
				return dsKhachHang.get(i).getSoDienThoai();
			}
		}
		return null;
	}

	private String layTenKhachHang() {
		String maKhachHang = cbKhachHang.getSelectedItem().toString();
		String maKH = maKhachHang.substring(0, 6);
		ArrayList<KhachHang> dsKhachHang = kh.getDsKhachHang();
		for (int i = 0; i < dsKhachHang.size(); i++) {
			if (dsKhachHang.get(i).getMaKhachHang().equals(maKH)) {
				return dsKhachHang.get(i).getTenKhachHang();
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private void loadDuLieuVaoCBKhachHang() {
		ArrayList<KhachHang> dsKhachHang = kh.getDsKhachHang();
		for (int i = 0; i < dsKhachHang.size(); i++) {
			modalCBKhachHang
					.addElement(dsKhachHang.get(i).getMaKhachHang() + " " + dsKhachHang.get(i).getTenKhachHang());
		}

	}

	private void loadDuLieuTable() {
		ArrayList<ChiTietHoaDon> dsChiTietHoaDon = cthdDao.layDSChiTietHoaDon();
		for (int i = 0; i < dsChiTietHoaDon.size(); i++) {
			String maHoaDon = dsChiTietHoaDon.get(i).getHoaDon().getMaHoaDon();
			int soLuong = dsChiTietHoaDon.get(i).getSoLuong();
			String maVe = dsChiTietHoaDon.get(i).getVePhim().getMaVe();
			LocalDate ngayLapHoaDon = dsChiTietHoaDon.get(i).getNgayLapHoaDon();
			Object[] row = { maHoaDon, soLuong, maVe, ngayLapHoaDon };
			modalHoaDon.addRow(row);

		}
	}

	private String layNgayHienHanh() {
		LocalDate ngayHienHanh = LocalDate.now();
		return ngayHienHanh.toString();

	}

	private String layLoaiVe() {
		Object selectedItem = cbVePhim.getSelectedItem();
		if (selectedItem != null) {
			String maVePhim = selectedItem.toString();
			String maVe = maVePhim.substring(0, 7);

			ArrayList<VePhim> dsVePhim = vePhim.getDsVePhim();
			for (VePhim vePhim : dsVePhim) {
				if (vePhim.getMaVe().equals(maVe)) {
					// Trả về tên loại vé tương ứng
					return vePhim.getMaloaiVe().getTenLoaiVe();
				}
			}
		}
		return null;
	}

	private String layGhe() {
		Object selectedItem = cbVePhim.getSelectedItem();
		if (selectedItem != null) {
			String maVePhim = selectedItem.toString();
			String maVe = maVePhim.substring(0, 7);

			ArrayList<VePhim> dsVePhim = vePhim.getDsVePhim();
			for (VePhim vePhim : dsVePhim) {
				if (vePhim.getMaVe().equals(maVe)) {
					// Trả về mã ghế tương ứng
					return vePhim.getMaGhe().getMaGhe();
				}
			}
		}
		return null;
	}

	private String layLichChieu() {
		Object selectedItem = cbVePhim.getSelectedItem(); // Giả sử cbVePhim là JComboBox chứa thông tin về vé phim

		if (selectedItem != null) {
			String maVePhim = selectedItem.toString();
			String maVe = maVePhim.substring(0, 7);

			ArrayList<VePhim> dsVePhim = vePhim.getDsVePhim(); // Lấy danh sách vé phim từ nguồn dữ liệu

			for (VePhim vePhim : dsVePhim) {
				if (vePhim.getMaVe().equals(maVe)) {
					// Trả về thông tin lịch chiếu tương ứng
					return vePhim.getMaLichChieu().getMaLichChieu() + " " + vePhim.getMaLichChieu().getNgayChieu();
				}
			}
		}

		return null; // Trả về null nếu không tìm thấy thông tin lịch chiếu
	}

	private String layTenPhim() {
		Object selectedItem = cbVePhim.getSelectedItem();
		if (selectedItem != null) {
			String maVePhim = selectedItem.toString();
			String maVe = maVePhim.substring(0, 7);
			ArrayList<VePhim> dsVePhim = vePhim.getDsVePhim();
			for (VePhim vePhim : dsVePhim) {
				if (vePhim.getMaVe().equals(maVe)) {
					return vePhim.getMaPhim().getTenPhim();
				}
			}
		}
		return null;

	}

	private void loadDuLieuVePhim() {
		ArrayList<VePhim> dsVePhim = vePhim.getDsVePhim();

		if (dsVePhim.isEmpty()) {
			cbVePhim.setEnabled(false);
		} else {
			for (VePhim vePhim : dsVePhim) {
				if (modalCBVePhim.getIndexOf(vePhim.getMaVe() + " " + vePhim.getMaPhim().getTenPhim()) == -1) {
					modalCBVePhim.addElement(vePhim.getMaVe() + " " + vePhim.getMaPhim().getTenPhim());
				}
			}
		}
	}

	private String phatSinhMaHoaDon() {
		String maHoaDonCuoi = hd.layMaHoaDonCuoi();
		if (maHoaDonCuoi != null && !maHoaDonCuoi.isEmpty()) {
			String sttString = maHoaDonCuoi.substring(2);
			int sttInt = Integer.parseInt(sttString);
			int sttNew = sttInt + 1;
			String maHoaDonNew = "HD" + String.format("%03d", sttNew);
			return maHoaDonNew;
		} else {
			return "HD001";
		}
	}

}

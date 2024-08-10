package gui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.Document;

import dao.Ghe_DAO;
import dao.LichChieu_DAO;
import dao.LoaiVe_DAO;
import dao.Phim_DAO;
import dao.VePhim_DAO;
import entity.Ghe;
import entity.LichChieu;
import entity.LoaiVe;
import entity.NhanVien;
import entity.Phim;
import entity.VePhim;

import javax.swing.JScrollPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class GUI_TaoVePhim extends JPanel implements MouseListener {
	private JTable table;
	private DefaultTableModel modeltable;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_5;

	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	private JComboBox<String> comboBox_2;
	private JComboBox<String> comboBox_3; 

	private VePhim_DAO vp_dao = new VePhim_DAO();
	private LoaiVe_DAO lv_dao = new LoaiVe_DAO();
	private Phim_DAO p_dao = new Phim_DAO();
	private LichChieu_DAO lc_dao = new LichChieu_DAO();
	private Ghe_DAO g_dao = new Ghe_DAO();

	private ArrayList<VePhim> listVePhim;
	private ArrayList<LoaiVe> listLoaiVe;
	private ArrayList<Phim> listPhim;
	private ArrayList<LichChieu> listLichChieu;

	private ScreenshotHelper sp;

	/**
	 * Create the panel.
	 */
	public GUI_TaoVePhim(NhanVien emp) {
		listVePhim = vp_dao.getDsVePhim();
		listLoaiVe = lv_dao.getalltbLoaiVe();
		listPhim = p_dao.getalltbPhim();
		listLichChieu = lc_dao.layDSLichChieu();
		int soLuongDanhSach = listVePhim.size();
		String maVeHienTai = "V0000" + soLuongDanhSach;
		sp = new ScreenshotHelper();

		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("TẠO VÉ PHIM");
		lblNewLabel.setForeground(new Color(0, 128, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));

		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u1EA1o V\u00E9", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 255)));
		panel_2.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_2);

		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_4);

		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.Y_AXIS));

		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("Mã Vé");
		panel_8.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setEditable(false);
		panel_8.add(textField);
		textField.setColumns(10);
		textField.setText(maVeHienTai);

		JPanel panel_9 = new JPanel();
		panel_6.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_2 = new JLabel("Loại Vé");
		panel_9.add(lblNewLabel_2);
		comboBox = new JComboBox<String>();
		duaTenVePhimVaoCBB(comboBox);
		panel_9.add(comboBox);

		JPanel panel_10 = new JPanel();
		panel_6.add(panel_10);
		panel_10.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("Phim");
		panel_10.add(lblNewLabel_3);

		comboBox_1 = new JComboBox<String>();
		duaTenPhimVaoCBB(comboBox_1);
		panel_10.add(comboBox_1);

		JPanel panel_11 = new JPanel();
		panel_6.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_5 = new JLabel("Lịch Chiếu");
		panel_11.add(lblNewLabel_5);

		comboBox_2 = new JComboBox<String>();
		duaLichChieuVaoCBB(comboBox_2);
		panel_11.add(comboBox_2);

		JPanel panel_12 = new JPanel();
		panel_6.add(panel_12);
		panel_12.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("Ghế");
		panel_12.add(lblNewLabel_4);

		textField_3 = new JTextField();
		textField_3.setEditable(false);
		panel_12.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("");
		panel_12.add(lblNewLabel_7);

		JButton btnNewButton_4 = new JButton("Chọn Ghế");
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String lichChieuCB = comboBox_2.getSelectedItem().toString();
				String[] partsLichChieu = lichChieuCB.split(" ");
				String lichChieu = partsLichChieu[0];
				LichChieu lc = lc_dao.layLichChieuTheoMaVe(lichChieu);

				GUI_ChonGhe selectionFrame = new GUI_ChonGhe(textField_3, lc);
				selectionFrame.setLocationRelativeTo(null);
				selectionFrame.setVisible(true);
			}
		});
		panel_12.add(btnNewButton_4);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_1);

		JPanel panel_7 = new JPanel();
		panel_7.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_7.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_4.add(panel_7);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_13 = new JPanel();
		panel_7.add(panel_13);
		panel_13.setLayout(new BoxLayout(panel_13, BoxLayout.Y_AXIS));

		JLabel lblNewLabel_6 = new JLabel("Mô Tả");
		panel_13.add(lblNewLabel_6);

		textField_5 = new JTextField();
		panel_13.add(textField_5);
		textField_5.setColumns(10);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_3);

		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_5);

		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Thao T\u00E1c", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 255)));
		panel_2.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));

		JPanel panel_18 = new JPanel();
		panel_5.add(panel_18);

		JButton btnNewButton_2 = new JButton("Tìm Vé");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timVeActionPerformed(e, panel_1);
			}
		});
		panel_18.add(btnNewButton_2);
		btnNewButton_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton_2.setBackground(new Color(0, 128, 255));
		
		comboBox_3 = new JComboBox<String>();
		duaMaVeVaoCBB(comboBox_3);
		panel_18.add(comboBox_3);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_2);

		JPanel panel_14 = new JPanel();
		panel_5.add(panel_14);
		panel_14.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnNewButton = new JButton("Tạo Vé");
		btnNewButton.setBackground(new Color(0, 128, 255));
		panel_14.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soLuongDanhSach = listVePhim.size();
				String maVeHienTai = "V0000" + soLuongDanhSach;
				textField.setText(maVeHienTai);

				String maVe = textField.getText();

				String loaiVeCN = comboBox.getSelectedItem().toString();
				String[] partsLoaiVe = loaiVeCN.split(" ");
				String loaiVe = partsLoaiVe[0];
				LoaiVe lv = lv_dao.layVeTheoMaVe(loaiVe); //////////

				String phimCN = comboBox_1.getSelectedItem().toString();
				String[] partsPhim = phimCN.split(" ");
				String phim = partsPhim[0];
				Phim p = p_dao.layPhimTheoMaVe(phim); ///////////////

				String lichChieuCB = comboBox_2.getSelectedItem().toString();
				String[] partsLichChieu = lichChieuCB.split(" ");
				String lichChieu = partsLichChieu[0];
				LichChieu lc = lc_dao.layLichChieuTheoMaVe(lichChieu); //////////

				String ghe = textField_3.getText();
				Ghe g = g_dao.layLichChieuTheoMaVe(ghe);

				String moTa = textField_5.getText();

				VePhim vp = new VePhim(maVe, lv, p, lc, g, moTa);

				if (listVePhim.contains(vp)) {
					JOptionPane.showMessageDialog(panel_1, "Trùng Mã Vé");
				} else {
					if (textField_3.getText().equals("")) {
						JOptionPane.showMessageDialog(panel_1, "Chọn ghế cho vé");
					} else {
						listVePhim.add(vp);
						soLuongDanhSach = listVePhim.size();
						maVeHienTai = "V0000" + soLuongDanhSach;
						textField.setText(maVeHienTai);
						vp_dao.themVePhim(vp);
						g_dao.capNhatTrangThaiGhe(vp.getMaGhe().getMaGhe()); 
						
						/// dua vao table 
						modeltable.addRow(new Object[] { vp.getMaVe(),
								vp.getMaloaiVe().getMaLoaiVe() + " " + vp.getMaloaiVe().getTenLoaiVe(),
								vp.getMaPhim().getMaPhim() + " " + vp.getMaPhim().getTenPhim(),
								vp.getMaLichChieu().getMaLichChieu() + " " + vp.getMaLichChieu().getNgayChieu() + " "
										+ vp.getMaLichChieu().getThoiGianChieu(),
								vp.getMaGhe().getMaGhe(), vp.getGia(), vp.getMota() });
						GUI_InVe gui_InVe = new GUI_InVe(vp, emp);
						gui_InVe.setVisible(true); 
						int askPrint = JOptionPane.showConfirmDialog(panel_1, "Bạn có muốn in vé không",
								"In Vé", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

						if (askPrint == JOptionPane.YES_OPTION) {
							BufferedImage bff = ScreenshotHelper.captureComponent(gui_InVe);
							ScreenshotHelper.printImage(bff);
							gui_InVe.setVisible(false); 
						}else {
							gui_InVe.setVisible(false);
						}
						
							
					}
				}
			}
		});

		Component verticalStrut = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut);

		JPanel panel_15 = new JPanel();
		panel_5.add(panel_15);

		JButton btnNewButton_1 = new JButton("Xóa Trắng");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel_15.add(btnNewButton_1);
		btnNewButton_1.setAlignmentY(Component.TOP_ALIGNMENT);
		btnNewButton_1.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnNewButton_1.setBackground(new Color(0, 128, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int soLuongDanhSach = listVePhim.size();
				String maVeHienTai = "V00" + soLuongDanhSach;
				textField.setText(maVeHienTai);
				textField_3.setText("");
				textField_5.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				comboBox_2.setSelectedIndex(0);
			}
		});

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		panel_5.add(verticalStrut_1);

		JPanel panel_19 = new JPanel();
		panel_5.add(panel_19);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "V\u00E9 Phim", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));

		String tieude[] = { "Mã Vé", "Loại Vé", "Phim", "Lịch Chiếu", "Ghế", "Giá", "Mô Tả" };
		modeltable = new DefaultTableModel(tieude, 0);
		table = new JTable(modeltable);
		panel_3.add(table);
		panel_3.add(new JScrollPane(table));
		duaDuLieuVaoModule();

		// Đăng Kí
		table.addMouseListener(this);

	}

	/// dua du lieu vao comboBox
	public void duaTenVePhimVaoCBB(JComboBox<String> comboBox) {
		for (LoaiVe loaiVe : listLoaiVe) {
			comboBox.addItem(loaiVe.getMaLoaiVe() + " " + loaiVe.getTenLoaiVe());
		}
	}

	public void duaTenPhimVaoCBB(JComboBox<String> comboBox) {
		for (Phim phim : listPhim) {
			comboBox.addItem(phim.getMaPhim() + " " + phim.getTenPhim());
		}
	}

	public void duaLichChieuVaoCBB(JComboBox<String> comboBox) {
		for (LichChieu lichchieu : listLichChieu) {
			comboBox.addItem(
					lichchieu.getMaLichChieu() + " " + lichchieu.getNgayChieu() + " " + lichchieu.getThoiGianChieu());
		}
	}
	
	public void duaMaVeVaoCBB(JComboBox<String> comboBox) {
		for (VePhim vephim : listVePhim) {
			comboBox.addItem(vephim.getMaVe());
		}
	}
	

	//// Đưa Vé Vào Table
	public void duaDuLieuVaoModule() {
		for (VePhim vephim : listVePhim) {
			modeltable.addRow(new Object[] { vephim.getMaVe(),
					vephim.getMaloaiVe().getMaLoaiVe() + " " + vephim.getMaloaiVe().getTenLoaiVe(),
					vephim.getMaPhim().getMaPhim() + " " + vephim.getMaPhim().getTenPhim(),
					vephim.getMaLichChieu().getMaLichChieu() + " " + vephim.getMaLichChieu().getNgayChieu() + " "
							+ vephim.getMaLichChieu().getThoiGianChieu(),
					vephim.getMaGhe().getMaGhe(), vephim.getGia(), vephim.getMota() });

		}
	}

	/// Sự kiện Nút
	private void timVeActionPerformed(java.awt.event.ActionEvent evt, JPanel p) {
		String str = (String) comboBox_3.getSelectedItem();  
		if (!str.equals("")) {
			int rowTimKiem = -1;
			for (int i = 0; i < listVePhim.size(); i++)
				if (table.getValueAt(i, 0).toString().equals(str)) {
					rowTimKiem = i;
					break;
				}
					

			if (vp_dao.timVePhim(str) != null && rowTimKiem != -1) {
	            // Chọn dòng tìm kiếm
	            table.getSelectionModel().setSelectionInterval(rowTimKiem, rowTimKiem);

	            // Đưa dòng được chọn vào giữa của viewport
	            Rectangle rect = table.getCellRect(rowTimKiem, 0, true);
	            table.scrollRectToVisible(new Rectangle(rect.x, rect.y, rect.width, 100));
	        }
		} 
	}

	// Sự Kiện Chuột
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		textField.setText(modeltable.getValueAt(row, 0).toString());
		textField_5.setText(modeltable.getValueAt(row, 6).toString());
		textField_3.setText(modeltable.getValueAt(row, 4).toString());
		comboBox.setSelectedItem(modeltable.getValueAt(row, 1).toString());
		comboBox_1.setSelectedItem(modeltable.getValueAt(row, 2).toString());
		comboBox_2.setSelectedItem(modeltable.getValueAt(row, 3).toString());
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

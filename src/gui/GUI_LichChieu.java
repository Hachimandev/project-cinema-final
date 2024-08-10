package gui;


import com.toedter.calendar.JDateChooser;

import connectDB.ConnectDB;
import dao.LichChieu_DAO;
import dao.Phim_DAO;
import entity.LichChieu;
import entity.Phim;
import entity.PhongChieu;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import javax.swing.Box;



public class GUI_LichChieu extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private DefaultTableModel modelTableLichChieu;
	private JTable tableLichChieu;
	private JTextField txtMaLC;
	private ButtonGroup group;
	private JComboBox<String> comboTenPhim;
	private JRadioButton radPhongD;
	private JRadioButton radPhongC;
	private JRadioButton radPhongB;
	private JRadioButton radPhongA;
	private JSpinner timeSpinnerKT;
	private JSpinner timeSpinnerBD;
	private JDateChooser dateNchieu;
	private JButton btnHuy;
	private JButton btnXoa;
	private JButton btnCapNhap;
	private JButton btnThem;
	private JButton btnTim;
	private LichChieu_DAO lc_dao;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd - MM - yyyy");
	private JButton btnReset;
//	private boolean use_phatSinhMaLichChieu;
	private JTextField txtNgayHienTai;

	/**
	 * Create the panel.
	 */
	public GUI_LichChieu() throws SQLException {
		ConnectDB.getInstance();
		ConnectDB.connect();
		
		lc_dao = new LichChieu_DAO();
		
		setBounds(100, 100, 1472, 657);
		setLayout(new BorderLayout(0, 0));
		
		JPanel pTop = new JPanel();
		add(pTop, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Quản Lý Lịch Chiếu");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 25));
		pTop.add(lblTitle);
		
		JPanel pCenter = new JPanel();
		add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(null);
							
		JLabel lblMaLichChieu = new JLabel("Mã Lịch Chiếu");
		lblMaLichChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaLichChieu.setBounds(67, 45, 130, 30);
		pCenter.add(lblMaLichChieu);
		
		txtMaLC = new JTextField();
		txtMaLC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaLC.setBounds(207, 45, 248, 30);
		txtMaLC.setDisabledTextColor(Color.LIGHT_GRAY);
		txtMaLC.setEnabled(false);
		pCenter.add(txtMaLC);
		txtMaLC.setColumns(10);
		
		JLabel lblNChieu = new JLabel("Ngày Chiếu");
		lblNChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNChieu.setBounds(67, 96, 136, 30);
		pCenter.add(lblNChieu);
		
		dateNchieu = new JDateChooser();
		dateNchieu.setDateFormatString("dd-MM-yyyy");
		dateNchieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dateNchieu.setBounds(207, 96, 248, 30);
		pCenter.add(dateNchieu);
		
		JLabel lblTGBD = new JLabel("Thời Gian Bắt Đầu");
		lblTGBD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTGBD.setBounds(67, 151, 136, 32);
		pCenter.add(lblTGBD);
		
		timeSpinnerBD = new JSpinner();
		timeSpinnerBD.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timeSpinnerBD.setBounds(207, 153, 145, 30);	
		timeSpinnerBD.setModel(new SpinnerDateModel(new Date(1704128400000L), null, null, Calendar.HOUR_OF_DAY));
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinnerBD, "HH:mm:ss");
		timeSpinnerBD.setEditor(timeEditor);
		pCenter.add(timeSpinnerBD);
		
		JLabel lblTGKT = new JLabel("Thời Gian Kết Thúc");
		lblTGKT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTGKT.setBounds(67, 204, 136, 30);
		pCenter.add(lblTGKT);
		
		timeSpinnerKT = new JSpinner();
		timeSpinnerKT.setFont(new Font("Tahoma", Font.PLAIN, 17));
		timeSpinnerKT.setBounds(207, 206, 145, 27);
		timeSpinnerKT.setModel(new SpinnerDateModel(new Date(1704042000490L), null, null, Calendar.HOUR_OF_DAY));
		JSpinner.DateEditor timeEditor1 = new JSpinner.DateEditor(timeSpinnerKT, "HH:mm:ss");
		timeSpinnerKT.setEditor(timeEditor1);
		pCenter.add(timeSpinnerKT);
		
		JLabel lblPhongChieu = new JLabel("Phòng Chiếu");
		lblPhongChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhongChieu.setBounds(67, 256, 136, 30);
		pCenter.add(lblPhongChieu);
			
		radPhongA = new JRadioButton("Phòng A");
		radPhongA.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radPhongA.setBounds(207, 259, 95, 25);
		pCenter.add(radPhongA);
		
		radPhongB = new JRadioButton("Phòng B");
		radPhongB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radPhongB.setBounds(332, 259, 95, 25);
		pCenter.add(radPhongB);
		
		radPhongC = new JRadioButton("Phòng C");
		radPhongC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radPhongC.setBounds(207, 293, 95, 25);
		pCenter.add(radPhongC);
		
		radPhongD = new JRadioButton("Phòng D");
		radPhongD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		radPhongD.setBounds(332, 293, 95, 25);
		pCenter.add(radPhongD);
		
		group = new ButtonGroup();
		group.add(radPhongA);
		group.add(radPhongB);
		group.add(radPhongC);
		group.add(radPhongD);
						
		JLabel lblTenPhim = new JLabel("Phim");
		lblTenPhim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTenPhim.setBounds(516, 43, 54, 30);
		pCenter.add(lblTenPhim);
		
		btnTim = new JButton("Lọc theo phim");
		btnTim.setBackground(new Color(0, 128, 255));
		btnTim.setForeground(Color.WHITE);
		btnTim.setFont(new java.awt.Font("Segoe UI", 1, 12));
		btnTim.setBounds(580, 45, 153, 30);
		pCenter.add(btnTim);
		
		btnReset = new JButton("Reset");
		btnReset.setEnabled(false);
		btnReset.setForeground(Color.BLUE);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnReset.setBounds(750, 45, 84, 30);
		pCenter.add(btnReset);
		
		//=================ComboBox======================================
		comboTenPhim = new JComboBox<String>();	
		comboTenPhim.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		comboTenPhim.setBounds(516, 89, 318, 37);	
		updateComboBox();
		pCenter.add(comboTenPhim);
	
		JPanel pThongTin = new JPanel();
		pThongTin.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(64, 64, 64), new Color(192, 192, 192)), 
				"Thông tin lịch chiếu", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pThongTin.setBounds(53, 10, 840, 316);
		pCenter.add(pThongTin);
		
		btnHuy = new JButton("Xoá Trắng");
		btnHuy.setForeground(Color.BLUE);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnHuy.setBounds(1051, 227, 145, 37);
		pCenter.add(btnHuy);
		
		btnXoa = new JButton("Xoá");
		btnXoa.setForeground(Color.BLUE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoa.setBounds(1051, 105, 145, 36);
		pCenter.add(btnXoa);
		
		btnCapNhap = new JButton("Cập Nhập");
		btnCapNhap.setForeground(Color.BLUE);
		btnCapNhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCapNhap.setBounds(1051, 165, 145, 36);
		pCenter.add(btnCapNhap);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(Color.BLUE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnThem.setBounds(1051, 45, 145, 36);
		pCenter.add(btnThem);
		
		JLabel lblNgayHT = new JLabel("Ngày hiện tại");
		lblNgayHT.setHorizontalAlignment(SwingConstants.CENTER);
		lblNgayHT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayHT.setBounds(1221, 45, 160, 36);
		pCenter.add(lblNgayHT);
		
		txtNgayHienTai = new javax.swing.JTextField(sdf.format(new Date()));
		txtNgayHienTai.setEditable(false);
		txtNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNgayHienTai.setForeground(Color.BLACK);
		txtNgayHienTai.setHorizontalAlignment(SwingConstants.CENTER);
		txtNgayHienTai.setBounds(1221, 95, 160, 36);
		pCenter.add(txtNgayHienTai);
		txtNgayHienTai.setColumns(10);
		
		JPanel pThongTin_1 = new JPanel();
		pThongTin_1.setBounds(1011, 10, 430, 308);
		pCenter.add(pThongTin_1);
		pThongTin_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 64), new Color(192, 192, 192)), 
				"Giao tác", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
					
		JPanel pBottom = new JPanel();
		pBottom.setBorder(null);
		add(pBottom, BorderLayout.SOUTH);
	
		String[] header = {"Mã lịch chiếu","Ngày chiếu","Thời gian bắt đầu","Thời gian kết thúc","Mã phòng chiếu","Mã phim"};
		Font headerFont = new Font("Arial", Font.BOLD, 17);
		modelTableLichChieu = new DefaultTableModel(header,0);
		tableLichChieu = new JTable(modelTableLichChieu);		
		pBottom.add(new JScrollPane(tableLichChieu));
		tableLichChieu.getTableHeader().setFont(headerFont);
		tableLichChieu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableLichChieu.setPreferredScrollableViewportSize(new Dimension(1240, 300));	
		tableLichChieu.setMinimumSize(new Dimension(1050, 300));			
		tableLichChieu.setRowHeight(35);    
		
		DocDuLieuVaoTable();
		//=======================================================
        
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhap.addActionListener(this);
		btnHuy.addActionListener(this);
		btnTim.addActionListener(this);
		btnReset.addActionListener(this);
		comboTenPhim.addActionListener(this);
		
		tableLichChieu.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int row = tableLichChieu.getSelectedRow();	
		txtMaLC.setText(modelTableLichChieu.getValueAt(row, 0).toString());		
		try {
			Object value = modelTableLichChieu.getValueAt(row, 1).toString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date date = dateFormat.parse((String) value);
			dateNchieu.setDate(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Object value = modelTableLichChieu.getValueAt(row, 2).toString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date date = dateFormat.parse((String) value);
			timeSpinnerBD.setValue(date);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			Object value1 = modelTableLichChieu.getValueAt(row, 3).toString();
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Date date1 = dateFormat.parse((String) value1);
			timeSpinnerKT.setValue(date1);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String maPhong = modelTableLichChieu.getValueAt(row, 4).toString();
		radPhongA.setSelected("A".equals(maPhong));
		radPhongB.setSelected("B".equals(maPhong));
		radPhongC.setSelected("C".equals(maPhong));
		radPhongD.setSelected("D".equals(maPhong));
		
		String maPhim = modelTableLichChieu.getValueAt(row, 5).toString();
		try {
			String tenPhim =  lc_dao.getTenPhimByMaPhim(maPhim);
			comboTenPhim.setSelectedItem(tenPhim);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			if(validData()) {
				LichChieu lc = reverLCFromTextFile();
				 String maLichChieu = phatSinhMaLichChieu();
			        
			     lc.setMaLichChieu(maLichChieu);
				try {
					if(JOptionPane.showConfirmDialog(this, "Thêm lịch chiếu "+ maLichChieu +" mới?", "Cảnh báo!", JOptionPane.YES_NO_OPTION)==
							JOptionPane.YES_OPTION) {
						if(lc_dao.themLichChieu(lc)) {
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					        String ngayChieuFormatted = lc.getNgayChieu().format(formatter);
							modelTableLichChieu.addRow(new Object[] {lc.getMaLichChieu(), ngayChieuFormatted, lc.getThoiGianChieu(),
									 lc.getThoiGianKetThuc(), lc.getPhongChieu().getMaPhongChieu(), lc.getPhim().getMaPhim()});
							JOptionPane.showMessageDialog(this, "Thêm thành công!");
						} else {
							JOptionPane.showMessageDialog(this, "Thêm thất bại!");
						}
					}							
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(this, "Trùng Mã!");
				}	
			}	
		} else if(o.equals(btnHuy)) {
			xoaRongTextfields();	
			DocDuLieuVaoTable();
		} else if(o.equals(btnXoa)){
			int row = tableLichChieu.getSelectedRow();
			if(row == -1) {
				JOptionPane.showMessageDialog(this, "Chọn lịch chiếu cần xoá!");
			}else {
				if(JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xoá không?", "Cảnh báo!", JOptionPane.YES_NO_OPTION)==
						JOptionPane.YES_OPTION) {
					String maLC = (String) tableLichChieu.getValueAt(row, 0);
					if(lc_dao.xoaLichChieu(maLC)){
						modelTableLichChieu.removeRow(row);
						xoaRongTextfields();
						JOptionPane.showMessageDialog(this, "Xoá thành công!");
					}
				}				
			}
	    } else if(o.equals(btnCapNhap)) {
	    	if(o.equals(btnCapNhap)) {	    	    
	    	    int row = tableLichChieu.getSelectedRow();
				if(row == -1) {
					JOptionPane.showMessageDialog(this, "Chọn lịch chiếu cần cập nhập!");
				}else {
					LichChieu lc = reverLCFromTextFile();
					if (lc_dao.capNhapLichChieu(lc)) {
		    	        int rowIndex = tableLichChieu.getSelectedRow(); 
		    	        if (rowIndex != -1) { 
		    	        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					        String ngayChieuFormatted = lc.getNgayChieu().format(formatter);
		    	            modelTableLichChieu.setValueAt(lc.getMaLichChieu(), rowIndex, 0);
		    	            modelTableLichChieu.setValueAt(ngayChieuFormatted, rowIndex, 1); 
		    	            modelTableLichChieu.setValueAt(lc.getThoiGianChieu(), rowIndex, 2);
		    	            modelTableLichChieu.setValueAt(lc.getThoiGianKetThuc(), rowIndex, 3); 
		    	            modelTableLichChieu.setValueAt(lc.getPhongChieu().getMaPhongChieu(), rowIndex, 4); 
		    	            modelTableLichChieu.setValueAt(lc.getPhim().getMaPhim(), rowIndex, 5); 
		    	            JOptionPane.showMessageDialog(this, "Cập nhật lịch chiếu thành công!");
		    	        } else {
		    	            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng để cập nhật!");
		    	        }
		    	    } else {
		    	        JOptionPane.showMessageDialog(this, "Cập nhật lịch chiếu thất bại!");
		    	    }
				}    	    
	    	}
	    } else if(o.equals(btnTim)) {
	    	String tenPhim = comboTenPhim.getSelectedItem().toString();  
	        String maPhim = null;
	        try {
	            maPhim = lc_dao.getMaPhimByTenPhim(tenPhim);
	        } catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	        if(maPhim != null && !maPhim.isEmpty()) {
	            try {
	                ArrayList<LichChieu> dsLCFind = lc_dao.timLichChieuTheoTenPhim(tenPhim);
	                if(dsLCFind != null && !dsLCFind.isEmpty()) {
	                	btnReset.setEnabled(true);
	                    xoaDuLieu();
	                    for (LichChieu lc : dsLCFind) { 
	                    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					        String ngayChieuFormatted = lc.getNgayChieu().format(formatter);
	                        modelTableLichChieu.addRow(new Object[] {lc.getMaLichChieu(), ngayChieuFormatted, lc.getThoiGianChieu(),
	                                 lc.getThoiGianKetThuc(), lc.getPhongChieu().getMaPhongChieu(), lc.getPhim().getMaPhim()});
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "Không tìm thấy lịch chiếu cho phim này!");
	                    btnReset.setEnabled(true);
	                }
	            } catch (Exception e2) {
	                JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!");
	            }
	        } else {
	        	JOptionPane.showMessageDialog(null, "Chọn phim muốn tìm lịch chiếu!");
	        }
				
	    } else if(o.equals(btnReset)) {
			 DocDuLieuVaoTable();
			 btnReset.setEnabled(false);
		}

	}
	public void xoaRongTextfields() {
		txtMaLC.setText("");
		dateNchieu.setDate(null);
		Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.HOUR_OF_DAY, 0);
	    calendar.set(Calendar.MINUTE, 0);
	    calendar.set(Calendar.SECOND, 0);
	    Date timeZero = calendar.getTime();
	    timeSpinnerBD.setValue(timeZero);	    
	    timeSpinnerKT.setValue(timeZero);		    
		radPhongA.setSelected(false);
		radPhongB.setSelected(false);
		radPhongC.setSelected(false);
		radPhongD.setSelected(false);			
		comboTenPhim.setSelectedIndex(-1);
	}
	
	public String phatSinhMaLichChieu() {
//	    use_phatSinhMaLichChieu = true;
	    
	    String maLC_lastest = lc_dao.layMaLichChieuCuoiCung().trim();
	    String ma = "LC";
	
	    if (maLC_lastest != null) {
	        String stt_string_lastest = maLC_lastest.substring(2);
	        int stt_int_lastest = Integer.parseInt(stt_string_lastest);
	        stt_int_lastest++;
	        ma += String.format("%03d", stt_int_lastest);
	    } else {
	        ma += "01";
	    }
	    return ma;
	}
	
	public LocalDate convertToLocalDate(JDateChooser dateChooser) {
		 Date date = dateChooser.getDate(); 
	     return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); 
	 }

	public Time convertToTime(JSpinner spinner) {
		 Object value = spinner.getValue();
		 if (value instanceof Date) {
			 return new Time(((Date) value).getTime()); 
		 } else {
			 return null;
		 }    
	 }
	
	public LichChieu reverLCFromTextFile() {
		String maLC = txtMaLC.getText().toString();
		LocalDate ngayChieu = convertToLocalDate(dateNchieu); 
        Time tgBD = convertToTime(timeSpinnerBD);
        Time tgKT = convertToTime(timeSpinnerKT);

		PhongChieu phongDuocChon = null;
		if (radPhongA.isSelected()) {
	        phongDuocChon = new PhongChieu("A");
	    } else if (radPhongB.isSelected()) {
	        phongDuocChon = new PhongChieu("B"); 
	    } else if (radPhongC.isSelected()) {
	        phongDuocChon = new PhongChieu("C"); 
	    } else if (radPhongD.isSelected()) {
	        phongDuocChon = new PhongChieu("D"); 
	    }
		
		String tenPhim = comboTenPhim.getSelectedItem().toString();  
		Phim phim = null;
		try {
			String maPhim = lc_dao.getMaPhimByTenPhim(tenPhim);
		    phim  = new Phim(maPhim);
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		
		return new LichChieu(maLC, tgBD, tgKT, ngayChieu, phongDuocChon, phim);
	}

	
	public void updateComboBox() {
    	Phim_DAO phim_dao = new Phim_DAO();
		List<Phim> list = phim_dao.getalltbPhim();
		
		comboTenPhim.removeAllItems();
		comboTenPhim.addItem("");
		for (Phim p : list) {
			comboTenPhim.addItem(p.getTenPhim());	
		}
		 		
	}
	
	public void xoaDuLieu() {
		DefaultTableModel dm = (DefaultTableModel) tableLichChieu.getModel();
		dm.getDataVector().removeAllElements();
	}
	public void DocDuLieuVaoTable() {
		List<LichChieu> list = lc_dao.layDSLichChieu();
		
		for (LichChieu lc : list) {		
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        String ngayChieuFormatted = lc.getNgayChieu().format(formatter);
			modelTableLichChieu.addRow(new Object[] {lc.getMaLichChieu(), ngayChieuFormatted, lc.getThoiGianChieu(),
					 lc.getThoiGianKetThuc(), lc.getPhongChieu().getMaPhongChieu(), lc.getPhim().getMaPhim()});
		}
	}
	
	public boolean validData() {
	    Date ngayChieu = dateNchieu.getDate(); 
	    String tenPhim = comboTenPhim.getSelectedItem().toString();  
    
	    if(ngayChieu == null) {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày chiếu!");
	        return false;
	    } 
	    
	    Time tgBD = convertToTime(timeSpinnerBD);
	    Time tgKT = convertToTime(timeSpinnerKT);  
	    
	    if (tgBD == null || tgKT == null) {
	        JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin thời gian!");
	        return false;
	    }
	    
	    LocalTime localTgBD = tgBD.toLocalTime();
	    LocalTime localTgKT = tgKT.toLocalTime();
	    
	    if (localTgKT.isBefore(localTgBD) || localTgKT == localTgBD) {
	        JOptionPane.showMessageDialog(this, "Thời gian kết thúc phải sau thời gian bắt đầu!");
	        return false;
	    } 
	    
	    if(tenPhim == null || tenPhim == "") {
	        JOptionPane.showMessageDialog(this, "Vui lòng chọn phim!");
	        return false;
	    } 
	    return true;
	}
}

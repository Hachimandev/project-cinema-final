package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import connectDB.ConnectDB;
import dao.ThongKe_DAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;

public class GUI_ThongKeDoanhThuDemo extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtNgayHienTai;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd - MM - yyyy");
	private JTextField txtDTHT;
	private DefaultTableModel modelTableThongKeDT;
	private JTable tableThongKeDT;
	private DefaultTableModel modelTableThongKeKH;
	private JTable tableThongKeKH;
	private ThongKe_DAO tk_dao;
	private JButton btnXemAll;
	private JComboBox<String> cmbThang;
	private JComboBox<String> cmbNam;
	private JButton btnThang;
	private JButton btnNam;

	/**
	 * Create the panel.
	 */
	public GUI_ThongKeDoanhThuDemo() {
		ConnectDB.getInstance();
		ConnectDB.connect();
		
		tk_dao = new ThongKe_DAO();
		setLayout(new BorderLayout(0, 0));
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Set the size of the main panel to fill the screen
        setPreferredSize(new Dimension(1540, 700));
        
        JPanel pnl_ALL = new JPanel();
		add(pnl_ALL, BorderLayout.CENTER);
		pnl_ALL.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		pnl_ALL.add(tabbedPane);
		
		JPanel pDoanhThu = new JPanel();
		tabbedPane.addTab("Thống Kê Doanh Thu", null, pDoanhThu, null);
		pDoanhThu.setLayout(new BorderLayout(0, 0));
		
		
//		JLabel lbl_TieuDe1 = new JLabel("Thống Kê Doanh Thu");
//		lbl_TieuDe1.setForeground(SystemColor.textHighlight);
//		lbl_TieuDe1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
//		pDoanhThu.add(lbl_TieuDe1);
		
		
		
		JPanel panel = new JPanel();
		pDoanhThu.add(panel, BorderLayout.NORTH);
		
		JLabel lbltitleDT = new JLabel("Thống Kê Doanh Thu");
		lbltitleDT.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		lbltitleDT.setForeground(Color.BLUE);
		panel.add(lbltitleDT);
		
		JPanel panel_1 = new JPanel();
		pDoanhThu.add(panel_1,BorderLayout.CENTER);
		
		panel_1.setLayout(null);
		
		JLabel lblThang = new JLabel("Tháng: ");
		lblThang.setHorizontalAlignment(SwingConstants.LEFT);
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThang.setBounds(50, 11, 89, 32);
		panel_1.add(lblThang);
		
		JLabel lblNam = new JLabel("Năm: ");
		lblNam.setHorizontalAlignment(SwingConstants.LEFT);
		lblNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNam.setBounds(50, 60, 81, 32);
		panel_1.add(lblNam);
		
		btnXemAll = new JButton("Xem Tất Cả");
		btnXemAll.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnXemAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXemAll.setBounds(1330, 63, 164, 35);
		panel_1.add(btnXemAll);
		
		String[] months = new String[13];
		months[0] = "";
		for (int i = 1; i <= 12; i++) {
			months[i] = String.valueOf(i);
		}
		cmbThang = new JComboBox<String>(months);
		cmbThang.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbThang.setBounds(149, 13, 242, 32);
		panel_1.add(cmbThang);
		
		int currentYear = Year.now().getValue();
		String[] years = new String[currentYear - 2020 + 1]; 
		years[0] = "";
		for (int i = 2021; i <= currentYear; i++) {
		    years[i - 2020] = String.valueOf(i);
		}
		cmbNam = new JComboBox<String>(years);
		cmbNam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cmbNam.setBounds(149, 60, 242, 32);
		panel_1.add(cmbNam);
		
		btnThang = new JButton("Thống kê theo tháng");
		btnThang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnThang.setBounds(445, 14, 292, 33);
		panel_1.add(btnThang);
		
		JLabel lblNgayHT = new JLabel("Ngày hiện tại: ");
		lblNgayHT.setHorizontalAlignment(SwingConstants.LEFT);
		lblNgayHT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgayHT.setBounds(846, 11, 152, 36);
		panel_1.add(lblNgayHT);
		
		txtNgayHienTai = new javax.swing.JTextField(sdf.format(new Date()));
		txtNgayHienTai.setEditable(false);
		txtNgayHienTai.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNgayHienTai.setForeground(Color.BLACK);
		txtNgayHienTai.setHorizontalAlignment(SwingConstants.LEFT);
		txtNgayHienTai.setBounds(1100, 11, 190, 36);
		panel_1.add(txtNgayHienTai);
		txtNgayHienTai.setColumns(10);
		
		String[] header = {"STT","Mã Phim","Tên phim", "Ngày lập hoá đơn" ,"Số buổi chiếu","Sỗ vé bán ra","Tổng doanh thu (VNĐ)"};
		Font headerFont = new Font("Arial", Font.BOLD, 17);
		modelTableThongKeDT = new DefaultTableModel(header,0);		
		tableThongKeDT = new JTable(modelTableThongKeDT);	
		tableThongKeDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableThongKeDT.getTableHeader().setFont(headerFont);
		tableThongKeDT.setRowHeight(35); 
		TableColumnModel columnModel = tableThongKeDT.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);
		columnModel.getColumn(2).setPreferredWidth(250); 
		columnModel.getColumn(6).setPreferredWidth(200);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "B\u1EA3ng Th\u1ED1ng K\u00EA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(12, 173, 1513, 426);
		panel_1.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

	
		JScrollPane scrollPane = new JScrollPane(tableThongKeDT);
		scrollPane.setBounds(225, 125, 1418, 514);
		panel_4.add(scrollPane); 
		
		duLieuDoanhThu();
		
		btnNam = new JButton("Thống kê theo năm");
		btnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNam.setBounds(445, 63, 292, 33);
		panel_1.add(btnNam);
		
		JLabel lblDTThangHT = new JLabel("Doanh thu tháng hiện tại: ");
		lblDTThangHT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDTThangHT.setBounds(846, 62, 242, 32);
		panel_1.add(lblDTThangHT);
		
		txtDTHT = new JTextField();
		txtDTHT.setEditable(false);
		txtDTHT.setForeground(Color.GRAY);
		txtDTHT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtDTHT.setBounds(1100, 67, 190, 31);
		panel_1.add(txtDTHT);
		txtDTHT.setColumns(10);	
		
		DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
		double doanhThu = tk_dao.doanhThuThangHienTai();
		txtDTHT.setText(decimalFormat.format(doanhThu));
		
		JPanel pKhachHang = new JPanel();
		tabbedPane.addTab("Thống Kê Khách Hàng", null, pKhachHang, null);
		pKhachHang.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		pKhachHang.add(panel_2, BorderLayout.NORTH);
		
		JLabel lblTitleKH = new JLabel("Thống Kê Khách Hàng");
		lblTitleKH.setForeground(Color.BLUE);
		lblTitleKH.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		panel_2.add(lblTitleKH);
		
		JPanel panel_3 = new JPanel();
		pKhachHang.add(panel_3, BorderLayout.CENTER);
		
		String[] header1 = {"STT","Mã khách hàng","Tên khách hàng","Số lần xem phim","Sỗ vé đã mua","Tổng tiền"};
		Font headerFont1 = new Font("Arial", Font.BOLD, 17);
		modelTableThongKeKH = new DefaultTableModel(header1,0);		
		tableThongKeKH = new JTable(modelTableThongKeKH);	
		tableThongKeKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableThongKeKH.getTableHeader().setFont(headerFont1);
		tableThongKeKH.setRowHeight(35);    
	
		JScrollPane scrollPane1 = new JScrollPane(tableThongKeKH);
		scrollPane1.setBounds(21, 10, 1504, 604);
		scrollPane.setBounds(32, 124, 1300, 514);
		panel_3.setLayout(null);
		
		panel_3.add(scrollPane1); 
		
		btnThang.addActionListener(this);
		btnNam.addActionListener(this);
		btnXemAll.addActionListener(this);
		
		tableThongKeDT.addMouseListener(this);
	}
		
	public void xoaDuLieu() {
		DefaultTableModel dm = (DefaultTableModel) tableThongKeDT.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	public void duLieuDoanhThu() {
		List<Object[]> list = tk_dao.doanhThu();;		
		for (Object[] tkdt : list) {		
			modelTableThongKeDT.addRow(tkdt);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		boolean thangTimThay = false;
		boolean namTimThay = false;
		if(o.equals(btnThang)) {		
			if (cmbThang.getSelectedIndex() == 0) {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn tháng!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        return;
		    }
			cmbNam.setSelectedItem(cmbNam.getItemAt(0));
			xoaDuLieu();			
			int thang = Integer.parseInt(cmbThang.getSelectedItem().toString());
			List<Object[]> list = tk_dao.doanhThuTheoThang(thang);;
			
			for (Object[] tkdt : list) {		
				modelTableThongKeDT.addRow(tkdt);
				thangTimThay = true;
			}
			if (!thangTimThay) {
		        JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu trong tháng " + thang + "!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		    }
		} else if(o.equals(btnNam)) {
			if (cmbNam.getSelectedIndex() == 0) {
		        JOptionPane.showMessageDialog(this, "Vui lòng chọn Năm!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		        return;
		    }
			cmbThang.setSelectedItem(cmbThang.getItemAt(0));
			xoaDuLieu();			
			int nam = Integer.parseInt(cmbNam.getSelectedItem().toString());
			List<Object[]> list = tk_dao.doanhThuTheoNam(nam);;
			
			for (Object[] tkdt : list) {		
				modelTableThongKeDT.addRow(tkdt);
				namTimThay = true;
			}
			if (!namTimThay) {
		        JOptionPane.showMessageDialog(this, "Không tìm thấy dữ liệu trong năm " + nam + "!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		    }
		} else if(o.equals(btnXemAll)) {
			cmbNam.setSelectedItem(cmbNam.getItemAt(0));
			cmbThang.setSelectedItem(cmbThang.getItemAt(0));
			xoaDuLieu();
			duLieuDoanhThu();
		}
		
	}
}

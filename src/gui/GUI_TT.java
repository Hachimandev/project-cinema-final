package gui;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.ImageIcon;

import entity.LoaiNhanVien;
import entity.NhanVien;
import javax.swing.border.TitledBorder;

import dao.LoaiNhanVien_DAO;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;


public class GUI_TT extends javax.swing.JPanel {
	private NhanVien emp;
	private LoaiNhanVien lnv; 
	private LoaiNhanVien_DAO lnv_dao; 
	
	private SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private String layNgayHienTai() {
		Date ngayHienTai = new Date();
		return sdf.format(ngayHienTai);
	}
	
  
    public GUI_TT(NhanVien emp) {
        this.emp = emp;
        lnv_dao = new LoaiNhanVien_DAO(); 
        lnv = lnv_dao.layLoaiNV(emp.getMaLoaiNV().getMaLoaiNhanVien()); 
    	initComponents();
        XinChao.setText("Xin chào: "+emp.getTenNhanVien());
    }

    private void initComponents() {

        pnlBTN = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon(new ImageIcon("E:\\Mon_Hoc_Truong\\4 HuongSuKien\\SaveProject\\QuanLyRapPhim\\img\\avatar.jpg"));
        jPanel8 = new javax.swing.JPanel();
        XinChao = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField("Ngày hiện nay: " + layNgayHienTai());
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Th\u00F4ng Tin", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(0, 128, 255)));

        setLayout(new java.awt.BorderLayout());

        pnlBTN.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 102));
        jLabel1.setText("Rạp CGV");
        jPanel1.add(jLabel1);
        jPanel1.add(filler2);

        pnlBTN.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 80, 8, 8));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setMaximumSize(new java.awt.Dimension(200, 500));
        jPanel3.setMinimumSize(new java.awt.Dimension(200, 218));
        jPanel3.setPreferredSize(new java.awt.Dimension(200, 372));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel7.setMaximumSize(new java.awt.Dimension(200, 200));
        jPanel7.setMinimumSize(new java.awt.Dimension(200, 200));
        jPanel7.setPreferredSize(new java.awt.Dimension(200, 200));
        jPanel7.setLayout(new java.awt.BorderLayout());

//        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nhanvien/avatar1.png"))); // NOI18N
        jPanel7.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        XinChao.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        XinChao.setForeground(new java.awt.Color(0, 0, 153));
//        XinChao.setText("Xin chào, Nguyễn Thành Luân");

        jTextField1.setEditable(false);
        jTextField1.setMaximumSize(new java.awt.Dimension(100, 2147483647));
        jTextField1.setMinimumSize(new java.awt.Dimension(100, 22));
        jTextField1.setOpaque(true);
        jTextField1.setPreferredSize(new java.awt.Dimension(180, 35));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XinChao)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(XinChao)
                .addGap(34, 34, 34)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 80, 10, 20));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setMinimumSize(new java.awt.Dimension(1090, 120));
        jPanel6.setPreferredSize(new java.awt.Dimension(200, 70));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(15, 102, 165));
        jLabel4.setText("Quản Lí Rạp Phim");
        jPanel6.add(jLabel4);

        jPanel4.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel5.setPreferredSize(new java.awt.Dimension(1500, 533));

        jPanel4.add(jPanel5, java.awt.BorderLayout.CENTER);
        jPanel5.setLayout(new GridLayout(1, 0, 0, 0));
        
        JPanel panel = new JPanel();
        jPanel5.add(panel);
        panel.setLayout(null);
        
        lblNewLabel = new JLabel("Mã Đăng Nhập");
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(36, 37, 235, 48);
        panel.add(lblNewLabel);
        
        textField = new JTextField();
        textField.setEditable(false);
        textField.setBounds(294, 37, 235, 47);
        panel.add(textField);
        textField.setColumns(10);
        textField.setText(emp.getMaNhanVien());
        
        
        lblHVTn = new JLabel("Họ và Tên");
        lblHVTn.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        lblHVTn.setBounds(36, 95, 235, 48);
        panel.add(lblHVTn);
        
        textField_1 = new JTextField();
        textField_1.setEditable(false);
        textField_1.setColumns(10);
        textField_1.setBounds(294, 95, 235, 47);
        textField_1.setText(emp.getTenNhanVien());
        panel.add(textField_1);
        
        
        lblSinThoi = new JLabel("Số Điện Thoại");
        lblSinThoi.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        lblSinThoi.setBounds(36, 152, 235, 48);
        panel.add(lblSinThoi);
        
        textField_2 = new JTextField();
        textField_2.setEditable(false);
        textField_2.setColumns(10);
        textField_2.setBounds(294, 152, 235, 47);
        textField_2.setText(emp.getSoDienThoai());
        panel.add(textField_2);
        
        
        lblCccd = new JLabel("CCCD");
        lblCccd.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        lblCccd.setBounds(36, 209, 235, 48);
        panel.add(lblCccd);
        
        textField_3 = new JTextField();
        textField_3.setEditable(false);
        textField_3.setColumns(10);
        textField_3.setBounds(294, 209, 235, 47);
        textField_3.setText(emp.getCMD());
        panel.add(textField_3);
        
        
        lblChngV = new JLabel("Chứng Vụ");
        lblChngV.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
        lblChngV.setBounds(36, 266, 235, 48);
        panel.add(lblChngV);
        
        textField_4 = new JTextField();
        textField_4.setEditable(false);
        textField_4.setColumns(10);
        textField_4.setBounds(294, 266, 235, 47);
        textField_4.setText(lnv.getTenLoaiNhanVien());
        panel.add(textField_4);
        
        JPanel panel_1 = new JPanel();
        jPanel5.add(panel_1);
        panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
        
        JLabel lblNewLabel_1 = new JLabel("");
        panel_1.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon("E:\\Mon_Hoc_Truong\\4 HuongSuKien\\SaveProject\\QuanLyRapPhim\\img\\logo.png"));

        jPanel2.add(jPanel4);

        pnlBTN.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(pnlBTN, java.awt.BorderLayout.CENTER);
    }

    private javax.swing.JLabel XinChao;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel pnlBTN;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblHVTn;
    private JTextField textField_2;
    private JLabel lblSinThoi;
    private JTextField textField_3;
    private JLabel lblCccd;
    private JTextField textField_4;
    private JLabel lblChngV;
}

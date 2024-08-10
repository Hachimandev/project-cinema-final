package gui;

import java.awt.Toolkit;
import java.security.NoSuchAlgorithmException;

import javax.swing.JOptionPane;

import dao.NhanVien_DAO;
import dao.TaiKhoanNV_DAO;
import entity.NhanVien;
import entity.TaiKhoanNV;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;


public class GUI_Login extends javax.swing.JFrame {
	private static TaiKhoanNV taiKhoan;
    /**
     * Creates new form GUI_Login
     */
	public void dangNhap() {
		String username = txtUser.getText().trim();
		String password = txtPassword.getText().trim();
		TaiKhoanNV_DAO tk_dao = new TaiKhoanNV_DAO(); 
		NhanVien_DAO nv_dao = new NhanVien_DAO(); 
		taiKhoan = tk_dao.layTaiKhoan(username);
		NhanVien nv = nv_dao.layNhanVien(username); 
		
		try {
			if (taiKhoan == null) {
				Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên nào có mã vừa nhập");
			} else {
				if(password.equals(taiKhoan.getMatKhau().trim())) {
					if(nv.getMaLoaiNV().getMaLoaiNhanVien().equals("LNV001")) { 
						GUI_TrangChu_NV gui_nv = new GUI_TrangChu_NV(nv); 
						gui_nv.setVisible(true);
						setVisible(false);
					}
					if(nv.getMaLoaiNV().getMaLoaiNhanVien().equals("LNV002")) { 
						GUI_TrangChu_QL gui_ql = new GUI_TrangChu_QL(nv); 
						gui_ql.setVisible(true);
						setVisible(false);
					}
				}
				
				else { 
					JOptionPane.showMessageDialog(txtPassword, "Mật khẩu bạn nhập chưa đúng", "Cảnh báo",
					JOptionPane.WARNING_MESSAGE);
				}		
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Tài Khoản Chưa Được Xác Nhận");
		}
	}
	
    public GUI_Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setIcon(new ImageIcon("E:\\Mon_Hoc_Truong\\4 HuongSuKien\\SaveProject\\QuanLyRapPhim\\img\\logo.png"));
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel13.setPreferredSize(new java.awt.Dimension(900, 1));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel13, java.awt.BorderLayout.SOUTH);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(15, 145, 239));
        jLabel1.setText("Quản Lý Bán Vé");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jPanel3.setPreferredSize(new java.awt.Dimension(449, 572));
        jPanel3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
//        try {
//            jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("img/logo.jpg")));
//        } catch (Exception e) {	
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Không thể tải hình ảnh!");
//        }
        
        jPanel3.add(jLabel2);

        jPanel2.add(jPanel3);

        jPanel5.setBackground(new java.awt.Color(15, 145, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1, 572));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 15, 1, 30));
        jPanel4.setPreferredSize(new java.awt.Dimension(450, 572));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 1, 20, 1));
        jPanel8.setLayout(new java.awt.GridLayout(2, 1));

        jPanel9.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1));
        jPanel9.setLayout(new java.awt.GridLayout(3, 1));
        jPanel9.add(jLabel6);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 3, 12)); 
        jLabel5.setText("User name:");
        jPanel9.add(jLabel5);

        txtUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtUser.setText("NV001");
        jPanel9.add(txtUser);

        jPanel8.add(jPanel9);

        jPanel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 20, 1));
        jPanel10.setLayout(new java.awt.GridLayout(3, 0));
        jPanel10.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 3, 12)); 
        jLabel8.setText("Password:");
        jPanel10.add(jLabel8);

        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        txtPassword.setText("Quanlybanve01");
        jPanel10.add(txtPassword);

        jPanel8.add(jPanel10);

        jPanel4.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.PAGE_AXIS));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        jLabel3.setText("Chào mừng đã trở lại!");
        jPanel6.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); 
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Hãy đăng nhập để tiếp tục công việc của bạn");
        jPanel6.add(jLabel4);

        jPanel4.add(jPanel6, java.awt.BorderLayout.PAGE_START);

        jPanel7.setPreferredSize(new java.awt.Dimension(405, 160));
        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        jPanel11.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 5));

        btnLogin.setBackground(new java.awt.Color(15, 145, 239));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Đăng nhập");
        btnLogin.setPreferredSize(new java.awt.Dimension(180, 45));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel11.add(btnLogin);

        btnCancel.setBackground(new java.awt.Color(15, 145, 239));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // 
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Thoát");
        btnCancel.setPreferredSize(new java.awt.Dimension(180, 45));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel11.add(btnCancel);

        jPanel7.add(jPanel11);

        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 3, 12)); 
        jLabel9.setText("Cinema: CGV");
        jPanel12.add(jLabel9);

        jPanel7.add(jPanel12);

        jPanel4.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        jPanel2.add(jPanel4);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        dangNhap();
    }

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
       System.exit(0);
    }
    

    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    
}

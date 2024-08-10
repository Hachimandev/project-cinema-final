package gui;

import java.sql.SQLException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import entity.NhanVien;


public class GUI_TrangChu_QL extends javax.swing.JFrame {

	private NhanVien emp;
	
	private GUI_Login gui_login;
	private GUI_TT gui_BTN;
	private GUI_LichChieu gui_LichChieu; 
	private GUI_QuanLyNhanVien gui_NhanVien; 
	private GUI_ThongKeDoanhThu gui_ThongKe; 
	private GUI_QuanLyPhim gui_TaoPhim; 
	
    public GUI_TrangChu_QL(NhanVien nv) throws SQLException {
        initComponents();
        this.emp = nv;
        gui_BTN = new GUI_TT(emp);
        gui_LichChieu = new GUI_LichChieu();
        gui_NhanVien = new GUI_QuanLyNhanVien(); 
        gui_ThongKe = new GUI_ThongKeDoanhThu(); 
        gui_TaoPhim = new GUI_QuanLyPhim(); 
        
        this.PnlChuyenHuong.add(gui_BTN);
        // 
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void initComponents() {

        PnlChuyenHuong = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnDangXuat = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        
        jMenuBar1 = new javax.swing.JMenuBar();
        
        menuTT = new javax.swing.JMenu();
        menuHD = new javax.swing.JMenu();
        menuVP = new javax.swing.JMenu();
        menuKH = new javax.swing.JMenu();
        menuTK = new javax.swing.JMenu();
        menuPhim = new javax.swing.JMenu(); 
        menuNhanVien = new javax.swing.JMenu();
        menuLichChieu = new javax.swing.JMenu();
        
        menuTaoHD = new javax.swing.JMenuItem();
        menuXemDSHD = new javax.swing.JMenuItem();
        menuTaoVe = new javax.swing.JMenuItem();
        ql = new javax.swing.JMenuItem();
        menuQuanLiTK = new javax.swing.JMenuItem();
        menuTaoPhim = new javax.swing.JMenuItem();
        menuTaoNhanVien = new javax.swing.JMenuItem();
        menuTaoLichChieu = new javax.swing.JMenuItem();
        menuTrangChu = new javax.swing.JMenuItem();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlChuyenHuong.setBackground(new java.awt.Color(255, 255, 255));
        PnlChuyenHuong.setLayout(new java.awt.BorderLayout());
        getContentPane().add(PnlChuyenHuong, java.awt.BorderLayout.CENTER);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jPanel5.setMinimumSize(new java.awt.Dimension(222, 52));
        jPanel5.setPreferredSize(new java.awt.Dimension(302, 52));
        jPanel5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 10, 5));

        btnDangXuat.setBackground(new java.awt.Color(15, 145, 239));
        btnDangXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(255, 255, 255));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setMargin(new java.awt.Insets(1, 14, 1, 14));
        btnDangXuat.setPreferredSize(new java.awt.Dimension(120, 40));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jPanel5.add(btnDangXuat);

        btnThoat.setBackground(new java.awt.Color(15, 145, 239));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Trở về");
        btnThoat.setMargin(new java.awt.Insets(1, 14, 1, 14));
        btnThoat.setPreferredSize(new java.awt.Dimension(120, 40));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel5.add(btnThoat);
        jPanel5.add(filler1);

        getContentPane().add(jPanel5, java.awt.BorderLayout.SOUTH);
        
        jMenuBar1.setBackground(new java.awt.Color(204, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jMenuBar1.setMargin(new java.awt.Insets(0, 8, 0, 8));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(23941, 50));

        // Trang Chu
        menuTT.setForeground(new java.awt.Color(15, 145, 239));
        menuTT.setText("Trang chủ");
        menuTT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTT.setMargin(new java.awt.Insets(3, 10, 3, 10));
        menuTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTTActionPerformed(evt);
            }
        });	
        menuTrangChu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTrangChu.setText("Trang Chủ");
        menuTrangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuTTActionPerformed(evt);
            }
        });
        menuTT.add(menuTrangChu); 
        jMenuBar1.add(menuTT);
        
        // Hoa Don
        menuHD.setForeground(new java.awt.Color(15, 145, 239));
        menuHD.setText("Hóa đơn");
        menuHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuHD.setMargin(new java.awt.Insets(3, 10, 3, 10));

        menuTaoHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTaoHD.setText("Tạo hóa đơn");
        menuTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuTaoHDActionPerformed(evt);
            }
        });
        menuHD.add(menuTaoHD);
    
        menuXemDSHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuXemDSHD.setText("Xem danh sách hóa đơn");
        menuXemDSHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuXemDSHDActionPerformed(evt);
            }
        });
        menuHD.add(menuXemDSHD);
//        jMenuBar1.add(menuHD);

        // Ve 
        menuVP.setForeground(new java.awt.Color(15, 145, 239));
        menuVP.setText("Vé Phim");
        menuVP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuVP.setMargin(new java.awt.Insets(3, 10, 3, 10));

        menuTaoVe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTaoVe.setText("Tạo Vé Phim");
        menuTaoVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuDanhSachThuocActionPerformed(evt);
            }
        });
        menuVP.add(menuTaoVe); 
//        jMenuBar1.add(menuVP);
        
        // Phim
        menuPhim.setForeground(new java.awt.Color(15, 145, 239));
        menuPhim.setText("Phim");
        menuPhim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuPhim.setMargin(new java.awt.Insets(3, 10, 3, 10));

        menuTaoPhim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTaoPhim.setText("Tạo Phim");
        menuTaoPhim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	menuTaoPhimActionPerformed(evt); 
            }
        });
        menuPhim.add(menuTaoPhim); 
        jMenuBar1.add(menuPhim);
        
        // Khach Hang
        menuKH.setForeground(new java.awt.Color(15, 145, 239));
        menuKH.setText("Khách hàng");
        menuKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuKH.setMargin(new java.awt.Insets(3, 10, 3, 10));
        menuKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuKHActionPerformed(evt);
            }
        });

        ql.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ql.setText("Thông tin khách hàng");
        ql.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                qlActionPerformed(evt);
            }
        });
        menuKH.add(ql);

//        jMenuBar1.add(menuKH);
        // Nhan Vien
        menuNhanVien.setForeground(new java.awt.Color(15, 145, 239));
        menuNhanVien.setText("Nhân Viên");
        menuNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuNhanVien.setMargin(new java.awt.Insets(3, 10, 3, 10));
        menuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuTKActionPerformed(evt);
            }
        });

        menuTaoNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTaoNhanVien.setText("Tạo Nhân Viên");
        menuTaoNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhanVienActionPerformed(evt);
            }
        });
        menuNhanVien.add(menuTaoNhanVien);

        jMenuBar1.add(menuNhanVien);
        // Lịch Chieu
        menuLichChieu.setForeground(new java.awt.Color(15, 145, 239));
        menuLichChieu.setText("Lịch Chiếu");
        menuLichChieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuLichChieu.setMargin(new java.awt.Insets(3, 10, 3, 10));
        menuLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuTKActionPerformed(evt);
            }
        });

        menuTaoLichChieu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTaoLichChieu.setText("Tạo Lịch Chiếu");
        menuTaoLichChieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLichChieuActionPerformed(evt); 
            }
        });
        menuLichChieu.add(menuTaoLichChieu);
        jMenuBar1.add(menuLichChieu);
        
        // Thong ke
        menuTK.setForeground(new java.awt.Color(15, 145, 239));
        menuTK.setText("Thống kê");
        menuTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuTK.setMargin(new java.awt.Insets(3, 10, 3, 10));
        menuTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                menuTKActionPerformed(evt);
            }
        });

        menuQuanLiTK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        menuQuanLiTK.setText("Quản lí thông kê");
        menuQuanLiTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuanLiTKActionPerformed(evt);
            }
        });
        menuTK.add(menuQuanLiTK);

        jMenuBar1.add(menuTK);

        setJMenuBar(jMenuBar1);

        pack();
    }
    
	public void clearSelectedMenu() {
		menuTT.setSelected(false);
		menuHD.setSelected(false);
		menuVP.setSelected(false);
		menuKH.setSelected(false);
		menuTK.setSelected(false);
	}
    
	public void thayDoiPanelChinh(JComponent component, JMenuItem menu) {
		clearSelectedMenu();
		menu.setSelected(true);
		this.PnlChuyenHuong.removeAll();
		this.PnlChuyenHuong.repaint();
		this.PnlChuyenHuong.revalidate();

		this.PnlChuyenHuong.add(component);
		this.PnlChuyenHuong.repaint();
		this.PnlChuyenHuong.revalidate();
	}
	
	//// su kien 
    private void menuTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTTActionPerformed
    	this.thayDoiPanelChinh(gui_BTN, menuTrangChu);
    }
    
    private void menuLichChieuActionPerformed(java.awt.event.ActionEvent evt) {
    	this.thayDoiPanelChinh(gui_LichChieu, menuTaoLichChieu);
    }
    
    private void menuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {
    	this.thayDoiPanelChinh(gui_NhanVien, menuTaoNhanVien);
    }
    
    private void menuQuanLiTKActionPerformed(java.awt.event.ActionEvent evt) { 
    	this.thayDoiPanelChinh(gui_ThongKe, menuQuanLiTK);
    }
    
    private void menuTaoPhimActionPerformed(java.awt.event.ActionEvent evt) {
    	this.thayDoiPanelChinh(gui_TaoPhim, menuTaoPhim);
    }
    
    ///// Sự kiện nút
    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {
    	int confirmed = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc chắn muốn đăng xuất không?", "Xác nhận đăng xuất",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    	if (confirmed == JOptionPane.YES_OPTION) {
    		this.dispose(); 
    		gui_login = new GUI_Login();
    		gui_login.setVisible(true);
    	}
    }
    
    
    
    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {
        this.thayDoiPanelChinh(gui_BTN, menuTrangChu);
    }


    // Variables 
    private javax.swing.JPanel PnlChuyenHuong;
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnThoat;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JMenu menuHD;
    private javax.swing.JMenu menuKH;
    private javax.swing.JMenu menuVP;
    private javax.swing.JMenu menuTK;
    private javax.swing.JMenu menuTT;
    private javax.swing.JMenu menuPhim; 
    private javax.swing.JMenu menuNhanVien;
    private javax.swing.JMenu menuLichChieu;
    private javax.swing.JMenuItem menuTaoVe;
    private javax.swing.JMenuItem menuQuanLiTK;
    private javax.swing.JMenuItem menuTaoHD;
    private javax.swing.JMenuItem menuXemDSHD;
    private javax.swing.JMenuItem menuTaoPhim;
    private javax.swing.JMenuItem menuTaoNhanVien; 
    private javax.swing.JMenuItem menuTaoLichChieu;
    private javax.swing.JMenuItem menuTrangChu;
    private javax.swing.JMenuItem ql;

}


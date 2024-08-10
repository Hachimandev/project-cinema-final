package gui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;

import entity.NhanVien;
import entity.VePhim;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;

public class GUI_InVe extends JFrame {

	/**
	 * Create the panel.
	 */
	public GUI_InVe(VePhim vp, NhanVien emp) {
		this.setSize(334, 357);
		getContentPane().setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Loại Vé");
		lblNewLabel.setBounds(10, 45, 74, 13);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phim");
		lblNewLabel_1.setBounds(10, 114, 74, 13);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Lịch Chiếu");
		lblNewLabel_2.setBounds(10, 91, 74, 13);
		panel.add(lblNewLabel_2);
		
		JLabel textLoaiVe = new JLabel(vp.getMaloaiVe().getTenLoaiVe());
		textLoaiVe.setBounds(130, 45, 166, 13);
		panel.add(textLoaiVe);
		
		JLabel textPhim = new JLabel(vp.getMaPhim().getTenPhim());
		textPhim.setBounds(130, 114, 166, 13);
		panel.add(textPhim);
		
		JLabel textLichChieu = new JLabel(vp.getMaLichChieu().getThoiGianChieu().toString() + " " + vp.getMaLichChieu().getNgayChieu().toString());
		textLichChieu.setBounds(130, 91, 117, 13);
		panel.add(textLichChieu);
		
		JLabel lblNewLabel_8 = new JLabel("Thẻ Vào Phòng Chiếu");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_8.setBounds(80, 10, 172, 13);
		panel.add(lblNewLabel_8);
		
		JLabel textNguoiLap = new JLabel(emp.getTenNhanVien());
		textNguoiLap.setBounds(128, 68, 168, 13);
		panel.add(textNguoiLap);
		
		JLabel lblNewLabel_5 = new JLabel("Người Lập");
		lblNewLabel_5.setBounds(10, 68, 74, 13);
		panel.add(lblNewLabel_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Giá");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(4, 90, 71, 25);
		panel_1.add(lblNewLabel_4);
		
		JLabel textGia = new JLabel(vp.getGia()+ "");
		textGia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textGia.setBounds(85, 93, 112, 19);
		panel_1.add(textGia);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("E:\\Mon_Hoc_Truong\\4 HuongSuKien\\SaveProject\\QuanLyRapPhim\\img\\logoNho.png"));
		lblNewLabel_6.setBounds(162, 10, 148, 132);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Cảm ơn bạn đã đến !!!!");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_7.setBounds(4, 125, 282, 25);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_3 = new JLabel("Ghế");
		lblNewLabel_3.setBounds(4, 23, 74, 22);
		panel_1.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		
		JLabel textGhe = new JLabel(vp.getMaGhe().getMaGhe());
		textGhe.setBounds(90, 23, 117, 22);
		panel_1.add(textGhe);
		textGhe.setFont(new Font("Tahoma", Font.PLAIN, 20));

	}
}

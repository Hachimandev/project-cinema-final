package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.Ghe_DAO;
import entity.Ghe;
import entity.LichChieu;
import java.awt.Font;

public class GUI_ChonGhe extends JFrame {
	private Ghe_DAO ghe_dao = new Ghe_DAO();
	private ArrayList<Ghe> listGhe;
	private LichChieu lichChieu;

	public GUI_ChonGhe(JTextField targetTextField, LichChieu lc) {
		setTitle("Chọn Ghế");
		setSize(587, 515); // Cỡ của cửa sổ có thể thay đổi tùy ý
//        getContentPane().setLayout(new GridLayout(0, 6)); // Giả sử có 6 ghế mỗi hàng
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout());
		lichChieu = lc;
		listGhe = ghe_dao.getDanhSachGheTheoPhongChieu(lichChieu.getPhongChieu().getMaPhongChieu());

		JPanel seatsPanel = new JPanel(new GridLayout(0, 6)); // Giả sử có 6 ghế mỗi hàng

		for (Ghe pro : listGhe) {
			JButton btn = new JButton(pro.getMaGhe());
			if (pro.isTrangThai() == false) {
				btn.setEnabled(false);
				btn.setUI(new javax.swing.plaf.basic.BasicButtonUI()); // Ghi đè L&F
				btn.setBackground(Color.RED); // Màu nền vẫn giữ khi vô hiệu hóa

			}

			btn.addActionListener(e -> {
				targetTextField.setText(pro.getMaGhe());
				dispose(); // Đóng cửa sổ sau khi chọn
			});
			seatsPanel.add(btn);
		}

		// Tạo panel chứa chữ "Màn Hình"
		JPanel screenPanel = new JPanel();
		screenPanel.setBackground(Color.GRAY);
		JLabel label = new JLabel("Màn Hình");
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		screenPanel.add(label);
		screenPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Thêm padding xung quanh label

		// Thêm các panel vào frame
		getContentPane().add(screenPanel, BorderLayout.NORTH); // Thêm panel "Màn Hình" vào vùng North
		getContentPane().add(seatsPanel, BorderLayout.CENTER); // Thêm panel ghế vào vùng Center

	}

}

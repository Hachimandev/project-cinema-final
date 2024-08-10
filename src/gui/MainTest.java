package gui;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class MainTest {
	
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(new FlatMacLightLaf());
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		GUI_Login gui_login = new GUI_Login();
		gui_login.setVisible(true);
	}
}

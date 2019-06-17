package GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MyJButton extends JFrame {

	public ImageIcon icon;

	public MyJButton() {
		icon = new ImageIcon("H:/honorarpflichtig-Einmalige-Nutzun-13.jpg");
		JButton a = new JButton("back");
		JButton b = new JButton(icon);
		JButton c = new JButton("back", icon);
		Container cp = getContentPane();
		cp.add(BorderLayout.WEST, a);
		cp.add(BorderLayout.CENTER, b);
		cp.add(BorderLayout.EAST, c);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyJButton mjb = new MyJButton();
	}

}

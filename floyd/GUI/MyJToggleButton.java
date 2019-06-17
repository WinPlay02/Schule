package GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class MyJToggleButton extends JFrame {

	public ImageIcon icon, ic2;

	public MyJToggleButton() {
		icon = new ImageIcon("H:/honorarpflichtig-Einmalige-Nutzun-13.jpg");
		ic2 = new ImageIcon("H:/Download.jpg");
		JToggleButton a = new JToggleButton("back", icon);
		JToggleButton b = new JToggleButton("back", ic2);
		JToggleButton c = new JToggleButton("back", ic2);
		Container cp = getContentPane();
		cp.add(BorderLayout.WEST, a);
		cp.add(BorderLayout.CENTER, b);
		cp.add(BorderLayout.EAST, c);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyJToggleButton mjb = new MyJToggleButton();
	}

}

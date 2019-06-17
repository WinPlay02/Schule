package GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class MyJRadioButton extends JFrame {

	public ImageIcon icon, ic2;

	public MyJRadioButton() {
		icon = new ImageIcon(getClass().getResource("/GUI/plus.png"));
		ic2 = new ImageIcon(getClass().getResource("/GUI/kreuz.png"));
		JRadioButton a = new JRadioButton("s1");
		// a.setRolloverIcon(ic2);
		a.setSelectedIcon(icon);
		JRadioButton b = new JRadioButton("sre32", ic2);
		// b.setRolloverIcon(ic2);
		b.setSelectedIcon(icon);
		JRadioButton c = new JRadioButton("wow", ic2);
		ButtonGroup bg = new ButtonGroup();
		bg.add(a);
		bg.add(b);
		bg.add(c);
		// c.setRolloverIcon(ic2);
		c.setSelectedIcon(icon);
		Container cp = getContentPane();
		cp.add(BorderLayout.WEST, a);
		cp.add(BorderLayout.CENTER, b);
		cp.add(BorderLayout.EAST, c);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyJRadioButton mjb = new MyJRadioButton();
	}

}

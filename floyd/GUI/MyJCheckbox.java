package GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MyJCheckbox extends JFrame {

	public ImageIcon icon, ic2;

	public MyJCheckbox() {
		icon = new ImageIcon(getClass().getResource("/GUI/plus.png"));
		ic2 = new ImageIcon(getClass().getResource("/GUI/kreuz.png"));
		JCheckBox a = new JCheckBox("s1");
		a.setRolloverIcon(ic2);
		a.setSelectedIcon(icon);
		JCheckBox b = new JCheckBox("sre32", icon);
		b.setRolloverIcon(ic2);
		b.setSelectedIcon(icon);
		JCheckBox c = new JCheckBox("wow", ic2);
		c.setRolloverIcon(ic2);
		c.setSelectedIcon(icon);
		Container cp = getContentPane();
		cp.add(BorderLayout.WEST, a);
		cp.add(BorderLayout.CENTER, b);
		cp.add(BorderLayout.EAST, c);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		MyJCheckbox mjb = new MyJCheckbox();
	}

}

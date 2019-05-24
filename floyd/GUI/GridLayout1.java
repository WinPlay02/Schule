package GUI;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GridLayout1 {
	public static void main(String... args) {
		JFrame frame = new JFrame("GridLayout");
		frame.setLayout(new GridLayout(4, 5));
		Container c = frame.getContentPane();
		for (int i = 0; i <= 17; i++) {
			c.add(new JButton(String.valueOf(i)));
		}
		// letzte drei Befehle:
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}
}

package GUI;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BorderLayout1 {
	public static void main(String... args) {
		JFrame frame = new JFrame("BorderLayout");
		frame.setLayout(new BorderLayout());
		Container c = frame.getContentPane();
		c.add(clbl(new JLabel("North")), BorderLayout.NORTH);
		c.add(clbl(new JLabel("South")), BorderLayout.SOUTH);
		c.add(clbl(new JLabel("West")), BorderLayout.WEST);
		c.add(clbl(new JLabel("East")), BorderLayout.EAST);
		c.add(clbl(new JLabel("Center")), BorderLayout.CENTER);
		// letzte drei Befehle:
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	private static JLabel clbl(JLabel l) {
		l.setHorizontalAlignment(SwingConstants.CENTER);
		return l;
	}
}

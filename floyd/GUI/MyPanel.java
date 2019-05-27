package GUI;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyPanel extends JFrame {

	private static final long serialVersionUID = 3498370136425783181L;
	JPanel first = new JPanel();
	JPanel second = new JPanel();

	public static void main(String... args) {
		MyPanel mp = new MyPanel();
	}

	public MyPanel() {
		Container cp = this.getContentPane();
		cp.setLayout(new FlowLayout());
		first.setLayout(new BoredLayout());
		first.add(new JButton("North"), BoredLayout.NORTH);
		first.add(new JButton("West"), BoredLayout.WEST);
		first.add(new JButton("Center"), BoredLayout.CENTER);
		first.add(new JButton("East"), BoredLayout.EAST);
		first.add(new JButton("South"), BoredLayout.SOUTH);
		cp.add(first);
		//
		cp.add(new JLabel("ein einfaches Label"));
		//
		second.setLayout(new BrettGridLayout(2, 3));
		for (int i = 0; i < 3; i++) {
			JLabel lbl1 = new JLabel("Label " + i * 2);
			JLabel lbl2 = new JLabel("Label " + (i * 2 + 1));
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			second.add(lbl1);
			second.add(lbl2);
		}
		cp.add(second);
		setSize(500, 100);
		setVisible(true);
	}
}

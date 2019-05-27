package GUI;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MyPanel extends JPanel {

	JPanel first = new JPanel();
	JPanel second = new JPanel();

	public MyPanel() {
		Container cp = this;
		cp.setLayout(new FlowLayout());
		first.setLayout(new BoredLayout());
		first.add(new JButton("North"), BoredLayout.SOUTH);
		first.add(new JButton("West"), BoredLayout.WEST);
		first.add(new JButton("Center"), BoredLayout.CENTER);
		first.add(new JButton("East"), BoredLayout.EAST);
		first.add(new JButton("South"), BoredLayout.SOUTH);
		cp.add(first);
		//
	}
}

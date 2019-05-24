package GUI;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ButtonXpl {

	public static void main(String... args) {
		JFrame frame = new JFrame("Button example");
		frame.setLayout(new FlowLayout());
		Container c = frame.getContentPane();
		c.add(new JButton("Click me!"));
		c.add(new JButton("Ignore me!"));
		c.add(new JTextField("Type something! Please!"));

		// Programm soll sich beim Schließen des Fensters beenden
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 150);
		frame.setVisible(true);
	}

}

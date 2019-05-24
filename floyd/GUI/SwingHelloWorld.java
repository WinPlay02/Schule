package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class SwingHelloWorld {
	public static void main(String... args) {
		JFrame frame = new JFrame();
		frame.getContentPane().add(new JLabel("Hello, world!"));

		// Programm soll sich beim Schließen des Fensters beenden
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 100);
		frame.setVisible(true);
	}
}

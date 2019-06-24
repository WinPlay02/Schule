package GUI.sdf;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Anonymous extends JFrame {

	private static final long serialVersionUID = -5426075073416745067L;
	JButton button;

	public Anonymous() {
		Container cp = getContentPane();
		button = new JButton("Button 1");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Der Button...");
			}
		});
		cp.add(button);
		setSize(100, 100);
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String... args) {
		Anonymous anon = new Anonymous();
	}
}

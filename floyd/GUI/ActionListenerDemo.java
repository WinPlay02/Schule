package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ActionListenerDemo extends JFrame {
	private JButton button1, button2;
	private JTextField textfield;

	public ActionListenerDemo() {
		super("Button example");
		ButtonListener bl = new ButtonListener();
		button1 = new JButton("Click me!");
		button1.setActionCommand("First button");
		button1.addActionListener(bl);
		button2 = new JButton("Ignore me!");
		button2.setActionCommand("Second button");
		button2.addActionListener(bl);
		textfield = new JTextField("Type something! Please!");
		this.setLayout(new FlowLayout());
		Container c = getContentPane();
		c.add(button1);
		c.add(button2);
		c.add(textfield);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			textfield.setText(e.getActionCommand());
		}
	}

	public static void main(String[] args) {
		// TODO Automatisch generierter Methodenstub
		JFrame frame = new ActionListenerDemo();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 150);
		frame.setVisible(true);

	}

}

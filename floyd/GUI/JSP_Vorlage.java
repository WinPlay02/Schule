package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

public class JSP_Vorlage extends JFrame {

	public static void main(String... args) {
		SwingUtilities.invokeLater(() -> {
			JSP_Vorlage jsp = new JSP_Vorlage(args);
			jsp.setVisible(true);
		});
	}

	public JSP_Vorlage(String... args) {
		// (im Bild sichtbare) Menükomponenten erzeugen:
		JMenuBar menuBar = new JMenuBar();
		JMenu blMenu = new JMenu("Blinken");
		JMenuItem blLinks = new JMenuItem("Links");
		JRadioButtonMenuItem blSchnell = new JRadioButtonMenuItem("Schnell");
		// Verhalte der Komponenten durch ActionListener festlegen
		blLinks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		// zwei weitere ähnliche
		blMenu.add(blLinks);
		// zwei weitere ähnliche
		blMenu.addSeparator();
		// RadioButtons gruppieren:
		ButtonGroup bg = new ButtonGroup();
		bg.add(blSchnell);
		// ein weiteres ähnliches
		blSchnell.setSelected(true);
		blMenu.add(blSchnell);
		// ein weiteres ähnliches
		menuBar.add(blMenu);
		// getContentPane().add(menuBar);
		setJMenuBar(menuBar);
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

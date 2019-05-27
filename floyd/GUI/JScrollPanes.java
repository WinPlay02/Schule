package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingUtilities;

public class JScrollPanes extends JFrame {

	private static final long serialVersionUID = 3880397956968487406L;

	public static void main(String... args) {
		SwingUtilities.invokeLater(() -> {
			JScrollPanes jsp = new JScrollPanes(args);
			jsp.setVisible(true);
		});
	}

	JLabel auto_anzeige = null;

	public static String createAutoAnzeige(boolean links, boolean rechts, boolean schnell, boolean vorne,
			boolean hinten) {
		return "<html>" + "Links: " + String.valueOf(links) + "<br>Rechts: " + String.valueOf(rechts)
				+ (schnell ? "<br>[schnell]" : "<br>[langsam]") + "<br>Vorne: " + String.valueOf(vorne) + "<br>Hinten: "
				+ String.valueOf(hinten) + "</html>";
	}

	public JScrollPanes(String... args) {
		// (im Bild sichtbare) Menükomponenten erzeugen:
		JMenuBar menuBar = new JMenuBar();
		JMenu blMenu = new JMenu("Blinken");
		JMenu wiMenu = new JMenu("Winken");
		JMenu niMenu = new JMenu("Nicken");
		JMenuItem blLinks = new JMenuItem("Links");
		JMenuItem blRechts = new JMenuItem("Rechts");
		JMenuItem blBeidseitig = new JMenuItem("Beidseitig (Warnblinkanlage)");
		JRadioButtonMenuItem blSchnell = new JRadioButtonMenuItem("Schnell");
		JRadioButtonMenuItem blLangsam = new JRadioButtonMenuItem("Langsam");
		auto_anzeige = new JLabel("");
		// zwei weitere ähnliche
		blMenu.add(blLinks);
		blMenu.add(blRechts);
		blMenu.add(blBeidseitig);
		// zwei weitere ähnliche
		blMenu.addSeparator();
		// RadioButtons gruppieren:
		ButtonGroup bg = new ButtonGroup();
		bg.add(blSchnell);
		bg.add(blLangsam);
		// ein weiteres ähnliches
		blSchnell.setSelected(true);
		blMenu.add(blSchnell);
		blMenu.add(blLangsam);
		// ein weiteres ähnliches
		// Richtung
		JMenu blRichtung = new JMenu("Richtung");
		JCheckBoxMenuItem blVorne = new JCheckBoxMenuItem("vorne");
		JCheckBoxMenuItem blHinten = new JCheckBoxMenuItem("hinten");

		auto_anzeige.setText(createAutoAnzeige(blLinks.isSelected(), blRechts.isSelected(), blSchnell.isSelected(),
				blVorne.isSelected(), blHinten.isSelected()));
		// Verhalte der Komponenten durch ActionListener festlegen
		blLinks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auto_anzeige.setText(createAutoAnzeige(true, blRechts.isSelected(), blSchnell.isSelected(),
						blVorne.isSelected(), blHinten.isSelected()));
			}
		});
		blRechts.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auto_anzeige.setText(createAutoAnzeige(blLinks.isSelected(), true, blSchnell.isSelected(),
						blVorne.isSelected(), blHinten.isSelected()));
			}
		});
		blBeidseitig.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auto_anzeige.setText(createAutoAnzeige(true, true, blSchnell.isSelected(), blVorne.isSelected(),
						blHinten.isSelected()));
			}
		});
		blVorne.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auto_anzeige.setText(createAutoAnzeige(blLinks.isSelected(), blRechts.isSelected(),
						blSchnell.isSelected(), blVorne.isSelected(), blHinten.isSelected()));
			}
		});
		blHinten.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auto_anzeige.setText(createAutoAnzeige(blLinks.isSelected(), blRechts.isSelected(),
						blSchnell.isSelected(), blVorne.isSelected(), blHinten.isSelected()));
			}
		});
		blSchnell.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auto_anzeige.setText(createAutoAnzeige(blLinks.isSelected(), blRechts.isSelected(),
						blSchnell.isSelected(), blVorne.isSelected(), blHinten.isSelected()));
			}
		});
		blLangsam.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				auto_anzeige.setText(createAutoAnzeige(blLinks.isSelected(), blRechts.isSelected(),
						blSchnell.isSelected(), blVorne.isSelected(), blHinten.isSelected()));
			}
		});
		//
		blRichtung.add(blVorne);
		blRichtung.add(blHinten);
		//
		blMenu.addSeparator();
		blMenu.add(blRichtung);
		menuBar.add(wiMenu);
		menuBar.add(blMenu);
		menuBar.add(niMenu);
		// getContentPane().add(menuBar);
		setLayout(new BoredLayout());
		getContentPane().add(auto_anzeige, BoredLayout.CENTER);
		setJMenuBar(menuBar);
		setSize(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Auto (Menus)");
	}
}

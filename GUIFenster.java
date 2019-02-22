import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;

public class GUIFenster {

	public static Morse morse;

	public static void main(String... args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		morse = new Morse();
		JFrame morser = new JFrame();
		morser.setTitle("MorseAlphabet");
		morser.setSize(400, 500);

		JPanel contentpane = new JPanel();

		BoxLayout bl = new BoxLayout(contentpane, BoxLayout.Y_AXIS);
		contentpane.setLayout(bl);

		JTextField klarTextFeld = new JTextField();
		JPanel pane_klar = new JPanel();
		pane_klar.setLayout(new BorderLayout());
		pane_klar.add(klarTextFeld, BorderLayout.CENTER);
		pane_klar.setBorder(new TitledBorder("Klartext"));
		contentpane.add(pane_klar);

		JPanel button_pane = new JPanel();
		button_pane.setLayout(new BorderLayout());
		JButton button_encode = new JButton("Encodieren");
		button_pane.add(button_encode, BorderLayout.NORTH);
		JButton button_decode = new JButton("Decodieren");
		button_pane.add(button_decode, BorderLayout.SOUTH);

		contentpane.add(button_pane);

		JTextField codeTextFeld = new JTextField();
		JPanel pane_code = new JPanel();
		pane_code.setLayout(new BorderLayout());
		pane_code.add(codeTextFeld, BorderLayout.CENTER);
		pane_code.setBorder(new TitledBorder("Codiert"));
		contentpane.add(pane_code);

		morser.setContentPane(contentpane);
		//
		button_encode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String codetext = klarTextFeld.getText();
				String enc = morse.morseCodieren(codetext);
				codeTextFeld.setText(enc);
			}
		});

		button_decode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String codetext = codeTextFeld.getText();
				String enc = morse.morseDecodieren(codetext);
				klarTextFeld.setText(enc);
			}
		});
		morser.setVisible(true);
	}
}

package paket;
//http://www.tutego.de/blog/javainsel/2015/11/inselraus-die-zusatzkomponentenbibliothek-swingx/

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Brauerei {

	public static volatile JLabel nachricht = null;
	public static volatile int drunk = 0;
	public static Object MONITOR = new Object();
	volatile static Thread rh;

	public static void main(String... args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Random r2 = new Random();
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}
				JFrame jframe = new JFrame();
				jframe.setTitle("Brauerei");
				jframe.setVisible(true);
				jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jframe.setSize(new Dimension(640, 480));
				JPanel jp = new JPanel();
				jframe.setContentPane(jp);
				JButton kn = new JButton("Nachschenken");
				JLabel jl = new JLabel("Wer das drückt, füllt nach");
				jp.add(jl);
				jp.add(kn);
				JProgressBar jps = new JProgressBar();
				JButton aufex = new JButton("Auf EX!");
				aufex.setEnabled(false);
				nachricht = new JLabel("");
				aufex.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						drunk++;
						aufex.setEnabled(false);
						jps.setValue(0);
						MONITOR.notify();
						jp.updateUI();
						jp.repaint();
						jframe.repaint();
						if (drunk >= 10) {
							JOptionPane.showMessageDialog(
									null, "Du bist dicht !!! Du solltest die Brauerei verlassen :("
											+ System.lineSeparator() + "Gläser: " + drunk,
									"Error", JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				jp.add(aufex);
				jp.add(nachricht);
				jps.setSize(200, 50);
				kn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (jps.getValue() < 100) {
							jps.setValue(jps.getValue() + 10);

						} else {
							nachricht.setText("Das Glas ist voll, der Alk leert sich.");
							nachricht.repaint();
							nachricht.repaint();
							aufex.setEnabled(true);
							aufex.updateUI();
							aufex.repaint();
							jp.updateUI();
							jp.repaint();
							jframe.repaint();
						}
					}
				});

				Runnable r = () -> {
					while (true) {
						try {
							MONITOR.wait(5000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
							System.out.println("Vorzeitiges Koma!");
						}
						jps.setValue((int) ((float) jps.getValue() - jps.getValue() * ((r2.nextInt(10) + 10) / 100f)));
						if (jps.getValue() <= 100) {
							aufex.setEnabled(false);
							aufex.repaint();
							aufex.updateUI();
						}
						if (jps.getValue() <= 0) {
							jps.setValue(0);
							// if (nachfuellen == null)
							nachricht.setText("Ich würde mal nachschenken...");
							// jp.add(nachfuellen);

							JOptionPane.showMessageDialog(null, "Viertel nach!");
							jp.updateUI();
							jp.repaint();
							jframe.repaint();
						}
					}
				};
				rh = new Thread(r);
				rh.start();
				jp.add(jps);
			}

		});

	}
}

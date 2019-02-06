package geschiffgens;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Sebastian Wagner
 * @author Malte Rudius
 * @author Winston Oberländer
 * @version v0.4-Omega
 * @see GEZ_Millionen
 * @see Eingabeaufforderung
 */
public class Kontodatenleseaufforderung {
	/**
	 * Interface um einen abstrakten Befehl zu repräsentieren.
	 * 
	 * @author Winston
	 *
	 */
	public static interface RunnableCommand {
		/**
		 * Gibt den Namen des Befehls wieder.
		 * 
		 * @return String den Namen des Befehls, kann Groß- und Kleinbuchstaben
		 *         enthalten; Bei der Registrierung wird der Name in Kleinbuchstaben
		 *         umgewandelt. Darf keine Leerzeichen enthalten.
		 */
		public String getName();

		/**
		 * Virtuelle Methode zum Aufrufen des Befehls von der Commandozeile
		 * 
		 * @param params
		 *            Die Parameter des Befehls. params[0] entspricht dem Namen des
		 *            Befehls mit originaler Schreibweise.
		 */
		public void execute(String[] params);

		/**
		 * Gibt dem Benutzer die Informationen über die Verwendung des Befehls.
		 * 
		 * @return String, der dem Benutzer angibt, wie der Befehl zu benutzen ist.
		 */
		public String getUsage();
	}

	protected static Map<String, RunnableCommand> commands = new HashMap<String, RunnableCommand>();

	/**
	 * Aufforderung zur Eingabe; Der auszugebende String.
	 */
	public static final String PROMPT_FOR_INPUT = "Geben Sie etwas ein> ";

	/**
	 * Alternative Aufforderung zur Eingabe; Der auszugebende String.
	 */
	public static final String PROMPT_FOR_INPUT2 = "Int> ";

	/**
	 * Öffnet eine Eingabeaufforderung; unterstützt bisher nur den 'exit' Befehl.
	 * 
	 * @param strings
	 */
	public static void main(String[] strings) {

		// Start
		System.out.print(PROMPT_FOR_INPUT);
		// neue Scanner Klasse deklarieren und instanzieren
		final Scanner scanner = new Scanner(System.in);
		// Befehl 'exit' registrieren; Beendet das Programm
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "exit";
			}

			@Override
			public void execute(String[] params) {
				System.out.println("Exit> ");
				scanner.close();
				System.exit(0);
			}

			@Override
			public String getUsage() {
				return getName();
			}
		});
		// Befehl 'random' registrieren; Gibt eine Zufallszahl im Bereich 0 - 500 aus
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "random";
			}

			@Override
			public void execute(String[] params) {
				System.out.println("Random> " + (int) (Math.random() * 500));
			}

			@Override
			public String getUsage() {
				return getName();
			}
		});
		// Ein Befehl von Malte
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "Hallola";
			}

			@Override
			public void execute(String[] params) {
				System.out.println("Systemoutput> " + "Deine Mutter.");
			}

			@Override
			public String getUsage() {
				return "\"" + getName() + "\"";
			}
		});
		// Ein weiterer Befehl von Malte
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "Gamehelper";
			}

			@Override
			public void execute(String[] params) {
				System.out.println(
						"Systemoutput> " + "https://www.woberlaender.de/gitlab/wfoasm-woma-net/gamehelper-mc-189");
			}

			@Override
			public String getUsage() {
				return getName();
			}
		});
		// Befehl zum Verschlüsseln -> Derzeitiges Thema Kryptografie
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "encrypt_caesar";
			}

			/**
			 * Verschlüsselt den gegebenen String um eine spezifizierte Rotation. Die
			 * Rotation bleibt im Alphabet und Unterstützt Groß- bzw. Kleinbuchstaben.
			 * 
			 * @param param
			 *            Der zu verschlüsselnde String.
			 * @param cesar_count
			 *            Die Zahl der Rotationen.
			 * @return Den Caesar-verschlüsselten String.
			 */
			String encryptString(String param, int cesar_count) {
				char[] c = new char[param.length()];
				param.getChars(0, param.length(), c, 0);
				for (int i = 0; i < c.length; i++) {
					char c_old = c[i];
					c[i] = (char) (c[i] + cesar_count % 26);
					if (c_old >= (int) 'A' && c_old <= (int) 'Z') { // uppercase
						while ((int) c[i] > (int) 'Z' || (int) c[i] < (int) 'A') {
							c[i] = (char) (c[i] - (cesar_count > 0 ? 26 : -26));
						}
					} else if (c_old >= (int) 'a' && c_old <= (int) 'z') { // lowercase
						while ((int) c[i] > (int) 'z' || (int) c[i] < (int) 'a') {
							c[i] = (char) (c[i] - (cesar_count > 0 ? 26 : -26));
						}
					}

				}
				return new String(c);
			}

			@Override
			public void execute(String[] params) {
				if (params.length <= 2) {
					System.out.println("Encrypt> " + "Keine Daten zum Verschlüsseln.");
					return;
				}
				int cesar_count = 0;
				try {
					cesar_count = Integer.parseInt(params[1]);
				} catch (NumberFormatException nfe) {
					System.out.println("Encrypt> '" + params[1] + "' ist keine Zahl.");
					return;
				}
				String[] array = new String[params.length - 2];
				for (int i = 0; i < params.length; i++) {
					if (i == 0 || i == 1)
						continue;
					else {
						array[i - 2] = encryptString(params[i], cesar_count);
					}
				}
				for (String s : array) {
					System.out.print(s + " ");
				}
				System.out.println();
			}

			@Override
			public String getUsage() {
				return getName() + " <Nummer der Rotationen> <Daten...>";
			}
		});
		// Hilfe-Befehl zum Anzeigen der verfügbaren Befehle mit Nutzungsinstruktionen
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "help";
			}

			@Override
			public void execute(String[] params) {
				System.out.println("Help> ");
				System.out.println("[Befehl: Benutzung]" + System.lineSeparator());
				for (Map.Entry<String, RunnableCommand> entry : commands.entrySet()) {
					System.out.println(
							String.format("%-20s %s", entry.getValue().getName() + ":", entry.getValue().getUsage()));
				}
			}

			@Override
			public String getUsage() {
				return getName();
			}

		});
		int value = 15 / 3;
		//
		registerCommand(new RunnableCommand() {

			@Override
			public String getUsage() {
				return "var_print";
			}

			@Override
			public String getName() {
				return "var_print";
			}

			@Override
			public void execute(String[] params) {
				System.out.println("Variable: " + value);
			}
		});
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "bestGirl";
			}

			@Override
			public void execute(String[] params) {
				System.out.println("Lacia ist BEST GIRL!");
			}

			@Override
			public String getUsage() {
				return "bestGirl";
			}
		});
		registerCommand(new RunnableCommand() {

			@Override
			public String getName() {
				return "trump";
			}

			@Override
			public void execute(String[] params) {
				System.out.println("Trump> We need to build a wall. You are fake news.");
			}

			@Override
			public String getUsage() {
				return "trump";
			}
		});
		// Hauptschleife; Solange Zeilen verfügbar sind
		while (scanner.hasNext()) {
			// Zeile in Variable lesen
			String line = scanner.nextLine();
			// Kommandos interpretieren
			interpretCommand(line);
			// Neue Aufforderung ausgeben
			System.out.print(PROMPT_FOR_INPUT);
		}
		// Rerssourcen freigeben
		scanner.close();
	}

	/**
	 * Methode zum Ausführen der abstrahierten Befehle
	 * 
	 * @param line
	 *            Eingelesene Zeile
	 */
	public static void interpretCommand(String line) {
		// Interface aus registrierten Commands lesen
		RunnableCommand rc = commands.get(line.toLowerCase().split(" ")[0]);
		// Testen ob Command vorhanden
		if (rc != null)
			// Wenn Vorhanden ausführen
			rc.execute(line.split(" "));
		else {
			// Testen ob zumindest genug Daten im Array für die folgende Operation ist
			if (line.toLowerCase().split("\"").length > 1) {
				// Andere möglichkeit für mehrwörtrige Befehle
				rc = commands.get(line.toLowerCase().split("\"")[1]);
				// Testen of Command vorhanden
				if (rc != null)
					// Wenn Vorhanden ausführen
					rc.execute(line.split(" "));
			} else
				// Wenn nicht 'Unbekannter Befehl' ausgeben
				System.out.println("Unbekannter Befehl: " + line);
		}
		// Eine Zeile Abstand nach jedem Prozess
		System.out.println();
	}

	/**
	 * Ein Befehl {@code RunnableCommand} wird registriert mithilfe seines Befehls
	 * in Kleinbuchstaben.
	 * 
	 * @param rc
	 *            Der zu registrierende Befehl
	 */
	public static void registerCommand(RunnableCommand rc) {
		// Füge den Befehl in die Map
		commands.put(rc.getName().toLowerCase(), rc);
	}
}

package zweidarrays;

public class GanzJahres {

	static void mitNichtsBefuellen(String[][][] kalender) {
		for (int monat = 0; monat < kalender.length; monat++) {
			for (int i = 0; i < kalender[monat].length; i++) {
				String[] tag = kalender[monat][i];
				for (int x = 0; x < kalender[monat][i].length; x++) {
					tag[x] = "nichts";
				}
			}
		}
	}

	static void alleWerteAusgeben(String[][][] kalender) {
		for (int monat = 0; monat < kalender.length; monat++) {
			for (int i = 0; i < kalender[monat].length; i++) {
				String[] tag = kalender[monat][i];
				for (int x = 0; x < tag.length; x++) {
					System.out.println("Monat(" + monat + ")Tag(" + i + ")/Stunde(" + x + "): " + tag[x]);
				}
			}
		}
	}

	static void stundenAusgeben(int tag, String[][][] kalender) {
		String[] tag2 = kalender[0][tag];
		for (int x = 0; x < tag2.length; x++) {
			System.out.println("Tag(" + tag + ")/Stunde(" + x + "): " + tag2[x]);
		}
	}

	static void tageAusgeben(String[][][] kalender) {
		for (int x = 0; x < kalender.length; x++) {
			for (int y = 0; y < kalender[x].length; y++) {
				System.out.println("Monat(" + x + ")Tag(" + x + ")");
			}
		}
	}

	static void fbiVernichten(String[][][] kalender) {
		mitNichtsBefuellen(kalender);
	}

	public static void main(String... args9) {
		String[][][] ganzjahreskalender = new String[12][31][24];
		mitNichtsBefuellen(ganzjahreskalender);
		ganzjahreskalender[0][0][4] = "Aufstehen!";
		ganzjahreskalender[0][0][9] = "Mittagessen!";
		ganzjahreskalender[0][30][22] = "Gute Nacht!";
		stundenAusgeben(0, ganzjahreskalender);
		tageAusgeben(ganzjahreskalender);
		fbiVernichten(ganzjahreskalender);
		alleWerteAusgeben(ganzjahreskalender);
	}
}

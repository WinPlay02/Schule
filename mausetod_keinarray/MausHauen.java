package mausetod;

public class MausHauen {
	public static void main(String... args) {
		Spielfeld sp = new Spielfeld(5);
		sp.setzeMaus();
		sp.ausgabe();
		sp.mausHauen();
	}
}

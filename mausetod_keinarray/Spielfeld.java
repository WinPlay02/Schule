package mausetod;

import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private Random random;

	int groesse;
	Maus maus;

	public Spielfeld(int pGroesse) {
		groesse = pGroesse;
		random = new Random();
		maus = new Maus(-1, -1);// nicht erreichbare koordinaten; ausﬂerhalb des zu betrachtenden bereichs
	}

	private int zufallsZahl(int max) {
		return random.nextInt(max);
	}

	public void ausgabe() {
		for (int x = 0; x < groesse; x++) {
			System.out.print("\t" + x);
		}
		System.out.println();
		for (int y = 0; y < groesse; y++) {
			System.out.print(y + ": ");
			for (int x = 0; x < groesse; x++) {
				System.out.print("\t");
				if (maus.getMausPosX() == x && maus.getMausPosY() == y) {
					System.out.print('M');
				} else {
					System.out.print('0');
				}

			}
			System.out.println();
		}
	}

	public void leeresSpielfeld() {
		maus.setzeMausPos(-1, -1);
	}

	public void setzeMaus() {
		maus.setzeMausTodesZustand(false);
		maus.setzeMausPos(zufallsZahl(groesse), zufallsZahl(groesse));
	}

	public void mausHauen() {
		int xHammer, yHammer;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Wohin hauen? X:");
		xHammer = scanner.nextInt();
		System.out.println();
		System.out.print("Wohin hauen? Y:");
		yHammer = scanner.nextInt();
		scanner.close();
		_internal_mausHauen(xHammer, yHammer);
	}

	public void _internal_mausHauen(int pX, int pY) {
		if (maus.getMausPosX() == pX && maus.getMausPosY() == pY) {
			maus.setzeMausTodesZustand(true);
			System.out.println("Gl¸ckwunsch: Die Maus ist jetzt tot.");
		} else {
			System.out.println("Daneben! Maus war bei X=" + maus.getMausPosX() + " Y=" + maus.getMausPosY());
		}
	}

}

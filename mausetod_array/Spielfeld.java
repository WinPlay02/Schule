package mausetod;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Spielfeld {
	private Random random;

	int groesse;
	Maus maus;
	char[][] spielFeld;

	public Spielfeld(int pGroesse) {
		groesse = pGroesse;
		random = new Random();
		spielFeld = new char[pGroesse][pGroesse];
		maus = new Maus(this, -1, -1);// nicht erreichbare koordinaten; ausßerhalb
		leeresSpielfeld(); // des zu betrachtenden bereichs
	}

	private int zufallsZahl(int max) {
		return random.nextInt(max);
		// return (int) (Math.random() * max);
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
				System.out.print(spielFeld[x][y]);
			}
			System.out.println();
		}
	}

	public void leeresSpielfeld() {
		for (int x = 0; x < groesse; x++) {
			for (int y = 0; y < groesse; y++) {
				spielFeld[x][y] = 'O';
			}
		}
		maus.setzeMausPos(this, -1, -1);
	}

	public void setzeMaus() {
		maus.setzeMausTodesZustand(false);
		maus.setzeMausPos(this, zufallsZahl(groesse), zufallsZahl(groesse));
	}

	public void mausHauen() {
		int xHammer, yHammer;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Wohin hauen? X: ");
		try {
			xHammer = scanner.nextInt();
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Mach keinen Schwachsinn!");
			mausHauen();
			scanner.close();
			return;
		}
		System.out.println();
		System.out.print("Wohin hauen? Y: ");
		try {
			yHammer = scanner.nextInt();
		} catch (InputMismatchException inputMismatch) {
			System.out.println("Bitte anständig antworten!");
			mausHauen();
			scanner.close();
			return;
		}
		scanner.close();
		_internal_mausHauen(xHammer, yHammer);
	}

	public void _internal_mausHauen(int pX, int pY) {
		if (maus.getMausPosX() == pX && maus.getMausPosY() == pY) {
			maus.setzeMausTodesZustand(true);
			System.out.println("Glückwunsch: Die Maus ist jetzt tot.");
		} else {
			System.out.println("Daneben! Maus war bei X=" + maus.getMausPosX() + " Y=" + maus.getMausPosY());
		}
	}

}

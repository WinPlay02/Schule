package mausetod;

public class Maus {
	int xPos;
	int yPos;
	boolean tot;

	public boolean getroffen() {
		return tot;
	}

	public Maus(Spielfeld ap, int pX, int pY) {
		setzeMausPos(ap, pX, pY);
	}

	public int getMausPosX() {
		return xPos;
	}

	public int getMausPosY() {
		return yPos;
	}

	public void setzeMausTodesZustand(boolean pZustand) {
		tot = pZustand;
	}

	public void setzeMausPos(Spielfeld sp, int pX, int pY) {
		xPos = pX;
		yPos = pY;
		if (!(pX == -1 && pY == -1)) {
			sp.spielFeld[pX][pY] = 'M';
		}
	}
}

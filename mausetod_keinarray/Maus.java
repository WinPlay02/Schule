package mausetod;

public class Maus {
	int xPos;
	int yPos;
	boolean tot;

	public boolean getroffen() {
		return tot;
	}

	public Maus(int pX, int pY) {
		setzeMausPos(pX, pY);
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

	public void setzeMausPos(int pX, int pY) {
		xPos = pX;
		yPos = pY;
	}
}

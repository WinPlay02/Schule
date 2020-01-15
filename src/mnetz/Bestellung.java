package mnetz;

public class Bestellung {
	private TShirt ware;
	private boolean bestaetigt;
	private int idnr;

	private String clientIP;
	private int clientPort;

	public Bestellung(TShirt pWare, String clientIP, int clientPort) {
		this.ware = pWare;
		this.bestaetigt = false;
		this.clientIP = clientIP;
		this.clientPort = clientPort;
	}

	public void setBestaetigt(boolean pBest) {
		this.bestaetigt = pBest;
	}

	public void setIDNr(int pIdNr) {
		this.idnr = pIdNr;
	}

	public TShirt getWare() {
		return this.ware;
	}

	public boolean isBestaetigt() {
		return this.bestaetigt;
	}

	public int getIDNr() {
		return this.idnr;
	}

	/**
	 * @return the clientIP
	 */
	public String getClientIP() {
		return clientIP;
	}

	/**
	 * @return the clientPort
	 */
	public int getClientPort() {
		return clientPort;
	}
}
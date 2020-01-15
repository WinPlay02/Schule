package mnetz;

import netzvorgabe.Client;

public class ShopClient extends Client {

	public ShopClient(String pServerIP, int pServerPort) {
		super(pServerIP, pServerPort);
	}

	@Override
	public void processMessage(String pMessage) {
		System.out.println(pMessage);
		if (pMessage.equalsIgnoreCase("HALLO")) {
			groesseFarbeWaehlen("XXL", "G");
		} else if (pMessage.equalsIgnoreCase("BESTAETIGUNG")) {
			bestaetigen("JA");
		}
			
	}

	public void groesseFarbeWaehlen(String pGroesse, String pFarbe) {
		this.send(String.format("TSHIRT:%s:%s", pGroesse, pFarbe));
	}

	public void bestaetigen(String pAntw) {
		this.send(String.format("BESTAETIGUNG:%s", pAntw));
	}

	public void abmelden() {
		this.send("ABMELDUNG");
	}
}

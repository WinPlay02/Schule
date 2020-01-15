package mnetz;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import netzvorgabe.List;
import netzvorgabe.Server;

public class ShopServer extends Server {

	public ShopServer(int pPort) {
		super(pPort);
	}

	public List<Bestellung> bestellungen = new List<>();
	public java.util.List<Bestellung> unbestaetigteBestellungen = new CopyOnWriteArrayList<>();

	@Override
	public void processNewConnection(String pClientIP, int pClientPort) {
		this.send(pClientIP, pClientPort, "HALLO");
	}

	@Override
	public void processMessage(String pClientIP, int pClientPort, String pMessage) {
		System.out.println(pMessage);
		if (pMessage.startsWith("TSHIRT:") && pMessage.lastIndexOf(":") != pMessage.indexOf(":")) {
			this.send(pClientIP, pClientPort, "BESTAETIGUNG");
			unbestaetigteBestellungen.add(
					new Bestellung(new TShirt(pMessage.split(":")[1], pMessage.split(":")[2]), pClientIP, pClientPort));
//			bestellungen.insert(
//					new Bestellung(new TShirt(pMessage.split(":")[1], pMessage.split(":")[2]), pClientIP, pClientPort));
		} else if (pMessage.equalsIgnoreCase("BESTAETIGUNG:JA")) {
			int i = 0;
			for (Bestellung b : unbestaetigteBestellungen) {
				if (b.getClientIP().equalsIgnoreCase(pClientIP) && b.getClientPort() == pClientPort) {
					bestellungen.insert(b);
					unbestaetigteBestellungen.remove(i);
					System.out.println("<server> BESTELLUNG EINGEGANGEN: " + b.getWare().getFarbe() + "|"
							+ b.getWare().getGroesse());
				}
				i++;
			}
			this.send(pClientIP, pClientPort, "ABMELDUNG");
		} else if (pMessage.equalsIgnoreCase("BESTAETIGUNG:NEIN") || pMessage.equalsIgnoreCase("ABMELDUNG")) {
			int i = 0;
			for (Bestellung b : unbestaetigteBestellungen) {
				if (b.getClientIP().equalsIgnoreCase(pClientIP) && b.getClientPort() == pClientPort) {
					unbestaetigteBestellungen.remove(i);
				}
				i++;
			}
			this.send(pClientIP, pClientPort, "ABMELDUNG");
		}
	}

	@Override
	public void processClosingConnection(String pClientIP, int pClientPort) {
		this.send(pClientIP, pClientPort, "BEENDEN");
	}
}

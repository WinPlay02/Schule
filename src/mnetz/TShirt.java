package mnetz;

public class TShirt {
	
	private String Farbe;
	private String Groesse;
	
	public TShirt(String pGroesse, String pFarbe) {
		this.Farbe = pFarbe;
		this.Groesse = pGroesse;
	}

	/**
	 * @return the farbe
	 */
	public String getFarbe() {
		return Farbe;
	}

	/**
	 * @return the groesse
	 */
	public String getGroesse() {
		return Groesse;
	}
	
}

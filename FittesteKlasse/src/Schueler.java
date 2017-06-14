
public class Schueler {
	
	private String vorname;
	private String nachname;
	private String klasse;
	private Double wert;
	
	public Schueler(){
	}
	
	public Schueler(String vorname, String nachname, String klasse, Double wert){
		this.vorname = vorname;
		this.nachname = nachname;
		this.klasse = klasse;
		this.wert = new Double(wert);	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getKlasse() {
		return klasse;
	}
	public void setKlasse(String klasse) {
		this.klasse = klasse;
	}
	public float getWert() {
		return wert.floatValue();
	}
	public void setWert(float wert) {
		this.wert = new Double(wert);
	}
	
	public String toString(){
		
		String result = "";
		
		result = vorname + ", " + nachname + ", " + klasse + ", " + wert + ";";
		
		return result;
	}
	
}

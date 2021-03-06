package model;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Contains the Information needed for an ListItem in the AssignToKurs-Activity
 */
@Root (name  = "kurs")
public class Kurs {
	@Element(name  = "id")
	private int id;
	@Element (name  = "kursstufe")
	private int kursstufe;
	@Element (name = "uhrzeit")
	private String uhrzeit;
	//private Date datum; // User Kurs DAO needs a String datum has to put in like : Day(int).Month(int).Year(int)
	@Element (name = "datum")
	private String datum;
	@Element (name  = "wochentag")
	private String wochentag;
	@Element (name = "enlisted")
	private boolean enlisted;
	//Boolean "SingUpAviable" must be added later 
	
	/**
	 * Instantiates a new kurs.
	 */
	public Kurs(){
		super ();
	}
	
	/**
	 * Instantiates a new kurs.
	 *
	 * @param kursID the kurs ID
	 * @param kursstufe the kursstufe
	 * @param datum the datum
	 * @param wochentag the wochentag
	 * @param uhrzeit the uhrzeit
	 * @param enlisted the enlisted
	 */
	public Kurs(int kursID,int kursstufe, String datum, String wochentag, String uhrzeit,boolean enlisted) {
		super();
		this.kursstufe = kursstufe;
		this.uhrzeit = uhrzeit;
		this.datum = datum;
		this.id = kursID;
		this.wochentag=wochentag;
		this.enlisted = enlisted;
	}
	
	public int getKursId() {
		return id;
	}

	public void setKursID(int kursID) {
		this.id = kursID;
	}

	public int getKursstufe() {
		return kursstufe;
	}

	public void setKursstufe(int kursstufe) {
		this.kursstufe = kursstufe;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getWochentag() {
		return wochentag;
	}

	public void setWochentag(String wochentag) {
		this.wochentag = wochentag;
	}

	public boolean isEnlisted() {
		return enlisted;
	}

	public void setEnlisted(boolean enlisted) {
		this.enlisted = enlisted;
	}
	
	//private Date kursende

}

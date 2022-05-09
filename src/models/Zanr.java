package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zanr {

    /**
     * Default constructor
     */
   

    /**
     * 
     */
    private String opis;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String oznaka;

    public Zanr() {
    	this.opis = "";
		this.id = "";
		this.oznaka = "";
    }
    
	public Zanr(String opis, String id, String oznaka) {
		this.opis = opis;
		this.id = id;
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
    
	private static String pripremaZaUpis(Zanr zanr) {
    	return String.format("%s|%s|%s", zanr.getOpis(), zanr.getId(), zanr.getOznaka());
    }
	
	public static void upisiZanr(Zanr zanr) {
		try {
			BufferedWriter zanrFajl = new BufferedWriter(new FileWriter("src/data/zanr.txt"));
			zanrFajl.write(pripremaZaUpis(zanr));
			zanrFajl.close();
			
		}catch(IOException e) { e.printStackTrace(); }
	}

	@Override
	public String toString() {
		return "Zanr [opis=" + opis + ", id=" + id + ", oznaka=" + oznaka + "]";
	}

}
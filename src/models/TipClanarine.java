package models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class TipClanarine {

    

    private String id;

    private String opis;

    private double cena;
    
    public TipClanarine() {
    	this.id = "";
		this.opis = "";
		this.cena = -1;
    }

	public TipClanarine(String id, String opis, double cena) {
		this.id = id;
		this.opis = opis;
		this.cena = cena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
    
    public static void upisiTipove(TipClanarine tipClanarine) {
    	try{
    		BufferedWriter tipoviFajl = new BufferedWriter(new FileWriter("src/data/tipovi.txt"));
    			
    		tipoviFajl.write(pripremaZaUpis(tipClanarine) + "\n");
    			
    			tipoviFajl.close();
    	} catch(IOException err) { err.printStackTrace(); }
    }
    private static String pripremaZaUpis(TipClanarine tip) {
    	return String.format("%s|%s|%s", tip.getId(), tip.getOpis(), Double.toString(tip.getCena()));
    }
    
    private static TipClanarine pripremaZaIspis(String line) {
    	String[] splitLinija = line.split("\\|");
    	TipClanarine clanarina = new TipClanarine(splitLinija[0], splitLinija[1], Double.parseDouble(splitLinija[2]));
    	return clanarina;
    }

}
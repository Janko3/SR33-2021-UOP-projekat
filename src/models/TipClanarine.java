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
    
    private boolean obrisan;
    
    public TipClanarine() {
    	this.id = "";
		this.opis = "";
		this.cena = -1;
		this.obrisan = false;
    }

	public TipClanarine(String id, String opis, double cena,boolean obrisan) {
		this.id = id;
		this.opis = opis;
		this.cena = cena;
		this.obrisan = obrisan;
	}
	
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
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
    
    
    
    

	@Override
	public String toString() {
		return "TipClanarine [id=" + id + ", opis=" + opis + ", cena=" + cena + "]";
	}
	public String generisiIDTip() {
        String idClan = "T-";
        for(int i=0;i<6;i++) {
            int broj = (int) Math.floor(Math.random()*9);
            idClan += Integer.toString(broj);
        }
        return idClan;
    }

	

}
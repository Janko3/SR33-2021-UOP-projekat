package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zanr {

    private String opis;

    private String id;

    private String oznaka;
    
    private boolean obrisan;

    public Zanr() {
    	this.opis = "";
		this.id = "";
		this.oznaka = "";
		this.obrisan = false;
    }
    
	public Zanr(String opis, String id, String oznaka,boolean obrisan) {
		this.opis = opis;
		this.id = id;
		this.oznaka = oznaka;
		this.obrisan = obrisan;
	}
	
	
	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
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
    
	
	
	

	@Override
	public String toString() {
		return "Zanr [opis=" + opis + ", id=" + id + ", oznaka=" + oznaka + "]";
	}
	public String generisiIDZanr() {
        String idClan = "Z-";
        for(int i=0;i<6;i++) {
            int broj = (int) Math.floor(Math.random()*9);
            idClan += Integer.toString(broj);
        }
        return idClan;
    }

}
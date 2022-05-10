package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Zanr {

    private String opis;

    private String id;

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
    
	
	
	

	@Override
	public String toString() {
		return "Zanr [opis=" + opis + ", id=" + id + ", oznaka=" + oznaka + "]";
	}

}
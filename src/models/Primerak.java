package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import enumerations.Jezik;
import enumerations.TipPoveza;

public class Primerak {

    

    private Knjiga knjiga;

    private int brojStrana;

    private int godinaStampanja;

    private boolean iznamljena;

    private String id;

    private boolean obrisan;
    
    private Jezik jezik;
    
    private TipPoveza povez;
    
    public Primerak() {
    	this.knjiga = null;
		this.brojStrana = -1;
		this.godinaStampanja = -1;
		this.iznamljena = false;
		this.id = "";
		this.obrisan = false;
		this.jezik = null;
		this.povez = null;
    	
    	
    }

	public Primerak(Knjiga knjiga, int brojStrana, int godinaStampanja, boolean iznamljena, String id,Jezik jezik,TipPoveza povez) {
		this.knjiga = knjiga;
		this.brojStrana = brojStrana;
		this.godinaStampanja = godinaStampanja;
		this.iznamljena = iznamljena;
		this.id = id;
		this.obrisan = false;
		this.jezik = jezik;
		this.povez = povez;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public int getBrojStrana() {
		return brojStrana;
	}

	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public int getGodinaStampanja() {
		return godinaStampanja;
	}

	public void setGodinaStampanja(int godinaStampanja) {
		this.godinaStampanja = godinaStampanja;
	}

	public boolean isIznamljena() {
		return iznamljena;
	}

	public void setIznamljena(boolean iznamljena) {
		this.iznamljena = iznamljena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}

	public TipPoveza getPovez() {
		return povez;
	}

	public void setPovez(TipPoveza povez) {
		this.povez = povez;
	}

	@Override
	public String toString() {
		return "Primerak [knjiga=" + knjiga + ", brojStrana=" + brojStrana + ", godinaStampanja=" + godinaStampanja
				+ ", iznamljena=" + iznamljena + ", id=" + id + ", obrisan=" + obrisan + ", jezik=" + jezik + ", povez="
				+ povez + "]";
	}
	
	
}
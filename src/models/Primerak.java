package models;

import enumerations.Jezik;
import enumerations.TipPoveza;

public class Primerak {

    

    private String knjiga;

    private int brojStrana;

    private int godinaStampanja;

    private boolean iznamljena;

    private int id;

    private boolean obrisan;
    
    private Jezik jezik;
    
    private TipPoveza povez;
    
    public Primerak() {
    	this.knjiga = "";
		this.brojStrana = -1;
		this.godinaStampanja = -1;
		this.iznamljena = false;
		this.id = -1;
		this.obrisan = false;
		this.jezik = null;
		this.povez = null;
    	
    	
    }

	public Primerak(String knjiga, int brojStrana, int godinaStampanja, boolean iznamljena, int id,Jezik jezik,TipPoveza povez) {
		this.knjiga = knjiga;
		this.brojStrana = brojStrana;
		this.godinaStampanja = godinaStampanja;
		this.iznamljena = iznamljena;
		this.id = id;
		this.obrisan = false;
		this.jezik = jezik;
		this.povez = povez;
	}

	public String getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(String knjiga) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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



}
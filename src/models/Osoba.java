package models;

import enumerations.Pol;

public abstract class Osoba {
	
	protected String prezime;

	 
    protected String JMBG;


    protected String adresa;
    
    protected String ime;
    
    protected Pol pol;

    protected boolean jeObrisan;
    
    public Osoba() {
    	
    	this.ime = "";
		this.prezime = "";
		this.JMBG = "";
		this.adresa = "";
		this.pol = null;
		this.jeObrisan = false;
		
		
    }

  
    public Osoba(String ime, String prezime, String JMBG, String adresa,Pol pol,boolean jeObrisan) {
		this.ime = ime;
		this.prezime = prezime;
		this.JMBG = JMBG;
		this.adresa = adresa;
		this.pol = pol;
		this.jeObrisan = jeObrisan;
	}


	

	
    public boolean isJeObrisan() {
		return jeObrisan;
	}


	public void setJeObrisan(boolean jeObrisan) {
		this.jeObrisan = jeObrisan;
	}


	public String getIme() {
		return ime;
	}


	public void setIme(String ime) {
		this.ime = ime;
	}


	public String getPrezime() {
		return prezime;
	}


	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}


	public String getJMBG() {
		return JMBG;
	}


	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}


	public String getAdresa() {
		return adresa;
	}


	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public Pol getPol() {
		return pol;
	}


	public void setPol(Pol pol) {
		this.pol = pol;
	}


	

}
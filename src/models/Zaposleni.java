package models;

import enumerations.Pol;

public abstract class Zaposleni extends Osoba {

	
	 	protected String korisnickoIme;

	    protected String lozinka;
	  
	    protected double plata;

	    protected String id;

	public Zaposleni() {
		this.korisnickoIme = "";
		this.lozinka = "";
		this.plata = -1;
		this.id = "";
		
		
	    }

	public Zaposleni(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,String korisnickoIme, String lozinka,double plata, String id) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan);
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.plata = plata;
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}


	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}


	public String getLozinka() {
		return lozinka;
	}


	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}


	public double getPlata() {
		return plata;
	}


	public void setPlata(double plata) {
		this.plata = plata;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "Zaposleni [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", plata=" + plata + ", id=" + id
				+ ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol=" + pol
				+ ", jeObrisan=" + jeObrisan + "]";
	}

	public void  DodatiNoveClanove() {
        // TODO implement here
    }

}
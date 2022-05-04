package models;

import enumerations.Pol;

public abstract class Zaposleni extends Osoba {

	
	 	protected String korisnickoIme;

	    protected String lozinka;
	  
	    protected double plata;

	    protected int id;

	    protected boolean obrisan;
   
   

   
  
	public Zaposleni() {
		this.korisnickoIme = "";
		this.lozinka = "";
		this.plata = -1;
		this.id = -1;
		this.obrisan = false;
	    }
	



	public Zaposleni(String korisnickoIme, String lozinka, double plata, int id,String ime, String prezime, String JMBG, String adresa, Pol pol) {
		super(ime, prezime, JMBG, adresa, pol);
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.plata = plata;
		this.id = id;
		this.obrisan = false;
		
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


	public void  DodatiNoveClanove() {
        // TODO implement here
    }

}
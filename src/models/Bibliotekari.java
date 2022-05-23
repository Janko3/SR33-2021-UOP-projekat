package models;

import java.util.ArrayList;

import enumerations.Pol;

public class Bibliotekari extends Zaposleni {
	
	

  
    public Bibliotekari() {
    	super();
    }




	public Bibliotekari(String korisnickoIme, String lozinka, double plata, String id) {
		super(korisnickoIme, lozinka, plata, id);
		// TODO Auto-generated constructor stub
	}




	public Bibliotekari(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,String korisnickoIme, String lozinka, double plata, String id) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan,korisnickoIme,lozinka,plata,id);
		// TODO Auto-generated constructor stub
	}




	@Override
	public String toString() {
		return "Bibliotekari [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", plata=" + plata + ", id="
				+ id + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol="
				+ pol + ", jeObrisan=" + jeObrisan + "]";
	}
	
	

	public String generisiIDBibliotekar() {
        String idBibliotekar = "B-";
        for(int i=0;i<6;i++) {
            int broj = (int) Math.floor(Math.random()*9);
            idBibliotekar += Integer.toString(broj);
        }
        return idBibliotekar;
    }
	

}
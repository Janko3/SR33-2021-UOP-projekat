  package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enumerations.Pol;

public class Administratori extends Zaposleni {
	
	protected Biblioteka biblioteka;


    public Administratori() {
    	super();
    	this.biblioteka = null;
    }
    
    

	public Administratori(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,
			String korisnickoIme, String lozinka, double plata, String id) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan, korisnickoIme, lozinka, plata, id);
		this.biblioteka = null;
		// TODO Auto-generated constructor stub
	}

	public Biblioteka getBiblioteka() {
		return biblioteka;
	}



	public void setBiblioteka(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
	}

	@Override
	public String toString() {
		return "Administratori [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", plata=" + plata + ", id="
				+ id + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol="
				+ pol + ", jeObrisan=" + jeObrisan +  "]";
	}

	


	public void DodatiNoveZaposlene() {
        // TODO implement here
    }

}
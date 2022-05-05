package models;

import enumerations.Pol;

public class Administratori extends Zaposleni {


    public Administratori() {
    }
    
    

	public Administratori(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,
			String korisnickoIme, String lozinka, double plata, String id) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan, korisnickoIme, lozinka, plata, id);
		// TODO Auto-generated constructor stub
	}



	public void DodatiNoveZaposlene() {
        // TODO implement here
    }

}
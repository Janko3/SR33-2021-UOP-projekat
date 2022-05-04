package models;

import enumerations.Pol;

public class Administratori extends Zaposleni {


    public Administratori() {
    }
    
    public Administratori(String korisnickoIme, String lozinka, double plata, int id, String ime, String prezime,
			String JMBG, String adresa, Pol pol) {
		super(korisnickoIme, lozinka, plata, id, ime, prezime, JMBG, adresa, pol);
		// TODO Auto-generated constructor stub
	}

	public void DodatiNoveZaposlene() {
        // TODO implement here
    }

}
package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import enumerations.Pol;

public class Administratori extends Zaposleni {


    public Administratori() {
    	super();
    }
    
    

	public Administratori(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,
			String korisnickoIme, String lozinka, double plata, String id) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan, korisnickoIme, lozinka, plata, id);
		// TODO Auto-generated constructor stub
	}
	
	
	
	


	@Override
	public String toString() {
		return "Administratori [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", plata=" + plata + ", id="
				+ id + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol="
				+ pol + ", jeObrisan=" + jeObrisan + ", getKorisnickoIme()=" + getKorisnickoIme() + ", getLozinka()="
				+ getLozinka() + ", getPlata()=" + getPlata() + ", getId()=" + getId() + ", isJeObrisan()="
				+ isJeObrisan() + ", getIme()=" + getIme() + ", getPrezime()=" + getPrezime() + ", getJMBG()="
				+ getJMBG() + ", getAdresa()=" + getAdresa() + ", getPol()=" + getPol() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	private static String pripremaZaUpis(Administratori admin) {
		
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s",admin.getIme(),admin.getPrezime(),admin.getJMBG(),admin.getAdresa(),admin.getPol(),admin.isJeObrisan(),
    			admin.getKorisnickoIme(),admin.getLozinka(),admin.getPlata(),admin.getId());
    }
	
	public static void upisiAdmina(Administratori admin) {
		try {
			
			BufferedWriter adminFajl = new BufferedWriter(new FileWriter("src/data/admini.txt"));
			adminFajl.write(pripremaZaUpis(admin));
			adminFajl.close();
			
			
		}catch(IOException e) { e.printStackTrace(); }
	}


	public void DodatiNoveZaposlene() {
        // TODO implement here
    }

}
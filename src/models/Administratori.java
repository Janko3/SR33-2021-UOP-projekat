  package models;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import enumerations.Pol;

public class Administratori extends Zaposleni {
	
	


    public Administratori() {
    	super();
//    	this.biblioteka = null;
    }
    
    

    public Administratori(String korisnickoIme, String lozinka, double plata, String id) {
		super(korisnickoIme, lozinka, plata, id);
		// TODO Auto-generated constructor stub
	}

	






	public Administratori(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,String korisnickoIme, String lozinka, double plata, String id) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan,korisnickoIme,lozinka,plata,id);
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "Administratori [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", plata=" + plata + ", id="
				+ id + ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol="
				+ pol + ", jeObrisan=" + jeObrisan +  "]";
	}
	
	
	private String generisiIDAdmin() {
        String idAdmin = "A-";
        for(int i=0;i<6;i++) {
            int broj = (int) Math.floor(Math.random()*9);
            idAdmin += Integer.toString(broj);
        }
        return idAdmin;
    }


	public void DodatiNoveAdmine(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,String korisnickoIme, String lozinka,double plata) {
		Administratori admin = new Administratori();
		admin.setIme(ime);
		admin.setPrezime(prezime);
		admin.setJMBG(JMBG);
		admin.setAdresa(adresa);
		admin.setPol(pol);
		admin.setJeObrisan(jeObrisan);
		admin.setKorisnickoIme(korisnickoIme);
		admin.setLozinka(lozinka);
		admin.setPlata(plata);
		admin.setId(admin.generisiIDAdmin());
		admin.setBiblioteka(biblioteka);
		biblioteka.getSviAdmini().add(admin);
		biblioteka.upisiAdmini(biblioteka.getSviAdmini());
        // TODO implement here
    }
	
	public void DodatiNoveBibliotekare(String ime, String prezime, String JMBG, String adresa, Pol pol, String korisnickoIme, String lozinka,double plata) {
		Bibliotekari bibliotekar = new Bibliotekari();
		bibliotekar.setIme(ime);
		bibliotekar.setPrezime(prezime);
		bibliotekar.setJMBG(JMBG);
		bibliotekar.setAdresa(adresa);
		bibliotekar.setPol(pol);
		
		bibliotekar.setKorisnickoIme(korisnickoIme);
		bibliotekar.setLozinka(lozinka);
		bibliotekar.setPlata(plata);
		bibliotekar.setId(bibliotekar.generisiIDBibliotekar());
		bibliotekar.setBiblioteka(biblioteka);
		biblioteka.getSviBibliotekari().add(bibliotekar);
		biblioteka.upisiBibliotekara(biblioteka.getSviBibliotekari());
	}
	
	public void obrisiBibliotekara(String id) {
		for(Bibliotekari b : biblioteka.getSviBibliotekari()) {
			if (b.getId().equals(id)) b.setJeObrisan(true);
		}
		biblioteka.izbrisiContentFajla("src/data/bibliotekari.txt");
		biblioteka.upisiBibliotekara(biblioteka.getSviBibliotekari());
	}
	public void obrisiAdmina(String id) {
		for(Administratori a: biblioteka.getSviAdmini()) {
			if(a.getId().equals(id)) a.setJeObrisan(true);
		}
		biblioteka.izbrisiContentFajla("src/data/admini.txt");
		biblioteka.upisiAdmini(biblioteka.getSviAdmini());
	}
	
	public void updateAdmina(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,String korisnickoIme, String lozinka,double plata,String id) {
		for(Administratori a: biblioteka.getSviAdmini()) {
			if(a.getId().equals(id)) {
				
				a.setIme(ime);
				a.setPrezime(prezime);
				a.setJMBG(JMBG);
				a.setAdresa(adresa);
				a.setPol(pol);
				a.setJeObrisan(jeObrisan);
				a.setKorisnickoIme(korisnickoIme);
				a.setLozinka(lozinka);
				a.setPlata(plata);
				a.setId(a.generisiIDAdmin());
				a.setBiblioteka(biblioteka);
				biblioteka.izbrisiContentFajla("src/data/admini.txt");
				biblioteka.upisiAdmini(biblioteka.getSviAdmini());
				
			}
		
		}
	}
	
	public void updateBibliotekara(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,String korisnickoIme, String lozinka, double plata, String id) {
		for (Bibliotekari b: biblioteka.getSviBibliotekari()) {
			if(b.getId().equals(id)) {
				b.setIme(ime);
				b.setPrezime(prezime);
				b.setJMBG(JMBG);
				b.setAdresa(adresa);
				b.setPol(pol);
				b.setJeObrisan(jeObrisan);
				b.setKorisnickoIme(korisnickoIme);
				b.setLozinka(lozinka);
				b.setPlata(plata);
				b.setId(b.generisiIDBibliotekar());
				biblioteka.izbrisiContentFajla("src/data/bibliotekari.txt");
				biblioteka.upisiBibliotekara(biblioteka.getSviBibliotekari());
			}
		}
	}
	
	public void updateBiblioteka(String naziv, String adresa, String radnoVreme, String telefon, String id) {
		
			if(biblioteka.getId().equals(id)) {
				biblioteka.setNaziv(naziv);
				biblioteka.setAdresa(adresa);
				biblioteka.setRadnoVreme(radnoVreme);
				biblioteka.setTelefon(telefon);
				biblioteka.setId(biblioteka.generisiIDBiblioteka() );
				biblioteka.izbrisiContentFajla("src/data/biblioteke.txt");
				biblioteka.upisiBiblioteku();
				
			}
		
	}


	


}
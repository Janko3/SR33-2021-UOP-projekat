package models;

import java.time.LocalDate;
import java.util.ArrayList;

import enumerations.Jezik;
import enumerations.Pol;

public abstract class Zaposleni extends Osoba {

	
	 	protected String korisnickoIme;

	    protected String lozinka;
	  
	    protected double plata;

	    protected String id;
	    
	    protected Biblioteka biblioteka;

	public Zaposleni() {
		this.korisnickoIme = "";
		this.lozinka = "";
		this.plata = -1;
		this.id = "";
		
		
	    }

	public Zaposleni(String korisnickoIme, String lozinka, double plata, String id) {
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.plata = plata;
		this.id = id;
		
		
	}

	



	public Zaposleni(String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,String korisnickoIme, String lozinka, double plata, String id) {
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

	
	
	public Biblioteka getBiblioteka() {
		return biblioteka;
	}

	public void setBiblioteka(Biblioteka biblioteka) {
		this.biblioteka = biblioteka;
	}

	@Override
	public String toString() {
		return "Zaposleni [korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + ", plata=" + plata + ", id=" + id
				+ ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol=" + pol
				+ ", jeObrisan=" + jeObrisan + "]";
	}

	public void  DodatiNoveClanove(LocalDate datumPoslednjeUplate, int brojMeseci, 
			boolean aktivnost,String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,TipClanarine tipClanarine) {
		
		Clan clan = new Clan();
		clan.setBrClanskeKarte(clan.generisiIDClan());
		clan.setDatumPoslednjeUplate(datumPoslednjeUplate);
		clan.setBrojMeseci(brojMeseci);
		clan.setAktivnost(aktivnost);
		clan.setIme(ime);
		clan.setPrezime(prezime);
		clan.setJMBG(JMBG);
		clan.setAdresa(adresa);
		clan.setPol(pol);
		clan.setJeObrisan(jeObrisan);
		clan.setTipClanarine(tipClanarine);
		this.setBiblioteka(biblioteka);
		ArrayList<Clan> sviClanovi = biblioteka.getSviClanovi();
		sviClanovi.add(clan);
		
		biblioteka.upisiClan(sviClanovi);
		
		
        // TODO implement here
    }
	
	public void DodajKnjigu(String naslov, String originalniNaslov, String pisac, int godinaObjavljivanja, String opis, Zanr zanr,Jezik jezik) {
		Knjiga knjiga = new Knjiga();
		knjiga.setNaslov(naslov);
		knjiga.setOriginalniNaslov(originalniNaslov);
		knjiga.setPisac(pisac);
		knjiga.setGodinaObjavljivanja(godinaObjavljivanja);
		knjiga.setOpis(opis);
		knjiga.setId(knjiga.generisiIDKnjiga());
		knjiga.setZanr(zanr);
		knjiga.setJezik(jezik);
		this.setBiblioteka(biblioteka);
		ArrayList<Knjiga> sveKnjige = biblioteka.getSveKnjige();
		sveKnjige.add(knjiga);
		biblioteka.upisiKnjigu(sveKnjige);
	}

}
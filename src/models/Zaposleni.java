package models;

import java.time.LocalDate;
import java.util.ArrayList;

import enumerations.Jezik;
import enumerations.Pol;
import enumerations.TipPoveza;

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
	
	public void DodajPrimerak(Knjiga knjiga, int brojStrana, int godinaStampanja, boolean iznamljena, Jezik jezik,TipPoveza povez) {
		Primerak primerak = new Primerak();
		primerak.setKnjiga(knjiga);
		primerak.setBrojStrana(brojStrana);
		primerak.setGodinaStampanja(godinaStampanja);
		primerak.setIznamljena(iznamljena);
		primerak.setId(primerak.generisiIDPrimerak());
		primerak.setJezik(jezik);
		primerak.setPovez(povez);
		this.setBiblioteka(biblioteka);
		biblioteka.getSviPrimerci().add(primerak);
		biblioteka.upisiPrimerak(biblioteka.getSviPrimerci());
	}
	
	public void DodajTip( String opis, double cena) {
		TipClanarine tip = new TipClanarine();
		tip.setId(tip.generisiIDTip());
		tip.setOpis(opis);
		tip.setCena(cena);
		this.setBiblioteka(biblioteka);
		biblioteka.getSviTipovi().add(tip);
		biblioteka.upisiTip(biblioteka.getSviTipovi());
		
	}
	
	public void DodajZanr(String opis, String oznaka) {
		Zanr zanr = new Zanr();
		zanr.setOpis(opis);
		zanr.setOznaka(oznaka);
		zanr.setId(zanr.generisiIDZanr());
		this.setBiblioteka(biblioteka);
		biblioteka.getSviZanrovi().add(zanr);
		biblioteka.upisiZanr(biblioteka.getSviZanrovi());
	}
	
	public void obrisiKnjigu(String id) {
		for (Knjiga k: biblioteka.getSveKnjige()) {
			if(k.getId().equals(id)) k.setObrisan(true);
		}
		biblioteka.izbrisiContentFajla("src/data/knjige.txt");
		biblioteka.upisiKnjigu(biblioteka.getSveKnjige());
	}
	
	public void obrisiTip(String id) {
		for(TipClanarine t: biblioteka.getSviTipovi()) {
			if(t.getId().equals(id)) t.setObrisan(true);
			
		}
		biblioteka.izbrisiContentFajla("src/data/tipovi.txt");
		biblioteka.upisiTip(biblioteka.getSviTipovi());
	}
	
	public void obrisiZanr(String id) {
		for(Zanr z: biblioteka.getSviZanrovi()) {
			if(z.getId().equals(id)) z.setObrisan(true);
		}
		biblioteka.izbrisiContentFajla("src/data/zanrovi.txt");
		biblioteka.upisiZanr(biblioteka.getSviZanrovi());
	}
	
	public void obrisiPrimerak(String id) {
		for(Primerak p: biblioteka.getSviPrimerci()) {
			if(p.getId().equals(id)) p.setObrisan(true);
		}
		biblioteka.izbrisiContentFajla("src/data/primerci");
		biblioteka.upisiPrimerak(biblioteka.getSviPrimerci());
	}
	public void obrisiClana(String id) {
		for(Clan c: biblioteka.getSviClanovi()) {
			if(c.getBrClanskeKarte().equals(id)) c.setJeObrisan(true);
			
		}
		biblioteka.izbrisiContentFajla("src/data/clanovi.txt");
		biblioteka.upisiClan(biblioteka.getSviClanovi());
	}
	
	
	

}
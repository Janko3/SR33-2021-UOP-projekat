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
			String ime, String prezime, String JMBG, String adresa, Pol pol, TipClanarine tipClanarine) {
		
		Clan clan = new Clan();
		clan.setBrClanskeKarte(clan.generisiIDClan());
		clan.setDatumPoslednjeUplate(datumPoslednjeUplate);
		clan.setBrojMeseci(brojMeseci);
		
		clan.setIme(ime);
		clan.setPrezime(prezime);
		clan.setJMBG(JMBG);
		clan.setAdresa(adresa);
		clan.setPol(pol);
		
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
	
	public void DodajPrimerak(Knjiga knjiga, int brojStrana, int godinaStampanja,  Jezik jezik,TipPoveza povez) {
		Primerak primerak = new Primerak();
		primerak.setKnjiga(knjiga);
		primerak.setBrojStrana(brojStrana);
		primerak.setGodinaStampanja(godinaStampanja);
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
	public void dodajIznajmljivanje(LocalDate datumIznajmljivanje, LocalDate datumVracanja,Primerak primerakKnjige,Clan clan,Zaposleni zaposleni) {
		
		Iznajmljivanje iznajmljivanje = new Iznajmljivanje();
		iznajmljivanje.setDatumIznajmljivanje(datumIznajmljivanje);
		iznajmljivanje.setDatumVracanja(datumVracanja);
		iznajmljivanje.setPrimerakKnjige(primerakKnjige);
		iznajmljivanje.setClan(clan);
		iznajmljivanje.setZaposleni(zaposleni);
		iznajmljivanje.setId(iznajmljivanje.generisiIDIznajmljivanje());
		updateIznajmljenPrimerak(primerakKnjige.getId());
		biblioteka.getSvaIznamljivanja().add(iznajmljivanje);
		biblioteka.upisiIznajmljivanje(biblioteka.getSvaIznamljivanja());
		
		
	}
	public void updateIznajmljenPrimerak(String idPrimerka) {
		ArrayList<Primerak> primerci = biblioteka.neobrisaniPrimerci();
		for(Primerak p: primerci) {
			if(p.getId().equals(idPrimerka)) {
				p.setIznamljena(true);
			}
			
		}
		biblioteka.upisiPrimerak(primerci);
		
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
	public void obrisiIznajmljivanje(String id) {
		for(Iznajmljivanje i: biblioteka.getSvaIznamljivanja()) {
			if(i.getId().equals(id)) {
				i.setObrisan(true);
				i.getPrimerakKnjige().setIznamljena(false);
			}
		}
		biblioteka.izbrisiContentFajla("src/data/iznajmljivanja.txt");
		biblioteka.upisiIznajmljivanje(biblioteka.getSvaIznamljivanja());
	}
	public void obrisiClana(String id) {
		for(Clan c: biblioteka.neobrisaniClanovi()) {
			if(c.getBrClanskeKarte().equals(id)) {
				c.setJeObrisan(true);
				
				biblioteka.neobrisaniClanovi().remove(c);
			}
			
		}
		biblioteka.izbrisiContentFajla("src/data/clanovi.txt");
		biblioteka.upisiClan(biblioteka.getSviClanovi());
	}
	
	public void updateClan(String brClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseci, 
			String ime, String prezime, String JMBG, String adresa, Pol pol, TipClanarine tipClanarine) {
		for(Clan c: biblioteka.getSviClanovi()) {
			if(c.getBrClanskeKarte().equals(brClanskeKarte)) {
				c.setBrClanskeKarte(c.getBrClanskeKarte());
				c.setDatumPoslednjeUplate(datumPoslednjeUplate);
				c.setBrojMeseci(brojMeseci);
				c.setAktivnost(c.isAktivnost());
				c.setIme(ime);
				c.setPrezime(prezime);
				c.setJMBG(JMBG);
				c.setAdresa(adresa);
				c.setPol(pol);
				c.setJeObrisan(c.isJeObrisan());
				c.setTipClanarine(tipClanarine);
				biblioteka.izbrisiContentFajla("src/data/clanovi.txt");
				biblioteka.upisiClan(biblioteka.getSviClanovi());
				
			}
			
		}
	}
	public void updateIznajmljivanje(LocalDate datumIznajmljivanja,LocalDate datumVracanja,Primerak primerak,Clan clan,Zaposleni zaposleni,String id) {
		for(Iznajmljivanje i:biblioteka.neobrisanaIznajmljivanja()) {
			if(i.getId().equals(id)) {
				i.setDatumIznajmljivanje(datumIznajmljivanja);
				i.setDatumVracanja(datumVracanja);
				i.setPrimerakKnjige(primerak);
				i.setClan(clan);
				i.setZaposleni(zaposleni);
				i.setId(i.getId());
				biblioteka.izbrisiContentFajla("src/data/iznajmljivanja.txt");
				biblioteka.upisiIznajmljivanje(biblioteka.neobrisanaIznajmljivanja());
			}
		}
		
	}
	public void updateKnjiga(String naslov, String originalniNaslov, String pisac, int godinaObjavljivanja, String opis, String id,Zanr zanr,Jezik jezik) {
		for(Knjiga k: biblioteka.getSveKnjige()) {
			if(k.getId().equals(id)) {
				k.setNaslov(naslov);
				k.setOriginalniNaslov(originalniNaslov);
				k.setPisac(pisac);
				k.setOpis(opis);
				k.setId(k.getId());
				k.setZanr(zanr);
				k.setJezik(jezik);
				biblioteka.izbrisiContentFajla("src/data/knjige.txt");
				biblioteka.upisiKnjigu(biblioteka.getSveKnjige());
			}
		}
	}
	public void updatePrimerak(Knjiga knjiga, int brojStrana, int godinaStampanja, String id,Jezik jezik,TipPoveza povez) {
		for(Primerak p: biblioteka.getSviPrimerci()) {
			if(p.getId().equals(id)) {
				p.setKnjiga(knjiga);
				p.setBrojStrana(brojStrana);
				p.setGodinaStampanja(godinaStampanja);
				p.setIznamljena(p.isIznamljena());
				
				p.setId(p.getId());
				p.setJezik(jezik);
				p.setPovez(povez);
				p.setObrisan(p.isObrisan());
				biblioteka.izbrisiContentFajla("src/data/primerci.txt");
				biblioteka.upisiPrimerak(biblioteka.getSviPrimerci());
			}
		}
	}
	
	public void updateTip(String id, String opis, double cena) {
		for(TipClanarine t: biblioteka.getSviTipovi()) {
			if(t.getId().equals(id)) {
				t.setId(t.getId());
				t.setOpis(opis);
				t.setCena(cena);
				t.setObrisan(t.isObrisan());
				biblioteka.izbrisiContentFajla("src/data/tipovi.txt");
				biblioteka.upisiTip(biblioteka.getSviTipovi());
			}
		}
	}
	
	public void updateZanr(String opis, String id, String oznaka) {
		for(Zanr z:biblioteka.getSviZanrovi()) {
			if(z.getId().equals(id)) {
				z.setOpis(opis);
				z.setId(z.getId());
				z.setOznaka(oznaka);
				z.setObrisan(z.isObrisan());
				biblioteka.izbrisiContentFajla("src/data/zanrovi.txt");
				biblioteka.upisiZanr(biblioteka.getSviZanrovi());
			}
		}
	}
	
	public void vratiClana(String id) {
		for(Clan c: biblioteka.getSviClanovi()) {
			if(c.getBrClanskeKarte().equals(id)) {
				c.setAktivnost(true);
				biblioteka.upisiClan(biblioteka.aktivniClanovi());
			}
		}
	}
	
		
	

}
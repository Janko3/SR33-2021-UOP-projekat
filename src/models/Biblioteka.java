 package models;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enumerations.Jezik;
import enumerations.Pol;
import enumerations.TipPoveza;

public class Biblioteka {

    

    private String naziv;

    private String adresa;

    private String radnoVreme;

    private String telefon;

    private String id;
    
    private ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
    
    private ArrayList<Clan> sviClanovi = new ArrayList<Clan>();
    
    private ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
    
    private ArrayList<TipClanarine> sviTipovi = new ArrayList<TipClanarine>();
    
    private ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
    
    private ArrayList<Administratori> sviAdmini = new ArrayList<Administratori>();
    
    private ArrayList<Bibliotekari> sviBibliotekari = new ArrayList<Bibliotekari>();
    
    private ArrayList<Iznajmljivanje> svaIznajmljivanja = new ArrayList<Iznajmljivanje>();
    
    private ArrayList<Zaposleni> sviZaposleni = new ArrayList<Zaposleni>();
    
    public Biblioteka() {
    	
    	this.naziv = "";
		this.adresa = "";
		this.radnoVreme = "";
		this.telefon = "";
		this.id = "";
		
    }
    public Biblioteka(String naziv, String adresa, String radnoVreme, String telefon, String id) {
    	this.naziv = naziv;
		this.adresa = adresa;
		this.radnoVreme = radnoVreme;
		this.telefon = telefon;
		this.id = id;
		
    	
    }

	public Biblioteka(String naziv, String adresa, String radnoVreme, String telefon, String id,
			ArrayList<Knjiga> sveKnjige, ArrayList<Clan> sviClanovi, ArrayList<Primerak> sviPrimerci,
			ArrayList<TipClanarine> sviTipovi, ArrayList<Zanr> sviZanrovi, ArrayList<Administratori> sviAdmini,
			ArrayList<Bibliotekari> sviBibliotekari, ArrayList<Iznajmljivanje> svaIznamljivanja,ArrayList<Zaposleni> sviZaposleni) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.radnoVreme = radnoVreme;
		this.telefon = telefon;
		this.id = id;
		this.sveKnjige = sveKnjige;
		this.sviClanovi = sviClanovi;
		this.sviPrimerci = sviPrimerci;
		this.sviTipovi = sviTipovi;
		this.sviZanrovi = sviZanrovi;
		this.sviAdmini = sviAdmini;
		this.sviBibliotekari = sviBibliotekari;
		this.svaIznajmljivanja = svaIznamljivanja;
		this.sviZaposleni = sviZaposleni;
		
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}


	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(String radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public ArrayList<Knjiga> getSveKnjige() {
		return sveKnjige;
	}

	public void setSveKnjige(ArrayList<Knjiga> sveKnjige) {
		this.sveKnjige = sveKnjige;
	}

	public ArrayList<Clan> getSviClanovi() {
		return sviClanovi;
	}

	public void setSviClanovi(ArrayList<Clan> sviClanovi) {
		this.sviClanovi = sviClanovi;
	}

	public ArrayList<Primerak> getSviPrimerci() {
		return sviPrimerci;
	}

	public void setSviPrimerci(ArrayList<Primerak> sviPrimerci) {
		this.sviPrimerci = sviPrimerci;
	}

	public ArrayList<TipClanarine> getSviTipovi() {
		return sviTipovi;
	}

	public void setSviTipovi(ArrayList<TipClanarine> sviTipovi) {
		this.sviTipovi = sviTipovi;
	}

	public ArrayList<Administratori> getSviAdmini() {
		return sviAdmini;
	}

	public void setSviAdmini(ArrayList<Administratori> sviAdmini) {
		this.sviAdmini = sviAdmini;
	}



	public ArrayList<Bibliotekari> getSviBibliotekari() {
		return sviBibliotekari;
	}



	public void setSviBibliotekari(ArrayList<Bibliotekari> sviBibliotekari) {
		this.sviBibliotekari = sviBibliotekari;
	}



	public ArrayList<Zanr> getSviZanrovi() {
		return sviZanrovi;
	}

	public ArrayList<Iznajmljivanje> getSvaIznamljivanja() {
		return svaIznajmljivanja;
	}



	public void setSvaIznamljivanja(ArrayList<Iznajmljivanje> svaIznajmljivanja) {
		this.svaIznajmljivanja = svaIznajmljivanja;
	}


	public void setSviZanrovi(ArrayList<Zanr> sviZanrovi) {
		this.sviZanrovi = sviZanrovi;
	}
	
	public ArrayList<Zaposleni> getSviZaposleni() {
		return sviZaposleni;
	}

	public void setSviZaposleni(ArrayList<Zaposleni> sviZaposleni) {
		this.sviZaposleni = sviZaposleni;
	}

	
	private String pripremaZaUpisZanr(Zanr zanr) {
    	return String.format("%s|%s|%s|%s\n", zanr.getOpis(), zanr.getId(), zanr.getOznaka(),zanr.isObrisan());
    }
	
	public void upisiZanr(ArrayList<Zanr> sviZanrovi) {
		try {
			
			BufferedWriter zanroviFajl = new BufferedWriter(new FileWriter("src/data/zanrovi.txt"));
			for(Zanr z: sviZanrovi) {
				
				zanroviFajl.write(this.pripremaZaUpisZanr(z));
			}zanroviFajl.close();
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	
	public ArrayList<Zanr> ucitajZanrove(){
		
		try {
			File zanrFajl = new File("src/data/zanrovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(zanrFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String[] splitLinije = linija.split("\\|");
				String opis = splitLinije[0];
				String id = splitLinije[1];
				String oznaka = splitLinije[2];
				boolean obrisan = Boolean.parseBoolean(splitLinije[3]);
				Zanr zanr = new Zanr(opis,id,oznaka,obrisan);
				sviZanrovi.add(zanr);
				
			}
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		
	}
		return sviZanrovi;
		
	}
	
	
	private  String pripremaZaUpisKnjiga(Knjiga knjiga) {
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s\n", knjiga.getNaslov(), knjiga.getOriginalniNaslov(), knjiga.getPisac(), Integer.toString(knjiga.getGodinaObjavljivanja()),
    			knjiga.getOpis(),knjiga.getId(),knjiga.getZanr().getId(),knjiga.getJezik(),knjiga.isObrisan());
    }
	
	
	public void upisiKnjigu(ArrayList<Knjiga> sveKnjige) {
		try {
			
			BufferedWriter knjigeFajl = new BufferedWriter(new FileWriter("src/data/knjige.txt"));
			for(Knjiga k: sveKnjige) {
				
				knjigeFajl.write(this.pripremaZaUpisKnjiga(k));
			}knjigeFajl.close();
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	
	public ArrayList<Knjiga>  ucitajKnjige(ArrayList<Zanr>sviZanrovi) {
		
		try {
			File fajlKnjiga = new File("src/data/knjige.txt");
			BufferedReader reader = new BufferedReader(new FileReader(fajlKnjiga));
			String linija;
			while((linija = reader.readLine()) != null) {
				String[] splitLinije = linija.split("\\|");
				String naslovKnjiga = splitLinije[0];
				String orgNaslovKnjiga = splitLinije[1];
				String pisacKnjiga = splitLinije[2];
				int godinaObjavljivanjaKnjiga = Integer.parseInt(splitLinije[3]);
				String opisKnjiga = splitLinije[4];
				String idKnjiga = splitLinije[5];
				Zanr zanrovi = null;
				for(Zanr za: sviZanrovi) {
					if(za.getId().equals(splitLinije[6])) zanrovi = za;
				}
				
				Jezik jezik = Jezik.valueOf(splitLinije[7]);
				boolean obrisan = Boolean.parseBoolean(splitLinije[8]);
				
				Knjiga knjiga = new Knjiga(naslovKnjiga,orgNaslovKnjiga,pisacKnjiga,godinaObjavljivanjaKnjiga,
						opisKnjiga,idKnjiga,zanrovi,jezik,obrisan);
				sveKnjige.add(knjiga);
				
				
				
			}
			reader.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		
	}
		return sveKnjige;

	}
	
	private String pripremaZaUpisClan(Clan clan) {
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n", clan.getBrClanskeKarte(), clan.getDatumPoslednjeUplate(), clan.getBrojMeseci(),clan.isAktivnost(),clan.getIme(),clan.getPrezime(),
    			clan.getJMBG(),clan.getAdresa(),clan.getPol(),clan.isJeObrisan(),clan.getTipClanarine().getId());
    }
	
	public void upisiClan(ArrayList<Clan> sviClanovi) {
		try {
			
			BufferedWriter clanoviFajl = new BufferedWriter(new FileWriter("src/data/clanovi.txt"));
			for(Clan cl: sviClanovi) {
				
				clanoviFajl.write(this.pripremaZaUpisClan(cl));
			}clanoviFajl.close();
			
			
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	
	public ArrayList<Clan> ucitajClanove(ArrayList<TipClanarine> sviTipovi) {
		
		try {
			File clanFajl = new File("src/data/clanovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(clanFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String [] splitLinije = linija.split("\\|");
				String imeClan = splitLinije[4];
				String prezimeClan = splitLinije[5];
				String adresaClan = splitLinije[7];
				String JMBGClan = splitLinije[6];
				Pol pol = Pol.valueOf(splitLinije[8]);
				String brClanskeKarteClan = splitLinije[0];
				LocalDate datumPoslednjeUplate =  LocalDate.parse(splitLinije[1]); 
				int brMeseciClan = Integer.parseInt(splitLinije[2]);
				boolean aktivnostClan = Boolean.parseBoolean(splitLinije[3]);
				boolean obrisanClan = Boolean.parseBoolean(splitLinije[9]);
				TipClanarine clanarina = null;
				for(TipClanarine cl: sviTipovi) {
					if (cl.getId().equals(splitLinije[10])) clanarina = cl;
				}
				Clan clan = new Clan(brClanskeKarteClan, datumPoslednjeUplate,brMeseciClan,aktivnostClan,imeClan,prezimeClan,JMBGClan,adresaClan,pol,obrisanClan,clanarina);
				sviClanovi.add(clan);
			}
			reader.close();
		}catch(IOException e) {
				e.printStackTrace();
			}
		return sviClanovi;
		}
	
	
    private String pripremaZaUpisTip(TipClanarine tip) {
    	return String.format("%s|%s|%s|%s\n", tip.getId(), tip.getOpis(), Double.toString(tip.getCena()),tip.isObrisan());
    }
    public void upisiTip(ArrayList<TipClanarine> sviTipovi) {
		try {
			
			BufferedWriter tipoviFajl = new BufferedWriter(new FileWriter("src/data/tipovi.txt"));
			for(TipClanarine t: sviTipovi) {
				
				tipoviFajl.write(this.pripremaZaUpisTip(t));
			}tipoviFajl.close();
			
			
			
		}catch(IOException e) { e.printStackTrace(); }
	}
    
	
	public  ArrayList<TipClanarine> ucitajTipove(){
		
		try {
			File tipFajl = new File("src/data/tipovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(tipFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String[] splitLinije = linija.split("\\|");
				String idTip = splitLinije[0];
				String opisTip = splitLinije[1];
				double cenaTip = Double.parseDouble(splitLinije[2]);
				boolean obrisanTip = Boolean.parseBoolean(splitLinije[3]);
				TipClanarine tip = new TipClanarine(idTip,opisTip,cenaTip,obrisanTip);
				sviTipovi.add(tip);
				
			}
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		
	}
		return sviTipovi;
		
	}
	private String pripremaZaUpisPrimerak(Primerak primerak) {
		
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s\n",primerak.getKnjiga().getId(),primerak.getBrojStrana(),primerak.getGodinaStampanja(),primerak.isIznamljena(),
    			primerak.getId(),primerak.getJezik(),primerak.getPovez(),primerak.isObrisan());
    }
	
	public void upisiPrimerak(ArrayList<Primerak> sviPrimerci) {
		try {
			
			BufferedWriter primerakFajl = new BufferedWriter(new FileWriter("src/data/primerci.txt"));
			for(Primerak p: sviPrimerci) {
				
				primerakFajl.write(this.pripremaZaUpisPrimerak(p));
			}primerakFajl.close();
			
			
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	public ArrayList<Primerak> ucitajPrimerke(){
		try {
			File primerakFajl = new File("src/data/primerci.txt");
			BufferedReader reader = new BufferedReader(new FileReader(primerakFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String[] splitLinije = linija.split("\\|");
				Knjiga knjiga = null;
				for(Knjiga k: sveKnjige) {
					
					if(k.getId().equals(splitLinije[0])) {
						knjiga = k;
					}
				}
				
				int brojStrana = Integer.parseInt(splitLinije[1]);
				int godinaObjavljivanja = Integer.parseInt(splitLinije[2]);
				boolean iznajmljena = Boolean.parseBoolean(splitLinije[3]);
				String id = splitLinije[4];
				Jezik jezik = Jezik.valueOf(splitLinije[5]);
				TipPoveza tipPoveza = TipPoveza.valueOf(splitLinije[6]);
				boolean obrisan = Boolean.parseBoolean(splitLinije[7]);
				Primerak primerak = new Primerak(knjiga,brojStrana,godinaObjavljivanja,iznajmljena,id,jezik,tipPoveza,obrisan);
				
				sviPrimerci.add(primerak);
			}
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();	
	}
	return sviPrimerci;

	}
	
	private String pripremaZaUpis(Administratori admin) {
		
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n",admin.getIme(),admin.getPrezime(),admin.getJMBG(),admin.getAdresa(),admin.getPol(),admin.isJeObrisan(),
    			admin.getKorisnickoIme(),admin.getLozinka(),admin.getPlata(),admin.getId());
    }
	
	public void upisiAdmini(ArrayList<Administratori> sviAdmini) {
		try {
			
			BufferedWriter adminiFajl = new BufferedWriter(new FileWriter("src/data/admini.txt"));
			for(Administratori a: sviAdmini) {
				adminiFajl.write(this.pripremaZaUpis(a));
			}adminiFajl.close();
			
			
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	
	public ArrayList<Administratori> ucitajAdmine(){
		try {
			File adminFajl = new File("src/data/admini.txt");
			BufferedReader reader = new BufferedReader(new FileReader(adminFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String[] splitLinije = linija.split("\\|");
				String imeAdmin = splitLinije[0];
				String prezimeAdmin = splitLinije[1];
				String jmbgAdmin = splitLinije[2];
				String adresaAdmin = splitLinije[3];
				Pol polAdmin = Pol.valueOf(splitLinije[4]);
				Boolean obrisanAdmin = Boolean.parseBoolean(splitLinije[5]);
				String korisnickoImeAdmin = splitLinije[6];
				String lozinkaAdmin = splitLinije[7];
				double plataAdmin = Double.parseDouble(splitLinije[8]);
				String idAdmin = splitLinije[9];
				Administratori admini = new Administratori(imeAdmin,prezimeAdmin,jmbgAdmin,adresaAdmin,polAdmin,obrisanAdmin,korisnickoImeAdmin,lozinkaAdmin,plataAdmin,
						idAdmin);
				admini.setBiblioteka(this);
				sviAdmini.add(admini);				
			}
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();	
	}
	return sviAdmini;  
	}
	
	private String pripremaZaUpisBibliotekari(Bibliotekari bibliotekar) {
		
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s\n",bibliotekar.getIme(),bibliotekar.getPrezime(),bibliotekar.getJMBG(),bibliotekar.getAdresa(),bibliotekar.getPol(),bibliotekar.isJeObrisan(),
    			bibliotekar.getKorisnickoIme(),bibliotekar.getLozinka(),bibliotekar.getPlata(),bibliotekar.getId());
    }
	
	public void upisiBibliotekara(ArrayList<Bibliotekari> sviBibliotekari) {
		try {
			
			BufferedWriter bibliotekarFajl = new BufferedWriter(new FileWriter("src/data/bibliotekari.txt"));
			for(Bibliotekari b: sviBibliotekari) {
				
				bibliotekarFajl.write(this.pripremaZaUpisBibliotekari(b));
			}bibliotekarFajl.close();
			
			
			
		}catch(IOException e) { e.printStackTrace(); }
	}
	
	public ArrayList<Bibliotekari> ucitajBibliotekare(){
		try {
			File bibliotekarFajl = new File("src/data/bibliotekari.txt");
			BufferedReader reader = new BufferedReader(new FileReader(bibliotekarFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String[] splitLinije = linija.split("\\|");
				String ime = splitLinije[0];
				String prezime = splitLinije[1];
				String jmbg = splitLinije[2];
				String adresa = splitLinije[3];
				Pol pol = Pol.valueOf(splitLinije[4]);
				Boolean obrisan = Boolean.parseBoolean(splitLinije[5]);
				String korisnickoIme = splitLinije[6];
				String lozinka = splitLinije[7];
				double plata = Double.parseDouble(splitLinije[8]);
				String id = splitLinije[9];
				Bibliotekari bibliotekari = new Bibliotekari(ime,prezime,jmbg,adresa,pol,obrisan,korisnickoIme,lozinka,plata,
						id);
				bibliotekari.setBiblioteka(this);
				sviBibliotekari.add(bibliotekari);				
			}
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();	
	}
	return sviBibliotekari;  
	}
	
    public ArrayList<Zaposleni> ucitajZaposlene(){
    	
			for(Administratori admin: sviAdmini) {
				sviZaposleni.add(admin);		
			}
			for(Bibliotekari bibliotekar: sviBibliotekari) {
				sviZaposleni.add(bibliotekar);
			}
			return sviZaposleni;
		}
	
	 private String pripremaZaUpisIznajmljivanje(Iznajmljivanje iznajmljivanje) {
	    	return String.format("%s|%s|%s|%s|%s|%s|%s\n", iznajmljivanje.getDatumIznajmljivanje().toString(), iznajmljivanje.getDatumVracanja().toString(), pripremaZaUpisPrimerakaUIznajmljivanje(iznajmljivanje.getPrimerakKnjige()),iznajmljivanje.getClan().getBrClanskeKarte(),
	    			iznajmljivanje.getZaposleni().getId(),iznajmljivanje.isObrisan(),iznajmljivanje.getId());
	    }
	 private static String pripremaZaUpisPrimerakaUIznajmljivanje(ArrayList<Primerak> sviPrimerci) {
		 String prikaz = "";
		 for(Primerak p: sviPrimerci) {
			 prikaz += p.getId() + ",";
		 }
		 return prikaz;
	 }
	    public void upisiIznajmljivanje(ArrayList<Iznajmljivanje> svaIznajmljivanja) {
			try {
				
				BufferedWriter iznajmljivanjeFajl = new BufferedWriter(new FileWriter("src/data/iznajmljivanja.txt"));
				for(Iznajmljivanje i: svaIznajmljivanja) {
					
					iznajmljivanjeFajl.write(this.pripremaZaUpisIznajmljivanje(i));
				}iznajmljivanjeFajl.close();
				
				
				
			}catch(IOException e) { e.printStackTrace(); }
		}
	    
	
	    
	   
	    
	    private String pripremaZaUpisBiblioteka() {
	    	return String.format("%s|%s|%s|%s|%s\n",this.getNaziv(),this.getAdresa(),this.getRadnoVreme(),this.getTelefon(),this.getId());
	    }
		
		public void upisiBiblioteku() {
			try {
				
				BufferedWriter bibliotekaFajl = new BufferedWriter(new FileWriter("src/data/biblioteke.txt"));
				bibliotekaFajl.write(pripremaZaUpisBiblioteka());
				bibliotekaFajl.close();
				
			}catch(IOException e) { e.printStackTrace(); }
		}
		
		public Biblioteka ucitajBiblioteku(){
			Biblioteka bibliotekaRet = null;
			try {
				File bibliotekaFajl = new File("src/data/biblioteke.txt");
				BufferedReader reader = new BufferedReader(new FileReader(bibliotekaFajl));
				String linija;
				while((linija = reader.readLine()) != null) {
					String[] splitLinije = linija.split("\\|");
					String naziv = splitLinije[0];
					String adresa = splitLinije[1];
					String radnoVreme = splitLinije[2];
					String telefon = splitLinije[3];
					String id = splitLinije[4];
					this.setNaziv(naziv);
					this.setAdresa(adresa);
					this.setRadnoVreme(radnoVreme);
					this.setTelefon(telefon);
					this.setId(id);
					
				}
				reader.close();
				
			}catch(IOException e) {
				e.printStackTrace();
			
		}
			return bibliotekaRet;
			
			
			
		}
		@Override
		public String toString() {
			return "Biblioteka [naziv=" + naziv + ", adresa=" + adresa + ", radnoVreme=" + radnoVreme + ", telefon="
					+ telefon + ", id=" + id +   "]";
		}
		
		
		public  boolean izbrisiContentFajla(String path) {
			
			
	        try {
	            FileWriter writer = new FileWriter(path);
	            writer.write("");
	            writer.close();
	        } catch(IOException e) {
	            e.printStackTrace();
	            return false;
	        }
	        return true;
	    
		
	}
		
		public String generisiIDBiblioteka() {
	        String idBiblioteka = "b-";
	        for(int i=0;i<6;i++) {
	            int broj = (int) Math.floor(Math.random()*9);
	            idBiblioteka += Integer.toString(broj);
	        }
	        return idBiblioteka;
	    }
		
		public ArrayList<Clan> neobrisaniClanovi(){
			ArrayList<Clan> clanovi = new ArrayList<Clan>();
			for(Clan c: sviClanovi) {
				if(c.isJeObrisan() == false) {
					
					clanovi.add(c);
					
				}
			
			}
			return clanovi;
		}
		public ArrayList<Iznajmljivanje>neobrisanaIznajmljivanja(){
			ArrayList<Iznajmljivanje> iznajmljivanja = new ArrayList<Iznajmljivanje>();
			for(Iznajmljivanje i: svaIznajmljivanja) {
				if(i.isObrisan()==false) {
					iznajmljivanja.add(i);
				}
			}
			return iznajmljivanja;
		}
		
		public ArrayList<Administratori>neobrisaniAdmini(){
			ArrayList<Administratori>admini = new ArrayList<Administratori>();
			for(Administratori a: sviAdmini) {
				if(a.isJeObrisan() == false) {
					admini.add(a);
				}
			}
			return admini;
			
		}
		
		public ArrayList<Bibliotekari> neobrisaniBibliotekari(){
			ArrayList<Bibliotekari> bibliotekari = new ArrayList<Bibliotekari>();
			for(Bibliotekari b: sviBibliotekari) {
				if(b.isJeObrisan() == false) {
					bibliotekari.add(b);
				}
			}
			return bibliotekari;
		}
		
		public ArrayList<Knjiga>neobrisaneKnjige(){
			ArrayList<Knjiga>knjige = new ArrayList<Knjiga>();
			for(Knjiga k:sveKnjige) {
				if(k.isObrisan() == false) {
					knjige.add(k);
				}
			}
			return knjige;
		}
		
		public ArrayList<Primerak>neobrisaniPrimerci(){
			ArrayList<Primerak>primerci = new ArrayList<Primerak>();
			for(Primerak p: sviPrimerci) {
				if(p.isObrisan()==false) {
					primerci.add(p);
				}
			}
			return primerci;
		}
		
		public ArrayList<TipClanarine>neobrisaniTipovi(){
			ArrayList<TipClanarine>tipovi = new ArrayList<TipClanarine>();
			for(TipClanarine t: sviTipovi) {
				if(t.isObrisan()==false) {
					tipovi.add(t);
				}
			}
			return tipovi;
		}
		public ArrayList<Zaposleni>neobrisaniZaposleni(){
			ArrayList<Zaposleni> zaposleni = new ArrayList<Zaposleni>();
			for(Administratori a: neobrisaniAdmini()) {
				if(a.isJeObrisan()==false) {
					zaposleni.add(a);
				}
				
			}
			for(Bibliotekari b: neobrisaniBibliotekari()) {
				if(b.isJeObrisan()==false) {
					zaposleni.add(b);
				}
			}
			return zaposleni;
		}
		
	
		
		public ArrayList<Zanr>neobrisaniZanrovi(){
			ArrayList<Zanr>zanrovi = new ArrayList<Zanr>();
			for(Zanr z: sviZanrovi) {
				if(z.isObrisan()== false) {
					zanrovi.add(z);
				}
			}
			return zanrovi;
		}
		public ArrayList<Primerak>neiznajmljeniPrimerci(){
			ArrayList<Primerak>primerci = new ArrayList<Primerak>();
			for(Primerak p: neobrisaniPrimerci()) {
				if(p.isIznamljena() == false) {
					primerci.add(p);
				}
			}
			return primerci;
		}
		public ArrayList<Clan> aktivniClanovi(){
			this.updateAktivnost();
			ArrayList<Clan> clanovi = new ArrayList<Clan>();
			for(Clan c: sviClanovi) {
				if(c.isAktivnost()== true) {
					clanovi.add(c);					
				}
			}
			return clanovi;
		}
		public ArrayList<Clan> neaktivniClanovi(){
			this.updateAktivnost();
			ArrayList<Clan> clanovi = new ArrayList<Clan>();
			for(Clan c: sviClanovi) {
				if(c.isAktivnost()== false) {
					clanovi.add(c);					
				}
			}
			return clanovi;
		}
		
		
		public Zaposleni loginZaposleni(String korisnickoIme,String lozinka) {
			for(Zaposleni z:neobrisaniZaposleni()) {
				if(z.getKorisnickoIme().equalsIgnoreCase(korisnickoIme)&&
						z.getLozinka().equals(lozinka) && !z.isJeObrisan()) {
					return z;
				}
			}
			return null;
		}
		 public ArrayList<Iznajmljivanje> ucitajIznajmljivanje(){
		    	try {
		    		File iznajmljivanjeFajl = new File("src/data/iznajmljivanja.txt");
		    		BufferedReader reader = new BufferedReader(new FileReader(iznajmljivanjeFajl));
		    		String linija;
		    		while((linija = reader.readLine())!= null) {
		    			String[] splitLinije = linija.split("\\|");
		    			LocalDate datumIznajmljivanja = LocalDate.parse(splitLinije[0]);
		    			LocalDate datumVracanja = LocalDate.parse(splitLinije[1]);
		    			String[] splitLinije2 = splitLinije[2].split(",");
		    			ArrayList<Primerak> primerci = new ArrayList<Primerak>();
//		    			for(Primerak p: sviPrimerci) {
//		    				if(p.getId().equals(splitLinije[2])) {
//		    					primerci = p;
//		    				}		
//		    			}
//		    			for(Primerak p : primerci) {
//		    				if(p.getId().equals(splitLinije2))
//		    			}
//		    		
		    			for(int i=0;i<splitLinije2.length;i++) {
		    				for(Primerak p : sviPrimerci) {
		    					if(p.getId().equals(splitLinije2[i])) {
		    						primerci.add(p);
		    					}
		    				}
		    			}
		    			Clan clan = null;
		    			for(Clan c:sviClanovi) {
		    				if(c.getBrClanskeKarte().equals(splitLinije[3])) {
		    					clan = c;
		    				}
		    			}
		    			Zaposleni zaposleni = null  ;
		    			for(Zaposleni z: neobrisaniZaposleni()) {
		    				if(z.getId().equals(splitLinije[4])) {
		    					zaposleni = z;
		    				}
		    			}
		    			boolean obrisan = Boolean.parseBoolean(splitLinije[5]);
		    			String id = splitLinije[6];
		    			
		    			Iznajmljivanje iznajmljivanje = new Iznajmljivanje(datumIznajmljivanja,datumVracanja,primerci,clan,zaposleni,obrisan,id);
		    			
		    			svaIznajmljivanja.add(iznajmljivanje);
		    		}
		    		reader.close();
		    		}catch(IOException e) { e.printStackTrace(); }
				return svaIznajmljivanja;
		    	
		    }
		public  boolean validnostDatum(String datumStr) {
			LocalDate datum;
			try {
				datum = LocalDate.parse(datumStr);
				
			}catch (DateTimeException e) {
				return false;
				// TODO: handle exception
			}
			return true;
		}
		public  boolean validnostInteger(String integerStr) {
			Integer integer;
			try {
				integer = Integer.parseInt(integerStr);
			}catch (NumberFormatException e) {
				return false;
				// TODO: handle exception
			}
			return true;
		}
		public boolean validnostDouble(String doubleStr) {
			Double doub;
			try {
				doub = Double.parseDouble(doubleStr);
			} catch (NumberFormatException e) {
				return false;
				// TODO: handle exception
			}
			return true;
		} 
		public void updateAktivnost() {
			for(Clan c: this.sviClanovi) {
				if(c.getDatumPoslednjeUplate().plusMonths(c.getBrojMeseci()).isBefore(LocalDate.now())) {
					c.setAktivnost(false);
				}else {
					c.setAktivnost(true);
				}
			}
		}
		public boolean validnostKorisnickoIme(String korisnickoIme) {
			for(Zaposleni z: neobrisaniZaposleni()) {
				if(z.getKorisnickoIme().equals(korisnickoIme)) {
					return false;
				}
			}
			return true;
		}
		
		public boolean validnostZanr(String opis) {
			for(Zanr z: neobrisaniZanrovi()) {
				if(z.getOpis().equals(opis.toLowerCase())) {
					return false;
					
				}
			}
			return true;
		}
		public boolean validnostTipClanarine(String opis) {
			for(TipClanarine tip: neobrisaniTipovi()) {
				if(tip.getOpis().equals(opis)) {
					return false;
				}
			}
			return true;
		}
		public boolean validnostJMBG(String jmbg) {
			Pattern ptrn = Pattern.compile("[0-9]{13}"); 
			Matcher match = ptrn.matcher(jmbg);
			return (match.find() && match.group().equals(jmbg));
		}
		public boolean validnostJmbgClan(String jmbg) {
			for(Clan c: aktivniClanovi()) {
				if(c.getJMBG().equals(jmbg)) {
					return false;
				}
				
			}
			return true;
		}
		public boolean validnostJmbgZaposleni(String jmbg) {
			for(Zaposleni z:neobrisaniZaposleni()) {
				if(z.getJMBG().equals(jmbg)) {
					return false;
				}
				
			}
			return true;
		}
		public Primerak nadjiPrimerak(String id) {
			Primerak primerak = new Primerak();
			for(Primerak p: neobrisaniPrimerci()) {
				if(p.getId().equals(id)) {
					
					primerak = p;
				}
			}
			return primerak;
		}
		
	

}
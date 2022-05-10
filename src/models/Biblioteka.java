package models;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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
    
    private ArrayList<Zaposleni> sviZaposleni = new ArrayList<Zaposleni>();
    
    private ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
    
    private ArrayList<TipClanarine> sviTipovi = new ArrayList<TipClanarine>();
    
    private ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
    
    public Biblioteka() {
    	
    	this.naziv = "";
		this.adresa = "";
		this.radnoVreme = "";
		this.telefon = "";
		this.id = "";
		this.sveKnjige = null;
		this.sviClanovi = null;
		this.sviZaposleni = null;
		
		this.sviZanrovi = null;
    }
    
    

	public Biblioteka(String naziv, String adresa, String radnoVreme, String telefon, String id,ArrayList<Knjiga> sveKnjige,
			ArrayList<Clan> sviClanovi,ArrayList<Zaposleni> sviZaposleni,ArrayList<Primerak> sviPrimerci,ArrayList<TipClanarine> sviTipovi,
			ArrayList<Zanr>sviZanrovi) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.radnoVreme = radnoVreme;
		this.telefon = telefon;
		this.id = id;
		this.sveKnjige = sveKnjige;
		this.sviClanovi = sviClanovi;
		this.sviZaposleni = sviZaposleni;
		this.sviPrimerci = sviPrimerci;
		this.sviTipovi = sviTipovi;
		this.sviZanrovi = sviZanrovi;
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

	public ArrayList<Zaposleni> getSviZaposleni() {
		return sviZaposleni;
	}

	public void setSviZaposleni(ArrayList<Zaposleni> sviZaposleni) {
		this.sviZaposleni = sviZaposleni;
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



	public ArrayList<Zanr> getSviZanrovi() {
		return sviZanrovi;
	}



	public void setSviZanrovi(ArrayList<Zanr> sviZanrovi) {
		this.sviZanrovi = sviZanrovi;
	}
	public ArrayList<Knjiga>  ucitajKnjige(ArrayList<Zanr>sviZanrovi) {
		ArrayList<Knjiga> knjige = new ArrayList<Knjiga>();
		try {
			File fajlKnjiga = new File("src/data/knjiga.txt");
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
				
				Knjiga knjiga = new Knjiga(naslovKnjiga,orgNaslovKnjiga,pisacKnjiga,godinaObjavljivanjaKnjiga,
						opisKnjiga,idKnjiga,zanrovi,jezik);
				knjige.add(knjiga);
				
				
				
			}
			reader.close();
			
			
		}catch(IOException e) {
			e.printStackTrace();
		
	}
		return knjige;

	}
	public static   ArrayList<Clan> ucitajClanove(ArrayList<TipClanarine> sviTipovi) {
		ArrayList<Clan> clanovi = new ArrayList<Clan>();
		try {
			File clanFajl = new File("src/data/Clan.txt");
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
				clanovi.add(clan);
			}
			reader.close();
		}catch(IOException e) {
				e.printStackTrace();
			}
		return clanovi;
		}
	
	public static ArrayList<TipClanarine> ucitajTipove(TipClanarine tipClanarine){
		ArrayList<TipClanarine> tipovi = new ArrayList<TipClanarine>();
		try {
			File tipFajl = new File("src/data/tipovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(tipFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String[] splitLinije = linija.split("\\|");
				String idTip = splitLinije[0];
				String opisTip = splitLinije[1];
				double cenaTip = Double.parseDouble(splitLinije[2]);
				TipClanarine tip = new TipClanarine(idTip,opisTip,cenaTip);
				tipovi.add(tip);
				
			}
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		
	}
		return tipovi;
		
	}
	
	public ArrayList<Primerak> ucitajPrimerke(){
		try {
			File primerakFajl = new File("src/data/primerak.txt");
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
				Primerak primerak = new Primerak(knjiga,brojStrana,godinaObjavljivanja,iznajmljena,id,jezik,tipPoveza);
				
				sviPrimerci.add(primerak);
			}
			reader.close();
			
		}catch(IOException e) {
			e.printStackTrace();	
	}
	return sviPrimerci;

	}
    
    

}
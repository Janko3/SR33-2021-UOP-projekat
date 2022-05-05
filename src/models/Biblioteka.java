package models;


import java.util.ArrayList;

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

    
    public Biblioteka() {
    	
    	this.naziv = "";
		this.adresa = "";
		this.radnoVreme = "";
		this.telefon = "";
		this.id = "";
		this.sveKnjige = null;
		this.sviClanovi = null;
		this.sviZaposleni = null;
		this.sviPrimerci = null;
    }
    
    

	public Biblioteka(String naziv, String adresa, String radnoVreme, String telefon, String id,ArrayList<Knjiga> sveKnjige,ArrayList<Clan> sviClanovi,ArrayList<Zaposleni> sviZaposleni,ArrayList<Primerak> sviPrimerci) {
		this.naziv = naziv;
		this.adresa = adresa;
		this.radnoVreme = radnoVreme;
		this.telefon = telefon;
		this.id = id;
		this.sveKnjige = sveKnjige;
		this.sviClanovi = sviClanovi;
		this.sviZaposleni = sviZaposleni;
		this.sviPrimerci = sviPrimerci;
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
	
	


    
    

}
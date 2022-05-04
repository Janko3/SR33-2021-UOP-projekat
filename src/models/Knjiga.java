package models;

import enumerations.Jezik;

public class Knjiga {

    

    private String naslov;

    private String originalniNaslov;

    private String pisac;

    private int godinaObjavljivanja;

    private String opis;

    private int id;

    private boolean obrisan;
    
    private Zanr zanr;
    
    private Jezik jezik;
    
    
    public Knjiga() {
    	
    	this.naslov = "";
		this.originalniNaslov = "";
		this.pisac = "";
		this.godinaObjavljivanja = -1;
		this.opis = "";
		this.id = -1;
		this.obrisan = false;
		this.zanr = null;
		this.jezik = null;
    }

	public Knjiga(String naslov, String originalniNaslov, String pisac, int godinaObjavljivanja, String opis, int id,Zanr zanr,Jezik jezik
			) {
		this.naslov = naslov;
		this.originalniNaslov = originalniNaslov;
		this.pisac = pisac;
		this.godinaObjavljivanja = godinaObjavljivanja;
		this.opis = opis;
		this.id = id;
		this.obrisan = false;
		this.zanr = zanr;
		this.jezik = jezik;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getOriginalniNaslov() {
		return originalniNaslov;
	}

	public void setOriginalniNaslov(String originalniNaslov) {
		this.originalniNaslov = originalniNaslov;
	}

	public String getPisac() {
		return pisac;
	}

	public void setPisac(String pisac) {
		this.pisac = pisac;
	}

	public int getGodinaObjavljivanja() {
		return godinaObjavljivanja;
	}

	public void setGodinaObjavljivanja(int godinaObjavljivanja) {
		this.godinaObjavljivanja = godinaObjavljivanja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Zanr getZanr() {
		return zanr;
	}

	public void setZanr(Zanr zanr) {
		this.zanr = zanr;
	}

	public Jezik getJezik() {
		return jezik;
	}

	public void setJezik(Jezik jezik) {
		this.jezik = jezik;
	}



    
	

}
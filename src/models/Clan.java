package models;
import java.time.LocalDate;

import enumerations.Pol;


public class Clan extends Osoba {
    
	protected String brClanskeKarte;

    protected LocalDate datumPoslednjeUplate;

    protected int brojMeseci;

    protected boolean aktivnost;

    
    
    protected TipClanarine tipClanarine;
    
    
    
    public Clan() {
    	
    	this.brClanskeKarte = "";
    	this.datumPoslednjeUplate = null;
    	this.brojMeseci = -1;
    	this.aktivnost = true;
    	this.tipClanarine = null;
    	
    }

	public Clan(String brClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseci, boolean aktivnost,String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan);
		this.brClanskeKarte = brClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseci = brojMeseci;
		this.aktivnost = aktivnost;
		
		
	}

	public String getBrClanskeKarte() {
		return brClanskeKarte;
	}

	public void setBrClanskeKarte(String brClanskeKarte) {
		this.brClanskeKarte = brClanskeKarte;
	}

	public LocalDate getDatumPoslednjeUplate() {
		return datumPoslednjeUplate;
	}

	public void setDatumPoslednjeUplate(LocalDate datumPoslednjeUplate) {
		this.datumPoslednjeUplate = datumPoslednjeUplate;
	}

	public int getBrojMeseci() {
		return brojMeseci;
	}

	public void setBrojMeseci(int brojMeseci) {
		this.brojMeseci = brojMeseci;
	}

	public boolean isAktivnost() {
		return aktivnost;
	}

	public void setAktivnost(boolean aktivnost) {
		this.aktivnost = aktivnost;
	}




	




	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}




	public void setTipClanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
	}






	

}
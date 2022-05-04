package models;
import java.time.LocalDate;

import enumerations.Pol;


public class Clan extends Osoba {
    
	protected int brClanskeKarte;

    protected LocalDate datumPoslednjeUplate;

    protected int brojMeseci;

    protected boolean aktivnost;

    protected boolean obrisan;
    
    protected TipClanarine tipClanarine;
    
    
    
    public Clan() {
    	
    	this.brClanskeKarte = -1;
    	this.datumPoslednjeUplate = null;
    	this.brojMeseci = -1;
    	this.aktivnost = true;
    	this.obrisan = false;
    	this.tipClanarine = null;
    	
    }

	public Clan(int brClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseci, boolean aktivnost,String ime, String prezime, String JMBG, String adresa, Pol pol) {
		super(ime, prezime, JMBG, adresa, pol);
		this.brClanskeKarte = brClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseci = brojMeseci;
		this.aktivnost = aktivnost;
		this.obrisan = false;
		
	}

	public int getBrClanskeKarte() {
		return brClanskeKarte;
	}

	public void setBrClanskeKarte(int brClanskeKarte) {
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




	public boolean isObrisan() {
		return obrisan;
	}




	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}




	public TipClanarine getTipClanarine() {
		return tipClanarine;
	}




	public void setTipClanarine(TipClanarine tipClanarine) {
		this.tipClanarine = tipClanarine;
	}






	

}
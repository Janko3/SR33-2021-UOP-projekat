package models;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

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

	public Clan(String brClanskeKarte, LocalDate datumPoslednjeUplate, int brojMeseci, 
			boolean aktivnost,String ime, String prezime, String JMBG, String adresa, Pol pol, boolean jeObrisan,TipClanarine tipClanarine) {
		super(ime, prezime, JMBG, adresa, pol, jeObrisan);
		this.brClanskeKarte = brClanskeKarte;
		this.datumPoslednjeUplate = datumPoslednjeUplate;
		this.brojMeseci = brojMeseci;
		this.aktivnost = aktivnost;
		this.tipClanarine = tipClanarine;
		
		
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
	
	

	@Override
	public String toString() {
		return "Clan [brClanskeKarte=" + brClanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
				+ ", brojMeseci=" + brojMeseci + ", aktivnost=" + aktivnost + 
				 ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol=" + pol
				+ ", jeObrisan=" + jeObrisan + ", tipClanarine=" + tipClanarine +"]";
	}
	
	public String generisiIDClan() {
        String idClan = "C-";
        for(int i=0;i<6;i++) {
            int broj = (int) Math.floor(Math.random()*9);
            idClan += Integer.toString(broj);
        }
        return idClan;
    }
	
	}
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
	
	private static String pripremaZaUpis(Clan clan) {
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s|%s|%s|%s", clan.getBrClanskeKarte(), clan.getDatumPoslednjeUplate(), clan.getBrojMeseci(),clan.isAktivnost(),clan.getIme(),clan.getPrezime(),
    			clan.getJMBG(),clan.getAdresa(),clan.getPol(),clan.isJeObrisan(),clan.getTipClanarine().getId());
    }
	
	public static void upisiClana(Clan clan) {
		try {
			BufferedWriter clanFajl = new BufferedWriter(new FileWriter("src/data/clan.txt"));
			clanFajl.write(pripremaZaUpis(clan));
			clanFajl.close();
			
		}catch(IOException e) { e.printStackTrace(); }
	}

	@Override
	public String toString() {
		return "Clan [brClanskeKarte=" + brClanskeKarte + ", datumPoslednjeUplate=" + datumPoslednjeUplate
				+ ", brojMeseci=" + brojMeseci + ", aktivnost=" + aktivnost + 
				 ", prezime=" + prezime + ", JMBG=" + JMBG + ", adresa=" + adresa + ", ime=" + ime + ", pol=" + pol
				+ ", jeObrisan=" + jeObrisan + ", tipClanarine=" + tipClanarine +"]";
	}
	
	}
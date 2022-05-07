package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
	
	public static ArrayList<Clan> ucitajClanove(ArrayList<TipClanarine> sviTipovi) {
		ArrayList<Clan> clanovi = new ArrayList<Clan>();
		try {
			File clanFajl = new File("src/data/Clan.txt");
			BufferedReader reader = new BufferedReader(new FileReader(clanFajl));
			String linija;
			while((linija = reader.readLine()) != null) {
				String [] splitLinije = linija.split("\\|");
				String imeClan = splitLinije[0];
				String prezimeClan = splitLinije[1];
				String adresaClan = splitLinije[2];
				String JMBGClan = splitLinije[3];
				Pol pol = Pol.valueOf(splitLinije[4]);
				String brClanskeKarteClan = splitLinije[5];
				LocalDate datumPoslednjeUplate =  LocalDate.parse(splitLinije[6]); 
				int brMeseciClan = Integer.parseInt(splitLinije[7]);
				boolean aktivnostClan = Boolean.parseBoolean(splitLinije[8]);
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
	}
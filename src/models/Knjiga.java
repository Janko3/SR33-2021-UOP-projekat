package models;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import enumerations.Jezik;

public class Knjiga {

    

    private String naslov;

    private String originalniNaslov;

    private String pisac;

    private int godinaObjavljivanja;

    private String opis;

    private String id;

    private boolean obrisan;
    
    private Zanr zanr;
    
    private Jezik jezik;
    
    
    public Knjiga() {
    	
    	this.naslov = "";
		this.originalniNaslov = "";
		this.pisac = "";
		this.godinaObjavljivanja = -1;
		this.opis = "";
		this.id = "";
		this.obrisan = false;
		this.zanr = null;
		this.jezik = null;
    }

	public Knjiga(String naslov, String originalniNaslov, String pisac, int godinaObjavljivanja, String opis, String id,Zanr zanr,Jezik jezik
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	private static String pripremaZaUpis(Knjiga knjiga) {
    	return String.format("%s|%s|%s|%s|%s|%s|%s|%s", knjiga.getNaslov(), knjiga.getOriginalniNaslov(), knjiga.getPisac(), Integer.toString(knjiga.getGodinaObjavljivanja()),
    			knjiga.getOpis(),knjiga.getId(),knjiga.getZanr().getId(),knjiga.getJezik());
    }
	public static void upisiKnjigu(Knjiga knjiga) {
		try {
			BufferedWriter knjigeFile = new BufferedWriter(new FileWriter("src/data/knjiga.txt"));
			knjigeFile.write(pripremaZaUpis(knjiga) + "\n");
			knjigeFile.close();
			
		} catch(IOException err) { err.printStackTrace(); }
		
	}
	
	public static void ucitajKnjige(ArrayList<Zanr>sviZanrovi) {
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

	}
	

}
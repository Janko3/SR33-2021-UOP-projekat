package models;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Iznajmljivanje {

    

    private LocalDate datumIznajmljivanje;

    private LocalDate datumVracanja;
    
    private Primerak primerakKnjige;
    
    private Clan clan;
    
    private Zaposleni zaposleni;
    
    private boolean obrisan;
    
    private String id;
    
    public Iznajmljivanje() {
    	
    	this.datumIznajmljivanje = null;
		this.datumVracanja = null;
		this.primerakKnjige = null;
		this.clan = null;
		this.zaposleni = null;
		this.obrisan = false;
		this.id = "";
    }

	public Iznajmljivanje(LocalDate datumIznajmljivanje, LocalDate datumVracanja,Primerak primerakKnjige,Clan clan,Zaposleni zaposleni,boolean obrisan,String id) {
		this.datumIznajmljivanje = datumIznajmljivanje;
		this.datumVracanja = datumVracanja;
		this.primerakKnjige = primerakKnjige;
		this.clan = clan;
		this.zaposleni = zaposleni;
		this.obrisan = obrisan;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isObrisan() {
		return obrisan;
	}

	public void setObrisan(boolean obrisan) {
		this.obrisan = obrisan;
	}

	public LocalDate getDatumIznajmljivanje() {
		return datumIznajmljivanje;
	}

	public void setDatumIznajmljivanje(LocalDate datumIznajmljivanje) {
		this.datumIznajmljivanje = datumIznajmljivanje;
	}

	public LocalDate getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(LocalDate datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public Primerak getPrimerakKnjige() {
		return primerakKnjige;
	}

	public void setPrimerakKnjige(Primerak primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Zaposleni getZaposleni() {
		return zaposleni;
	}

	public void setZaposleni(Zaposleni zaposleni) {
		this.zaposleni = zaposleni;
	}

	@Override
	public String toString() {
		return "Iznajmljivanje [datumIznajmljivanje=" + datumIznajmljivanje + ", datumVracanja=" + datumVracanja
				+ ", primerakKnjige=" + primerakKnjige + ", clan=" + clan + ", zaposleni=" + zaposleni +",obrisan=" +obrisan +",id="+id+"]";
	}

	public String generisiIDIznajmljivanje() {
        String idClan = "I-";
        for(int i=0;i<6;i++) {
            int broj = (int) Math.floor(Math.random()*9);
            idClan += Integer.toString(broj);
        }
        return idClan;
    }
    
    

}
package models;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Iznajmljivanje {

    

    private LocalDate datumIznajmljivanje;

    private LocalDate datumVracanja;
    
    private Primerak primerakKnjige;
    
    private Clan clan;
    
    private Zaposleni zaposleni;
    
    public Iznajmljivanje() {
    	
    	this.datumIznajmljivanje = null;
		this.datumVracanja = null;
		this.primerakKnjige = null;
		this.clan = null;
		this.zaposleni = null;
    }

	public Iznajmljivanje(LocalDate datumIznajmljivanje, LocalDate datumVracanja,Primerak primerakKnjige,Clan clan,Zaposleni zaposleni) {
		this.datumIznajmljivanje = datumIznajmljivanje;
		this.datumVracanja = datumVracanja;
		this.primerakKnjige = primerakKnjige;
		this.clan = clan;
		this.zaposleni = zaposleni;
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
				+ ", primerakKnjige=" + primerakKnjige + ", clan=" + clan + ", zaposleni=" + zaposleni + "]";
	}

	
    
    

}
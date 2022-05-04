package models;
import java.time.LocalDateTime;


public class Iznajmljivanje {

    

    private LocalDateTime datumIznajmljivanje;

    private LocalDateTime datumVracanja;
    
    private Primerak primerakKnjige;
    
    public Iznajmljivanje() {
    	
    	this.datumIznajmljivanje = null;
		this.datumVracanja = null;
		this.primerakKnjige = null;
    }

	public Iznajmljivanje(LocalDateTime datumIznajmljivanje, LocalDateTime datumVracanja,Primerak primerakKnjige) {
		this.datumIznajmljivanje = datumIznajmljivanje;
		this.datumVracanja = datumVracanja;
		this.primerakKnjige = primerakKnjige;
	}

	public LocalDateTime getDatumIznajmljivanje() {
		return datumIznajmljivanje;
	}

	public void setDatumIznajmljivanje(LocalDateTime datumIznajmljivanje) {
		this.datumIznajmljivanje = datumIznajmljivanje;
	}

	public LocalDateTime getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(LocalDateTime datumVracanja) {
		this.datumVracanja = datumVracanja;
	}

	public Primerak getPrimerakKnjige() {
		return primerakKnjige;
	}

	public void setPrimerakKnjige(Primerak primerakKnjige) {
		this.primerakKnjige = primerakKnjige;
	}
    
    

}
package models;
import java.time.LocalDate;
import java.time.LocalDateTime;


public class Iznajmljivanje {

    

    private LocalDate datumIznajmljivanje;

    private LocalDate datumVracanja;
    
    private Primerak primerakKnjige;
    
    public Iznajmljivanje() {
    	
    	this.datumIznajmljivanje = null;
		this.datumVracanja = null;
		this.primerakKnjige = null;
    }

	public Iznajmljivanje(LocalDate datumIznajmljivanje, LocalDate datumVracanja,Primerak primerakKnjige) {
		this.datumIznajmljivanje = datumIznajmljivanje;
		this.datumVracanja = datumVracanja;
		this.primerakKnjige = primerakKnjige;
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

	@Override
	public String toString() {
		return "Iznajmljivanje [datumIznajmljivanje=" + datumIznajmljivanje + ", datumVracanja=" + datumVracanja
				+ ", primerakKnjige=" + primerakKnjige + "]";
	}
    
    

}
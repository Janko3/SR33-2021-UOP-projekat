package models;

public class TipClanarine {

    

    private String id;

    private String opis;

    private double cena;
    
    public TipClanarine() {
    	this.id = "";
		this.opis = "";
		this.cena = -1;
    }

	public TipClanarine(String id, String opis, double cena) {
		this.id = id;
		this.opis = opis;
		this.cena = cena;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}
    
    

}
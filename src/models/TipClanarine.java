package models;

public class TipClanarine {

    

    private int id;

    private String opis;

    private double cena;
    
    public TipClanarine() {
    	this.id = -1;
		this.opis = "";
		this.cena = -1;
    }

	public TipClanarine(int id, String opis, double cena) {
		this.id = id;
		this.opis = opis;
		this.cena = cena;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
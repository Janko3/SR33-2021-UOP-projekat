package models; 

public class Zanr {

    /**
     * Default constructor
     */
   

    /**
     * 
     */
    private String opis;

    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private String oznaka;

    public Zanr() {
    	this.opis = "";
		this.id = -1;
		this.oznaka = "";
    }
    
	public Zanr(String opis, int id, String oznaka) {
		this.opis = opis;
		this.id = id;
		this.oznaka = oznaka;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public void setOznaka(String oznaka) {
		this.oznaka = oznaka;
	}
    
    

}
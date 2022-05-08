package main;


import models.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipClanarine tipClanarine = new TipClanarine("penzioner","Clanarina",100.00);
		TipClanarine.upisiTipove(tipClanarine);
		Zanr zanr = new Zanr("opis","akcija","akc.");
		Zanr.upisiZanr(zanr);
		Knjiga knjiga = new Knjiga("Rat i mir","Rat i mir","Tolstoj",1826,"opis knjige","011",zanr,enumerations.Jezik.SRPSKI);
		Knjiga.upisiKnjigu(knjiga);
		
		
	}

}

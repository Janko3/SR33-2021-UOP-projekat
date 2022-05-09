package main;


import java.time.LocalDate;
import java.util.ArrayList;

import models.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TipClanarine tipClanarine = new TipClanarine("1","penzioner",100.00);
		TipClanarine.upisiTipove(tipClanarine);
		
		Zanr zanr = new Zanr("Akcija","1","action");
		Zanr.upisiZanr(zanr);
		ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
		ArrayList<TipClanarine> sviTipovi = new ArrayList<TipClanarine>();
		sviTipovi.add(tipClanarine);
		sviZanrovi.add(zanr);
		Knjiga knjiga = new Knjiga("Rat i mir","Rat i mir","Tolstoj",1826,"opis knjige","011",zanr,enumerations.Jezik.SRPSKI);
		Knjiga.upisiKnjigu(knjiga);		
		Biblioteka biblioteka = new Biblioteka();
		System.out.println(biblioteka.ucitajKnjige(sviZanrovi));		
		Clan clan = new Clan("12",LocalDate.parse("2022-05-05"),1,true,"Petar","Petrovic","08071996793821","bb",enumerations.Pol.MUSKI,false,tipClanarine);
		Clan.upisiClana(clan);
		System.out.println(Biblioteka.ucitajClanove(sviTipovi));
		
	}

}

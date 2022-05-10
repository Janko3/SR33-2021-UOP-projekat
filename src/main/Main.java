package main;


import java.time.LocalDate;
import java.util.ArrayList;

import enumerations.Jezik;
import enumerations.Pol;
import enumerations.TipPoveza;
import models.*;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biblioteka biblioteka = new Biblioteka();
		
		TipClanarine tipClanarine1 = new TipClanarine("1","penzioner",100.00);
		TipClanarine tipClanarine2 = new TipClanarine("2","decija",150.00);	
		ArrayList<TipClanarine> sviTipovi = new ArrayList<TipClanarine>();
		sviTipovi.add(tipClanarine1);
		sviTipovi.add(tipClanarine2);
		biblioteka.upisiTip(sviTipovi);
		System.out.println(biblioteka.ucitajTipove());
		
		Clan clan1 = new Clan("12",LocalDate.parse("2022-05-05"),1,true,"Petar","Petrovic","08071996793821","bb",Pol.MUSKI,false,tipClanarine1);
		ArrayList<Clan> sviClanovi = new ArrayList<Clan>();
		sviClanovi.add(clan1);
		biblioteka.upisiClan(sviClanovi);
		System.out.println(biblioteka.ucitajClanove(sviTipovi));
		
		Zanr zanr1 = new Zanr("Akcija","1","action");
		ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
		sviZanrovi.add(zanr1);
		biblioteka.upisiZanr(sviZanrovi);
		System.out.println(biblioteka.ucitajZanrove());
		
		
		Knjiga knjiga1 = new Knjiga("Rat i mir","Rat i mir","Tolstoj",1826,"opis knjige","011",zanr1,Jezik.SRPSKI);
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		sveKnjige.add(knjiga1);
		biblioteka.upisiKnjigu(sveKnjige);
		System.out.println(biblioteka.ucitajKnjige(sviZanrovi));
		
		Primerak primerak1 = new Primerak(knjiga1,450,1826,true,"001",Jezik.SRPSKI,TipPoveza.MEKI);
		ArrayList<Primerak> sviPrimerci = new ArrayList<Primerak>();
		sviPrimerci.add(primerak1);
		biblioteka.upisiPrimerak(sviPrimerci);
		System.out.println(biblioteka.ucitajPrimerke());

		
		Administratori admin1 = new Administratori("Atzo","Atzic","08071996793821","bb",Pol.MUSKI,false,"atzo1","11111",1000.00,"2");
		Administratori admin2 = new Administratori("Atzo","Hercegovac","08071996793811","bb",Pol.MUSKI,false,"atzo2","11111",1000.00,"1");
		ArrayList<Administratori>sviAdmini = new ArrayList<Administratori>();
		sviAdmini.add(admin1);
		sviAdmini.add(admin2);
		biblioteka.upisiAdmini(sviAdmini);
		System.out.println(biblioteka.ucitajAdmine());
		
		Bibliotekari bibliotekar1 = new Bibliotekari("Matejko","Linuksas","08071996793821","bb",Pol.MUSKI,false,"linuxWTP","11111",1000.00,"3");
		ArrayList<Bibliotekari> sviBibliotekari = new ArrayList<Bibliotekari>();
		sviBibliotekari.add(bibliotekar1);
		biblioteka.upisiBibliotekara(sviBibliotekari);
		System.out.println(biblioteka.ucitajBibliotekare());
		
		
		Iznajmljivanje iznajmljivanje1 = new Iznajmljivanje(LocalDate.of(2022,05,05),LocalDate.of(2022, 06, 05),primerak1);
		ArrayList<Iznajmljivanje> svaIznajmljivanja = new ArrayList<Iznajmljivanje>();
		svaIznajmljivanja.add(iznajmljivanje1);
		biblioteka.upisiIznajmljivanje(svaIznajmljivanja);
		System.out.println(biblioteka.ucitajIznajmljivanje());
		
	}

}

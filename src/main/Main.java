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
		Biblioteka biblioteka = new Biblioteka("Borisov atelje","bb","0-24","+381 999999999","1");
		biblioteka.upisiBiblioteku();
		System.out.println(biblioteka.ucitajBiblioteku());
		
		
		TipClanarine tipClanarine1 = new TipClanarine("1","penzioner",100.00,false);
		TipClanarine tipClanarine2 = new TipClanarine("2","decija",150.00,false);	
		TipClanarine tipClanarine3 = new TipClanarine("3","ostali",250.00,false);
		ArrayList<TipClanarine> sviTipovi = new ArrayList<TipClanarine>();
		sviTipovi.add(tipClanarine1);
		sviTipovi.add(tipClanarine2);
		sviTipovi.add(tipClanarine3);
		biblioteka.upisiTip(sviTipovi);
		System.out.println(biblioteka.ucitajTipove());
		
		Clan clan1 = new Clan("12",LocalDate.parse("2022-05-05"),1,true,"Petar","Petrovic","08071996793821","bb",Pol.MUSKI,false,tipClanarine1);
		ArrayList<Clan> sviClanovi = new ArrayList<Clan>();
		sviClanovi.add(clan1);
		biblioteka.upisiClan(sviClanovi);
		System.out.println(biblioteka.ucitajClanove(sviTipovi));
		
		Zanr zanr1 = new Zanr("Akcija","1","action",false);
		ArrayList<Zanr> sviZanrovi = new ArrayList<Zanr>();
		sviZanrovi.add(zanr1);
		biblioteka.upisiZanr(sviZanrovi);
		System.out.println(biblioteka.ucitajZanrove());
		
		
		Knjiga knjiga1 = new Knjiga("Rat i mir","Rat i mir","Tolstoj",1826,"opis knjige","011",zanr1,Jezik.SRPSKI);
		ArrayList<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		sveKnjige.add(knjiga1);
		biblioteka.upisiKnjigu(sveKnjige);
		System.out.println(biblioteka.ucitajKnjige(sviZanrovi));
		
		Primerak primerak1 = new Primerak(knjiga1,450,1826,true,"001",Jezik.SRPSKI,TipPoveza.MEKI,false);
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
		
		
		Iznajmljivanje iznajmljivanje1 = new Iznajmljivanje(LocalDate.of(2022,05,05),LocalDate.of(2022, 06, 05),primerak1,clan1,admin1);
		ArrayList<Iznajmljivanje> svaIznajmljivanja = new ArrayList<Iznajmljivanje>();
		svaIznajmljivanja.add(iznajmljivanje1);
		biblioteka.upisiIznajmljivanje(svaIznajmljivanja);
		System.out.println(biblioteka.ucitajIznajmljivanje());
		
		Administratori admin = biblioteka.getSviAdmini().get(0);
		admin.DodatiNoveAdmine("Matejko", "Matejkovic", "32140839048", "Telep",Pol.MUSKI, false, "linuxas1", "lozinka", 1200);		
		admin.DodatiNoveBibliotekare("Matejko", "Aleksandrovic", "32140839048", "Telep",Pol.MUSKI, false, "linuxas2", "lozinka", 1200);		
		admin.DodatiNoveClanove(LocalDate.parse("2022-05-05"),1,true,"Petar","Petrovic","08071996793821","bb",Pol.MUSKI,false,tipClanarine1);
		
		Bibliotekari bibliotekar2 = biblioteka.getSviBibliotekari().get(0);
		bibliotekar2.DodatiNoveClanove(LocalDate.parse("2022-05-05"),1,true,"Petar","Petrovic","08071996793821","bb",Pol.MUSKI,false,tipClanarine1);		
		admin.DodajKnjigu("Rat i mir","Rat i mir","Tolstoj",1826,"opis knjige",zanr1,Jezik.SRPSKI);		
		bibliotekar2.DodajPrimerak(knjiga1,450,1826,false,Jezik.SRPSKI,TipPoveza.MEKI);
		bibliotekar2.DodajTip("penzioner", 100);
		admin.DodajZanr("Drama", "drama");
		
		admin.obrisiBibliotekara("3");
		bibliotekar2.obrisiKnjigu("011");
		admin.obrisiTip("3");
		bibliotekar2.obrisiZanr("1");
		admin.obrisiPrimerak("001");
		
		admin.obrisiAdmina("2");
		admin.updateAdmina("janko", "jankovic", "3219403", "bb", Pol.MUSKI, false, "jr3", "lozinka3", 1000, "2");
		admin.updateBibliotekara("Boza", "Bozic", "4324324", "bb", Pol.MUSKI, false, "bobinjo", "lozinkabobi", 1000, "3");
		bibliotekar2.updateClan("12", LocalDate.of(2022,05,23), 1, true, "Cukeli", "Cukeljovic", "83294832094", "bb", Pol.ZENSKI, false, tipClanarine3);
		admin.updateKnjiga("Sopenhauer kao vaspitac", "Schopenhauer as Educator", "Friedrich Nietzsche", 1874, "opis", "011", zanr1, Jezik.SRPSKI);
		admin.updatePrimerak(knjiga1, 300, 1900, false, "001", Jezik.SRPSKI, TipPoveza.TVRDI, false);
		admin.updateTip("1", "ostali", 250, false);
		bibliotekar2.updateZanr("Psiho-triler","1", "pt", false);
		admin.updateBiblioteka("BorisovAtelje", "bbb","0-24", "43285723532", "1");
		String clanzabrisanje = biblioteka.getSviClanovi().get(0).getBrClanskeKarte();
		bibliotekar2.obrisiClana(clanzabrisanje);
		System.out.println(biblioteka.neobrisaniClanovi());
		String adminzabrisanje = biblioteka.getSviAdmini().get(0).getId();
		admin.obrisiAdmina(adminzabrisanje);
		System.out.println(biblioteka.neobrisaniAdmini());
		
	}

}

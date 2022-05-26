package main;


import java.time.LocalDate;
import java.util.ArrayList;

import enumerations.Jezik;
import enumerations.Pol;
import enumerations.TipPoveza;
import models.*;
import view.MainWindow;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Biblioteka biblioteka = new Biblioteka();
		biblioteka.ucitajAdmine();
		biblioteka.ucitajBibliotekare();
		biblioteka.ucitajClanove(biblioteka.getSviTipovi());
		biblioteka.ucitajIznajmljivanje();
		biblioteka.ucitajKnjige(biblioteka.getSviZanrovi());
		biblioteka.ucitajPrimerke();
		biblioteka.ucitajTipove();
		biblioteka.ucitajZanrove();
		
		Administratori admin = biblioteka.getSviAdmini().get(0);
		Knjiga knjiga = biblioteka.getSveKnjige().get(0);
		
		

		
		MainWindow w = new MainWindow(biblioteka,admin);
		w.setVisible(true);
		
	}

}

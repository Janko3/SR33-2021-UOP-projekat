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
		biblioteka.ucitajTipove();
		biblioteka.ucitajZanrove();
		
		
		biblioteka.ucitajClanove(biblioteka.getSviTipovi());
		
		biblioteka.ucitajKnjige(biblioteka.getSviZanrovi());
		biblioteka.ucitajPrimerke();
		biblioteka.ucitajIznajmljivanje();
		
		
		Administratori admin = biblioteka.getSviAdmini().get(0);
		
		
		
		
		
		

		
		MainWindow w = new MainWindow(biblioteka,admin);
		w.setVisible(true);
		
	}

}

package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import models.Administratori;
import models.Biblioteka;

public class MainWindow extends JFrame{
	private JMenuBar mainMenu = new JMenuBar();
	private JMenu zaposleniMenu = new JMenu("Zaposleni");
	private JMenuItem adminiItem = new JMenuItem("Administratori");
	private JMenuItem bibliotekariItem = new JMenuItem("Bibliotekari");
	private JMenu clanoviMenu = new JMenu("Clanovi");
	private JMenuItem tipoviItem = new JMenuItem("Tipovi Clanarine");
	private JMenuItem aktivniClanoviItem = new JMenuItem("Aktivni");
	private JMenuItem neaktivniClanoviItem = new JMenuItem("Neaktivni");
	private JMenu knjigeMenu = new JMenu("Knjige");
	private JMenuItem knjigeItem = new JMenuItem("Knjige");
	private JMenuItem primerciItem = new JMenuItem("Primerci");
	private JMenuItem zanrItem = new JMenuItem("Zanrovi");
	
	private Biblioteka biblioteka;
	private Administratori prijavljeniAdmin;
	
	
	

	public MainWindow(Biblioteka biblioteka,Administratori prijavljeniAdmin) {
		this.biblioteka=biblioteka;
		this.prijavljeniAdmin= prijavljeniAdmin;
		setTitle("Administrator: " + prijavljeniAdmin.getKorisnickoIme());
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		
		// TODO Auto-generated constructor stub
	}
	private void initMenu() {
		setJMenuBar(mainMenu);
		mainMenu.add(zaposleniMenu);
		zaposleniMenu.add(adminiItem);
		zaposleniMenu.add(bibliotekariItem);
		mainMenu.add(clanoviMenu);
		clanoviMenu.add(tipoviItem);
		clanoviMenu.add(aktivniClanoviItem);
		clanoviMenu.add(neaktivniClanoviItem);
		mainMenu.add(knjigeMenu);
		knjigeMenu.add(knjigeItem);
		knjigeMenu.add(primerciItem);
		knjigeMenu.add(zanrItem);
		
	}
	private void initActions() {
		adminiItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriProzor ap = new AdministratoriProzor(biblioteka);
				ap.setVisible(true);
			}
		});
		bibliotekariItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekariProzor bp = new BibliotekariProzor(biblioteka);
				bp.setVisible(true);
				
			}
		});
	}

}

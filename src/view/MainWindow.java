package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import models.Administratori;
import models.Biblioteka;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;

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
	private JMenu iznajmljivanjaMenu = new JMenu("Iznajmljivanja");
	private JMenuItem iznajmljivanjaItem = new JMenuItem("Iznajmljivanja");
	private JLabel lblBibliotekaNaziv = new JLabel("Biblioteka");
	private JTextField txtBibliotekaNaziv = new JTextField(20);
	private JLabel lblBiblioAdresa = new JLabel("Adresa");
	private JTextField txtBiblioAdresa = new JTextField(20);
	private JLabel lblRadnoVremeBib = new JLabel("Radno vreme");
	private JTextField txtRadnoVremeBib = new JTextField(20);
	private JLabel lblIdBib = new JLabel("ID");
	private JTextField txtIdBib = new JTextField(10);
	private JLabel lblTelefon = new JLabel("Broj Telefona");
	private JTextField txtTelefon = new JTextField(20);
	private JButton btnUpdateBib = new JButton("Update");
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	
	

	public MainWindow(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka=biblioteka;
		this.prijavljeniZaposleni= prijavljeniZaposleni;
		setTitle("Zaposleni: " + prijavljeniZaposleni.getKorisnickoIme());
		
		setSize(500,500);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initMenu();
		initActions();
		
		// TODO Auto-generated constructor stub
	}
	private void initMenu() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		setJMenuBar(mainMenu);
		
		if(prijavljeniZaposleni.getId().contains("A-")) {
			mainMenu.add(zaposleniMenu);
			zaposleniMenu.add(adminiItem);
			zaposleniMenu.add(bibliotekariItem);
			
		}
		mainMenu.add(clanoviMenu);
		clanoviMenu.add(tipoviItem);
		clanoviMenu.add(aktivniClanoviItem);
		clanoviMenu.add(neaktivniClanoviItem);
		mainMenu.add(knjigeMenu);
		knjigeMenu.add(knjigeItem);
		knjigeMenu.add(primerciItem);
		knjigeMenu.add(zanrItem);
		mainMenu.add(iznajmljivanjaMenu);
		iznajmljivanjaMenu.add(iznajmljivanjaItem);
		add(lblBibliotekaNaziv);
		add(txtBibliotekaNaziv);
		add(lblBiblioAdresa);
		add(txtBiblioAdresa);
		add(lblRadnoVremeBib);
		add(txtRadnoVremeBib);
		add(lblTelefon);
		add(txtTelefon);
		add(lblIdBib);
		add(txtIdBib);
		add(btnUpdateBib);
		txtBibliotekaNaziv.setText(biblioteka.getNaziv());
		txtBiblioAdresa.setText(biblioteka.getAdresa());
		txtRadnoVremeBib.setText(biblioteka.getRadnoVreme());
		txtIdBib.setText(biblioteka.getId());
		txtTelefon.setText(biblioteka.getTelefon());
		txtIdBib.setEditable(false);
		
	}
	private void initActions() {
		adminiItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AdministratoriProzor ap = new AdministratoriProzor(biblioteka,prijavljeniZaposleni);
				ap.setVisible(true);
			}
		});
		bibliotekariItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BibliotekariProzor bp = new BibliotekariProzor(biblioteka,prijavljeniZaposleni);
				bp.setVisible(true);
				
			}
		});
		aktivniClanoviItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AktivniClanoviProzor ap = new AktivniClanoviProzor(biblioteka,prijavljeniZaposleni);
				ap.setVisible(true);
			}
		});
		neaktivniClanoviItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NeaktivniClanoviProzor np = new NeaktivniClanoviProzor(biblioteka);
				np.setVisible(true);
			}
		});
		knjigeItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				KnjigeProzor kp = new KnjigeProzor(biblioteka,prijavljeniZaposleni);
				kp.setVisible(true);
			}
		});
		tipoviItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TipoviProzor tp = new TipoviProzor(biblioteka,prijavljeniZaposleni);
				tp.setVisible(true);
			}
		});
		primerciItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PrimerciProzor pp = new PrimerciProzor(biblioteka,prijavljeniZaposleni);
				pp.setVisible(true);
				
			}
		});
		iznajmljivanjaItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				IznajmljivanjaProzor ip = new IznajmljivanjaProzor(biblioteka);
				ip.setVisible(true);
			}
		});
		zanrItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ZanroviProzor zp = new ZanroviProzor(biblioteka,prijavljeniZaposleni);
				zp.setVisible(true);
			}
		});
		btnUpdateBib.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtBibliotekaNaziv.getText().equals("")||txtBiblioAdresa.getText().equals("")|| txtRadnoVremeBib.getText().equals("")||txtTelefon.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				Administratori admin = (Administratori) prijavljeniZaposleni;
				admin.updateBiblioteka(txtBibliotekaNaziv.getText().trim(), txtBiblioAdresa.getText().trim(), txtRadnoVremeBib.getText().trim(), txtTelefon.getText().trim(), txtIdBib.getText());
				dispose();
				MainWindow mw = new MainWindow(biblioteka, admin);
				mw.setVisible(true);
				// TODO Auto-generated method stub
				
			}
		});
	}

}

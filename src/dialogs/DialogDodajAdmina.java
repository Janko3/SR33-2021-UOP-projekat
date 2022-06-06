package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import enumerations.Pol;
import models.Administratori;
import models.Biblioteka;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.AdministratoriProzor;
import view.BibliotekariProzor;

public class DialogDodajAdmina extends JDialog {
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	private JLabel lblIme = new JLabel("Ime");
	private JTextField txtIme = new JTextField(20);
	private JLabel lblPrezime = new JLabel("Prezime");
	private JTextField txtPrezime = new JTextField(20);
	private JLabel lblJmbg = new JLabel("JMBG");
	private JTextField txtJmbg = new JTextField(13);
	private JLabel lblAdresa = new JLabel("Adresa");
	private JTextField txtAdresa = new JTextField(20);
	private JLabel lblPol = new JLabel("Pol");
	private JComboBox<Pol> cmbxPol= new JComboBox<Pol>();
	private JLabel lblKorisnickoIme = new JLabel("Korisnicko ime");
	private JTextField txtKorisnickoIme = new JTextField(20);
	private JLabel lblLozinka = new JLabel("Lozinka");
	private JTextField txtLozinka = new JTextField(20);
	private JLabel lblPlata = new JLabel("Plata");
	private JTextField txtPlata = new JTextField(20);
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");

	public DialogDodajAdmina(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Dodaj Novog Admina");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		cmbxPol.setModel(new DefaultComboBoxModel<Pol>(Pol.values()));
		initGUI();
		initActions();
		// TODO Auto-generated constructor stub
	}
	
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblIme);
		add(txtIme);
		add(lblPrezime);
		add(txtPrezime);
		add(lblJmbg);
		add(txtJmbg);
		add(lblAdresa);
		add(txtAdresa);
		add(lblPol);
		add(cmbxPol);
		add(lblKorisnickoIme);
		add(txtKorisnickoIme);
		add(lblLozinka);
		add(txtLozinka);
		add(lblPlata);
		add(txtPlata);
		add(btnSave);
		add(btnCncl);

		
	}
	
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajAdmina.this.dispose();
				DialogDodajAdmina.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtIme.getText().equals("")||txtPrezime.getText().equals("")||txtJmbg.getText().equals("")||txtAdresa.getText().equals("")||txtKorisnickoIme.getText().equals("")||txtLozinka.getText().equals("")||txtPlata.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				if(biblioteka.validnostDouble(txtPlata.getText())==false) {
					JOptionPane.showMessageDialog(rootPane,"Platu morate uneti u formatu 0.00");
					return;
				}
				if(biblioteka.validnostKorisnickoIme(txtKorisnickoIme.getText().trim())==false) {
					JOptionPane.showMessageDialog(rootPane, "Vec postoji korisnik sa korisnickim imenom: "+ txtKorisnickoIme.getText());
					return;
				}
				if(!biblioteka.validnostJMBG(txtJmbg.getText().trim())) {
					JOptionPane.showMessageDialog(rootPane, "Uneti JMBG nije validan");
					return;
					
				}
				for(Zaposleni z: biblioteka.neobrisaniZaposleni()) {
					if(z.getKorisnickoIme().equals(txtKorisnickoIme.getText().trim())) {
						JOptionPane.showMessageDialog(rootPane, "Korisnik sa unetim korisnickim imenom vec postoji");
						return;
					}
				}
				for(Zaposleni z: biblioteka.neobrisaniZaposleni()) {
					if(z.getJMBG().equals(txtJmbg.getText().trim())) {
						JOptionPane.showMessageDialog(rootPane, "Uneti jmbg mora biti jedinstven");
						return;
					}
				}
				 Administratori admin = (Administratori) prijavljeniZaposleni;
				 admin.DodatiNoveAdmine(txtIme.getText().trim(), txtPrezime.getText().trim(), txtJmbg.getText().trim(), txtAdresa.getText().trim(), Pol.valueOf(cmbxPol.getSelectedItem().toString().trim()), txtKorisnickoIme.getText().trim(), txtLozinka.getText().trim(), Double.parseDouble(txtPlata.getText().trim()));
				 dispose();
				 AdministratoriProzor dp = new AdministratoriProzor(biblioteka, admin);
				 dp.setVisible(true);
			}
		});
	}
}

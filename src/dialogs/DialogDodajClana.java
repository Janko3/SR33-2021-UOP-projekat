package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

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
import models.TipClanarine;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.AktivniClanoviProzor;
import view.BibliotekariProzor;

public class DialogDodajClana extends JDialog{
	
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
	private JLabel lblDatum = new JLabel("Datum Poslednje Uplate");
	private JTextField txtDatum = new JTextField(10);
	private JLabel lblBrMeseci = new JLabel("Broj meseci");
	private JTextField txtBrMeseci = new JTextField(2);
	private JLabel lblTip = new JLabel("Tip Clanarine");
	private JComboBox<String> cmbxTip = new JComboBox<String>();
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	
	
	
	

	@SuppressWarnings("rawtypes")
	public DialogDodajClana(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Dodaj Novog Clana");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		cmbxPol.setModel(new DefaultComboBoxModel<Pol>(Pol.values()));
		String[] nazivi = new String[biblioteka.neobrisaniTipovi().size()];
		for(int i=0;i<biblioteka.neobrisaniTipovi().size();i++) {
			TipClanarine t= biblioteka.neobrisaniTipovi().get(i);
			nazivi[i] = t.getOpis(); 
		}
		cmbxTip.setModel(new DefaultComboBoxModel<String>(nazivi));
		
		initGUI();
		initActions();
		// TODO Auto-generated constructor stub
	}
	
	public void initGUI(){
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
		add(lblDatum);
		add(txtDatum);
		add(lblBrMeseci);
		add(txtBrMeseci);
		add(lblTip);
		add(cmbxTip);
		add(btnSave);
		add(btnCncl);
	}
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajClana.this.dispose();
				DialogDodajClana.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtIme.getText().equals("")||txtPrezime.getText().equals("")||txtJmbg.getText().equals("")||txtAdresa.getText().equals("")||txtBrMeseci.getText().equals("")||txtDatum.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				if(biblioteka.validnostInteger(txtBrMeseci.getText()) == false) {
					JOptionPane.showMessageDialog(rootPane,"Uneta vrednost mora biti broj");
					return;
				}
				if(biblioteka.validnostDatum(txtDatum.getText())== false) {
					JOptionPane.showMessageDialog(rootPane,"Datum morate uneti u formatu YY-MM-DD");
					return;
				}
				 prijavljeniZaposleni.DodatiNoveClanove(LocalDate.parse(txtDatum.getText().trim()), Integer.parseInt(txtBrMeseci.getText().trim()), txtIme.getText().trim(), txtPrezime.getText().trim(),txtJmbg.getText().trim(),txtAdresa.getText().trim(),Pol.valueOf(cmbxPol.getSelectedItem().toString()),biblioteka.neobrisaniTipovi().get(cmbxTip.getSelectedIndex()));
				 dispose();
				 AktivniClanoviProzor dp = new AktivniClanoviProzor(biblioteka, prijavljeniZaposleni);
				 dp.setVisible(true);
			}
		});
	}
	
}

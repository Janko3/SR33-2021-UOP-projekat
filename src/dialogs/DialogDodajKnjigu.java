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

import enumerations.Jezik;
import enumerations.Pol;
import models.Biblioteka;
import models.Zanr;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.KnjigeProzor;

public class DialogDodajKnjigu extends JDialog {
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	private JLabel lblNaslov = new JLabel("Naslov");
	private JTextField txtNaslov = new JTextField(40);
	private JLabel lblOrgNaslov = new JLabel("Originalni Naslov");
	private JTextField txtOrgNaslov = new JTextField(40);
	private JLabel lblPisac = new JLabel("Pisac");
	private JTextField txtPisac = new JTextField(40);
	private JLabel lblGodina = new JLabel("Godina Objavljivanja");
	private JTextField txtGodina = new JTextField(4);
	private JLabel lblOpis = new JLabel("Opis");
	private JTextField txtOpis = new JTextField(100);
	private JLabel lblZanr = new JLabel("Zanr");
	private JComboBox<String>cmbxZanr = new JComboBox<String>();
	private JLabel lblJezik = new JLabel("Jezik");
	private JComboBox<Jezik>cmbxJezik = new JComboBox<Jezik>();
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	

	public DialogDodajKnjigu(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Dodaj Novu Knjigu");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		cmbxJezik.setModel(new DefaultComboBoxModel<Jezik>(Jezik.values()));
		String[]nazivi = new String[biblioteka.neobrisaniZanrovi().size()];
		for(int i=0;i<biblioteka.neobrisaniZanrovi().size();i++) {
			Zanr z = biblioteka.neobrisaniZanrovi().get(i);
			nazivi[i] = z.getOpis();
		}
		cmbxZanr.setModel(new DefaultComboBoxModel<String>(nazivi));
		
		initGUI();
		initActions();
		// TODO Auto-generated constructor stub
	}
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblNaslov);
		add(txtNaslov);
		add(lblOrgNaslov);
		add(txtOrgNaslov);
		add(lblPisac);
		add(txtPisac);
		add(lblGodina);
		add(txtGodina);
		add(lblOpis);
		add(txtOpis);
		add(lblJezik);
		add(cmbxJezik);
		add(lblZanr);
		add(cmbxZanr);
		add(btnSave);
		add(btnCncl);
	}
	
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajKnjigu.this.dispose();
				DialogDodajKnjigu.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(txtGodina.getText().equals("")||txtNaslov.getText().equals("")||txtOpis.getText().equals("")||txtOrgNaslov.getText().equals("")||txtPisac.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				if(biblioteka.validnostDouble(txtGodina.getText())== false) {
					JOptionPane.showMessageDialog(rootPane, "Uneta vrednost mora biti broj");
				}
				prijavljeniZaposleni.DodajKnjigu(txtNaslov.getText().trim(), txtOrgNaslov.getText().trim(),txtPisac.getText().trim(), Integer.parseInt(txtGodina.getText().trim()), txtOpis.getText().trim(), biblioteka.neobrisaniZanrovi().get(cmbxZanr.getSelectedIndex()), Jezik.valueOf(cmbxJezik.getSelectedItem().toString()));
				dispose();
				KnjigeProzor kp = new KnjigeProzor(biblioteka,prijavljeniZaposleni);
				kp.setVisible(true);
				
			}
		});
	}

}

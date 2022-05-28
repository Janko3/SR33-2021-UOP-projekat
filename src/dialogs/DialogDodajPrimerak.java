package dialogs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enumerations.Jezik;
import enumerations.TipPoveza;
import models.Biblioteka;
import models.Knjiga;
import models.Primerak;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.KnjigeProzor;
import view.PrimerciProzor;

public class DialogDodajPrimerak extends JDialog {
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	private JLabel lblKnjiga = new JLabel("Knjiga");
	private JComboBox<String> cmbxKnjiga = new JComboBox<String>();
	private JLabel lblBrSrtana = new JLabel("Broj Strana");
	private JTextField txtBrStrana = new JTextField(4);
	private JLabel lblGodina = new JLabel("Godina Stampanja");
	private JTextField txtGodina = new JTextField(4);
	private JLabel lblJezik = new JLabel("Jezik");
	private JComboBox<Jezik> cmbxJezik = new JComboBox<Jezik>();
	private JLabel lblPovez = new JLabel("Tip Poveza");
	private JComboBox<TipPoveza>cmbxPovez = new JComboBox<TipPoveza>();
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	
	
	

	public DialogDodajPrimerak(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		
		setTitle("Dodaj Novi Primerak");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		cmbxJezik.setModel(new DefaultComboBoxModel<Jezik>(Jezik.values()));
		cmbxPovez.setModel(new DefaultComboBoxModel<TipPoveza>(TipPoveza.values()));
		String[]nazivi = new String[biblioteka.neobrisaneKnjige().size()];
		for(int i=0;i<biblioteka.neobrisaneKnjige().size();i++) {
			Knjiga k = biblioteka.neobrisaneKnjige().get(i);
			nazivi[i] = k.getNaslov();
		}
		cmbxKnjiga.setModel(new DefaultComboBoxModel<>(nazivi));
		
		initGUI();
		initActions();
		
		
		// TODO Auto-generated constructor stub
	}
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblKnjiga);
		add(cmbxKnjiga);
		add(lblBrSrtana);
		add(txtBrStrana);
		add(lblGodina);
		add(txtGodina);
		add(lblJezik);
		add(cmbxJezik);
		add(lblPovez);
		add(cmbxPovez);
		add(btnSave);
		add(btnCncl);
		
		
		
	}
	public void initActions() {
btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajPrimerak.this.dispose();
				DialogDodajPrimerak.this.setVisible(false);
				
			}
		});
btnSave.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		prijavljeniZaposleni.DodajPrimerak(biblioteka.neobrisaneKnjige().get(cmbxKnjiga.getSelectedIndex()),Integer.parseInt(txtBrStrana.getText().trim()), Integer.parseInt(txtGodina.getText().trim()), Jezik.valueOf(cmbxJezik.getSelectedItem().toString()), TipPoveza.valueOf(cmbxPovez.getSelectedItem().toString()));
		dispose();
		PrimerciProzor pp = new PrimerciProzor(biblioteka,prijavljeniZaposleni);
		pp.setVisible(true);
		// TODO Auto-generated method stub
		
	}
});
	}

}

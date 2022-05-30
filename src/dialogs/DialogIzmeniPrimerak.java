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
import enumerations.TipPoveza;
import models.Biblioteka;
import models.Knjiga;
import models.Primerak;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.PrimerciProzor;

public class DialogIzmeniPrimerak extends JDialog {
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	private int index;
	
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
	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(10);
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	

	public DialogIzmeniPrimerak(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		this.index = index;
		setTitle("Izmeni Primerak");
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
		add(lblId);
		add(txtId);
		add(btnSave);
		add(btnCncl);
		
		Primerak p = biblioteka.neobrisaniPrimerci().get(index);
		cmbxKnjiga.setSelectedItem(p.getKnjiga());
		txtBrStrana.setText(String.valueOf(p.getBrojStrana()));
		txtGodina.setText(String.valueOf(p.getGodinaStampanja()));
		cmbxJezik.setSelectedItem(p.getJezik());
		cmbxPovez.setSelectedItem(p.getPovez());
		txtId.setText(p.getId());
		txtId.setEditable(false);
		
		
		
		
	}
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogIzmeniPrimerak.this.dispose();
				DialogIzmeniPrimerak.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtBrStrana.getText().equals("")||txtGodina.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				prijavljeniZaposleni.updatePrimerak(biblioteka.neobrisaneKnjige().get(cmbxKnjiga.getSelectedIndex()),Integer.parseInt(txtBrStrana.getText().trim()), Integer.parseInt(txtGodina.getText().trim()),txtId.getText(), Jezik.valueOf(cmbxJezik.getSelectedItem().toString()), TipPoveza.valueOf(cmbxPovez.getSelectedItem().toString()));
				dispose();
				PrimerciProzor pp = new PrimerciProzor(biblioteka, prijavljeniZaposleni);
				pp.setVisible(true);
				
			}
		});
	}

}

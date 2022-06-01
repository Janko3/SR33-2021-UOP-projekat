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

import models.Biblioteka;
import models.Clan;
import models.Iznajmljivanje;
import models.Primerak;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.IznajmljivanjaProzor;

public class DialogIzmeniIznajmljivanje extends JDialog {
	private JLabel lblDatumIznajmljivanja = new JLabel("Datum Iznajmljivanja");
	private JTextField txtDatumIznajmljivanja = new JTextField(10);
	private JLabel lblVracanje = new JLabel("Datum Vracanja");
	private JTextField txtVracanje = new JTextField(10);
	private JLabel lblPrimerak = new JLabel("Primerak");
	private JComboBox<String> cmbxPrimerak  = new JComboBox<String>();
	private JLabel lblClan = new JLabel("Clan");
	private JComboBox<String>cmbxClan = new JComboBox<String>();
	private JLabel lblZaposleni = new JLabel("Zaposleni");
	private JComboBox<String>cmbxZaposleni = new JComboBox<String>();
	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(10);
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	private int index;

	
	public DialogIzmeniIznajmljivanje(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		this.index = index;
		setTitle("Iznajmi primerak");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		String[]naziviP = new String[biblioteka.neobrisaniPrimerci().size()];
		for(int i=0;i<biblioteka.neobrisaniPrimerci().size();i++) {
			Primerak p = biblioteka.neobrisaniPrimerci().get(i);
			naziviP[i] = p.getId();
		}
		cmbxPrimerak.setModel(new DefaultComboBoxModel<>(naziviP));
		
		String[] naziviC = new String[biblioteka.neobrisaniClanovi().size()];
		for(int i=0;i<biblioteka.neobrisaniClanovi().size();i++) {
			Clan c = biblioteka.neobrisaniClanovi().get(i);
			naziviC[i] = c.getBrClanskeKarte();
		}
		cmbxClan.setModel(new DefaultComboBoxModel<>(naziviC));
		
		String[]naziviZ = new String[biblioteka.neobrisaniZaposleni().size()];
		for(int i=0;i<biblioteka.neobrisaniZaposleni().size();i++) {
			Zaposleni z = biblioteka.neobrisaniZaposleni().get(i);
			naziviZ[i] = z.getId();
		}
		cmbxZaposleni.setModel(new DefaultComboBoxModel<>(naziviZ));
		
		initGUI();
		initActions();

	}
	public void initGUI() {
		MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
		setLayout(mig);
		
		add(lblDatumIznajmljivanja);
		add(txtDatumIznajmljivanja);
		add(lblVracanje);
		add(txtVracanje);
		add(lblPrimerak);
		add(cmbxPrimerak);
		add(lblClan);
		add(cmbxClan);
		add(lblZaposleni);
		add(cmbxZaposleni);
		add(lblId);
		add(txtId);
		add(btnSave);
		add(btnCncl);
		Iznajmljivanje i = biblioteka.neobrisanaIznajmljivanja().get(index);
		txtDatumIznajmljivanja.setText(i.getDatumIznajmljivanje().toString());
		txtVracanje.setText(i.getDatumVracanja().toString());
		cmbxPrimerak.setSelectedItem(i.getPrimerakKnjige());
		cmbxClan.setSelectedItem(i.getClan());
		cmbxZaposleni.setSelectedItem(i.getZaposleni());
		txtId.setText(i.getId());
		txtId.setEditable(false);
		
	}
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogIzmeniIznajmljivanje.this.dispose();
				DialogIzmeniIznajmljivanje.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtDatumIznajmljivanja.getText().equals("")||txtVracanje.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				if(biblioteka.validnostDatum(txtDatumIznajmljivanja.getText())== false || biblioteka.validnostDatum(txtVracanje.getText())== false) {
					JOptionPane.showMessageDialog(rootPane,"Datum morate uneti u formatu YY-MM-DD");
					return;
				}
				prijavljeniZaposleni.updateIznajmljivanje(LocalDate.parse(txtDatumIznajmljivanja.getText().trim()), LocalDate.parse(txtVracanje.getText().trim()), biblioteka.neobrisaniPrimerci().get(cmbxPrimerak.getSelectedIndex()), biblioteka.neobrisaniClanovi().get(cmbxClan.getSelectedIndex()), biblioteka.neobrisaniZaposleni().get(cmbxZaposleni.getSelectedIndex()), txtId.getText());
				dispose();
				IznajmljivanjaProzor ip = new IznajmljivanjaProzor(biblioteka, prijavljeniZaposleni);
				ip.setVisible(true);
			}
		});
}
}



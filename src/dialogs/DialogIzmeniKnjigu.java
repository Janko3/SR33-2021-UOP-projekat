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
import models.Biblioteka;
import models.Knjiga;
import models.Zanr;
import models.Zaposleni;
import net.miginfocom.swing.MigLayout;
import view.KnjigeProzor;

public class DialogIzmeniKnjigu extends JDialog {
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	private int index;
	
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
	private JLabel lblId = new JLabel("ID");
	private JTextField txtId = new JTextField(10);
	private JButton btnSave = new JButton("Sacuvaj");
	private JButton btnCncl = new JButton("Otkazi");

	public DialogIzmeniKnjigu(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni,int index) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		this.index = index;
		setTitle("Izmeni Knjigu");
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
		add(lblId);
		add(txtId);
		add(btnSave);
		add(btnCncl);
		
		Knjiga k = biblioteka.neobrisaneKnjige().get(index);
		txtNaslov.setText(k.getNaslov());
		txtOrgNaslov.setText(k.getOriginalniNaslov());
		txtPisac.setText(k.getPisac());
		txtGodina.setText(String.valueOf(k.getGodinaObjavljivanja()));
		txtOpis.setText(k.getOpis());
		cmbxJezik.setSelectedItem(k.getJezik());
		cmbxZanr.setSelectedItem(k.getZanr());
		txtId.setText(k.getId());
		txtId.setEditable(false);
	}
	
	public void initActions() {
		btnCncl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogIzmeniKnjigu.this.dispose();
				DialogIzmeniKnjigu.this.setVisible(false);
				
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtGodina.getText().equals("")||txtId.getText().equals("")||txtNaslov.getText().equals("")||txtOpis.getText().equals("")||txtOrgNaslov.getText().equals("")||txtPisac.getText().equals("")) {
					JOptionPane.showMessageDialog(rootPane,"Morate popuniti sva polja");
					return;
				}
				prijavljeniZaposleni.updateKnjiga(txtNaslov.getText().trim(), txtOrgNaslov.getText().trim(),txtPisac.getText().trim(), Integer.parseInt(txtGodina.getText().trim()), txtOpis.getText().trim(),txtId.getText(), biblioteka.neobrisaniZanrovi().get(cmbxZanr.getSelectedIndex()), Jezik.valueOf(cmbxJezik.getSelectedItem().toString()));
				dispose();
				KnjigeProzor kp = new KnjigeProzor(biblioteka, prijavljeniZaposleni);
				kp.setVisible(true);
				// TODO Auto-generated method stub
				
			}
		});
	}

}

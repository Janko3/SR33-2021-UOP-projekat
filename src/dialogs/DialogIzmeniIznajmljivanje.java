package dialogs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

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
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
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
		add(lblClan);
		add(cmbxClan);
		add(lblZaposleni);
		add(cmbxZaposleni);
		add(lblId);
		add(txtId);
		Iznajmljivanje iznajmljivanje = biblioteka.neobrisanaIznajmljivanja().get(index);
		String[] zaglavlja = new String[] {"Knjiga","Broj Strana","Godina stampanja","ID","Jezik","Tip poveza","Iznajmljena"};
		Object[][]sadrzaj = new Object[biblioteka.neiznajmljeniPrimerci().size()+iznajmljivanje.getPrimerakKnjige().size()][zaglavlja.length];
		
		for(int i=0;i<iznajmljivanje.getPrimerakKnjige().size();i++) {
			Primerak primerak = iznajmljivanje.getPrimerakKnjige().get(i);
			sadrzaj[i][0] = primerak.getKnjiga().getNaslov();
			sadrzaj[i][1] = primerak.getBrojStrana();
			sadrzaj[i][2] = primerak.getGodinaStampanja();
			sadrzaj[i][3] = primerak.getId();
			sadrzaj[i][4] = primerak.getJezik();
			sadrzaj[i][5] = primerak.getPovez();
			sadrzaj[i][6] = primerak.isIznamljena();
		}
		int n = iznajmljivanje.getPrimerakKnjige().size() ;
		for(int i=0;i<biblioteka.neiznajmljeniPrimerci().size();i++) {
			Primerak primerak = biblioteka.neiznajmljeniPrimerci().get(i);
			sadrzaj[n][0] = primerak.getKnjiga().getNaslov();
			sadrzaj[n][1] = primerak.getBrojStrana();
			sadrzaj[n][2] = primerak.getGodinaStampanja();
			sadrzaj[n][3] = primerak.getId();
			sadrzaj[n][4] = primerak.getJezik();
			sadrzaj[n][5] = primerak.getPovez();
			sadrzaj[n][6] = primerak.isIznamljena();
			n++;
		}
	
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		primerciTabela = new JTable(tableModel);
		
//		primerciTabela.setRowSelectionInterval(1, iznajmljivanje.getPrimerakKnjige().size()-1);
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		primerciTabela.setSize(getMinimumSize());
		primerciTabela.setRowSelectionInterval(0, iznajmljivanje.getPrimerakKnjige().size()-1);
		JScrollPane scrollPane = new JScrollPane(primerciTabela);
		
		add(scrollPane,BorderLayout.SOUTH);
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
				if(primerciTabela.getSelectedRows().length == 0) {
					JOptionPane.showMessageDialog(rootPane, "Morate izabrati bar jedan primerak");
					return;
					
				}
				
				ArrayList<Primerak> primerci = new ArrayList<Primerak>();
				int[] izabraniRedovi = primerciTabela.getSelectedRows();
				for(int i:izabraniRedovi) {
					primerci.add(biblioteka.nadjiPrimerak(primerciTabela.getValueAt(i, 3).toString()));
					System.out.println(primerci);
				}
				Iznajmljivanje iznajmljivanje = biblioteka.neobrisanaIznajmljivanja().get(index);
				for(Primerak p: iznajmljivanje.getPrimerakKnjige()) {
					p.setIznamljena(false);
					
				}
				for(Primerak p: primerci) {
					p.setIznamljena(true);
				}
				prijavljeniZaposleni.updateIznajmljivanje(LocalDate.parse(txtDatumIznajmljivanja.getText().trim()), LocalDate.parse(txtVracanje.getText().trim()), primerci, biblioteka.neobrisaniClanovi().get(cmbxClan.getSelectedIndex()), biblioteka.neobrisaniZaposleni().get(cmbxZaposleni.getSelectedIndex()), txtId.getText());
				dispose();
				IznajmljivanjaProzor ip = new IznajmljivanjaProzor(biblioteka, prijavljeniZaposleni);
				ip.setVisible(true);
			}
		});
}
}



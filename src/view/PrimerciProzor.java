package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dialogs.DialogDodajPrimerak;
import dialogs.DialogIzmeniPrimerak;
import models.Administratori;
import models.Biblioteka;
import models.Primerak;
import models.Zaposleni;

public class PrimerciProzor extends JFrame {
		
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable primerciTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	

	public PrimerciProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Primerci");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initView();
		initActions();
		// TODO Auto-generated constructor stub
	}
	
private void initView() {
		
		
		mainToolBar.add(addBtn);
		mainToolBar.add(editBtn);
		mainToolBar.add(deleteBtn);
		add(mainToolBar,BorderLayout.SOUTH);
		
		String[] zaglavlja = new String[] {"Knjiga","Broj Strana","Godina stampanja","ID","Jezik","Tip poveza","Iznajmljena"};
		Object[][]sadrzaj = new Object[biblioteka.neobrisaniPrimerci().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaniPrimerci().size();i++) {
			Primerak primerak = biblioteka.neobrisaniPrimerci().get(i);
			sadrzaj[i][0] = primerak.getKnjiga().getNaslov();
			sadrzaj[i][1] = primerak.getBrojStrana();
			sadrzaj[i][2] = primerak.getGodinaStampanja();
			sadrzaj[i][3] = primerak.getId();
			sadrzaj[i][4] = primerak.getJezik();
			sadrzaj[i][5] = primerak.getPovez();
			sadrzaj[i][6] = primerak.isIznamljena();
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		primerciTabela = new JTable(tableModel);
		
		primerciTabela.setRowSelectionAllowed(true);
		primerciTabela.setColumnSelectionAllowed(false);
		primerciTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		primerciTabela.setDefaultEditor(Object.class, null);
		primerciTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(primerciTabela);
		add(scrollPane,BorderLayout.CENTER);
}

private void initActions() {
	addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DialogDodajPrimerak dp = new DialogDodajPrimerak(biblioteka, prijavljeniZaposleni);
			dp.setVisible(true);
			dispose();
			// TODO Auto-generated method stub
			
		}
	});
	deleteBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(primerciTabela .getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Morate izabrati primerak za brisanje");
				return;
			}
			int a = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni?");
			if(a == JOptionPane.YES_OPTION) {
				
				prijavljeniZaposleni.obrisiPrimerak(primerciTabela.getModel().getValueAt(primerciTabela.getSelectedRow(),3).toString());
				
				dispose();
				PrimerciProzor pp = new PrimerciProzor(biblioteka, prijavljeniZaposleni);
				pp.setVisible(true);
			}
			// TODO Auto-generated method stub
			
		}
	});
	editBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(primerciTabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Morate izabrati primerak za izmenu");
				return;
			}
			DialogIzmeniPrimerak dp = new DialogIzmeniPrimerak(biblioteka, prijavljeniZaposleni, primerciTabela.getSelectedRow());
			dp.setVisible(true);
			dispose();
			// TODO Auto-generated method stub
			
		}
	});
}

}

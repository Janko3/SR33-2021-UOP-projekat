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

import dialogs.DialogDodajKnjigu;
import dialogs.DialogIzmeniKnjigu;
import models.Administratori;
import models.Biblioteka;
import models.Knjiga;
import models.Primerak;
import models.Zaposleni;

public class KnjigeProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable knjigeTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	

	public KnjigeProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Knjige");
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
		
		String[] zaglavlja = new String [] {"Naslov","Originalni naslov","Autor","Godina izdavanja","Opis","ID","Zanr","Jezik"};
		Object[][]sadrzaj = new Object[biblioteka.neobrisaneKnjige().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaneKnjige().size();i++) {
			Knjiga knjiga = biblioteka.neobrisaneKnjige().get(i);
			sadrzaj[i][0] = knjiga.getNaslov();
			sadrzaj[i][1] = knjiga.getOriginalniNaslov();
			sadrzaj[i][2] = knjiga.getPisac();
			sadrzaj[i][3] = knjiga.getGodinaObjavljivanja();
			sadrzaj[i][4] = knjiga.getOpis();
			sadrzaj[i][5] = knjiga.getId();
			sadrzaj[i][6] = knjiga.getZanr().getOpis();
			sadrzaj[i][7] = knjiga.getJezik();
			
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		knjigeTabela = new JTable(tableModel);
		
		knjigeTabela.setRowSelectionAllowed(true);
		knjigeTabela.setColumnSelectionAllowed(false);
		knjigeTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		knjigeTabela.setDefaultEditor(Object.class, null);
		knjigeTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(knjigeTabela);
		add(scrollPane,BorderLayout.CENTER);
		
}
private void initActions() {
	addBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			DialogDodajKnjigu dk = new DialogDodajKnjigu(biblioteka, prijavljeniZaposleni);
			dk.setVisible(true);
			dispose();
			// TODO Auto-generated method stub
			
		}
	});
	deleteBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(knjigeTabela .getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Morate izabrati knjigu za brisanje");
				return;
			}
			Knjiga knjiga = biblioteka.neobrisaneKnjige().get(knjigeTabela.getSelectedRow());
			for(Primerak p: biblioteka.neobrisaniPrimerci()) {
				if(p.getKnjiga().getId().equals(knjiga.getId())) {
					JOptionPane.showMessageDialog(rootPane, "Knjiga ne moze biti izbrisana");
					return;
				}
			}
			int a = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni?");
			if(a == JOptionPane.YES_OPTION) {
				
				prijavljeniZaposleni.obrisiKnjigu(knjigeTabela.getModel().getValueAt(knjigeTabela.getSelectedRow(),5).toString());
				dispose();
				KnjigeProzor kp = new KnjigeProzor(biblioteka, prijavljeniZaposleni);
				kp.setVisible(true);
			}
			// TODO Auto-generated method stub
			
		}
	});
	editBtn.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(knjigeTabela.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(rootPane, "Morate izabrati knjigu za izmenu");
				return;
			}
			DialogIzmeniKnjigu dk = new DialogIzmeniKnjigu(biblioteka, prijavljeniZaposleni, knjigeTabela.getSelectedRow());
			dk.setVisible(true);
			dispose();
			// TODO Auto-generated method stub
			
		}
	});
}

}

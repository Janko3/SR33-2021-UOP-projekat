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

import dialogs.DialogDodajClana;
import dialogs.DialogIzmeniClana;
import models.Administratori;
import models.Biblioteka;
import models.Clan;
import models.TipClanarine;
import models.Zaposleni;

public class AktivniClanoviProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable aktivniClanoviTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	

	public AktivniClanoviProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Aktivni Clanovi");
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
		
		String[]zaglavlja = new String[] {"Ime","Prezime","JMBG","Pol","Adresa","Broj Meseci","Datum Uplate","Broj Clanske Karte","Tip Clanarine"};
		Object[][] sadrzaj = new Object[biblioteka.aktivniClanovi().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.aktivniClanovi().size();i++) {
			Clan clan = biblioteka.aktivniClanovi().get(i);
			
			sadrzaj[i][0] = clan.getIme();
			sadrzaj[i][1] = clan.getPrezime();
			sadrzaj[i][2] = clan.getJMBG();
			sadrzaj[i][3] = clan.getPol();
			sadrzaj[i][4] = clan.getAdresa();
			sadrzaj[i][5] = clan.getBrojMeseci();
			sadrzaj[i][6]= clan.getDatumPoslednjeUplate();
			sadrzaj[i][7] = clan.getBrClanskeKarte();
			sadrzaj[i][8] = clan.getTipClanarine().getOpis();		
			
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		aktivniClanoviTabela = new JTable(tableModel);
		
		aktivniClanoviTabela.setRowSelectionAllowed(true);
		aktivniClanoviTabela.setColumnSelectionAllowed(false);
		aktivniClanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		aktivniClanoviTabela.setDefaultEditor(Object.class, null);
		aktivniClanoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(aktivniClanoviTabela);
		add(scrollPane,BorderLayout.CENTER);
		
	}
	
	public void initActions() {
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajClana dc = new DialogDodajClana(biblioteka, prijavljeniZaposleni);
				dc.setVisible(true);
				dispose();
				
			}
		});
deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(aktivniClanoviTabela .getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Morate izabrati clana za brisanje");
					return;
				}
				int a = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni?");
				if(a == JOptionPane.YES_OPTION) {
					
					prijavljeniZaposleni.obrisiClana(aktivniClanoviTabela.getModel().getValueAt(aktivniClanoviTabela.getSelectedRow(),7).toString());
					dispose();
					AktivniClanoviProzor ak = new AktivniClanoviProzor(biblioteka, prijavljeniZaposleni);
					ak.setVisible(true);
				}
				// TODO Auto-generated method stub
				
			}
		});
editBtn.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(aktivniClanoviTabela.getSelectedRow() == -1) {
			JOptionPane.showMessageDialog(rootPane, "Morate izabrati clana za izmenu");
			return;
		}
		DialogIzmeniClana dc = new DialogIzmeniClana(biblioteka, prijavljeniZaposleni, aktivniClanoviTabela.getSelectedRow());
		dc.setVisible(true);
		dispose();
		// TODO Auto-generated method stub
		
	}
});
	}

}

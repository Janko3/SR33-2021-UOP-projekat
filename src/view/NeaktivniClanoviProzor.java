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

import models.Biblioteka;
import models.Clan;
import models.Zaposleni;

public class NeaktivniClanoviProzor extends JFrame{
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	private JButton extendBtn = new JButton("extend");
	private DefaultTableModel tableModel;
	private JTable neaktivniClanoviTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;

	public NeaktivniClanoviProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Neaktivni Clanovi");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initView();
		initActions();
		// TODO Auto-generated constructor stub
	}
	
	private void initView() {
		mainToolBar.add(extendBtn);
		add(mainToolBar,BorderLayout.SOUTH);
		
		String[]zaglavlja = new String[] {"Ime","Prezime","JMBG","Pol","Adresa","Broj Meseci","Datum Uplate","ID","Tip Clanarine"};
		Object[][] sadrzaj = new Object[biblioteka.neaktivniClanovi().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neaktivniClanovi().size();i++) {
			Clan clan = biblioteka.neaktivniClanovi().get(i);
			
			sadrzaj[i][0] = clan.getIme();
			sadrzaj[i][1] = clan.getPrezime();
			sadrzaj[i][2] = clan.getJMBG();
			sadrzaj[i][3] = clan.getPol();
			sadrzaj[i][4] = clan.getAdresa();
			sadrzaj[i][5] = clan.getBrojMeseci();
			sadrzaj[i][6]= clan.getDatumPoslednjeUplate();
			sadrzaj[i][7] = clan.getBrClanskeKarte();
			sadrzaj[i][8] = clan.getTipClanarine();		
			
		}
		
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		 neaktivniClanoviTabela = new JTable(tableModel);
		
		 neaktivniClanoviTabela.setRowSelectionAllowed(true);
		 neaktivniClanoviTabela.setColumnSelectionAllowed(false);
		 neaktivniClanoviTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 neaktivniClanoviTabela.setDefaultEditor(Object.class, null);
		 neaktivniClanoviTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane( neaktivniClanoviTabela);
		add(scrollPane,BorderLayout.CENTER);
		
	}
	private void initActions() {
		extendBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(neaktivniClanoviTabela.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Morate izabrati clana kojeg zelite da vratite");
					return;
				}
				int a = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni?");
				if(a == JOptionPane.YES_OPTION) {
					prijavljeniZaposleni.vratiClana(neaktivniClanoviTabela.getModel().getValueAt(neaktivniClanoviTabela.getSelectedRow(), 7).toString());
					dispose();
					NeaktivniClanoviProzor np = new NeaktivniClanoviProzor(biblioteka, prijavljeniZaposleni);
					np.setVisible(true);
				}
				
			}
		});
	}

}

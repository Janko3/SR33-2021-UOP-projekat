package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import dialogs.DialogDodajAdmina;
import dialogs.DialogIzmeniAdmina;
import models.Administratori;
import models.Biblioteka;
import models.Zaposleni;

public class AdministratoriProzor extends JFrame {
	
	private JToolBar mainToolBar = new JToolBar();
	private JButton addBtn = new JButton("add");
	private JButton editBtn = new JButton("update");
	private JButton deleteBtn = new JButton("delete");
	
	private DefaultTableModel tableModel;
	private JTable adminiTabela;
	
	private Biblioteka biblioteka;
	private Zaposleni prijavljeniZaposleni;
	
	

	public AdministratoriProzor(Biblioteka biblioteka,Zaposleni prijavljeniZaposleni) {
		this.biblioteka = biblioteka;
		this.prijavljeniZaposleni = prijavljeniZaposleni;
		setTitle("Administratori");
		setSize(500,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		initView();
		initActions();

	}
	private void initView() {
		
		
		mainToolBar.add(addBtn);
		mainToolBar.add(editBtn);
		mainToolBar.add(deleteBtn);
		add(mainToolBar,BorderLayout.SOUTH);
		
		String[] zaglavlja = new String[] {"Ime","Prezime","JMBG","Adresa","Pol","Korisnicko ime","Lozinka","Plata","ID"};
		Object[][] sadrzaj = new Object[biblioteka.neobrisaniAdmini().size()][zaglavlja.length];
		
		for(int i=0;i<biblioteka.neobrisaniAdmini().size();i++) {
			Administratori admin = biblioteka.neobrisaniAdmini().get(i);
			sadrzaj[i][0] = admin.getIme();
			sadrzaj[i][1] = admin.getPrezime();
			sadrzaj[i][2]= admin.getJMBG();
			sadrzaj[i][3] = admin.getAdresa();
			sadrzaj[i][4] = admin.getPol();
			sadrzaj[i][5] = admin.getKorisnickoIme();
			sadrzaj[i][6] = admin.getLozinka();
			sadrzaj[i][7] = admin.getPlata();
			sadrzaj[i][8] = admin.getId();
			
		}
		tableModel = new DefaultTableModel(sadrzaj,zaglavlja);
		adminiTabela = new JTable(tableModel);
		
		adminiTabela.setRowSelectionAllowed(true);
		adminiTabela.setColumnSelectionAllowed(false);
		adminiTabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		adminiTabela.setDefaultEditor(Object.class, null);
		adminiTabela.getTableHeader().setReorderingAllowed(false);
		
		JScrollPane scrollPane = new JScrollPane(adminiTabela);
		add(scrollPane,BorderLayout.CENTER);
	}
	
	private void initActions() {
		addBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDodajAdmina da = new DialogDodajAdmina(biblioteka, prijavljeniZaposleni);
				da.setVisible(true);
				dispose();
				
			}
		});
		deleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(adminiTabela.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Morate izabrati admina za brisanje");
					return;
				}
				int a = JOptionPane.showConfirmDialog(rootPane, "Da li ste sigurni?");
				if(a == JOptionPane.YES_OPTION) {
					Administratori admin = (Administratori)prijavljeniZaposleni;
					admin.obrisiAdmina(adminiTabela.getModel().getValueAt(adminiTabela.getSelectedRow(),8).toString());
					dispose();
					AdministratoriProzor ap = new AdministratoriProzor(biblioteka, admin);
					ap.setVisible(true);
				}
				// TODO Auto-generated method stub
				
			}
		});
		editBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(adminiTabela.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(rootPane, "Morate izabrati admina za izmenu");
					return;
				}
				DialogIzmeniAdmina da = new DialogIzmeniAdmina(biblioteka, prijavljeniZaposleni,adminiTabela.getSelectedRow());
				da.setVisible(true);
				dispose();
				// TODO Auto-generated method stub
				
			}
		});
	}

}
